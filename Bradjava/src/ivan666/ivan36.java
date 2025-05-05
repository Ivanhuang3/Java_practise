package ivan666;

import java.util.HashMap;
import java.util.Set;
//import java.util.HashMap;：導入 HashMap 類別，用於創建鍵值對的集合。
//import java.util.Set;：導入 Set 類別，用於儲存 HashMap 的鍵集合
public class ivan36 {

	
	public static void main(String[] args) {
		HashMap<String, Object> person = new HashMap<String, Object>();
//創建一個 HashMap 物件 person，鍵的型別是 String，值的型別是 Object（可以儲存任意型別的值）。
//HashMap 是一種鍵值對結構，鍵必須唯一，值可以重複。
		person.put("name", "Brad");
//新增鍵值對，鍵為 "name"，值為 "Brad"（字串）。
		person.put("gender", true);
//新增鍵值對，鍵為 "gender"，值為 true（布林值）。
		person.put("age", 18);
//新增鍵值對，鍵為 "age"，值為 18（整數，會自動裝箱為 Integer）。
		person.put("w", 79.7);
//新增鍵值對，鍵為 "w"，值為 79.7（浮點數，會自動裝箱為 Double）。
		System.out.println(person.size());
//輸出 person 中的鍵值對數量。此時有 4 個鍵值對，輸出：4。
		person.put("age", 28);
//使用已存在的鍵 "age" 放入新值 28。
//HashMap 不允許重複鍵，因此這會覆蓋原有的值 18。
		System.out.println(person.size());
//再次輸出鍵值對數量。
//因為只是更新 "age" 的值，鍵數量未變，仍然輸出：4。
		person.put("alias", "Brad");
//新增一個新的鍵值對，鍵為 "alias"，值為 "Brad"。
		System.out.println(person.size());
//輸出鍵值對數量。
//新增了一個鍵值對，總數變為 5，輸出：5。
		System.out.println("---");
		Set<String> keys = person.keySet();
//調用 keySet() 方法，取得 person 中所有鍵的集合，儲存在 Set<String> 物件 keys 中。
//Set 是一個不允許重複元素的集合，適合儲存 HashMap 的鍵。
		for (String key : keys) {
//使用增強型 for 迴圈遍歷 keys 中的每個鍵。
			System.out.println(key + ":" + person.get(key));
//對於每個鍵，輸出格式為 鍵:值。
//使用 person.get(key) 取得對應鍵的值。
//
//這段程式碼模擬使用 HashMap 儲存一個人的多種屬性（姓名、性別、年齡、體重、別名）。
//			展示了以下 HashMap 操作：
//			新增鍵值對（put）。
//			更新已有鍵的值（put 覆蓋）。
//			取得鍵值對數量（size）。
//			取得所有鍵（keySet）。
//			遍歷鍵並取得對應值（get）。
//			最終輸出所有鍵值對，顯示人的完整資訊。
//
//第一行：初始新增 4 個鍵值對，輸出 4。
//			第二行：更新 "age" 的值，鍵數量不變，輸出 4。
//			第三行：新增 "alias"，鍵數量增為 5，輸出 5。
//			分隔線後：遍歷所有鍵，輸出每個鍵及其對應值。
//			注意：HashMap 不保證鍵的順序，因此輸出的鍵值對順序可能與插入順序不同。
	  }
   }
}
