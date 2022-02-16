package z_wBloomingGame;

import java.util.Random;

public class ThreadDamage extends Thread {
	Main main;
	
	public ThreadDamage(Main main) {
		super();
		this.main = main;
	}
	
	public void run() {
		//40% 확률로 병충해, 랜덤으로 필드 값을 정하고 거기가 값이 있다면 0으로 초기화
	
	

	while(true) {
		
	Random r1= new Random();
	Random r2 = new Random();	
	int rx = r1.nextInt(10)+1;
	int ry = r2.nextInt(15);
	if(rx>=1&& rx<=4) {
		if(main.field.datafield[rx]!=null) {
			main.field.datafield[rx]=null;
			System.out.println("                              ***앗! "+(rx+1)+"번째 밭의 작물이 벌레의 공격으로 죽었습니다 !!");
		}
	}
	
	try {
		Thread.sleep(15000);
	}
	catch(Exception e) {
		return;
	}
	}
	}
}
