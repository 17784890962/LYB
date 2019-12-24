package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class LoginIn extends JFrame {
	JTextField f1;
	JTextField f2;
	JButton b1;
	JButton b2;
	String imgePath = "image.jpg";
	JPanel p5;
	Image img = Toolkit.getDefaultToolkit().createImage(imgePath);

	LoginIn() {
		Container cp = getContentPane();

		Label l1 = new Label("用户：");
		Label l2 = new Label("密码：");

		JPanel p1 = new JPanel();
		JPanel p2 = new JPanel();
		JPanel p3 = new JPanel();
		JPanel p4 = new JPanel();
		p5 = new JPanel() {
			protected void paintChildren(Graphics g) {
				g.drawImage(img, 0, 0, this);
				super.paintChildren(g);
			}
		};

		f1 = new JTextField(15);
		f2 = new JPasswordField(15);
		b1 = new JButton("登录");
		b2 = new JButton("重置");
		p2.add(l1);
		p2.add(f1);
		p2.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
		p2.setBackground(Color.ORANGE);
		p3.add(l2);
		p3.add(f2);
		p3.setBackground(Color.ORANGE);
		p3.setBorder(new MatteBorder(0, 0, 0, 0, Color.BLACK));
		p4.add(b1);
		p4.add(b2);
		p4.setBorder(new MatteBorder(-3, -3, -3, -3, Color.CYAN));
		p4.setBackground(Color.ORANGE);
		p5.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		p5.add(p2);
		p5.add(p3);
		p5.add(p4);
		cp.add(p5, BorderLayout.CENTER);

		b1.addActionListener(new Enter());
		b2.addActionListener(new ReWrite());
		addWindowListener(new winClose());
	}

	public static void main(String[] args) {
		LoginIn log = new LoginIn();
		log.setIconImage(Toolkit.getDefaultToolkit().createImage(""));
		log.setTitle("学生管理系统");
		log.setLocation(800, 300);
		log.setSize(400, 300);
		log.setVisible(true);

	}

	class Enter implements ActionListener {
		@SuppressWarnings("deprecation")
		public void actionPerformed(ActionEvent e) {
			if ((f1.getText()).equals("root") && (f2.getText()).equals("root")) {
				JOptionPane.showMessageDialog(null, "登录成功！");
				Qframe frame = new Qframe();
				frame.setIconImage(Toolkit.getDefaultToolkit().createImage(""));
				frame.setLocation(800, 300);
				frame.resize(500, 285);
				frame.show();
				dispose();

			}

			else
				JOptionPane.showMessageDialog(null, "登录失败，请重新登录！");
		}
	}

	class ReWrite implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			f1.setText("");
			f2.setText("");
			f1.requestFocus();
		}
	}

	class winClose extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			(e.getWindow()).dispose();
			System.exit(0);
		}
	}
}