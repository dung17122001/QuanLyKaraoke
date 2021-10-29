package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;

public class FormTimHoaDon extends JPanel {
	private JTextField txtTimKiem;
	private JTextField txtSoLuong;
	private DefaultTableModel dfDichVu;
	private JTable tableDichVu;
	private JTextField txtTongTien;
	private JTextField txtTienNhan;
	private JTextField txtTienThoi;

	public FormTimHoaDon() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelTimHD = new JPanel();
		panelTimHD.setBorder(new TitledBorder(null, "Nhập thông tin hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTimHD.setBounds(10, 10, 669, 182);
		panel.add(panelTimHD);
		panelTimHD.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Nhập thông tin hóa đơn cần tìm: ");
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTimKiem.setBounds(30, 10, 240, 30);
		panelTimHD.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setBounds(280, 11, 328, 30);
		panelTimHD.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lbLoaiTimKiem = new JLabel("Chọn loại tìm kiếm: ");
		lbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLoaiTimKiem.setBounds(30, 71, 240, 30);
		panelTimHD.add(lbLoaiTimKiem);
		
		JComboBox<String> cbLoaiTimKiem = new JComboBox<String>();
		cbLoaiTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiTimKiem.setBounds(280, 71, 328, 30);
		cbLoaiTimKiem.addItem("Tìm theo tên phòng");
		cbLoaiTimKiem.addItem("Tìm theo mã hóa đơn");
		cbLoaiTimKiem.addItem("Tìm theo số điện thoại khách hàng");
		panelTimHD.add(cbLoaiTimKiem);
		
		JButton btnTimKiem = new JButton("Tìm hóa đơn");
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(259, 128, 139, 30);
		panelTimHD.add(btnTimKiem);
		
		JPanel panelDV = new JPanel();
		panelDV.setBorder(new TitledBorder(null, "Chọn dịch vụ cần thêm vào hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDV.setBounds(689, 10, 653, 182);
		panel.add(panelDV);
		panelDV.setLayout(null);
		
		JLabel lbDichVu = new JLabel("Chọn loại dịch vụ: ");
		lbDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDichVu.setBounds(54, 12, 157, 30);
		panelDV.add(lbDichVu);
		
		JLabel lbTenDV = new JLabel("Tên dịch vụ:");
		lbTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenDV.setBounds(75, 52, 157, 30);
		panelDV.add(lbTenDV);
		
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoLuong.setBounds(75, 93, 157, 30);
		panelDV.add(lbSoLuong);
		
		JComboBox cbLoaiDV = new JComboBox();
		cbLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiDV.setBounds(242, 12, 310, 30);
		panelDV.add(cbLoaiDV);
		
		JComboBox cbTenDV = new JComboBox();
		cbTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTenDV.setBounds(242, 52, 310, 30);
		panelDV.add(cbTenDV);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuong.setBounds(242, 94, 310, 30);
		panelDV.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JButton btnThemDV = new JButton("Thêm dịch vụ vào hóa đơn");
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemDV.setBounds(198, 142, 237, 30);
		panelDV.add(btnThemDV);
		
		JPanel panelCTHD = new JPanel();
		panelCTHD.setBounds(10, 191, 1332, 207);
		panel.add(panelCTHD);
		panelCTHD.setLayout(null);
		
		String []header= {"STT","Mã dịch vụ","Tên Dịch vụ","Giá tiền","Số lượng","Thành tiền"};
		dfDichVu=new DefaultTableModel(header,0);
		tableDichVu=new JTable(dfDichVu);
		tableDichVu.setRowHeight(20);
		JScrollPane scrollDichVu;
		scrollDichVu=new JScrollPane(tableDichVu,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollDichVu.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		scrollDichVu.setBounds(10, 10, 1312,176);
		scrollDichVu.setBackground(new Color(248,248,248));
		panelCTHD.add(scrollDichVu);
		
		JPanel panelChiTiet = new JPanel();
		panelChiTiet.setBorder(new TitledBorder(null, "Th\u00F4ng tin chi ti\u1EBFt", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChiTiet.setBounds(10, 397, 1332, 147);
		panel.add(panelChiTiet);
		panelChiTiet.setLayout(null);
		
		JLabel lbGioVao = new JLabel("Giờ vào: ");
		lbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioVao.setBounds(24, 60, 93, 30);
		panelChiTiet.add(lbGioVao);
		
		JLabel lbTrinhTrang = new JLabel("Trình trạng hóa đơn: ");
		lbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTrinhTrang.setBounds(27, 20, 152, 30);
		panelChiTiet.add(lbTrinhTrang);
		
		JCheckBox chckThanhToan = new JCheckBox("Đã thanh toán");
		chckThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckThanhToan.setBounds(185, 20, 123, 30);
		panelChiTiet.add(chckThanhToan);
		
		JCheckBox chckChoThanhToan = new JCheckBox("Chờ thanh toán");
		chckChoThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		chckChoThanhToan.setBounds(322, 20, 152, 30);
		panelChiTiet.add(chckChoThanhToan);
		
		JLabel lbGioRa = new JLabel("Giờ ra:");
		lbGioRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioRa.setBounds(185, 60, 55, 30);
		panelChiTiet.add(lbGioRa);
		
		JLabel lbPhong = new JLabel("Phòng đã hát:");
		lbPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPhong.setBounds(24, 99, 107, 30);
		panelChiTiet.add(lbPhong);
		
		JLabel lbTongTien = new JLabel("Tổng tiền cần thanh toán (VNĐ):");
		lbTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTongTien.setBounds(549, 10, 231, 30);
		panelChiTiet.add(lbTongTien);
		
		JLabel lbTienNhan = new JLabel("Tiền nhận (VNĐ): ");
		lbTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTienNhan.setBounds(549, 55, 231, 30);
		panelChiTiet.add(lbTienNhan);
		
		JLabel lbTienThoi = new JLabel("Tiền thối lại (VNĐ) :");
		lbTienThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTienThoi.setBounds(549, 99, 231, 30);
		panelChiTiet.add(lbTienThoi);
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTien.setBounds(777, 18, 198, 30);
		panelChiTiet.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		txtTienNhan = new JTextField();
		txtTienNhan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTienNhan.setBounds(777, 61, 198, 30);
		panelChiTiet.add(txtTienNhan);
		txtTienNhan.setColumns(10);
		
		txtTienThoi = new JTextField();
		txtTienThoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTienThoi.setBounds(777, 100, 198, 30);
		panelChiTiet.add(txtTienThoi);
		txtTienThoi.setColumns(10);
		
		JButton btnThanhToan = new JButton("Thanh Toán");
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThanhToan.setBounds(1115, 29, 152, 30);
		panelChiTiet.add(btnThanhToan);
		
		JButton btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInHoaDon.setBounds(1115, 82, 152, 30);
		panelChiTiet.add(btnInHoaDon);
	}
}
