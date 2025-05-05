package ivan666;

import java.util.LinkedList;
//導入 LinkedList 類別，用於創建和操作鏈結列表。
public class ivan35 {

	public static void main(String[] args) {
		LinkedList<String> names = new LinkedList<String>();
//創建一個 LinkedList 物件 names，用來儲存字串 (String)。
//LinkedList 是一種雙向鏈結列表，適合頻繁插入或刪除操作。
		names.add(0,"Brad");
//在索引 0 的位置插入 "Brad"。
//由於列表一開始是空的，"Brad" 成為第一個元素。
//列表狀態：["Brad"]
		names.add(0,"Eric");
//在索引 0 的位置插入 "Eric"，原有的 "Brad" 會被推到索引 1。
//列表狀態：["Eric", "Brad"]
		names.add(0,"Andy");
//在索引 0 的位置插入 "Andy"，"Eric" 移到索引 1，"Brad" 移到索引 2。
//列表狀態：["Andy", "Eric", "Brad"]
		names.add(0,"Mark");
//在索引 0 的位置插入 "Mark"，其他元素依序向後移。
//列表狀態：["Mark", "Andy", "Eric", "Brad"]
		names.add(0,"John");
//在索引 0 的位置插入 "John"，其他元素再次向後移。
//列表狀態：["John", "Mark", "Andy", "Eric", "Brad"]
		System.out.println(names.size());
//輸出 names 列表的元素數量。
//此時列表有 5 個元素，輸出：5
		System.out.println(names);
//輸出整個 names 列表的內容。
//由於每次插入都在索引 0，後插入的元素會出現在前面，
//輸出：[John, Mark, Andy, Eric, Brad]
//
//LinkedList 是一個雙向鏈結列表，適合需要頻繁插入或刪除的情況。
//與 ArrayList 相比，LinkedList 在插入和刪除時效率較高，
//但隨機訪問（例如透過索引獲取元素）效率較低。
	}

}
