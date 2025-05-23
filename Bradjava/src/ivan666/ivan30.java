package ivan666;

public class ivan30 {
	public static void main(String[] args) {
		ivan302 obj1 =new ivan302();
		obj1.m1();
	}
}
//ivan302 = 冷氣型號
//obj1    = 冷氣造出來取名obj1
//new ivan302 = 設計圖變成機器的過程

interface ivan301{
	void m1();
	void m2();
}
//interface Brad301 就像老闆開的「冷氣功能清單」，
//要求冷氣得會「製冷」（m1）和「送風」（m2）。

class ivan302 extends Object implements ivan301{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
}
//class ivan302：冷氣設計圖:定義了冷氣的規格
//（會製冷、送風、除濕、定時）。
//ivan302 是你工廠的第一款冷氣，
//姑且叫它「三菱冷氣」。這台冷氣簽了兩份合約：
//ivan301（之前講過，要求冷氣會製冷 m1 和送風 m2）。
//ivan303（要求冷氣會除濕 m3 和定時 m4）。
//extends Object：這是 Java 的預設，
//意思是這台冷氣是個「東西」，可以忽略。

//implements ivan301, ivan03：
//三菱冷氣答應做到這兩份合約的所有要求，所以它得會：
//製冷 (m1)、送風 (m2)（從 ivan301）。
//除濕 (m3)、定時 (m4)（從 ivan303）。
//方法 m1(), m2(), m3(), m4()：
//這就像三菱冷氣裝了四個按鈕，說「我會做這些功能」。但因為方法體是空的（{}），這些按鈕按下去啥也不幹，就像冷氣裝了按鈕但沒接電路。


interface ivan303{
	void m3();
	void m4();
}
//這是一份「冷氣功能合約」，叫 Brad303。
//它像老闆的清單，說冷氣得會：
//m3()：除濕功能（比如讓房間不潮）。
//m4()：定時關機（比如半夜自動關）。
//這份合約只說「要做這些」，
//沒說「怎麼做」（因為介面只定義方法，沒實作）。
	
interface ivan304 extends ivan301, ivan303{
	void m5();
}
//ivan304 是一份「超級冷氣合約」，
//它把 ivan301（製冷、送風）和
//ivan303（除濕、定時）兩份合約合併，
//還加了一個新要求：
//m5()：自動清潔功能（比如冷氣自己洗濾網）。
//extends ivan301, ivan303：
//這就像老闆把兩份舊清單（Brad301 和 Brad303）
//合成一張大清單，再加一條新規則。
//所以，ivan304 要求冷氣得會：
//製冷 (m1)、送風 (m2)（從 Brad301）。
//除濕 (m3)、定時 (m4)（從 Brad303）。
//自動清潔 (m5)（自己加的）。

class ivan305 implements ivan304{
	public void m1() {}
	public void m2() {}
	public void m3() {}
	public void m4() {}
	public void m5() {}
}
//ivan305 是你工廠的第二款冷氣，
//姑且叫它「大金冷氣」。
//這台冷氣簽了 ivan304 這份超級合約。
//implements ivan304：
//大金冷氣說「我答應做到 ivan304 的所有要求」。
//因為 ivan304 
//包含了 ivan301 和 ivan303 的功能，
//加上自己的 m5，所以 ivan305 得會：
//製冷 (m1)、送風 (m2)。
//除濕 (m3)、定時 (m4)。
//自動清潔 (m5)。
//方法 m1() 到 m5()：
//這就像大金冷氣裝了五個按鈕，說「我會做這些功能」。但一樣因為方法體是空的（{}），按下去啥也不會發生，就像按鈕沒接電路。
//作用：
//ivan305 是另一台冷氣的設計，
//承諾做到超級合約的五件事，但功能也是空的，
//只是個框架。

//為什麼 ivan305 不用寫 extends Object？
//因為它是類別，Java 自動讓每個類別繼承 
//Object，不用特別寫。

//為什麼 ivan304 不用寫 extends Object？
//因為它是介面，不是類別，
//介面不會繼承 Object，所以沒這回事。

//冷氣比喻總結
//public void m1() {}：
//你在三菱冷氣（Brad302）的設計圖上
//畫了一個「製冷按鈕」，說這台冷氣會製冷。
//但你沒寫怎麼製冷（方法體是 {}），
//所以按鈕是空的。

//obj1.m1();：
//你拿著一台真的三菱冷氣（obj1），
//按下「製冷按鈕」。
//因為設計圖裡的按鈕是空的，
//你按了啥也不會發生（沒冷風）。
//差別：
//一個是設計圖上的按鈕（定義功能），
//一個是對真冷氣按按鈕（執行功能）。
//定義是基礎，執行靠定義的程式碼。
