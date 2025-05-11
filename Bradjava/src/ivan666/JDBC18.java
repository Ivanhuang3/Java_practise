package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
//1. 套件和導入:
//功能：定義程式碼的套件結構並導入所需的 Java 標準庫類別。
//詳細：package tw.brad.tutor;：
//將程式碼組織在 tw.brad.tutor 套件中，作為命名空間，避免類別名稱衝突。
//表明這是一個教學或範例程式，與之前的 JDBC14 到 JDBC17 屬於同一系列。
//導入的類別：
//JDBC 資料庫操作：
//Connection：表示與資料庫的連線。
//DriverManager：管理 JDBC 驅動程式，用於建立連線。
//PreparedStatement：預編譯 SQL 語句，提供安全查詢。
//ResultSet：儲存查詢結果，允許逐行訪問資料。
//Statement：用於執行靜態 SQL 語句（程式中未使用）。
//其他工具：
//Properties：鍵值對集合，用於儲存資料庫連線的帳號和密碼。	
public class JDBC18 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static final String QUERY = "SELECT * FROM gift";
//2. 類別定義和靜態變數
//功能：定義 JDBC18 類別並宣告靜態變數，用於資料庫連線和查詢配置。
//詳細：public class JDBC18：
//定義一個公開的類別，作為程式的主體。
//名稱 JDBC18 表明這是 JDBC 系列範例的一部分，專注於進階 ResultSet 操作。
//URL：值為 "jdbc:mysql://localhost/brad"，指定連接到本機 MySQL 資料庫 brad 的 JDBC URL。
//使用 private static final 確保不可修改，限制在類別內部使用。
//USER 和 PASSWD：分別為 "root"，表示資料庫的帳號和密碼。
//使用 private static final 確保不可修改。
//QUERY：
//定義 SQL 查詢："SELECT * FROM gift"。
//查詢 gift 表的所有欄位和記錄。
//使用 private static final 確保查詢語句不可變。
		public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
