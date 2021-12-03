package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import chucnang.Regex;
import connect.ConnectDB;
import dao.DaoLoaiPhong;
import dao.PhatSinhMa;
import entity.LoaiPhong;
import entity.Phong;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.Color;

public class FormLoaiPhong extends JPanel implements ActionListener, MouseListener{

	private JPanel contentPane;
	private JTextField txtTen;
	private JTextField txtMa;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private JButton btnThem,btnXoa,btnSua,btnXoaTrang;
	private DaoLoaiPhong daoLoaiPhong=new DaoLoaiPhong();
	private JTextField txtMoTa;
	private PhatSinhMa ma=new PhatSinhMa();

	public FormLoaiPhong() {
		setBounds(0, 0, 1352, 565);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1352, 565);
		add(panel);
		panel.setLayout(null);
		
		JPanel panelTT = new JPanel();
		panelTT.setBorder(new TitledBorder(null, "Th\u00F4ng tin lo\u1EA1i ph\u00F2ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelTT.setBounds(10, 10, 834, 176);
		panel.add(panelTT);
		panelTT.setLayout(null);
		
		JLabel lbTen = new JLabel("Tên loại phòng:");
		lbTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTen.setBounds(125, 78, 140, 30);
		panelTT.add(lbTen);
		
		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTen.setBounds(305, 79, 364, 30);
		panelTT.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lbMa = new JLabel("Mã loại phòng:");
		lbMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMa.setBounds(125, 23, 140, 30);
		panelTT.add(lbMa);
		
		txtMa = new JTextField();
		txtMa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMa.setColumns(10);
		txtMa.setBounds(305, 23, 364, 30);
		txtMa.setEditable(false);
		panelTT.add(txtMa);
		
		JLabel lblMT = new JLabel("Mô tả:");
		lblMT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMT.setBounds(125, 136, 140, 30);
		panelTT.add(lblMT);
		
		txtMoTa = new JTextField();
		txtMoTa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMoTa.setColumns(10);
		txtMoTa.setBounds(305, 136, 364, 30);
		panelTT.add(txtMoTa);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(854, 10, 476, 176);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		btnThem = new JButton("Thêm loại phòng");
		btnThem.setBackground(Color.ORANGE);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(61, 42, 160, 30);
		panel_1.add(btnThem);
		
		btnXoa = new JButton("Xóa loại phòng");
		btnXoa.setBackground(Color.ORANGE);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(61, 106, 160, 30);
		panel_1.add(btnXoa);
		
		btnSua = new JButton("Sửa loại phòng");
		btnSua.setBackground(Color.ORANGE);
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(291, 42, 160, 30);
		panel_1.add(btnSua);
		
		btnXoaTrang = new JButton("Làm mới");
		btnXoaTrang.setBackground(Color.ORANGE);
		btnXoaTrang.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaTrang.setBounds(291, 106, 160, 30);
		panel_1.add(btnXoaTrang);
		
		JPanel panelTable = new JPanel();
		panelTable.setBounds(10, 196, 1320, 344);
		panel.add(panelTable);
		
		String []header= {"Mã loại phòng","Tên loại phòng","Mô tả"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		tablePhong.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		tablePhong.getTableHeader().setBackground(new Color(255, 204, 102));
		JScrollPane scrollPhong;
		panelTable.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBorder(BorderFactory.createTitledBorder("Thông tin loại phòng"));
		scrollPhong.setBounds(10, 5, 1300, 329);
		scrollPhong.setBackground(new Color(248,248,248));
		panelTable.add(scrollPhong);
		
		setTableAlternateRow();
		
//		kết nối database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		tablePhong.addMouseListener(this);
		
		LoadTatCaloaiPhong();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int i = tablePhong.getSelectedRow();
		txtMa.setText(dfPhong.getValueAt(i, 0).toString());
		txtTen.setText(dfPhong.getValueAt(i, 1).toString());
		txtMoTa.setText(dfPhong.getValueAt(i, 2).toString());
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
		if(o.equals(btnThem)) {
			if(KiemTraDuLieu()) {
				String maLoaiPhong=ma.maLoaiPhong();
				String tenLoaiPhong=txtTen.getText();
				String mota=txtMoTa.getText();
				LoaiPhong loaiPhong=new LoaiPhong(maLoaiPhong, tenLoaiPhong, mota);
				
					if (daoLoaiPhong.themLoaiPhong(loaiPhong)) {
						clearTable();
						LoadTatCaloaiPhong();
						JOptionPane.showMessageDialog(this, "Thêm thành công");
					} else
						JOptionPane.showMessageDialog(this, "Lỗi");
			}
		}
		
		if(o.equals(btnSua)) {
			
			if(KiemTraDuLieu()) {
				if (tablePhong.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(this, "Hãy chọn loại phòng cần sửa");
				} else {
					String maLoaiPhong=txtMa.getText();
					String tenLoaiPhong=txtTen.getText();
					String mota=txtMoTa.getText();
					LoaiPhong loaiPhong=new LoaiPhong(maLoaiPhong, tenLoaiPhong, mota);
					
					int tl;
					tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa loại phòng này không ?", "Cảnh báo",
							JOptionPane.YES_OPTION);
					if (tl == JOptionPane.YES_OPTION) {
						daoLoaiPhong.SuaPhong(loaiPhong);
						clearTable();
						LoadTatCaloaiPhong();
						JOptionPane.showMessageDialog(this, "Đã sửa");
						XoaTrang();
					}
					if(tl==JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(this, "Đã hủy");
					}
				}
			}
			
		}
		if(o.equals(btnXoa)) {
			String maPhong=txtMa.getText();
			if (tablePhong.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn loại phòng cần xóa");
			} else {
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa loại phòng này không ?", "Cảnh báo",
						JOptionPane.YES_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					daoLoaiPhong.xoaLoaiPhong(maPhong);
					clearTable();
					LoadTatCaloaiPhong();
					JOptionPane.showMessageDialog(this, "Đã xóa");
				}
				if(tl==JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(this, "Đã hủy");
				}
			}
		}
		if(o.equals(btnXoaTrang)) {
			XoaTrang();
		}
		
	}
	
	public void LoadTatCaloaiPhong() {
		ArrayList<LoaiPhong> ds=new ArrayList<LoaiPhong>();
		ds=daoLoaiPhong.getTatCaLoaiPhong();
		for(LoaiPhong p:ds) {
			dfPhong.addRow(new Object[] {
					p.getMaLoaiPhong(),p.getTenLoai(),p.getMoTa()
			});
		}
	}
	private void clearTable() {
		while (tablePhong.getRowCount() > 0) {
			dfPhong.removeRow(0);
		}
	}
	private void XoaTrang() {
		txtMa.setText("");
		txtTen.setText("");
		txtMoTa.setText("");
	}
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
	public boolean KiemTraDuLieu() {
		Regex regex=new Regex();
		if(regex.kiemTraRong(txtTen))
			return false;
		if(regex.kiemTraRong(txtMoTa))
			return false;
		return true;
	}
}
