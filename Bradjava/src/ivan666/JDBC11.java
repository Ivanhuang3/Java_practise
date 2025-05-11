package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
//1.套件與匯入
//功能：定義程式所在的套件並匯入必要的類別，為後續功能提供支援。
//詳細解釋：
//package tw.brad.tutor;：
//將程式碼組織在 tw.brad.tutor 套件下，方便模組化管理。
//這是 Java 的命名空間機制，確保類別名稱不會與其他套件中的類別衝突。
//JDBC 相關匯入：
//java.sql.Connection：表示與資料庫的連線，用於管理資料庫會話。
//java.sql.DriverManager：用於建立資料庫連線，透過指定的 URL 和認證資訊連接到資料庫。
//java.sql.PreparedStatement：預編譯的 SQL 語句物件，支援參數化查詢，防止 SQL 注入並提高效率。
//java.sql.ResultSet：查詢結果的資料結構，用於存儲和操作從資料庫返回的資料。
//java.sql.SQLException：JDBC 操作中可能拋出的異常，用於錯誤處理。
//java.sql.Statement：未使用，但匯入可能是為了備用（例如執行靜態 SQL）。
//java.util.Properties：
//用於儲存鍵值對，這裡用來設定資料庫連線的帳號和密碼。
//比直接在 DriverManager.getConnection 中傳遞參數更靈活，支援更多連線屬性（例如編碼、時區）。
//java.util.Scanner：
//用於從標準輸入（鍵盤）讀取使用者輸入的帳號、密碼和名稱。
//簡單易用，適合命令列應用程式。
//tw.brad.apis.BCrypt：
//自定義的 BCrypt 類別（假設來自外部庫或專案中的模組），用於密碼加密。
//BCrypt 是一種安全的單向雜湊演算法，廣泛用於密碼儲存，支援鹽值（salt）以防止彩虹表攻擊。
//設計考量：
//匯入的類別專注於資料庫操作（JDBC）、使用者輸入（Scanner）和密碼安全（BCrypt），顯示程式的主要功能是與資料庫互動並處理帳號註冊。
//未匯入日誌框架（如 SLF4J 或 Log4J），錯誤訊息直接輸出到控制台，可能在正式應用中需要改進。
//作用：為程式提供必要的工具，確保後續的資料庫連線、查詢執行、密碼加密和輸入處理能夠順利進行。
public class JDBC11 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
//2. 類別與常數定義
//功能：定義 JDBC11 類別並設定資料庫連線的靜態常數和變數。
//詳細解釋：
//public class JDBC11：
//定義一個公開的類別，作為程式的入口點。
//private static final String URL = "jdbc:mysql://localhost/brad";：
//定義資料庫連線的 URL，格式為 jdbc:mysql://<主機>:<埠>/<資料庫名稱>。
//localhost 表示 MySQL 伺服器運行在本機，brad 是目標資料庫名稱。
//未指定埠（預設為 3306），也未附加額外參數（如 ?useSSL=false 或 ?serverTimezone=UTC），可能需要根據 MySQL 配置調整。
//private static final String USER = "root";：
//定義資料庫的登入帳號，這裡使用 MySQL 的預設管理員帳號 root。
//在正式環境中，硬編碼帳號（特別是 root）是不安全的，應使用專用帳號並從配置文件或環境變數讀取。
//private static final String PASSWD = "root";：
//定義資料庫的登入密碼，與 USER 對應。
//硬編碼密碼同樣有安全風險，應改用安全的儲存方式（例如環境變數或加密配置文件）。
//private static Connection conn;：宣告一個靜態的 Connection 物件，用於儲存資料庫連線。
//使用 static 表示連線是類別層級的，所有方法共用同一個連線。
//未初始化，會在 main 方法中透過 DriverManager.getConnection 賦值。
//設計考量：使用 static final 定義常數是良好的實踐，確保連線資訊不可變且易於維護。
//Connection 物件未設置為 final，允許在程式執行期間重新賦值（例如重新連線），但未關閉連線（conn.close()）可能導致資源洩漏。
//未使用連線池（例如 HikariCP 或 Apache DBCP），對於簡單程式可接受，但在高併發應用中應考慮連線池以提高效能。
//作用：提供資料庫連線的基礎配置，並為後續的 JDBC 操作準備一個共用的 Connection 物件。
	public static void main(String[] args) {
		Scanner scaner =new Scanner(System.in);
		System.out.println("Account:");
		String account = scaner.next();
		System.out.print("Password:");
		String passwd =scaner.next();
		System.out.print("Name:");
		String cname =scaner.next();
		System.out.println("-----");
//初始化 Scanner 並收集輸入：		
//Scanner scaner = new Scanner(System.in);：創建 Scanner 物件，從標準輸入（鍵盤）讀取資料。
//System.out.print("Account:");：提示使用者輸入帳號，scaner.next() 讀取下一個非空白字串（以空白或換行符分隔）。
//同樣方式收集密碼（passwd）和名稱（cname）。
//System.out.println("-----");：輸出分隔線，增強命令列界面的可讀性。
//注意：scaner 的拼寫應為 scanner，目前是拼寫錯誤，但不影響執行。
//使用 next() 只讀取單詞，若輸入包含空格（例如名稱為 "John Doe"），只會讀取 "John"。應考慮使用 nextLine()。
//未關閉 Scanner（scaner.close()），在簡單程式中影響不大，但在長期運行的應用中可能導致資源洩漏。
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
//2.設置資料庫連線屬性：
//Properties prop = new Properties();：
//創建 Properties 物件，用於儲存連線參數。
//prop.put("user", USER); 和 prop.put("password", PASSWD);：
//將帳號（root）和密碼（root）加入屬性。
//優勢：使用 Properties 允許靈活添加其他連線參數（例如 useSSL、serverTimezone）。
//替代方案：
//可以直接在 DriverManager.getConnection(URL, USER, PASSWD) 中傳遞帳號和密碼，但 Properties 更具擴展性。
		try {
			conn = DriverManager.getConnection(URL, prop);
//DriverManager.getConnection(URL, prop)：根據指定的 URL 和屬性建立資料庫連線。
//連線成功後，將結果賦值給類別層級的 conn 變數。
//包在 try 塊中，捕捉可能的 SQLException（例如資料庫未啟動、帳號密碼錯誤）。
			if(!isAccountExist(account)) {
				try {
					registerAccount(account, passwd ,cname);
				}catch(Exception e) {
					System.out.println(e);
				}
			}else {
				System.out.println("Account EXIST!");
			}
//4.檢查帳號並註冊：
//isAccountExist(account)：呼叫方法檢查帳號是否已存在於資料庫。
//如果帳號不存在（!isAccountExist），則呼叫 registerAccount 插入新帳號。
//registerAccount 可能拋出 Exception，因此使用內層 try-catch 捕捉並輸出錯誤訊息。
//如果帳號存在，輸出 "Account EXIST!" 提示使用者。
		}catch(Exception e) {
			System.out.println(e);
		}
	}
