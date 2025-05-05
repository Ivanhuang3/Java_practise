package ivan666;

import java.io.FileInputStream;
//說明：引入 FileInputStream 類別，用於從檔案中讀取位元組資料。
//作用：允許程式開啟並讀取檔案內容。
public class ivan45 {

	public static void main(String[] args) {
		try {
//說明：開始一個 try 塊，用於執行可能拋出異常的程式碼，與後續的 catch 塊一起處理錯誤。
//作用：包圍檔案讀取操作，確保異常（如檔案不存在）不會導致程式崩潰。
			FileInputStream fin = new FileInputStream("dir1/file2.txt");
//說明：創建 FileInputStream 物件 fin，用於讀取 dir1/file2.txt 檔案。
//如果檔案或 dir1 目錄不存在，會拋出 FileNotFoundException。
//作用：建立與目標檔案的連接，準備讀取資料			
			int c;
			while( (c = fin.read()) != -1) {
				System.out.print((char)c);
			}
//int c;：定義整數變數 c，用於儲存從檔案讀取的位元組值。
//fin.read()：讀取檔案中的一個位元組，返回 0 到 255 的整數（對應字元編碼），或在檔案末尾返回 -1。
//while ((c = fin.read()) != -1)：循環讀取檔案，直到遇到檔案末尾（-1）。
//修正點：這裡將 ! = 改為 !=，確保正確比較 c 是否不等於 -1。
//(char)c：將位元組值轉換為字元（例如，65 轉為 A）。
//System.out.print((char)c)：將字元輸出到控制台，連續輸出不換行。
//作用：逐字元讀取 dir1/file2.txt 的內容並顯示在控制台上
			
			fin.close();
//說明：關閉 FileInputStream，釋放檔案相關的系統資源。
//作用：確保檔案讀取完成後正確關閉檔案，避免資源洩漏。
		}catch(Exception e) {
			System.out.println(e);
//說明：捕獲 try 塊中可能拋出的異常（Exception 是通用類型，
//涵蓋 FileNotFoundException 和 IOException）。
//System.out.println(e)：輸出異常訊息，例如檔案不存在的錯誤。
//作用：處理錯誤（例如檔案不存在或讀取失敗），確保程式健壯性。
		}
	}

}
