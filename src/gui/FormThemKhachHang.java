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
import dao.DaoKhachHang;
import entity.KhachHang;

public class FormThemKhachHang extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTenKH;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private JTextField txtDiaChi;
	private JButton btnTaoTaikhoan;
	private JPanel panel_Info;
	private JButton btnDong;


	/**
	 * Create the frame.
	 */
	public FormThemKhachHang () {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 750, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_Info = new JPanel();
		panel_Info.setBounds(0, 0, 734, 521);
		panel_Info.setBackground(SystemColor.WHITE);
		contentPane.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã khách hàng:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(10, 100, 200, 30);
		panel_Info.add(lblMaNV);

		txtId = new JTextField();
		txtId .setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtId .setBounds(230, 100, 300, 30);
		panel_Info.add(txtId );
		txtId.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên khách hàng:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTenNV.setBounds(10, 150, 200, 30);
		panel_Info.add(lblTenNV);

		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenKH.setBounds(230, 150, 300, 30);
		panel_Info.add(txtTenKH);
		txtTenKH.setColumns(10);

		JLabel lblSDT = new JLabel("SDT:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSDT.setBounds(10, 240, 190, 30);
		panel_Info.add(lblSDT);

		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtSDT.setColumns(10);
		txtSDT.setBounds(230, 240, 300, 30);
		panel_Info.add(txtSDT);
		
		JLabel lblCMND = new JLabel("CMND:");
		lblCMND.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblCMND.setBounds(10, 195, 190, 30);
		panel_Info.add(lblCMND);

		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtCMND.setColumns(10);
		txtCMND.setBounds(230, 195, 300, 30);
		panel_Info.add(txtCMND);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblDiaChi.setBounds(10, 280, 190, 30);
		panel_Info.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(230, 280, 300, 30);
		panel_Info.add(txtDiaChi);
		
		btnTaoTaikhoan = new JButton("Tạo ");
		btnTaoTaikhoan.setBackground(new Color(255, 204, 102));
		btnTaoTaikhoan.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTaoTaikhoan.setBounds(230, 360,130, 50);
		panel_Info.add(btnTaoTaikhoan);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(400, 360, 130, 50);
		panel_Info.add(btnDong);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(0, 0, 734, 70);
		panel_Info.add(panel_Title);
		panel_Title.setBackground(new Color(255, 204, 102));
		panel_Title.setLayout(null);
		
		JLabel lblTitle = new JLabel("THÊM KHÁCH HÀNG MỚI");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 50);
		panel_Title.add(lblTitle);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTaoTaikhoan.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnTaoTaikhoan.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTaoTaikhoan)) {
			DaoKhachHang dao_khachhang = new DaoKhachHang ();
			String ma = txtId.getText();
			String ten = txtTenKH.getText();
			String diachi = txtDiaChi.getText();
			String sdt = txtSDT.getText();
			String cmnd = txtCMND.getText();
			KhachHang kh =new KhachHang(ma,ten,diachi,sdt,cmnd);
			try {
				if (dao_khachhang.themKhachHang(kh)) {
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
	
	public static void main(String[] args) throws SQLException {		
		FormThemKhachHang  frm = new FormThemKhachHang ();
		frm.setVisible(true);
	}
	
}

