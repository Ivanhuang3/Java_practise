package ivan666;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
//逐行說明：
//import java.awt.FlowLayout;：
//匯入 FlowLayout 類別，這是一個佈局管理器，
//用於將元件（例如按鈕）從左到右、依序排列，若空間不足則換行。
//import javax.swing.JButton;：
//匯入 JButton 類別，用於創建帶有標籤的按鈕，使用者可以點擊以觸發動作。
//import javax.swing.JFrame;：
//匯入 JFrame 類別，這是一個頂層容器，
//用於創建獨立的視窗（GUI 應用程式的主要視窗）。
//import javax.swing.SwingUtilities;：
//匯入 SwingUtilities 類別，提供實用工具方法，
//例如 invokeLater，用於在事件分派執行緒 (EDT) 上執行程式碼。
//意義：這些匯入語句允許程式使用 Swing 和 AWT 的功能來構建 GUI，
//並確保 GUI 操作在正確的執行緒上執行。
public class ivan18 extends JFrame {
//	功能：定義一個公開的類別 ivan18，並讓它繼承自 JFrame。
//	意義：
//	extends JFrame 表示 ivan18 是一個自定義的視窗類別，
//	繼承了 JFrame 的所有功能（如設置視窗標題、大小、可見性等）。
//	ivan18 可以看作一個自訂的視窗，包含特定的元件（例如按鈕）和行為。
	private JButton b1, b2, b3;
//功能：宣告三個私有（private）的 JButton 物件變數 b1、b2 和 b3。
//意義：
//這些變數用於儲存三個按鈕的實例，稍後會在建構子中初始化。
//使用 private 修飾符確保這些變數只能在 ivan18 類別內部訪問，
//遵循封裝原則。
    public ivan18() { // 修正為建構子
        super("偶的視窗"); // 設定視窗標題
        b1 = new JButton("B1");
        b2 = new JButton("B2");
        b3 = new JButton("B3");
        setLayout(new FlowLayout());
        add(b1); add(b2); add(b3);
        
        setSize(640, 480);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
//public ivan18()：定義無參數的建構子，當創建 ivan18 物件時自動執行。
//super("偶的視窗");：調用父類 JFrame 的建構子，
//設定視窗的標題為「偶的視窗」（中文，意為「我的視窗」）。
//b1 = new JButton("B1");、
//b2 = new JButton("B2");、
//b3 = new JButton("B3");：
//創建三個 JButton 物件，分
//別標籤為「B1」、「B2」、「B3」，並將它們賦值給成員變數 b1、b2、b3。
//setLayout(new FlowLayout());：設定視窗的佈局管理器為 
//FlowLayout，
//元件將從左到右依序排列，若空間不足則自動換行。
//add(b1); add(b2); add(b3);：將三個按鈕添加到視窗的內容面板中，
//按添加順序（b1、b2、b3）從左到右排列。
//setSize(640, 480);：設定視窗大小為 640 像素寬、480 像素高。
//setVisible(true);：使視窗可見，顯示在螢幕上。
//setDefaultCloseOperation(EXIT_ON_CLOSE);：設定視窗的關閉行為，當用戶點擊視窗右上角的「X」按鈕時，程式將完全退出（結束 JVM）。
//意義：
//建構子負責設置視窗的外觀和內容，創建一個包含三個按鈕的 GUI 視窗。
//FlowLayout 確保按鈕以簡單的方式排列，適合初學者學習 Swing 的佈局管理。
//這段程式碼完成了視窗的初始化，使其準備好顯示和接受用戶交互。
    public static void main(String[] args) {
        // 在事件分派執行緒中執行 GUI 相關程式碼
        SwingUtilities.invokeLater(() -> {
            new ivan18(); // 創建並顯示視窗
        });
//public static void main(String[] args)：
//Java 程式的標準入口點，JVM 從這裡開始執行程式。
//SwingUtilities.invokeLater(() -> { ... });：
//使用 SwingUtilities.invokeLater 
//將 GUI 相關程式碼包裝在事件分派執行緒 (EDT) 中執行。
//Swing 的 GUI 操作（例如創建視窗、添加元件）
//應在 EDT 上執行，以確保執行緒安全並避免潛在的 UI 問題。
//invokeLater 將指定的程式碼（Runnable）排入 
//EDT 的任務佇列，確保它在正確的執行緒上執行。
//new ivan18();：創建一個 ivan18 物件，
//觸發建構子執行，從而初始化並顯示視窗。
    }
}