package gui;

import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ScrollPaneConstants;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import chucnang.Regex;
import connect.ConnectDB;
import dao.DaoKhachHang;
import dao.DaoPhong;
import dao.DaoChiTietDDP;
import dao.DaoDonDatPhong;
import dao.DaoLoaiPhong;
import dao.PhatSinhMa;
import entity.ChiTietDDP;
import entity.DonDatPhong;
import entity.KhachHang;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;

public class FormDatPhong extends JPanel implements ActionListener, MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JDateChooser ngayDat;
	private JButton btnDatPhong,btnTimKiem;
	private JButton btnLuu;
	private DaoPhong daoPhong=new DaoPhong();
	private DaoLoaiPhong daoLoaiPhong=new DaoLoaiPhong();
	private DefaultTableModel dfCTPhong;
	private JTable tablePhongCT;
	private JComboBox<Integer> cbGio;
	private JComboBox<Integer> cbPhut;
	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
	private DecimalFormat df = new DecimalFormat("#,### VNĐ");
	private PhatSinhMa ma=new PhatSinhMa();
	private DaoDonDatPhong daoDonDatPhong=new DaoDonDatPhong();
	private DaoChiTietDDP daoChiTietDDP=new DaoChiTietDDP();
	private DaoKhachHang daoKhachHang=new DaoKhachHang();
	private String maDon;
	private String makh;
	public static JLabel lbTenKhachHang,lbSDT;
	private JTextField txtTimKH;
	public static KhachHang khachHang=new KhachHang();

	public FormDatPhong(){

		setBounds(0, 0, 1352, 565);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);

		JPanel panelPhong = new JPanel();
		panelPhong.setBorder(new TitledBorder(null, "Lựa chọn phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPhong.setBounds(10, 95, 640, 446);
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
		scrollPhong.setBounds(10, 40, 620, 262);
		scrollPhong.setBackground(new Color(248,248,248));
		panelPhong.add(scrollPhong);

		JLabel lbGioDat = new JLabel("Giờ muốn đặt: ");
		lbGioDat.setBounds(381, 336, 102, 30);
		panelPhong.add(lbGioDat);
		lbGioDat.setFont(new Font("Tahoma", Font.PLAIN, 15));

		btnDatPhong = new JButton("Thêm vào đơn đặt phòng");
		btnDatPhong.setBounds(222, 390, 223, 30);
		panelPhong.add(btnDatPhong);
		btnDatPhong.setBackground(Color.ORANGE);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbGio = new JComboBox<Integer>();
		cbGio.setBounds(493, 338, 42, 30);
		for(int i=0;i<25;i++) {
			cbGio.addItem(i);
		}
		panelPhong.add(cbGio);

		JLabel lbphu = new JLabel(":");
		lbphu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbphu.setBounds(545, 336, 6, 30);
		panelPhong.add(lbphu);

		cbPhut = new JComboBox<Integer>();
		cbPhut.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbPhut.setBounds(556, 336, 42, 30);
		for(int i=0;i<60;i++) {
			cbPhut.addItem(i);
		}
		panelPhong.add(cbPhut);

		JLabel lbNgay = new JLabel("Ngày muốn đặt phòng:");
		lbNgay.setBounds(15, 336, 158, 30);
		panelPhong.add(lbNgay);
		lbNgay.setFont(new Font("Tahoma", Font.PLAIN, 15));

		ngayDat = new JDateChooser();
		ngayDat.setBounds(183, 336, 169, 30);
		panelPhong.add(ngayDat);
		ngayDat.setDateFormatString("dd/MM/yyyy");
		ngayDat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ngayDat.setPreferredSize(new Dimension(400, 400));
		ngayDat.getJCalendar().getMonthChooser().setPreferredSize(new Dimension(150, 30));

		JPanel panelDDP = new JPanel();
		panelDDP.setBorder(new TitledBorder(null, "Chi tiết đơn đặt phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDDP.setBounds(649, 10, 693, 531);
		panel.add(panelDDP);
		panelDDP.setLayout(null);

		String []headerCT= {"Mã phòng","Tên phòng","Ngày đặt","Giờ đặt"};
		dfCTPhong=new DefaultTableModel(headerCT,0);
		tablePhongCT=new JTable(dfCTPhong);
		tablePhongCT.setRowHeight(20);
		tablePhongCT.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhongCT.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollCT;
		panelDDP.setLayout(null);
		scrollCT=new JScrollPane(tablePhongCT,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollCT.setBounds(10, 126, 673, 334);
		scrollCT.setBackground(new Color(248,248,248));
		panelDDP.add(scrollCT);

		JLabel lbChiTiet = new JLabel("Đơn đặt phòng");
		lbChiTiet.setBounds(303, 28, 186, 30);
		lbChiTiet.setForeground(Color.BLUE);
		lbChiTiet.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelDDP.add(lbChiTiet);

		btnLuu = new JButton("Lưu đơn đặt phòng");
		btnLuu.setBackground(Color.ORANGE);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuu.setBounds(280, 477, 186, 30);
		panelDDP.add(btnLuu);

		JLabel lbTenKH = new JLabel("Tên khách hàng:");
		lbTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenKH.setBounds(21, 65, 136, 30);
		panelDDP.add(lbTenKH);

		lbTenKhachHang = new JLabel("");
		lbTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenKhachHang.setBounds(146, 65, 207, 30);
		panelDDP.add(lbTenKhachHang);
		
		JLabel lbDT = new JLabel("Số điện thoại:");
		lbDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDT.setBounds(392, 68, 113, 30);
		panelDDP.add(lbDT);
		
		lbSDT = new JLabel("");
		lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSDT.setBounds(515, 68, 142, 30);
		panelDDP.add(lbSDT);
		
		txtTimKH = new JTextField();
		txtTimKH.setForeground(Color.GRAY);
		txtTimKH.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtTimKH.setBounds(50, 37, 319, 30);
		panel.add(txtTimKH);
		txtTimKH.setText("Nhập số điện thoại hoặc số CMND của khách hàng");
		txtTimKH.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(420, 37, 147, 30);
		panel.add(btnTimKiem);
		
		btnDatPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLuu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		setTableAlternateRow();//tô màu  table

		//		Thêm sự kiện
		btnDatPhong.addActionListener(this);
		btnLuu.addActionListener(this);
		btnTimKiem.addActionListener(this);
		txtTimKH.addMouseListener(this);

		//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//Lấy tên khách hàng đã thêm mới nhất
		LayThongTinKH();

		//lấy giờ hiện tại cho cbbox giờ và phút
		cbGio.setSelectedItem(Calendar.getInstance().getTime().getHours());
		cbPhut.setSelectedItem(Calendar.getInstance().getTime().getMinutes());
		
		//		thêm dữ liệu vào table
		//		ThemDuLieuVaoTable();
		LoadTatCaPhong();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnTimKiem)) {
			if(KiemTraDuLieu()) {
				//clearTableDichVu();
				khachHang=daoKhachHang.getKhachHangBangSDTHoacCMND(txtTimKH.getText());
				if(khachHang==null) {
					JOptionPane.showMessageDialog(this, "Không tìm thấy thông tin khách hàng này");
					khachHang=daoKhachHang.getKhachHangTheoMa(ma.maKhachHangVuaThem());
					lbTenKhachHang.setText(khachHang.getTenKhachHang());
					lbSDT.setText(khachHang.getSoDienThoai());
				}
				else
					lbTenKhachHang.setText(khachHang.getTenKhachHang());
					lbSDT.setText(khachHang.getSoDienThoai());
			}
		}
		if(o.equals(btnDatPhong)) {
			int i = tablePhong.getSelectedRow();
			Date da = new Date(ngayDat.getDate().getTime());
			if(tablePhong.getSelectedRow()==-1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn phòng cần đặt");
			}
			
			else if(dfPhong.getValueAt(i, 4).toString().equals("Đang sử dụng")&&da.toString().equals(LocalDate.now().toString())) {
				JOptionPane.showMessageDialog(this, "Phòng này hiện tại đang được sử dụng");
			}
			else if(da.toString().equals("")) {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập ngày muốn đặt");
			}
			else {
				Date d = new Date(ngayDat.getDate().getTime());
				Phong p=daoPhong.getPhongTheoMa(dfPhong.getValueAt(i, 0).toString());
				dfCTPhong.addRow(new Object[] {
						p.getMaPhong(),p.getTenPhong(),simpleDateFormat.format(d),cbGio.getSelectedItem().toString()+":"+cbPhut.getSelectedItem().toString()
				});
			}

		}
		if(o.equals(btnLuu)) {
			themDonDatPhong();
			for(int i=0;i<tablePhongCT.getRowCount();i++)
				ThemVaoCTDDP(i);
			JOptionPane.showMessageDialog(this, "Lưu đơn đặt phòng thành công");
		}
	}

	private void themDonDatPhong() {

//		makh=ma.maKhachHangVuaThem();
//		KhachHang kh=daoKhachHang.getKhachHangTheoMa(makh);
		String manv=FormGiaoDienChinh.txtUsername.getText();
		NhanVien nv=new NhanVien(manv);

		maDon=ma.maDonDatPhong();
		Date date=new Date(ngayDat.getDate().getTime());
		DonDatPhong donDatPhong=new DonDatPhong(maDon, date, khachHang, nv);
		daoDonDatPhong.themDonDatPhong(donDatPhong);

	}

	private void ThemVaoCTDDP(int vt) {
		Phong p=daoPhong.getPhongTheoMa(dfCTPhong.getValueAt(vt, 0).toString());
		Time time= new Time((int)cbGio.getSelectedItem(), (int) cbPhut.getSelectedItem(), 0);
		ChiTietDDP chiTietDDP=new ChiTietDDP(maDon, time, p);

		daoChiTietDDP.themChiTietDDP(chiTietDDP);

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		Object o=e.getSource();
		if(o.equals(txtTimKH)) {
			txtTimKH.setText("");
			txtTimKH.setForeground(Color.BLACK);
			txtTimKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
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
	public void LayThongTinKH() {
		khachHang=daoKhachHang.getKhachHangTheoMa(ma.maKhachHangVuaThem());
		lbTenKhachHang.setText(""+khachHang.getTenKhachHang());
		lbSDT.setText(""+khachHang.getSoDienThoai());
	}
	
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
	public boolean KiemTraDuLieu() {
		Regex regex=new Regex();
		if(regex.kiemTraRong(txtTimKH))
			return false;
		if(regex.RegexSDT(txtTimKH))
			return false;
		return true;
	}
}