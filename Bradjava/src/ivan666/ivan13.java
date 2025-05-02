package ivan666;

public class ivan13 {

	public static void main(String[] args) {
		int[][] a;
		a = new int[3][2];
//int[][] a;：宣告一個二維整數陣列 a。
//a = new int[3][2];：分配一個 3 行 2 列的二維陣列。
		int[][] b;
		b = new int[3][];
		b[0] = new int[2];
		b[1] = new int[3];
		b[2] = new int[4];
//int[][] b;：宣告一個二維整數陣列 b。
//b = new int[3][];：分配一個有 3 行的二維陣列，
//但每行的長度未指定（列數為 null）。
//b[0] = new int[2];：第 0 行分配 2 個元素的陣列。
//b[1] = new int[3];：第 1 行分配 3 個元素的陣列。
//b[2] = new int[4];：第 2 行分配 4 個元素的陣列。
//這是一個不規則陣列（jagged array），
//每行長度不同（分別為 2、3、4）。
		for(int[] v : b) {
			for (int vv : v) {
				System.out.print(vv + "  ");
			}
			System.out.println();
		}
//功能：使用巢狀的增強型 for 迴圈（foreach）遍歷陣列 b，
//並打印每個元素。
//意義：
//外層迴圈：for(int[] v : b) 遍歷 b 的每一行，
//v 代表每一行的一維陣列（b[0], b[1], b[2]）。
//內層迴圈：for (int vv : v) 遍歷每一行的元素，vv 代表單個整數值。
//System.out.print(vv + " ");：
//打印元素值，後加兩個空格以保持格式整齊。
//System.out.println();：
//每打印完一行後換行。
		System.out.println("====");
		System.out.println(b);
		System.out.println(b[0]);
		System.out.println(b[0][0]);
//程式碼的意義:
//展示二維陣列的兩種形式：
//規則陣列（a）：固定 3 行 2 列，適合每行長度相同的場景。
//不規則陣列（b）：3 行，每行長度不同（2、3、4），展示陣列的靈活性。
//陣列初始化：
//規則陣列用單一語句分配（new int[3][2]）。
//不規則陣列需要分步分配每行（b[0], b[1], b[2]）。
//元素預設為 0
//遍歷不規則陣列：
//使用增強型 for 迴圈簡潔地遍歷不同長度的行。
//展示了如何處理不規則陣列的動態結構。
//陣列物件 vs. 元素：
//直接打印陣列（b 或 b[0]）顯示記憶體位址，無實際意義。
//打印具體元素（b[0][0]）顯示值，強調需要明確索引來訪問數據。
	}

}
