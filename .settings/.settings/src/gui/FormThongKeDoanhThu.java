package gui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormThongKeDoanhThu extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtPhong;
	private JTextField txtDichVu;
	private JTextField txtDoanhThu;
	private DefaultTableModel dfHangHoa;
	private JTable tableHangHoa;

	public FormThongKeDoanhThu() {
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
		btnThongKe.setBackground(Color.ORANGE);
		btnThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThongKe.setBounds(103, 107, 164, 30);
		panel_1.add(btnThongKe);
		
		JButton btnInThongKe = new JButton("In thống kê");
		btnInThongKe.setBackground(Color.ORANGE);
		btnInThongKe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInThongKe.setBounds(338, 107, 164, 30);
		panel_1.add(btnInThongKe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Thông tin thống kê", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(644, 10, 698, 166);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lbPhong = new JLabel("Tổng tiền của các phòng: ");
		lbPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbPhong.setBounds(95, 26, 193, 30);
		panel_2.add(lbPhong);
		
		JLabel lbDichVu = new JLabel("Tổng tiền của dịch vụ đã bán: ");
		lbDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDichVu.setBounds(95, 76, 209, 30);
		panel_2.add(lbDichVu);
		
		JLabel lbDoanhThu = new JLabel("Tổng doanh thu: ");
		lbDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDoanhThu.setBounds(95, 126, 166, 30);
		panel_2.add(lbDoanhThu);
		
		txtPhong = new JTextField();
		txtPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtPhong.setBounds(335, 26, 294, 30);
		panel_2.add(txtPhong);
		txtPhong.setColumns(10);
		
		txtDichVu = new JTextField();
		txtDichVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDichVu.setBounds(335, 77, 294, 30);
		panel_2.add(txtDichVu);
		txtDichVu.setColumns(10);
		
		txtDoanhThu = new JTextField();
		txtDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDoanhThu.setBounds(336, 127, 293, 30);
		panel_2.add(txtDoanhThu);
		txtDoanhThu.setColumns(10);
		
		JPanel panelThongKe = new JPanel();
		panelThongKe.setBounds(10, 176, 1332, 379);
		panel.add(panelThongKe);
		
		
		
		String []header= {"STT","Mã hàng hóa","Tên hàng hóa","Giá tiền","Số lượng","Thành tiền"};
		dfHangHoa=new DefaultTableModel(header,0);
		tableHangHoa=new JTable(dfHangHoa);
		tableHangHoa.setRowHeight(20);
		tableHangHoa.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tableHangHoa.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollHangHoa;
		panelThongKe.setLayout(null);
		scrollHangHoa=new JScrollPane(tableHangHoa,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollHangHoa.setBorder(BorderFactory.createTitledBorder("Thông tin các hành hóa đã bán"));
		scrollHangHoa.setBounds(0, 0, 1332, 369);
		scrollHangHoa.setBackground(new Color(248,248,248));
		panelThongKe.add(scrollHangHoa);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
