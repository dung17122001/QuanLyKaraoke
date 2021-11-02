package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.components.JTitlePanel;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormLapHD extends JPanel {
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private DefaultTableModel dfDichVu;
	private JTable tableDichVu;
	private JTextField txtSoLuongDV;

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
		
		String []header= {"STT","Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
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
		
		JButton btnThemPhong = new JButton("Thêm phòng vào hóa đơn");
		btnThemPhong.setBackground(Color.ORANGE);
		btnThemPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPhong.setBounds(176, 328, 222, 30);
		panelPhong.add(btnThemPhong);
		 
		
		JPanel panelChiTietHD = new JPanel();
		panelChiTietHD.setBounds(665, 50, 677, 406);
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
		scrollDichVu.setBounds(0, 10, 667, 386);
		panelChiTietHD.add(scrollDichVu);
		scrollDichVu.setBorder(BorderFactory.createTitledBorder("Thông tin hóa đơn"));
		scrollDichVu.setBackground(new Color(248,248,248));
		
		JPanel panelDichVu = new JPanel();
		panelDichVu.setBorder(new TitledBorder(null, "Thêm dịch vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelDichVu.setBounds(10, 388, 645, 151);
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
		btnThemDV.setBackground(Color.ORANGE);
		btnThemDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemDV.setBounds(375, 94, 241, 30);
		panelDichVu.add(btnThemDV);
		
		JLabel lbSoLuongDV = new JLabel("Số lượng:");
		lbSoLuongDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSoLuongDV.setBounds(375, 33, 87, 30);
		panelDichVu.add(lbSoLuongDV);
		
		txtSoLuongDV = new JTextField();
		txtSoLuongDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSoLuongDV.setBounds(448, 34, 186, 30);
		panelDichVu.add(txtSoLuongDV);
		txtSoLuongDV.setColumns(10);
		
		JLabel lbThongTinHD = new JLabel("Thông tin hóa đơn");
		lbThongTinHD.setForeground(Color.BLUE);
		lbThongTinHD.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbThongTinHD.setBounds(969, 10, 218, 30);
		panel.add(lbThongTinHD);
		
		JButton btnTinhGio = new JButton("Bắt đầu tính giờ");
		btnTinhGio.setBackground(Color.ORANGE);
		btnTinhGio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTinhGio.setBounds(936, 495, 186, 30);
		panel.add(btnTinhGio);
	}
}
