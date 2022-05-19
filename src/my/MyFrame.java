package my;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.File;

import javax.swing.*;

import af.swing.LayoutBox;
import af.swing.layout.HLayout;
import af.swing.layout.VLayout;
import my.util.TextFileUtil;
import org.json.JSONObject;

public class MyFrame extends JFrame
{
	JButton openButton = new JButton("open");
	JButton saveButton = new JButton("save");
	
	JTextField idField = new JTextField();
	JTextField nameField = new JTextField();
	JComboBox<String> sexField = new JComboBox<>();
	JTextField telField = new JTextField();

	File lastDir = new File(".");
	
	public MyFrame(String title) {
		super(title);
		
		LayoutBox root = new LayoutBox().layout(new BorderLayout());
		this.setContentPane(root);
		
		root.add(initTop(), BorderLayout.NORTH);
		root.add(initCenter(), BorderLayout.CENTER);
		openButton.addActionListener((e) -> load());
		saveButton.addActionListener((e) -> save());
	}
	private JComponent initTop(){
		LayoutBox panel = new LayoutBox().layout(new HLayout());
		panel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(0xA0A0A0)));
		panel.preferredHeight(50).padding(10, 5, 10, 5);
		panel.add(openButton);
		panel.add(saveButton);
		return panel;
	}

	private JComponent initCenter() {
		LayoutBox panel = new LayoutBox().layout(new VLayout());
		panel.padding(10, 10, 10, 150);
		panel.bgColor(new Color(0xFCFCFC));
		panel.add(initFormLine("ID", idField));
		panel.add(initFormLine("Name", nameField));
		panel.add(initFormLine("Sex", sexField));
		panel.add(initFormLine("Tel", telField));
		sexField.addItem("female");
		sexField.addItem("male");
		sexField.setSelectedIndex(1);
		return panel;
	}

	private JComponent initFormLine(String label, JComponent field) {
		LayoutBox formLine = new LayoutBox().layout(new HLayout());
		formLine.preferredHeight(40).padding(5);
		formLine.add(new JLabel(label), "50px");
		formLine.add(field, "1w");
		return formLine;
	}

	private void load(){
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(lastDir);
		int ret = chooser.showOpenDialog(this);
		if(ret == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			lastDir = file.getParentFile();
			try{
				String str = TextFileUtil.read(file, "UTF-8");
				JSONObject json = new JSONObject(str);
				idField.setText(json.getString("id"));
				nameField.setText(json.getString("name"));
				sexField.setSelectedIndex(json.getInt("sex"));
				telField.setText(json.getString("tel"));
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}

	private void save(){
		JSONObject json = new JSONObject();
		if(idField.getText().trim().length() == 0){
			InfoDialog.showMessage(this, "id can't be null");
			return;
		}
		json.put("id", idField.getText());
		json.put("name", nameField.getText());
		json.put("sex", sexField.getSelectedIndex());
		json.put("tel", telField.getText());
		String str = json.toString();

		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(lastDir);
		int ret = chooser.showSaveDialog(this);
		if(ret == JFileChooser.APPROVE_OPTION){
			File file = chooser.getSelectedFile();
			lastDir = file.getParentFile();
			try {
				TextFileUtil.write(file, str, "UTF-8");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
