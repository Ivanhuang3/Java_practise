package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
//1. 套件與匯入:
//功能：定義程式所在的套件並匯入必要的類別，為後續功能提供支援。
//詳細解釋：
//package tw.brad.tutor;：
//將程式碼組織在 tw.brad.tutor 套件下，方便模組化管理。
//這是 Java 的命名空間機制，確保類別名稱不會與其他套件中的類別衝突。
//JDBC 相關匯入：
//java.sql.Connection：表示與資料庫的連線，用於管理資料庫會話。
//java.sql.DriverManager：
//用於建立資料庫連線，透過指定的 URL 和認證資訊連接到 MySQL 資料庫。
//java.sql.PreparedStatement：
//預編譯的 SQL 語句物件，支援參數化查詢，防止 SQL 注入並提高執行效率。
//java.sql.ResultSet：查詢結果的資料結構，用於儲存和操作從資料庫返回的資料。
//java.sql.SQLException：JDBC 操作中可能拋出的異常，用於錯誤處理。
//java.sql.Statement：未使用，但匯入可能是為了備用（例如執行靜態 SQL 語句）。
public class JDBC12 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String LOGIN = 
			"SELECT * FROM member WHERE account = ?";
//功能：定義 JDBC12 類別，設定資料庫連線的靜態常數、連線物件，以及用於登入的 SQL 查詢語句。
//詳細解釋：
//public class JDBC12：
//定義一個公開的類別，作為程式的入口點。
//名稱 JDBC12 可能表示這是某系列教學或練習的一部分
//（例如第 12 個 JDBC 範例，可能與之前的 JDBC11 相關）。
//private static final String URL = "jdbc:mysql://localhost/brad";：
//定義資料庫連線的 URL，格式為 jdbc:mysql://<主機>:<埠>/<資料庫名稱>。
//localhost 表示 MySQL 伺服器運行在本機，brad 是目標資料庫名稱。
//未指定埠（預設為 3306），也未附加額外參數（如 ?useSSL=false 或 ?serverTimezone=UTC），
//可能需要根據 MySQL 配置調整（例如 MySQL 8.0+ 需要時區設定）。
//private static final String USER = "root";：
//定義資料庫的登入帳號，使用 MySQL 的預設管理員帳號 root。
//硬編碼帳號（特別是 root）在正式環境中不安全，應使用專用帳號並從配置文件或環境變數讀取。
//private static final String PASSWD = "root";：
//定義資料庫的登入密碼，與 USER 對應。
//硬編碼密碼同樣有安全風險，應改用安全的儲存方式（例如環境變數或加密配置文件）。
//private static Connection conn;：
//宣告一個靜態的 Connection 物件，用於儲存資料庫連線。
//使用 static 表示連線是類別層級的，供所有方法共用。
//初始化，會在 main 方法中透過 DriverManager.getConnection 賦值。
//private static final String LOGIN = "SELECT * FROM member WHERE account = ?";：
//定義用於登入的 SQL 查詢語句，儲存為常數。
//查詢從 member 表中選取所有欄位（*），條件是 account 欄位等於指定的值。
//使用參數佔位符 ? 表示這是一個參數化查詢，實際值會在執行時透過 PreparedStatement 動態綁定。
//假設：member 表存在，且包含 account、passwd（儲存 BCrypt 加密的密碼）和 cname 欄位。
//account 欄位通常為唯一鍵（例如主鍵或唯一索引）。
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.print("Account:");
		String account = scaner.next();
		System.out.println("Password:");
		String passwd = scaner.next();
		System.out.println("-----");
//Scanner scaner = new Scanner(System.in);：創建 Scanner 物件，從標準輸入（鍵盤）讀取資料。
//System.out.print("Account:");：
//提示使用者輸入帳號，scaner.next() 讀取下一個非空白字串（以空白或換行符分隔）。
//同樣方式收集密碼（passwd）。
//System.out.println("-----");：輸出分隔線，增強命令列界面的可讀性。
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
//Properties prop = new Properties();：創建 Properties 物件，用於儲存連線參數。
//prop.put("user", USER); 和 prop.put("password", PASSWD);：
//將帳號（root）和密碼（root）加入屬性。
//優勢：使用 Properties 允許靈活添加其他連線參數（例如 useSSL、serverTimezone）。
//替代方案：可以直接在 DriverManager.getConnection(URL, USER, PASSWD) 
//中傳遞帳號和密碼，但 Properties 更具擴展性。
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(LOGIN);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
//DriverManager.getConnection(URL, prop)：
//根據指定的 URL 和屬性建立資料庫連線，將結果賦值給 conn。
//conn.prepareStatement(LOGIN)：
//創建 PreparedStatement 物件，預編譯登入查詢語句（SELECT * FROM member WHERE account = ?）。
//pstmt.setString(1, account);：將輸入的 account 值綁定到第一個參數（?），確保安全（防止 SQL 注入）。
//pstmt.executeQuery()：執行查詢，返回結果集（ResultSet）。
			if (rs.next()) {
				String hashPasswd = rs.getString("Passwd");
				if (BCrypt.checkpw(passwd, hashPasswd)) {
					System.out.printf("Welcome, %s", rs.getString("cname"));
				}else {
					System.out.println("Login Failure(2)");
				}
			}else {
					System.out.println("Login Failure(1)");
			}
//rs.next()：將結果集的游標移動到第一行。如果有結果（rs.next() 為 true），表示帳號存在。
//帳號存在的情況：
//rs.getString("passwd")：取得 passwd 欄位的值（BCrypt 加密的密碼）。
//BCrypt.checkpw(passwd, hashPasswd)：
//比較使用者輸入的明文密碼（、passwd）與資料庫中的加密密碼（hashPasswd）。BCrypt 會自動處理鹽值並驗證匹配。
//如果密碼匹配，輸出歡迎訊息，包含使用者的名稱（rs.getString("cname")）。
//如果密碼不匹配，輸出 "Login Failure(2)"，表示密碼錯誤。
//帳號不存在的情況：
//如果 rs.next() 為 false，表示沒有符合條件的記錄，輸出 "Login Failure(1)"，表示帳號不存在。
//假設：
//passwd 欄位儲存有效的 BCrypt 雜湊值（通常為 60 字元）。
//cname 欄位存在且為字串型別（例如 VARCHAR）。
			
		}catch(Exception e) {
			System.out.println(e);
//捕捉所有異常（Exception），包括 SQLException（資料庫錯誤）和其他潛在錯誤（例如 BCrypt 相關異常）。
//僅輸出異常訊息，未記錄詳細日誌或採取恢復措施。
//
//設計考量：
//程式結構簡單，適合教學或原型開發，實現基本的登入功能。
//使用 PreparedStatement 防止 SQL 注入，顯示對安全性的關注。
//密碼驗證使用 BCrypt，符合現代密碼安全標準。
//異常處理過於簡化，僅輸出錯誤訊息，缺乏詳細診斷。
//輸入處理使用 next()，可能無法處理包含空格的輸入。
//作用：實現登入的核心邏輯，從收集輸入到資料庫查詢和密碼驗證，確保安全性和正確性。
		}
	}
}
