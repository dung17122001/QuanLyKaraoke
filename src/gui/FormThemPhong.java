package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableModel;

public class FormThemPhong extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhong;
	private JTextField textField;
	private JTextField txtGiaPhong;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	
	public FormThemPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThemPhong = new JPanel();
		panelThemPhong.setBorder(new TitledBorder(null, "Nhập thông tin phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThemPhong.setBounds(10, 10, 1332, 159);
		panel.add(panelThemPhong);
		panelThemPhong.setLayout(null);
		
		JLabel lbMaPhong = new JLabel("Mã phòng: ");
		lbMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaPhong.setBounds(43, 28, 121, 30);
		panelThemPhong.add(lbMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhong.setBounds(203, 29, 344, 30);
		panelThemPhong.add(txtMaPhong);
		txtMaPhong.setColumns(10);
		
		JLabel lbTenPhong = new JLabel("Tên phòng: ");
		lbTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenPhong.setBounds(32, 104, 121, 30);
		panelThemPhong.add(lbTenPhong);
		
		textField = new JTextField();
		textField.setBounds(203, 107, 344, 30);
		panelThemPhong.add(textField);
		textField.setColumns(10);
		
		JLabel lbGiaPhong = new JLabel("Giá phòng: ");
		lbGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiaPhong.setBounds(687, 104, 121, 30);
		panelThemPhong.add(lbGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaPhong.setBounds(860, 105, 379, 30);
		panelThemPhong.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JLabel lbLoaiPhong = new JLabel("Loại phòng: ");
		lbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLoaiPhong.setBounds(687, 28, 121, 30);
		panelThemPhong.add(lbLoaiPhong);
		
		JComboBox cbLoaiPhong = new JComboBox();
		cbLoaiPhong.setBounds(860, 30, 379, 30);
		panelThemPhong.add(cbLoaiPhong);
		
		JButton btnThemPhong = new JButton("Thêm phòng");
		btnThemPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPhong.setBounds(600, 179, 164, 30);
		panel.add(btnThemPhong);
		
		JButton btnXoaTrang = new JButton("Xóa trắng");
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(345, 179, 122, 30);
		panel.add(btnXoaTrang);
		
		JButton btnLuuPhong = new JButton("Lưu phòng");
		btnLuuPhong.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLuuPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuuPhong.setBounds(886, 179, 153, 30);
		panel.add(btnLuuPhong);
		
		JPanel panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBounds(10, 219, 1332, 336);
		panel.add(panelThongTinPhong);
		panelThongTinPhong.setLayout(null);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tablePhong.setRowHeight(30);
//		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
//		tablePhong.getTableHeader().setBackground(new Color(0,234,22,232));
		JScrollPane scrollPhong;
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(0, 0, 1325, 326);
		scrollPhong.setBackground(new Color(248,248,248));
		panelThongTinPhong.add(scrollPhong);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
