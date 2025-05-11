package ivan666;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Properties;
//java.io.BufferedReader：用於從輸入流中讀取文字。
//java.io.InputStreamReader：將字節流轉換為字符流。
//java.net.URL：表示網路資源的位址，用於訪問 API。
//javax.net.ssl.HttpsURLConnection：用於建立 HTTPS 連線，處理安全的網路請求。
//------------------------------------
//java.sql.Connection：表示與資料庫的連線。
//java.sql.DriverManager：管理 JDBC 驅動程式並建立資料庫連線。
//java.sql.PreparedStatement：執行預編譯的 SQL 語句（帶參數）。
//java.sql.ResultSet：儲存查詢結果（此程式碼未使用，可能是為後續功能預留）。
//java.sql.Statement：執行靜態 SQL 語句。
//java.util.Properties：儲存資料庫連線屬性（使用者名稱和密碼）。

import javax.net.ssl.HttpsURLConnection;
//HttpsURLConnection 是 Java 的 javax.net.ssl 套件中的一個類別，
//繼承自 java.net.HttpURLConnection。
//它專門用於建立和處理基於 HTTPS（HyperText Transfer Protocol Secure，安全超文字傳輸協議）
//的網路連線。
import org.json.JSONArray;
import org.json.JSONObject;
//org.json.JSONArray：處理 JSON 陣列。
//org.json.JSONObject：處理 JSON 物件。

