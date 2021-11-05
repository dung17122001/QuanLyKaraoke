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
import dao.DAO_KhachHang;
import entity.KhachHang;

public class FormSuaKH extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtMaKH;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JButton btnSua;
	private JPanel panel_Info;
	private JButton btnDong;
	private KhachHang kh;

	/**
	 * Create the frame.
	 */
	public FormSuaKH (String maKhachHang) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 750, 460);
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

		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaKH.setBounds(10, 70, 200, 30);
		panel_Info.add(lblMaKH);

		txtMaKH = new JTextField();
		txtMaKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtMaKH.setBounds(230, 70, 300, 30);
		panel_Info.add(txtMaKH);
		txtMaKH.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên khách hàng:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTenNV.setBounds(10, 120, 200, 30);
		panel_Info.add(lblTenNV);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenKH.setBounds(230, 120, 300, 30);
		panel_Info.add(txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSDT.setBounds(10, 220, 190, 30);
		panel_Info.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(230, 220, 300, 30);
		panel_Info.add(txtSDT);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCMND.setBounds(10, 270, 190, 30);
		panel_Info.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(230, 270, 300, 30);
		panel_Info.add(txtCMND);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDiaChi.setBounds(10, 170, 190, 30);
		panel_Info.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(230, 170, 300, 30);
		panel_Info.add(txtDiaChi);
		
		btnSua = new JButton("Cập nhật ");
		btnSua.setBackground(new Color(255, 204, 102));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnSua.setBounds(150, 360, 170, 50);
		panel_Info.add(btnSua);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(394, 360, 130, 50);
		panel_Info.add(btnDong);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(0, 0, 734, 70);
		panel_Info.add(panel_Title);
		panel_Title.setBackground(new Color(255, 204, 102));
		panel_Title.setLayout(null);
		
		JLabel lblTitle = new JLabel("SỬA KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 40);
		panel_Title.add(lblTitle);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnSua.addActionListener(this);

		// Load thông tin khach hang
				DAO_KhachHang dao_khachhang = new DAO_KhachHang();
				try {
						KhachHang kh = dao_khachhang.getKhachHangByMaKhachHang(maKhachHang);
						txtMaKH.setText(kh.getMaKhachHang());
						txtTenKH.setText(kh.getTenKhachHang());
						txtDiaChi.setText(kh.getDiaChi());
						txtSDT.setText(kh.getSoDienThoai());
						txtCMND.setText(kh.getSoCMND());	
				} catch (SQLException e) {
					e.printStackTrace();
				}
						// Nhân viên với thông tin mới
					 kh = new KhachHang(maKhachHang, null, null, null, null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnDong)) {
			this.dispose();
		}
		
		if (o.equals(btnSua)) {
			
			int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn xác nhận muốn thay đổi thông tin khách hàng này?",
					"Chú ý", JOptionPane.YES_NO_OPTION);
			if (xacnhan == JOptionPane.YES_OPTION) {
				DAO_KhachHang dao_khachhang = new DAO_KhachHang();
				String tenkh = txtTenKH.getText();
				String diachi = txtDiaChi.getText();
				String sdt = txtSDT.getText();
				String cmnd = txtCMND.getText();
				
				kh.setTenKhachHang(tenkh);
				kh.setDiaChi(diachi);
				kh.setSoDienThoai(sdt);
				kh.setSoCMND(cmnd);
				
				this.dispose();
				try {
					if (dao_khachhang.suaThongtinKhachHang(kh)) {
						JOptionPane.showMessageDialog(this, "Sửa thông tin khách hàng thành công");
					} else {
						JOptionPane.showMessageDialog(this,
								"Đã có lỗi phát sinh. Sửa thông tin khách hàng thất bại.");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		
	}
	}
	
}


