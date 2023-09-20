package sistema;

import javax.swing.SwingUtilities;

public class Main {
		
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Login frame = new Login(); 
                frame.setUndecorated(true);
                frame.setVisible(true);
             
            }
        });
		
    }
}
