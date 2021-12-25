package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Frame;
import java.awt.HeadlessException;
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
import java.sql.Date;
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

import chucnang.Regex;
import connect.ConnectDB;
import dao.DaoChucVu;
import dao.DaoNhanVien;
import dao.DaoTaiKhoan;
import dao.PhatSinhMa;
import entity.ChucVu;
import entity.NhanVien;
import entity.TaiKhoan;

public class FormTaiKhoan extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtId;
	private JTextField txtTen;
	private JTextField txtMk;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnCapNhat;
	private JTable table;
	private DefaultTableModel tableModel;
	private DaoNhanVien dao = new DaoNhanVien();
	private DaoChucVu daoCV = new DaoChucVu();
	private DaoTaiKhoan daoTK = new DaoTaiKhoan();
	private JComboBox<String> cbChucVu;
	private PhatSinhMa phatSinhMa=new PhatSinhMa(); 
	
	public FormTaiKhoan() {
		
		setBounds(0, 0, 1366, 766);
		setLayout(null);
		
		//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.WHITE);
		pnTimKiem.setBorder(new TitledBorder(null, "THÔNG TIN TÀI KHOẢN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTimKiem.setBounds(0,0, 1366,190);
		pnTimKiem.setLayout(null);
		add(pnTimKiem);
		
		JLabel lblMaNV = new JLabel("Mã tài khoản :");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(420, 30, 200, 30);
		pnTimKiem.add(lblMaNV);

		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtId.setBounds(650, 30, 300, 30);
		pnTimKiem.add(txtId);
		txtId.setColumns(10);
		
	    
        JLabel lblTenNV = new JLabel("Tên đăng nhập :");
        lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTenNV.setBounds(420, 80, 300, 30);
        pnTimKiem.add(lblTenNV);

		txtTen = new JTextField();
		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTen.setBounds(650, 80, 300, 30);
		pnTimKiem.add(txtTen);
		txtTen.setColumns(10);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu :");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMatKhau.setBounds(420, 130, 300, 30);
        pnTimKiem.add(lblMatKhau);

		txtMk = new JTextField();
		txtMk .setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtMk .setBounds(650, 130, 300, 30);
		pnTimKiem.add(txtMk );
		txtMk.setColumns(10);
		
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
		
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnCapNhat.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 230, 1366, 820);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH TÀI KHOẢN:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(500,0, 500, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 280);
		panel.add(scrollPane);
		
		String[] header = {"Mã", "Tên ","Mật khẩu"};
		tableModel = new DefaultTableModel(header, 0){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false
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
			daoTK.loadData("select * from TaiKhoan ", tableModel); 
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if(KiemTraDuLieu()) {
			String ma=txtId.getText();
			String ten=txtTen.getText();
			String matkhau=txtMk.getText();
			
			TaiKhoan tk =new TaiKhoan(ma,ten,matkhau);
			try {
				if (daoTK.themTaikhoan(tk)) {
					clearTable();
					reloadData();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				} else
					JOptionPane.showMessageDialog(this, "Lỗi");
			} catch (HeadlessException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		}
		if(o.equals(btnSua)) {
			if(KiemTraDuLieu()) {
			int i = table.getSelectedRow();
			if (i != -1) {
				String ma=txtId.getText(); 
				String ten=txtTen.getText();
				String matkhau=txtMk.getText();
				
				TaiKhoan tk =new TaiKhoan(ma,ten,matkhau);
				
				daoTK.doiMatkhau(tk, matkhau);
				clearTable();
				reloadData();
				JOptionPane.showMessageDialog(this, "Đã sửa");
				XoaTrang();
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên cần cập nhật thông tin");
			}
			}
		
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				try {
						int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa ", "Chú ý",
								JOptionPane.YES_NO_OPTION);
						if (xacnhan == JOptionPane.YES_OPTION) {
							if (daoTK.delTaiKhoan(txtId.getText())) {
								tableModel.removeRow(row);
								JOptionPane.showMessageDialog(this, "Xóa thành công!");
								reloadData();
							} 
							else {
								JOptionPane.showMessageDialog(this, "Xóa tài khoản " + txtId.getText() + " thành công!");
							}
						}
					}
				 catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else
				JOptionPane.showMessageDialog(this, "Vui lòng chọn chức vụ để xóa");
		}
		if(o.equals(btnCapNhat)) {
			XoaTrang();
		}
	}
				
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = table.getSelectedRow();
		txtId.setText(tableModel.getValueAt(i, 0).toString());
		txtTen.setText(tableModel.getValueAt(i, 1).toString());
		txtMk.setText(tableModel.getValueAt(i, 2).toString());
		
		
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
	private void clearTable() {
		while (table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	public void reloadData() {
		try {
			tableModel.setRowCount(0);
			daoTK.loadData("select * from TaiKhoan ", tableModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	private void XoaTrang() {
		txtId.setText("");
		txtTen.setText("");
		txtMk.setText("");
	}
	public boolean KiemTraDuLieu() {
		Regex regex=new Regex();
		if(regex.kiemTraRong(txtTen))
			return false;
		return true;
	}
}

