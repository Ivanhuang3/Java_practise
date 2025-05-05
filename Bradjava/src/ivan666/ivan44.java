package ivan666;

import java.io.FileOutputStream;

public class ivan44 {
	public static void main(String[] args) {
	String mesg = "Hello, Ivan\nTest1\n1234567";
//	說明：定義了一個字串變數 mesg，其內容為多行文字：
//	\n 是換行符，確保每行文字在檔案中分行顯示。
	try {
//說明：開始一個 try 塊，用於執行可能拋出異常的程式碼。
//Java 的異常處理機制允許程式在錯誤發生時捕獲並處理異常，而不是直接終止。
//作用：包圍檔案操作的程式碼，確保任何異常（如檔案不存在或寫入失敗）都能被捕獲並處理。
		FileOutputStream fout =
		new FileOutputStream("./dir1/file1.txt");
//說明：創建一個 FileOutputStream 物件 fout，用於將資料寫入指定檔案 ./dir1/file1.txt。
//./dir1/file1.txt：表示當前工作目錄下的 dir1 子目錄中的 file1.txt 檔案。
//如果檔案不存在，FileOutputStream 會嘗試創建它；如果存在，則會覆蓋原有內容。
//如果 dir1 目錄不存在，會拋出 FileNotFoundException。
//作用：建立與目標檔案的連接，準備進行資料寫入。
		fout.write(mesg.getBytes());
//說明：將字串 mesg 轉換為位元組陣列（mesg.getBytes()），然後透過 fout 將這些位元組寫入檔案。
//getBytes()：將字串轉換為預設編碼（通常是 UTF-8）的位元組陣列。
//write()：將位元組寫入檔案。
//作用：將 mesg 的內容（包括換行符）寫入 ./dir1/file1.txt。
		fout.close();
//說明：關閉 FileOutputStream 物件，釋放與檔案相關的系統資源。
//關閉檔案流是必要的，否則可能導致資源洩漏或資料未正確寫入。
//作用：確保檔案操作完成後，檔案被正確關閉。
		System.out.println("OK");
//說明：在控制台印出字串 "OK"，表示檔案寫入操作成功完成。
//作用：提供執行成功的反饋，方便使用者確認程式運行結果。
	}catch(Exception e1) {
		System.out.println(e1);
//說明：catch 塊捕獲 try 塊中可能拋出的任何異常
//（這裡使用 Exception 作為通用類型，涵蓋 FileNotFoundException 和 IOException 等）。
//e1 是異常物件，包含錯誤的詳細資訊。
//System.out.println(e1)：將異常訊息印到控制台，例如檔案不存在的錯誤訊息。
//作用：處理任何檔案操作中的錯誤，確保程式不會因異常而崩潰，並提供錯誤訊息以便除錯。
		}
	
	}

}
