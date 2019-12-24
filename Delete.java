package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class Delete extends JFrame {
	public static final int Width = 320;
	public static final int Heigth = 230;

	Button btn, btn2;
	JTextField jt, jt2, jt3;

	public Delete() {
		setSize(Width, Heigth);
		setLocation(820, 300);
		setTitle(new String("删除："));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("学号：");
		btn = new Button("确定");
		btn.addActionListener(new Enter());
		btn2 = new Button("取消");
		add(lb);
		add(jt);
		add(btn);
		add(btn2);

	}

	class Enter implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Container con = getContentPane();

			if (e.getActionCommand().equals("确定")) {

				con.setBackground(Color.red);

				String sno = jt.getText();

				Connection sin = Dbcon.getconnectin();
				Dbcon.delete(sin, sno);
				JOptionPane.showMessageDialog(null, "信息删除成功!", "信息", JOptionPane.INFORMATION_MESSAGE);
				dispose();

			}
		}
	}

}