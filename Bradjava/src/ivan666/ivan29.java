package ivan666;

public class ivan29 {
	public static void main(String[] args) {
//		
		ivan291 obj1 = new ivan291() {
			void m3() {
				System.out.println("ivan291:m3()");
			}
		};
		obj1.m3();
		
		System.out.println("----");
		
		ivan291 obj2 = new ivan292();
		obj2.m3();
		
		System.out.println("----");
		
		ivan291 obj3 = new ivan291() {
			void m3() {
				System.out.println("ivan291:m3():other");
			}
		};
		obj3.m3();
		
	}
}
abstract class ivan291 {
	ivan291(){System.out.println("ivan291()");}
	void m1() {}
	void m2() {}
	abstract void m3();
}
class ivan292 extends ivan291{
	ivan292(){System.out.println("ivan292()");}
	void m3() {System.out.println("ivan292:m3()");}
}
class ivan293 extends ivan291{
	ivan293(){System.out.println("ivan293()");}
	void m3() {System.out.println("ivan293:m3()");}
}

//實際用途：抽象類作為父類型，可以用來統一管理不同子類的物件，讓程式碼更靈活，
//容易擴展。
//生活比喻：想像你是一個快遞公司老闆，規定所有「交通工具」都要能「送貨」（抽象方法）。
//你可以用一個「交通工具」清單來管理腳踏車、汽車、飛機，它們送貨方式不同，
//但都可以放進同一個清單，因為它們都繼承自抽象類。
//abstract class Vehicle {
//    abstract void deliver();
//}
//
//class Bicycle extends Vehicle {
//    void deliver() {
//        System.out.println("用腳踏車送貨");
//    }
//}
//
//class Truck extends Vehicle {
//    void deliver() {
//        System.out.println("用卡車送貨");
//    }
//}
//
//public class DeliveryApp {
//    public static void main(String[] args) {
//        Vehicle[] vehicles = {new Bicycle(), new Truck()};
//        for (Vehicle v : vehicles) {
//            v.deliver(); // 多型：統一呼叫不同實作
//        }
//    }
//}