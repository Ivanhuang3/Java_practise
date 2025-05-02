package ivan666;

import java.util.Scanner;
//引入了 Java 的 Scanner 工具，這個工具可以讓程式讀取使用者在鍵盤輸入的東西。
public class ivan04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("X =");
		int x = scanner.nextInt();
		
		System.out.print("Y =");
		int y = scanner.nextInt();
//Scanner scanner = new Scanner(System.in); 創建了一個 Scanner 物件，
//準備讀取鍵盤輸入。
//System.out.print("X = "); 印出 X = ，提示使用者輸入第一個數字。
//int x = scanner.nextInt(); 讀取使用者輸入的第一個整數，存到變數 x。
//接著一樣的方式，印 Y = ，讀取第二個整數，存到變數 y。
//比如使用者輸入 10 和 3，那 x = 10，y = 3。		
		int var1 = x + y;
		int var2 = x - y;
		int var3 = x * y;
		int var4 = x / y;
		int var5 = x % y;
//程式拿 x 和 y 做五種運算，結果存到五個變數：
//var1：加法，x + y（如 10 + 3 = 13）。
//var2：減法，x - y（如 10 - 3 = 7）。
//var3：乘法，x * y（如 10 × 3 = 30）。
//var4：除法，x / y（如 10 ÷ 3 = 3，因為 x 和 y 是整數，只取整數部分）。
//var5：取餘數，x % y（如 10 ÷ 3 餘 1，因為 10 = 3 × 3 + 1）。
		System.out.printf("%d + %d = %d\n", x, y, var1);
		System.out.printf("%d - %d = %d\n", x, y, var2);
		System.out.printf("%d x %d = %d\n", x, y, var3);
		System.out.printf("%d / %d = %d ... %d\n", x, y, var4, var5);
//System.out.printf 是格式化輸出，會把數字塞進指定的位置：
//%d 是放整數的地方，\n 是換行。
//第一行印 x + y = var1（如 10 + 3 = 13）。
//第二行印 x - y = var2（如 10 - 3 = 7）。
//第三行印 x × y = var3（如 10 × 3 = 30）。
//第四行印 x ÷ y = var4 ... var5（如 10 ÷ 3 = 3 ... 1
//
//nextInt() 是 Scanner 的其中一個功能，專門負責抓取使用者輸入的下一個「整數」。
//當程式執行到 scanner.nextInt()，它會：
//暫停程式，等使用者在鍵 鍵盤輸入一個整數（比如 123 或 -5）。
//把這個整數讀進程式，存到你指定的變數裡。
	}

}
