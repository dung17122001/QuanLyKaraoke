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

public class FormTimPhong extends JPanel {

	
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JTextField txtTimKiem;

	public FormTimPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBounds(10, 244, 1332, 311);
		panel.add(panelThongTinPhong);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		panelThongTinPhong.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(10, 5, 1312, 296);
		scrollPhong.setBackground(new Color(248,248,248));
		panelThongTinPhong.add(scrollPhong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Nhập thông tin phòng cần tìm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 1332, 224);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Nhập thông tin phòng cần tìm:");
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
		cbTimKiem.addItem("Tìm các phòng còn trống");
		panel_1.add(cbTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTimKiem.setBounds(586, 171, 187, 40);
		panel_1.add(btnTimKiem);
	}

}