public class JDBC08 {
	private static final String dataUrl ="https://data.moa.gov.tw/Service/OpenData/ODwsv/ODwsvAgriculturalProduce.aspx";
	private static final String URL ="jdbc:mysql://localhost/brad";
	private static final String USER ="root";
	private static final String PASSWD = "root";
	private static final String SQL =
			"INSERT INTO gift (name,feature,tel,picurl,city,town,lat,lng)" +
					"VALUES(?,?,?,?,?,?,?,?)";
//public class JDBC08：定義一個名為 JDBC08 的公開類別，作為程式的主要容器。
//常數宣告：
//dataUrl：定義 API 的 URL，指向農業資料的公開端點，用於從網路獲取 JSON 資料。
//URL：定義 MySQL 資料庫的連線位址（jdbc:mysql://localhost/brad），表示連接到本機的 brad 資料庫。
//USER：定義資料庫使用者名稱，設為 root。
//PASSWD：定義資料庫密碼，設為 root。
//SQL：定義一個 SQL 插入語句，用於將資料插入 gift 表，
//包含八個欄位：name（名稱）、feature（特色）、tel（電話）、
//picurl（圖片 URL）、city（縣市）、town（鄉鎮）、lat（緯度）、lng（經度）。
//使用八個參數佔位符 (?, ?, ?, ?, ?, ?, ?, ?)，由 PreparedStatement 動態設置。
//總結：這些常數定義了資料來源（API URL）、資料庫連線資訊以及資料插入的 SQL 模板，
//支援後續的網路請求和資料庫操作。
	public static void main(String[] args) {
		try {
			URL url = new URL(dataUrl);
			HttpsURLConnection conn = (HttpsURLConnection)url.openConnection();
			
			BufferedReader br = 
					new BufferedReader(
					new InputStreamReader(conn.getInputStream()));
			String line; StringBuffer mesg = new StringBuffer();
			while ( (line = br.readLine()) != null) {
				mesg.append(line);
			}
			
			br.close();
			inserData(mesg.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	public static void main(String[] args)：程式的入口點，負責啟動網路請求並調用資料插入邏輯。
//	網路請求：
//	URL url = new URL(dataUrl);：創建一個 URL 物件，指向農業資料 API。
//	HttpsURLConnection conn = 
//	(HttpsURLConnection)url.openConnection();：建立 HTTPS 連線，用於安全地訪問 API。
//	BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));：
//	從連線的輸入流中讀取資料，將字節流轉換為字符流，並使用 BufferedReader 提高讀取效率。
//	StringBuffer mesg = new StringBuffer();：用於儲存從 API 獲取的原始 JSON 資料（以字串形式）。
//	while ((line = br.readLine()) != null)：逐行讀取 API 回應，將每一行追加到 mesg 中。
//	資源清理：
//	br.close();：關閉 BufferedReader，釋放資源。
//	資料處理：
//	insertData(mesg.toString());：將讀取到的 JSON 字串傳遞給 insertData 方法，進行解析和資料庫插入。
//	異常處理：
//	try-catch 塊捕獲網路請求中的異常（例如 API 不可用、網路連線失敗等），並使用 e.printStackTrace() 輸出詳細錯誤資訊。
//	總結：這段程式碼負責從指定的 API 獲取 JSON 資料，儲存為字串，然後調用 insertData 方法處理資料。
	private static void inserData(String json) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		
		try(Connection conn = DriverManager.getConnection(URL, prop)){
			String delAll = "DELETE FROM gift";
			Statement stmt = conn.createStatement();
			stmt.execute(delAll);
			
			String zero = "ALTER TABLE gift AUTO_INCREMENT = 1";
			stmt.execute(zero);
			
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			
			JSONArray root = new JSONArray(json);
			for (int i=0; i<root.length(); i++) {
				JSONObject row = root.getJSONObject(i);
				String name = row.getString("Name");
				String feature = row.getString("Feature");
				String tel = row.getString("ContactTel");
				String picurl = row.getString("Column1");
				String city = row.getString("County");
				String town = row.getString("Township");
				String lat = row.getString("Latitude");
				String lng = row.getString("Longitude");
				
				pstmt.setString(1, name);
				pstmt.setString(2, feature);
				pstmt.setString(3, tel);
				pstmt.setString(4, picurl);
				pstmt.setString(5, city);
				pstmt.setString(6, town);
				
				try {
					pstmt.setDouble(7, Double.parseDouble(lat));
					pstmt.setDouble(8, Double.parseDouble(lng));
				}catch(Exception e) {
					pstmt.setDouble(7, 0.0);
					pstmt.setDouble(8, 0.0);
				}
				
				pstmt.executeUpdate();
			}
			System.out.println("Finish");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
//功用：
//
//private static void insertData(String json)：
//定義一個靜態方法，負責解析 JSON 資料並將其插入資料庫。
//資料庫連線：
//Properties prop = new Properties(); 
//和 prop.put(...)：設置資料庫連線的屬性（使用者名稱和密碼）。
//try (Connection conn = DriverManager.getConnection(URL, prop))：
//使用 try-with-resources 確保連線自動關閉，建立與 brad 資料庫的連線。
//清空資料表：
//String delAll = "DELETE FROM gift"; 和 stmt.execute(delAll);：
//刪除 gift 表中的所有現有記錄，確保插入新資料前表是空的。
//String zero = "ALTER TABLE gift AUTO_INCREMENT = 1"; 和 stmt.execute(zero);：
//重置 gift 表的自動遞增計數器，從 1 開始，適用於有自動遞增主鍵的表。
//
//JSON 解析：
//JSONArray root = new JSONArray(json);：
//將輸入的 JSON 字串解析為 JSON 陣列，假設 API 返回的資料是一個 JSON 陣列。
//for (int i=0; i<root.length(); i++)：迭代陣列中的每個 JSON 物件（每物件代表一筆記錄）。
//從每個 JSON 物件中提取欄位：
//JSONObject row = root.getJSONObject(i); 的作用：
//從 root（JSONArray）中提取索引 i 處的單個 JSONObject，並將其儲存在 row 變數中。
//每個 row 代表 API 回應中的一筆記錄（例如一個農場的資料），包含多個欄位（如名稱、特色、電話等）。
//為什麼需要這句？
//API 返回的 JSON 資料是一個陣列，包含多筆記錄。
//程式需要逐一處理每筆記錄（每個 JSON 物件），提取其欄位值並插入資料庫。
//getJSONObject(i) 允許程式按索引訪問陣列中的每個 JSON 物件，方便後續解析。
//Name → name（名稱）
//Feature → feature（特色）
//ContactTel → tel（電話）
//Column1 → picurl（圖片 URL）
//County → city（縣市）
//Township → town（鄉鎮）
//Latitude → lat（緯度）
//Longitude → lng（經度）
//
//資料插入：
//PreparedStatement pstmt = conn.prepareStatement(SQL);：
//創建 PreparedStatement，預編譯 SQL 插入語句。
//設置參數：
//pstmt.setString(1, name); 到 pstmt.setString(6, town);：
//設置字串型態的欄位（name, feature, tel, picurl, city, town）。
//pstmt.setDouble(7, Double.parseDouble(lat)); 
//和 pstmt.setDouble(8, Double.parseDouble(lng));：
//將 lat 和 lng 轉換為 double 並設置。
//使用內部 try-catch 處理 lat 和 lng 轉換失敗的情況（例如非數字格式），若失敗則設置為 0.0。
//pstmt.executeUpdate();：執行插入操作，將一筆記錄插入 gift 表。
//結果處理：
//成功插入所有記錄後，輸出 Finish。
//異常處理：
//外層 try-catch 捕獲資料庫操作或 JSON 解析中的異常（例如連線失敗、表不存在、JSON 格式錯誤等），輸出異常訊息。
//總結：這段程式碼解析 API 返回的 JSON 資料，提取所需欄位，
//清空 gift 表並重置自動遞增計數器，然後將每筆記錄插入資料庫，處理緯度和經度的轉換錯誤。
//
//總結
//每個段落的功用可以概括如下：
//
//套件與匯入：組織程式碼並引入網路請求、資料庫操作和 JSON 解析所需的類別。
//註解：提供背景資訊，指向農業資料 API，說明資料來源。
//類別與常數：定義程式容器，設置 API URL、資料庫連線參數和 SQL 插入語句（插入 gift 表的八個欄位）。
//主程式與網路請求：從農業資料 API 獲取 JSON 資料，儲存為字串，傳遞給 insertData 方法。
//資料解析與插入：
//解析 JSON 資料，清空 gift 表並重置自動遞增計數器，迭代 JSON 陣列，將每筆記錄插入資料庫，處理緯度和經度的轉換錯誤。
//程式整體功能：這段程式碼從台灣農業部的公開 API 獲取農業資料（JSON 格式），
//解析資料並將其插入 MySQL 資料庫的 gift 表中，每次執行前清空表並重置主鍵計數器。
//程式實現了從網路資料到資料庫儲存的完整流程，適合用於定期更新農業相關資料。
//與之前的程式碼（例如 JDBC06 和 JDBC07）相比，它增加了網路請求和 JSON 處理，功能更複雜且更貼近實際應用場景。
