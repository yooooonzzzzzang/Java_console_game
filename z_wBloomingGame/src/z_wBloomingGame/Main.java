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
		invenItemList.add(new Item("빨간 장미 씨앗", 100,2,'s'));
		invenItemList.add(new Item("흰 장미 씨앗", 100,2,'s'));
		invenItemList.add(new Item("노란 장미 씨앗", 100,2,'s'));
		invenItemList.add(new Item("기본 비료", 300, 0, 'f'));
		invenItemList.add(new Item("고급 비료", 800, 0,'f'));
		didfindGR =false;
	}
	public void intro() {	//인트로
		
		System.out.println("=============================================================");
		System.out.println("   @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ");
		System.out.println();
		String s ="\t\t 꽃 피우기 게임: 황금장미를 찾아서  @'ㅡㅡ \n\n"
				+ " 주인공  '존 폰 노이만'은 어느 날 잠에서 깨어나니 자신이 異세계 마을인 '그랑펠리체'에\n\n"
				+" 와있다는  것을 깨닫는다. 이 마을에는 황금장미를 피우면 마을의 영원한 평화가 계속된다는  \n\n"
				+" 전설이 있는데, 새로운 이방인 노이만이 마을을 위해 황금장미를 피워야하는 '신의 손'으로  \n\n"
				+" 지정된다. 노이만은 하루 빨리 황금장미를 피우고 이 마을을 떠나고 싶어 하는데 ... \n";
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
	public void ending() {	//엔딩
		System.out.println("==============================================================");
		System.out.println("               축하합니다!");
		System.out.println("        "+day+"일 만에 황금장미를 피워냈습니다.");
		System.out.println("             게임이 종료됩니다. ");
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println("==============================================================");
		System.out.println("   @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ ");
		String s =" 마침내 황금장미를 피워내는데 성공한 '존 폰 노이만'은 황금장미의 특별한 힘 덕분에 \n\n"
				+" 집으로 돌아갈 수 있게 된다. 꽃을 재배하는 일에 재능을 발견한 노이만은 \n\n"
				+" 꽃집을 창업하면서 제 2의 인생을 시작한다. \n\n"
				+" 그의 꽃집은 나날이 번성해 100여개가 넘는 전국 체인점을 열게 되고 노이만은 대부호가 된다.\n\n"
				+" Bravo my LIFE !\n\n"
				+" 지금까지 '꽃 피우기: 황금장미를 찾아서 '를 사랑해주셔서 감사합니다! \n";
		TypeThread endingT = new TypeThread(s);
		endingT.start();
		try {
			endingT.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("   @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ  @'ㅡㅡ");
		System.out.println("==============================================================");
			
			
		
	
	}
	
	void findGoldRose() {
		for(int i=0; i<field.datafield.length; i++) {
			
				if(field.showfield[i]=='황') {
					//ending();
					didfindGR =true;
					
				}
			
		}
	}
//	기본창
	@SuppressWarnings("removal")
	public void initAct() {
		Scanner sc = new Scanner(System.in);
		Music initMusic = new Music("beginner-village.mp3", true);
		initMusic.start();
		
		while(true) {
	
		System.out.println("=============================================================");
		System.out.println();
		System.out.println(day+"일차 입니다.");
		System.out.println("활동을 선택해주세요.");
		System.out.println();
		System.out.println("1. 장미밭 가기");
		System.out.println("2. 상점 가기");
		System.out.println("3. 가방 열기");
		System.out.println("4. 잠자기");
		System.out.println("5. 힌트 보기");
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
			System.out.println("잘못된 번호입니다!");
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
// 게임설명 힌트
	public void hint(){
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("=============================================================");
		System.out.println("1. 게임 방법");
		System.out.println("2. 교배 확률");
		System.out.println("3. 판매 가격");
		System.out.println("4. 돌아가기");
		System.out.print(">>");
		int usr= sc.nextInt();
		if(usr ==1) {
			System.out.println("=============================================================");
			
			System.out.println("밭을 선택하고 씨앗을 심는다. 물을 3회 이상 주기전까지는 묘묙의 상태(우)이며 \r물을 준 횟수가 3회 이상일 시 꽃이 핀다. "
					+"2개의 꽃을 양 옆 혹은 위아래로 붙여두면 \r다음날 주변에 새로 교배된 꽃의 묘묙이 피어난다.\r\n" + 
					"교배를 통해 황금장미를 빠른 시일안에 키워내는 것이 게임의 목표이다. ");
		}else if(usr ==2) {
			System.out.println("=============================================================");
			
			System.out.println("빨강+노랑 : 빨강20%, 노랑40%, 주황40%");
			System.out.println("빨강+흰색: 핑크20%, 빨강20%, 흰색60%");
			System.out.println("빨강+빨강: 검정60%, 빨강20%, 핑크20%");
			System.out.println("흰색+흰색: 보라40%, 흰색60%");
			System.out.println("검정+노랑: 주황40%, 검정60%");
			System.out.println("주황+보라: 초록60%, 보라40%");
			System.out.println("초록+초록: 황금20%, 초록60%, 핑크20%");
		}else if(usr==3) {
			System.out.println("=============================================================");
			
			System.out.println("묘묙(우): 0 G");
			System.out.println("빨간 장미 : 200 G");
			System.out.println("노란 장미: 200 G");
			System.out.println("흰 장미: 200 G");
			System.out.println("주황 장미: 300 G");
			System.out.println("분홍 장미: 600 G");
			System.out.println("보라 장미: 500 G");
			System.out.println("검은 장미: 500 G");
			System.out.println("초록 장미: 700 G");
		}else if(usr==4) {
			break;
		}else {
			System.out.println("잘못된 입력값입니다.");
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

