package z_wBloomingGame;

import java.util.ArrayList;

public class Inventory{	//����
	public static int Money = 1000;	//�ʱ� �ں���
	public ArrayList<Item> invenItemList;// Item Ŭ������ �޴� ArrayList invenItemList
	public Inventory() {	
		//�� ��̾��� 2���� ó���� �⺻���� �ش�.
		invenItemList = new ArrayList<Item>();
		invenItemList.add(new Item("���� ��� ����", 100,2, 's'));
		invenItemList.add(new Item("�� ��� ����", 100,2,'s'));
		invenItemList.add(new Item("��� ��� ����", 100,2,'s'));
		invenItemList.add(new Item("�⺻ ���", 300, 0,'f'));
		invenItemList.add(new Item("��� ���", 800, 0,'f'));
	}
	
	//������ �����ִ� �޼ҵ�
	void showInventory(ArrayList<Item> invenItemList, Inventory inventory) {	
		System.out.println("�������������������������������������榬��������������������������������");
		System.out.println();
		for(int i=0; i<invenItemList.size(); i++) {
			if(invenItemList.get(i).getCount()>=1) {
				System.out.println("\t    "+invenItemList.get(i).getName()+" : "+
			invenItemList.get(i).getCount()+"��");
			}
		}
		System.out.println();
		System.out.println("\t    ���� ���: "+ inventory.Money);
		System.out.println();
		System.out.println("������������������������������������������������������������������������");
	}
	
	
}

