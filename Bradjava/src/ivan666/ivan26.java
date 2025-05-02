package ivan666;

public class ivan26 {

	public static void main(String[] args) {
		Ivan261 obj1 = new Ivan261();
		Ivan261 obj2 = new Ivan261();
		Ivan261 obj3 = new Ivan261();
		System.out.println(obj1.i);
		System.out.println(obj2.i);
		System.out.println(obj3.i);
		System.out.println("----");
		System.out.println(obj1.j);
		System.out.println(Ivan261.j);

	}

}
//static 到底是什麼？
//用白話來說：
//
//普通變數（像 i）：
//每個物件有自己的 i，就像每個人有自己的筆記本。
//每次創建物件，i 從 0 開始，獨立加 1，變成 1。

//靜態變數（像 j）：所有物件共享一個東西，
//所有物件共享同一個 j，就像大家共用一個黑板。
//每次創建物件，j 會在黑板上加 1，累積起來（0 → 1 → 2 → 3）。
//所以 j 最後是 3，因為它記錄了三次物件創建的總和。
class Ivan261{
	int i;
	static int j;
	Ivan261(){
		i++;
		j++;
	}
}
//總結
//每個物件的 i 是 1，因為：
//
//i 是普通變數，每個物件（obj1、obj2、obj3）有自己的 i。
//創建物件時，i 從 0 開始，建構子執行 i++，讓 i 變成 1。
//每個物件的 i 都是獨立的，互不影響，
//所以 obj1.i、obj2.i、obj3.i 都是 1。
//這跟 j 不同，j 是靜態變數，會累加三次（變成 3）