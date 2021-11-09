package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;

import connect.ConnectDB;
import dao.DAO_NhanVien;
import entity.NhanVien;

public class FormThemNhanVien extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtTenNV;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JComboBox<String> cbChucVu;
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
		setBounds(300, 100, 750,460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_Info = new JPanel();
		panel_Info.setBounds(0, 0, 734, 600);
		panel_Info.setBackground(SystemColor.WHITE);
		contentPane.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(10, 50, 190, 30);
		panel_Info.add(lblMaNV);

		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtID.setBounds(200, 50, 300, 30);
		panel_Info.add(txtID);
		txtID.setColumns(10);
		
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
		
		JLabel lbChucVu = new JLabel("Chức vụ: ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbChucVu.setBounds(10, 321, 190, 30);
		panel_Info.add(lbChucVu);
		
		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbChucVu.setBounds(200, 321, 300, 30);
		cbChucVu.addItem("Nhân viên thu ngân");
		cbChucVu.addItem("Nhân viên phục vụ");
		cbChucVu.addItem("Nhân viên kế toán");
		panel_Info.add(cbChucVu);
		
		btnTaoTaikhoan = new JButton("Tạo");
		btnTaoTaikhoan.setBackground(new Color(255, 204, 102));
		btnTaoTaikhoan.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTaoTaikhoan.setBounds(200, 360,130, 50);
		panel_Info.add(btnTaoTaikhoan);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(370, 360, 130, 50);
		panel_Info.add(btnDong);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(0, 0, 734, 45);
		panel_Info.add(panel_Title);
		panel_Title.setBackground(new Color(255, 204, 102));
		panel_Title.setLayout(null);
		
		JLabel lblTitle = new JLabel("THÊM NHÂN VIÊN MỚI");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTitle.setBounds(0, 9, 704,35);
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
		if(o.equals(btnTaoTaikhoan)) {
			DAO_NhanVien dao_Nhanvien = new DAO_NhanVien();
			String ma = txtID.getText();
			String ten = txtTenNV.getText();
			String gt = (String) cbGioitinh.getSelectedItem();
			Date ns = new Date(ngaysinh.getDate().getTime());
			String sdt = txtSDT.getText();
			String cmnd = txtCMND.getText();
			String chucvu = (String) cbChucVu.getSelectedItem();
			NhanVien nv =new NhanVien(ma,ten,gt, ns,sdt,cmnd,chucvu);
			try {
				if (dao_Nhanvien.themNhanVien(nv)) {
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					this.dispose();
					
				}else {
					JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng thử lại\nThêm không thành công");
					
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(o.equals(btnDong)) {
			this.dispose();
		}
	}
	
}
