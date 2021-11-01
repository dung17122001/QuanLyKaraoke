package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
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

public class FormTimKiemNV extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimMaNV;
	private JTextField txtTimTenNV;
	private JTextField txtTimNsNV;
	private JTextField txtTimSdtNV;
	private JTextField txtTimSocmNV;
	private JButton btnTimKiem;
	private JPanel panel_Info;
	private JButton btnDong;
	private JRadioButton rb1;
	
	public FormTimKiemNV() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(300, 40, 750, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panel_Info = new JPanel();
		panel_Info.setBounds(0, 0, 734, 521);
		panel_Info.setBackground(SystemColor.WHITE);
		contentPane.add(panel_Info);
		panel_Info.setLayout(null);
		
		JPanel panel_Title = new JPanel();
		panel_Title.setBounds(0, 0, 734, 70);
		panel_Info.add(panel_Title);
		panel_Title.setBackground(new Color(255, 204, 102));
		panel_Title.setLayout(null);
		
		JLabel lblTitle = new JLabel("TÌM KIẾM NHÂN VIÊN");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 50);
		panel_Title.add(lblTitle);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(10, 100, 300, 30);
		panel_Info.add(lblMaNV);

		txtTimMaNV = new JTextField();
		txtTimMaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimMaNV.setBounds(350, 100, 300, 30);
		panel_Info.add(txtTimMaNV);
		txtTimMaNV.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 100, 20, 30);
        panel_Info.add(rb1);
        
        JLabel lblTenNV = new JLabel("Tên nhân viên:");
        lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTenNV.setBounds(10, 150, 300, 30);
		panel_Info.add(lblTenNV);

		txtTimTenNV = new JTextField();
		txtTimTenNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimTenNV.setBounds(350, 150, 300, 30);
		panel_Info.add(txtTimTenNV);
		txtTimTenNV.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 150, 20, 30);
        panel_Info.add(rb1);
        
        JLabel lblNsNV = new JLabel("Ngày sinh:");
        lblNsNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNsNV.setBounds(10, 200, 300, 30);
		panel_Info.add(lblNsNV);

		txtTimNsNV = new JTextField();
		txtTimNsNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimNsNV.setBounds(350, 250, 300, 30);
		panel_Info.add(txtTimNsNV);
		txtTimNsNV.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 250, 20, 30);
        panel_Info.add(rb1);
		
        JLabel lblSdt = new JLabel("Số điện thoại:");
        lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblSdt.setBounds(10, 250, 300, 30);
		panel_Info.add(lblSdt);

		txtTimSdtNV = new JTextField();
		txtTimSdtNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSdtNV.setBounds(350, 200, 300, 30);
		panel_Info.add(txtTimSdtNV);
		txtTimSdtNV.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 200, 20, 30);
        panel_Info.add(rb1);
        
        JLabel lblCmnd = new JLabel("CMND:");
        lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblCmnd.setBounds(10, 300, 300, 30);
		panel_Info.add(lblCmnd);

		txtTimSocmNV = new JTextField();
		txtTimSocmNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSocmNV.setBounds(350, 300, 300, 30);
		panel_Info.add(txtTimSocmNV);
		txtTimSocmNV.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 300, 20, 30);
        panel_Info.add(rb1);
        
		JLabel lbChucVu= new JLabel("Chức vụ:");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbChucVu.setBounds(10, 350, 300, 30);
		panel_Info.add(lbChucVu);
		
		JComboBox<String> cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cbChucVu.setBounds(350, 350, 300, 30);
		cbChucVu.addItem("Nhân viên thu ngân");
		cbChucVu.addItem("Nhân viên phục vụ");
		cbChucVu.addItem("Nhân viên kế toán");
		panel_Info.add(cbChucVu);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 350, 20, 30);
        panel_Info.add(rb1);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(255, 204, 102));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTimKiem.setBounds(180, 390, 180, 50);
		panel_Info.add(btnTimKiem);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(450, 390, 180, 50);
		panel_Info.add(btnDong);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnTimKiem.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if(o.equals(btnDong)) {
			this.dispose();
		}
		
	}

	public static void main(String[] args) throws SQLException {		
		FormTimKiemNV frm = new FormTimKiemNV();
		frm.setVisible(true);
	}
	
}
