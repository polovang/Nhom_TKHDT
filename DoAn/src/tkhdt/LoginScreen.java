package tkhdt;


import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginScreen extends JFrame implements ActionListener {
	private JTextField username;
	private JPasswordField password;
	private JButton loginButton;

	public void createView() {
		JFrame frame = new JFrame("Màn Hình Đăng Nhập");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setLocation(600, 350);
		frame.setLayout(new BorderLayout());

		frame.add(addLoginAndPass(), BorderLayout.CENTER);
		frame.add(addButtonLogin(), BorderLayout.SOUTH);

		frame.pack();
		frame.setVisible(true);
	}

	public JPanel addLoginAndPass() {
		JPanel panel = new JPanel();

		panel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		JLabel userLabel = new JLabel("Tên đăng nhập:");
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 10, 10);
		panel.add(userLabel, c);

		username = new JTextField(20);
		c.gridx = 1;
		c.gridy = 0;
		panel.add(username, c);

		JLabel passLabel = new JLabel("Mật khẩu:");
		c.gridx = 0;
		c.gridy = 1;
		panel.add(passLabel, c);

		password = new JPasswordField(20);
		c.gridx = 1;
		c.gridy = 1;
		panel.add(password, c);

		return panel;
	}

	public JPanel addButtonLogin() {
		JPanel panel = new JPanel();
		loginButton = new JButton("Đăng nhập");
		loginButton.addActionListener(this);
		panel.add(loginButton);
		return panel;
	}

	public static void main(String[] args) {
		LoginScreen hospital = new LoginScreen();
		hospital.createView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ConnectSQL fileSQL = new ConnectSQL();
		Connection con = null;
		try {
			con = fileSQL.getConnection();
			String sql = "SELECT * FROM DDH= '" + username.getText() + "' AND PASSWORD = '"
					+ password.getText() + "';";
			PreparedStatement pst = con.prepareCall(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
			} else {
				JOptionPane.showMessageDialog(this, "Sai ten dang nhap hoac mat khau !!!");
			}
		} catch (SQLException e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e2.toString());
		}

	}

}

