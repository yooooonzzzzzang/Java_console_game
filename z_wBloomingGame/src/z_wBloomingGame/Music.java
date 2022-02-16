package z_wBloomingGame;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {

	Player player;
	boolean isLoop;
	
	File file;
	FileInputStream fis;
	BufferedInputStream bis;
	
	public Music(String name, boolean isLoop) {
		this.isLoop = isLoop;
		
		try {
			file = new File(Main.class.getResource("../Music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			
		}catch(Exception e) {
			System.out.println("getResource Music Error");
		}
	}
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	public void run() {
		try {
			do {
			player.play();
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
			}while(isLoop);
			
		}catch(Exception e) {
			System.out.println("Musiuc run error");
		}
	}
}
