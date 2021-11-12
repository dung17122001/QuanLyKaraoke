package gui;

import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalDate;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JTitlePanel;

import connect.ConnectDB;
import dao.DAO_KhachHang;
import dao.DAO_Phong;
import dao.DaoCTHoaDonDichVu;
import dao.DaoCTHoaDonPhong;
import dao.DaoDichVu;
import dao.DaoHoaDon;
import dao.DaoLoaiDV;
import dao.DaoLoaiPhong;
import dao.PhatSinhMa;
import entity.ChiTietDDP;
import entity.ChiTietHoaDonDichVu;
import entity.ChiTietHoaDonPhong;
import entity.DichVu;
import entity.HoaDon;
import entity.KhachHang;
import entity.LoaiDichVu;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;

public class FormLapHD extends JPanel implements ActionListener,MouseListener{
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private DefaultTableModel dfDichVu;
	private JTable tableDichVu;
	private JButton btnThemPhong;
	private JButton btnThemDV;
	private JButton btnTinhGio;
	private JComboBox<String> cbLoaiDV;
	private JComboBox<String> cbTenDV;
	private DAO_Phong daoPhong=new DAO_Phong();
	private DaoLoaiPhong daoLoaiPhong=new DaoLoaiPhong();
	private DaoLoaiDV daoLoaiDV=new DaoLoaiDV();
	private DaoDichVu daoDichVu=new DaoDichVu();
	private DAO_KhachHang daoKhachHang=new DAO_KhachHang();
	private DaoHoaDon daoHoaDon=new DaoHoaDon();
	private DaoCTHoaDonPhong daoCTHoaDonPhong=new DaoCTHoaDonPhong();
	private DaoCTHoaDonDichVu daoCTHoaDonDichVu=new DaoCTHoaDonDichVu();
	private int stt=1;
	private DecimalFormat df = new DecimalFormat("# ###");
	private PhatSinhMa ma=new PhatSinhMa();
	private String maHoaDon;
	private JComboBox<Integer> cbGio;
	private JComboBox<Integer> cbPhut;
	private HoaDon hoaDon;
	private JSpinner txtSoLuong;
	private JSpinner spinner;

	public FormLapHD() {

		setBounds(0, 0, 1352, 565);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1352, 565);
		add(panel);
		panel.setLayout(null);

