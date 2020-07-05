
import java.io.*;

import javax.swing.JFrame;

public class VorkathLootTrackerMain {

	
	public static void main(String[] args)  throws IOException {
		//VorkathLootTrackerBack
		
		VorkathLootTrackerBack window = new VorkathLootTrackerBack();
		window.setSize(230, 320);
		window.setVisible(true);
		window.setTitle("Vorkath Loot Tracker");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //makes it so it closes out in memory
		window.setResizable(false);
		
		

	}
	
	
	

}
