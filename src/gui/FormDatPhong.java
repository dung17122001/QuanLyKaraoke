package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;

public class FormDatPhong extends JPanel {
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private DefaultTableModel dfDichVu;
	private JTextField txtNgay;
	private JTextField txtGio;

	public FormDatPhong() {
		
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelPhong = new JPanel();
		panelPhong.setBorder(new TitledBorder(null, "Lựa chọn phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPhong.setBounds(10, 10, 1332, 430);
		panel.add(panelPhong);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		panelPhong.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(10, 20, 1312, 400);
		scrollPhong.setBackground(new Color(248,248,248));
		panelPhong.add(scrollPhong);
		
		JButton btnDatPhong = new JButton("Thêm đơn đặt phòng");
		btnDatPhong.setBackground(Color.ORANGE);
		btnDatPhong.setBounds(863, 482, 243, 40);
		panel.add(btnDatPhong);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel lbNgay = new JLabel("Ngày muốn đặt phòng:");
		lbNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNgay.setBounds(42, 450, 198, 30);
		panel.add(lbNgay);
		
		txtNgay = new JTextField();
		txtNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgay.setBounds(250, 451, 253, 30);
		panel.add(txtNgay);
		txtNgay.setColumns(10);
		
		JLabel lbGioDat = new JLabel("Giờ muốn đặt: ");
		lbGioDat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioDat.setBounds(42, 511, 198, 30);
		panel.add(lbGioDat);
		
		txtGio = new JTextField();
		txtGio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGio.setBounds(250, 512, 251, 30);
		panel.add(txtGio);
		txtGio.setColumns(10);
		
	}
}
