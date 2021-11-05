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
import dao.DAO_DichVu;
import entity.DichVu;

public class FormThemDichVu extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTenDV;
	private JTextField txtGiaDV;
	private JTextField txtMaDV;
	private JButton btnTao;
	private JPanel panel_Info;
	private JButton btnDong;


	/**
	 * Create the frame.
	 */
	public FormThemDichVu () {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 100, 750, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_Info = new JPanel();
		panel_Info.setBounds(0, 0, 734, 521);
		panel_Info.setBackground(SystemColor.WHITE);
		contentPane.add(panel_Info);
		panel_Info.setLayout(null);

		JLabel lblMaNV = new JLabel("Mã dịch vụ:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(10, 80, 200, 30);
		panel_Info.add(lblMaNV);

		txtMaDV = new JTextField();
		txtMaDV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtMaDV.setBounds(230, 80, 300, 30);
		panel_Info.add(txtMaDV);
		txtMaDV.setColumns(10);
		
		JLabel lblTenNV = new JLabel("Tên dịch vụ:");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTenNV.setBounds(10, 130, 200, 30);
		panel_Info.add(lblTenNV);

		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTenDV.setBounds(230, 130, 300, 30);
		panel_Info.add(txtTenDV);
		txtTenDV.setColumns(10);

		JLabel lblSDT = new JLabel("Giá dịch vụ:");
		lblSDT.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblSDT.setBounds(10, 180, 250, 30);
		panel_Info.add(lblSDT);

		txtGiaDV = new JTextField();
		txtGiaDV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtGiaDV.setColumns(10);
		txtGiaDV.setBounds(230, 180, 300, 30);
		panel_Info.add(txtGiaDV);
		
		btnTao= new JButton("Tạo ");
		btnTao.setBackground(new Color(255, 204, 102));
		btnTao.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTao.setBounds(230, 240,130, 50);
		panel_Info.add(btnTao);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(400, 240, 130, 50);
		panel_Info.add(btnDong);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(0, 0, 734, 70);
		panel_Info.add(panel_Title);
		panel_Title.setBackground(new Color(255, 204, 102));
		panel_Title.setLayout(null);
		
		JLabel lblTitle = new JLabel("THÊM DỊCH VỤ MỚI");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 50);
		panel_Title.add(lblTitle);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnTao.addActionListener(this);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnTao)) {
			DAO_DichVu dao_dichvu = new DAO_DichVu();
			String ma = txtMaDV.getText();
			String ten = txtTenDV.getText();
			String gia = txtGiaDV.getText();
			DichVu dv =new DichVu(ma,ten,gia, null);
			try {
				if (dao_dichvu.themDichVu(dv)) {
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
		FormThemDichVu  frm = new FormThemDichVu();
		frm.setVisible(true);
	}
	
}


