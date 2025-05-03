package ivan666;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
//java.awt.FlowLayout：導入 FlowLayout 佈局管理器，
//用於將組件（例如按鈕）按順序排列在窗口中。
//java.awt.event.ActionEvent：
//導入 ActionEvent 類，表示事件（例如按鈕點擊）的物件。
//java.awt.event.ActionListener：
//導入 ActionListener 接口，
//用於處理用戶觸發的事件（例如點擊按鈕）。
//javax.swing.JButton：導入 JButton 類，
//用於創建按鈕組件。
//javax.swing.JFrame：導入 JFrame 類，
//用於創建應用程式的主窗口。
public class ivan31 extends JFrame implements ActionListener{
//實現 ActionListener 接口，表示這個類可以處理事件（例如按鈕點擊）。
//這要求類必須實現 actionPerformed 方法。
//這個類是程式的主體，負責創建窗口、按鈕，並處理按鈕點擊事件。
	private JButton b1, b2, b3;
//聲明三個私有（private）的 JButton 物件 b1、b2、b3，
//用於表示窗口中的三個按鈕。
//這些變數是類的實例變數，儲存在 ivan31 物件中，可在類的各個方法中訪問。
	public ivan31() {
		b1 = new JButton("B1");
		b2 = new JButton("B2");
		b3 = new JButton("B3");
		setLayout(new FlowLayout());
		
		add(b1);add(b2);add(b3);
		
		setSize(640, 480);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		initEvent();
//b1 = new JButton("B1");：創建一個標籤為 "B1" 的按鈕，
//並賦值給 b1。同樣初始化 b2 和 b3。
//setLayout(new FlowLayout());：設置窗口的佈局為 FlowLayout，
//按鈕將按添加順序從左到右排列。
//add(b1);add(b2);add(b3);：將三個按鈕添加到窗口中。
//setSize(640, 480);：設置窗口大小為 640x480 像素。
//setVisible(true);：使窗口可見（顯示出來）。
//setDefaultCloseOperation(EXIT_ON_CLOSE);：
//設置窗口關閉行為，點擊關閉按鈕時程式退出。
//initEvent();：調用 initEvent 方法，為按鈕設置事件監聽器。
	}
	
	private void initEvent() {
		//MyListener myListener = new MyListener(); 
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}
//定義一個私有方法 initEvent，用於為按鈕註冊事件監聽器。
//具體功能：
//MyListener myListener = new MyListener();：
//這一行被註釋掉，表示原本可能打算使用 MyListener 類作為事件監聽器，
//但最終未使用。
//b1.addActionListener(this);：
//為 b1 按鈕添加事件監聽器，this 表示當前 ivan31 物件
//（因為 ivan31 實現了 ActionListener）。
//同樣為 b2 和 b3 註冊相同的監聽器。
//當按鈕被點擊時，會觸發 ivan31 類的 actionPerformed 方法。
// 本類別的物件實體(this)
	public static void main(String[] args) {
		new ivan31();
	}
//這是程式的入口點，Java 程式從 main 方法開始執行。
//new ivan31();：創建一個 ivan31 物件，
//觸發構造函數執行，從而初始化並顯示窗口。
//這段程式碼簡單但有效，負責啟動應用程式。
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b1) {
			System.out.println("B1");
		}else if (e.getSource() == b2) {
			System.out.println("B2");
		}else if (e.getSource() == b3) {
			System.out.println("B3");
//實現 ActionListener 接口的 actionPerformed 方法，
//用於處理按鈕點擊事件。
//參數：ActionEvent e 表示觸發的事件物件，
//含事件來源（例如哪個按鈕被點擊）。
//具體功能：
//e.getSource()：獲取觸發事件的物件（即被點擊的按鈕）。
//使用 if-else 判斷點擊的是哪個按鈕：
//如果是 b1，輸出 "B1" 到控制台。
//如果是 b2，輸出 "B2"。
//如果是 b3，輸出 "B3"。
//這是事件處理的核心邏輯，當用戶點擊按鈕時，
//控制台會顯示對應按鈕的標籤。
		}
	}
}

class MyListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		
//		if (e.getSource() == b1) {
//			System.out.println("B1");
//		}else if (e.getSource() == b2) {
//			System.out.println("B2");
//		}else if (e.getSource() == b3) {
//			System.out.println("B3");
//		}	
//		
//說明：
//定義一個獨立的 MyListener 類，
//實現 ActionListener 接口，作為另一種處理按鈕事件的方式。
//具體功能：
//actionPerformed 方法輸出 e.getActionCommand()，
//這是按鈕的動作命令，通常是按鈕的標籤
//（例如 "B1"、"B2"、"B3"）。
//註釋掉的 if-else 塊顯示原本可能打算根據按鈕物件
//（b1、b2、b3）判斷，
//但無法直接訪問這些變數，因為它們是 ivan31 類的私有成員。
//問題：
//這個類目前未被使用（在 initEvent 中被註釋掉）。
//由於 b1、b2、b3 是 ivan31 的私有變數，
//MyListener 無法直接訪問它們，
//因此註釋掉的 if-else 邏輯無法工作。
//用途：
//這可能是為了展示另一種事件處理方式（獨立監聽器類），
//但需要修改才能實際使用
//（例如傳遞按鈕引用或使用 getActionCommand）。
	}
	
}