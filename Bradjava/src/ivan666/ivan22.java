package ivan666;

import ivanapi.Bike;
import ivanapi.Scooter;

public class ivan22 {
	private static String upspeed;

	public static void main(String[] args) {
		String s1 =" Ivan";
		String s2 = new String();
		byte[] bs = {97,98,99,100};
		String s3 = new String(bs);
		String s4 = new String(bs, 1, 2);
		String s5 = new String("Ivan");
		System.out.println(s1);
//s1 = "Ivan"：直接使用字串字面量初始化，內容為 "Ivan"。
//s2 = new String()：
//創建一個空的 String 物件（內容為空字串 ""）。
//bs = {97, 98, 99, 100}：定義一個位元組陣列，
//對應 ASCII 碼（97='a', 98='b', 99='c', 100='d'）。
//s3 = new String(bs)：將位元組陣列轉換為字串，
//結果為 "abcd"（所有位元組轉為對應字元）。
//s4 = new String(bs, 1, 2)：從位元組陣列的索引 1 開始，
//取 2 個位元組（98, 99），結果為 "bc"。
//s5 = new String("Ivan")：使用字串字面量 "Ivan" 
//創建一個新的 String 物件，內容也是 "Ivan"。
		System.out.println("---");
		Bike b1 = new Bike();
//Bike b1 = new Bike();：創建一個 Bike 類別的物件 b1。
//假設 Bike 類別有無參數建構子和一個 speed 屬性
//（可能初始化為 0），並有 upSpeed 方法。
		System.out.println(b1);
//		輸出 b1 物件的字串表示。
		b1.upSpeed();b1.upSpeed();
		b1.upSpeed();b1.upSpeed();
//		b1.upSpeed(); 被連續呼叫 4 次。
		upspeed = b1.upSpeed;b1.upSpeed();
//假設 Bike 的 upSpeed 方法定義為類似 speed = speed < 1 ? 1 : speed * 1.2;（根據常見範例，父類加速較慢，例如每次增加 20%）。
//		假設初始 speed = 0：
//		第 1 次：speed = 1（因為 speed < 1）。
//		第 2 次：speed = 1 * 1.2 = 1.2。
//		第 3 次：speed = 1.2 * 1.2 = 1.44。
//		第 4 次：speed = 1.44 * 1.2 = 1.728。
		System.out.println(b1);
//		再次輸出 b1 的字串表示。

		System.out.println("---");
		Scooter s6 = new Scooter();
		System.out.println(s6);
//Scooter s6 = new Scooter();：
//創建一個 Scooter 類別的物件 s6。
//根據之前的 Scooter 程式碼，建構子會輸出 "Scooter()" 到控制台。
//Scooter 繼承自 Bike，因此也繼承了 speed 屬性（可能初始化為 0）。
//System.out.println(s6);：輸出 s6 的字串表示。
//如果 Scooter 沒有覆寫 toString，
//則使用 Bike 的 toString 方法（例如輸出 speed 值，如 0.0）。
//如果 Bike 也未覆寫 toString，
//則輸出類似 tw.brad.apis.Scooter@<hashcode>。
	}
}