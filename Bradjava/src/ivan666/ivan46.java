package ivan666;

import java.io.FileNotFoundException;
import java.io.FileReader;
//說明：引入檔案讀取和異常處理相關的類別。
//FileReader：用於從文字檔案中讀取字元資料，適用於處理純文字檔案（例如 .txt），
//以字元為單位（而非位元組）。
//FileNotFoundException：當試圖開啟不存在的檔案時拋出的異常。
public class ivan46 {

	public static void main(String[] args) {
		try {
//開始一個 try 塊，用於執行可能拋出異常的程式碼，與後續的 catch 塊一起構成異常處理機制。
			FileReader reader = new FileReader("dir1/file2.txt");
//說明：創建 FileReader 物件 reader，用於讀取 dir1/file2.txt 檔案中的字元資料。
//FileReader 專為文字檔案設計，讀取的是字元（Unicode），而不是原始位元組。
//如果檔案或 dir1 目錄不存在，會拋出 FileNotFoundException。
//作用：建立與目標文字檔案的連接，準備讀取內容。		
			int c ;
			while ((c = reader.read())!= -1) {
				System.out.print((char)c);
			}
//int c;：定義整數變數 c，用於儲存從檔案讀取的字元值。
//reader.read()：讀取檔案中的一個字元，
//返回值的範圍是 0 到 65535（對應 Unicode 字元編碼），或在檔案末尾返回 -1。
//while ((c = reader.read()) != -1)：循環讀取檔案內容，直到遇到檔案末尾（-1）。
//(char)c：將整數值轉換為對應的字元。例如，值 65 轉為字元 A。
//System.out.print((char)c)：將字元輸出到控制台，使用 print 確保內容連續輸出，不自動換行。			
			reader.close();
//說明：關閉 FileReader 物件，釋放與檔案相關的系統資源。
//關閉檔案流是必要的，否則可能導致資源洩漏。
			System.out.println("OK");
		}catch (Exception e) {
			System.out.println(e);
//說明：catch 塊捕獲 try 塊中可能拋出的異常（Exception 是通用類型，
//涵蓋 FileNotFoundException 和 IOException 等）。
//System.out.println(e)：將異常訊息輸出到控制台，例如檔案不存在的錯誤訊息。
//作用：處理檔案操作中的錯誤（例如檔案不存在或讀取失敗），確保程式健壯性並提供錯誤訊息以便除錯。
		}
	}
}
