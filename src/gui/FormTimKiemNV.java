package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
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
	private JTextField txtTimNV;
	private JButton btnTimKiem;
	private JPanel panel_Info;
	private JButton btnDong;
	
	
	public FormTimKiemNV() {
		
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
		
		JLabel lblNtttk = new JLabel("Nhập thông tin cần tìm:");
		lblNtttk.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNtttk.setBounds(10, 100, 300, 30);
		panel_Info.add(lblNtttk);

		txtTimNV = new JTextField();
		txtTimNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimNV.setBounds(350, 100, 300, 30);
		panel_Info.add(txtTimNV);
		txtTimNV.setColumns(10);
		
		JLabel lbLoaiTimKiem = new JLabel("Chọn loại tìm kiếm:");
		lbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbLoaiTimKiem.setBounds(10, 145, 300, 30);
		panel_Info.add(lbLoaiTimKiem);
		
		JComboBox<String> cbTimKiem = new JComboBox<String>();
		cbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cbTimKiem.setBounds(350, 145, 300, 30);
		cbTimKiem.addItem("Tìm theo mã nhân viên");
		cbTimKiem.addItem("Tìm theo tên nhân viên");
		panel_Info.add(cbTimKiem);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(255, 204, 102));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTimKiem.setBounds(350, 460, 230, 50);
		panel_Info.add(btnTimKiem);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setBounds(594, 460, 130, 50);
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
