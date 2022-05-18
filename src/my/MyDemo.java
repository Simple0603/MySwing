package my;

import java.awt.Toolkit;

import javax.swing.JFrame;

import my.util.SwingUtil;

public class MyDemo
{
	public static void main(String args[]) {
		JFrame frame = new MyFrame("Edit Student Information");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 450);
		SwingUtil.centerInScreen(frame);
		frame.setVisible(true);
	}
}
