package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;
import java.util.Scanner;
//定義套件：將程式碼組織在 tw.brad.tutor 套件中，
//這是一個 Java 套件命名慣例，通常用於教學或個人專案，表明這段程式碼可能來自某個教學範例。
//匯入類別：
//java.sql.Connection：表示與資料庫的連線物件，用於管理資料庫連線。
//java.sql.DriverManager：JDBC 的核心類別，負責根據提供的 URL 和認證資訊建立資料庫連線。
//java.sql.PreparedStatement：用於執行預編譯的 SQL 語句，支持參數化查詢，防止 SQL 注入並提高性能。
//java.sql.ResultSet：表示查詢結果的資料結構，允許程式遍歷查詢返回的行和欄。
//java.sql.Statement：用於執行靜態 SQL 語句（雖然本程式未使用，但匯入可能是為了備用或教學完整性）。
//java.util.Properties：用於儲存鍵值對（例如用戶名和密碼），在建立資料庫連線時傳遞認證資訊。
//java.util.Scanner：用於從標準輸入（鍵盤）讀取使用者輸入，在本程式中用來接收頁數。
public class JDBC10 {
	private static final String URL ="jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String SQL =
			"SELECT id,name FROM gift ORDER BY id LIMIT ?,?";
//宣告常數：
//URL：定義 MySQL 資料庫的連線字串，
//格式為 jdbc:mysql://主機名稱/資料庫名稱，這裡指向本機（localhost）的 brad 資料庫。
//USER：資料庫用戶名，設為 root（MySQL 的預設管理員帳戶）。
//PASSWD：資料庫密碼，設為 root（與用戶名一致，僅用於測試環境）。
//SQL：定義一個 SQL 查詢語句，選取 gift 表格中的 id 和 name 欄位，
//按 id 升序排序，並使用 LIMIT ?,? 實現分頁查詢。
//LIMIT ?,?：MySQL 的分頁語法，第一個 ? 表示起始行索引（從 0 開始），第二個 ? 表示要返回的行數。
//	
//這句 SQL 是用於從 MySQL 資料庫的 gift 表格中查詢數據的語句，結合了分頁功能。
//1. SELECT id, name
//意義：
//SELECT 是 SQL 的查詢指令，用於從資料庫中選取指定的欄位。
//id, name 表示只選取 gift 表格中的 id 和 name 兩個欄位。
//
//2. FROM gift
//意義：
//FROM gift 指定查詢的數據來源是名為 gift 的表格。
//
//3. ORDER BY id
//意義：ORDER BY id 表示查詢結果將按 id 欄位的值進行排序。
//預設為升序（ascending），即從小到大排序（例如，1, 2, 3 或 "A", "B", "C"）。
//
//4. LIMIT ?, ?
//意義：LIMIT ?, ? 是 MySQL 的分頁語法，用於限制查詢結果的行數和起始位置。
//第一個 ? 是起始索引（offset），表示從結果集的第幾行開始返回（索引從 0 開始）。
//第二個 ? 是返回的行數（count），表示要返回的最大記錄數。
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("頁: ");
		int page = scanner.nextInt();
		int rpp = 7;
		int start = (page - 1 )*rpp;
		System.out.println("---");
//功能
//定義主方法：main 方法是程式的入口點，接收命令列參數（args），雖然本程式未使用。
//接收使用者輸入：
//創建 Scanner 物件，從標準輸入（鍵盤）讀取資料。
//輸出提示 "頁: "，要求使用者輸入想查詢的頁數。
//使用 scanner.nextInt() 讀取整數輸入，存入 page 變數。
//分頁參數計算：
//定義 rpp（rows per page，每頁記錄數）為 7，表示每頁顯示 7 筆記錄。
//計算查詢的起始索引：start = (page - 1) * rpp。
//例如，若 page = 1，則 start = (1-1) * 7 = 0（從第一筆記錄開始）。
//若 page = 2，則 start = (2-1) * 7 = 7（從第八筆記錄開始）。
//格式化輸出：輸出 "---" 作為分隔線，用於區分輸入提示和後續查詢結果。
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
//功能:
//創建 Properties 物件：初始化一個 Properties 物件，用於儲存資料庫連線的認證資訊。
//設定認證屬性：
//使用 prop.put("user", USER) 設定用戶名（root）。
//使用 prop.put("password", PASSWD) 設定密碼（root）。
//細節:
//Properties 的用途：
//Properties 是 Java 的鍵值對儲存類別，常用於配置管理。
//在 JDBC 中，Properties 物件用於傳遞連線參數（如用戶名、密碼、編碼等）。
//鍵的選擇：
//"user" 和 "password" 是 JDBC 連線的標準鍵，DriverManager 會解析這些鍵來進行身份驗證。
//硬編碼問題：
//雖然這裡使用了常數 USER 和 PASSWD，但它們的值仍是硬編碼的（root），不適合生產環境。
//更好的做法是從外部配置文件（例如 database.properties）或環境變數載入這些值。
//作用:
//準備資料庫連線所需的認證資訊，確保後續的 DriverManager.getConnection 能成功連接到資料庫。
//將認證資訊集中管理，提高程式碼的可讀性和可維護性。
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setInt(1, start);
			pstmt.setInt(2, rpp);
			ResultSet rs = pstmt.executeQuery();
//功能:
//開始異常處理：使用 try 塊包圍資料庫操作，準備捕獲可能的異常（例如連線失敗或 SQL 錯誤）。
//建立資料庫連線：
//使用 DriverManager.getConnection(URL, prop) 連接到 MySQL 資料庫，
//傳入連線 URL（jdbc:mysql://localhost/brad）和認證屬性（prop）。
//返回一個 Connection 物件，表示與資料庫的活躍連線。
//準備 SQL 查詢：
//使用 conn.prepareStatement(SQL) 創建 PreparedStatement 物件，預編譯常數 SQL 中的查詢語句。
//PreparedStatement 允許使用佔位符（?）動態設定參數，提高安全性和性能。
//設定查詢參數：
//pstmt.setInt(1, start)：將第一個佔位符（LIMIT 的起始索引）設為 start（從段落 3 計算而來）。
//pstmt.setInt(2, rpp)：將第二個佔位符（每頁記錄數）設為 rpp（固定為 7）。
//執行查詢：
//使用 pstmt.executeQuery() 執行查詢，
//返回一個 ResultSet 物件，包含查詢結果（gift 表格中指定範圍的記錄）。			
			while (rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				System.out.printf("%s:%s\n", id, name);		
			}
//功能
//遍歷結果集：
//使用 while (rs.next()) 迴圈遍歷 ResultSet 中的每一行。
//rs.next() 將游標移動到下一行，並返回 true（如果有數據）或 false（如果無更多數據）。
//提取欄位值：
//使用 rs.getString("id") 提取當前行的 id 欄位值，作為字串儲存到 id 變數。
//使用 rs.getString("name") 提取當前行的 name 欄位值，作為字串儲存到 name 變數。
//格式化輸出：
//使用 System.out.printf("%s:%s\n", id, name) 
//將 id 和 name 格式化輸出，格式為 id:name，每行後換行（\n）。
//例如，若 id = "1"，name = "GiftA"，則輸出 1:GiftA。
//			
//細節
//ResultSet 的運作：
//ResultSet 預設為順向唯讀游標，每次 next() 移動到下一行。
//getString("id") 和 getString("name") 
//使用欄位名稱訪問數據，假設 id 和 name 是 gift 表格的有效欄位。
//資料型別假設：
//getString 假設 id 和 name 欄位可以轉為字串。
//如果 id 是整數型（如 INT），getString 會自動將其轉為字串表示。
//如果欄位不存在或型別不兼容，會拋出 SQLException。
//輸出格式：
//printf 使用 %s 格式化字串，:作為分隔符，\n 確保每行獨立。
//這種格式簡單，適合命令列輸出，但在實際應用中可能需要更結構化的輸出（例如 JSON 或表格）。
			System.out.println("Finish");
//完成訊息：在查詢結果處理完成後，輸出字串 "Finish" 到控制台。
//提示執行狀態：表示程式已成功執行資料庫查詢和結果輸出。		
		}catch(Exception e) {
			System.out.println(e);
//使用 catch(Exception e) 
//捕獲 try 塊中可能拋出的任何異常（例如 SQLException 或其他運行時異常）。
//Exception 是所有異常的父類，確保捕捉所有可能的錯誤。
//
//總結與整體流程
//以下是每個段落的簡要功能總結，以及它們如何協同工作：
//套件與匯入：
//為程式提供必要的類別支持，準備 JDBC、屬性管理和輸入處理。
//類別定義與常數：
//設定資料庫連線和查詢的固定參數（URL、用戶名、密碼、SQL 語句）。
//主方法與使用者輸入：
//接收使用者輸入的頁數，計算分頁查詢的起始索引（start），為 SQL 參數做準備。
//設定資料庫連線屬性：
//準備認證資訊（用戶名和密碼），用於建立資料庫連線。
//資料庫連線與查詢：
//連接到 MySQL 資料庫，執行分頁查詢（SELECT ... LIMIT ?,?），獲取指定頁數的記錄。
//處理查詢結果：
//遍歷查詢結果，提取 id 和 name 欄位並格式化輸出（id:name）。
//查詢完成提示：
//輸出 "Finish"，確認查詢和輸出成功完成。
//異常處理與程式結束：
//捕獲並顯示任何錯誤，確保程式正常終止。
//整體流程
//程式啟動，提示使用者輸入頁數（例如 2）。
//計算起始索引（start = (2-1) * 7 = 7），表示從第 8 筆記錄開始。
//連接到 MySQL 的 brad 資料庫，使用用戶名和密碼 root。
//執行 SQL 查詢，從 gift 表格選取第 8 至 14 筆記錄（每頁 7 筆）。
//遍歷結果，將每筆記錄的 id 和 name 輸出為 id:name 格式。
//輸出 "Finish"，或在發生錯誤時顯示錯誤訊息。
//程式結束。
			
		}
	}

}
