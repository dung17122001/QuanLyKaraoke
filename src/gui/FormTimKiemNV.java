package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.ItemSelectable;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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


import connect.ConnectDB;
import dao.DAO_NhanVien;

public class FormTimKiemNV extends JFrame implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtTimMaNV;
	private JTextField txtTimTenNV;
	private JTextField txtTimNsNV;
	private JTextField txtTimSdtNV;
	private JTextField txtTimSocmNV;
	private JButton btnTimKiem;
	private JButton btnDong;
	private JButton btnCapNhat;
	private JTable table;
	private DefaultTableModel tableModel;
	private DAO_NhanVien dao = new DAO_NhanVien();
	private JRadioButton rTen, rSDT, rChucVu, rCmnd, rMa,rNs;
	private JComboBox<String> cbChucVu;
	
	public FormTimKiemNV() {
		
		setBounds(0, 0, 1366, 766);
		setLayout(null);
		
		//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		DAO_NhanVien dao_nhanvien = new DAO_NhanVien(); 
				
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.WHITE);
		pnTimKiem.setBorder(new TitledBorder(null, "THÔNG TIN TÌM KIẾM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTimKiem.setBounds(0,0, 1366,310);
		pnTimKiem.setLayout(null);
		add(pnTimKiem);
		
		JLabel lblMaNV = new JLabel("Mã nhân viên:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(300, 20, 300, 30);
		pnTimKiem.add(lblMaNV);

		txtTimMaNV = new JTextField();
		txtTimMaNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimMaNV.setBounds(650, 20, 300, 30);
		pnTimKiem.add(txtTimMaNV);
		txtTimMaNV.setColumns(10);
		
		rMa = new JRadioButton();
		rMa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rMa.setBackground(Color.WHITE);
		rMa.setBounds(950, 20, 20, 30);
		pnTimKiem.add(rMa);
	    
        JLabel lblTenNV = new JLabel("Tên nhân viên:");
        lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTenNV.setBounds(300, 70, 300, 30);
        pnTimKiem.add(lblTenNV);

		txtTimTenNV = new JTextField();
		txtTimTenNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimTenNV.setBounds(650, 70, 300, 30);
		pnTimKiem.add(txtTimTenNV);
		txtTimTenNV.setColumns(10);
		
		rTen = new JRadioButton();
		rTen.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rTen.setBackground(Color.WHITE);
		rTen.setBounds(950, 70, 20, 30);
		pnTimKiem.add(rTen);
		
        JLabel lblNsNV = new JLabel("Ngày sinh:");
        lblNsNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNsNV.setBounds(300, 120, 300, 30);
        pnTimKiem.add(lblNsNV);

		txtTimNsNV = new JTextField();
		txtTimNsNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimNsNV.setBounds(650, 120, 300, 30);
		pnTimKiem.add(txtTimNsNV);
		txtTimNsNV.setColumns(10);
	    
		rNs = new JRadioButton();
		rNs.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rNs.setBackground(Color.WHITE);
		rNs.setBounds(950, 120, 300, 30);
		pnTimKiem.add(rNs);
		
        JLabel lblSdt = new JLabel("Số điện thoại:");
        lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblSdt.setBounds(300, 170, 300, 30);
        pnTimKiem.add(lblSdt);

		txtTimSdtNV = new JTextField();
		txtTimSdtNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSdtNV.setBounds(650, 170, 300, 30);
		pnTimKiem.add(txtTimSdtNV);
		txtTimSdtNV.setColumns(10);
        
		rSDT = new JRadioButton();
		rSDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rSDT.setBackground(Color.WHITE);
		rSDT.setBounds(950, 170, 300, 30);
		pnTimKiem.add(rSDT);
		
        JLabel lblCmnd = new JLabel("CMND:");
        lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblCmnd.setBounds(300, 220, 300, 30);
        pnTimKiem.add(lblCmnd);

		txtTimSocmNV = new JTextField();
		txtTimSocmNV.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSocmNV.setBounds(650, 220, 300, 30);
		pnTimKiem.add(txtTimSocmNV);
		txtTimSocmNV.setColumns(10);
		
		rCmnd = new JRadioButton();
		rCmnd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rCmnd.setBackground(Color.WHITE);
		rCmnd.setBounds(950, 220, 300, 30);
		pnTimKiem.add(rCmnd);
		
		JLabel lbChucVu= new JLabel("Chức vụ:");
		lbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbChucVu.setBounds(300, 270, 300, 30);
		pnTimKiem.add(lbChucVu);
		
		cbChucVu = new JComboBox<String>();
		cbChucVu.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cbChucVu.setBounds(650, 270, 300, 30);
		cbChucVu.addItem("Nhân viên thu ngân");
		cbChucVu.addItem("Nhân viên phục vụ");
		cbChucVu.addItem("Nhân viên kế toán");
		pnTimKiem.add(cbChucVu);
		
		rChucVu = new JRadioButton();
		rChucVu.setFont(new Font("Tahoma", Font.PLAIN, 16));
		rChucVu.setBackground(Color.WHITE);
		rChucVu.setBounds(950, 270, 300, 30);
		pnTimKiem.add(rChucVu);
		
        JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.WHITE);
		pnChucNang.setBounds(0,310, 1366,50);
		pnChucNang.setLayout(null);
		add(pnChucNang);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(SystemColor.controlText);
		btnTimKiem.setBackground(new Color(255, 204, 102));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTimKiem.setBounds(250, 5, 180, 40);
		btnTimKiem.setFocusable(false);
		pnChucNang.add(btnTimKiem);
		
		btnCapNhat= new JButton("Tải lại");
		btnCapNhat.setForeground(SystemColor.controlText);
		btnCapNhat.setBackground(new Color(255, 204, 102));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCapNhat.setBounds(600, 5, 180, 40);
		btnCapNhat.setFocusable(false);
		pnChucNang.add(btnCapNhat);
		btnCapNhat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				reloadData();
			}
		});
		
		btnDong = new JButton("Thoát");
		btnDong.setForeground(SystemColor.controlText);
		btnDong.setBackground(new Color(255, 204, 102));
		btnDong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDong.setBounds(1000, 5, 180, 40);
		btnDong.setFocusable(false);
		pnChucNang.add(btnDong);
		
		btnDong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDong.addActionListener(this);
		btnTimKiem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 360, 1366, 820);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH NHÂN VIÊN:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(500,0, 500, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 350);
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
		
		//Add thông tin vào bảng
		try {
			dao_nhanvien.loadData("select * from NhanVien ", tableModel); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rMa.addActionListener(this);
		rTen.addActionListener(this);
		rSDT.addActionListener(this);
		rCmnd.addActionListener(this);
		rChucVu.addActionListener(this);
		rNs.addActionListener(this);
		
	}
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if (o.equals(btnTimKiem)) {
			String timkiemma = txtTimMaNV.getText().toLowerCase().trim();
			String timkiemten = txtTimTenNV.getText().toLowerCase().trim();
			String timkiemns = txtTimNsNV.getText().toLowerCase().trim();
			String timkiemsdt = txtTimSdtNV.getText().toLowerCase().trim();
			String timsocmnd = txtTimSocmNV.getText().toLowerCase().trim();
			String timchucvu =(String) cbChucVu.getSelectedItem();
			//tim theo ma nhan vien
			if (rMa.isSelected()) {
				if (!timkiemma.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from NhanVien where maNhanVien like N'%" + timkiemma + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTimMaNV.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Mã NV gồm NVxxx! \n Tìm kiếm gần đúng", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					txtTimMaNV.requestFocus();
					return;
				}
			}
			
			//tim theo ten nhan vien
			if (rTen.isSelected()) {
				if (!timkiemten.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from NhanVien where tenNhanVien like N'%" + timkiemten + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTimTenNV.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Tên nhân viên gồm họ+tên ! \n Tìm kiếm gần đúng", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					txtTimTenNV.requestFocus();
					return;
				}
			
		}
			
			//tim theo ns nhan vien
			if (rNs.isSelected()) {
				if (!timkiemns.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from NhanVien where ngaySinh like N'%" + timkiemns + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTimNsNV.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Ngày sinh nhân viên gồm xxxx-xx-xx ! \n Tìm kiếm gần đúng", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					txtTimNsNV.requestFocus();
					return;
				}
			
		}
			//tim theo sdt nhan vien
			if (rSDT.isSelected()) {
				if (!timkiemsdt.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from NhanVien where dienThoai like N'%" + timkiemsdt + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTimSdtNV.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Số điện thoại nhân viên gồm 0xxxxxxxxx ! \n Tìm kiếm gần đúng", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					txtTimSdtNV.requestFocus();
					return;
				}
			
		}
			
			//tim theo soCMND nhan vien
			if (rCmnd.isSelected()) {
				if (!timsocmnd.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from NhanVien where soCMND like N'%" + timsocmnd + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTimSocmNV.setText("");
				} else {
					JOptionPane.showMessageDialog(this, "Số cmnd nhân viên gồm xxxxxxxxx ! \n Tìm kiếm gần đúng", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					txtTimSocmNV.requestFocus();
					return;
				}
			
		}
			
			//tim theo chuc vu nhan vien
			if (rChucVu.isSelected()) {
				if (!timchucvu.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from NhanVien where chucVu like N'%" + timchucvu + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					cbChucVu.setToolTipText("");
				} else {
					JOptionPane.showMessageDialog(this, "Tìm kiếm gần đúng", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					cbChucVu.requestFocus();
					return;
				}
			
		}
		}
		if(o.equals(btnDong)) {
			this.dispose();
		}
	}

	public static void main(String[] args) throws SQLException {		
		FormTimKiemNV frm = new FormTimKiemNV();
		frm.setVisible(true);
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
	public void reloadData() {
		DAO_NhanVien dao_nhanvien = new DAO_NhanVien();
		try {
			tableModel.setRowCount(0);
			dao_nhanvien.loadData("select * from NhanVien ", tableModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
