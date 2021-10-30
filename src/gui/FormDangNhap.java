package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import gui.FormDangNhap;


public class FormDangNhap extends JFrame implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JPanel pnMain;
	private JPasswordField txtPassword;
	int xx, xy;
	private JTextField txtUserName;
	private JButton btnLogin;

	public FormDangNhap() {

	setTitle("KARAOKE NICE");
	setBackground(Color.WHITE);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	setResizable(true);
	setBounds(0,0, 1366,768);

	pnMain = new JPanel();
	pnMain.setBorder(new LineBorder(new Color(0, 0, 0), 0));
	pnMain.setBackground(new Color(255,179,179));
	pnMain.setBounds(0, 0, 500,500);
	getContentPane().add(pnMain);
	pnMain.setLayout(null);

	JPanel panel = new JPanel();
	panel.setBounds(0, 0, 890,1000);
	panel.setBackground(Color.BLACK);
	pnMain.add(panel);
	panel.setLayout(null);

	JLabel bgImage = new JLabel("");
	bgImage.setBackground(new Color(255, 255, 255));

	bgImage.addMouseListener(new MouseAdapter() {
		@Override
		public void mousePressed(MouseEvent e) {

			xx = e.getX();
			xy = e.getY();
		}
	});
	bgImage.addMouseMotionListener(new MouseMotionAdapter() {
		@Override
		public void mouseDragged(MouseEvent arg0) {

			int x = arg0.getXOnScreen();
			int y = arg0.getYOnScreen();
			FormDangNhap.this.setLocation(x - xx, y - xy);
		}
	});
	bgImage.setBounds(50, 0, 1100, 1100);
	bgImage.setVerticalAlignment(SwingConstants.TOP);
	bgImage.setIcon(new ImageIcon("img/karaokenice.jpg"));
	panel.add(bgImage);

	JLabel lblTitle = new JLabel("KARAOKE NICE");
	lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
	lblTitle.setFont(new Font("Serif", Font.BOLD, 55));
	lblTitle.setBounds(890, 50, 477, 158);
	pnMain.add(lblTitle);

	Panel pnLogin = new Panel();
	pnLogin.setBounds(890, 300, 477, 470);
	pnLogin.setForeground(Color.BLACK);
	pnLogin.setBackground(new Color(255,77,77));
	pnMain.add(pnLogin);
	pnLogin.setLayout(null);

	JLabel lblLogin = new JLabel("Đăng nhập");
	lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
	lblLogin.setBounds(0, 67, 477, 65);
	pnLogin.add(lblLogin);
	lblLogin.setFont(new Font("Times New Roman", Font.BOLD, 48));

	txtUserName = new JTextField(10);
	txtUserName.setBounds(55, 171, 412, 60);
	pnLogin.add(txtUserName);
	txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 28));
	txtUserName.setText("admin");
	txtUserName.setColumns(10);

	txtPassword = new JPasswordField(10);
	txtPassword.setBounds(55, 236, 412, 60);
	pnLogin.add(txtPassword);
	txtPassword.setText("admin");
	txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 28));

	btnLogin = new JButton("Đăng nhập");
	btnLogin.setBounds(10, 354, 457, 70);
	pnLogin.add(btnLogin);
	btnLogin.setFont(new Font("Times New Roman", Font.BOLD, 32));
	btnLogin.setForeground(Color.WHITE);
	btnLogin.setOpaque(true);
	btnLogin.setBackground(new Color(255, 204, 102));
	btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	JLabel lblIconUser = new JLabel("");
	lblIconUser.setIcon(new ImageIcon("img/user.png"));
	lblIconUser.setBounds(10, 180, 40, 40);
	pnLogin.add(lblIconUser);
	
	JLabel lblIconPW = new JLabel("");
	lblIconPW.setIcon(new ImageIcon("img/unlock.png"));
	lblIconPW.setBounds(10, 243, 40, 40);
	pnLogin.add(lblIconPW);
	
	btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
	btnLogin.addActionListener(this);
	txtPassword.addActionListener(this);
	txtUserName.addActionListener(this);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}



}

