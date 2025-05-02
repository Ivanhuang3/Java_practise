package ivan666;

public class ivan02 {

	public static void main(String[] args) {
		byte var1;
		var1 = 126;
//byte 是一種很省空間的整數型別，範圍是 -128 到 127。
//var1 是 byte 型別的變數，設成 126
//（這已經很接近 byte 的上限 127）。
		System.out.println(var1);
		var1++;
//var1++ 表示把 var1 的值加 1，等於 var1 = var1 + 1。
//所以 126 + 1 = 127，var1 變成 127。
//印出 127。
		System.out.println(var1);
		var1++;
		System.out.println(var1);
//再把 var1 加 1，現在 127 + 1 = 128。
//但問題來了！byte 的範圍只有 -128 到 127，128 超出上限。
//Java 的 byte 會「溢位」（overflow），
//從最大值 127 跳到最小值 -128。
//所以 var1 變成 -128，然後印出 -128。
	}

}
