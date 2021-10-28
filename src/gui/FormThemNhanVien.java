package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;

public class FormThemNhanVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenNV;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtChucVu;
	private JDateChooser ngaysinh;
	private JButton btnTaoTaikhoan;
	private JPanel panel_Info;
	private JComboBox<String> cbGioitinh;
	private JButton btnDong;


	/**
	 * Create the frame.
	 */
	public FormThemNhanVien() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_Info = new JPanel();
		panel_Info.setBounds(0, 0, 734, 521);
		panel_Info.setBackground(SystemColor.WHITE);
		contentPane.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTenNV.setBounds(10, 100, 190, 30);
		panel_Info.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenNV.setBounds(200, 100, 300, 30);
		panel_Info.add(txtTenNV);
		txtTenNV.setColumns(10);

		JLabel lblGioitinh = new JLabel("Giới tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGioitinh.setBounds(10, 145, 190, 30);
		panel_Info.add(lblGioitinh);

		cbGioitinh = new JComboBox<String>();
		cbGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cbGioitinh.addItem("Nam");
		cbGioitinh.addItem("Nữ");
		cbGioitinh.setBounds(200, 145, 200, 30);
		panel_Info.add(cbGioitinh);

		JLabel lblNgaysinh = new JLabel("Ngày sinh:");
		lblNgaysinh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNgaysinh.setBounds(10, 190, 190, 30);
		panel_Info.add(lblNgaysinh);

		ngaysinh = new JDateChooser();
		ngaysinh.setDateFormatString("dd/MM/yyyy");
		ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ngaysinh.setPreferredSize(new Dimension(400, 400));
		ngaysinh.getJCalendar().getMonthChooser().setPreferredSize(new Dimension(150, 30));
		ngaysinh.setBounds(200, 190, 200, 30);
		panel_Info.add(ngaysinh);

		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSDT.setBounds(10, 231, 190, 30);
		panel_Info.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(200, 231, 300, 30);
		panel_Info.add(txtSDT);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCMND.setBounds(10, 276, 190, 30);
		panel_Info.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(200, 276, 300, 30);
		panel_Info.add(txtCMND);
		
		JLabel lblChucVu = new JLabel("Chức Vụ:");
		lblChucVu.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblChucVu.setBounds(10, 321, 190, 30);
		panel_Info.add(lblChucVu);

		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtChucVu.setColumns(10);
		txtChucVu.setBounds(200, 321, 300, 30);
		panel_Info.add(txtChucVu);
		
		btnTaoTaikhoan = new JButton("Tạo tài khoản");
		btnTaoTaikhoan.setBackground(new Color(255, 204, 102));
		btnTaoTaikhoan.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTaoTaikhoan.setBounds(350, 460, 230, 50);
		panel_Info.add(btnTaoTaikhoan);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(594, 460, 130, 50);
		panel_Info.add(btnDong);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(0, 0, 734, 70);
		panel_Info.add(panel_Title);
		panel_Title.setBackground(new Color(255, 204, 102));
		panel_Title.setLayout(null);
		
		JLabel lblTitle = new JLabel("THÊM NHÂN VIÊN MỚI");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 50);
		panel_Title.add(lblTitle);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTaoTaikhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbGioitinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnTaoTaikhoan.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDong)) {
			this.dispose();
		}
	}
	
	public static void main(String[] args) throws SQLException {		
		FormThemNhanVien frm = new FormThemNhanVien();
		frm.setVisible(true);
	}
	
}
