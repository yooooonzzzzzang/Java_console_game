package z_wBloomingGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Field {
	Flower[] datafield = new Flower[16];	//���� �����Ͱ� �� �迭
	char[] showfield = new char[16];		//console ��¿� �迭 
	

	void showShowField() {	//���� ������ִ� �޼ҵ�
		System.out.println("������������������������������������ ��̹� ������������������������������������");
		for(int i=0; i<datafield.length; i++) {
			if(datafield[i]==null) {	//�� �� 
					showfield[i]= '��';
			}else if(datafield[i].getWc()<3)	{ //��ȭ�ϱ����� �� ������
				showfield[i]='��';
			}else if(datafield[i].isDidiwater()==false){	//���� 3���̻� �ָ� ��ü�� ��
				showfield[i]=datafield[i].getColor();	//�� ���� ���ڰ� ������ ��ü�� �Ȱ��̴�.
			}
			}
		for(int i=0; i<9; i++) {	//�� ���
			if(i%4==0) {
				System.out.println();
			}
				System.out.print("   ");
				System.out.print(showfield[i] +" ( "+(i+1)+")");
		}
		for(int j=9; j<showfield.length; j++) {
			if(j%4==0) {
				System.out.println();
			}
			System.out.print("   ");
			System.out.print(showfield[j] +" ("+(j+1)+")");
		}
		
		System.out.println();
		System.out.println();
		System.out.println("������������������������������������������������������������������������������������");
		}

	
	void fieldAct(ArrayList<Item> invenItemList, Inventory inventory) { //�翡�� Ȱ���� �� �ִ� ������
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0: �������� ���ư��� ");
		System.out.println("1~16: �� ���� ");
		System.out.print(">>");
		
		int fieldChoice = sc.nextInt();
		if(fieldChoice == 0) {
			break;
		}else if(fieldChoice-1>datafield.length) {
			System.out.println("�߸��� ���ڸ� �Է��Ͽ����ϴ�");
			System.out.println("=============================================================");
		}
		else {
			System.out.println("=============================================================");
		System.out.println(fieldChoice+"�� ���� ���õǾ����ϴ�.");
		System.out.println("");
		System.out.println("1. ���ѽɱ�");
		System.out.println("2. ���ֱ�");
		System.out.println("3. ����ֱ�");
		System.out.println("4. �ȱ�");
		System.out.println("5. �������� ���ư���");
		System.out.print(">>");
		
		int usr = sc.nextInt();
		
		if(usr==1) {	//1. ���ѽɱ�
			boolean have = false;
			if(datafield[fieldChoice-1]!=null) {
				System.out.println("�̹� ������� ���Դϴ�.");
			}else {//���� ����ְ� ������ �����ϰ� ������
				for(int i =0; i<invenItemList.size(); i++) {	//�κ��丮 �������� ����(s)�� ������	
					if(invenItemList.get(i).getDiv()=='s' && invenItemList.get(i).getCount()>0) {
						have = true;
						System.out.println((i+1)+"."+invenItemList.get(i).getName()+" : "+
								invenItemList.get(i).getCount()+"��");
					}
					
				}
				if(have ==false) {	//������ ������
					System.out.println("������ ������ �����ϴ�!");
				}else {		
					System.out.print("���� ������ �������ּ��� >>");
					int seedChoice = sc.nextInt();
					
					if(seedChoice>3||seedChoice<1||invenItemList.get(seedChoice-1).getCount()<=0) {
						System.out.println("�߸��� ��ȣ �Դϴ�!");	
					}
					else if(invenItemList.get(seedChoice-1).getCount()>0) {
					int temp = invenItemList.get(seedChoice-1).getCount()-1;
					invenItemList.get(seedChoice-1).setCount(temp);
		
					System.out.println("=============================================================");
					System.out.println(fieldChoice+"��° �翡 "+invenItemList.get(seedChoice-1).getName()+"�� �ɾ����ϴ�! ");
					if(invenItemList.get(seedChoice-1).getName().equals("���� ��� ����")==true) {
						datafield[fieldChoice-1] = new RedRose();
					}else if(invenItemList.get(seedChoice-1).getName().equals("�� ��� ����")==true) {
						datafield[fieldChoice-1] = new WhiteRose();
					}else if(invenItemList.get(seedChoice-1).getName().equals("��� ��� ����")==true) {
						datafield[fieldChoice-1] = new YellowRose();
						}
					}
				}
				showShowField()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ;
			}
		
		}else if(usr==2) {	//2. ���ֱ�
			
			if(datafield[fieldChoice-1]==null)	//�� �翡 ���� �� �� 
			{
				System.out.println("���� �� �۹��� �����ϴ�! ");
				System.out.println("=============================================================");
			}else {
			showShowField();
			if(datafield[fieldChoice-1].isDidiwater()==false) {	//�Ϸ翡 �ѹ��� ���� �ټ��ִ�
				int w = datafield[fieldChoice-1].getWc()+1;
				datafield[fieldChoice-1].setWc(w);
				datafield[fieldChoice-1].setDidiwater(true);
				System.out.println(fieldChoice+"�� �翡 ���� �� "+datafield[fieldChoice-1].getWc()+"�� �־����ϴ�");
				System.out.println("=============================================================");
			}else {
				System.out.println("������ �̹� ���� �־����ϴ�!");
			}
			}
		}else if(usr==3) {	//3. ����ֱ�
			boolean have = false;	//1. �����ֱ�� ����
			
			if(datafield[fieldChoice-1]==null) {
				System.out.println("��Ḧ �� �۹��� �����ϴ� !");
			}else {
			
			for(int i =0; i<invenItemList.size(); i++) {		
				if(invenItemList.get(i).getDiv()=='f' && invenItemList.get(i).getCount()>0) {
					have = true;
					System.out.println((i+1)+"."+invenItemList.get(i).getName()+" : "+
							invenItemList.get(i).getCount()+"��");
				}
			}
			if(have==false) {
				System.out.println("������ ��ᰡ �����ϴ�!");
			}else {	//��Ḧ �����ϰ� �ִ� ���
				System.out.println("=============================================================");
				System.out.print("����� ��Ḧ �������ּ��� >>");
				int fertilChoice = sc.nextInt();
				int temp = invenItemList.get(fertilChoice-1).getCount()-1;
				invenItemList.get(fertilChoice-1).setCount(temp);
				
				if(invenItemList.get(fertilChoice-1).getName().equals("�⺻ ���")) {	
					int w = datafield[fieldChoice-1].getWc();
					w++;			//�⺻��� -���� 1�� �� ȿ��
					datafield[fieldChoice-1].setWc(w);
				}else {	// ��޺�� - ���� 2�� �� ȿ��
					int w = datafield[fieldChoice-1].getWc();
					w = w+2;
					datafield[fieldChoice-1].setWc(w);
				}
				System.out.println(fieldChoice + "��° �翡 ��Ḧ ����Ͽ����ϴ� ");
				showShowField();
			}
		}	
			
		}else if(usr==4) {	//4. �ȱ�
			if(datafield[fieldChoice-1].getWc()>=3) { // ���� ��ü�� �Ǹ�
				System.out.println(datafield[fieldChoice-1].getName()+"�� "+datafield[fieldChoice-1].getSellprice()
						+"G�� �Ľðڽ��ϱ�?");
				System.out.println("1. ��");
				System.out.println("2. �ƴϿ�");
				int ans = sc.nextInt();
				if(ans ==1) {
					inventory.Money += datafield[fieldChoice-1].getSellprice();
					datafield[fieldChoice-1] = null;
					showShowField();
					System.out.println("���� ���: " +inventory.Money);
				}
			}else {
				System.out.println("�۹��� �� �ڶ��� �ʾҽ��ϴ�!");
				System.out.println("=============================================================");
			}
			
			
		}else if(usr ==5) {	//5. �������� ���ư���
			break;
		}
		
		

		}
		}
	}
	
	
	void pairFlower() {		//���� �¿� or ���Ϸ� �ΰ��� �Ǿ����� Ȯ���ϰ�(��ü), Ȯ���� ���� ����� ���ο� ���� �ֺ��� �ǰ� �ϴ� �޼ҵ�  
		
		Random r = new Random();	//����� ���� ���� ���� ��� ���� �ڸ� ���� �����ִ� rindex �� ����
		Random r2 = new Random();	//����� ���� ���� ���� ���� ������ ���� �����ִ� rcolor �� ����
		
		
		
//		if(count <=16) {
		
		for(int i=0;i<16; i++) {	// ��, �� �� ������ ���� ���� ���
			int rindex;
			int count =0;
			int rcolor = r2.nextInt(10)+1; //1~10 
			
			for(int p=0; p<datafield.length; p++) {	//�迭�� �� á���� �ƴ��� �˻�
				if(datafield[p] != null) { // �迭�� ���� ������
					count++;
				
				}
			}
			
			if(count==16)
				break;
			
			while(true) {//rindex�� �̹� ���� �Ǿ��ִ� ���ڰ� ���������� ����
				
				rindex = r.nextInt(datafield.length);
				if(datafield[rindex]==null) {
					break;
				}
			}
			
			
			
			if(i==3||i==7||i==11||i==15) {
				continue;
			}
			else if((datafield[i]!=null&& datafield[i+1]!=null)) {
						if(datafield[i].getWc()>=3 && datafield[i+1].getWc()>=3) {
							if(datafield[i].isDidcross()==true&&datafield[i+1].isDidcross()==true) {
								continue;
							}else {		
							//�������+������
							if((datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')||(datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')) {
								datafield[i].setDidcross(true);
								datafield[i+1].setDidcross(true);
								if(rcolor<=2) {	//20%
									datafield[rindex] = new RedRose();
								}else if(rcolor<=6) { //40%
									datafield[rindex] = new YellowRose();
								
								}else {//60%
									datafield[rindex] = new OrangeRose();
								}
						//���� ���+�����
					}else if((datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')||(datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')) {
							datafield[i].setDidcross(true);
							datafield[i+1].setDidcross(true);
							if(rcolor<=2) {
								datafield[rindex] = new PinkRose();
							}else if(rcolor<=4) {
								datafield[rindex] = new RedRose();
							}else {
								datafield[rindex] = new WhiteRose();
							}
						//���� ���+���� ���
					}else if(datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��') {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
						
						if(rcolor<=6) {
							datafield[rindex] = new BlackRose();
						}else if(rcolor<=8) {
							datafield[rindex] = new RedRose();
						}else {
							datafield[rindex] = new PinkRose();
						}
					
				
				}	//�����+�����
					else if(datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��') {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
					
							if(rcolor<=4) {
								datafield[rindex] = new VioletRose();
							}else {
								datafield[rindex] = new WhiteRose();
							}
						//�������+������
				}else if((datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')||(datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')) {
							datafield[i].setDidcross(true);
							datafield[i+1].setDidcross(true);
							if(rcolor<=4) {
								datafield[rindex] = new OrangeRose();
							}else {
								datafield[rindex] = new BlackRose();
							}	
						//��Ȳ+�������
					}else if((datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')||(datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')) {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
							if(rcolor<= 6) {
								datafield[rindex] = new GreenRose();
							}else {
								datafield[rindex] = new VioletRose();
							}
						//�ʷ����+�ʷ����
					}else if((datafield[i].getColor()=='��'&&datafield[i+1].getColor()=='��')) {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
							if(rcolor<=2) {
								datafield[rindex] = new GoldRose();	// Ȳ����̰� ���ý� ���� ����
							}else if(rcolor<=8) {
								datafield[rindex] = new GreenRose();
							}else {
								datafield[rindex] = new PinkRose();
							}
						
					}
			
			}
						}
		}
		}
		
		for(int j=0; j<12; j++) {	// ��, �Ͽ� �ºپ� ���� �Ǿ��� ���
			int rindex;
			int rcolor = r2.nextInt(10)+1; //1~10 
			int count =0;
			
			for(int p=0; p<datafield.length; p++) {	//�迭�� �� á���� �ƴ��� �˻�
				if(datafield[p] != null) { // �迭�� ���� ������
					count++;
				}
			}
			
			if(count==16)
				break;
			
			while(true) {//rindex�� �̹� ���� �Ǿ��ִ� ���ڰ� ���������� ����
				rindex = r.nextInt(datafield.length);
				if(datafield[rindex]==null) {
					break;
				}
			}
			
			if((datafield[j]!=null&& datafield[j+4]!=null)) {
				if(datafield[j].getWc()>=3 && datafield[j+4].getWc()>=3) {
					if(datafield[j].isDidcross()==true&&datafield[j+4].isDidcross()==true) {
						continue;
					}else {
				if((datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')||(datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')){
						datafield[j].setDidcross(true);
						datafield[j+4].setDidcross(true);
						if(rcolor<=2) {
							datafield[rindex] = new RedRose();
						}else if(rcolor<=6) {
							datafield[rindex] = new YellowRose();
						}else {
							datafield[rindex] = new OrangeRose();
						}
					
				}
				else if ((datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')||(datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')) {
					
						datafield[j].setDidcross(true);
						datafield[j+4].setDidcross(true);
					if(rcolor<=2) {
						datafield[rindex] = new PinkRose();
					}else if(rcolor<=4) {
						datafield[rindex] = new RedRose();
					}else {
						datafield[rindex] = new WhiteRose();
					}
				
			}else if(datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��') {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=6) {
						datafield[rindex] = new BlackRose();
					}else if(rcolor<=8) {
						datafield[rindex] = new RedRose();
					}else {
						datafield[rindex] = new PinkRose();
					}
				
			}else if((datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')) {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=4) {
						datafield[rindex] = new VioletRose();
					}else {
						datafield[rindex] = new WhiteRose();
					}
				
				
			}else if((datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')||(datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')) {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=4) {
						datafield[rindex] = new OrangeRose();
					}else {
						datafield[rindex] = new BlackRose();
					}
				
			}else if((datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')||(datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��')) {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<= 6) {
						datafield[rindex] = new GreenRose();
					}else {
						datafield[rindex] = new VioletRose();
					}
				
			}else if(datafield[j].getColor()=='��'&&datafield[j+4].getColor()=='��') {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=2) {
						datafield[rindex] = new GoldRose();
					}else if(rcolor<=8) {
						datafield[rindex] = new GreenRose();
					}else {
						datafield[rindex] = new PinkRose();
					}
			}
					}	
				
				
				
			}
		}
			
			
			
		}
	}
		
	
	
		

}