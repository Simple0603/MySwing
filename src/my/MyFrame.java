package my;



import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class MyFrame extends JFrame
{

	public MyFrame(String title)
	{
		super(title);

		JPanel root = new JPanel();
		root.setLayout(new BorderLayout());
		this.setContentPane(root);

		// 1 创建列表框
		JList<String> listbox = new JList<>();

		// 2 滚动条支持
		JScrollPane scrollPane = new JScrollPane(listbox);

		// 3 添加到主界面
		root.add(scrollPane, BorderLayout.CENTER);

		// 4 设置列表数据
		DefaultListModel<String> model = new DefaultListModel<>();
		model.addElement("罗亚");
		model.addElement("爱丽莎");
		model.addElement("诺艾尔");
		model.addElement("夏洛特");
		model.addElement("莉莉安");
		model.addElement("威廉敏娜");
		model.addElement("保罗");
		model.addElement("卡帝亚");
		model.addElement("约翰");
		model.addElement("雷顿");
		model.addElement("安东尼奥");
		model.addElement("艾丝翠德");
		model.addElement("卡洛琳");
		model.addElement("母神");
		model.addElement("救世主");
		model.addElement("希雅");
		listbox.setModel(model); // 显示数据
	}


}
