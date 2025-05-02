package ivan666;

public class ivan14 {

	public static void main(String[] args) {
		int[][] a;
		a = new int[3][2];
//	int[][] a;：宣告一個二維整數陣列 a。
//	a = new int[3][2];：分配一個 3 行 2 列的二維陣列。
//	這是一個規則陣列，每行有固定長度（2 個元素）。
//	陣列元素預設初始化為 0（因為 int 的預設值是 0）。
		int[][] b;
		b = new int[3][];
		b[0] = new int [2];
		b[1] = new int [3];
		b[2] = new int [4];
//	int[][] b;：宣告一個二維整數陣列 b。
//	b = new int[3][];：分配一個有 3 行的二維陣列，
//	    但每行的長度未指定（列數為 null）。
//	b[0] = new int[2];：第 0 行分配 2 個元素的陣列。
//	b[1] = new int[3];：第 1 行分配 3 個元素的陣列。
//	b[2] = new int[4];：第 2 行分配 4 個元素的陣列。
		for(int[] v : b) {
			for (int vv : v) {
				System.out.print(vv + "   ");
			}
			System.out.println();
		}
//功能：使用巢狀的增強型 for 迴圈（foreach）遍歷陣列 b，
//並打印每個元素。
//意義：
//外層迴圈：for(int[] v : b) 遍歷 b 的每一行，
//v 代表每一行的一維陣列（b[0], b[1], b[2]）。
//內層迴圈：for (int vv : v) 遍歷每一行的元素，vv 代表單個整數值。
//System.out.print(vv + " ");：打印每個元素，
//後面加兩個空格以便格式整齊。
//System.out.println();：每打印完一行後換行。
		System.out.println("===");
		System.out.println(b);
		System.out.println(b[0]);
		System.out.println(b[0][0]);
		System.out.println(b);
//打印陣列 b 的物件引用。
//在 Java 中，二維陣列是一個物件，println 會呼叫物件的 toString()
//方法。
//輸出類似：[[I@<hashcode>（例如 [[I@7b23ec81）。
//[[I 表示二維整數陣列，@<hashcode> 是物件的記憶體位址。
//這展示了陣列是一個物件，而非直接的值。
//System.out.println(b[0]);：
//打印 b 的第一行（b[0]），它是一個一維陣列。
//輸出類似：[I@<hashcode>（例如 [I@6acbcfc0）。
//[I 表示一維整數陣列，@<hashcode> 是該一維陣列的記憶體位址。
//System.out.println(b[0][0]);：
//打印 b 第一行第一個元素的值。
//因為 b[0][0] 是 int 類型，值為 0（預設值）。
//輸出：0。
//
//程式碼的意義:
//展示二維陣列的兩種形式：
//規則陣列（a）：固定行數和列數（3 行 2 列）。
//不規則陣列（b）：固定行數（3 行），但每行長度不同（2、3、4）。
//展示了 Java 中二維陣列的靈活性，特別是不規則陣列的動態分配方式。
//陣列初始化：
//展示了陣列元素預設值（int 為 0）。
//展示了如何分步分配不規則陣列的每一行。
	}

}
