package z_wBloomingGame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Field {
	Flower[] datafield = new Flower[16];	//실제 데이터가 들어간 배열
	char[] showfield = new char[16];		//console 출력용 배열 
	

	void showShowField() {	//밭을 출력해주는 메소드
		System.out.println("━━━━━━━━━━━━━━━━━━ 장미밭 ━━━━━━━━━━━━━━━━━━");
		for(int i=0; i<datafield.length; i++) {
			if(datafield[i]==null) {	//빈 값 
					showfield[i]= 'ㅁ';
			}else if(datafield[i].getWc()<3)	{ //개화하기전의 꽃 봉오리
				showfield[i]='우';
			}else if(datafield[i].isDidiwater()==false){	//물을 3번이상 주면 성체가 됨
				showfield[i]=datafield[i].getColor();	//꽃 색의 글자가 나오면 성체가 된것이다.
			}
			}
		for(int i=0; i<9; i++) {	//밭 출력
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
		System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
		}

	
	void fieldAct(ArrayList<Item> invenItemList, Inventory inventory) { //밭에서 활동할 수 있는 선택지
		while(true) {
		Scanner sc = new Scanner(System.in);
		System.out.println("0: 메인으로 돌아가기 ");
		System.out.println("1~16: 밭 선택 ");
		System.out.print(">>");
		
		int fieldChoice = sc.nextInt();
		if(fieldChoice == 0) {
			break;
		}else if(fieldChoice-1>datafield.length) {
			System.out.println("잘못된 숫자를 입력하였습니다");
			System.out.println("=============================================================");
		}
		else {
			System.out.println("=============================================================");
		System.out.println(fieldChoice+"번 밭이 선택되었습니다.");
		System.out.println("");
		System.out.println("1. 씨앗심기");
		System.out.println("2. 물주기");
		System.out.println("3. 비료주기");
		System.out.println("4. 팔기");
		System.out.println("5. 메인으로 돌아가기");
		System.out.print(">>");
		
		int usr = sc.nextInt();
		
		if(usr==1) {	//1. 씨앗심기
			boolean have = false;
			if(datafield[fieldChoice-1]!=null) {
				System.out.println("이미 재배중인 밭입니다.");
			}else {//밭이 비어있고 씨앗을 소지하고 있을때
				for(int i =0; i<invenItemList.size(); i++) {	//인벤토리 아이템중 씨앗(s)만 가져옴	
					if(invenItemList.get(i).getDiv()=='s' && invenItemList.get(i).getCount()>0) {
						have = true;
						System.out.println((i+1)+"."+invenItemList.get(i).getName()+" : "+
								invenItemList.get(i).getCount()+"개");
					}
					
				}
				if(have ==false) {	//씨앗이 없을때
					System.out.println("소지한 씨앗이 없습니다!");
				}else {		
					System.out.print("심을 씨앗을 선택해주세요 >>");
					int seedChoice = sc.nextInt();
					
					if(seedChoice>3||seedChoice<1||invenItemList.get(seedChoice-1).getCount()<=0) {
						System.out.println("잘못된 번호 입니다!");	
					}
					else if(invenItemList.get(seedChoice-1).getCount()>0) {
					int temp = invenItemList.get(seedChoice-1).getCount()-1;
					invenItemList.get(seedChoice-1).setCount(temp);
		
					System.out.println("=============================================================");
					System.out.println(fieldChoice+"번째 밭에 "+invenItemList.get(seedChoice-1).getName()+"을 심었습니다! ");
					if(invenItemList.get(seedChoice-1).getName().equals("빨간 장미 씨앗")==true) {
						datafield[fieldChoice-1] = new RedRose();
					}else if(invenItemList.get(seedChoice-1).getName().equals("흰 장미 씨앗")==true) {
						datafield[fieldChoice-1] = new WhiteRose();
					}else if(invenItemList.get(seedChoice-1).getName().equals("노란 장미 씨앗")==true) {
						datafield[fieldChoice-1] = new YellowRose();
						}
					}
				}
				showShowField()                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      ;
			}
		
		}else if(usr==2) {	//2. 물주기
			
			if(datafield[fieldChoice-1]==null)	//빈 밭에 물을 줄 때 
			{
				System.out.println("물을 줄 작물이 없습니다! ");
				System.out.println("=============================================================");
			}else {
			showShowField();
			if(datafield[fieldChoice-1].isDidiwater()==false) {	//하루에 한번만 물을 줄수있다
				int w = datafield[fieldChoice-1].getWc()+1;
				datafield[fieldChoice-1].setWc(w);
				datafield[fieldChoice-1].setDidiwater(true);
				System.out.println(fieldChoice+"번 밭에 물을 총 "+datafield[fieldChoice-1].getWc()+"번 주었습니다");
				System.out.println("=============================================================");
			}else {
				System.out.println("오늘은 이미 물을 주었습니다!");
			}
			}
		}else if(usr==3) {	//3. 비료주기
			boolean have = false;	//1. 씨앗주기와 동일
			
			if(datafield[fieldChoice-1]==null) {
				System.out.println("비료를 줄 작물이 없습니다 !");
			}else {
			
			for(int i =0; i<invenItemList.size(); i++) {		
				if(invenItemList.get(i).getDiv()=='f' && invenItemList.get(i).getCount()>0) {
					have = true;
					System.out.println((i+1)+"."+invenItemList.get(i).getName()+" : "+
							invenItemList.get(i).getCount()+"개");
				}
			}
			if(have==false) {
				System.out.println("소지한 비료가 없습니다!");
			}else {	//비료를 소지하고 있는 경우
				System.out.println("=============================================================");
				System.out.print("사용할 비료를 선택해주세요 >>");
				int fertilChoice = sc.nextInt();
				int temp = invenItemList.get(fertilChoice-1).getCount()-1;
				invenItemList.get(fertilChoice-1).setCount(temp);
				
				if(invenItemList.get(fertilChoice-1).getName().equals("기본 비료")) {	
					int w = datafield[fieldChoice-1].getWc();
					w++;			//기본비료 -물을 1번 준 효과
					datafield[fieldChoice-1].setWc(w);
				}else {	// 고급비료 - 물을 2번 준 효과
					int w = datafield[fieldChoice-1].getWc();
					w = w+2;
					datafield[fieldChoice-1].setWc(w);
				}
				System.out.println(fieldChoice + "번째 밭에 비료를 사용하였습니다 ");
				showShowField();
			}
		}	
			
		}else if(usr==4) {	//4. 팔기
			if(datafield[fieldChoice-1].getWc()>=3) { // 꽃이 성체가 되면
				System.out.println(datafield[fieldChoice-1].getName()+"를 "+datafield[fieldChoice-1].getSellprice()
						+"G에 파시겠습니까?");
				System.out.println("1. 예");
				System.out.println("2. 아니오");
				int ans = sc.nextInt();
				if(ans ==1) {
					inventory.Money += datafield[fieldChoice-1].getSellprice();
					datafield[fieldChoice-1] = null;
					showShowField();
					System.out.println("소지 골드: " +inventory.Money);
				}
			}else {
				System.out.println("작물이 다 자라지 않았습니다!");
				System.out.println("=============================================================");
			}
			
			
		}else if(usr ==5) {	//5. 메인으로 돌아가기
			break;
		}
		
		

		}
		}
	}
	
	
	void pairFlower() {		//꽃이 좌우 or 상하로 두개가 피었는지 확인하고(성체), 확률에 따라 교배된 새로운 꽃이 주변에 피게 하는 메소드  
		
		Random r = new Random();	//교배된 새로 생긴 꽃이 어디에 필지 자리 값을 정해주는 rindex 용 랜덤
		Random r2 = new Random();	//교배된 새로 생긴 꽃이 무슨 색으로 필지 정해주는 rcolor 용 랜덤
		
		
		
//		if(count <=16) {
		
		for(int i=0;i<16; i++) {	// 좌, 우 에 나란히 꽃이 있을 경우
			int rindex;
			int count =0;
			int rcolor = r2.nextInt(10)+1; //1~10 
			
			for(int p=0; p<datafield.length; p++) {	//배열이 다 찼는지 아닌지 검사
				if(datafield[p] != null) { // 배열에 값이 있으면
					count++;
				
				}
			}
			
			if(count==16)
				break;
			
			while(true) {//rindex가 이미 꽃이 피어있는 숫자가 나왔을때를 방지
				
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
							//빨간장미+노란장미
							if((datafield[i].getColor()=='빨'&&datafield[i+1].getColor()=='노')||(datafield[i].getColor()=='노'&&datafield[i+1].getColor()=='빨')) {
								datafield[i].setDidcross(true);
								datafield[i+1].setDidcross(true);
								if(rcolor<=2) {	//20%
									datafield[rindex] = new RedRose();
								}else if(rcolor<=6) { //40%
									datafield[rindex] = new YellowRose();
								
								}else {//60%
									datafield[rindex] = new OrangeRose();
								}
						//빨간 장미+흰장미
					}else if((datafield[i].getColor()=='빨'&&datafield[i+1].getColor()=='흰')||(datafield[i].getColor()=='흰'&&datafield[i+1].getColor()=='빨')) {
							datafield[i].setDidcross(true);
							datafield[i+1].setDidcross(true);
							if(rcolor<=2) {
								datafield[rindex] = new PinkRose();
							}else if(rcolor<=4) {
								datafield[rindex] = new RedRose();
							}else {
								datafield[rindex] = new WhiteRose();
							}
						//빨간 장미+빨간 장미
					}else if(datafield[i].getColor()=='빨'&&datafield[i+1].getColor()=='빨') {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
						
						if(rcolor<=6) {
							datafield[rindex] = new BlackRose();
						}else if(rcolor<=8) {
							datafield[rindex] = new RedRose();
						}else {
							datafield[rindex] = new PinkRose();
						}
					
				
				}	//흰장미+흰장미
					else if(datafield[i].getColor()=='흰'&&datafield[i+1].getColor()=='흰') {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
					
							if(rcolor<=4) {
								datafield[rindex] = new VioletRose();
							}else {
								datafield[rindex] = new WhiteRose();
							}
						//검은장미+노란장미
				}else if((datafield[i].getColor()=='검'&&datafield[i+1].getColor()=='노')||(datafield[i].getColor()=='노'&&datafield[i+1].getColor()=='검')) {
							datafield[i].setDidcross(true);
							datafield[i+1].setDidcross(true);
							if(rcolor<=4) {
								datafield[rindex] = new OrangeRose();
							}else {
								datafield[rindex] = new BlackRose();
							}	
						//주황+보라장미
					}else if((datafield[i].getColor()=='주'&&datafield[i+1].getColor()=='보')||(datafield[i].getColor()=='보'&&datafield[i+1].getColor()=='주')) {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
							if(rcolor<= 6) {
								datafield[rindex] = new GreenRose();
							}else {
								datafield[rindex] = new VioletRose();
							}
						//초록장미+초록장미
					}else if((datafield[i].getColor()=='초'&&datafield[i+1].getColor()=='초')) {
						datafield[i].setDidcross(true);
						datafield[i+1].setDidcross(true);
							if(rcolor<=2) {
								datafield[rindex] = new GoldRose();	// 황금장미가 나올시 게임 엔딩
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
		
		for(int j=0; j<12; j++) {	// 상, 하에 맞붙어 꽃이 피었을 경우
			int rindex;
			int rcolor = r2.nextInt(10)+1; //1~10 
			int count =0;
			
			for(int p=0; p<datafield.length; p++) {	//배열이 다 찼는지 아닌지 검사
				if(datafield[p] != null) { // 배열에 값이 있으면
					count++;
				}
			}
			
			if(count==16)
				break;
			
			while(true) {//rindex가 이미 꽃이 피어있는 숫자가 나왔을때를 방지
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
				if((datafield[j].getColor()=='빨'&&datafield[j+4].getColor()=='노')||(datafield[j].getColor()=='노'&&datafield[j+4].getColor()=='빨')){
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
				else if ((datafield[j].getColor()=='빨'&&datafield[j+4].getColor()=='흰')||(datafield[j].getColor()=='흰'&&datafield[j+4].getColor()=='빨')) {
					
						datafield[j].setDidcross(true);
						datafield[j+4].setDidcross(true);
					if(rcolor<=2) {
						datafield[rindex] = new PinkRose();
					}else if(rcolor<=4) {
						datafield[rindex] = new RedRose();
					}else {
						datafield[rindex] = new WhiteRose();
					}
				
			}else if(datafield[j].getColor()=='빨'&&datafield[j+4].getColor()=='빨') {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=6) {
						datafield[rindex] = new BlackRose();
					}else if(rcolor<=8) {
						datafield[rindex] = new RedRose();
					}else {
						datafield[rindex] = new PinkRose();
					}
				
			}else if((datafield[j].getColor()=='흰'&&datafield[j+4].getColor()=='흰')) {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=4) {
						datafield[rindex] = new VioletRose();
					}else {
						datafield[rindex] = new WhiteRose();
					}
				
				
			}else if((datafield[j].getColor()=='검'&&datafield[j+4].getColor()=='노')||(datafield[j].getColor()=='노'&&datafield[j+4].getColor()=='검')) {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<=4) {
						datafield[rindex] = new OrangeRose();
					}else {
						datafield[rindex] = new BlackRose();
					}
				
			}else if((datafield[j].getColor()=='주'&&datafield[j+4].getColor()=='보')||(datafield[j].getColor()=='보'&&datafield[j+4].getColor()=='주')) {
				
					datafield[j].setDidcross(true);
					datafield[j+4].setDidcross(true);
					if(rcolor<= 6) {
						datafield[rindex] = new GreenRose();
					}else {
						datafield[rindex] = new VioletRose();
					}
				
			}else if(datafield[j].getColor()=='초'&&datafield[j+4].getColor()=='초') {
				
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