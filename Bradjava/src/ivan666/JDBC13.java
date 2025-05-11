package ivan666;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
//java.io.FileInputStream：用於從檔案系統讀取二進位資料，這裡用來讀取 PNG 圖片檔案
//java.sql.Connection：表示與資料庫的連線，用於管理資料庫會話。
//java.sql.DriverManager：用於建立資料庫連線，
//透過指定的 URL 和認證資訊連接到 MySQL 資料庫。
//java.sql.PreparedStatement：預編譯的 SQL 語句物件，
//支援參數化查詢，防止 SQL 注入並處理二進位資料（例如 BLOB）。
//java.sql.ResultSet：查詢結果的資料結構，
//雖然程式未使用，但匯入可能是為了備用。
//java.sql.SQLException：JDBC 操作中可能拋出的異常，用於錯誤處理。
//java.sql.Statement：未使用，但匯入可能是為了備用（例如執行靜態 SQL）。
public class JDBC13 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String UPDATE_SQL = 
		"UPDATE member SET icon = ? WHERE id = ?";
//定義一個公開的類別，作為程式的入口點。
//private static final String URL = "jdbc:mysql://localhost/brad";：
//定義資料庫連線的 URL，格式為 jdbc:mysql://<主機>:<埠>/<資料庫名稱>。
//localhost 表示 MySQL 伺服器運行在本機，
//brad 是目標資料庫名稱，與之前的程式（JDBC11, JDBC12）一致。
//未指定埠（預設為 3306），也未附加額外參數（如 ?useSSL=false 
//或 ?serverTimezone=UTC），可能需要根據 MySQL 配置調整（例如 MySQL 8.0+ 需要時區設定）。
//private static final String USER = "root";：
//定義資料庫的登入帳號，使用 MySQL 的預設管理員帳號 root。
//硬編碼帳號（特別是 root）在正式環境中不安全，應使用專用帳號並從配置文件或環境變數讀取。
//private static final String PASSWD = "root";：
//定義資料庫的登入密碼，與 USER 對應。
//硬編碼密碼同樣有安全風險，應改用安全的儲存方式（例如環境變數或加密配置文件）。
//private static Connection conn;：
//宣告一個靜態的 Connection 物件，用於儲存資料庫連線。
//使用 static 表示連線是類別層級的，供所有方法共用。
//未初始化，會在 main 方法中透過 DriverManager.getConnection 賦值。
//private static final String UPDATE_SQL = "UPDATE member SET icon = ? WHERE id = ?";：
//定義用於更新資料的 SQL 語句，儲存為常數。
//這是一個 UPDATE 語句，更新 member 表的 icon 欄位，條件是 id 欄位等於指定的值。
//使用兩個參數佔位符 ?：
//第一個 ? 表示 icon 欄位的值（預期為二進位資料，例如 BLOB）。
//第二個 ? 表示 id 欄位的值（預期為整數）。
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
//1.設置資料庫連線屬性：
//Properties prop = new Properties();：創建 Properties 物件，用於儲存連線參數。
//prop.put("user", USER); 和 
//prop.put("password", PASSWD);：將帳號（root）和密碼（root）加入屬性。
//優勢：使用 Properties 允許靈活添加其他連線參數（例如 useSSL, serverTimezone）。
//替代方案：可以直接在 DriverManager.getConnection(URL, USER, PASSWD) 中傳遞帳
//號和密碼，但 Properties 更具擴展性。
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(UPDATE_SQL);
//2.建立資料庫連線並準備 SQL：
//DriverManager.getConnection(URL, prop)：
//根據指定的 URL 和屬性建立資料庫連線，將結果賦值給 conn。
//conn.prepareStatement(UPDATE_SQL)：
//創建 PreparedStatement 物件，預編譯更新語句（UPDATE member SET icon = ? WHERE id = ?）。
			FileInputStream fin = new FileInputStream("dir2/ball.png");
//3.讀取圖片檔案：
//FileInputStream fin = new FileInputStream("dir2/10.0.104.183.png");：
//開啟名為 10.0.104.183.png 的檔案（位於 dir2 目錄下），作為輸入流。
			pstmt.setBinaryStream(1, fin);
			pstmt.setInt(2,4);
			if (pstmt.executeUpdate()>0 ) {
				System.out.println("Success");
			}else {
				System.out.println("Failure");
			}
//4.設置 SQL 參數並執行更新：
//pstmt.setBinaryStream(1, fin);：
//將第一個參數（icon 欄位）綁定為二進位輸入流（fin），將圖片資料作為 BLOB 傳遞。
//pstmt.setInt(2, 4);：將第二個參數（id 欄位）綁定為整數值 4，表示更新 id = 4 的記錄。
//pstmt.executeUpdate()：執行更新操作，返回影響的行數（通常為 0 或 1）。
//條件判斷：
//如果 executeUpdate() > 0，表示至少更新了一行，輸出 "Success"。
//如果返回 0，表示沒有記錄被更新（例如 id = 4 的記錄不存在），輸出 "Failure"。
			
			fin.close();
//5.關閉檔案流：
//顯式關閉 FileInputStream，釋放檔案資源。
//注意：這是良好的實踐，但如果程式在 fin.close() 之前拋出異常（例如 SQLException），
//fin 可能未被關閉。
		}catch(Exception e ) {
			System.out.println(e);
//6.異常處理：
//捕捉所有異常（Exception），包括 SQLException（資料庫錯誤）、
//FileNotFoundException（檔案不存在）、和 IOException（檔案讀取錯誤）。
//僅輸出異常訊息，未記錄詳細日誌或採取恢復措施。
//
//結論
//JDBC13.java 實現了一個將圖片檔案作為 BLOB 資料更新到資料庫的功能，
//展示 JDBC 處理二進位資料的能力。
		}
	}
}
