package ivan666;

import ivanapi.Bike;

public class Ivan16 {
	
	public static void main(String[] args) {
			Bike bike;
	//宣告一個 Bike 類型的變數 bike，尚未初始化。
			bike = new Bike();
	//創建一個 Bike 物件，調用其無參數建構子。(初始化)
	//分配記憶體：new 關鍵字在堆記憶體（heap）中為 Bike 物件分配記憶體。
	//調用建構子：調用 Bike 類別的無參數建構子（public Bike()），
	//初始化物件的內部狀態（例如設定屬性）。
	//賦值：將新創建的 Bike 物件的參考（記憶體位址）賦給變數 bike。
			bike.upSpeed();bike.upSpeed();bike.upSpeed();
			bike.upSpeed();bike.upSpeed();bike.upSpeed();
			bike.upSpeed();bike.upSpeed();bike.upSpeed();
	//第一次：speed = 0.0 < 1，所以 speed = 1.0。
	//第二次：speed = 1.0 ≥ 1，所以 speed = 1.0 * 1.2 = 1.2。
	//第三次：speed = 1.2 ≥ 1，所以 speed = 1.2 * 1.2 = 1.44。
	//bike.upSpeed();bike.upSpeed();bike.upSpeed();（後三次）：
	//第四次：speed = 1.44 ≥ 1，所以 speed = 1.44 * 1.2 = 1.728。
	//第五次：speed = 1.728 ≥ 1，所以 speed = 1.728 * 1.2 = 2.0736。
	//第六次：speed = 2.0736 ≥ 1，所以 speed = 2.0736 * 1.2 = 2.48832。
			System.out.println(bike.getSpeed());
			bike.downSpeed();bike.downSpeed();
			System.out.println(bike.getSpeed());
			System.out.println("----");
			System.out.println(bike.getSpeed());
		}

	}


