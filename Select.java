package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;

public class Select extends JFrame {
	public static final int Width = 320;
	public static final int Heigth = 230;

	Button btn, btn2;
	JTextField jt, jt2, jt3;

	public Select() {
		setSize(Width, Heigth);
		setLocation(820, 300);
		setTitle(new String("查询："));
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

				Connection sin = Dbcon.getconnectin();
				String sno = jt.getText();
				ResultSet rs = null;
				PreparedStatement stmt = null;
				try {

					stmt = sin.prepareStatement("select * from student where sno=?");
					stmt.setObject(1, sno);
					rs = stmt.executeQuery();
					while (rs.next()) {
						String msg = rs.getString("sno") + "\t" + rs.getString("sname") + "\t" + rs.getString("ssex")
								+ "\t" + rs.getString("sage") + "\t" + rs.getString("sclass") + "\t"
								+ rs.getString("smajor") + "\n";
						JOptionPane.showMessageDialog(null, msg, "查询结果：", JOptionPane.NO_OPTION);
					}
				} catch (SQLException h) {
					// TODO Auto-generated catch block
					h.printStackTrace();
				}
			}

			dispose();

		}
	}
}
