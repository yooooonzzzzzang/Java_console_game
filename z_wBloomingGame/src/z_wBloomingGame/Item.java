package z_wBloomingGame;

public class Item {
	private String name;	//������ �̸�
	private int price;		//������ ����
	private int count;		//������ ���� 
	private char div;		//������ �з� ('s'���� 'f'���� ������)
	private String explan;	//������ ����
	
	
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
