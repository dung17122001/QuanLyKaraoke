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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;

public class FormThongKeKhachHang extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtKhachHang;
	public static DefaultTableModel dfKhachHang;
	private JTable tableKhachHang;
	private JButton btnThongKe,btnInThongKe;
	private JComboBox<String> cbThoiGian ;
	private DaoHoaDon daoHoaDon=new DaoHoaDon();
	public static int sokh;
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
	FormInThongKeKH formKH=new FormInThongKeKH();
	private DaoNhanVien daoNhanVien=new DaoNhanVien();

	public FormThongKeKhachHang() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);

		JPanel panel=new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chọn thời gian cần thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 44, 663, 166);
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
		panel_2.setBounds(679, 44, 663, 166);
		panel.add(panel_2);
		panel_2.setLayout(null);

		JLabel lbKhachHang = new JLabel("Tổng số khách hàng ");
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbKhachHang.setBounds(49, 71, 193, 30);
		panel_2.add(lbKhachHang);

		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtKhachHang.setBounds(281, 72, 294, 30);
		panel_2.add(txtKhachHang);
		txtKhachHang.setColumns(10);

		JPanel panelThongKe = new JPanel();
		panelThongKe.setBounds(10, 220, 1332, 335);
		panel.add(panelThongKe);

		String []header= {"STT","Mã khách hàng","Tên khách hàng","Số điện thoại","Địa chỉ","Số giờ đến quán","Tổng tiền hóa đơn"};
		dfKhachHang=new DefaultTableModel(header,0);
		tableKhachHang=new JTable(dfKhachHang);
		tableKhachHang.setRowHeight(20);
		tableKhachHang.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableKhachHang.getTableHeader().setBackground(new Color(255, 204, 102));
		tableKhachHang.getColumnModel().getColumn(4).setPreferredWidth(300);
		JScrollPane scrollKhachHang;
		panelThongKe.setLayout(null);
		scrollKhachHang=new JScrollPane(tableKhachHang,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollKhachHang.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		scrollKhachHang.setBounds(0, 10, 1332, 315);
		scrollKhachHang.setBackground(new Color(248,248,248));
		panelThongKe.add(scrollKhachHang);
		
		btnInThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThongKe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JLabel lblTitle = new JLabel("THỐNG KÊ KHÁCH HÀNG");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(561, 10, 251, 30);
		panel.add(lblTitle);
		
		setTableAlternateRow();

		//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//		thêm sự kiện
		btnThongKe.addActionListener(this);
		btnInThongKe.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(btnThongKe)) {
			if(cbThoiGian.getSelectedItem().equals("Hôm nay")) {
				clearTable();
				daoHoaDon.ThongKeKhachHangTheoNgay();
				txtKhachHang.setText(""+sokh);
			}
			if(cbThoiGian.getSelectedItem().equals("Tuần này")) {
				clearTable();
				daoHoaDon.ThongKeKhachHangTheoTuan();
				txtKhachHang.setText(""+sokh);
			}
			if(cbThoiGian.getSelectedItem().equals("Tháng này")) {
				clearTable();
				daoHoaDon.ThongKeKhachHangTheoThang();
				txtKhachHang.setText(""+sokh);
			}
			if(cbThoiGian.getSelectedItem().equals("Cả năm")) {
				clearTable();
				daoHoaDon.ThongKeKhachHangTheoNam();
				txtKhachHang.setText(""+sokh);
			}
		}
		if(o.equals(btnInThongKe)) {
			setDuLieuFrmInThongKe();
			this.formKH.setVisible(true);
			formKH.setLocationRelativeTo(null);
			formKH.printInThongKe();
		}

	}
	private void clearTable() {
		while (tableKhachHang.getRowCount() > 0) {
			dfKhachHang.removeRow(0);
		}
	}
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
	
	public void setDuLieuFrmInThongKe() {
		FormInThongKeKH.clearTable();
		int i=tableKhachHang.getSelectedRow();
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.add(Calendar.DATE, -7);
        if(c1.getTime().getDate()<8)
            c1.roll(Calendar.MONTH, -1);
        
        if(cbThoiGian.getSelectedItem().equals("Hôm nay")) {
			FormInThongKeKH.lblThoiGian.setText(dateFormat.format(c2.getTime()));
			daoHoaDon.InThongKeKhachHangTheoNgay();
		}
		if(cbThoiGian.getSelectedItem().equals("Tuần này")) {
			FormInThongKeKH.lblThoiGian.setText(dateFormat.format(c1.getTime())+" - "+dateFormat.format(c2.getTime()));
			daoHoaDon.InThongKeKhachHangTheoTuan();
		}
		if(cbThoiGian.getSelectedItem().equals("Tháng này")) {
			FormInThongKeKH.lblThoiGian.setText(c2.getTime().getMonth()+"-"+LocalDate.now().getYear());
			daoHoaDon.InThongKeKhachHangTheoThang();
		}
		if(cbThoiGian.getSelectedItem().equals("Cả năm")) {
			FormInThongKeKH.lblThoiGian.setText("Cả năm "+LocalDate.now().getYear());
			daoHoaDon.InThongKeKhachHangTheoNam();
		}
		try {
			NhanVien nv=daoNhanVien.getNhanvienByMaNhanVien("NV001");
			FormInThongKeKH.lblTenNV.setText(""+nv.getTenNhanVien());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}