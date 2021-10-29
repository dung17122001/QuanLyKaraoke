package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class FormSuaPhong extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhong;
	private JTextField textField;
	private JTextField txtGiaPhong;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	
	public FormSuaPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBounds(-10, 20, 1352, 555);
		add(panel);
		panel.setLayout(null);
		
		JButton btnSuaPhong = new JButton("Sửa phòng");
		btnSuaPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSuaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaPhong.setBounds(731, 500, 164, 30);
		panel.add(btnSuaPhong);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(570, 500, 122, 30);
		panel.add(btnXoaTrang);
		
		JPanel panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBounds(10, 312, 1332, 178);
		panel.add(panelThongTinPhong);
		panelThongTinPhong.setLayout(null);
		
		JPanel panelThemPhong = new JPanel();
		panelThemPhong.setBounds(0, 10, 1332, 159);
		panelThongTinPhong.add(panelThemPhong);
		panelThemPhong.setBorder(new TitledBorder(null, "Nhập thông tin cần sửa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThemPhong.setLayout(null);
		
		JLabel lbMaPhong = new JLabel("Mã phòng: ");
		lbMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaPhong.setBounds(28, 37, 121, 30);
		panelThemPhong.add(lbMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhong.setBounds(191, 38, 344, 30);
		panelThemPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lbTenPhong = new JLabel("Tên phòng: ");
		lbTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenPhong.setBounds(28, 100, 121, 30);
		panelThemPhong.add(lbTenPhong);
		
		textField = new JTextField();
		textField.setBounds(191, 103, 344, 30);
		panelThemPhong.add(textField);
		textField.setColumns(10);
		
		JLabel lbGiaPhong = new JLabel("Giá phòng: ");
		lbGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiaPhong.setBounds(665, 100, 121, 30);
		panelThemPhong.add(lbGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaPhong.setBounds(843, 101, 379, 30);
		panelThemPhong.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JLabel lbLoaiPhong = new JLabel("Loại phòng: ");
		lbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLoaiPhong.setBounds(665, 37, 121, 30);
		panelThemPhong.add(lbLoaiPhong);
		
		JComboBox cbLoaiPhong = new JComboBox();
		cbLoaiPhong.setBounds(843, 39, 379, 30);
		panelThemPhong.add(cbLoaiPhong);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng"};
		dfPhong=new DefaultTableModel(header,0);
		JScrollPane scrollPhong;
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBounds(10, 10, 1325, 301);
		panel.add(scrollPhong);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBackground(new Color(248,248,248));

	}
}
