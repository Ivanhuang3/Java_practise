package ivan666;

public class ivan38 {
	public static void main(String[] args) {
		Bird b1 = new Bird();
		try {
			b1.setLeg(-2);
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println("XX");
//public static void main(String[] args)：程式的入口方法，
//Java 程式從這裡開始執行。String[] args 用於接收命令列參數。
//Bird b1 = new Bird();：創建一個 Bird 類的實例 b1，
//表示一隻鳥。此時，b1 的 leg 屬性（在 Bird 類中定義）預設為 0（Java 整數成員變數的預設值）。
//try {：開始一個 try 區塊，包裝可能拋出異常的程式碼。
//b1.setLeg(-2);：呼叫 b1 的 setLeg 方法，傳入參數 -2，試圖設置鳥的腿數。
//setLeg 方法可能拋出 Exception（由於其方法簽名中有 throws Exception）。
//System.out.println("OK");：如果 setLeg(-2) 成功（未拋出異常），
//這行會印出 "OK"。但在本例中，這行不會執行，因為後續會拋出異常。
//catch (Exception e)：捕獲 try 區塊中拋出的 Exception 類型異常。
//Exception 是所有異常的父類，因此能捕獲 setLeg 方法拋出的 Exception。
//當異常被捕獲時，執行 System.out.println("XX");，印出 "XX"。
//執行流程：setLeg(-2) 會因無效參數（-2 不符合條件）拋出 Exception，
//導致 try 區塊中斷，跳到 catch 區塊，印出 "XX"。因此，"OK" 不會被印出。
		}

	}
}
class Bird{
	int leg;
	void setLeg(int n) throws Exception{
		if(n>=0 && n<=2) {
			leg = n;
		}else {
			throw new Exception();
//class Bird {：定義一個 Bird 類，表示鳥的物件模型。
//int leg;：宣告一個整數成員變數 leg，用於儲存鳥的腿數。
//未初始化時，預設值為 0（Java 成員變數預設規則）。
//void setLeg(int n) throws Exception 
//定義 setLeg 方法，接受一個整數參數 n，用於設置 leg 的值。
//方法簽名中的 throws Exception 表示此方法可能拋出 Exception，
//呼叫者必須處理此異常（透過 try-catch 或繼續拋出）。
//
//if (n >= 0 && n <= 2)：檢查輸入參數 n 是否在有效範圍（0 到 2）。
//這模擬鳥的腿數應為非負且不超過 2（例如，鳥通常有 0 到 2 條腿）。
//如果條件成立，執行 leg = n;，將 leg 設為 n。
//else { throw new Exception(); }：如果 n 不在有效範圍（小於 0 或大於 2），
//拋出一個新的 Exception 物件，無具體錯誤訊息。這會中斷方法執行，
//異常被傳遞到呼叫者（main 方法的 try-catch）。
//在本例中：setLeg(-2) 被呼叫，-2 不滿足 n >= 0 && n <= 2，
//因此進入 else 分支，拋出 Exception，導致異常被 main 方法的 catch 區塊捕獲。
//程式輸出
		}
	}
}
//核心概念
//1.檢查型異常（Checked Exception）：
//setLeg 方法聲明 throws Exception，表示它可能拋出檢查型異常。
//檢查型異常（非 RuntimeException 的子類）要求呼叫者必須處理（透過 try-catch 或繼續 throws）。
//在本例中，main 方法使用 try-catch 處理了 Exception。
//注意：這裡使用通用的 Exception 類並不理想，因為它缺乏具體性（見改進建議）。
//2.異常處理流程：
//當 setLeg(-2) 拋出異常時，try 區塊立即中斷，程式跳到匹配的 catch 區塊。
//catch (Exception e) 捕獲異常後，執行其程式碼，然後繼續執行 try-catch 外的程式碼
//（在本例中，main 方法已無其他程式碼）。
//3.物件導向設計：
//Bird 類封裝了鳥的屬性（leg）和行為（setLeg），透過異常機制確保資料有效性（腿數在 0 到 2 之間）。
//main 方法創建 Bird 實例並與之互動，展示物件導向的基本應用。