package z_wBloomingGame;

public class Item {
	private String name;	//아이템 이름
	private int price;		//아이템 가격
	private int count;		//아이템 개수 
	private char div;		//아이템 분류 ('s'씨앗 'f'비료로 나눠짐)
	private String explan;	//아이템 설명
	
	
	public Item(String name, int price, String explan) {
		super();
		this.name = name;
		this.price = price; 
		this.explan = explan;
	}

	public Item(String name, int price, int count, char div) {
		super();
		this.name = name;
		this.price = price;
		this.count = count;
		this.div = div;
	}
	


	public String getExplan() {
		return explan;
	}

	public void setExplan(String explan) {
		this.explan = explan;
	}

	public char getDiv() {
		return div;
	}

	public void setDiv(char div) {
		this.div = div;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
