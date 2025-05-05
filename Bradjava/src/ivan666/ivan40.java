package ivan666;

public class ivan40 {

	public static void main(String[] args) {
		m1();
		System.out.println("Finish");
//m1();：呼叫靜態方法 m1()，啟動程式的主要邏輯。
//System.out.println("Finish");：在 m1() 執行完畢後，輸出字串 "Finish" 到控制台。
	}
	static void m1() {
		int a = 10, b = 0;
//m1() 方法：
//這是一個靜態方法（static），
//因此可以直接通過類別名稱或在 main 方法中直接呼叫（無需創建物件）。
//方法簽名 void 表示它不返回任何值。
//變數宣告：
//int a = 10, b = 0; 宣告並初始化兩個整數變數：
//a 的值為 10。
//b 的值為 0。
//這些變數將在後續的 try 塊中用於除法運算。
//意義：
//m1() 是程式的主要邏輯執行方法，負責執行除法運算並處理可能的例外。
//將 b 設為 0 是故意設計的，用來模擬除以零的錯誤，從而觸發例外。
		try {
			System.out.println(a /b);
//try 塊：
//try 塊用來包裹可能拋出例外的程式碼。
//System.out.println(a / b); 嘗試計算 a / b（即 10 / 0）並輸出結果。
//除以零的問題：
//在 Java 中，當整數除以零（10 / 0）時，
//會拋出 ArithmeticException，這是 Exception 的子類。
//因此，這行程式碼會觸發一個例外，導致程式跳出 try 塊，進入對應的 catch 塊。
//意義：
//try 塊模擬了一個可能失敗的操作（除以零），這是程式設計中常見的錯誤場景。
//它的目的是測試例外處理機制，讓程式能夠在錯誤發生時執行備用邏輯，而不是直接崩潰。		
		}catch(Exception e) {
			System.out.println("XX");
			return;
//catch 塊：
//catch (Exception e) 捕捉 try 塊中拋出的任何 Exception
//（或其子類，例如 ArithmeticException）。
//當 try 塊中的 a / b 拋出 ArithmeticException 時，程式會跳到這個 catch 塊執行。
//處理邏輯：
//System.out.println("XX");：輸出字串 "XX"，表示程式捕捉到了例外並執行了錯誤處理邏輯。
//return;：這是一個重要的語句，表示立即結束 m1() 方法的執行，
//並返回到呼叫 m1() 的地方（即 main 方法）。這意味著 m1() 方法中後續的程式碼
//（包括 finally 塊之後的程式碼）不會被執行。
//意義：
//catch 塊展示了如何處理程式中的錯誤（這裡是除以零）。
//輸出 "XX" 表示程式檢測到錯誤並採取了行動（雖然只是簡單的輸出）。
//return 語句顯示了如何在捕捉例外後提前終止方法執行，這在某些場景下用來避免進一步的錯誤操作。
		}finally {
			System.out.println("finally");
		}
//finally 塊：
//finally 塊是 try-catch 結構的一部分，無論 try 塊是否拋出例外，
//或者 catch 塊是否執行 return，finally 塊中的程式碼 總是會執行。
//在這裡，finally 塊執行 System.out.println("finally");，輸出字串 "finally"。
//行為細節：
//即使 catch 塊中的 return 語句試圖結束 m1() 方法，finally 塊仍然會在方法返回之前執行。
//這是 Java 中 finally 塊的特性，用來確保某些清理操作（例如關閉檔案或釋放資源）總能執行。
//意義：
//finally 塊展示了 Java 例外處理中確保程式碼執行的機制。
//它模擬了在真實應用中必須執行的清理工作，例如關閉資料庫連線或檔案流。
//輸出 "finally" 證明即使方法提前返回，finally 塊仍然會執行。
		System.out.println("End");
//結尾程式碼：
//System.out.println("End"); 是 m1() 
//方法中 try-catch-finally 結構之後的程式碼，預期輸出字串 "End"。
//但是，由於 catch 塊中的 return 語句，這個程式碼 不會被執行。
//當 catch 塊執行 return 時，m1() 方法會在執行 finally 塊後立即結束，跳過後續的程式碼。
//意義：
//這段程式碼展示了 return 語句如何影響方法的執行流程。
//它提醒程式設計者，catch 塊中的 return 會導致方法提前終止，
//因此需要小心設計程式邏輯，以確保必要的後續程式碼能夠執行。
//
//程式從 main 方法開始，呼叫 m1()。
//在 m1() 中：
//宣告 a = 10, b = 0。
//進入 try 塊，嘗試計算 10 / 0，觸發 ArithmeticException。
//跳到 catch 塊，輸出 "XX"，然後執行 return。
//在 return 之前，執行 finally 塊，輸出 "finally"。
//因為 return，m1() 方法結束，跳過 System.out.println("End");。
//返回到 main 方法，執行 System.out.println("Finish");。
	}

}
