package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.DaoHoaDon;
import dao.DaoNhanVien;
import entity.NhanVien;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class FormThongKeNV extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	public static JTextField txtSoLuong;
	public static DefaultTableModel dfNhanVien;
	public static int shd=0;
	private JTable tableNhanVien;
	public static JTextField txtTongTien;
	private JButton btnInThongKe,btnThongKe;
	private JComboBox<String> cbThoiGian;
	private DaoHoaDon daoHoaDon=new DaoHoaDon();
	public static double tongTien=0.0;
	DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	FormInThongKeNV formNV=new FormInThongKeNV();
	private DaoNhanVien daoNhanVien=new DaoNhanVien();

	public FormThongKeNV() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chọn thời gian cần thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 40, 663, 166);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbThoiGian = new JLabel("Thời gian cần thống kê:");
		lbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbThoiGian.setBounds(28, 17, 198, 30);
		panel_1.add(lbThoiGian);
		
		cbThoiGian = new JComboBox<String>();
		cbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbThoiGian.setBounds(236, 17, 314, 30);
		cbThoiGian.addItem("Hôm nay");
		cbThoiGian.addItem("Tuần này");
		cbThoiGian.addItem("Tháng này");
		cbThoiGian.addItem("Cả năm");
		panel_1.add(cbThoiGian);
		
		btnThongKe = new JButton("Xem thống kê");
		btnThongKe.setBackground(Color.ORANGE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKe.setBounds(103, 107, 164, 30);
		panel_1.add(btnThongKe);
		
		btnInThongKe = new JButton("In thống kê");
		btnInThongKe.setBackground(Color.ORANGE);
		btnInThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInThongKe.setBounds(338, 107, 164, 30);
		panel_1.add(btnInThongKe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Thông tin thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(679, 40, 663, 166);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbNhanVien = new JLabel("Tổng số hóa đơn đã lập: ");
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNhanVien.setBounds(42, 32, 193, 30);
		panel_2.add(lbNhanVien);
		
		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuong.setBounds(287, 33, 294, 30);
		panel_2.add(txtSoLuong);
		txtSoLuong.setColumns(10);
		
		JLabel lbTongTien = new JLabel("Tổng tiền bán được: ");
		lbTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTongTien.setBounds(42, 100, 193, 30);
		panel_2.add(lbTongTien);
		
		txtTongTien = new JTextField();
		txtTongTien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTongTien.setBounds(287, 101, 294, 30);
		panel_2.add(txtTongTien);
		txtTongTien.setColumns(10);
		
		JPanel panelThongKe = new JPanel();
		panelThongKe.setBounds(10, 216, 1332, 339);
		panel.add(panelThongKe);
		
		String []header= {"STT","Mã nhân viên","Tên nhân viên","Số điện thoại","Số hóa đơn đã lập","Tổng tiền hóa đơn"};
		dfNhanVien=new DefaultTableModel(header,0);
		tableNhanVien=new JTable(dfNhanVien);
		tableNhanVien.setRowHeight(20);
		tableNhanVien.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableNhanVien.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollNhanVien;
		panelThongKe.setLayout(null);
		scrollNhanVien=new JScrollPane(tableNhanVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollNhanVien.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		scrollNhanVien.setBounds(0, 0, 1332, 329);
		scrollNhanVien.setBackground(new Color(248,248,248));
		panelThongKe.add(scrollNhanVien);
		
		setTableAlternateRow();
		
		btnInThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblTitle = new JLabel("THỐNG KÊ NHÂN VIÊN");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(568, 10, 231, 30);
		panel.add(lblTitle);
		
//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		btnInThongKe.addActionListener(this);
		btnThongKe.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThongKe)) {
			if(cbThoiGian.getSelectedItem().equals("Hôm nay")) {
				tongTien=0.0;
				shd=0;
				clearTable();
				daoHoaDon.ThongKeNhanVienTheoNgay();
				txtSoLuong.setText(""+shd);
				txtTongTien.setText(tien.format(tongTien));
			}
			if(cbThoiGian.getSelectedItem().equals("Tuần này")) {
				tongTien=0.0;
				shd=0;
				clearTable();
				daoHoaDon.ThongKeNhanVienTheoTuan();
				txtSoLuong.setText(""+shd);
				txtTongTien.setText(tien.format(tongTien));
			}
			if(cbThoiGian.getSelectedItem().equals("Tháng này")) {
				tongTien=0.0;
				shd=0;
				clearTable();
				daoHoaDon.ThongKeNhanVienTheoThang();
				txtSoLuong.setText(""+shd);
				txtTongTien.setText(tien.format(tongTien));
			}
			if(cbThoiGian.getSelectedItem().equals("Cả năm")) {
				tongTien=0.0;
				shd=0;
				clearTable();
				daoHoaDon.ThongKeNhanVienTheoNam();
				txtSoLuong.setText(""+shd);
				txtTongTien.setText(tien.format(tongTien));
			}
		}
		if(o.equals(btnInThongKe)) {
			setDuLieuFrmInThongKe();
			this.formNV.setVisible(true);
			formNV.setLocationRelativeTo(null);
			formNV.printInThongKe();
		}
		
	}
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
	private void clearTable() {
		while (tableNhanVien.getRowCount() > 0) {
			dfNhanVien.removeRow(0);
		}
	}
	public void setDuLieuFrmInThongKe() {
		FormInThongKeNV.clearTable();
		int i=tableNhanVien.getSelectedRow();
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.add(Calendar.DATE, -7);
        if(c1.getTime().getDate()<8)
            c1.roll(Calendar.MONTH, -1);
        
        if(cbThoiGian.getSelectedItem().equals("Hôm nay")) {
			FormInThongKeNV.lblThoiGian.setText(dateFormat.format(c2.getTime()));
			daoHoaDon.InThongKeNhanVienTheoNgay();
		}
		if(cbThoiGian.getSelectedItem().equals("Tuần này")) {
			FormInThongKeNV.lblThoiGian.setText(dateFormat.format(c1.getTime())+" - "+dateFormat.format(c2.getTime()));
			daoHoaDon.InThongKeNhanVienTheoTuan();
		}
		if(cbThoiGian.getSelectedItem().equals("Tháng này")) {
			FormInThongKeNV.lblThoiGian.setText(c2.getTime().getMonth()+"-"+LocalDate.now().getYear());
			daoHoaDon.InThongKeNhanVienTheoThang();
		}
		if(cbThoiGian.getSelectedItem().equals("Cả năm")) {
			FormInThongKeNV.lblThoiGian.setText("Cả năm "+LocalDate.now().getYear());
			daoHoaDon.InThongKeNhanVienTheoNam();
		}
		try {
			NhanVien nv=daoNhanVien.getNhanvienByMaNhanVien("NV001");
			FormInThongKeNV.lblTenNV.setText(""+nv.getTenNhanVien());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
