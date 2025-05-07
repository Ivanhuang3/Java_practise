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
//java.util.Scanner：從鍵盤讀取使用者輸入。
public class JDBC07 {
	private static final String URL ="jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL =
			"UPDATE cust SET cname = ?, tel = ? WHERE id = ?";
//功用：
//public class JDBC07：定義一個名為 JDBC07 的公開類別，作為程式的主要容器。
//常數宣告：
//URL：定義資料庫連線位址，jdbc:mysql://localhost/brad 表示連接到本機 MySQL 伺服器的 brad 資料庫。
//USER：定義資料庫使用者名稱，設為 root。
//PASSWD：定義資料庫密碼，設為 root。
//SQL：定義一個 SQL 更新語句，用於更新 cust 表中的 cname（姓名）和 tel（電話）欄位，根據條件 WHERE ld = ? 來定位記錄。
//使用 private static final 確保這些值不可修改且僅在類別內部使用。
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("ID: ");
		int id = scanner.nextInt();
		System.out.print("Name: ");
		String name = scanner.next();
		System.out.print("Tel: ");
		String tel = scanner.next();
//功用：
//public static void main(String[] args)：程式的入口點，程式執行時從這裡開始。
//使用者輸入：
//Scanner scanner = new Scanner(System.in);：創建一個 Scanner 物件，從鍵盤讀取使用者輸入。
//System.out.print(...)：提示使用者輸入三項資料：
//ID：記錄的唯一識別碼，預期為整數（int）。
//Name：要更新的姓名。
//Tel：要更新的電話號碼。
//scanner.nextInt()：讀取整數類型的 id。
//scanner.next()：讀取字串類型的 name 和 tel。
//這些輸入資料將用於後續的資料庫更新操作。
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setInt(3, id);
			if (pstmt.executeUpdate() > 0) {
				System.out.println("Success");
			}else {
				System.out.println("Failute" + SQL);
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
//創建 PreparedStatement 物件，預編譯 SQL 更新語句，防止 SQL 注入並提高效率。
//pstmt.setString(1, name);、pstmt.setString(2, tel);：設置要更新的 cname 和 tel 欄位的值。
//pstmt.setInt(3, id);：設置 WHERE 條件中的 id 值，用於定位要更新的記錄。
//pstmt.executeUpdate()：執行更新操作，返回受影響的行數。
//結果處理：
//如果 executeUpdate() 返回值大於 0，表示至少更新了一行記錄，輸出 Success。
//否則，輸出 Failure: 並附上 SQL 語句，幫助診斷問題（例如指定的 id 不存在）。
//最後輸出 Finish，表示程式執行完成。
//異常處理：
//try-catch 塊捕獲可能的異常（例如連線失敗、資料庫表不存在、SQL 語句錯誤、輸入格式錯誤等）。
//如果發生異常，輸出異常訊息（e），幫助開發者排查問題。
//			
//JDBC06：要求使用者輸入三項資料：Name（姓名）、Tel（電話）、Birthday（生日），皆為字串型態。
//JDBC07：要求使用者輸入三項資料：ID（識別碼，整數型態）、Name（姓名）、Tel（電話）。ID 用於定位要更新的記錄。			
		}
	}
}
