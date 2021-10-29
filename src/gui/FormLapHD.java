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

public class FormLapHD extends JPanel {
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private DefaultTableModel dfDichVu;
	private JTable tableDichVu;
	private JTextField txtSoLuongDV;

	public FormLapHD() {
		
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Nhập thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 1332, 118);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbKhachHang = new JLabel("Tên khách hàng: ");
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbKhachHang.setBounds(23, 21, 125, 30);
		panel_1.add(lbKhachHang);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKH.setBounds(202, 22, 370, 30);
		panel_1.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ: ");
		lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDiaChi.setBounds(23, 71, 125, 30);
		panel_1.add(lbDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setBounds(202, 72, 370, 30);
		panel_1.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lbCMND = new JLabel("Số CMND/CCCD: ");
		lbCMND.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCMND.setBounds(667, 22, 156, 30);
		panel_1.add(lbCMND);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCMND.setBounds(833, 22, 456, 30);
		panel_1.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lbSDT = new JLabel("Số điện thoại:");
		lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSDT.setBounds(667, 71, 125, 30);
		panel_1.add(lbSDT);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setBounds(833, 72, 456, 30);
		panel_1.add(txtSDT);
		txtSDT.setColumns(10);
		
		JPanel panelPhong = new JPanel();
		panelPhong.setBorder(new TitledBorder(null, "Lựa chọn phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPhong.setBounds(10, 138, 645, 275);
		panel.add(panelPhong);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		JScrollPane scrollPhong;
		panelPhong.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(10, 20, 625, 199);
		scrollPhong.setBackground(new Color(248,248,248));
		panelPhong.add(scrollPhong);
		
		JLabel lbGioVao = new JLabel("Giờ vào:");
		lbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioVao.setBounds(221, 234, 82, 20);
		panelPhong.add(lbGioVao);
		
		JButton btnThemPhong = new JButton("Thêm vào hóa đơn");
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPhong.setBounds(416, 229, 167, 30);
		panelPhong.add(btnThemPhong);
		
		JLabel lbPhong = new JLabel("Phòng: ");
		lbPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPhong.setBounds(20, 229, 69, 30);
		panelPhong.add(lbPhong);
		
		JPanel panelChiTietHD = new JPanel();
		panelChiTietHD.setBounds(665, 299, 677, 256);
		panel.add(panelChiTietHD);
		
		String []headerDV= {"Mã dịch vụ","Tên dịch vụ","Số lượng","Đơn giá"};
		dfDichVu=new DefaultTableModel(headerDV,0);
		tableDichVu=new JTable(dfDichVu);
		tableDichVu.setRowHeight(20);
		JScrollPane scrollDichVu;
		panelChiTietHD.setLayout(null);
		scrollDichVu=new JScrollPane(tableDichVu,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollDichVu.setBorder(BorderFactory.createTitledBorder("Các dịch vụ đã thêm"));
		scrollDichVu.setBounds(10, 5, 657, 241);
		scrollDichVu.setBackground(new Color(248,248,248));
		panelChiTietHD.add(scrollDichVu);
		
		JPanel panelDichVu = new JPanel();
		panelDichVu.setBorder(new TitledBorder(null, "Th\u00EAm d\u1ECBch v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDichVu.setBounds(666, 138, 676, 151);
		panel.add(panelDichVu);
		panelDichVu.setLayout(null);
		
		JLabel lbLaoiDV = new JLabel("Loại dịch vụ:");
		lbLaoiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLaoiDV.setBounds(10, 33, 106, 30);
		panelDichVu.add(lbLaoiDV);
		
		JComboBox cbLoaiDV = new JComboBox();
		cbLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiDV.setBounds(130, 33, 205, 30);
		panelDichVu.add(cbLoaiDV);
		
		JLabel lbTenDV = new JLabel("Tên dịch vụ:");
		lbTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenDV.setBounds(10, 94, 87, 30);
		panelDichVu.add(lbTenDV);
		
		JComboBox cbTenDV = new JComboBox();
		cbTenDV.setBounds(130, 96, 205, 30);
		panelDichVu.add(cbTenDV);
		
		JButton btnThemDV = new JButton("Thêm vào hóa đơn");
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemDV.setBounds(448, 94, 186, 30);
		panelDichVu.add(btnThemDV);
		
		JLabel lbSoLuongDV = new JLabel("Số lượng:");
		lbSoLuongDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoLuongDV.setBounds(375, 33, 87, 30);
		panelDichVu.add(lbSoLuongDV);
		
		txtSoLuongDV = new JTextField();
		txtSoLuongDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuongDV.setBounds(448, 34, 218, 30);
		panelDichVu.add(txtSoLuongDV);
		txtSoLuongDV.setColumns(10);
		
		JButton btnThemHoaDon = new JButton("Thêm mới hóa đơn");
		btnThemHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemHoaDon.setBounds(382, 481, 189, 30);
		panel.add(btnThemHoaDon);
		
		JButton btnXoaRong = new JButton("Xóa rỗng");
		btnXoaRong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaRong.setBounds(75, 481, 136, 30);
		panel.add(btnXoaRong);
	}
}
