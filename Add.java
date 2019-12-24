package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class Add extends JFrame {
	public static final int Width = 320;
	public static final int Heigth = 230;

	Button btn, btn2;
	JTextField jt, jt2, jt3, jt4, jt5, jt6;

	public Add() {
		setSize(Width, Heigth);
		setLocation(820, 300);
		setTitle(new String("增加"));
		setLayout(new FlowLayout());
		Container con = getContentPane();
		jt = new JTextField(20);
		Label lb = new Label("学号：");
		jt2 = new JTextField(20);
		Label lb2 = new Label("姓名：");
		jt3 = new JTextField(20);
		Label lb3 = new Label("性别：");
		jt4 = new JTextField(20);
		Label lb4 = new Label("年龄：");
		jt5 = new JTextField(20);
		Label lb5 = new Label("班级：");
		jt6 = new JTextField(20);
		Label lb6 = new Label("专业：");
		btn = new Button("添加");
		btn.addActionListener(new Enter());
		btn2 = new Button("取消");
		add(lb);
		add(jt);
		add(lb2);
		add(jt2);
		add(lb3);
		add(jt3);
		add(lb4);
		add(jt4);
		add(lb5);
		add(jt5);
		add(lb6);
		add(jt6);
		add(btn);
		add(btn2);

	}

	class Enter implements ActionListener {

		public void actionPerformed(ActionEvent e) {

			Container con = getContentPane();
			Add ad = new Add();

			if (e.getActionCommand().equals("添加")) {

				con.setBackground(Color.green);

				String sno = jt.getText();
				String sname = jt2.getText();
				String ssex = jt3.getText();
				String sage = jt4.getText();
				String sclass = jt5.getText();
				String smajor = jt6.getText();
				Object str[] = { sno, sname, ssex, sage, sclass, smajor };
				Connection sin = Dbcon.getconnectin();
				Dbcon.insert(sin, str);
				JOptionPane.showMessageDialog(null, "添加成功!", "操作提示", JOptionPane.NO_OPTION);
				dispose();

			}
		}
	}
}
