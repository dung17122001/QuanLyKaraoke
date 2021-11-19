package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.DaoKhachHang;
import dao.DaoPhong;
import dao.DaoCTHoaDonDichVu;
import dao.DaoCTHoaDonPhong;
import dao.DaoDichVu;
import dao.DaoHoaDon;
import dao.DaoLoaiDV;
import dao.DaoLoaiPhong;
import entity.ChiTietHoaDonDichVu;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiDichVu;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;

public class FormTimHoaDon extends JPanel implements ActionListener,MouseListener{
	private JTable tableDichVu;
	private JTextField txtTongTien;
	private JTextField txtTienNhan;
	private JTextField txtTienThoi;
	public static DefaultTableModel dfHoaDon;
	private JTable tableHoaDon;
	public static DefaultTableModel dfHangHoa;
	private JTable tableHangHoa;
	private JTextField txtTimKiem;
	private DaoPhong daoPhong=new DaoPhong();
	private DaoLoaiPhong daoLoaiPhong=new DaoLoaiPhong();
	private DaoLoaiDV daoLoaiDV=new DaoLoaiDV();
	private DaoDichVu daoDichVu=new DaoDichVu();
	private DaoKhachHang daoKhachHang=new DaoKhachHang();
	private DaoHoaDon daoHoaDon=new DaoHoaDon();
	private DaoCTHoaDonPhong daoCTHoaDonPhong=new DaoCTHoaDonPhong();
	private DaoCTHoaDonDichVu daoCTHoaDonDichVu=new DaoCTHoaDonDichVu();
	public static int stt=1;
	private JComboBox<String> cbLoaiDV;
	private JComboBox<String> cbTenDV;
	private JComboBox<Integer> cbPhutVao;
	private JComboBox<Integer> cbGioVao;
	private JComboBox<Integer> cbGioRa;
	private JComboBox<Integer> cbPhutRa;
	private JLabel lbTenKhachHang,lbDT,lbSDT;
	private JSpinner txtSL;
	public static Time gioVao;
	private Time gioRa;
	private JButton btnThemDV,btnKetThuc,btnThanhToan,btnTimKiem;
	private double tienPhong=0.0,tienDV=0.0,tongTien=0.0,tienNhan=0.0,tienThoi=0.0;
	public static Double gioDaHat=0.0;
	private DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");

