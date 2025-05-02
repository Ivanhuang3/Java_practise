package ivan666;

public class ivan21 {

	public static void main(String[] args) {
		byte b = 1;
		ivan213 obj = new ivan213(b);
	}
}
//這就像一個老闆（main 方法），負責下命令開始蓋房子。
//老闆先準備了一塊材料 b，是一個 byte 型別的 1（就像給工人一塊特定尺寸的磚頭）。
//然後老闆說：「用這塊磚頭，去叫 ivan213 來蓋房子！」（new ivan213(b)）。
//這段的任務就是啟動蓋房子的流程，指定用 byte 型別的材料，讓 ivan213 開始工作。
class ivan211 extends object{
	ivan211(String a){
		
	}
}
//Brad211 是房子的第一層（最基礎的部分），它繼承自 Object，
//就像地基靠著土地（Object 是 Java 所有類別的祖宗）。
//這層只有一個工人（建構子 Brad211(String a)），
//專門處理 String 型別的材料（像是需要一張藍圖）。
//這個工人沒幹什麼具體的活，只是說：「好，我收到藍圖（String a），
//我先把地基（Object）弄好！」
//這層很簡單，沒印任何東西，純粹是為了讓上層能繼續蓋。
class ivan212 extends ivan211{
	ivan212(int a){
		super("");
		System.out.println("ivan212");
	}
}
//Brad212 是房子的第二層，蓋在第一層（Brad211）上面。
//這層也只有一個工人（建構子 Brad212(int a)），
//專門處理 int 型別的材料（像是需要一個數字，告訴他蓋多高）。
//這個工人開始工作前，先喊第一層的工人來幫忙，
//給了一張空的藍圖（super("")，調用 Brad211 的建構子，傳入空字串）。
//第一層蓋好後，這個工人蓋完自己的第二層，然後大喊：「第二層蓋好了！」（印出 Brad212）。
//這段的重點是：第二層依賴第一層，蓋完後會留個記錄（印 Brad212）。
class ivan213 extends ivan212{
	ivan213(){
		super(1);
		System.out.println("A");
	}
	ivan213(int a){
		super(1);
		System.out.println("B");
	}
	ivan213(byea a){
		super(1);
		System.out.println("C");
	}
	ivan213(double a){
		super(1);
		System.out.println("D");
	}
}
//Brad213 是房子的第三層（最頂層），蓋在第二層（Brad212）上面。
//這層很厲害，有四個工人（四個建構子），可以處理不同材料：
//無參數（Brad213()）：沒給材料時用，蓋完印「A」。
//int 型別（Brad213(int a)）：給數字時用，蓋完印「B」。
//byte 型別（Brad213(byte a)）：給小數字（像 byte）時用，蓋完印「C」。
//double 型別（Brad213(double a)）：給小數時用，蓋完印「D」。
//每個工人開始工作前，都會喊第二層的工人來幫忙，給他一個數字 1（super(1)，
//調用 Brad212 的建構子）。
//在這次程式中，老闆給的是 byte 型別的 1，所以會挑 Brad213(byte a) 這個工人：
//他先喊第二層工人（super(1)），讓第二層蓋好。
//然後自己蓋第三層，蓋完大喊：「第三層蓋好了！」（印出 C）。
//這段的重點是：第三層有很多選擇（多個建構子），但這次用的是 byte 的工人，結果會印 C。
//
//整個流程像什麼
//老闆（main）說：「用 byte 的 1 蓋房子！」（new Brad213(b)）。
//第三層的 byte 工人（Brad213(byte a)）被叫來，
//說：「我要蓋第三層，但先讓第二層蓋好！」（super(1)）。
//第二層工人（Brad212(int a)）被叫來，
//說：「我要蓋第二層，但先讓第一層蓋好！」（super("")）。
//第一層工人（Brad211(String a)）蓋好第一層（沒啥動靜）。
//第二層工人蓋好第二層，喊：「第二層好了！」（印 Brad212）。
//第三層工人蓋好第三層，喊：「第三層好了！」（印 C）。
//
//來源：super(1) 裡的 1 是一個硬編碼的 int 字面值，直接寫在 Brad213 的建構子中，由程式設計者決定。
//作用：它用來調用父類 Brad212 的建構子 Brad212(int a)，傳遞 1 作為參數。
//為什麼是 1：可能是為了簡化程式邏輯、確保一致性，或作為教學範例展示建構子鏈。
//Brad212 建構子並未使用這個 1，所以它的具體值對輸出沒有影響。
//與參數的關係：1 與 Brad213 建構子的參數（例如 byte a）無關，
//即使 a = 1，程式也未使用 a 來調用 super()