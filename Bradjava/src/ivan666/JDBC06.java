package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;
//java.sql.Connection：表示與資料庫的連線。
//java.sql.DriverManager：管理 JDBC 驅動程式並建立資料庫連線。
//java.sql.PreparedStatement：用於執行預編譯的 SQL 語句（帶參數），提高安全性和效率。
//java.util.Properties：儲存資料庫連線的屬性（如使用者名稱和密碼）。
//java.util.Scanner：用於從使用者輸入（鍵盤）獲取資料。

public class JDBC06 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWD ="root";
	private static final String SQL = "INSERT INTO cust (cname,tel,birthday)" +
										"VALUES (?,?,?) ";
//功用：
//public class JDBC06：定義一個名為 JDBC06 的公開類別，作為程式的主要容器。
//常數宣告：
//URL：定義資料庫連線位址，jdbc:mysql://localhost/brad 表示連接到本機 MySQL 伺服器的 brad 資料庫。
//USER：定義資料庫使用者名稱，設為 root。
//PASSWD：定義資料庫密碼，設為 root。
//SQL：定義一個 SQL 插入語句，用於將資料插入 cust 表，包含三個欄位（cname, tel, birthday），使用 ? 
//作為佔位符，表示參數將由 PreparedStatement 動態設置。
//使用 private static final 確保這些值不可修改且僅在類別內部使用。
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.print("Tel: ");
		String tel = scanner.next();
		System.out.print("Birthday: ");
		String birthday = scanner.next();
//使用者輸入：
//Scanner scanner = new Scanner(System.in);：創建一個 Scanner 物件，從鍵盤讀取使用者輸入。
//System.out.print(...)：提示使用者輸入三項資料：姓名（Name）、電話（Tel）和生日（Birthday）。
//scanner.next()：讀取使用者輸入的字串，分別儲存到變數 name、tel 和 birthday 中。
//這些輸入資料將用於後續的資料庫插入操作。
		
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, birthday);
			
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Success");
			}else {
				System.out.println("Failure + SQL");
			}
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e);
//功用：
//連線設定：
//Properties prop = new Properties();：創建 Properties 物件，儲存連線屬性。
//prop.put("user", USER); 和 prop.put("password", PASSWD);：設置使用者名稱和密碼。
//資料庫連線與 SQL 執行：
//Connection conn = DriverManager.getConnection(URL, prop);：建立與 MySQL 資料庫的連線。
//PreparedStatement pstmt = conn.prepareStatement(SQL);：
//創建 PreparedStatement 物件，預編譯 SQL 插入語句，防止 SQL 注入並提高執行效率。
//pstmt.setString(1, name);、pstmt.setString(2, tel);、pstmt.setString(3, birthday);：
//將使用者輸入的 name、tel 和 birthday 設置為 SQL 語句中的三個參數。
//pstmt.executeUpdate()：執行插入操作，返回受影響的行數。
//結果處理：
//如果 executeUpdate() 返回值大於 0，表示插入成功，輸出 Success。
//否則，輸出 Failure: 並附上 SQL 語句，幫助診斷問題。
//無論成功或失敗，最後輸出 Finish，表示程式執行完成。
//異常處理：
//try-catch 塊捕獲可能的異常（例如連線失敗、資料庫表不存在、輸入格式錯誤等）。
//如果發生異常，輸出異常訊息（e），幫助開發者排查問題。
//
//總結
//每個段落的功用可以概括如下：
//套件與匯入：組織程式碼並引入資料庫操作和使用者輸入所需的類別。
//註解：提供背景資訊，指向農業資料 API，暗示程式可能與農業資料處理相關。
//類別與常數：定義程式容器並設定資料庫連線參數和 SQL 插入語句。
//主程式與輸入：從使用者獲取姓名、電話和生日資料，準備插入資料庫。
//資料庫連線與插入：連接到資料庫，執行插入操作，根據結果輸出成功或失敗訊息，並處理異常。
//程式整體功能：這段程式碼允許使用者輸入姓名、電話和生日，然後將這些資料插入 MySQL 資料庫的 cust 表中，
//測試資料庫插入操作是否成功。雖然註解提到農業資料 API，
//但當前程式碼僅實現簡單的資料插入功能，可能是為後續整合 API 資料做準備。
		}
	}
}
