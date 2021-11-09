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
		lbTimKiem.setBounds(30, 21, 240, 30);
		panelTimHD.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setBounds(280, 22, 328, 30);
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
		
		JButton btnTimKiem = new JButton("Tìm hóa đơn chờ thanh toán");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(368, 128, 240, 30);
		panelTimHD.add(btnTimKiem);
		
		JButton btnTimHDDaThanhToan = new JButton("Tìm hóa đơn đã thanh toán");
		btnTimHDDaThanhToan.setBackground(Color.ORANGE);
		btnTimHDDaThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimHDDaThanhToan.setBounds(40, 128, 226, 30);
		panelTimHD.add(btnTimHDDaThanhToan);
		
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
		lbTenDV.setBounds(54, 53, 157, 30);
		panelDV.add(lbTenDV);
		
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoLuong.setBounds(54, 93, 157, 30);
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
		btnThemDV.setBackground(Color.ORANGE);
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemDV.setBounds(198, 142, 237, 30);
		panelDV.add(btnThemDV);
		
		JPanel panelCTHD = new JPanel();
		panelCTHD.setBounds(10, 191, 1332, 207);
		panel.add(panelCTHD);
		panelCTHD.setLayout(null);
		
		String []header= {"STT","Mã hàng hóa","Tên hàng hóa","Đơn giá","Số lượng","Thành tiền"};
		dfDichVu=new DefaultTableModel(header,0);
		tableDichVu=new JTable(dfDichVu);
		tableDichVu.setRowHeight(20);
		tableDichVu.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableDichVu.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollDichVu;
		scrollDichVu=new JScrollPane(tableDichVu,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollDichVu.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		scrollDichVu.setBounds(10, 10, 1312,187);
		scrollDichVu.setBackground(new Color(248,248,248));
		panelCTHD.add(scrollDichVu);
		
		JPanel panelChiTiet = new JPanel();
		panelChiTiet.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChiTiet.setBounds(10, 397, 1332, 147);
		panel.add(panelChiTiet);
		panelChiTiet.setLayout(null);
		
		JLabel lbGioVao = new JLabel("Giờ vào: ");
		lbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioVao.setBounds(24, 60, 69, 30);
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
		lbGioRa.setBounds(24, 100, 55, 30);
		panelChiTiet.add(lbGioRa);
		
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
		btnThanhToan.setBackground(Color.ORANGE);
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThanhToan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThanhToan.setBounds(1115, 29, 152, 30);
		panelChiTiet.add(btnThanhToan);
		
		JButton btnInHoaDon = new JButton("In hóa đơn");
		btnInHoaDon.setBackground(Color.ORANGE);
		btnInHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInHoaDon.setBounds(1115, 82, 152, 30);
		panelChiTiet.add(btnInHoaDon);
		
		JComboBox<Integer> cbGioVao = new JComboBox<Integer>();
		cbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioVao.setBounds(100, 62, 46, 30);
		for(int i=0;i<25;i++)
			cbGioVao.addItem(i);
		panelChiTiet.add(cbGioVao);
		
		JLabel lbphu = new JLabel(":");
		lbphu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphu.setBounds(156, 60, 12, 30);
		panelChiTiet.add(lbphu);
		
		JComboBox<Integer> cbPhutVao = new JComboBox<Integer>();
		cbPhutVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhutVao.setBounds(166, 62, 46, 30);
		for(int i=0;i<60;i++)
			cbPhutVao.addItem(i);
		panelChiTiet.add(cbPhutVao);
		
		JComboBox<Integer> cbGioRa = new JComboBox<Integer>();
		cbGioRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioRa.setBounds(100, 100, 46, 30);
		for(int i=0;i<25;i++)
			cbGioRa.addItem(i);
		panelChiTiet.add(cbGioRa);
		
		JLabel lbphu_1 = new JLabel(":");
		lbphu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphu_1.setBounds(156, 100, 12, 30);
		panelChiTiet.add(lbphu_1);
		
		JComboBox<Integer> cbPhutRa = new JComboBox<Integer>();
		cbPhutRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhutRa.setBounds(166, 100, 46, 30);
		for(int i=0;i<60;i++)
			cbPhutRa.addItem(i);
		panelChiTiet.add(cbPhutRa);
	}
}
