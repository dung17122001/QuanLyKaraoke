package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.DaoDonDatPhong;
import dao.DaoKhachHang;
import dao.DaoPhong;
import entity.KhachHang;
import entity.Phong;

public class FormNhanPhong extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField txtTimKiem;
	public static DefaultTableModel tableModel;
	private JTable table;
	private DaoDonDatPhong daoDonDatPhong=new DaoDonDatPhong();
	private DaoPhong daoPhong=new DaoPhong();
	private JButton btnNhanPhong,btnTimKiem;
	private DaoKhachHang daoKhachHang=new DaoKhachHang();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormNhanPhong frame = new FormNhanPhong();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FormNhanPhong() {
		setTitle("Đơn đặt phòng");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 928, 613);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "T\u00ECm nhanh th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 10, 894, 68);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lbTT = new JLabel("Nhập thông tin khách hàng cần tìm:");
		lbTT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTT.setBounds(10, 17, 265, 30);
		panel.add(lbTT);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKiem.setBounds(280, 18, 319, 30);
		panel.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(681, 17, 114, 30);
		panel.add(btnTimKiem);
		
		JLabel lblTitle = new JLabel("Danh sách đơn đặt phòng:");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitle.setBounds(321, 88, 265, 30);
		contentPane.add(lblTitle);
		
		JPanel panelTable = new JPanel();
		panelTable.setBounds(10, 128, 894, 376);
		contentPane.add(panelTable);
		panelTable.setLayout(null);
		
		btnNhanPhong = new JButton("Nhận phòng");
		btnNhanPhong.setBackground(Color.ORANGE);
		btnNhanPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNhanPhong.setBounds(367, 525, 179, 30);
		contentPane.add(btnNhanPhong);
		
		String []headerDV= {"STT","Tên khách hàng","Số điện thoại","Tên phòng","Ngày đặt","Thời gian đặt"};
		tableModel=new DefaultTableModel(headerDV,0);
		JScrollPane scroll;
		table=new JTable(tableModel);
		table.setRowHeight(20);
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.getTableHeader().setBackground(new Color(255, 204, 102));
		scroll=new JScrollPane(table,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scroll.setBounds(0, 10, 884, 356);
		panelTable.add(scroll);
		scroll.setBackground(new Color(248,248,248));
		setLocationRelativeTo(null);
		
		btnNhanPhong.addActionListener(this);
		btnTimKiem.addActionListener(this);
		
		setTableAlternateRow();
		
//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		daoDonDatPhong.getTatCaDonDatPhong();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		Object [] row = null;
		int i=table.getSelectedRow();
		int index=1;
		if(o.equals(btnNhanPhong)){
			if(i==-1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn đơn đặt phòng cần nhận phòng");
			}
			else {
				FormLapHD.clearTableDichVu();
				ArrayList<Phong> ds=daoPhong.getPhongTuDonDatPhong(tableModel.getValueAt(i,2 ).toString());
				for(Phong p:ds) {
					row = new Object [] {index++,p.getMaPhong(),p.getTenPhong(),p.getGiaPhong(),0,0}; 
					FormLapHD.dfDichVu.addRow(row);
				}
				FormLapHD.stt=index;
				FormLapHD.khachHang=daoKhachHang.getKhachHangBangSDTHoacCMND(tableModel.getValueAt(i, 2).toString());
				FormLapHD.loadThongTinKH();
				JOptionPane.showMessageDialog(this, "Đã nhận phòng");
			}
		}
		
		if(o.equals(btnTimKiem)) {
			clearTablePhong();
			daoDonDatPhong.getDonDatPhongTheoSDTorCMND(txtTimKiem.getText());
			if(table.getRowCount()==0)
				JOptionPane.showMessageDialog(this, "Không có thông tin nào được tìm thấy");
		}
		
	}
	private void clearTablePhong() {
		while (table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
}
