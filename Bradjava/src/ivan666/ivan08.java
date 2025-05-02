package ivan666;

public class ivan08 {

	public static void main(String[] args) {
		double temp = Math.random();
		int score = (int)(temp * 49) +1;
		System.out.println(score);
//double temp = Math.random();: 使用 Math.random() 
//生成一個隨機的 double 值，範圍在 [0.0, 1.0)
//（包含 0.0，但不包含 1.0）。
//int score = (int)(temp * 49) + 1;:
//將 temp 乘以 49，得到範圍 [0.0, 49.0)。
//使用 (int) 將結果轉為整數（捨去小數部分），範圍變為 [0, 48]。
//加上 1，使範圍變為 [1, 49]。
//最終 score 是一個隨機整數，範圍在 1 到 49 之間。
//System.out.println(score);: 輸出隨機生成的分數。
		if(score >= 60){
			System.out.println("Pass");
		}else {
			System.out.println("Down");
//if (score >= 60) {:
//這是一個 if 條件語句，檢查變數 score 是否大於或等於 60。
//score >= 60 是一個布林表達式，返回 true（如果 score ≥ 60）
//或 false（如果 score < 60）。
//如果條件為 true，執行大括號 {} 內的程式碼。
//System.out.println("Pass");:
//如果 score >= 60，則在螢幕上輸出字串 "Pass"，表示「及格」。
//} else {:
//如果 if 條件為 false（即 score < 60），則執行 else 區塊內的程式碼。
//System.out.println("Down");:
//如果 score < 60，則輸出字串 "Down"，表示「不及格」。
		}
	}

}
