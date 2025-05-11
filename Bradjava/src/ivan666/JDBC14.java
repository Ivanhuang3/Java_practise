package ivan666;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import tw.brad.apis.BCrypt;
//目的：宣告套件並導入所需的 Java 類別。
//詳細：
//程式碼位於 tw.brad.tutor 套件中。
//導入的類別用於：
//檔案輸入輸出操作（FileInputStream, FileOutputStream, InputStream）。
//JDBC 資料庫操作（Connection,
//DriverManager, PreparedStatement, ResultSet, SQLException, Statement）。
//屬性配置（Properties）。
//使用者輸入（Scanner，但程式中未使用）。
//自定義的 BCrypt 類別（可能用於密碼加密，但此程式未使用）。
//這些導入為資料庫連線和檔案處理提供了必要的工具。
public class JDBC14 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String QUERY = 
			"SELECT * FROM member WHERE id = ?";
//目的：定義 JDBC14 類別並設定靜態變數，用於資料庫連線和查詢。
//詳細：
//URL：指定連接到本機 MySQL 資料庫 brad 的 JDBC URL。
//USER 和 PASSWD：硬編碼的資料庫帳號和密碼（root/root），這在正式環境中不建議使用。
//conn：靜態的 Connection 物件，用於儲存資料庫連線（此處尚未初始化）。
//QUERY：預定義的 SQL 查詢語句，
//使用 PreparedStatement 查詢 member 表中 id 為指定值的記錄，? 是參數占位符。
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1, 3);
			ResultSet rs = pstmt.executeQuery();
//目的：程式的入口點，負責建立資料庫連線、執行查詢並處理結果。
//詳細：Properties prop = new Properties();：
//創建一個 Properties 物件，用於儲存資料庫連線的配置。
//Properties 是一個鍵值對集合，類似於 Map，常用於處理配置資訊。
//prop.put("user", USER); prop.put("password", PASSWD);：
//將 USER（root）和 PASSWD（root）作為鍵值對存入 prop，分別對應資料庫的帳號和密碼。
//這是 JDBC 連線所需的標準屬性。
//try { ... } catch(Exception e) { ... }：
//使用 try-catch 塊捕捉所有可能的異常（包括 SQLException 和其他運行時異常）。
//若發生異常，簡單地印出異常訊息（System.out.println(e);）。
//問題：捕捉廣泛的 Exception 可能隱藏具體錯誤，應明確捕捉 SQLException 或其他預期異常。
//conn = DriverManager.getConnection(URL, prop);：
//使用 DriverManager 建立與資料庫的連線，傳入連線 URL 和配置屬性。
//成功連線後，conn 儲存連線物件。
//假設：程式假設 MySQL JDBC 驅動程式（例如 mysql-connector-java）已加入類路徑（classpath）。
//PreparedStatement pstmt = conn.prepareStatement(QUERY);：
//創建一個 PreparedStatement 物件，基於預定義的 QUERY 語句。
//PreparedStatement 會預編譯 SQL 語句，提高執行效率並防止 SQL 注入攻擊。
//pstmt.setInt(1, 3);：
//將 QUERY 中的第一個 ? 參數設為整數 3，表示查詢 id = 3 的記錄。
//setInt 確保參數以正確的類型傳遞，符合資料庫欄位定義。
//ResultSet rs = pstmt.executeQuery();：
//執行查詢並返回結果集，儲存在 ResultSet 物件 rs 中。
//executeQuery 用於執行 SELECT 語句，返回查詢結果。
			if (rs.next()) {
				String account = rs.getString("account");
				InputStream in = rs.getBinaryStream("icon");
//目的：從查詢結果中提取資料，準備處理帳號和圖片資料。
//詳細：if (rs.next()) { ... }：
//rs.next() 將游標移到結果集的第一筆記錄，並返回 true 如果存在記錄，否則返回 false。
//如果有記錄，進入 if 塊處理資料；如果沒有，則跳過（程式未處理無結果的情況）。
//String account = rs.getString("account");：
//從結果集中提取 account 欄位的值，假設為字串類型（對應資料庫中的 VARCHAR 或類似類型）。
//儲存在 account 變數中，後續用於生成檔案名稱。
//InputStream in = rs.getBinaryStream("icon");：
//從結果集中提取 icon 欄位的二進位資料流，假設為 BLOB（二進位大物件）類型，儲存圖片資料。
//getBinaryStream 返回一個 InputStream 物件，允許程式逐塊讀取二進位資料。
				new Thread() {
					public void run() {
						try {
							String filename = String.format("dir2/%s.png", account);
							FileOutputStream fout = new FileOutputStream(filename);
							
							byte[] buf = new byte [128*1024];
							int len = in.read(buf);
							
							fout.write(buf, 0, len);
							fout.flush();
							fout.close();
							System.out.println("OK");
						}catch(Exception e) {
							System.out.println(e);
						}
					}
				}.start();
				System.out.println("Writing...");
			}