//5.異常處理:
//外層 try-catch 捕捉連線建立過程中的異常（例如 SQLException）。
//直接輸出異常訊息，未記錄詳細日誌或採取恢復措施。
	private static boolean isAccountExist(String account) {
		String sql ="SELECT COUNT(account) count FROM member WHERE account = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
//SQL 語句定義：
//查詢語句計算 member 表中 account 欄位等於指定值的記錄數。
//count(account)：計算非空 account 欄位的記錄數，結果命名為 count（透過 AS 關鍵字）。
//WHERE account = ?：使用參數佔位符 ?，待後續綁定具體值。
//注意：假設 member 表存在，且包含 account 欄位。未檢查表或欄位是否存在。
//準備與執行查詢：
//conn.prepareStatement(sql)：創建 PreparedStatement 物件，預編譯 SQL 語句。
//pstmt.setString(1, account);：將第一個參數（?）綁定為輸入的 account 值。
//pstmt.executeQuery()：執行查詢，返回結果集（ResultSet）。
//優勢：PreparedStatement 防止 SQL 注入
//（例如輸入 account = "'; DROP TABLE member; --"），因為參數值會被正確轉義。
			rs.next();
			return rs.getInt("count") > 0;
//rs.next()：將結果集的游標移動到第一行（查詢應只返回一行）。
//rs.getInt("count")：取得名為 count 的欄位值（整數，表示記錄數）。
//> 0：如果記錄數大於 0，表示帳號存在，返回 true；否則返回 false。
//假設：查詢總是返回至少一行（因為 count 聚合函數保證結果），因此 rs.next() 不會失敗。
		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}
