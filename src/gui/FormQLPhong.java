package gui;

import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import chucnang.Regex;
import connect.ConnectDB;
import dao.DaoPhong;
import dao.PhatSinhMa;
import dao.DaoLoaiPhong;
import entity.LoaiPhong;
import entity.Phong;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;

public class FormQLPhong extends JPanel implements ActionListener, MouseListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField txtMaPhong;
	private JTextField txtGiaPhong;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JTextField txtTenPhong;
	private DaoPhong daoPhong=new DaoPhong();
	private DaoLoaiPhong daoLoaiPhong=new DaoLoaiPhong();
	private JComboBox<String> cbLoaiPhong;
	private JComboBox<String> cbTrinhTrang;
	private JButton btnThemPhong;
	private JButton btnXoaPhong;
	private JButton btnSuaPhong;
	private JButton btnReset;
	private DecimalFormat df = new DecimalFormat("#,### VNĐ");
	private PhatSinhMa phatSinhMa=new PhatSinhMa(); 
	
	public FormQLPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelThongTinPhong =  new JPanel();
		panelThongTinPhong.setBorder(new TitledBorder(null, "Thông tin phòng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelThongTinPhong.setBounds(10, 10, 809, 183);
		panel.add(panelThongTinPhong);
		panelThongTinPhong.setLayout(null);
		
		JLabel lbMaPhong = new JLabel("Mã phòng: ");
		lbMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMaPhong.setBounds(34, 22, 96, 38);
		panelThongTinPhong.add(lbMaPhong);
		
		txtMaPhong = new JTextField();
		txtMaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPhong.setBounds(130, 27, 244, 30);
		panelThongTinPhong.add(txtMaPhong);
		txtMaPhong.setEditable(false);
		txtMaPhong.setColumns(10);
		
		JLabel lbGiaPhong = new JLabel("Giá phòng: ");
		lbGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiaPhong.setBounds(34, 132, 96, 38);
		panelThongTinPhong.add(lbGiaPhong);
		
		txtGiaPhong = new JTextField();
		txtGiaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaPhong.setBounds(130, 137, 244, 30);
		panelThongTinPhong.add(txtGiaPhong);
		txtGiaPhong.setColumns(10);
		
		JLabel lbTrinhTrang = new JLabel("Trình trạng: ");
		lbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTrinhTrang.setBounds(423, 84, 96, 38);
		panelThongTinPhong.add(lbTrinhTrang);
		
		cbTrinhTrang = new JComboBox<String>();
		cbTrinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbTrinhTrang.setBounds(529, 88, 245, 30);
		cbTrinhTrang.addItem("Trống");
		cbTrinhTrang.addItem("Đang sử dụng");
		panelThongTinPhong.add(cbTrinhTrang);
		
		JLabel lbTenPhong = new JLabel("Tên phòng: ");
		lbTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTenPhong.setBounds(34, 84, 96, 38);
		panelThongTinPhong.add(lbTenPhong);
		
		txtTenPhong = new JTextField();
		txtTenPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenPhong.setBounds(130, 84, 244, 30);
		panelThongTinPhong.add(txtTenPhong);
		txtTenPhong.setColumns(10);
		
		JLabel lbLoaiPhong = new JLabel("Loại Phòng:");
		lbLoaiPhong.setBounds(423, 22, 96, 38);
		panelThongTinPhong.add(lbLoaiPhong);
		lbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		cbLoaiPhong = new JComboBox<String>();
		cbLoaiPhong.setBounds(529, 26, 245, 30);
		panelThongTinPhong.add(cbLoaiPhong);
		cbLoaiPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JPanel panelBangThuoc = new JPanel();
		panelBangThuoc.setBounds(10, 199, 1332, 351);
		panel.add(panelBangThuoc);
		panelBangThuoc.setLayout(null);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng","Giá phòng","Trình trạng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin phòng"));
		scrollPhong.setBounds(0, 10, 1325, 331);
		scrollPhong.setBackground(new Color(248,248,248));
		panelBangThuoc.add(scrollPhong);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "chọn tác vụ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(821, 10, 510, 183);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnThemPhong = new JButton("Thêm phòng");
		btnThemPhong.setBackground(Color.ORANGE);
		btnThemPhong.setBounds(84, 36, 120, 30);
		panel_1.add(btnThemPhong);
		btnThemPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnXoaPhong = new JButton("Xóa phòng");
		btnXoaPhong.setBackground(Color.ORANGE);
		btnXoaPhong.setBounds(304, 36, 120, 30);
		panel_1.add(btnXoaPhong);
		btnXoaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSuaPhong = new JButton("Sửa phòng");
		btnSuaPhong.setBackground(Color.ORANGE);
		btnSuaPhong.setBounds(84, 113, 120, 30);
		panel_1.add(btnSuaPhong);
		btnSuaPhong.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnReset = new JButton("Xóa rỗng");
		btnReset.setBackground(Color.ORANGE);
		btnReset.setBounds(304, 113, 120, 30);
		panel_1.add(btnReset);
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSuaPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnThemPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoaPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//tô màu table
		setTableAlternateRow();
		
		//Thêm sự kiện
		tablePhong.addMouseListener(this);
		btnReset.addActionListener(this);
		btnSuaPhong.addActionListener(this);
		btnThemPhong.addActionListener(this);
		btnXoaPhong.addActionListener(this);
		
		
//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		thêm dữ liệu vào table
//		ThemDuLieuVaoTable();
		LoadTatCaPhong();
		
//		Thêm dữ liệu vào combobox loại phòng
		ThemDuLieuVaoCBLoaiPhong();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = tablePhong.getSelectedRow();
		txtMaPhong.setText(dfPhong.getValueAt(i, 0).toString());
		txtTenPhong.setText(dfPhong.getValueAt(i, 1).toString());
		cbLoaiPhong.setSelectedItem(dfPhong.getValueAt(i, 2).toString());
		txtGiaPhong.setText(dfPhong.getValueAt(i, 3).toString());
		cbTrinhTrang.setSelectedItem(dfPhong.getValueAt(i, 4).toString());
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
		if(o.equals(btnThemPhong)) {
			if(KiemTraDuLieu()) {
				String maPhong=phatSinhMa.maPhong();
				String tenPhong=txtTenPhong.getText();
				Double giaPhong=Double.parseDouble(txtGiaPhong.getText());
				String tenLoaiPhong=cbLoaiPhong.getSelectedItem().toString();
				String trinhTrang=cbTrinhTrang.getSelectedItem().toString();
				
				LoaiPhong lp=daoLoaiPhong.getLoaiPhongTheoTen(tenLoaiPhong);
				Phong p=new Phong(maPhong, tenPhong, trinhTrang, giaPhong, lp);
				
					if (daoPhong.themPhong(p)) {
						clearTable();
						LoadTatCaPhong();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else
						JOptionPane.showMessageDialog(this, "Lỗi");
			}
		}
		
		if(o.equals(btnSuaPhong)) {
			
			if(KiemTraDuLieu()) {
				if (tablePhong.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần sửa");
				} else {
					String maPhong=txtMaPhong.getText();
					String tenPhong=txtTenPhong.getText();
					Double giaPhong=Double.parseDouble(txtGiaPhong.getText());
					String tenLoaiPhong=cbLoaiPhong.getSelectedItem().toString();
					String trinhTrang=cbTrinhTrang.getSelectedItem().toString();
					
					LoaiPhong lp=daoLoaiPhong.getLoaiPhongTheoTen(tenLoaiPhong);
					Phong p=new Phong(maPhong, tenPhong, trinhTrang, giaPhong, lp);
					
					int tl;
					tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa phòng này không ?", "Cảnh báo",
							JOptionPane.YES_OPTION);
					if (tl == JOptionPane.YES_OPTION) {
						daoPhong.SuaPhong(p);
						clearTable();
						LoadTatCaPhong();
						JOptionPane.showMessageDialog(this, "Đã sửa");
						XoaTrang();
					}
					if(tl==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(this, "Đã hủy");
					}
				}
			}
			
		}
		if(o.equals(btnXoaPhong)) {
			String maPhong=txtMaPhong.getText();
			if (tablePhong.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn phòng cần xóa");
			} else {
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa phòng này không ?", "Cảnh báo",
						JOptionPane.YES_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					daoPhong.xoaPhong(maPhong);
					clearTable();
					LoadTatCaPhong();
					JOptionPane.showMessageDialog(this, "Đã xóa");
				}
				if(tl==JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(this, "Đã hủy");
				}
			}
		}
		if(o.equals(btnReset)) {
			XoaTrang();
		}
		
	}
	
	public void LoadTatCaPhong() {
		ArrayList<Phong> dsp=new ArrayList<Phong>();
		dsp=daoPhong.getTatCaPhong();
		for(Phong p:dsp) {
			LoaiPhong lp=new LoaiPhong();
			lp=daoLoaiPhong.getLoaiPhongTheoMa(p.getLoaiPhong().getMaLoaiPhong());
			dfPhong.addRow(new Object[] {
					p.getMaPhong(),p.getTenPhong(),lp.getTenLoai(),df.format(p.getGiaPhong()),p.getTinhTrang()
			});
		}
	}
	
//	public void ThemDuLieuVaoTable() {
//		try {
//			daoPhong.getDuLieuPhong("SELECT Phong.maPhong, Phong.tenPhong, LoaiPhong.tenLoai, Phong.giaPhong,"
//					+ " Phong.trinhTrang FROM Phong INNER JOIN LoaiPhong ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong", dfPhong);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
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
	private void XoaTrang() {
		txtGiaPhong.setText("");
		txtMaPhong.setText("");
		txtTenPhong.setText("");
	}
	
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
	public boolean KiemTraDuLieu() {
		Regex regex=new Regex();
		if(regex.kiemTraRong(txtTenPhong))
			return false;
		if(regex.kiemTraRong(txtGiaPhong))
			return false;
		if(regex.kiemTraGiaPhong(txtGiaPhong))
			return false;
		return true;
	}
}