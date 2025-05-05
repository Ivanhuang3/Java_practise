package ivan666;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//FileInputStream：用於從檔案中讀取原始位元組資料，適用於任何檔案類型（例如圖片、文字或二進位檔案）。
//FileOutputStream：用於將位元組資料寫入檔案，同樣適用於任何檔案類型。
//作用：允許程式讀取來源檔案並寫入目標檔案。
public class ivan47 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//說明：記錄程式開始執行時的當前時間（以毫秒為單位），使用 System.currentTimeMillis()。
//System.currentTimeMillis() 返回從 1970 年 1 月 1 日 00:00:00 UTC 到當前時間的毫秒數。
//作用：用於測量檔案複製操作的執行時間，後續會計算結束時間與 start 的差值。
		try {
			FileOutputStream fout = new FileOutputStream("dir2/cafe1.jpg");
//說明：創建 FileOutputStream 物件 fout，用於將資料寫入目標檔案 dir2/cafe1.jpg。
//dir2/cafe1.jpg：表示當前工作目錄下的 dir2 目錄中的 cafe1.jpg。
//如果檔案不存在，FileOutputStream 會創建它；如果存在，則覆蓋原有內容。
//如果 dir2 目錄不存在，會拋出 FileNotFoundException。
//作用：建立與目標檔案的連接，準備寫入資料。
			FileInputStream fin = new FileInputStream("dir1/coffee.jpg");
//說明：創建 FileInputStream 物件 fin，用於從來源檔案 dir1/coffee2.jpg 讀取資料。
//dir1/coffee2.jpg：表示當前工作目錄下的 dir1 目錄中的 coffee2.jpg。
//如果檔案不存在或無法開啟，會拋出 FileNotFoundException。
//作用：建立與來源檔案的連接，準備讀取資料。
			int c;
			while((c = fin.read()) != -1) {
				fout.write(c);
			}
//說明：int c;：定義整數變數 c，用於儲存從來源檔案讀取的位元組值。
//fin.read()：從來源檔案讀取一個位元組，返回 0 到 255 的整數（對應位元組值），或在檔案末尾返回 -1。
//while ((c = fin.read()) != -1)：循環讀取來源檔案的內容，直到遇到檔案末尾。
//fout.write(c)：將讀取的位元組 c 寫入目標檔案。
//作用：逐位元組將 dir1/coffee2.jpg 的內容複製到 dir2/cafe1.jpg，適用於任何檔案類型（這裡是圖片）。
			fin.close();
//說明：關閉 FileInputStream 物件，釋放與來源檔案相關的系統資源。
//作用：確保讀取操作完成後，來源檔案被正確關閉。
			fout.flush();
//說明：強制將 FileOutputStream 的緩衝區中的資料寫入目標檔案。
//FileOutputStream 可能會將資料暫存在緩衝區中，flush() 確保所有資料立即寫入檔案。
//作用：保證所有資料在關閉檔案前都已寫入，防止資料遺失。
			fout.close();
//說明：關閉 FileOutputStream 物件，釋放與目標檔案相關的系統資源。
//作用：確保寫入操作完成後，目標檔案被正確關閉。
			System.out.println("OK");
//說明：在控制台印出 "OK"，表示檔案複製操作成功完成。
//作用：提供執行成功的反饋。
			System.out.println(System.currentTimeMillis() - start);
//說明：計算並輸出檔案複製操作的執行時間。
//System.currentTimeMillis() - start：計算從程式開始到當前時間的毫秒數差值。
//作用：顯示複製過程花費的時間（以毫秒為單位），用於性能評估。
		}catch(Exception e) {
//System.out.println(e);
//說明：catch 塊捕獲 try 塊中可能拋出的異常（Exception 是通用類型，
//涵蓋 FileNotFoundException 和 IOException 等）
//			
//			
			
		}
	}

}
