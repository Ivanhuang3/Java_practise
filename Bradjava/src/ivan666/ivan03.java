package ivan666;

public class ivan03 {

	public static void main(String[] args) {
		byte var1 = 10;
		byte var2 = 3;
		int var3;
		var3 = var1 +var2;
//byte 是一種很省空間的資料型別，只能存 -128 到 127 之間的整數。
//var1 設成 10，var2 設成 3。
//int 是用來存比較大的整數（範圍比 byte 大很多）。
//var3 是一個 int 變數，拿來存 var1 + var2 的結果。
//計算 var1 + var2，也就是 10 + 3 = 13，然後把 13 存到 var3。
//
//var1 和 var2 都是 byte，為什麼不直接用 byte 存 var3？
//這是因為 Java 在做 byte 的運算（像加法）時，
//會自動把 byte 轉成 int 來計算，結果也會是 int。
//如果你試著寫 byte var3 = var1 + var2;，
//程式會報錯，除非你強制把結果轉回 byte
//（像 byte var3 = (byte)(var1 + var2);）。
//這邊用 int 存 var3 是比較安全的做法，因為 int 能處理更大的數字。
//
//這應該是個教學用的程式，目的可能是：
//讓你認識 byte 型別（一種省空間的整數型別）。
//展示 Java 在做 byte 運算時，會自動把結果轉成 int。
//教你變數宣告和基本加法運算。
	}

}
