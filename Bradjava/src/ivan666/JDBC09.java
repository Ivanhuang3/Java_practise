package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class JDBC09 {
	private static final String URL ="jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
//1. 常數定義:
//定義資料庫連線的 URL、使用者名稱和密碼。
//jdbc:mysql://localhost/brad 表示連接到本機的 MySQL 資料庫，資料庫名稱為 brad。
	private static final String SQL =
			"SELECT id,name pname, feature,city,town FROM gift " + 
					"WHERE name LIKE ? OR feature LIKE ? OR city LIKE ? OR town LIKE ? " +
					"ORDER BY " + 
						"CASE " + 
							"WHEN name LIKE ? THEN 1 " +
							"ELSE 2 " +
						"END, " +
						"id ASC";
//2. SQL 查詢語句
//查詢部分：
//從 gift 表中選取 id、name（別名為 pname）、feature、city 和 town。
//使用 WHERE 子句進行模糊查詢，檢查 name、feature、city 或 town 是否包含關鍵字 (LIKE ?)。
//排序部分：
//使用 CASE 語句檢查 name 是否符合關鍵字：
//如果 name 包含關鍵字，該行優先級為 1。
//否則，優先級為 2。
//在優先級相同的條件下，按 id 升序排序。
	public static void main(String[] args) {
		Scanner scaner = new Scanner(System.in);
		System.out.print("Keyword:");
		String search = scaner.next();
		System.out.println("------");
//3. 主程式
//使用 Scanner 從控制台讀取使用者輸入的關鍵字。
//輸出分隔線 ----- 以區分輸入和查詢結果。
		String kw = "%" + search + "%";
//將使用者輸入的關鍵字包裝為模糊查詢格式，例如輸入 test 會變成 %test%，用於 SQL 的 LIKE 查詢。
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, kw);
			pstmt.setString(2, kw);
			pstmt.setString(3, kw);
			pstmt.setString(4, kw);
			pstmt.setString(5, kw);
//5. 資料庫連線與查詢
//使用 Properties 物件設置資料庫的連線憑證。
//建立資料庫連線 (Connection)。
//使用 PreparedStatement 預編譯 SQL 語句，防止 SQL 注入。
//將關鍵字 (kw) 設置到 SQL 語句中的五個 ? 參數：
//前四個用於 WHERE 子句的 name、feature、city 和 town。
//第五個用於 CASE 語句中的 name LIKE ?。
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("pname");
//				String lat =  rs.getString("lat");
//				String lng =  rs.getString("lng");
//				System.out.printf("%s:%s:%s:%s\n", id, name, lat, lng);
		
				String feature = rs.getString("feature");
				String city =rs.getString("city");
				String town =rs.getString("town");
				System.out.printf("%s:%s:%s:%s:%s\n", id, name, feature, city, town);			
			}
//6. 執行查詢與輸出結果
//執行查詢並取得結果集 (ResultSet)。
//遍歷結果集，提取每行的 id、pname、feature、city 和 town。
//使用 printf 格式化輸出，每行以 : 分隔欄位值。	
		  }catch(Exception e) {
				System.out.println(e);
//	捕獲任何異常（例如連線失敗、SQL 錯誤）並輸出異常訊息。
		}
	}
}
//程式執行流程
//使用者輸入關鍵字（例如 taipei）。
//程式將關鍵字轉為 %taipei%，用於模糊查詢。
//連接到 MySQL 資料庫，執行 SQL 查詢，搜尋 gift 表中 name、feature、city 或 town 包含 taipei 的記錄。
//查詢結果按以下規則排序：
//如果 name 包含 taipei，優先顯示。
//其他匹配的記錄次之。
//按 id 升序排列。
//輸出結果，每行顯示 id:name:feature:city:town。
//如果發生錯誤，顯示錯誤訊息。
