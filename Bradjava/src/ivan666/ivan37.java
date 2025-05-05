package ivan666;

public class ivan37 {
	public static void main(String[] args) {
		int a = 10 , b=0;
		int c;
		int[] d = {1,2,3,4};
//int a = 10, b = 0;：宣告並初始化兩個整數變數，
//a 設為 10，b 設為 0。b 的值 0 將在後續導致除以零的問題。
//int c;：宣告整數變數 c，但未初始化。它將用於儲存除法結果，
//但由於後續異常，實際上不會被賦值。
//int[] d = {1, 2, 3, 4};：宣告並初始化一個整數陣列 d，
//包含四個元素 {1, 2, 3, 4}，索引範圍為 0 到 3。後續程式試圖存取無效索引 d[10]，但因異常不會執行到該行。
		try {
			c = a / b;
			System.out.println(c);
			System.out.println(d[10]);
			System.out.println("OK");
//try {：開始一個 try 區塊，用於包裝可能拋出異常的程式碼。如果區塊內的程式碼拋出異常，
//程式會跳到相應的 catch 區塊處理。
//c = a / b;：嘗試將 a (10) 除以 b (0)，並將結果存入 c。
//然而，Java 中整數除以零會拋出 ArithmeticException，導致程式立即中斷 try 區塊，跳到 catch 區塊。
//System.out.println(c);：這行試圖印出 c 的值，但因為前一行拋出異常，這行不會執行。
//System.out.println(d[10]);：試圖存取陣列 d 的第 10 個元素（索引 10）。
//由於 d 只有 4 個元素（索引 0 到 3），這會拋出 ArrayIndexOutOfBoundsException。
//但同樣因為前面的異常，這行也不會執行。
//System.out.println("OK");：這行試圖印出 "OK"，但因異常未執行。
		}catch(ArrayIndexOutOfBoundsException e2) {
			System.out.println("B");
		}catch(ArithmeticException e1) {
			System.out.println("A");
		}catch(Exception e3) {
			System.out.println("C");
		}
//catch (ArrayIndexOutOfBoundsException e2)：
//這是第一個 catch 區塊，專門捕獲 ArrayIndexOutOfBoundsException（當存取陣列超出邊界時拋出）。
//由於實際拋出的是 ArithmeticException，這個區塊被跳過，System.out.println("B"); 不會執行。
//catch (ArithmeticException e1)：第二個 catch 區塊，
//捕獲 ArithmeticException（除以零時拋出）。這與 c = a / b;
//拋出的異常匹配，因此執行此區塊，印出 "A"。執行後，程式離開 try-catch 結構，不會檢查後續的 catch 區塊。
//catch (Exception e3)：第三個 catch 區塊，
//捕獲所有 Exception 類型的異常（Exception 是所有異常的父類）。
//因為 ArithmeticException 已被前一個區塊捕獲，這裡的 System.out.println("C"); 不會執行。
//順序重要性：catch 區塊按順序檢查，
//特定異常（如 ArithmeticException）必須放在通用異常（如 Exception）之前，
//否則編譯器會報錯（因為 Exception 會捕獲所有異常，導致後面的區塊無法執行）。
		System.out.println("Game Over");
//System.out.println("Game Over");：這行位於 try-catch 區塊之外，
//無論是否拋出異常或捕獲異常，都會執行。它印出 "Game Over"，表示程式正常結束。
//
//套件與類宣告：組織程式碼並定義程式入口類。
//主方法與變數宣告：設置程式執行起點，初始化變數，為後續操作做準備。
//Try 區塊：執行可能拋出異常的程式碼（除法和陣列存取），但因除以零立即拋出異常。
//Catch 區塊：處理異常，根據異常類型執行對應處理（這裡捕獲 ArithmeticException，印出 "A"）。
//後續程式碼：執行異常處理後的程式碼，確保程式正常結束（印出 "Game Over"）。
	}

}
