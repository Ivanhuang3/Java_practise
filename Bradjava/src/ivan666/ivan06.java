package ivan666;

public class ivan06 {

	public static void main(String[] args) {
		char c1 = 65;
		char c2 = 'D';
		char c3 = '資';
		System.out.println(c3);
	}

}
//關於 char 型別：
//在 Java 中，char 是一個 16 位元的 Unicode 字元型別，
//範圍從 0 到 65535（即 2^16 - 1）。
//char 可以用整數（對應 Unicode 編碼）、單引號括住的字元字面值，
//或直接的 Unicode 字元來初始化。
//char c1 = 65;:
//將 c1 初始化為整數 65，對應於 ASCII/Unicode 表中的字元 'A'。
//註解 // 2^16 => 0 - 65535 說明 char 的範圍，表示它可以儲存 0 到 65535 的整數值，對應不同的 Unicode 字元。
//char c2 = 'D';:
//將 c2 初始化為字元 'D'，這是一個字面值表示法。
//在 Unicode/ASCII 中，'D' 對應的數值是 68。
//char c3 = '資';:
//將 c3 初始化為中文漢字 '資'。
//這是一個 Unicode 字元，對應的 Unicode 編碼是 
//\u8cc7（十進制為 36039）。
