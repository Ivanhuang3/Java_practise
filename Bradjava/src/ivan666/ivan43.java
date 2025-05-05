package ivan666;

import java.io.File;

public class ivan43 {
	public static void main(String[] args) {
		File f1 = new File(".");
		System.out.println(f1.getAbsolutePath());
		File dir1 = new File("./dir1/file3.txt");
		System.out.println(dir1.exists());
	}
//整體執行流程與輸出
//執行順序：
//程式從 main 方法開始執行。
//創建 File 物件 f1 表示相對路徑 "."，並輸出其絕對路徑（f1.getAbsolutePath()），
//顯示當前工作目錄的完整路徑。
//創建 File 物件 dir1 表示相對路徑 "./dir1/file1.txt"，
//並檢查該檔案是否存在（dir1.exists()），輸出 true 或 false。
//程式結束。
//絕對路徑與相對路徑的對比：
//使用相對路徑 "." 並通過 getAbsolutePath() 轉換為絕對路徑，
//展示了相對路徑如何依賴當前工作目錄。
//相對路徑 "./dir1/file1.txt" 的存在性檢查進一步說明，
//相同的相對路徑在不同工作目錄下可能指向不同位置，而絕對路徑則始終固定。
}