		JPanel panelPhong = new JPanel();
		panelPhong.setBorder(new TitledBorder(null, "Lựa chọn phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPhong.setBounds(10, 10, 645, 368);
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
		scrollPhong.setBounds(10, 20, 625, 298);
		scrollPhong.setBackground(new Color(248,248,248));
		panelPhong.add(scrollPhong);

		JLabel lbGio = new JLabel("New label");
		lbGio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGio.setBounds(288, 229, 45, 30);
		Calendar c = Calendar.getInstance();
		c.getTime().getHours();
		lbGio.setText("");
		panelPhong.add(lbGio); 

		JLabel lbTenPhong = new JLabel("");
		lbTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenPhong.setBounds(80, 229, 53, 30);
		panelPhong.add(lbTenPhong);

		btnThemPhong = new JButton("Thêm phòng vào hóa đơn");
		btnThemPhong.setBackground(Color.ORANGE);
		btnThemPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPhong.setBounds(176, 328, 222, 30);
		panelPhong.add(btnThemPhong);


		JPanel panelChiTietHD = new JPanel();
		panelChiTietHD.setBounds(665, 40, 677, 431);
		panel.add(panelChiTietHD);

		String []headerDV= {"STT","Mã hàng hóa","Tên hàng hóa","Số lượng","Đơn giá","Thành tiền"};
		dfDichVu=new DefaultTableModel(headerDV,0);
		JScrollPane scrollDichVu;
		panelChiTietHD.setLayout(null);
		tableDichVu=new JTable(dfDichVu);
		tableDichVu.setRowHeight(20);
		tableDichVu.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableDichVu.getTableHeader().setBackground(new Color(255, 204, 102));
		scrollDichVu=new JScrollPane(tableDichVu,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollDichVu.setBounds(0, 44, 667, 377);
		panelChiTietHD.add(scrollDichVu);
		scrollDichVu.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		scrollDichVu.setBackground(new Color(248,248,248));

		JLabel lbKhachHang = new JLabel("Tên khách hàng:");
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbKhachHang.setBounds(10, 10, 122, 30);
		panelChiTietHD.add(lbKhachHang);

		JLabel lbTenKhachHang = new JLabel("");
		lbTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenKhachHang.setBounds(147, 10, 234, 30);
		panelChiTietHD.add(lbTenKhachHang);

		JPanel panelDichVu = new JPanel();
		panelDichVu.setBorder(new TitledBorder(null, "Thêm dịch vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDichVu.setBounds(10, 388, 645, 151);
		panel.add(panelDichVu);
		panelDichVu.setLayout(null);

		JLabel lbLaoiDV = new JLabel("Loại dịch vụ:");
		lbLaoiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLaoiDV.setBounds(10, 33, 106, 30);
		panelDichVu.add(lbLaoiDV);

		cbLoaiDV = new JComboBox<String>();
		cbLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiDV.setBounds(130, 33, 205, 30);
		panelDichVu.add(cbLoaiDV);

		JLabel lbTenDV = new JLabel("Tên dịch vụ:");
		lbTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenDV.setBounds(10, 94, 87, 30);
		panelDichVu.add(lbTenDV);

		cbTenDV = new JComboBox<String>();
		cbTenDV.setBounds(130, 96, 205, 30);
		panelDichVu.add(cbTenDV);

		btnThemDV = new JButton("Thêm vào hóa đơn");
		btnThemDV.setBackground(Color.ORANGE);
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemDV.setBounds(375, 94, 241, 30);
		panelDichVu.add(btnThemDV);

		JLabel lbSoLuongDV = new JLabel("Số lượng:");
		lbSoLuongDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoLuongDV.setBounds(375, 33, 87, 30);
		panelDichVu.add(lbSoLuongDV);
		
		//SpinnerModel spinnerModel = new SpinnerNumberModel(1, 1, 100, 1);
        spinner = new JSpinner();//spinnerModel
        spinner = new JSpinner();
        spinner.setValue(1);
        spinner.setFont(new Font("Tahoma", Font.PLAIN, 15));
        spinner.setBounds(448, 34, 50, 30);
		panelDichVu.add(spinner);

		JLabel lbThongTinHD = new JLabel("Thông tin hóa đơn");
		lbThongTinHD.setForeground(Color.BLUE);
		lbThongTinHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbThongTinHD.setBounds(969, 10, 218, 30);
		panel.add(lbThongTinHD);

		btnTinhGio = new JButton("Bắt đầu tính giờ");
		btnTinhGio.setBackground(Color.ORANGE);
		btnTinhGio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTinhGio.setBounds(1087, 495, 186, 30);
		panel.add(btnTinhGio);

		JLabel lbGioVao = new JLabel("Giờ vào: ");
		lbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGioVao.setBounds(711, 495, 74, 30);
		panel.add(lbGioVao);

		cbGio = new JComboBox<Integer>();
		cbGio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGio.setBounds(793, 495, 50, 30);
		for(int i=0;i<25;i++) {
			cbGio.addItem(i);
		}
		panel.add(cbGio);

		JLabel lpPhu = new JLabel(":");
		lpPhu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lpPhu.setBounds(853, 495, 6, 30);
		panel.add(lpPhu);

		cbPhut = new JComboBox<Integer>();
		cbPhut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhut.setBounds(864, 495, 50, 30);
		for(int i=0;i<60;i++) {
			cbPhut.addItem(i);
		}
		panel.add(cbPhut);

		//	Thêm sự kiện
		btnThemDV.addActionListener(this);
		btnThemPhong.addActionListener(this);
		btnTinhGio.addActionListener(this);
		cbLoaiDV.addActionListener(this);
		tablePhong.addMouseListener(this);
		tableDichVu.addMouseListener(this);

		//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//		thêm dữ liệu vào table
		//		ThemDuLieuVaoTable();
		LoadTatCaPhong();

		//		Thêm dữ liệu vào combobox
		ThemDuLieuVaoCBLoaiDichVu();

		//Lấy tên khách hàng đã thêm mới nhất
		KhachHang lbkh=daoKhachHang.getKhachHangTheoMa(ma.maKhachHangVuaThem());
		lbTenKhachHang.setText(""+lbkh.getTenKhachHang());
		
		//lấy giờ hiện tại cho cbbox giờ và phút
		cbGio.setSelectedItem(Calendar.getInstance().getTime().getHours());
		cbPhut.setSelectedItem(Calendar.getInstance().getTime().getMinutes());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(cbLoaiDV)) {
			cbTenDV.removeAllItems();
			ArrayList<DichVu> dsDV=daoDichVu.getDichVuTheoLoai(cbLoaiDV.getSelectedItem().toString());
			for(DichVu dv:dsDV) {
				cbTenDV.addItem(dv.getTenDichVu());
			}
		}
		if(o.equals(btnThemPhong)) {
			int i=tablePhong.getSelectedRow();
			if(dfPhong.getValueAt(i, 4).toString().equals("Trống")) {
				LoaiPhong lp=daoLoaiPhong.getLoaiPhongTheoTen(dfPhong.getValueAt(i, 4).toString());
				Phong p=new Phong(dfPhong.getValueAt(i, 0).toString(), dfPhong.getValueAt(i, 1).toString(),
						dfPhong.getValueAt(i, 2).toString(),Double.parseDouble(dfPhong.getValueAt(i, 3).toString()) ,lp );
				dfDichVu.addRow(new Object[] {
						stt++,p.getMaPhong(),p.getTenPhong(),0,df.format(p.getGiaPhong()),0
				});
			}
			else 
				JOptionPane.showMessageDialog(this, "Phòng này đang được sử dụng");
			
		}
		if(o.equals(btnThemDV)) {
			DichVu dv=new DichVu();
			dv=daoDichVu.getDichVuTheoTen(cbTenDV.getSelectedItem().toString());
			dfDichVu.addRow(new Object[] {
					stt++,dv.getMaDichVu(),dv.getTenDichVu(),spinner.getValue(),df.format(dv.getGiaTien()),df.format(dv.getGiaTien()*(int)spinner.getValue())
			});
		}
		if(o.equals(btnTinhGio)) {
			maHoaDon=ma.maHoaDon();
			Date date=new Date(System.currentTimeMillis());
			KhachHang khachHang=daoKhachHang.getKhachHangTheoMa(ma.maKhachHangVuaThem());
			NhanVien nhanVien=new NhanVien("NV001");//lấy tạm, sau này lấy từ form đăng nhập
			hoaDon=new HoaDon(maHoaDon, date, "Chờ thanh toán", khachHang, nhanVien);
			daoHoaDon.themHoaDon(hoaDon);
			for(int i=0;i<tableDichVu.getRowCount();i++) {
				ThemVaoCTHDDichVu(i);
				ThemVaoCTHDP(i);
			}
			JOptionPane.showMessageDialog(this, "Đã lưu hóa đơn");
			clearTablePhong();
			LoadTatCaPhong();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

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

	public void ThemDuLieuVaoTable() {
		try {
			daoPhong.getDuLieuPhong("SELECT Phong.maPhong, Phong.tenPhong, LoaiPhong.tenLoai, Phong.giaPhong,"
					+ " Phong.trinhTrang FROM Phong INNER JOIN LoaiPhong ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong", dfPhong);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void LoadTatCaPhong() {
		ArrayList<Phong> dsp=new ArrayList<Phong>();
		dsp=daoPhong.getTatCaPhong();
		for(Phong p:dsp) {
			LoaiPhong lp=new LoaiPhong();
			lp=daoLoaiPhong.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			dfPhong.addRow(new Object[] {
					p.getMaPhong(),p.getTenPhong(),lp.getTenLoai(),df.format(p.getGiaPhong()),p.getTinhTrang()
			});
		}
	}

	public void ThemDuLieuVaoCBLoaiDichVu() {
		ArrayList<LoaiDichVu> dsDV=new ArrayList<LoaiDichVu>();
		dsDV=daoLoaiDV.getTatCaLoaiDV();
		for(LoaiDichVu l: dsDV) {
			cbLoaiDV.addItem(l.getTenLoaiDV());
		}
	}
	private void ThemVaoCTHDP(int vt) {
		Phong p=daoPhong.getPhongTheoMa(dfDichVu.getValueAt(vt, 1).toString());
		Time gioVao= new Time((int)cbGio.getSelectedItem(), (int) cbPhut.getSelectedItem(), 0);
		Time gioRa=null;
		if(p!=null) {
			ChiTietHoaDonPhong cthdp=new ChiTietHoaDonPhong(hoaDon, p, gioVao, gioRa);
			daoCTHoaDonPhong.themChiTietHDPhong(cthdp);
			daoPhong.updateTrinhTrangPhong(p.getMaPhong());
		}
		
	}
	private void ThemVaoCTHDDichVu(int vt) {
		DichVu dv=daoDichVu.getDichVuTheoMa(dfDichVu.getValueAt(vt, 1).toString());
		int soLuong=(int) dfDichVu.getValueAt(vt, 3);
		if(dv!=null) {
			ChiTietHoaDonDichVu cthddv=new ChiTietHoaDonDichVu(hoaDon, dv, soLuong);
			daoCTHoaDonDichVu.themChiTietHDDichVu(cthddv);
		}
		
	}
	private void clearTablePhong() {
		while (tablePhong.getRowCount() > 0) {
			dfPhong.removeRow(0);
		}
	}
}
