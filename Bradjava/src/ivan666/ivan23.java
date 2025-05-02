package ivan666;

import ivanapi.Bike;
//程式碼位於 tw.brad.tutor 套件中。
//導入 ivanapi.Bike 類別
//（根據前文，Bike 是一個模擬自行車的類別）。
public class ivan23 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		Bike b2 = new Bike();
		System.out.println(b1 == b2);
//false
//創建兩個 Bike 物件 b1 和 b2，分別通過 new Bike() 實例化。
//使用 == 比較 b1 和 b2，
//檢查它們是否為同一個物件（比較記憶體位址）。
//結果：b1 == b2 返回 false，因為 new Bike() 
//每次創建一個新的物件，b1 和 b2 指向不同的記憶體位址。
//輸出：假設 Bike 的構造函數輸出 "Bike()"，
//則先輸出兩次 "Bike()"，然後輸出 false。
//  關鍵在於new沒string的string pool 
//每次調用 new Bike() 時，Java 會在堆記憶體（heap）中
//分配一個新的 Bike 物件，並返回該物件的記憶體位址。
//因此，b1 = new Bike() 創建了一個 Bike 物件，
//b1 儲存該物件的記憶體位址（例如，假設位址是 0x1000）。
//同樣，b2 = new Bike() 創建了另一個新的 Bike 物件，b2 儲存
//另一個不同的記憶體位址（例如，0x2000）。
		int a = 10, b = 3;
		System.out.println(a == b);
//定義兩個整數變數 a = 10 和 b = 3。
//使用 == 比較它們的值。
//結果：a == b 返回 false，因為 10 不等於 3。
//輸出：false。
		String s1 ="Ivan";
		String s2 ="Ivan";
		System.out.println(s1 == s2);
//創建兩個字串變數 s1 和 s2，都賦值為字面值 "Ivan"。
//使用 == 比較它們的參考。
//結果：s1 == s2 返回 true，
//儲存在Java的 字串池（String Pool）
//機制使得相同的字串字面值共享同一個物件。"Ivan" 
//只在記憶體中創建一次，s1 和 s2 指向同一個物件。
//輸出：true。
		String s3 = new String("Ivan");
		System.out.println(s1 == s3);
//創建一個新的 String 物件 s3，使用 new String("Ivan")。
//使用 == 比較 s1 和 s3。
//結果：s1 == s3 返回 false，因為 new String("Ivan") 
//創建了一個新的 String 物件，與字串池中的 "Ivan"（s1 指向的）不同。
//輸出：false。
		String s4 = new String("Ivan");
		System.out.println(s4 == s3);
//創建另一個新的 String 物件 s4，也是 new String("Ivan")。
//使用 == 比較 s3 和 s4。
//結果：s4 == s3 返回 false，
//因為 new String("Ivan") 每次都創建一個新的物件，
//s3 和 s4 指向不同的記憶體位址。
//輸出：false。
//
//new 關鍵字強制在堆記憶體（heap）中分配一個新的物件，
//獨立於字串池（String Pool）中的 "Ivan"。
//所以兩個new就算名字一樣，記憶體也會不一樣
		System.out.println("---");
		System.out.println(s1.equals(s3));
		System.out.println(s4.equals(s3));
//使用 equals 方法比較字串的內容（而非參考）。
//s1.equals(s3)：檢查 s1（"Ivan"）和 s3（"Ivan"）的內容是否相同。
//s4.equals(s3)：檢查 s4（"Ivan"）和 s3（"Ivan"）的內容是否相同。
//結果：
//s1.equals(s3) 返回 true，因為它們的內容都是 "Ivan"。
//s4.equals(s3) 返回 true，因為它們的內容也都是 "Ivan"。
	}

}