//目的：在獨立的執行緒中將圖片的二進位資料寫入本地檔案系統，確保主執行緒不被阻塞。
//詳細：
//new Thread(){ ... }.start();：
//創建一個匿名 Thread 類別的實例，覆寫 run 方法來定義執行緒的任務。
//呼叫 start() 啟動執行緒，使檔案寫入操作在背景執行。
//使用執行緒的目的是避免檔案 I/O 操作阻塞主執行緒（例如，寫入大檔案可能耗時）。
//String filename = String.format("dir2/%s.png", account);：
//使用 String.format 動態生成檔案路徑，格式為 dir2/<account>.png。
//例如，若 account 為 user1，則檔案名為 dir2/user1.png。
//假設：dir2 目錄已存在，且程式有寫入權限。
//FileOutputStream fout = new FileOutputStream(filename);：
//創建 FileOutputStream 物件，將資料寫入指定的檔案。
//如果檔案不存在，會自動創建；如果已存在，會覆蓋。
//byte[] buf = new byte[128*1024];：
//分配一個 128KB（128 * 1024 位元組）的位元組陣列作為緩衝區。
//選擇 128KB 是為了平衡記憶體使用和 I/O 效率（過小的緩衝區可能導致多次讀寫，降低性能）。
//int len = in.read(buf);：
//從 InputStream（icon 欄位的二進位流）讀取資料到 buf 中。
//len 記錄實際讀取的位元組數（可能小於緩衝區大小）。
//假設：圖片資料小於 128KB，因此只需讀取一次。
//fout.write(buf, 0, len);：
//將緩衝區中的 len 個位元組寫入檔案，從索引 0 開始。
//fout.flush();：
//強制將緩衝區中的資料寫入檔案，確保資料不遺留在記憶體中。
//fout.close();：
//關閉檔案輸出流，釋放系統資源。
//System.out.println("OK");：
//寫入成功後印出 "OK"，表示操作完成。
//catch(Exception e) { System.out.println(e); }：
//捕捉所有異常（例如 IOException），並印出錯誤訊息。
//問題：異常處理過於簡單，無法區分具體錯誤（例如檔案無權限、目錄不存在等）。
//System.out.println("Writing...");：
//在主執行緒中，啟動新執行緒後立即印出 "Writing..."，表示檔案寫入正在進行。
//由於執行緒是異步的，"Writing..." 可能在檔案寫入完成前印出。
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
//總結
//程式功能
//目的：從 MySQL 資料庫的 member 表中查詢 id = 3 的記錄，
//提取 account 和 icon 欄位，並將 icon 的二進位圖片資料寫入 dir2/<account>.png 檔案。
//流程：
//使用硬編碼的連線資訊（root/root）連接到 MySQL 資料庫 brad。
//執行 SELECT * FROM member WHERE id = ? 查詢，獲取結果。
//從結果中提取 account（字串）和 icon（二進位流）。
//在新執行緒中將 icon 資料寫入檔案，檔案名稱基於 account。
//提供簡單的狀態提示（"Writing..." 和 "OK"）。
//技術特點
//使用 PreparedStatement 確保查詢安全，防止 SQL 注入。
//使用執行緒處理檔案寫入，嘗試避免 I/O 操作阻塞主執行緒。
//使用 Properties 管理連線屬性，雖然未充分利用其潛力。
