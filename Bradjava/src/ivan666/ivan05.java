package ivan666;

public class ivan05 {

	public static void main(String[] args) {
		float var1 = 12.0f;
		double var2 = 12;
//var1 是一個 float 型別的變數，
//初始化為 12.0f。f 後綴明確指定這是 float 型別（單精度浮點數）。
//var2 是一個 double 型別的變數，
//初始化為 12。雖然寫的是整數 12，Java 會自動將其視為 12.0
//（雙精度浮點數）。
		int a = 10, b =3;
		double var3 = a * 1.0/b;
//a 和 b 是整數，分別初始化為 10 和 3。
//var3 是一個 double 型別的變數，計算 a * 1.0 / b：
//a * 1.0 將 a（整數 10）與 1.0（double 型別）相乘，
//結果是 10.0（double 型別）。
//再除以 b（整數 3），
//結果是 10.0 / 3 = 3.333333...（double 型別）。
//如果直接寫 a / b，結果會是整數除法（10 / 3 = 3），
//因為 a 和 b 都是整數。因此，* 1.0 是為了強制轉換為浮點數運算。
		System.out.println(var2);
		System.out.println(var3);
		System.out.println("----");
//輸出 var2：12.0（因為 var2 是 double 型別）。
//輸出 var3：3.3333333333333335
//（double 型別的除法結果，精確度受限於 double 的表示範圍）。
//輸出分隔線 ----。
		float x = 0.1f;
		float y = 0.2f;
		float r1 = x + y;
		System.out.println(r1);
//x 和 y 是 float 型別，分別初始化為 0.1f 和 0.2f。
//r1 計算 x + y，理論上應為 0.3。
//實際輸出結果可能是 0.300000004（或類似值），
//這是因為 float（單精度浮點數）在儲存小數時有精度限制。
//0.1 和 0.2 在二進制中無法精確表示，導致計算結果出現微小誤差。
	}
}
