package ivan666;

import ivanapi.TWId;
//程式碼位於 tw.brad.tutor 套件中。
//導入了 ivanapi.TWId 類別，
//這個類別應該是用來生成、驗證或處理台灣身份證號的工具。
public class ivan25 {

	public static void main(String[] args) {
		if(TWId.checkTWId("A123456789")) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
//呼叫 TWId 類別的靜態方法 checkTWId，傳入字串 "A123456789"，
//檢查這個字串是否為有效的台灣身份證號。
//如果有效，輸出 "OK"；否則輸出 "XX"。
//說明：台灣身份證號有特定的格式（1 個字母 + 9 個數字）與檢查規則
//（例如加權計算檢查碼）。checkTWId 方法應該會驗證輸入是否符合這些規則。
		System.out.println("---");
//輸出 "----"，作為不同功能區塊的視覺分隔。
		TWId id1 = new TWId();
		TWId id2 = new TWId(false);
		TWId id3 = new TWId('X');
		TWId id4 = new TWId(true, 'R');
		System.out.println(id1.getId());
		System.out.println(id2.getId());
		System.out.println(id3.getId());
		System.out.println(id4.getId());
//這裡展示了 TWId 類別的多種構造函數，生成不同的身份證號，並輸出它們：
//id1 = new TWId()：無參數構造函數，可能隨機生成一個身份證號。
//id2 = new TWId(false)：傳入一個布林值 false，可能表示生成女性（或特定性別）的身份證號。
//id3 = new TWId
//傳入字元 'X'，可能表示生成以字母 'X' 開頭的身份證號（例如台北市）。
//id4 = new TWId(true, 'R')：傳入布林值 true（可能表示男性）
//與字元 'R'，生成以 'R' 開頭的身份證號（例如台南市）。
//每個 TWId 物件的 getId() 方法返回生成的身份證號字串，並輸出到控制台。
		System.out.println("-----");
		TWId id5 = TWId.createTWId("A123456789");
		if (id5 != null) {
			System.out.println(id5.getId());
		}else {
			System.out.println("XX");
//呼叫 TWId 類別的靜態方法 createTWId，傳入字串 "A123456789"，
//嘗試創建一個 TWId 物件。
//如果創建成功（id5 != null），輸出身份證號；否則輸出 "XX"。
//說明：createTWId 方法應該會先驗證輸入的身份證號是否有效
//（類似 checkTWId），如果有效則返回一個 TWId 物件，否則返回 null。
		}
//這段程式碼展示了 TWId 類別的功能，包括：
//驗證身份證號：使用 checkTWId 方法檢查給定的身份證號是否合法。
//生成身份證號：通過多種構造函數生成隨機或特定條件的身份證號
//（例如指定性別或地區）。
//從字串創建物件：使用 createTWId 方法
//將有效的身份證號字串轉換為 TWId 物件。
//輸出結果：將生成的身份證號或驗證結果輸出到控制台。
	}
}
