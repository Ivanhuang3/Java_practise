package ivan666;

public class ivan12 {

	public static void main(String[] args) {
		int p0, p1, p2, p3, p4, p5, p6;
		p0 = p1 = p2 = p3 =p4 =p5 = p6 = 0;
//宣告七個整數變數 p0, p1, p2, p3, p4, p5, p6，分別用來記錄無效結果（p0）以及點數 1 到 6 的出現次數。
//所有變數初始值設為 0：p0 = p1 = p2 = p3 = p4 = p5 = p6 = 0
		for (int i=0; i<100; i++) {
			int point = (int)(Math.random()*6 + 1);	// 1 - 6
//使用 for 迴圈執行 100 次模擬擲骰子。
//每次迴圈中，透過 Math.random()*6 + 1 
//產生一個隨機整數 point，範圍為 1 到 6，模擬骰子的點數。
//Math.random() 產生 0.0 到 1.0 的隨機數，
//乘以 6 後範圍為 0.0 到 6.0，加上 1 並轉為整數，
//得到 1 到 6 的隨機數。
			switch(point) {
				case 1: p1++; break;
				case 2: p2++; break;
				case 3: p3++; break;
				case 4: p4++; break;
				case 5: p5++; break;
				case 6: p6++; break;
				default: p0++;
//使用 switch 語句根據 point 的值，遞增對應的計數變數：
//如果 point 為 1，p1++；
//如果 point 為 2，p2++；
//以此類推，直到 point 為 6，p6++。
//如果 point 不在 1 到 6 的範圍（理論上不會發生，
//因為 Math.random()*6 + 1 只會產生 1 到 6），則 p0++。
			}
		}
		if (p0 == 0) {
			System.out.printf("1點出現%d次\n", p1);
			System.out.printf("2點出現%d次\n", p2);
			System.out.printf("3點出現%d次\n", p3);
			System.out.printf("4點出現%d次\n", p4);
			System.out.printf("5點出現%d次\n", p5);
			System.out.printf("6點出現%d次\n", p6);
		}else {
			System.out.printf("ERROR: %d", p0);
		}
//		%d 是 printf 格式化輸出的一種「佔位符」，
//		專門用來表示整數（decimal integer）
	}

}
