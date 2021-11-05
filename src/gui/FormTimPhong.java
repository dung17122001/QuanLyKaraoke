package gui;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import dao.DAO_Phong;
import dao.DaoLoaiPhong;
import entity.LoaiPhong;
import entity.Phong;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

public class FormTimPhong extends JPanel implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JTextField txtTimKiem;
	private JComboBox<String> cbLoaiPhong;
	private JComboBox<String> cbTrinhTrang;
	private JButton btnTimKiem;
	private JButton btnReset;
	private DAO_Phong daoPhong=new DAO_Phong();
	private DaoLoaiPhong daoLoaiPhong=new DaoLoaiPhong();
	private DecimalFormat df = new DecimalFormat("#,### VNĐ");

	public FormTimPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThongTinPhong = new JPanel();
		panelThongTinPhong.setBounds(10, 244, 1332, 311);
		panel.add(panelThongTinPhong);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		panelThongTinPhong.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(10, 5, 1312, 296);
		scrollPhong.setBackground(new Color(248,248,248));
		panelThongTinPhong.add(scrollPhong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Nhập thông tin phòng cần tìm", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 10, 1332, 224);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbTimKiem = new JLabel("Nhập thông tin phòng cần tìm:");
		lbTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTimKiem.setBounds(458, 131, 224, 30);
		panel_1.add(lbTimKiem);
		
		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(721, 134, 284, 30);
		panel_1.add(txtTimKiem);
		txtTimKiem.setColumns(10);
		
		JLabel lbHinhThuc = new JLabel("Tìm theo loại phòng: ");
		lbHinhThuc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbHinhThuc.setBounds(458, 20, 224, 30);
		panel_1.add(lbHinhThuc);
		
		cbLoaiPhong = new JComboBox<String>();
		cbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiPhong.setBounds(721, 20, 284, 30);
		panel_1.add(cbLoaiPhong);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.ORANGE);
		btnTimKiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnTimKiem.setBounds(513, 174, 187, 35);
		panel_1.add(btnTimKiem);
		
		JLabel lbTrinhTrang = new JLabel("Tìm theo trình trạng phòng: ");
		lbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTrinhTrang.setBounds(458, 76, 224, 30);
		panel_1.add(lbTrinhTrang);
		
		cbTrinhTrang = new JComboBox<String>();
		cbTrinhTrang.addItem("Trống");
		cbTrinhTrang.addItem("Đang sử dụng");
		cbTrinhTrang.setBounds(721, 78, 284, 30);
		panel_1.add(cbTrinhTrang);
		
		btnReset = new JButton("Tải lại");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(768, 174, 187, 35);
		panel_1.add(btnReset);
		
		btnTimKiem.addActionListener(this);
		btnReset.addActionListener(this);
		cbLoaiPhong.addActionListener(this);
		cbTrinhTrang.addActionListener(this);
		
//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		thêm dữ liệu vào table
//		ThemDuLieuVaoTable();
		
//		Thêm dữ liệu vào combobox loại phòng
		ThemDuLieuVaoCBLoaiPhong();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o.equals(cbLoaiPhong)) {
			clearTable();
			LoadTatCaPhongTheoDieuKien();
//			try {
//				daoPhong.getDuLieuPhong("SELECT Phong.maPhong, Phong.tenPhong, LoaiPhong.tenLoai, Phong.giaPhong, Phong.trinhTrang FROM Phong INNER JOIN LoaiPhong ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong"
//				+ " where LoaiPhong.tenLoai like N'" + cbLoaiPhong.getSelectedItem() + "' and Phong.trinhTrang like N'"+cbTrinhTrang.getSelectedItem()+"' ", dfPhong);
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		if(o.equals(cbTrinhTrang)) {
		clearTable();
		LoadTatCaPhongTheoDieuKien();
//			try {
//				daoPhong.getDuLieuPhong("SELECT Phong.maPhong, Phong.tenPhong, LoaiPhong.tenLoai, Phong.giaPhong, Phong.trinhTrang FROM Phong INNER JOIN LoaiPhong"
//				+ " ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong where Phong.trinhTrang like N'"+cbTrinhTrang.getSelectedItem()+"' and LoaiPhong.tenLoai like N'" + cbLoaiPhong.getSelectedItem() + "'", dfPhong);
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
		}
		if(o.equals(btnTimKiem)) {
			if(txtTimKiem.getText().equals(""))
				JOptionPane.showMessageDialog(this, "Vui lòng nhập dữ liệu cần tìm");
			else {
				clearTable();
				HienThiPhongTheoThongTinTimKiem();
//					daoPhong.getDuLieuPhong("SELECT Phong.maPhong, Phong.tenPhong, LoaiPhong.tenLoai, Phong.giaPhong, Phong.trinhTrang FROM Phong INNER JOIN LoaiPhong"
//					+ " ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong where (Phong.trinhTrang like N'"+cbTrinhTrang.getSelectedItem().toString()+"' and LoaiPhong.tenLoai like N'" + cbLoaiPhong.getSelectedItem().toString() + "') "
//					+ "and (Phong.maPhong=N'"+ txtTimKiem.getText() +"' or Phong.tenPhong=N'"+ txtTimKiem.getText() +"')"+ "", dfPhong);
				int i=dfPhong.getRowCount();
				if(i==0)
					JOptionPane.showMessageDialog(this, "Không có phòng nào khớp với thông tin tìm kiếm");
			}
			
		}
		if(o.equals(btnReset)) {
			clearTable();
		}
		
	}
	
	public void ThemDuLieuVaoCBLoaiPhong() {
		ArrayList<LoaiPhong> dslp=new ArrayList<LoaiPhong>();
		dslp=daoLoaiPhong.getTatCaLoaiPhong();
		for(LoaiPhong lp: dslp) {
			cbLoaiPhong.addItem(lp.getTenLoai());
		}
	}
	
	
	private void clearTable() {
		while (tablePhong.getRowCount() > 0) {
			dfPhong.removeRow(0);
		}
	}
	//Tim phong theo 2 combobox
	public void LoadTatCaPhongTheoDieuKien() {
		ArrayList<Phong> dsp=new ArrayList<Phong>();
		dsp=daoPhong.getTatCaPhongTheoDieuKien(cbLoaiPhong.getSelectedItem().toString(),cbTrinhTrang.getSelectedItem().toString());
		for(Phong p:dsp) {
			LoaiPhong lp=new LoaiPhong();
			lp=daoLoaiPhong.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			dfPhong.addRow(new Object[] {
					p.getMaPhong(),p.getTenPhong(),lp.getTenLoai(),df.format(p.getGiaPhong()),p.getTinhTrang()
			});
		}
	}
	
	//tim phong theo textbox va combobox
	public void HienThiPhongTheoThongTinTimKiem() {
		ArrayList<Phong> dsp=new ArrayList<Phong>();
		dsp=daoPhong.getPhongTheoThongTinTimKiem(cbTrinhTrang.getSelectedItem().toString(),cbLoaiPhong.getSelectedItem().toString(),txtTimKiem.getText());
		for(Phong p:dsp) {
			LoaiPhong lp=new LoaiPhong();
			lp=daoLoaiPhong.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			dfPhong.addRow(new Object[] {
					p.getMaPhong(),p.getTenPhong(),lp.getTenLoai(),df.format(p.getGiaPhong()),p.getTinhTrang()
			});
		}
	}
}
