package gui;

import javax.swing.JPanel;
import java.awt.Panel;
import java.sql.SQLException;

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

public class FormQLPhong extends JPanel {
	private Panel panel = new Panel();
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JTextField txtTenPhong;
	private JTextField txtTimKiem;

	public Panel getFormQLPhong() {
		return this.panel;
	}
	
	public FormQLPhong() {
		setLayout(null);
		
		panel.setBounds(0, 20, 1355, 560);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBorder(new TitledBorder(null, "Thông tin phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinPhong.setBounds(10, 10, 673, 227);
		panel.add(panelThongTinPhong);
		panelThongTinPhong.setLayout(null);
		
		JLabel lbMaPhong = new JLabel("Mã phòng: ");
		lbMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaPhong.setBounds(10, 27, 96, 38);
		panelThongTinPhong.add(lbMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhong.setBounds(116, 31, 190, 30);
		panelThongTinPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lbLoaiPhong = new JLabel("Loại Phòng:");
		lbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLoaiPhong.setBounds(355, 24, 96, 38);
		panelThongTinPhong.add(lbLoaiPhong);
		
		JComboBox cbLoaiPhong = new JComboBox();
		cbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiPhong.setBounds(461, 30, 190, 30);
		panelThongTinPhong.add(cbLoaiPhong);
		
		JLabel lbGiaPhong = new JLabel("Giá phòng: ");
		lbGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiaPhong.setBounds(10, 145, 96, 38);
		panelThongTinPhong.add(lbGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaPhong.setBounds(116, 152, 190, 30);
		panelThongTinPhong.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JLabel lbTrinhTrang = new JLabel("Trình trạng: ");
		lbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTrinhTrang.setBounds(355, 78, 96, 38);
		panelThongTinPhong.add(lbTrinhTrang);
		
		JComboBox cbTrinhTrang = new JComboBox();
		cbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTrinhTrang.setBounds(461, 84, 190, 30);
		panelThongTinPhong.add(cbTrinhTrang);
		
		JLabel lbTenPhong = new JLabel("Tên phòng: ");
		lbTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenPhong.setBounds(10, 78, 96, 38);
		panelThongTinPhong.add(lbTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenPhong.setBounds(116, 85, 190, 30);
		panelThongTinPhong.add(txtTenPhong);
		txtTenPhong.setColumns(10);
		
		JButton btnThemPhong = new JButton("Thêm phòng");
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPhong.setBounds(355, 135, 120, 30);
		panelThongTinPhong.add(btnThemPhong);
		
		JButton btnSuaPhong = new JButton("Sửa phòng");
		btnSuaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaPhong.setBounds(531, 135, 120, 30);
		panelThongTinPhong.add(btnSuaPhong);
		
		JButton btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaPhong.setBounds(355, 176, 120, 30);
		panelThongTinPhong.add(btnXoaPhong);
		
		JButton btnReset = new JButton("Xóa rỗng");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(531, 175, 120, 30);
		panelThongTinPhong.add(btnReset);
		
		JPanel panelTimKiem = new JPanel();
		panelTimKiem.setBorder(new TitledBorder(null, "Tìm kiếm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimKiem.setBounds(693, 10, 642, 227);
		panel.add(panelTimKiem);
		panelTimKiem.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Nhập thông tin cần tìm:");
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTimKiem.setBounds(20, 30, 180, 30);
		panelTimKiem.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setBounds(241, 33, 367, 30);
		panelTimKiem.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lbLoaiTimKiem = new JLabel("Chọn loại tìm kiếm:");
		lbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLoaiTimKiem.setBounds(20, 100, 180, 30);
		panelTimKiem.add(lbLoaiTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(81, 175, 146, 30);
		panelTimKiem.add(btnTimKiem);
		
		JButton btnTimKiemTheoTrinhTrang = new JButton("Tìm các phòng còn trống");
		btnTimKiemTheoTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiemTheoTrinhTrang.setBounds(356, 175, 210, 30);
		panelTimKiem.add(btnTimKiemTheoTrinhTrang);
		
		JComboBox<String> cbTimKiem = new JComboBox<String>();
		cbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTimKiem.setBounds(241, 102, 367, 30);
		cbTimKiem.addItem("Tìm theo mã phòng");
		cbTimKiem.addItem("Tìm theo tên phòng");
		cbTimKiem.addItem("Tìm theo loại phòng");
		panelTimKiem.add(cbTimKiem);
		
		JPanel panelBangThuoc = new JPanel();
		panelBangThuoc.setBounds(10, 247, 1325, 303);
		panel.add(panelBangThuoc);
		panelBangThuoc.setLayout(null);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		JScrollPane scrollPhong;
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(0, 10, 1325, 283);
		scrollPhong.setBackground(new Color(248,248,248));
		panelBangThuoc.add(scrollPhong);
		
	}
	public static void main(String[] args) throws SQLException {		
		FormQLPhong frm = new FormQLPhong();
		frm.setVisible(true);
	}
}
