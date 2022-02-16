package z_wBloomingGame;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{

	public ArrayList<Item> invenItemList;
	static int day =1;
	Shop shop = new Shop();
	Field field = new Field();
	Inventory inventory = new Inventory();
	boolean didfindGR;
	

	public Main() {
		invenItemList = new ArrayList<Item>();
		invenItemList.add(new Item("���� ��� ����", 100,2,'s'));
		invenItemList.add(new Item("�� ��� ����", 100,2,'s'));
		invenItemList.add(new Item("��� ��� ����", 100,2,'s'));
		invenItemList.add(new Item("�⺻ ���", 300, 0, 'f'));
		invenItemList.add(new Item("��� ���", 800, 0,'f'));
		didfindGR =false;
	}
	public void intro() {	//��Ʈ��
		
		System.out.println("=============================================================");
		System.out.println("   @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�");
		System.out.println();
		String s ="\t\t �� �ǿ�� ����: Ȳ����̸� ã�Ƽ�  @'�Ѥ� \n\n"
				+ " ���ΰ�  '�� �� ���̸�'�� ��� �� �ῡ�� ����� �ڽ��� 춼��� ������ '�׶��縮ü'��\n\n"
				+" ���ִٴ�  ���� ���ݴ´�. �� �������� Ȳ����̸� �ǿ�� ������ ������ ��ȭ�� ��ӵȴٴ�  \n\n"
				+" ������ �ִµ�, ���ο� �̹��� ���̸��� ������ ���� Ȳ����̸� �ǿ����ϴ� '���� ��'����  \n\n"
				+" �����ȴ�. ���̸��� �Ϸ� ���� Ȳ����̸� �ǿ�� �� ������ ������ �;� �ϴµ� ... \n";
		TypeThread introT = new TypeThread(s);
		introT.setPriority(1);
		introT.start();
		try {
			introT.join();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void ending() {	//����
		System.out.println("==============================================================");
		System.out.println("               �����մϴ�!");
		System.out.println("        "+day+"�� ���� Ȳ����̸� �ǿ��½��ϴ�.");
		System.out.println("             ������ ����˴ϴ�. ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("   @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ� ");
		String s =" ��ħ�� Ȳ����̸� �ǿ����µ� ������ '�� �� ���̸�'�� Ȳ������� Ư���� �� ���п� \n\n"
				+" ������ ���ư� �� �ְ� �ȴ�. ���� ����ϴ� �Ͽ� ����� �߰��� ���̸��� \n\n"
				+" ������ â���ϸ鼭 �� 2�� �λ��� �����Ѵ�. \n\n"
				+" ���� ������ ������ ������ 100������ �Ѵ� ���� ü������ ���� �ǰ� ���̸��� ���ȣ�� �ȴ�.\n\n"
				+" Bravo my LIFE !\n\n"
				+" ���ݱ��� '�� �ǿ��: Ȳ����̸� ã�Ƽ� '�� ������ּż� �����մϴ�! \n";
		TypeThread endingT = new TypeThread(s);
		endingT.start();
		try {
			endingT.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("   @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�  @'�Ѥ�");
		System.out.println("==============================================================");
			
			
		
	
	}
	
	void findGoldRose() {
		for(int i=0; i<field.datafield.length; i++) {
			
				if(field.showfield[i]=='Ȳ') {
					//ending();
					didfindGR =true;
					
				}
			
		}
	}
//	�⺻â
	@SuppressWarnings("removal")
	public void initAct() {
		Scanner sc = new Scanner(System.in);
		Music initMusic = new Music("beginner-village.mp3", true);
		initMusic.start();
		
		while(true) {
	
		System.out.println("=============================================================");
		System.out.println();
		System.out.println(day+"���� �Դϴ�.");
		System.out.println("Ȱ���� �������ּ���.");
		System.out.println();
		System.out.println("1. ��̹� ����");
		System.out.println("2. ���� ����");
		System.out.println("3. ���� ����");
		System.out.println("4. ���ڱ�");
		System.out.println("5. ��Ʈ ����");
		System.out.print(">>");
		int usr = sc.nextInt();
	
		if(usr==1) {
			initMusic.suspend();
			Music fieldMusic = new Music("a-good-day.mp3",true);
			fieldMusic.start();
			field.showShowField();
			field.fieldAct(invenItemList, inventory);
			fieldMusic.close();
			initMusic.resume();
		}else if(usr == 2) {
			initMusic.suspend();
			Music shopMusic = new Music("pit-a-pat.mp3", true);
			shopMusic.start();
			shop.purchase(invenItemList, inventory);
			shopMusic.close();
			initMusic.resume();
		}else if(usr ==3) {
			inventory.showInventory(invenItemList, inventory);
			
		}else if(usr ==4) {
			day++;
			for(int i=0; i<field.datafield.length; i++) {
				if(field.datafield[i]!=null) {
				field.datafield[i].setDidiwater(false);
			}
				}
			field.pairFlower();
			findGoldRose();
			
		}else if(usr == 5) {
			hint();
			}
		else {
			System.out.println("�߸��� ��ȣ�Դϴ�!");
		}
		if(didfindGR==true) {
			Music findGR = new Music("findGR.mp3", true);
			findGR.start();
			ending();
			findGR.stop();
			System.exit(0);
		}
		}  
	};
// ���Ӽ��� ��Ʈ
	public void hint(){
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("=============================================================");
		System.out.println("1. ���� ���");
		System.out.println("2. ���� Ȯ��");
		System.out.println("3. �Ǹ� ����");
		System.out.println("4. ���ư���");
		System.out.print(">>");
		int usr= sc.nextInt();
		if(usr ==1) {
			System.out.println("=============================================================");
			
			System.out.println("���� �����ϰ� ������ �ɴ´�. ���� 3ȸ �̻� �ֱ��������� ������ ����(��)�̸� \r���� �� Ƚ���� 3ȸ �̻��� �� ���� �ɴ�. "
					+"2���� ���� �� �� Ȥ�� ���Ʒ��� �ٿ��θ� \r������ �ֺ��� ���� ����� ���� ������ �Ǿ��.\r\n" + 
					"���踦 ���� Ȳ����̸� ���� ���Ͼȿ� Ű������ ���� ������ ��ǥ�̴�. ");
		}else if(usr ==2) {
			System.out.println("=============================================================");
			
			System.out.println("����+��� : ����20%, ���40%, ��Ȳ40%");
			System.out.println("����+���: ��ũ20%, ����20%, ���60%");
			System.out.println("����+����: ����60%, ����20%, ��ũ20%");
			System.out.println("���+���: ����40%, ���60%");
			System.out.println("����+���: ��Ȳ40%, ����60%");
			System.out.println("��Ȳ+����: �ʷ�60%, ����40%");
			System.out.println("�ʷ�+�ʷ�: Ȳ��20%, �ʷ�60%, ��ũ20%");
		}else if(usr==3) {
			System.out.println("=============================================================");
			
			System.out.println("����(��): 0 G");
			System.out.println("���� ��� : 200 G");
			System.out.println("��� ���: 200 G");
			System.out.println("�� ���: 200 G");
			System.out.println("��Ȳ ���: 300 G");
			System.out.println("��ȫ ���: 600 G");
			System.out.println("���� ���: 500 G");
			System.out.println("���� ���: 500 G");
			System.out.println("�ʷ� ���: 700 G");
		}else if(usr==4) {
			break;
		}else {
			System.out.println("�߸��� �Է°��Դϴ�.");
		}
	
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		Main main = new Main();
		main.intro();
		TimeThread t1 = new TimeThread(main);
		t1.start();
		ThreadDamage t2 = new ThreadDamage(main);
		t2.start();

		main.initAct();
		

	}

}

