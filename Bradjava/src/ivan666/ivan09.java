package ivan666;

import java.util.Scanner;

public class ivan09 {

		public static void main(String[] args) {
			Scanner scanner =  new Scanner(System.in);
			System.out.print("Year = ");
			int year = scanner.nextInt();
			boolean isLeap = false ;
//Scanner scanner = new Scanner(System.in);: 
//創建一個 Scanner 物件，用於從標準輸入（鍵盤）讀取使用者輸入。
//System.out.print("Year = ");: 
//在螢幕上顯示提示文字 "Year = "，要求使用者輸入年份。
//int year = scanner.nextInt();:
//讀取使用者輸入的整數（年份），並儲存在 year 變數中。
//boolean isLeap = false;:
//宣告一個布林變數 isLeap，初始值為 false，用來標記該年份是否為閏年。
			if (year % 4 == 0) {
			    if (year % 100 == 0) {
			        if (year % 400 == 0) {
			            isLeap = true;
			        } else {
			            isLeap = false;
			        }
			    } else {
			        isLeap = true;
			    }
			} else {
			    isLeap = false;
			}
		System.out.printf("%d 年是 %s年", year, isLeap?"潤": "平");	
	}
}
//這段程式碼是閏年判斷的核心邏輯，逐步檢查年份是否符合閏年規則：
//
//第一層：if (year % 4 == 0)
//檢查 year 是否能被 4 整除（即 year % 4 == 0）。
//如果是，進入內層判斷；如果不是，則 isLeap 保持 false（非閏年）。
//第二層：if (year % 100 == 0)
//如果年份能被 4 整除，進一步檢查是否能被 100 整除。
//如果能被 100 整除，進入下一層判斷；如果不能，
//則該年份是閏年（isLeap = true）。
//第三層：if (year % 400 == 0)
//如果年份能被 100 整除，檢查是否能被 400 整除。
//如果能被 400 整除，則是閏年（isLeap = true）；
//否則不是閏年（isLeap = false）。
//這段邏輯可以總結為：
//
//閏年條件：
//能被 4 整除，但不能被 100 整除（例如 2020）。
//能被 400 整除（例如 2000）。
//非閏年：
//不能被 4 整除（例如 2021）。
//能被 100 整除但不能被 400 整除（例如 1900）。
//
//使用 System.out.printf 格式化輸出結果。
//%d: 代表整數，輸出 year 的值。
//%s: 代表字串，根據 isLeap 的值輸出 "潤"（閏年）或 "平"（平年）。
//三元運算子 isLeap ? "潤" : "平": 
//如果 isLeap 為 true，返回 "潤"；否則返回 "平"。
//範例輸出：
//輸入 2020：2020 年是 潤年
//輸入 2021：2021 年是 平年

