package z_wBloomingGame;

public class Flower {
	private char color;	//���� ����
	private int sellprice;	//���� ����ؼ� �Ĵ� ����
	private int probability;	//���� ���� ������ Ȯ��
	private int wc;	//watercount ���� Ƚ��
	private boolean didiwater;	//���� �־����� Ȯ��
	private boolean didcross;	//������ ���� �ִ��� Ȯ��
	private String name;	//���� �̸�
	
//	
	public Flower() {
		this.wc = 0;
		this.didiwater = false;
		this.didcross =false;
	}

	public Flower(char color, int sellprice, int probability, String name) {
		this.color = color;
		this.sellprice = sellprice;
		this.probability = probability;
		this.wc = 0;
		this.didiwater = false;
		this.name = name;
		this.didcross = false;
	}
	
	public boolean isDidcross() {
		return didcross;
	}

	public void setDidcross(boolean didcross) {
		this.didcross = didcross;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isDidiwater() {
		return didiwater;
	}

	public void setDidiwater(boolean didiwater) {
		this.didiwater = didiwater;
	}

	public int getWc() {
		return wc;
	}

	public void setWc(int wc) {
		this.wc = wc;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getSellprice() {
		return sellprice;
	}

	public void setSellprice(int sellprice) {
		this.sellprice = sellprice;
	}

	public int getProbability() {
		return probability;
	}

	public void setProbability(int probability) {
		this.probability = probability;
	}
	
}
