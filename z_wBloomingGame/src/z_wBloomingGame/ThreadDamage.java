package z_wBloomingGame;

import java.util.Random;

public class ThreadDamage extends Thread {
	Main main;
	
	public ThreadDamage(Main main) {
		super();
		this.main = main;
	}
	
	public void run() {
		//40% Ȯ���� ������, �������� �ʵ� ���� ���ϰ� �űⰡ ���� �ִٸ� 0���� �ʱ�ȭ
	
	

	while(true) {
		
	Random r1= new Random();
	Random r2 = new Random();	
	int rx = r1.nextInt(10)+1;
	int ry = r2.nextInt(15);
	if(rx>=1&& rx<=4) {
		if(main.field.datafield[rx]!=null) {
			main.field.datafield[rx]=null;
			System.out.println("                              ***��! "+(rx+1)+"��° ���� �۹��� ������ �������� �׾����ϴ� !!");
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
