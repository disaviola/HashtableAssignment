//Disa Röed Sahlström, disa7213

public class MyString {

	private char[] data;
	
	public MyString(String title) {
		data = title.toCharArray();
	}

	public Object length() {
		return data.length;
	}
	
	@Override
	public String toString() {
		return new String(data);
	}
	
}
