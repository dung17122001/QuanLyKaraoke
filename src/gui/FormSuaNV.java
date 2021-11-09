package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JComboBox;

import connect.ConnectDB;
import dao.DAO_NhanVien;
import entity.NhanVien;

public class FormSuaNV extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtmaNV;
	private JTextField txtTenNV;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JDateChooser ngaysinh;
	private JButton btnCapNhat;
	private JPanel panel_Info;
	private JComboBox<String> cbGioitinh;
	private JComboBox<String> cbChucVu;
	private JButton btnDong;
	private NhanVien nv;


	/**
	 * Create the frame.
	 */
	public FormSuaNV (String maNhanVien) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 750, 560);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		panel_Info = new JPanel();
		panel_Info.setBounds(0, 0, 734, 521);
		panel_Info.setBackground(SystemColor.WHITE);
		contentPane.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(10, 100, 190, 30);
		panel_Info.add(lblMaNV);

		txtmaNV = new JTextField();
		txtmaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtmaNV.setBounds(200, 100, 300, 30);
		panel_Info.add(txtmaNV);
		txtmaNV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên nhân viên:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTenNV.setBounds(10, 145, 190, 30);
		panel_Info.add(lblTenNV);

		txtTenNV = new JTextField();
		txtTenNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenNV.setBounds(200, 145, 300, 30);
		panel_Info.add(txtTenNV);
		txtTenNV.setColumns(10);

		JLabel lblGioitinh = new JLabel("Giới tính:");
		lblGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGioitinh.setBounds(10, 190, 190, 30);
		panel_Info.add(lblGioitinh);

		cbGioitinh = new JComboBox<String>();
		cbGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 24));
		cbGioitinh.addItem("Nam");
		cbGioitinh.addItem("Nữ");
		cbGioitinh.setBounds(200, 190, 200, 30);
		panel_Info.add(cbGioitinh);

		JLabel lblNgaysinh = new JLabel("Ngày sinh:");
		lblNgaysinh.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNgaysinh.setBounds(10, 231, 190, 30);
		panel_Info.add(lblNgaysinh);

		ngaysinh = new JDateChooser();
		ngaysinh.setDateFormatString("dd/MM/yyyy");
		ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ngaysinh.setPreferredSize(new Dimension(400, 400));
		ngaysinh.getJCalendar().getMonthChooser().setPreferredSize(new Dimension(150, 30));
		ngaysinh.setBounds(200, 231, 200, 30);
		panel_Info.add(ngaysinh);

		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSDT.setBounds(10, 276, 190, 30);
		panel_Info.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(200, 276, 300, 30);
		panel_Info.add(txtSDT);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCMND.setBounds(10, 321, 190, 30);
		panel_Info.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(200, 321, 300, 30);
		panel_Info.add(txtCMND);
		

		JLabel lbChucVu = new JLabel("Chức vụ: ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lbChucVu.setBounds(10, 371, 190, 30);
		panel_Info.add(lbChucVu);
		
		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		cbChucVu.setBounds(200, 371, 300, 30);
		cbChucVu.addItem("Nhân viên thu ngân");
		cbChucVu.addItem("Nhân viên phục vụ");
		cbChucVu.addItem("Nhân viên kế toán");
		panel_Info.add(cbChucVu);
		
		btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(new Color(255, 204, 102));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCapNhat.setBounds(350, 460, 230, 50);
		panel_Info.add(btnCapNhat);
		
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
		
		JLabel lblTitle = new JLabel("SỬA THÔNG TIN NHÂN VIÊN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 50);
		panel_Title.add(lblTitle);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbGioitinh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		cbChucVu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnCapNhat.addActionListener(this);
				
		// Load thông tin nhân viên
		DAO_NhanVien dao_Nhanvien = new DAO_NhanVien();
		try {
				NhanVien nv = dao_Nhanvien.getNhanvienByMaNhanVien(maNhanVien);
				txtmaNV.setText(nv.getMaNhanVien());
				txtTenNV.setText(nv.getTenNhanVien());
				cbGioitinh.setSelectedItem(nv.getGioiTinh());
				ngaysinh.setDate(nv.getNgaySinh());
				txtSDT.setText(nv.getDienThoai());
				txtCMND.setText(nv.getSoCMND());
				cbChucVu.setSelectedItem(nv.getChucVu());
		} catch (SQLException e) {
			e.printStackTrace();
		}
				// Nhân viên với thông tin mới
			 nv = new NhanVien(maNhanVien, null, null, null, null, null, null);
	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDong)) {
			this.dispose();
		}
		if (o.equals(btnCapNhat)) {
			
				int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn xác nhận muốn thay đổi thông tin nhân viên này?",
						"Chú ý", JOptionPane.YES_NO_OPTION);
				if (xacnhan == JOptionPane.YES_OPTION) {
					DAO_NhanVien dao_Nhanvien = new DAO_NhanVien();
					String tennv = txtTenNV.getText();
					String gt = (String) cbGioitinh.getSelectedItem();
					Date ns = new Date(ngaysinh.getDate().getTime());
					String sdt = txtSDT.getText();
					String cmnd = txtCMND.getText();
					String chucvu = (String) cbChucVu.getSelectedItem();
					
					nv.setTenNhanVien(tennv);
					nv.setGioiTinh(gt);
					nv.setNgaySinh(ns);
					nv.setDienThoai(sdt);
					nv.setSoCMND(cmnd);
					nv.setChucVu(chucvu);
					this.dispose();
					try {
						if (dao_Nhanvien.suaThongtinNhanvien(nv)) {
							JOptionPane.showMessageDialog(this, "Sửa thông tin nhân viên thành công");
						} else {
							JOptionPane.showMessageDialog(this,
									"Đã có lỗi phát sinh. Sửa thông tin nhân viên thất bại.");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			
		}
	}

}
