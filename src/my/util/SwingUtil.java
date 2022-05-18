package my.util;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;

public class SwingUtil
{
	public static void centerInOwner(Window win, Window owner) {
		Rectangle ownerRect = owner.getBounds();
		
		int width = win.getWidth();
		int height = win.getHeight();
		int x = ownerRect.x + (ownerRect.width - width) / 2;
		int y = ownerRect.y + (ownerRect.height - height) / 2;
		win.setBounds(x, y, width, height);
	}
	
	public static void centerInScreen(Window win) {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		
		int x = (screenSize.width - win.getWidth()) / 2;
		int y = (screenSize.height - win.getHeight()) / 2;
		win.setLocation(x, y);
	}
}
