package z_wBloomingGame;

public class TimeThread extends Thread{
	Main main;
	int n =0;
	
	
	public TimeThread(Main main) {
		super();
		this.main = main;
	}
	public int time() {
		return n;
	}
	public void run() {
		while(true) {
			n++;
			time();
			try {
				sleep(1000);
				if(n==120) {
					main.day++;
					System.out.println("                              -"+main.day+"일차 입니다.");
					n=0;
					for(int i=0; i<main.field.datafield.length; i++) {
						if(main.field.datafield[i]!=null) {
							main.field.datafield[i].setDidiwater(false);
					}
						}
					main.field.pairFlower();
					main.findGoldRose();
				}
			}catch(Exception e) {
				return;
			}
		}
	}
}
