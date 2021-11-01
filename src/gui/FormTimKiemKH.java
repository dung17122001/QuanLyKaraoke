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

public class FormTimKiemKH extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtTimMaKH;
	private JTextField txtTimTenKH;
	private JTextField txtTimSdtKH;
	private JTextField txtTimSocmKH;
	private JButton btnTimKiem;
	private JPanel panel_Info;
	private JButton btnDong;
	private JRadioButton rb1;
	
	public FormTimKiemKH() {
		
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
		
		JLabel lblTitle = new JLabel("TÌM KIẾM KHÁCH HÀNG");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setForeground(new Color(21, 25, 28));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblTitle.setBounds(0, 9, 704, 50);
		panel_Title.add(lblTitle);
		
		JLabel lblMaNV = new JLabel("Mã khách hàng:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(10, 100, 300, 30);
		panel_Info.add(lblMaNV);

		txtTimMaKH= new JTextField();
		txtTimMaKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimMaKH.setBounds(350, 100, 300, 30);
		panel_Info.add(txtTimMaKH);
		txtTimMaKH.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 100, 20, 30);
        panel_Info.add(rb1);
        
        JLabel lblTenNV = new JLabel("Tên khách hàng:");
        lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTenNV.setBounds(10, 150, 300, 30);
		panel_Info.add(lblTenNV);

		txtTimTenKH = new JTextField();
		txtTimTenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimTenKH.setBounds(350, 150, 300, 30);
		panel_Info.add(txtTimTenKH);
		txtTimTenKH.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 150, 20, 30);
        panel_Info.add(rb1);
        
        JLabel lblNsNV = new JLabel("Số điện thoại:");
        lblNsNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNsNV.setBounds(10, 200, 300, 30);
		panel_Info.add(lblNsNV);

		txtTimSdtKH = new JTextField();
		txtTimSdtKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSdtKH.setBounds(350, 200, 300, 30);
		panel_Info.add(txtTimSdtKH);
		txtTimSdtKH.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 200, 20, 30);
        panel_Info.add(rb1);
        
        JLabel lblCmnd = new JLabel("CMND:");
        lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblCmnd.setBounds(10, 250, 300, 30);
		panel_Info.add(lblCmnd);
		
		txtTimSocmKH = new JTextField();
		txtTimSocmKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSocmKH.setBounds(350, 250, 300, 30);
		panel_Info.add(txtTimSocmKH);
		txtTimSocmKH.setColumns(10);
		
		rb1 = new JRadioButton("");
        rb1.setBounds(660, 250, 20, 30);
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

}
