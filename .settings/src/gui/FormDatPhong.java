package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.border.EtchedBorder;

public class FormDatPhong extends JPanel {
	private JTextField txtTenKH;
	private JTextField txtDiaChi;
	private JTextField txtCMND;
	private JTextField txtSDT;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private DefaultTableModel dfDichVu;

	public FormDatPhong() {
		
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nh\u1EADp th\u00F4ng tin", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		panel_1.setBounds(10, 10, 1332, 180);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbKhachHang = new JLabel("Tên khách hàng: ");
		lbKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbKhachHang.setBounds(23, 21, 125, 30);
		panel_1.add(lbKhachHang);
		
		txtTenKH = new JTextField();
		txtTenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKH.setBounds(202, 22, 370, 30);
		panel_1.add(txtTenKH);
		txtTenKH.setColumns(10);
		
		JLabel lbDiaChi = new JLabel("Địa chỉ: ");
		lbDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDiaChi.setBounds(23, 71, 125, 30);
		panel_1.add(lbDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setBounds(202, 72, 370, 30);
		panel_1.add(txtDiaChi);
		txtDiaChi.setColumns(10);
		
		JLabel lbCMND = new JLabel("Số CMND/CCCD: ");
		lbCMND.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCMND.setBounds(667, 22, 156, 30);
		panel_1.add(lbCMND);
		
		txtCMND = new JTextField();
		txtCMND.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCMND.setBounds(833, 22, 447, 30);
		panel_1.add(txtCMND);
		txtCMND.setColumns(10);
		
		JLabel lbSDT = new JLabel("Số điện thoại:");
		lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSDT.setBounds(667, 71, 125, 30);
		panel_1.add(lbSDT);
		
		txtSDT = new JTextField();
		txtSDT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSDT.setBounds(833, 72, 447, 30);
		panel_1.add(txtSDT);
		txtSDT.setColumns(10);
		
		JLabel lbThoiGian = new JLabel("Thời gian đặt: ");
		lbThoiGian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbThoiGian.setBounds(23, 123, 125, 30);
		panel_1.add(lbThoiGian);
		
		JLabel lbGioVao = new JLabel("Giờ đặt:");
		lbGioVao.setBounds(305, 128, 82, 20);
		panel_1.add(lbGioVao);
		lbGioVao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lbPhong = new JLabel("Phòng: ");
		lbPhong.setBounds(567, 123, 69, 30);
		panel_1.add(lbPhong);
		lbPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelPhong = new JPanel();
		panelPhong.setBorder(new TitledBorder(null, "Lựa chọn phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelPhong.setBounds(10, 200, 1332, 294);
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
		scrollPhong.setBounds(10, 20, 1312, 264);
		scrollPhong.setBackground(new Color(248,248,248));
		panelPhong.add(scrollPhong);
		
		JButton btnDatPhong = new JButton("Thêm đơn đặt phòng");
		btnDatPhong.setBackground(Color.ORANGE);
		btnDatPhong.setBounds(511, 504, 243, 40);
		panel.add(btnDatPhong);
		btnDatPhong.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
	}
}
