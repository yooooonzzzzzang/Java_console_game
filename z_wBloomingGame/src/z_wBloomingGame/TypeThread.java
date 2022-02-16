package z_wBloomingGame;

public class TypeThread extends Thread {
	String s;
	public TypeThread(String s) {
		this.s = s;
	}
	public void run() {
		try {
			for(int i=0; i<s.length(); i++) {
				Thread.sleep(25);
				System.out.print(s.charAt(i));
			}
		}catch(Exception e) {
			return;
		}
	}
}
