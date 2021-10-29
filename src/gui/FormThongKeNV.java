package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThongKeNV extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtPhong;
	private DefaultTableModel dfNhanVien;
	private JTable tableNhanVien;
	private JTextField txtTongTien;

	public FormThongKeNV() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Chọn thời gian cần thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 624, 166);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbThoiGian = new JLabel("Thời gian cần thống kê:");
		lbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbThoiGian.setBounds(28, 17, 198, 30);
		panel_1.add(lbThoiGian);
		
		JComboBox<String> cbThoiGian = new JComboBox<String>();
		cbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbThoiGian.setBounds(236, 17, 314, 30);
		cbThoiGian.addItem("Hôm nay");
		cbThoiGian.addItem("Tuần này");
		cbThoiGian.addItem("Tháng này");
		cbThoiGian.addItem("Cả năm");
		panel_1.add(cbThoiGian);
		
		JButton btnThongKe = new JButton("Xem thống kê");
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKe.setBounds(103, 107, 164, 30);
		panel_1.add(btnThongKe);
		
		JButton btnInThongKe = new JButton("In thống kê");
		btnInThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInThongKe.setBounds(338, 107, 164, 30);
		panel_1.add(btnInThongKe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Thông tin thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(644, 10, 698, 166);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbNhanVien = new JLabel("Tổng số hóa đơn đã lập: ");
		lbNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNhanVien.setBounds(42, 32, 193, 30);
		panel_2.add(lbNhanVien);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhong.setBounds(287, 33, 294, 30);
		panel_2.add(txtPhong);
		txtPhong.setColumns(10);
		
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
		panelThongKe.setBounds(10, 176, 1332, 379);
		panel.add(panelThongKe);
		
		String []header= {"STT","Mã nhân viên","Tên nhân viên","Số hóa đơn đã lập","Ngày lập","Tổng tiền hóa đơn"};
		dfNhanVien=new DefaultTableModel(header,0);
		tableNhanVien=new JTable(dfNhanVien);
		tableNhanVien.setRowHeight(20);
		JScrollPane scrollNhanVien;
		panelThongKe.setLayout(null);
		scrollNhanVien=new JScrollPane(tableNhanVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollNhanVien.setBorder(BorderFactory.createTitledBorder("Thông tin khách hàng"));
		scrollNhanVien.setBounds(0, 0, 1332, 369);
		scrollNhanVien.setBackground(new Color(248,248,248));
		panelThongKe.add(scrollNhanVien);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
