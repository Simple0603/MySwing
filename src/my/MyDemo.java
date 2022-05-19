package my;


import my.util.SwingUtil;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.JFrame;


public class MyDemo
{
	public static void main(String[] args)
	{
		JFrame frame = new MyFrame("列表框测试");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 450);

		// 显示在屏幕中央
		SwingUtil.centerInScreen(frame);

		frame.setVisible(true);
	}
}
