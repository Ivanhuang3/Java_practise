package ivan666;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

import tw.brad.apis.BCrypt;
import tw.brad.apis.Bike;
//1. 套件和導入:
//功能：定義程式碼的套件結構並導入所需的 Java 標準庫類別和自定義模組。
//詳細：package tw.brad.tutor;：
//將程式碼組織在 tw.brad.tutor 套件中，作為命名空間，避免類別名稱衝突。
//套件結構反映了程式碼的層次，例如 tutor 可能表示教學或範例程式。
//導入的類別：
//檔案與資料流：
//FileInputStream：用於從檔案讀取二進位資料（程式中未使用，可能為遺留程式碼）。
//FileOutputStream：用於將二進位資料寫入檔案（程式中未使用）。
//InputStream：抽象類別，表示二進位輸入流，用於處理資料庫的 bike 欄位資料。
//ObjectInputStream：用於從二進位流反序列化 Java 物件，這裡用於還原 Bike 物件。
//JDBC 資料庫操作：
//Connection：表示與資料庫的連線，是 JDBC 操作的核心。
//DriverManager：管理 JDBC 驅動程式，用於建立資料庫連線。
//PreparedStatement：預編譯 SQL 語句，提供參數化查詢，防止 SQL 注入。
//ResultSet：儲存查詢結果，允許逐行訪問資料庫記錄。
//SQLException：用於捕捉資料庫相關異常，例如連線失敗或查詢錯誤。
//Statement：用於執行靜態 SQL 語句（程式中未使用）。
//其他工具：
//Properties：鍵值對集合，用於儲存資料庫連線的帳號和密碼。
//Scanner：用於從標準輸入讀取資料（程式中未使用，可能計劃用於動態輸入）。
//tw.brad.apis.BCrypt：自定義類別，可能用於密碼加密（程式中未使用）。
//tw.brad.apis.Bike：自定義類別，表示自行車物件，程式中用於反序列化後的資料。	
public class JDBC16 {
	private static final String URL = "jdbc:mysql://localhost/brad"; 
	private static final String USER = "root";
	private static final String PASSWD = "root";
	private static Connection conn;
	private static final String QUERY = 
		"SELECT * FROM member WHERE id = ?";
//2. 類別定義和靜態變數
//功能：定義 JDBC16 類別並宣告靜態變數，用於資料庫連線和查詢配置。
//詳細：public class JDBC16：
//定義一個公開的類別，作為程式的主體。
//名稱 JDBC16 表明這是一個 JDBC 相關的範例程式，可能是系列教學的一部分（例如 JDBC14, JDBC15）。
//URL：值為 "jdbc:mysql://localhost/brad"，這是 JDBC 連線字串，指定連接到本機（localhost）的 MySQL 資料庫，資料庫名稱為 brad。
//格式遵循 JDBC 標準：jdbc:<database_type>://<host>/<database_name>。
//使用 private static final 確保這是一個不可變的靜態常數，限制在類別內部使用。
//USER 和 PASSWD：
//分別為 "root"，表示資料庫的帳號和密碼。使用 private static final 確保不可修改。
//問題：硬編碼帳號和密碼在程式碼中不安全，特別是在開源或共享環境中，可能導致安全漏洞。
//conn：一個靜態的 Connection 物件，用於儲存資料庫連線。
//宣告為 private static，但未初始化（在 main 方法中初始化）。
//問題：未明確關閉連線，可能導致資源洩漏；靜態變數在多執行緒環境中可能不安全。
//QUERY：定義 SQL 查詢語句："SELECT * FROM member WHERE id = ?"。
//查詢 member 表中 id 等於指定值的記錄，? 是 PreparedStatement 的參數占位符。
//使用 private static final 確保查詢語句不可變，提高程式可維護性。	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user",USER);
		prop.put("password", PASSWD);
		try {
			conn = DriverManager.getConnection(URL, prop);
//3. 主程式（main 方法） - 初始化與連線
//功能：程式入口，初始化資料庫連線屬性並建立連線。
//詳細：public static void main(String[] args)：
//程式的標準入口點，接收命令列參數（未使用）。
//Properties prop = new Properties();：創建 Properties 物件，用於儲存資料庫連線的配置。
//Properties 是鍵值對集合，類似 Map，常用於處理配置資訊。
//prop.put("user", USER); prop.put("password", PASSWD);：
//將 USER（root）和 PASSWD（root）作為鍵值對存入 prop，對應資料庫的帳號和密碼。
//這是 JDBC 連線所需的標準屬性（"user" 和 "password"）。
//try {：開始 try 塊，捕捉後續操作可能拋出的異常（例如 SQLException）。
//conn = DriverManager.getConnection(URL, prop);：
//使用 DriverManager 建立與資料庫的連線，傳入 URL（jdbc:mysql://localhost/brad）和 prop。
//成功連線後，conn 儲存連線物件。
//假設：MySQL JDBC 驅動程式（例如 mysql-connector-java）已加入類路徑。
//技術細節：DriverManager 會根據 URL 選擇合適的驅動程式（MySQL 驅動），並使用提供的帳號和密碼驗證連線。
			PreparedStatement pstmt = conn.prepareStatement(QUERY);
			pstmt.setInt(1, 3);
			ResultSet rs = pstmt.executeQuery();
//4. 準備與執行查詢
//功能：準備並執行 SQL 查詢，獲取 id = 3 的記錄。
//詳細：PreparedStatement pstmt = conn.prepareStatement(QUERY);：
//創建 PreparedStatement 物件，基於預定義的 QUERY（"SELECT * FROM member WHERE id = ?"）。
//PreparedStatement 會預編譯 SQL 語句，提高執行效率並防止 SQL 注入攻擊。
//技術細節：PreparedStatement 使用占位符 ? 允許動態設置參數，確保參數值被正確轉義。
//pstmt.setInt(1, 3);：將第一個 ? 參數設為整數 3，表示查詢 id = 3 的記錄。
//setInt 確保參數以整數類型傳遞，符合資料庫的 id 欄位定義。
//技術細節：參數索引從 1 開始（JDBC 規範）。
//ResultSet rs = pstmt.executeQuery();：
//執行查詢，返回結果集，儲存在 ResultSet 物件 rs 中。
//executeQuery 用於 SELECT 語句，返回包含查詢結果的 ResultSet。
//假設：member 表中存在 id = 3 的記錄，且 bike 欄位包含序列化資料。	
			if(rs.next()) {
				InputStream in = rs.getBinaryStream("bike");
//5. 處理查詢結果:
//功能：檢查查詢結果並提取 bike 欄位的二進位資料流。
//詳細：if (rs.next()) { ... }：
//rs.next() 將 ResultSet 的游標移到第一筆記錄，返回 true 如果存在記錄，否則返回 false。
//如果有記錄，進入 if 塊處理資料；如果沒有，則跳過（未處理無結果的情況）。
//技術細節：ResultSet 初始游標位於第一筆記錄之前，next() 移動到第一筆並檢查是否存在。
//InputStream in = rs.getBinaryStream("bike");：
//從結果集中提取 bike 欄位的二進位資料流，假設為 BLOB 類型，儲存序列化的 Bike 物件。
//getBinaryStream 返回一個 InputStream 物件，允許程式讀取二進位資料。
//假設：bike 欄位包含由 JDBC15.java 儲存的序列化 Bike 物件。	
				ObjectInputStream oin = new ObjectInputStream(in);
				Object obj = oin.readObject();
				Bike b1 = (Bike)obj;
				System.out.println(b1);
//6. 反序列化與輸出:
//功能：將 bike 欄位的二進位資料流反序列化為 Bike 物件並輸出。
//詳細：ObjectInputStream oin = new ObjectInputStream(in);：
//創建 ObjectInputStream 物件，包裝 InputStream，用於從二進位流反序列化 Java 物件。
//技術細節：ObjectInputStream 解析 Java 序列化格式（以 AC ED 00 05 開頭），還原物件結構。
//假設：bike 欄位的資料是有效的序列化 Bike 物件，例如由 JDBC15.java 儲存。
//Object obj = oin.readObject();：
//從 ObjectInputStream 讀取序列化物件，還原為 Java 物件，儲存在 obj 中。
//readObject 返回 Object 類型，需要後續轉型。
//技術細節：反序列化過程重建物件的類別、屬性和狀態。
//Bike b1 = (Bike)obj;：將 obj 強制轉型為 Bike 類型，儲存在 b1 中。
//假設：obj 是 Bike 類型的實例，且 Bike 實現了 Serializable 接口。
//風險：如果 obj 不是 Bike 類型（例如資料庫儲存了其他物件），會拋出 ClassCastException。
//System.out.println(b1);：印出 Bike 物件的字串表示。
//假設：Bike 覆寫了 toString() 方法，返回有意義的資訊（例如速度）。
//示例輸出（假設 bike 欄位儲存了 speed = 8.0 的 Bike 物件）：
			}
		}catch(Exception e) {
			System.out.println(e);
//7. 異常處理
//功能：捕捉程式執行中的所有異常並印出錯誤訊息。
//詳細：catch(Exception e)：
//捕捉所有類型的 Exception，包括：
//SQLException：資料庫連線或查詢錯誤（例如無效 URL、認證失敗）。
//IOException：ObjectInputStream 創建或讀取時的 I/O 錯誤（例如流損壞）。
//ClassNotFoundException：反序列化時找不到 Bike 類別（例如類路徑問題）。
//ClassCastException：obj 無法轉型為 Bike（例如資料庫儲存了其他物件）。
//InvalidClassException：Bike 類別結構與序列化時不匹配（例如屬性改變）。
//StreamCorruptedException：序列化資料格式無效（例如非序列化物件）。
//System.out.println(e);：
//簡單印出異常的 toString() 表示，通常包含異常類型和訊息（例如 java.sql.SQLException: Access denied）。
//問題：僅印出異常訊息，缺乏詳細的堆疊追蹤或上下文，難以診斷問題。
//
//9. 技術背景與實務應用
//JDBC 與 BLOB：
//BLOB 欄位用於儲存大塊二進位資料，適合序列化物件、圖片、文件等。
//getBinaryStream 提供了一個高效的方式處理 BLOB 資料，特別適合大資料量。
//Java 序列化：
//序列化（Serializable 接口）允許將物件轉為二進位流，儲存到資料庫或檔案。
//反序列化需要確保類別結構一致，否則可能拋出異常。
//安全風險：反序列化不受信任的資料可能執行惡意程式碼，應限制允許的類別。
//與其他程式碼的關聯：
//JDBC15.java：將 Bike 物件序列化並儲存到 bike 欄位，JDBC16.java 則負責讀取和還原。
//JDBC14.java：處理 icon 欄位的圖片資料，與 JDBC16.java 類似，但專注於檔案寫入而非物件反序列化。
//.bin 檔案問題：bike 欄位的二進位資料若儲存為 .bin 檔案，可用 ObjectInputStream 反序列化（參考之前的回覆）。
//實務應用：
//物件持久化：儲存複雜物件（例如用戶設置、遊戲狀態）到資料庫。
//資料交換：在不同系統間傳輸序列化物件。
//教育：展示 JDBC 和序列化的結合，適合教學或原型開發。
		}
	}
}
//10.總結:
//每段程式碼在說什麼：
//套件和導入：準備資料庫操作和物件反序列化的工具，導入 JDBC、I/O 和自定義 Bike 類別。
//類別定義和靜態變數：定義 JDBC16 類別，配置資料庫連線（URL、帳號、密碼）和查詢語句。
//初始化與連線：在 main 方法中設置連線屬性並連接到 MySQL 資料庫 brad。
//準備與執行查詢：使用 PreparedStatement 查詢 id = 3 的記錄，獲取結果集。
//處理查詢結果：檢查結果集並提取 bike 欄位的二進位流。
//反序列化與輸出：將二進位流反序列化為 Bike 物件並輸出。
//異常處理：捕捉所有異常並印出錯誤訊息。
//核心功能：
//從資料庫提取序列化的 Bike 物件，反序列化後輸出其狀態（例如 Bike[speed=8.0]）。