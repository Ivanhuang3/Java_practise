package ivan666;

public class ivan24 {

	public static void main(String[] args) {
		String name ="Ivan";
//String 是一個類別，因此 name 是一個物件，儲存字串 "Ivan"。
		String name2 = name.concat("OK");
		System.out.println(name2);
//name.concat("OK") 呼叫 String 類別的 concat(連接)方法，
//將字串 "OK" 附加到 name（即 "Ivan"）的末尾，
//生成一個新的字串 "IvanOK"。
//String 是不可變的（immutable），
//因此 concat 不會修改 name，
//而是返回一個新的 String 物件，賦值給 name2。
//輸出 name2 的值，即 "IvanOK"。
		String name3 = name2.replace('I', 'i');
		System.out.println(name3);
//name2.replace('B', 'b') 呼叫String類別的
//replace方法，將 name2（即 "IvanOK"）中的所有'I'替換為 'i'。
//這也生成一個新的 String 物件，因為String不可變。
//結果是 "ivanOK"，賦值給 name3。
//System.out.println(name3); 輸出name3的值，
//即 "ivanOK"。
	}

}
