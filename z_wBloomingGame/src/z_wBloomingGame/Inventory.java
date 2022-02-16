package z_wBloomingGame;

import java.util.ArrayList;

public class Inventory{	//陛寞
	public static int Money = 1000;	//蟾晦 濠獄旎
	public ArrayList<Item> invenItemList;// Item 贗楚蝶蒂 嫡朝 ArrayList invenItemList
	public Inventory() {	
		//陝 濰嘐噢憾 2偃噶 籀擠縑 晦獄戲煎 遽棻.
		invenItemList = new ArrayList<Item>();
		invenItemList.add(new Item("說除 濰嘐 噢憾", 100,2, 's'));
		invenItemList.add(new Item("�� 濰嘐 噢憾", 100,2,'s'));
		invenItemList.add(new Item("喻塢 濰嘐 噢憾", 100,2,'s'));
		invenItemList.add(new Item("晦獄 綠猿", 300, 0,'f'));
		invenItemList.add(new Item("堅晝 綠猿", 800, 0,'f'));
	}
	
	//陛寞擊 爾罹輿朝 詭模萄
	void showInventory(ArrayList<Item> invenItemList, Inventory inventory) {	
		System.out.println("旨收收收收收收收收收收收收收收收收陛寞收收收收收收收收收收收收收收收收旬");
		System.out.println();
		for(int i=0; i<invenItemList.size(); i++) {
			if(invenItemList.get(i).getCount()>=1) {
				System.out.println("\t    "+invenItemList.get(i).getName()+" : "+
			invenItemList.get(i).getCount()+"偃");
			}
		}
		System.out.println();
		System.out.println("\t    模雖 埤萄: "+ inventory.Money);
		System.out.println();
		System.out.println("曲收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收收旭");
	}
	
	
}

