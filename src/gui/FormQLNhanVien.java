package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.toedter.calendar.JDateChooser;

import connect.ConnectDB;
import entity.ChucVu;
import entity.NhanVien;
import dao.DaoChucVu;
import dao.DaoNhanVien;

public class FormQLNhanVien extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnSua;
	private JButton btnCapNhat;
	private JButton btnThem;
	private JButton btnXoa;
	private JTextField txtTenNv;
	private JTextField txtID;
	private JDateChooser ngaysinh;
	private JComboBox<String> cbGioitinh;;
	private JTextField txtCmnd;
	private JComboBox<String> cbChucVu;
	private JTextField txtSdt;
	private DefaultTableModel tableModel;
	private DaoNhanVien dao = new DaoNhanVien();
	private DaoChucVu daoCV= new DaoChucVu();
	
	public FormQLNhanVien() {
		setBounds(0, 0, 1366, 620);
		setLayout(null);
		
		//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JPanel pnTTNV = new JPanel();
		pnTTNV.setBackground(Color.WHITE);
		pnTTNV.setBorder(new TitledBorder(null, "THÔNG TIN NHÂN VIÊN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTTNV.setBounds(0,0, 1366,190);
		pnTTNV.setLayout(null);
		add(pnTTNV);
		
		JLabel lbManv = new JLabel("Mã NV: ");
		lbManv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbManv.setBounds(110, 27, 96, 38);
		pnTTNV.add(lbManv);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(216, 31, 190, 30);
		pnTTNV.add(txtID);
		txtID.setColumns(10);
		
		JLabel lbTennv = new JLabel("Tên NV: ");
		lbTennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTennv.setBounds(505, 24, 96, 38);
		pnTTNV.add(lbTennv);
		
		txtTenNv = new JTextField();
		txtTenNv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNv.setBounds(601, 30, 190, 30);
		pnTTNV.add(txtTenNv);
		txtTenNv.setColumns(10);
		
		JLabel lbGt = new JLabel("Giới tính:");
		lbGt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGt.setBounds(955, 24, 96, 38);
		pnTTNV.add(lbGt);
		
		cbGioitinh = new JComboBox<String>();
		cbGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbGioitinh.addItem("Nam");
		cbGioitinh.addItem("Nữ");
		cbGioitinh.setBounds(1055, 30, 190, 30);
		pnTTNV.add(cbGioitinh);
		
		JLabel lblNgaysinh = new JLabel("Ngày sinh:");
		lblNgaysinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNgaysinh.setBounds(110, 80, 96, 38);
		pnTTNV.add(lblNgaysinh);

		ngaysinh = new JDateChooser();
		ngaysinh.setDateFormatString("dd/MM/yyyy");
		ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ngaysinh.setPreferredSize(new Dimension(400, 400));
		ngaysinh.getJCalendar().getMonthChooser().setPreferredSize(new Dimension(150, 30));
		ngaysinh.setBounds(216, 83, 190, 30);
		pnTTNV.add(ngaysinh);
		
		/*
		JLabel lbNs = new JLabel("Ngày sinh:");
		lbNs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNs.setBounds(110, 80, 96, 38);
		pnTTNV.add(lbNs);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgaySinh.setBounds(216, 83, 190, 30);
		pnTTNV.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		*/
		
		JLabel lbScm = new JLabel("Số CMND:");
		lbScm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbScm.setBounds(505, 80, 96, 30);
		pnTTNV.add(lbScm);
		
		txtCmnd = new JTextField();
		txtCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCmnd.setBounds(601, 83, 190, 30);
		pnTTNV.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JLabel lbSdt = new JLabel("Số điện thoại:");
		lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSdt.setBounds(955, 83, 190, 30);
		pnTTNV.add(lbSdt);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSdt.setBounds(1055, 88, 190, 30);
		pnTTNV.add(txtSdt);
		txtSdt.setColumns(10);
		
		JLabel lbChucVu = new JLabel("Chức vụ: ");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbChucVu.setBounds(110, 137, 96, 38);
		pnTTNV.add(lbChucVu);
		
		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbChucVu.setBounds(216, 140, 190, 30);
		pnTTNV.add(cbChucVu);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.WHITE);
		pnChucNang.setBounds(0,190, 1366,40);
		pnChucNang.setLayout(null);
		add(pnChucNang);
		
		btnThem = new JButton("Thêm");
		btnThem.setForeground(SystemColor.controlText);
		btnThem.setBackground(new Color(255, 255, 153));
		btnThem.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnThem.setBounds(200, 10, 150, 30);
		btnThem.setFocusable(false);
		pnChucNang.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(SystemColor.controlText);
		btnSua.setBackground(new Color(255, 255, 153));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnSua.setBounds(450, 10, 150, 30);
		btnSua.setFocusable(false);
		pnChucNang.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(SystemColor.controlText);
		btnXoa.setBackground(new Color(255, 255, 153));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnXoa.setBounds(700, 10, 150, 30);
		btnXoa.setFocusable(false);
		pnChucNang.add(btnXoa);
		
		btnCapNhat= new JButton("Xóa trắng");
		btnCapNhat.setForeground(SystemColor.controlText);
		btnCapNhat.setBackground(new Color(255, 255, 153));
		btnCapNhat.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnCapNhat.setBounds(950, 10, 150, 30);
		btnCapNhat.setFocusable(false);
		pnChucNang.add(btnCapNhat);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 230, 1366, 820);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH NHÂN VIÊN:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(500,0, 500, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 300);
		panel.add(scrollPane);
		
		String[] header = {"Mã NV", "Tên NV","Giới tính","Ngày sinh", "Điện thoại", "CMND", "Chức vụ"};
		tableModel = new DefaultTableModel(header, 0){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false, false, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
			table = new JTable() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				/**
				 * tô màu từng dòng
				 */
				@Override
				public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
					Component c = super.prepareRenderer(renderer, row, column);
					if (!isRowSelected(row))
						c.setBackground(row % 2 == 0 ? getBackground() :  new Color(218, 223, 225));
					return c;
				}

				public boolean getScrollableTracksViewportWidth() {
					return getPreferredSize().width < getParent().getWidth();
				}

				@Override
				public void doLayout() {
					TableColumn resizingColumn = null;
					TableColumnModel tcm = getColumnModel();

					if (tableHeader != null)
						resizingColumn = tableHeader.getResizingColumn();

					// Viewport size changed. May need to increase columns widths

					if (resizingColumn == null) {
						setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						super.doLayout();
					}

					// Specific column resized. Reset preferred widths

					else {

						for (int i = 0; i < tcm.getColumnCount(); i++) {
							resizingColumn = table.getColumnModel().getColumn(i);
							if (i == 1) {
								resizingColumn.setPreferredWidth(700); // second column is bigger
							} else {
								resizingColumn.setPreferredWidth(resizingColumn.getWidth());
							}
						}

						// Columns don't fill the viewport, invoke default layout

						if (tcm.getTotalColumnWidth() < getParent().getWidth())
							setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
						super.doLayout();
					}

					setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				}

			};
        
        table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 20));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		table.setBackground(SystemColor.WHITE);
		table.setRowHeight(45);
		table.addMouseListener(this);
		table.setModel(tableModel);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);
		table.getTableHeader().setBackground(new Color(255, 208, 120));
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setViewportView(table);
		
		/*/Add thông tin vào bảng
		try {
			dao_nhanvien.loadData("select * from NhanVien ", tableModel); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		LoadTatCaNhanVien();
		ThemDuLieuVaoCbLoaiCV();
		
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = table.getSelectedRow();
		txtID.setText(tableModel.getValueAt(i, 0).toString());
		txtTenNv.setText(tableModel.getValueAt(i, 1).toString());
		cbGioitinh.setSelectedItem(tableModel.getValueAt(i, 2).toString());
		ngaysinh.setToolTipText(tableModel.getValueAt(i, 3).toString());
		txtSdt.setText(tableModel.getValueAt(i, 4).toString());
		txtCmnd.setText(tableModel.getValueAt(i, 5).toString());
		cbChucVu.setSelectedItem(tableModel.getValueAt(i, 6).toString());
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
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String ma=txtID.getText(); 
			String ten=txtTenNv.getText(); 
			String gt = (String) cbGioitinh.getSelectedItem();
			Date ns = new Date(ngaysinh.getDate().getTime());
			String sdt = txtSdt.getText();
			String cmnd = txtCmnd.getText();
			String tenChucVu=cbChucVu.getSelectedItem().toString();
			
			ChucVu lcv=daoCV.getChucVuTheoTen(tenChucVu);
			NhanVien nv =new NhanVien(ma,ten,gt, ns,sdt,cmnd,lcv);
			
			try {
				if (dao.themNhanVien(nv)) {
					clearTable();
					LoadTatCaNhanVien();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				} else
					JOptionPane.showMessageDialog(this, "Lỗi");
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua)) {
			int i = table.getSelectedRow();
			if (i != -1) {
				String ma=txtID.getText(); 
				String ten=txtTenNv.getText(); 
				String gt = (String) cbGioitinh.getSelectedItem();
				Date ns = new Date(ngaysinh.getDate().getTime());
				String sdt = txtSdt.getText();
				String cmnd = txtCmnd.getText();
				String tenChucVu=cbChucVu.getSelectedItem().toString();
				
				ChucVu lcv=daoCV.getChucVuTheoTen(tenChucVu);
				NhanVien nv =new NhanVien(ma,ten,gt, ns,sdt,cmnd,lcv);
				
				dao.suaThongtinNhanvien(nv);
				clearTable();
				LoadTatCaNhanVien();
				JOptionPane.showMessageDialog(this, "Đã sửa");
				XoaTrang();
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần cập nhật thông tin");
			}
		
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				try {
						int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa nhân viên này", "Chú ý",
								JOptionPane.YES_NO_OPTION);
						if (xacnhan == JOptionPane.YES_OPTION) {
							if (dao.delNhanVien(txtID.getText())) {
								tableModel.removeRow(row);
								JOptionPane.showMessageDialog(this, "Xóa thành công!");
								LoadTatCaNhanVien();
							} 
							else {
								JOptionPane.showMessageDialog(this, "Xóa nhân viên " + txtID.getText() + " thành công!");
							}
						}
					}
				 catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên để xóa");
		}
		if(o.equals(btnCapNhat)) {
			XoaTrang();
		}
	}

	public void LoadTatCaNhanVien() {
		ArrayList<NhanVien> dsnv=new ArrayList<NhanVien>();
		dsnv=dao.getalltbNhanVien();
		for(NhanVien nv:dsnv) {
			ChucVu lcv=new ChucVu();
			lcv=daoCV.getChucVuTheoMa(nv.getChucVu().getMaChucVu());
			tableModel.addRow(new Object[] {
					nv.getMaNhanVien(),nv.getTenNhanVien(),nv.getGioiTinh(),nv.getNgaySinh(),nv.getDienThoai(),nv.getSoCMND(),lcv.getTenChucVu()
			});
		}
		
	}
	public void ThemDuLieuVaoCbLoaiCV() {
		ArrayList<ChucVu> dsCV=new ArrayList<ChucVu>();
		dsCV=daoCV.getTatCaLoaiCV();
		for(ChucVu lcv: dsCV) {
			cbChucVu.addItem(lcv.getTenChucVu());
		}
	}
	public void reloadData() {
		DaoNhanVien dao_nhanvien = new DaoNhanVien();
		try {
			tableModel.setRowCount(0);
			dao_nhanvien.loadData("select * from NhanVien ", tableModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	private void clearTable() {
		while (table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	private void XoaTrang() {
		txtID.setText("");
		txtTenNv.setText("");
		cbGioitinh.setToolTipText("");
		ngaysinh.setToolTipText("");
		txtSdt.setText("");
		txtCmnd.setText("");
		cbChucVu.setToolTipText("");
	}
}