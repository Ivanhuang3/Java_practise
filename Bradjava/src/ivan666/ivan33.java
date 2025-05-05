package ivan666;

import java.util.TreeSet;
import java.util.HashSet;
//導入了 HashSet 和 TreeSet 兩個集合類別
public class ivan33 {

	public static void main(String[] args) {
		TreeSet<Integer> lottery = new TreeSet();
//創建一個 TreeSet 物件 lottery，用來儲存整數 (Integer)。
//TreeSet 會自動排序（由小到大）並保證元素不重複。
		while (lottery.size()<6) {
//使用 while 迴圈，直到 lottery 中有 6 個數字為止。
			lottery.add((int)(Math.random()*49+1));
		}
//Math.random() 產生 0.0 到 1.0 的隨機數。
//Math.random() * 49 將範圍擴大到 0 到 48.999...。
//+1 將範圍調整為 1 到 49.999...。
//(int) 將結果轉為整數，得到 1 到 49 的隨機數字。
//lottery.add() 將隨機數字加入 TreeSet，
//如果數字已存在（因為 TreeSet 不允許重複），
//則不會新增，重複的數字會被忽略。
		System.out.println(lottery);
	}
}

//如果使用 HashSet 替代 TreeSet，
//數字不會排序，輸出順序會是隨機的
