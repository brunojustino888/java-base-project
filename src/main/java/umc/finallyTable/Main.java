package umc.finallyTable;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class Main {

	public static void main(String[] args) {
		try {
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
	    } catch (Exception evt) {}
	  
	    JFrame f = new JFrame("FinallyTable");

	}

}
