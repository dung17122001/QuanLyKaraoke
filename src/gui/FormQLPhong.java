package gui;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class FormQLPhong extends JPanel {
	
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JTextField txtTenPhong;

	
	public FormQLPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThongTinPhong =  new JPanel();
		panelThongTinPhong.setBorder(new TitledBorder(null, "Thông tin phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinPhong.setBounds(10, 10, 809, 183);
		panel.add(panelThongTinPhong);
		panelThongTinPhong.setLayout(null);
		
		JLabel lbMaPhong = new JLabel("Mã phòng: ");
		lbMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaPhong.setBounds(34, 22, 96, 38);
		panelThongTinPhong.add(lbMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhong.setBounds(130, 27, 244, 30);
		panelThongTinPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lbGiaPhong = new JLabel("Giá phòng: ");
		lbGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiaPhong.setBounds(34, 84, 96, 38);
		panelThongTinPhong.add(lbGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaPhong.setBounds(130, 89, 244, 30);
		panelThongTinPhong.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JLabel lbTrinhTrang = new JLabel("Trình trạng: ");
		lbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTrinhTrang.setBounds(423, 84, 96, 38);
		panelThongTinPhong.add(lbTrinhTrang);
		
		JComboBox cbTrinhTrang = new JComboBox();
		cbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTrinhTrang.setBounds(529, 88, 245, 30);
		panelThongTinPhong.add(cbTrinhTrang);
		
		JLabel lbTenPhong = new JLabel("Tên phòng: ");
		lbTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenPhong.setBounds(34, 132, 96, 38);
		panelThongTinPhong.add(lbTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenPhong.setBounds(130, 137, 244, 30);
		panelThongTinPhong.add(txtTenPhong);
		txtTenPhong.setColumns(10);
		
		JLabel lbLoaiPhong = new JLabel("Loại Phòng:");
		lbLoaiPhong.setBounds(423, 22, 96, 38);
		panelThongTinPhong.add(lbLoaiPhong);
		lbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JComboBox cbLoaiPhong = new JComboBox();
		cbLoaiPhong.setBounds(529, 26, 245, 30);
		panelThongTinPhong.add(cbLoaiPhong);
		cbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelBangThuoc = new JPanel();
		panelBangThuoc.setBounds(10, 199, 1332, 351);
		panel.add(panelBangThuoc);
		panelBangThuoc.setLayout(null);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(0, 10, 1325, 331);
		scrollPhong.setBackground(new Color(248,248,248));
		panelBangThuoc.add(scrollPhong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "chọn tác vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(821, 10, 510, 183);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThemPhong = new JButton("Thêm phòng");
		btnThemPhong.setBackground(Color.ORANGE);
		btnThemPhong.setBounds(84, 36, 120, 30);
		panel_1.add(btnThemPhong);
		btnThemPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setBackground(Color.ORANGE);
		btnXoaPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXoaPhong.setBounds(304, 36, 120, 30);
		panel_1.add(btnXoaPhong);
		btnXoaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSuaPhong = new JButton("Sửa phòng");
		btnSuaPhong.setBackground(Color.ORANGE);
		btnSuaPhong.setBounds(84, 113, 120, 30);
		panel_1.add(btnSuaPhong);
		btnSuaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnReset = new JButton("Xóa rỗng");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setBounds(304, 113, 120, 30);
		panel_1.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
	}
}
