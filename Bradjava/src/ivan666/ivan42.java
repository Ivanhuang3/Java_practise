package ivan666;

import java.io.File;
//import java.io.File; 匯入了 Java 標準庫中的 File 類別，位於 java.io 套件。
//File 類別用於表示檔案系統中的檔案或目錄，提供操作檔案和目錄的方法，
//例如檢查是否存在、創建目錄等
public class ivan42 {
	public static void main(String[] args) {
		File f1 = new File("d:/brad/dir2");
		if (f1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
			f1.mkdir();
//創建 File 物件：
//File f1 = new File("d:/brad/dir2"); 
//創建了一個 File 物件 f1，表示檔案系統中的路徑 d:/brad/dir2。
//這裡使用了正斜線 /，如註解所述，這在 Java 中是合法的，
//即使在 Windows 系統上，File 類別會正確解析為 d:\brad\dir2。
//f1 表示一個目錄（dir2），位於 d:/brad 路徑下。
//File 物件可以表示檔案或目錄，具體取決於路徑。
//檢查目錄是否存在：
//f1.exists() 是一個 File 類別的方法，返回布林值，
//檢查指定的路徑（d:/brad/dir2）在檔案系統中是否存在。
//如果路徑存在（無論是檔案還是目錄），exists() 返回 true；否則返回 false。
//條件判斷與邏輯：
//if (f1.exists()) { ... } else { ... } 
//根據 f1.exists() 的結果執行不同的邏輯：
//如果目錄存在：
//執行 System.out.println("OK");，輸出 "OK"，表示指定的目錄已經存在。
//如果目錄不存在：
//執行 System.out.println("XX");，輸出 "XX"，表示目錄不存在。
//執行 f1.mkdir();，這是 File 類別的方法，
//用於創建單一層級的目錄（在這裡是 d:/brad/dir2）。
//注意：mkdir() 僅能創建單一層級的目錄。
//如果父目錄 d:/brad 不存在，mkdir() 會失敗（返回 false，但這段程式碼未檢查返回值）。
//若需要創建多層級目錄，應該使用 mkdirs()。
//
//mkdir() 的侷限：
//mkdir() 只能創建單一層級的目錄。如果父目錄 d:/brad 不存在，
//mkdir() 會失敗，且程式未檢查 mkdir() 的返回值（boolean）。
//若需要創建多層級目錄（例如 d:/brad/dir2），應使用 f1.mkdirs()，
//它會遞迴創建所有必要的父目錄
		}
	}

}
