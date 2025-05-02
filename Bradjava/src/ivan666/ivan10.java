package ivan666;

public class ivan10 {

	public static void main(String[] args) {
// 1. 宣告並初始化變數
// i 將作為 for 迴圈的計數器，用來控制迴圈次數和輸出內容。
		int i = 0;		
		for (printBrad(); i<10 ; printLine()) {
			System.out.println(i++);
		}
// 2. for 迴圈
// 這是一個 for 迴圈，結構是 for (初始化; 條件; 更新)，但這裡的「初始化」和「更新」部分用了自訂方法 printBrad() 和 printLine()，而不是常見的變數操作。
// 讓我們分解這段迴圈：
//	a. 初始化：printBrad()
//	printBrad() 是一個自訂的靜態方法（後面會解釋），它會印出 "Brad"。
//	在迴圈開始前，printBrad() 會先被呼叫一次，作為初始化的動作。
//	b. 條件：i < 10
//	這是迴圈的繼續條件：只要 i 小於 10（也就是 i 是 0 到 9），
//	迴圈就繼續跑。
//	當 i 變成 10 時，條件 i < 10 變成 false，迴圈停止。
//	c. 更新：printLine()
//	printLine() 是另一個自訂的靜態方法，會印出 "------"。
//	每次迴圈結束後，printLine() 會被呼叫，作為更新的動作。
//	d. 迴圈內容：System.out.println(i++);
//	每次迴圈，程式會印出 i 的當前值，然後把 i 加 1
//	（i++ 是先用 i 的值，然後再把 i 增加 1）。
//	例如，第一次迴圈時，i 是 0，印出 0，然後 i 變成 1。

		System.out.println("===");
// 4. 印出 i 的最終值
		System.out.println(i);
	}
// 5. 自訂方法 printBrad
//這是一個靜態方法（static），名叫 printBrad。
//它不接受任何參數（void），執行時只做一件事：印出 "Brad" 並換行。
//這個方法被用在 for 迴圈的初始化部分。
	static void printBrad() {
		System.out.println("Brad");
	}
//這是另一個靜態方法，名叫 printLine。
//它同樣不接受參數，執行時印出 "------" 並換行。
//這個方法被用在 for 迴圈的更新部分。
	static void printLine() {
		System.out.println("-----");
	}
}
