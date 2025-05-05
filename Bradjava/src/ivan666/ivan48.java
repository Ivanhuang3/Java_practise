package ivan666;

import java.io.FileInputStream;
import java.io.FileOutputStream;
//說明：引入檔案輸入和輸出流相關的類別。
//FileInputStream：用於從檔案中讀取原始位元組資料，適用於任何檔案類型（例如圖片、文字或二進位檔案）。
//FileOutputStream：用於將位元組資料寫入檔案，同樣適用於任何檔案類型。
//作用：允許程式讀取來源檔案並寫入目標檔案。
public class ivan48 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
//說明：記錄程式開始執行時的當前時間（以毫秒為單位），使用 System.currentTimeMillis()。
//System.currentTimeMillis() 返回從 1970 年 1 月 1 日 00:00:00 UTC 到當前時間的毫秒數。
//作用：用於測量檔案複製操作的執行時間，後續會計算結束時間與 start 的差值。
		try {
//說明：開始一個 try 塊，用於執行可能拋出異常的程式碼，與後續的 catch 塊一起構成異常處理機制。
//作用：包圍檔案讀寫操作，確保異常（如檔案不存在或讀寫錯誤）不會導致程式崩潰。
			FileOutputStream fout = new FileOutputStream("dir2/cafe2.jpg");
//說明：創建 FileOutputStream 物件 fout，用於將資料寫入目標檔案 dir2/cafe2.jpg。
//dir2/cafe2.jpg：表示當前工作目錄下的 dir2 目錄中的 cafe2.jpg。
//如果檔案不存在，FileOutputStream 會創建它；如果存在，則覆蓋原有內容。
//如果 dir2 目錄不存在，會拋出 FileNotFoundException。
//作用：建立與目標檔案的連接，準備寫入資料。
			FileInputStream fin =new FileInputStream("dir1/coffee.jpg");
//說明：創建 FileInputStream 物件 fin，用於從來源檔案 dir1/coffee2.jpg 讀取資料。
//dir1/coffee2.jpg：表示當前工作目錄下的 dir1 目錄中的 coffee2.jpg。
//如果檔案不存在或無法開啟，會拋出 FileNotFoundException。
//作用：建立與來源檔案的連接，準備讀取資料。
			int len; byte[] buf = new byte[4*1024];
//說明：
//int len;：定義整數變數 len，用於儲存每次從檔案讀取的位元組數。
//byte[] buf = new byte[4*1024];：創建一個 4KB（4096 位元組）的位元組陣列 buf，
//作為緩衝區，用於批量讀取和寫入資料。
//4KB 是一個常見的緩衝區大小，平衡了性能和記憶體使用。
//作用：準備用於批量讀寫的變數和緩衝區，提升檔案複製效
			while( (len = fin.read(buf)) != -1) {
				fout.write(buf, 0, len);
			}
//說明：
//fin.read(buf)：從來源檔案讀取最多 4096 個位元組到緩衝區 buf，返回實際讀取的位元組數（len），
//或在檔案末尾返回 -1。
//while ((len = fin.read(buf)) != -1)：循環讀取檔案內容，直到讀到檔案末尾。
//fout.write(buf, 0, len)：將緩衝區 buf 中從索引 0 開始的 len 個位元組寫入目標檔案。
//len 表示實際讀取的位元組數，確保只寫入有效資料（避免寫入緩衝區中未使用的部分）。
//作用：以 4KB 為單位批量複製 dir1/coffee2.jpg 的內容到 dir2/cafe2.jpg，
//比逐位元組複製更高效。
			fin.close();
//說明：關閉 FileInputStream 物件，釋放與來源檔案相關的系統資源。
//作用：確保讀取操作完成後，來源檔案被正確關閉。
			fout.flush();
//說明：強制將 FileOutputStream 的緩衝區中的資料寫入目標檔案。
//FileOutputStream 可能暫存資料，flush() 確保所有資料立即寫入。
//作用：保證所有資料在關閉檔案前都已寫入，防止資料遺失。
			fout.close();
//說明：關閉 FileOutputStream 物件，釋放與目標檔案相關的系統資源。
//作用：確保寫入操作完成後，目標檔案被正確關閉
			System.out.println("OK");
//說明：在控制台印出 "OK"，表示檔案複製操作成功完成。
//作用：提供執行成功的反饋。
			System.out.println(System.currentTimeMillis() - start);
//說明：計算並輸出檔案複製操作的執行時間（以毫秒為單位）。
//System.currentTimeMillis() - start：計算從程式開始到當前時間的毫秒數差值。
//作用：顯示複製過程花費的時間，用於性能評估。
		}catch(Exception e) {
			System.out.println(e);
//說明：catch 塊捕獲 try 塊中可能拋出的異常（Exception 是通用類型，
//涵蓋 FileNotFoundException 和 IOException 等）。
//System.out.println(e)：將異常訊息輸出到控制台，例如檔案不存在的錯誤。
//作用：處理檔案操作中的錯誤（例如檔案或目錄不存在、讀寫失敗），確保程式健壯性
//
//讀寫方式：
//Ivan47 使用逐位元組讀寫（fin.read() 和 fout.write(c)），
//每次處理 1 個位元組，效率較低，適合小檔案或簡單場景。
//Ivan48 使用 4KB 的位元組陣列緩衝區（fin.read(buf) 和 fout.write(buf, 0, len)），
//批量讀寫，減少對底層檔案系統的訪問，適合大檔案（如圖片）。
//性能：
//Ivan48 的執行時間通常比 Ivan47 短，因為批量讀寫減少了 I/O 操作次數。
//例如，複製 1MB 檔案時，Ivan47 可能需要 150 毫秒，Ivan48 可能只需 50 毫秒。
//程式碼結構：
//Ivan48 引入 len 和 buf 變數來管理緩衝區，程式碼稍複雜，但更高效。
//兩者都測量時間並處理異常，功能目標相同。
		}
	}
}