//捕捉 SQLException（例如連線失效、表不存在、語法錯誤）。
//輸出錯誤訊息並返回 false，假設查詢失敗時帳號不存在。
//改進建議：
//應記錄異常詳情（例如堆疊追蹤），而不是僅輸出。
//返回 false 可能不總是正確（例如連線失敗不等於帳號不存在），應考慮拋出異常讓上層處理。
//未關閉 ResultSet 和 PreparedStatement，應在 finally 塊中關閉。
//設計考量：
//使用 PreparedStatement 是安全的做法，適合處理用戶輸入。
//SQL 查詢簡單高效，count(account) 是檢查存在性的常見方式。
//異常處理較簡化，未區分不同類型的 SQLException（例如連線錯誤與語法錯誤）。
//1.方法簽名：
//方法假設 conn 已正確初始化，若 conn 為 null 或已關閉，會拋出未捕捉的異常。
	private static void registerAccount(
			String account,
			String passwd,
			String cname)
//	接受三個參數：account（帳號）、passwd（明文密碼）、cname（名稱）。
		throws Exception{
		String sql ="INSERT INTO member (account,passwd,cname) VALUES(?,?,?)";
		String hashPasswd = BCrypt.hashpw(passwd, BCrypt.gensalt());
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, account);
		pstmt.setString(2, hashPasswd);
		pstmt.setString(3, cname);
		if (pstmt.executeUpdate() == 0) {
			throw new Exception("Update Failure");
//宣告拋出 Exception，表示方法可能因插入失敗或資料庫問題拋出異常。
//
//2.SQL 語句定義：
//static 表示方法與類別綁定，與 conn 的靜態屬性一致。
//定義插入語句，將一筆新記錄添加到 member 表。
//欄位：account（帳號）、passwd（加密後的密碼）、cname（名稱）。
//使用三個 ? 作為參數佔位符，待後續綁定。
//假設：member 表存在，且包含這三個欄位，欄位型別與輸入相容（例如 VARCHAR）。
//
//3.密碼加密：
//BCrypt.gensalt()：生成隨機鹽值（salt），用於增強密碼的安全性。
//BCrypt.hashpw(passwd, ...)：
//將明文密碼與鹽值結合，生成 BCrypt 格式的雜湊值（通常為 60 字元的字串）。
//			
//4.準備與執行插入：
//conn.prepareStatement(sql)：創建 PreparedStatement 物件，預編譯插入語句。
//pstmt.setString(1, account);：綁定第一個參數為帳號。
//pstmt.setString(2, hashPasswd);：綁定第二個參數為加密後的密碼。
//pstmt.setString(3, cname);：綁定第三個參數為名稱。
//安全：參數化查詢防止 SQL 注入，特別是對於用戶輸入的 account 和 cname。
//
//5.執行並檢查結果：
//pstmt.executeUpdate()：執行插入操作，返回影響的行數（應為 1 表示成功插入一行）。
//如果返回 0，表示插入失敗（例如資料庫約束違反），拋出自定義的 Exception。
//假設：插入失敗的原因可能是唯一鍵衝突（若 account 有唯一約束）或其他資料庫錯誤。
//改進建議：
//應檢查具體的 SQLException 原因（例如 DuplicateKeyException），提供更詳細的錯誤訊息。
//未關閉 PreparedStatement，應在 finally 塊中關閉。
//
//程式整體功能
//目的：實現一個命令列的帳號註冊系統，允許使用者輸入帳號、密碼和名稱，
//檢查帳號是否已存在，若不存在則將資料（含加密密碼）儲存到 MySQL 資料庫的 member 表。
//流程：
//收集使用者輸入（帳號、密碼、名稱）。
//連線到 MySQL 資料庫。
//檢查帳號是否已存在。
//若帳號不存在，加密密碼並插入新記錄。
//處理可能的錯誤並輸出結果。
//技術亮點：
//使用 JDBC 進行資料庫操作，結構清晰。
//使用 PreparedStatement 防止 SQL 注入。
//使用 BCrypt 加密密碼，確保安全性。
//分離檢查（isAccountExist）和插入（registerAccount）邏輯，模組化設計。
			}
	}
}
