package ivan666;

public class ivan15 {

	public static void main(String[] args) {
		int a = 44, b = -7;
//聲明並初始化兩個整數變數 a 和 b，分別賦值為 44 和 -7。
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
//A ^ A = 0（相同值異或為 0）
//A ^ 0 = A（與 0 異或不變）
//A ^ B ^ B = A（因為 B ^ B = 0，
//所以 A ^ 0 = A）
	System.out.printf("a = %d, b = %d\n", a, b);
	System.out.println(3 & 2);
	System.out.println(3 | 2);
	System.out.println(3 ^ 2);
	}
//變數初始化：設置 a = 44, b = -7。
//XOR 交換：用位元運算交換 a 和 b 的值。
//輸出交換結果：確認 a = -7, b = 44。
//AND 運算：展示 3 & 2 = 2。
//OR 運算：展示 3 | 2 = 3。
//XOR 運算：展示 3 ^ 2 = 1。
}
