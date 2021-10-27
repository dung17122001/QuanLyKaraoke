package gui;

import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class FormThongKe extends JPanel {

	private Panel panel = new Panel();
	private JTextField textDoanhThu;
	private JTextField txtKhachHang;
	private JTextField txtDichVu;

	public Panel getFormThongKe() {
		return this.panel;
	}
	
	public FormThongKe() {
		setLayout(null);
		
		panel.setBounds(0, 20, 1355, 560);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelLoaiThongKe = new JPanel();
		panelLoaiThongKe.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), 
		new Color(160, 160, 160)), "Chọn doanh mục cần thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelLoaiThongKe.setBounds(10, 10, 645, 177);
		panel.add(panelLoaiThongKe);
		panelLoaiThongKe.setLayout(null);
		
		JLabel lbThongKe = new JLabel("Chọn thời gian cần thống kê:");
		lbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbThongKe.setBounds(10, 26, 208, 30);
		panelLoaiThongKe.add(lbThongKe);
		
		JComboBox<String> cbThongKe = new JComboBox<String>();
		cbThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbThongKe.setBounds(248, 26, 171, 30);
		cbThongKe.addItem("Hôm nay");
		cbThongKe.addItem("Tuần này");
		cbThongKe.addItem("Tháng này");
		cbThongKe.addItem("Năm nay");
		panelLoaiThongKe.add(cbThongKe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 66, 625, 101);
		panelLoaiThongKe.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnThongKeDoanhThu = new JButton("Thống kê doanh thu");
		btnThongKeDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKeDoanhThu.setBounds(32, 10, 199, 30);
		panel_1.add(btnThongKeDoanhThu);
		
		JButton btnThongKeKhachHang = new JButton("Thống kê khách hàng");
		btnThongKeKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKeKhachHang.setBounds(32, 63, 199, 30);
		panel_1.add(btnThongKeKhachHang);
		
		JButton btnThongKeNhanVien = new JButton("Thống kê nhân viên");
		btnThongKeNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKeNhanVien.setBounds(391, 10, 208, 30);
		panel_1.add(btnThongKeNhanVien);
		
		JButton btnInThongKe = new JButton("In bảng thống kê");
		btnInThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInThongKe.setBounds(391, 63, 208, 30);
		panel_1.add(btnInThongKe);
		
		JPanel panelThongTinThongKe = new JPanel();
		panelThongTinThongKe.setBorder(new TitledBorder(null, "Thông tin thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinThongKe.setBounds(665, 10, 680, 177);
		panel.add(panelThongTinThongKe);
		panelThongTinThongKe.setLayout(null);
		
		JLabel lbDoanhThu = new JLabel("Doanh Thu:");
		lbDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDoanhThu.setBounds(10, 23, 175, 30);
		panelThongTinThongKe.add(lbDoanhThu);
		
		textDoanhThu = new JTextField();
		textDoanhThu.setBackground(Color.WHITE);
		textDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textDoanhThu.setBounds(218, 24, 175, 30);
		panelThongTinThongKe.add(textDoanhThu);
		textDoanhThu.setColumns(10);
		
		JLabel lbKhachHang = new JLabel("Tổng số khách hàng:");
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbKhachHang.setBounds(10, 81, 175, 30);
		panelThongTinThongKe.add(lbKhachHang);
		
		txtKhachHang = new JTextField();
		txtKhachHang.setBackground(Color.WHITE);
		txtKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtKhachHang.setBounds(218, 81, 175, 30);
		panelThongTinThongKe.add(txtKhachHang);
		txtKhachHang.setColumns(10);
		
		JLabel lbDichVu = new JLabel("Tổng số dịch vụ đã bán:");
		lbDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDichVu.setBounds(10, 133, 175, 30);
		panelThongTinThongKe.add(lbDichVu);
		
		txtDichVu = new JTextField();
		txtDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDichVu.setBounds(218, 134, 175, 30);
		panelThongTinThongKe.add(txtDichVu);
		txtDichVu.setColumns(10);
		
	}
}
