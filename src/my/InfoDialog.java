package my;

import af.swing.LayoutBox;
import af.swing.layout.FreeLayout;
import af.swing.layout.Margin;

import java.awt.*;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoDialog extends JDialog
{
	JLabel messageLabel = new JLabel();

	public InfoDialog(Window owner )
	{
		// 调用父类的构造方法，进行初始化
		super ( owner );

		//
		JPanel root = new JPanel();
		this.setContentPane( root );
		root.setLayout( new BorderLayout());

		LayoutBox box = new LayoutBox().layout(new FreeLayout());
		box.bgColor(new Color(0xFCFCFC));
		root.add(box, BorderLayout.CENTER);

		box.add(messageLabel, new Margin(-1, -1, -1, -1));
	}

	public void setMessage(String message){
		messageLabel.setText(message);
	}

	// execute
	public void exec()
	{
		this.setTitle("提示");
		this.setModal( true ); // 模态的，即阻塞模式
		this.setSize(250, 120);

		centerInOwner();

		// 显示对话框，并阻塞等待
		this.setVisible( true ); // 显示对话框，并阻塞
	}

	// 显示在原窗口的中央
	private void centerInOwner()
	{
		// 获取原窗口的位置
		Rectangle ownerRect = this.getOwner().getBounds();

		// 显示在原窗口的中央
		int width = this.getWidth();
		int height = this.getHeight();
		int x = ownerRect.x + (ownerRect.width - width)/2;
		int y = ownerRect.y + (ownerRect.height - height)/2;
		this.setBounds(x,y, width, height);
	}

	// 显示在屏幕中央
	private void centerInScreen()
	{
		// 获取屏幕大小
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		// 显示在屏幕的中央
		int x = ( screenSize.width - this.getWidth())/2;
		int y = ( screenSize.height - this.getHeight())/2;
		this.setLocation(x,  y);
	}

	public static void showMessage(Window owner, String message){
		InfoDialog dlg = new InfoDialog(owner);
		dlg.setMessage(message);
		dlg.exec();
	}
}
