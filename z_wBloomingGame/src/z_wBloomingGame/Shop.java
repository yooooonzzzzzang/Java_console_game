
package z_wBloomingGame;

import java.util.ArrayList;
import java.util.Scanner;


public class Shop {	//����
	ArrayList<Item>shopItemList; //������ Ŭ������ �޴� ArrayList shopItemList

	public Shop() {
		shopItemList=new ArrayList<Item>();	
		shopItemList.add(new Item("���� ��� ����", 100, "���� ���� �� �ִ� ���� ��� ����"));
		shopItemList.add(new Item("�� ��� ����", 100, "���� ���� �� �ִ� �� ��� ����"));
		shopItemList.add(new Item("��� ��� ����", 100, "���� ���� �� �ִ� ��� ��� ����"));
		shopItemList.add(new Item("�⺻ ���", 300, "���� 1ȸ �� ȿ���� �����ϴ�"));
		shopItemList.add(new Item("��� ���", 800, "���� 2ȸ �� ȿ���� �����ϴ�"));
	}
	
	
	void show() {	//�������� �Ĵ� �������� ������
		
		System.out.println("������������������������������������������������������������������������");
		System.out.println();
		for(int i=0; i<shopItemList.size(); i++) {
			
		System.out.println("      "+(i+1)+". "+shopItemList.get(i).getName()+
					": "+ shopItemList.get(i).getPrice()+" G");
		System.out.println("\t -"+ shopItemList.get(i).getExplan());
			
		}
		System.out.println("      "+"6. ������");
		System.out.println();
		System.out.println("������������������������������������������������������������������������");
		
		
	}
	// ������ ���� �޼ҵ�
		void purchase(ArrayList<Item> invenItemList, Inventory inventory) {	
		Scanner sc= new Scanner(System.in);
		while(true) {
		show();
		System.out.println("\t���� ���: "+ inventory.Money+" G");
		System.out.print(">>");
		int usr = sc.nextInt();
		
		if(usr == 6) {	//������
			break;
		}else if(usr >=1 && usr <=5){
		if(inventory.Money >= invenItemList.get(usr-1).getPrice()) {	//������> �������� ����
			inventory.Money = inventory.Money - invenItemList.get(usr-1).getPrice(); //������ ���ݸ�ŭ ������ ����
			int temp = invenItemList.get(usr-1).getCount()+1;	//���濡 ������ ������ ���� �ϳ� ���� 
			invenItemList.get(usr-1).setCount(temp);
			System.out.println("=============================================================");
			System.out.println("���Ű� �Ϸ�Ǿ����ϴ�");
			System.out.println("���� ���: "+inventory.Money);
		}else {
			System.out.println("��尡 �����մϴ�.");
		}
		

			}else {	//1~6 ���� ���ڸ� �Է�������
				System.out.println("=============================================================");
				System.out.println("�߸��� ��ȣ �Դϴ� ");
			}
		}
	}
	
	
	
	
	
	
}
