package ivan666;

public class ivan39 {
	public static void main(String[] args) {
		ivan391 obj = new ivan391();
		obj.m1();
//創建了一個 ivan391 類別的物件 obj。這表示程式將使用 ivan391 類別中定義的方法。
//obj.m1();：呼叫 obj 物件的 m1() 方法，啟動後續的程式邏輯。
	}
}
class ivan391{
	void m1() {
		System.out.println("m1");
		try {
			m2();
		}catch (Exception e) {
	}
}
//m1() 是方法呼叫鏈的起點，負責呼叫 m2()。
//使用 try-catch 塊顯示了例外處理的基本結構，
//但空的 catch 塊意味著即使發生錯誤，程式也不會顯示或記錄任何錯誤資訊，
//這在實際開發中是不推薦的做法。
//這段程式碼模擬了「靜默」處理例外的情況，程式會繼續運行而不出現錯誤訊息。
	void m2() throws Exception{
		System.out.println("m2");
		m3();
	}
//m2() 作為中間層，負責將執行流程從 m1() 傳遞到 m3()。
//它的 throws Exception 聲明表明它不負責處理 m3() 可能引發的錯誤，
//而是將責任交給上層方法（m1()）。
	void m3() throws Exception{
		System.out.println("m3");
		throw new Exception();
//m3() 是例外產生的源頭，模擬了某個操作失敗或錯誤的情況（例如，檔案讀取失敗、網路連線中斷等）。
//它展示了如何在程式碼中主動拋出例外，並通過 throws 將處理責任交給上層方法。
	}
}
//程式從 main 方法開始，創建 Brad391 物件並呼叫 m1()。
//m1() 輸出 "m1"，然後呼叫 m2()。
//m2() 輸出 "m2"，然後呼叫 m3()。
//m3() 輸出 "m3"，然後拋出 Exception。
//例外從 m3() 傳到 m2()，再傳到 m1()。
//m1() 的 try-catch 塊捕捉到例外，
//但因為 catch 塊是空的，程式不執行任何錯誤處理，繼續完成執行。