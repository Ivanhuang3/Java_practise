package ivan666;

import java.util.HashSet;
import java.util.Iterator;
import ivanapi.Bike;
//java.util.HashSet：導入 HashSet 類，
//HashSet 是 Java 集合框架中的一個實現 Set 接口的類，
//用於儲存不重複的元素，無序。
//java.util.Iterator：導入 Iterator 接口，用於遍歷集合中的元素。
//ivanapi.Bike：導入自定義的 Bike 類，
//這個類可能表示一個自行車物件，用於展示 HashSet 儲存自定義物件的能力。
public class ivan32 {

	public static void main(String[] args) {
		HashSet set = new HashSet();
//HashSet set = new HashSet();：創建一個 HashSet 物件，
//用於儲存元素。HashSet 不保證元素順序，且不允許重複元素。
		set.add("ivan");
		set.add(new Bike());
//set.add("ivan");：添加字串 "ivan" 到集合中。
//HashSet 接受任何 Object 類型的元素（這裡是 String）。
//set.add(new Bike());：添加一個新創建的 Bike 物件
//（假設 Bike 是自定義類）。
		System.out.println(set.size());
//System.out.println(set.size());：輸出集合大小，
//此時有 2 個元素（"ivan" 和 Bike 物件），輸出：2。
		set.add("ivan");
		System.out.println(set.size());
//set.add("ivan");：再次添加 "ivan"。
//由於 HashSet 不允許重複元素（根據 equals 和 hashCode 方法判斷），
//這不會增加新元素。
//System.out.println(set.size());：大小仍為 2，輸出：2。
		set.add(123);
		System.out.println(set.size());
//set.add(123);：添加整數 123。
//Java 會自動將 int 裝箱（auto-boxing）為 Integer 物件。
//System.out.println(set.size());：大小增加到 3，輸出：3。
		set.add(12.3);  
		System.out.println(set.size());
//set.add(12.3);：添加浮點數 12.3。
//Java 將 double 裝箱為 Double 物件。
//System.out.println(set.size());：
//大小增加到 4，輸出：4。
		set.add(123);
		System.out.println(set.size());
//set.add(123);：再次添加 123。
//由於 Integer 的 equals 方法認為這與之前的 123 相同，
//不會添加新元素。
//System.out.println(set.size());：
//大小仍為 4，輸出：4。
//
//HashSet 使用元素的 hashCode 和 equals 方法判斷是否重複。
//字串 "Brad" 和 Integer(123) 的重複被正確識別。
//Bike 物件是否視為重複取決於其 equals 和 hashCode 方法的實現
//（程式碼中未顯示 Bike 類定義，假設每次 new Bike() 創建不同物件）。
//自動裝箱（auto-boxing）允許基本類型（int、double）
//作為物件添加到集合中。
		System.out.println("----");
		System.out.println(set);
//System.out.println("----");：輸出分隔線 "----"，
//用於區分不同部分的輸出。
//System.out.println(set);：
//直接輸出集合的內容。HashSet 的 toString 方法會將所有元素格式化為 
//[元素1, 元素2, ...] 的形式。	
		Iterator it = set.iterator();
		while (it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
//這段程式碼展示如何使用 Iterator 遍歷 HashSet 中的元素。
//具體功能：
//Iterator it = set.iterator();：
//獲取 HashSet 的迭代器物件，用於逐一訪問集合中的元素。
//while (it.hasNext() 
//{：檢查是否還有下一個元素（hasNext 返回 true 表示還有元素）。
//Object obj = it.next();：
//獲取下一個元素，儲存在 obj 中。
//next 方法返回 Object 類型，因為 HashSet 儲存任意物件。
//System.out.println(obj);：輸出當前元素。
//
//Iterator 是一種傳統的遍歷方式，適用於任何 Java 集合。
//由於 HashSet 無序，輸出的元素順序無法預測。
		System.out.println("----");
		for (Object obj : set) {
			System.out.println(obj);
//這段程式碼展示使用增強型 for 迴圈（for-each）
//遍歷 HashSet，這是更簡潔的現代遍歷方式。
//具體功能：
//System.out.println("----");：輸出分隔線。
//for (Object obj : set) {：遍歷 set 中的每個元素，
//將當前元素賦值給 obj（類型為 Object）。
//System.out.println(obj);：輸出當前元素。
		}
	}
}

//	什麼是 HashSet？
//HashSet 是 Java 集合框架中的一個類，位於 java.util 包中，
//實現了 Set 接口。它用於儲存一組不重複的元素，且元素之間沒有固定順序。
//簡單來說，HashSet 就像一個裝東西的袋子，裡面的東西不會重複，
//拿出來時順序也不固定。
//
//遍歷（英文：traverse 或 iteration）在程式設計中，
//指的是逐一訪問或處理一個集合（如清單、陣列、集合等）中的每個元素。
//簡單來說，就是把集合裡的東西一個一個拿出來檢查或操作。
//
//使用了 HashSet 來儲存元素（"ivan"、 Bike 物件、 123、 12.3），
//並展示了兩種遍歷方式：
//
//Iterator it = set.iterator();
//while (it.hasNext()) {
//    Object obj = it.next();
//    System.out.println(obj);
//}
//
//白話解釋：
//Iterator 像一個機器人幫你從籃子（HashSet）裡拿東西。
//it.hasNext() 問：「籃子裡還有東西嗎？」
//it.next() 說：「好，我拿下一個給你！」
//你拿到東西（obj）後，印出來（System.out.println(obj)）。
//這個過程會把籃子裡的每顆水果（元素）都拿出來一次。
//
//使用增強型 for 迴圈遍歷
//for (Object obj : set) {
//System.out.println(obj);
//}
//
//白話解釋：
//這就像你直接伸手進籃子，一次拿一個水果出來。
//for (Object obj : set) 說：「從籃子（set）裡每次拿一個東西，
//放到 obj 裡。」
//然後你把拿到的東西印出來。
//這方式比 Iterator 簡單，就像直接翻籃子裡的東西。
//
//遍歷通常用來：
//
//查看元素：檢查集合裡有什麼（像你的程式碼，把元素印出來）。
//處理元素：對每個元素做操作（例如計算總和、修改值、過濾特定元素）。
//統計資訊：數數有多少元素，或找某個特定元素。
//為什麼需要遍歷？
//集合（像 HashSet）裡的元素通常有很多，直接操作全部元素很麻煩。
//遍歷提供了一個有條理的方式，讓你能一個一個處理，不漏掉也不重複。