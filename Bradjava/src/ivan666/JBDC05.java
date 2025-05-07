package ivan666;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
//java.sql.Connection：用於表示與資料庫的連線。
//java.sql.DriverManager：用於管理 JDBC 驅動程式並建立資料庫連線。
//java.util.Properties：用於儲存資料庫連線的屬性（如使用者名稱和密碼）。
public class JBDC05 {
	private static final String URL = "jdbc:mysql://localhost/brad";
	private static final String USER = "root";
	private static final String PASSWD = "root";
//public class JDBC05：定義一個名為 JDBC05 的公開類別，作為程式的主要容器。
//常數宣告：
//URL：定義資料庫連線位址，使用 JDBC 格式 jdbc:mysql://localhost/brad，表示連接到本機 MySQL 伺服器的 brad 資料庫。
//USER：定義資料庫使用者名稱，設為 root。
//PASSWD：定義資料庫密碼，設為 root。
//使用 private static final 確保這些值不可修改且僅在類別內部使用，作為連線資料庫的固定參數。
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("user", USER);
		prop.put("password", PASSWD);
		try {
			Connection conn = DriverManager.getConnection(URL, prop);
			
			System.out.println("Finish");
			
		}catch(Exception e) {
			System.out.println(e);
//連線設定：Properties prop = new Properties();：創建一個 Properties 物件，用於儲存資料庫連線的屬性。
//prop.put("user", USER); 和 prop.put("password", PASSWD);：將使用者名稱和密碼存入 Properties 物件，作為連線資料庫的憑證。
//資料庫連線：Connection conn = DriverManager.getConnection(URL, prop);：
//使用 DriverManager 根據提供的 URL 和 Properties 物件建立與 MySQL 資料庫的連線。
//如果連線成功，程式輸出 Finish，表示連線完成。
//異常處理：try-catch 塊捕獲可能發生的異常（例如資料庫未啟動、帳號密碼錯誤、資料庫不存在等）。
//如果發生異常，程式輸出異常訊息（e），幫助診斷問題。
		}

	}

}
