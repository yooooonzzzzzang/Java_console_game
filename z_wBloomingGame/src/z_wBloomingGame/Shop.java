
package z_wBloomingGame;

import java.util.ArrayList;
import java.util.Scanner;


public class Shop {	//상점
	ArrayList<Item>shopItemList; //아이템 클래스를 받는 ArrayList shopItemList

	public Shop() {
		shopItemList=new ArrayList<Item>();	
		shopItemList.add(new Item("빨간 장미 씨앗", 100, "쉽게 구할 수 있는 빨간 장미 씨앗"));
		shopItemList.add(new Item("흰 장미 씨앗", 100, "쉽게 구할 수 있는 흰 장미 씨앗"));
		shopItemList.add(new Item("노란 장미 씨앗", 100, "쉽게 구할 수 있는 노란 장미 씨앗"));
		shopItemList.add(new Item("기본 비료", 300, "물을 1회 준 효과와 동일하다"));
		shopItemList.add(new Item("고급 비료", 800, "물을 2회 준 효과와 동일하다"));
	}
	
	
	void show() {	//상점에서 파는 아이템을 보여줌
		
		System.out.println("┏━━━━━━━━━━━━━━━━상점━━━━━━━━━━━━━━━━┓");
		System.out.println();
		for(int i=0; i<shopItemList.size(); i++) {
			
		System.out.println("      "+(i+1)+". "+shopItemList.get(i).getName()+
					": "+ shopItemList.get(i).getPrice()+" G");
		System.out.println("\t -"+ shopItemList.get(i).getExplan());
			
		}
		System.out.println("      "+"6. 나가기");
		System.out.println();
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		
		
	}
	// 아이템 구매 메소드
		void purchase(ArrayList<Item> invenItemList, Inventory inventory) {	
		Scanner sc= new Scanner(System.in);
		while(true) {
		show();
		System.out.println("\t소지 골드: "+ inventory.Money+" G");
		System.out.print(">>");
		int usr = sc.nextInt();
		
		if(usr == 6) {	//나가기
			break;
		}else if(usr >=1 && usr <=5){
		if(inventory.Money >= invenItemList.get(usr-1).getPrice()) {	//소지금> 아이템의 가격
			inventory.Money = inventory.Money - invenItemList.get(usr-1).getPrice(); //아이템 가격만큼 소지금 감소
			int temp = invenItemList.get(usr-1).getCount()+1;	//가방에 구매한 아이템 개수 하나 증가 
			invenItemList.get(usr-1).setCount(temp);
			System.out.println("=============================================================");
			System.out.println("구매가 완료되었습니다");
			System.out.println("소지 골드: "+inventory.Money);
		}else {
			System.out.println("골드가 부족합니다.");
		}
		

			}else {	//1~6 외의 숫자를 입력했을때
				System.out.println("=============================================================");
				System.out.println("잘못된 번호 입니다 ");
			}
		}
	}
	
	
	
	
	
	
}
