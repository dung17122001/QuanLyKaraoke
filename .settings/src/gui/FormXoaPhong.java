package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class FormXoaPhong extends JPanel {

	
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JTextField txtTimKiem;

	public FormXoaPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBounds(10, 203, 1332, 265);
		panel.add(panelThongTinPhong);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		panelThongTinPhong.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(10, 10, 1312, 245);
		scrollPhong.setBackground(new Color(248,248,248));
		panelThongTinPhong.add(scrollPhong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tìm phòng cần xóa", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 1332, 194);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Tìm nhanh phòng cần xóa: ");
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTimKiem.setBounds(435, 31, 224, 30);
		panel_1.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(696, 34, 284, 30);
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lbHinhThuc = new JLabel("Loại tìm kiếm: ");
		lbHinhThuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbHinhThuc.setBounds(435, 92, 224, 30);
		panel_1.add(lbHinhThuc);
		
		JComboBox<String> cbTimKiem = new JComboBox<String>();
		cbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTimKiem.setBounds(696, 92, 284, 30);
		cbTimKiem.addItem("Tìm theo mã phòng");
		cbTimKiem.addItem("Tìm theo tên phòng");
		panel_1.add(cbTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimKiem.setBounds(575, 147, 181, 40);
		panel_1.add(btnTimKiem);
		
		JButton btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setBackground(Color.ORANGE);
		btnXoaPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnXoaPhong.setBounds(439, 497, 174, 40);
		panel.add(btnXoaPhong);
		
		JButton btnHuy = new JButton("Hủy");
		btnHuy.setBackground(Color.ORANGE);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnHuy.setBounds(730, 497, 150, 40);
		panel.add(btnHuy);
	}

}
