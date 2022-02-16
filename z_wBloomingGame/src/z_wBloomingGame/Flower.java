package z_wBloomingGame;

public class Flower {
	private char color;	//꽃의 색깔
	private int sellprice;	//내가 재배해서 파는 가격
	private int probability;	//꽃이 가진 유전자 확률
	private int wc;	//watercount 물준 횟수
	private boolean didiwater;	//물을 주었는지 확인
	private boolean didcross;	//교배한 적이 있는지 확인
	private String name;	//꽃의 이름
	
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
