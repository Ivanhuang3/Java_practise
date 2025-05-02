package ivan666;

public class ivan28 {
	public static void main(String[] args) {
		ivan281 obj1 = new ivan281();
		ivan281 obj2 = new ivan282();
		ivan281 obj3 = new ivan283();
	
		ivan282 obj4 = (ivan282)obj2;
		System.out.println(obj2 ==obj4);
		obj4.m2();
		System.out.println(obj2 instanceof ivan283);
	}
}
//Food item1 = new Food();
//Food item2 = new Pizza();
//Food item3 = new Salad();
//這就像顧客點了三道菜，服務生用「食物」（Food）
//這個大框框來記錄：
//item1 是普通食物（像白飯，沒啥特別）。
//item2 雖然用「食物」框框，但裡面是披薩（Pizza）。
//item3 也用「食物」框框，但裡面是沙拉（Salad）。

//服務生發現 item2 其實是披薩，就說：「我知道你是披薩，
//我要把你當披薩處理！」這叫向下轉型。
//轉型後，item4 就是披薩，可以用披薩的獨特功能（像是加配料）。
//這得小心確認 item2 真的是披薩，不然轉錯會出錯（像把沙拉當披薩，
//會搞亂）。

//這行問：「item2 和 item4 是同一盤披薩嗎？」
//雖然 item2 用「食物」框框，item4 用「披薩」框框，
//但它們指的是同一盤披薩（同一個記憶體地址）。
//所以會印出 true，因為它們是同一盤菜，只是標籤不同

//System.out.println(item2 instanceof Salad);
//這行問：「item2 這盤菜是沙拉嗎？」
//其實 item2 是披薩，不是沙拉，所以會印出 false。
//instanceof 就像服務生檢查菜單，確認這盤菜的真實身份。

class ivan281{
	void m1() {
		System.out.println("ivan281:m1()");
	}
}
class ivan282 extends ivan281{
	void m1() {
		System.out.println("Ivan282:m1()");
	}
	void m2() {
		System.out.println("Ivan282:m2()");
	}
}
class ivan283 extends ivan281{
	void m1() {
		System.out.println("Ivan283:m1()");
	}
	void m3() {
		System.out.println("Ivan283:m3()");
	}
}
//Brad281 是父類（老爸），有個方法 m1()，
//就像樂團領隊的基本技能：演奏音樂。
//當呼叫 m1()，會印出 "Brad281:m1()"，表示老爸用自己的方式
//（比如吹口琴）來演奏。
//
//Brad282 是子類，透過 extends Brad281 
//繼承了老爸 Brad281 的功能。
//覆寫（Override）：大兒子重新定義了 m1()，
//印出 "Brad282:m1()"，表示
//他用自己的方式演奏（比如彈吉他），而不是老爸的口琴。
//新功能：大兒子還有自己的獨特技能 m2()，
//印出 "Brad282:m2()"，像是會唱歌，這是老爸不會的。
//
//Brad283 也是子類，繼承了老爸 Brad281。
//覆寫（Override）：二兒子也重新定義了 m1()，
//印出 "Brad283:m1()"，
//表示他用自己的方式演奏（比如彈鋼琴）。
//新功能：二兒子有自己的獨特技能 m3()，
//印出 "Brad283:m3()"，像是會跳舞，
//這是老爸和大兒子都不會的。