	public FormTimHoaDon() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelDV = new JPanel();
		panelDV.setBorder(new TitledBorder(null, "Chọn dịch vụ cần thêm vào hóa đơn", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDV.setBounds(10, 258, 669, 129);
		panel.add(panelDV);
		panelDV.setLayout(null);
		
		JLabel lbDichVu = new JLabel("Chọn loại dịch vụ: ");
		lbDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDichVu.setBounds(10, 22, 157, 30);
		panelDV.add(lbDichVu);
		
		JLabel lbTenDV = new JLabel("Tên dịch vụ:");
		lbTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenDV.setBounds(347, 22, 95, 30);
		panelDV.add(lbTenDV);
		
		JLabel lbSoLuong = new JLabel("Số lượng: ");
		lbSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoLuong.setBounds(10, 76, 95, 30);
		panelDV.add(lbSoLuong);
		
		cbLoaiDV = new JComboBox<String>();
		cbLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiDV.setBounds(155, 22, 170, 30);
		panelDV.add(cbLoaiDV);
		
		cbTenDV = new JComboBox<String>();
		cbTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTenDV.setBounds(457, 22, 190, 30);
		panelDV.add(cbTenDV);
		
		btnThemDV = new JButton("Thêm dịch vụ vào hóa đơn");
		btnThemDV.setBackground(Color.ORANGE);
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemDV.setBounds(410, 76, 237, 30);
		panelDV.add(btnThemDV);
		
		txtSL = new JSpinner();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSL.setBounds(155, 77, 56, 30);
		txtSL.setValue(1);
		panelDV.add(txtSL);
		
		JPanel pnCTHD = new JPanel();
		pnCTHD.setBounds(689, 10, 653, 377);
		panel.add(pnCTHD);
		pnCTHD.setLayout(null);
		
		String []header= {"STT","Mã hàng hóa","Tên hàng hóa","Đơn giá","Số lượng","Thành tiền"};
		dfHangHoa=new DefaultTableModel(header,0);
		tableHangHoa=new JTable(dfHangHoa);
		tableHangHoa.setRowHeight(20);
		tableHangHoa.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableHangHoa.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollHangHoa;
		scrollHangHoa=new JScrollPane(tableHangHoa,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollHangHoa.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		scrollHangHoa.setBounds(10, 84, 633,293);
		scrollHangHoa.setBackground(new Color(248,248,248));
		pnCTHD.add(scrollHangHoa);
		
		JLabel lbHoaDon = new JLabel("Thông tin hóa đơn");
		lbHoaDon.setForeground(Color.BLUE);
		lbHoaDon.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbHoaDon.setBounds(243, 10, 217, 30);
		pnCTHD.add(lbHoaDon);
		
		JLabel lbTenKH = new JLabel("Tên khách hàng:");
		lbTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenKH.setBounds(10, 48, 130, 30);
		pnCTHD.add(lbTenKH);
		
		lbTenKhachHang = new JLabel("");
		lbTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenKhachHang.setBounds(137, 48, 170, 30);
		pnCTHD.add(lbTenKhachHang);
		
		lbDT = new JLabel("Số điện thoại:");
		lbDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDT.setBounds(348, 50, 112, 30);
		pnCTHD.add(lbDT);
		
		lbSDT = new JLabel("");
		lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSDT.setBounds(470, 48, 173, 30);
		pnCTHD.add(lbSDT);
		
		JPanel panelChiTiet = new JPanel();
		panelChiTiet.setBorder(new TitledBorder(null, "Thông tin chi tiết", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelChiTiet.setBounds(10, 397, 1332, 147);
		panel.add(panelChiTiet);
		panelChiTiet.setLayout(null);
		
		JLabel lbGioVao = new JLabel("Thời gian vào:");
		lbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioVao.setBounds(52, 17, 137, 30);
		panelChiTiet.add(lbGioVao);
		
		JLabel lbGioRa = new JLabel("Thời gian trả phòng:");
		lbGioRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioRa.setBounds(52, 57, 144, 30);
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
//		txtTongTien.setEnabled(false);
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
		
		btnThanhToan = new JButton("Thanh Toán");
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
		
		cbGioVao = new JComboBox<Integer>();
		cbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioVao.setBounds(199, 17, 50, 30);
		for(int i=0;i<25;i++) {
			cbGioVao.addItem(i);
		}
		panelChiTiet.add(cbGioVao);
		
		JLabel lbphu = new JLabel(":");
		lbphu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphu.setBounds(259, 17, 6, 30);
		panelChiTiet.add(lbphu);
		
		cbPhutVao = new JComboBox<Integer>();
		cbPhutVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhutVao.setBounds(275, 17, 50, 30);
		for(int i=0;i<60;i++) {
			cbPhutVao.addItem(i);
		}
		panelChiTiet.add(cbPhutVao);
		
		cbGioRa = new JComboBox<Integer>();
		cbGioRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioRa.setBounds(199, 57, 50, 30);
		for(int i=0;i<25;i++) {
			cbGioRa.addItem(i);
		}
		panelChiTiet.add(cbGioRa);
		
		JLabel lbphu_1 = new JLabel(":");
		lbphu_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphu_1.setBounds(259, 57, 6, 30);
		panelChiTiet.add(lbphu_1);
		
		cbPhutRa = new JComboBox<Integer>();
		cbPhutRa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhutRa.setBounds(275, 57, 50, 30);
		for(int i=0;i<60;i++) {
			cbPhutRa.addItem(i);
		}
		panelChiTiet.add(cbPhutRa);
		
		JPanel pnHoaDon = new JPanel();
		pnHoaDon.setBounds(10, 10, 669, 251);
		panel.add(pnHoaDon);
		pnHoaDon.setLayout(null);
		
		String []headerHD= {"Mã hóa đơn","Tên phòng","Tên khách hàng","Giờ vào","Trình trạng"};
		dfHoaDon=new DefaultTableModel(headerHD,0);
		tableHoaDon=new JTable(dfHoaDon);
		tableHoaDon.setRowHeight(20);
		tableHoaDon.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableHoaDon.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollHoaDon;
		scrollHoaDon=new JScrollPane(tableHoaDon,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollHoaDon.setBorder(BorderFactory.createTitledBorder("Thông tin các hóa đơn"));
		scrollHoaDon.setBounds(10, 57, 649,184);
		scrollHoaDon.setBackground(new Color(248,248,248));
		pnHoaDon.add(scrollHoaDon);
		
		JLabel lbTimKiem = new JLabel("Tìm nhanh hóa đơn:");
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTimKiem.setBounds(10, 10, 155, 30);
		pnHoaDon.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setForeground(Color.LIGHT_GRAY);
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTimKiem.setBounds(156, 11, 280, 30);
		txtTimKiem.setText("Nhập tên phòng, tên khách hàng hoặc SDT khách hàng");
		pnHoaDon.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(469, 10, 119, 30);
		pnHoaDon.add(btnTimKiem);
		
		btnKetThuc = new JButton("Xác nhận trả phòng");
		btnKetThuc.setBackground(Color.ORANGE);
		btnKetThuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnKetThuc.setBounds(98, 99, 180, 30);
		panelChiTiet.add(btnKetThuc);
		
//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//Thêm sự kiện
		cbLoaiDV.addActionListener(this);
		btnInHoaDon.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnThemDV.addActionListener(this);
		btnTimKiem.addActionListener(this);
		tableHoaDon.addMouseListener(this);
		btnKetThuc.addActionListener(this);
		txtTimKiem.addMouseListener(this);
		
//		Thêm dữ liệu vào combobox
		ThemDuLieuVaoCBLoaiDichVu();
		//Lấy danh sách các hóa đơn chờ thanh toán
		daoHoaDon.LayHoaDonChoThanhToan();
		
		//lấy giờ hiện tại cho cbbox giờ và phút
		cbGioRa.setSelectedItem(Calendar.getInstance().getTime().getHours());
		cbPhutRa.setSelectedItem(Calendar.getInstance().getTime().getMinutes());
		
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object o=e.getSource();
		if(o.equals(tableHoaDon)) {
			int i=tableHoaDon.getSelectedRow();
			KhachHang kh=new KhachHang();
			kh=daoKhachHang.getKhachHangTheoTen(dfHoaDon.getValueAt(i, 2).toString());
			lbTenKhachHang.setText(""+kh.getTenKhachHang());
			lbSDT.setText(""+kh.getSoDienThoai());
			clearTableChiTietHoaDon();
			daoHoaDon.LayThongTinPhongTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
			daoHoaDon.LayThongTinDichVuTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
			daoHoaDon.layGioVaoTheoHoaDon(dfHoaDon.getValueAt(i, 0).toString());
			cbGioVao.setSelectedItem(gioVao.getHours());
			cbPhutVao.setSelectedItem(gioVao.getMinutes());
		}
		if(o.equals(txtTimKiem)) {
			txtTimKiem.setText("");
			txtTimKiem.setForeground(Color.BLACK);
			txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(cbLoaiDV)) {
			cbTenDV.removeAllItems();
			ArrayList<DichVu> dsDV=daoDichVu.getDichVuTheoLoai(cbLoaiDV.getSelectedItem().toString());
			for(DichVu dv:dsDV) {
				cbTenDV.addItem(dv.getTenDichVu());
			}
		}
		if(o.equals(btnThemDV)) {
			int i=tableHoaDon.getSelectedRow();
			int count=0;
			if(dfHoaDon.getValueAt(i, 4).equals("Chờ thanh toán")) {
				for(int j=0;j<tableHangHoa.getRowCount();j++) {
					if(cbTenDV.getSelectedItem().toString().equals(dfHangHoa.getValueAt(j, 2).toString())) {
						DichVu dv=daoDichVu.getDichVuTheoTen(cbTenDV.getSelectedItem().toString());
						daoHoaDon.capNhatSoLuongDV(dfHoaDon.getValueAt(i, 0).toString(),dv.getMaDichVu() ,(int) txtSL.getValue());
						JOptionPane.showMessageDialog(this, "Dịch vụ này đã có và số lượng đã được cộng thêm");
						clearTableChiTietHoaDon();
						daoHoaDon.LayThongTinPhongTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
						daoHoaDon.LayThongTinDichVuTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
						break;
					}
					count++;
				}
				if(count==tableHangHoa.getRowCount()) {
					DichVu dv=daoDichVu.getDichVuTheoTen(cbTenDV.getSelectedItem().toString());
					HoaDon hd=new HoaDon(dfHoaDon.getValueAt(i, 0).toString());
					ChiTietHoaDonDichVu ctdhdv=new ChiTietHoaDonDichVu(hd, dv, (int)txtSL.getValue());
					daoCTHoaDonDichVu.themChiTietHDDichVu(ctdhdv);
					JOptionPane.showMessageDialog(this, "Đã thêm dịch vụ vào hóa đơn");
					clearTableChiTietHoaDon();
					daoHoaDon.LayThongTinPhongTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
					daoHoaDon.LayThongTinDichVuTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán nên không được phép thêm");
			}
			
		}
		if(o.equals(btnKetThuc)) {
			int i=tableHoaDon.getSelectedRow();
			gioRa=new Time((int)cbGioRa.getSelectedItem(), (int)cbPhutRa.getSelectedItem(), 0);
			daoCTHoaDonPhong.capNhatGioRa(dfHoaDon.getValueAt(i, 0).toString(), gioRa);
			gioDaHat=daoCTHoaDonPhong.soGioDaHat(dfHoaDon.getValueAt(i, 0).toString())/60;
			clearTableChiTietHoaDon();
			daoHoaDon.LayThongTinPhongTuHoaDonDaTraPhong(dfHoaDon.getValueAt(i, 0).toString());
			daoHoaDon.LayThongTinDichVuTuHoaDon(dfHoaDon.getValueAt(i, 0).toString());
			JOptionPane.showMessageDialog(this, "Đã ngưng tính giờ phòng");
			tienPhong=daoCTHoaDonPhong.tinhTienPhong(dfHoaDon.getValueAt(i, 0).toString());
			tienDV=daoCTHoaDonDichVu.tinhTienDichVu(dfHoaDon.getValueAt(i, 0).toString());
			tongTien=tienPhong+tienDV;
			txtTongTien.setText(tien.format(tongTien));
		}
		if(o.equals(btnThanhToan)) {
			int i=tableHoaDon.getSelectedRow();
			if(tableHoaDon.getSelectedRow()==-1)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn hóa đơn cần thanh toán");
			else if(txtTongTien.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng xác nhận trả phòng trước khi thanh toán");
			else if(txtTienNhan.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng nhập số tiền khách đã đưa");
			else {
				tienNhan=Double.parseDouble(txtTienNhan.getText());
				if(tienNhan>tongTien) {
					tienThoi=tienNhan-tongTien;
					txtTienThoi.setText(tien.format(tienThoi));
					daoHoaDon.capNhatTrangThaiHoaDon(dfHoaDon.getValueAt(i, 0).toString());
					daoPhong.updatePhongThanhTrong(dfHoaDon.getValueAt(i, 1).toString());
					JOptionPane.showMessageDialog(this, "Hóa đơn đã được thanh toán");
				}
				else {
					JOptionPane.showMessageDialog(this, "Tiền nhận phải lớn hơn tổng tiền của hóa đơn");
				}
			}
			
		}
		if(o.equals(btnTimKiem)) {
			clearTableHoaDon();
			daoHoaDon.LayHoaDonTheoDK(txtTimKiem.getText());
			int i=tableHoaDon.getRowCount();
			if(i==0)
				JOptionPane.showMessageDialog(this, "Không có hóa đơn nào được tìm thấy");
		}
		
	}
	
	public void ThemDuLieuVaoCBLoaiDichVu() {
		ArrayList<LoaiDichVu> dsDV=new ArrayList<LoaiDichVu>();
		dsDV=daoLoaiDV.getTatCaLoaiDV();
		for(LoaiDichVu l: dsDV) {
			cbLoaiDV.addItem(l.getTenLoaiDV());
		}
	}
	
	private void clearTableChiTietHoaDon() {
		while (tableHangHoa.getRowCount() > 0) {
			dfHangHoa.removeRow(0);
		}
	}
	private void clearTableHoaDon() {
		while (tableHoaDon.getRowCount() > 0) {
			dfHoaDon.removeRow(0);
		}
	}
}
