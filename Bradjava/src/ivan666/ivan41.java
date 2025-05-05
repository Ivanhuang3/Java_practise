package ivan666;

import java.io.File;
//import java.io.File; 匯入了 Java 標準庫中的 File 類別，位於 java.io 套件中。
//File 類別用於處理檔案和目錄的操作，
//例如建立檔案、檢查路徑、獲取檔案屬性等。在這段程式碼中
//它被用來存取與檔案系統分隔符號相關的靜態屬性。
public class ivan41 {

	public static void main(String[] args) {
		System.out.println(File.pathSeparator);
		System.out.println(File.separator);
//File.pathSeparator：
//File.pathSeparator 是一個靜態屬性（static 欄位），
//表示作業系統中用來分隔多個路徑的符號（例如在環境變數 PATH 或 CLASSPATH 中）。
//在 Windows 系統中，pathSeparator 通常是分號 ;。
//在 Unix/Linux/MacOS 系統中，pathSeparator 通常是冒號 :。
//System.out.println(File.pathSeparator); 會將這個分隔符號輸出到控制台。
//File.separator：
//File.separator 是一個靜態屬性，表示作業系統中用來分隔檔案路徑中目錄層級的符號。
//在 Windows 系統中，separator 通常是反斜線 \。
//在 Unix/Linux/MacOS 系統中，separator 通常是正斜線 /。
//System.out.println(File.separator); 會將這個分隔符號輸出到控制台。
//
//展示了 File.pathSeparator 和 File.separator 的用途，
//分別用於路徑列表分隔和目錄層級分隔。
//這些屬性讓程式設計者能夠撰寫與作業系統無關的程式碼，提高跨平台相容性。
	}

}
