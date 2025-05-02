package ivan666;

import ivanapi.Scooter;
//package tw.brad.tutor;：
//指定當前類別 Brad17 屬於 tw.brad.tutor 套件，用於組織程式碼。
//import tw.brad.apis.Scooter;：
//匯入位於 tw.brad.apis 套件的 Scooter 類別，
//允許程式使用 Scooter 類別來創建機車物件。
public class ivan17 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
//Scooter s1 = new Scooter();：
//創建一個 Scooter 類別的實例 s1，調用其無參數建構子來初始化機車物件。
		System.out.println(s1.getSpeed());
//System.out.println(s1.getSpeed());：
//調用 s1 的 getSpeed 方法，取得當前速度並印到控制台。
//假設這是新創建的機車，初始速度可能是 0（取決於 Scooter 類別的實現）。
		s1.upSpeed();
		s1.upSpeed();
		s1.upSpeed();
//s1.upSpeed();：連續三次調用 upSpeed 方法，模擬機車加速。
//每次調用可能會將速度增加一個特定的值（例如，每次增加 10 單位，
//具體取決於 Scooter 類別的實現）。
		System.out.println(s1.getSpeed());
//System.out.println(s1.getSpeed());：
//再次調用 getSpeed 方法，取得加速後的當前速度並印到控制台。
	}

}
