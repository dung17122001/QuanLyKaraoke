package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

//import gui.FormQLNhanVien;

public class FormGiaoDien extends JFrame  implements ActionListener, MouseListener {
	private static final long serialVersionUID = -1554680235689968471L;
	private JPanel contentPane;
	private JButton btnQlnv;
	private JButton btnQlkh;
	private JButton btnQldv;
	private JButton btnQlp;
	private JButton btnThongKe;
	private JButton btnQlhd;
	private JButton btnDangXuat;
	private JLabel txtUsername;
	private JPanel panel_Manage;
	FormThongKe formThongKe=new FormThongKe();
	FormQLPhong formQLPhong=new FormQLPhong();
	
	public FormGiaoDien(){
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1366,768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1366, 175);
		panel.setBackground(new Color(204,204,204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		setTitle("Quan ly quan Karaoke Nice");
		setSize(1366,768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel lblTieuDe = new JLabel("Karaoke Nice");
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblTieuDe.setBounds(500,20, 500, 50);
		panel.add(lblTieuDe);
		
		try {
			setIconImage(ImageIO.read(new File("img/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedImage image = ImageIO.read(new File("img/logo.png")); 
			Area clip = new Area( new Rectangle(0, 0,0, 0) ); 
			Area oval = new Area( new Ellipse2D.Double(0,0, 0, 0) ); 
			clip.subtract( oval ); //Khung ảnh
			Graphics g2d = image.createGraphics(); 
			g2d.setClip(clip); //Ảnh đại diện admin
			g2d.setColor(new Color(0, 0, 255));
			g2d.fillRect(0, 0, image.getWidth(), image.getHeight()); 
			JLabel lblImage = new JLabel();
			lblImage.setIcon(new ImageIcon(image));
			lblImage.setBackground(SystemColor.control);
			lblImage.setBounds(0,-22, 250, 165);
			panel.add(lblImage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel lblUser = new JLabel("Người dùng:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		lblUser.setBounds(1150, 60, 120, 31);
		panel.add(lblUser);
		
		txtUsername = new JLabel("NV001");
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		txtUsername.setBounds(1270, 60, 170, 31);
		panel.add(txtUsername);
		panel.revalidate();
		panel.repaint();
		
		btnQlnv = new JButton("Quản lý nhân viên");
		btnQlnv.setIcon(new ImageIcon("img/house.png"));
		btnQlnv.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnQlnv.setBorderPainted(false);
		btnQlnv.setBorder(null);
		btnQlnv.setBackground(new Color(255, 204, 102));
		btnQlnv.setForeground(Color.BLACK);
		btnQlnv.setFocusable(false);
		btnQlnv.setBounds(0, 125, 180, 50);
		panel.add(btnQlnv);
		
		btnQlkh = new JButton("Quản lý khách hàng");
		btnQlkh.setIcon(new ImageIcon("img/icon1.png"));
		btnQlkh.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnQlkh.setBorderPainted(false);
		btnQlkh.setBorder(null);
		btnQlkh.setBackground(new Color(255, 204, 102));
		btnQlkh.setForeground(Color.BLACK);
		btnQlkh.setFocusable(false);
		btnQlkh.setBounds(190,125, 190, 50);
		panel.add(btnQlkh);
		
		btnQldv = new JButton("Quản lý dịch vụ");
		btnQldv.setIcon(new ImageIcon("img/icon2.png"));
		btnQldv.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnQldv.setBorderPainted(false);
		btnQldv.setBorder(null);
		btnQldv.setBackground(new Color(255, 204, 102));
		btnQldv.setForeground(Color.BLACK);
		btnQldv.setFocusable(false);
		btnQldv.setBounds(390, 125, 190, 50);
		panel.add(btnQldv);
		
		btnQlp = new JButton("Quản lý phòng");
		btnQlp.setIcon(new ImageIcon("img/icon3.png"));
		btnQlp.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnQlp.setBorderPainted(false);
		btnQlp.setBorder(null);
		btnQlp.setBackground(new Color(255, 204, 102));
		btnQlp.setForeground(Color.BLACK);
		btnQlp.setFocusable(false);
		btnQlp.setBounds(590, 125, 190, 50);
		panel.add(btnQlp);
		
		btnThongKe = new JButton("Thống kê");
		btnThongKe.setIcon(new ImageIcon("img/icon4.png"));
		btnThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnThongKe.setBorderPainted(false);
		btnThongKe.setBorder(null);
		btnThongKe.setBackground(new Color(255, 204, 102));
		btnThongKe.setForeground(Color.BLACK);
		btnThongKe.setFocusable(false);
		btnThongKe.setBounds(790, 125, 190, 50);
		panel.add(btnThongKe);
		
		btnQlhd = new JButton("Quản lý hóa đơn");
		btnQlhd.setIcon(new ImageIcon("img/icon5.png"));
		btnQlhd.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnQlhd.setBorderPainted(false);
		btnQlhd.setBorder(null);
		btnQlhd.setBackground(new Color(255, 204, 102));
		btnQlhd.setForeground(Color.BLACK);
		btnQlhd.setFocusable(false);
		btnQlhd.setBounds(990, 125, 190, 50);
		panel.add(btnQlhd);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon("img/icon6.png"));
		btnDangXuat.setFont(new Font("Times New Roman", Font.PLAIN, 19));
		btnDangXuat.setBorderPainted(false);
		btnDangXuat.setBorder(null);
		btnDangXuat.setBackground(new Color(255, 204, 102));
		btnDangXuat.setForeground(Color.BLACK);
		btnDangXuat.setFocusable(false);
		btnDangXuat.setBounds(1190, 125, 190, 50);
		panel.add(btnDangXuat);
			
		btnQlnv.addActionListener(this);
		btnQlkh.addActionListener(this);
		btnQldv.addActionListener(this);
		btnQlp.addActionListener(this);
		btnThongKe.addActionListener(this);
		btnQlhd.addActionListener(this);
		btnDangXuat.addActionListener(this);
		
		panel_Manage = new JPanel();
		panel_Manage.setBounds(0, 175, 1366, 593);
//		panel_Manage.add(new FormQLNhanVien());
		contentPane.add(panel_Manage);
		panel_Manage.setLayout(null);
		
		btnQlnv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQlkh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQldv.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQlp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnQlhd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
	}
	public void changeScreen(JPanel newScreen) {

		panel_Manage.removeAll();
		panel_Manage.add(newScreen);
		panel_Manage.repaint();
		panel_Manage.revalidate();

	}
	public void buttonPressed(JButton button) {
		//panel_center.removeAll();
		panel_Manage.repaint();
		panel_Manage.revalidate();
		if(button.equals(btnQlnv)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
		else if(button.equals(btnQlkh)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
		else if(button.equals(btnQldv)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
		else if(button.equals(btnQlp)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
		else if(button.equals(btnThongKe)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
		else if(button.equals(btnQlhd)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
		else if(button.equals(btnDangXuat)) {
			button.setBackground(new Color(255, 238, 204));
			btnQlnv.setBackground(new Color(255, 204, 102));
			btnQlkh.setBackground(new Color(255, 204, 102));
			btnQldv.setBackground(new Color(255, 204, 102));
			btnQlp.setBackground(new Color(255, 204, 102));
			btnThongKe.setBackground(new Color(255, 204, 102));
			btnQlhd.setBackground(new Color(255, 204, 102));
			btnDangXuat.setBackground(new Color(255, 204, 102));
		}
	}
	public static void main(String[] args) throws SQLException {		
		FormGiaoDien frm = new FormGiaoDien();
		frm.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnQlnv)) {
			buttonPressed(btnQlnv);
			changeScreen(new FormQLNhanVien());
		}
		
		if(o.equals(btnQlkh)) {
			buttonPressed(btnQlkh);
			changeScreen(new FormQLKhachHang());
		}
		
		if(o.equals(btnQldv)) {
			buttonPressed(btnQldv);
			changeScreen(new FormQLDichVu());
		}
		if(o.equals(btnQlp)) {
			changeScreen(formQLPhong);
			panel_Manage.add(formQLPhong.getFormQLPhong());
		}
		if(o.equals(btnThongKe)) {
			changeScreen(formThongKe);
			panel_Manage.add(formThongKe.getFormThongKe());
		}
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
	
}