//3. 主程式（main 方法） - 初始化與連線
//功能：程式入口，初始化連線屬性並連接到資料庫。
//詳細：public static void main(String[] args)：
//標準入口點，接收命令列參數（未使用）。
//Properties prop = new Properties();：
//創建 Properties 物件，用於儲存連線配置。prop.put("user", USER); prop.put("password", PASSWD);：
//將 USER（root）和 PASSWD（root）存入 prop。
//try {：開始 try 塊，捕捉異常。
//Connection conn = DriverManager.getConnection(URL, prop);：
//使用 DriverManager 連接到 brad 資料庫，傳入 URL 和 prop。
//假設：MySQL JDBC 驅動程式已加入類路徑。
//技術細節：conn 是局部變數（相較於之前的靜態 conn），更適合單執行緒操作。
			PreparedStatement pstmt =
					conn.prepareStatement(QUERY,
							ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = pstmt.executeQuery();
//4. 準備查詢與可滾動 ResultSet			
//功能：準備查詢並創建可滾動且可更新的 ResultSet。
//詳細：
//PreparedStatement pstmt = conn.prepareStatement(...)：
//創建 PreparedStatement，基於 QUERY（"SELECT * FROM gift"）。
//傳入兩個參數：
//ResultSet.TYPE_SCROLL_INSENSITIVE：
//指定 ResultSet 是可滾動的，允許在結果集中前後移動（例如 next(), previous(), absolute()）。
//INSENSITIVE 表示對資料庫的其他更改不敏感（查詢結果是快照）。
//ResultSet.CONCUR_UPDATABLE：
//指定 ResultSet 是可更新的，允許直接修改資料庫記錄（例如 updateString(), updateRow()）。
//技術細節：這些參數使 ResultSet 支援進階操作，但增加記憶體和性能開銷。
//ResultSet rs = pstmt.executeQuery();：
//執行查詢，返回可滾動且可更新的 ResultSet。
//假設：gift 表存在，且查詢返回非空結果集。
			rs.next();
			String name = rs .getString("name");
			System.out.println(name);
//5. 讀取第一筆記錄		
//功能：移動到第一筆記錄，讀取並輸出 name 欄位。
//詳細：
//// beforeFist：
//註解表明初始時 ResultSet 游標位於第一筆記錄之前（beforeFirst 狀態）。
//rs.next();：
//將游標移動到第一筆記錄，返回 true（假設結果集非空）。
//技術細節：next() 是標準的順序遍歷方法。
			if (rs.absolute(4)) {
				name = rs.getString("name");
				System.out.println(name);
			}else {
				System.out.println("XX");
			}
//6. 移動到第四筆記錄
//功能：嘗試移動到第四筆記錄，讀取並輸出 name 欄位。
//詳細：
//if (rs.absolute(4)) { ... }：
//absolute(4) 將游標移動到第四筆記錄（從 1 開始計數），返回 true 如果成功，否則返回 false（例如記錄數少於 4）。
//技術細節：absolute(n) 是可滾動 ResultSet 的功能，允許直接跳到指定行。
//name = rs.getString("name");：
//提取第四筆記錄的 name 欄位。
//System.out.println(name);：
//輸出第四筆記錄的 name 值。
//else { System.out.println("XX"); }：
//如果移動失敗（例如少於 4 筆記錄），輸出 "XX"。
			rs.first();
			name = rs.getString("name");
			System.out.println(name);
			
			rs.last();
			name = rs.getString("name");
			System.out.println(name);
//8. 移動到最後一筆記錄
//功能：移動到最後一筆記錄，讀取並輸出 name 欄位。
//詳細：
//rs.last();：
//將游標移動到最後一筆記錄，返回 true（假設結果集非空）。
//name = rs.getString("name");：
//提取 name 欄位。
//System.out.println(name);：
//輸出最後一筆記錄的 name 值。
			if (rs.next()) {
				System.out.println("OK");
			}else {
				System.out.println("XX");
			}
			
			rs.absolute(147);
			name = rs.getString("name");
			System.out.println(name);
			
			rs.updateString("tel", "09123456");
			rs.updateString("name", "麻辣小魚分享包V2");
			rs.updateRow();
//11. 更新記錄
//功能：更新第 147 筆記錄的 tel 和 name 欄位，並提交更改。
//詳細：rs.updateString("tel", "0912-123456");：
//將當前記錄（第 147 筆）的 tel 欄位設置為 "0912-123456"。
//技術細節：updateString 修改 ResultSet 的緩衝區，未立即影響資料庫。
//rs.updateString("name", "麻辣小魚分享包V2");：將 name 欄位設置為 "麻辣小魚分享包V2"。
//rs.updateRow();：將緩衝區的更改提交到資料庫，實際更新 gift 表的記錄。
//假設：tel 和 name 欄位存在且為字串類型。
//設計意圖：展示可更新 ResultSet 的功能，允許直接修改資料庫記錄。	
//			
			rs.absolute(7);
			name = rs.getString("name");
			System.out.println(name);
			
			rs.deleteRow();
//12. 移動到第七筆記錄並刪除
//功能：移動到第七筆記錄，輸出 name 欄位，然後刪除該記錄。
//詳細：
//rs.absolute(7);：移動到第七筆記錄。
//name = rs.getString("name");：提取 name 欄位。
//System.out.println(name);：輸出第七筆記錄的 name 值。
//rs.deleteRow();：從資料庫中刪除當前記錄（第七筆）。
//技術細節：deleteRow() 直接執行 SQL DELETE 語句，影響資料庫。
//設計意圖：
//展示可更新 ResultSet 的刪除功能。
			//--------------------
			rs.moveToInsertRow();
			rs.updateString("tel", "0912-123456");
			rs.updateString("name", "麻辣小魚分享包V3");
			rs.updateString("feature", "麻辣小魚粉好吃");
			rs.insertRow();
//13. 插入新記錄
//功能：插入一筆新記錄到 gift 表。
//詳細：rs.moveToInsertRow();：
//將 ResultSet 游標移動到一個特殊的插入行（不對應任何現有記錄）。
//技術細節：插入行是 ResultSet 的緩衝區，用於構建新記錄。
//rs.updateString("tel", "0912-123456");：
//設置插入行的 tel 欄位。
//rs.updateString("name", "麻辣小魚分享包V3");：
//設置 name 欄位。
//rs.updateString("feature", "麻辣小魚粉好吃");：
//設置 feature 欄位。
//rs.insertRow();：將插入行的數據提交到資料庫，創建新記錄。
//假設：tel, name, feature 欄位存在，且表結構允許插入。	
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
//16. 技術背景與實務應用
//可滾動與可更新 ResultSet：
//TYPE_SCROLL_INSENSITIVE 允許隨機訪問結果集，適合需要靈活遍歷的應用。
//CONCUR_UPDATABLE 允許直接修改資料庫，減少手動 SQL 語句。
//限制：需要資料庫支援（例如 MySQL 需要主鍵），且性能開銷較大。
//應用場景：
//資料編輯工具：開發資料庫管理介面，允許用戶直接修改記錄。
//批量數據處理：遍歷和更新大型結果集。
//教學：展示 JDBC 的進階功能。
//與其他程式碼的關聯：
//JDBC14.java：處理圖片資料（BLOB）。
//JDBC15/16.java：處理序列化物件（Bike）。
//JDBC17.java：多表查詢銷售報表。
//JDBC18 專注於 ResultSet 的滾動和更新功能，與前述程式形成對比。
//
//17. 總結
//每段程式碼在說什麼：
//套件和導入：準備 JDBC 操作的工具。
//類別定義和靜態變數：配置連線（brad 資料庫）和查詢（gift 表）。
//初始化與連線：連接到資料庫。
//準備查詢與 ResultSet：創建可滾動且可更新的 ResultSet。
//讀取第一筆記錄：移動到第一筆並輸出 name。
//移動到第四筆記錄：隨機訪問並輸出 name。
//移動到第一筆記錄：展示 first() 方法。
//移動到最後一筆記錄：展示 last() 方法。
//檢查下一筆記錄：驗證結果集末尾。
//移動到第 147 筆記錄：隨機訪問並輸出 name。
//更新記錄：修改第 147 筆的 tel 和 name。
//刪除記錄：刪除第七筆記錄。
//插入記錄：新增一筆記錄。
//異常處理：捕捉所有異常。
//核心功能：
//使用可滾動且可更新的 ResultSet 進行資料讀取、更新、刪除和插入。