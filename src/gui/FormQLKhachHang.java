package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import connect.ConnectDB;
import entity.KhachHang;
import dao.DaoKhachHang;

public class FormQLKhachHang extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnCapNhat;
	private JButton btnXoa;
	private JTextField txtTenKh;
	private JTextField txtID;
	private JTextField txtCmnd;
	private JTextField txtDiachi;
	private JTextField txtSdt;
	private DefaultTableModel tableModel;
	private DaoKhachHang dao = new DaoKhachHang();
	
	public FormQLKhachHang() {
		setBounds(0, 0, 1366,620);
		setLayout(null);
		//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		DaoKhachHang dao_khachhang = new DaoKhachHang(); 
		
		JPanel pnTTNV = new JPanel();
		pnTTNV.setBackground(Color.WHITE);
		pnTTNV.setBorder(new TitledBorder(null, "THÔNG TIN KHÁCH HÀNG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTTNV.setBounds(0,0, 1366,190);
		pnTTNV.setLayout(null);
		add(pnTTNV);
		
		JLabel lbManv = new JLabel("Mã KH: ");
		lbManv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbManv.setBounds(310, 27, 96, 38);
		pnTTNV.add(lbManv);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(416, 31, 190, 30);
		pnTTNV.add(txtID);
		txtID.setColumns(10);
		
		JLabel lbTennv = new JLabel("Tên KH: ");
		lbTennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTennv.setBounds(310, 80, 96, 38);
		pnTTNV.add(lbTennv);
		
		txtTenKh = new JTextField();
		txtTenKh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKh.setBounds(416, 83, 190, 30);
		pnTTNV.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		JLabel lbScm = new JLabel("Số CMND");
		lbScm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbScm.setBounds(705, 80, 96, 30);
		pnTTNV.add(lbScm);
		
		txtCmnd = new JTextField();
		txtCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCmnd.setBounds(801, 83, 190, 30);
		pnTTNV.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JLabel lbSdt = new JLabel("Số điện thoại:");
		lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSdt.setBounds(705, 24, 96, 38);
		pnTTNV.add(lbSdt);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSdt.setBounds(801, 30, 190, 30);
		pnTTNV.add(txtSdt);
		txtSdt.setColumns(10);
		
		JLabel lbDiachi = new JLabel("Địa chỉ:");
		lbDiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDiachi.setBounds(310, 135, 190, 30);
		pnTTNV.add(lbDiachi);
		
		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiachi.setBounds(416, 135, 576, 30);
		pnTTNV.add(txtDiachi);
		txtDiachi.setColumns(10);
		
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
		panel.setBounds(0, 230, 1368, 768);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH KHÁCH HÀNG:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(500,0, 500, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 300);
		panel.add(scrollPane);
		
		String[] header = {"Mã KH", "Tên KH","Địa chỉ", "Điện thoại", "CMND"};
		tableModel = new DefaultTableModel(header, 0){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false, false, false
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
			dao_khachhang.loadData("select * from KhachHang ", tableModel); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnCapNhat.addActionListener(this);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int i = table.getSelectedRow();
		txtID.setText(tableModel.getValueAt(i, 0).toString());
		txtTenKh.setText(tableModel.getValueAt(i, 1).toString());
		txtDiachi.setText(tableModel.getValueAt(i, 2).toString());
		txtSdt.setText(tableModel.getValueAt(i, 3).toString());
		txtCmnd.setText(tableModel.getValueAt(i, 4).toString());
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
		DaoKhachHang dao_khachhang = new DaoKhachHang();
		try {
			tableModel.setRowCount(0);
			dao_khachhang.loadData("select * from KhachHang ", tableModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if(o.equals(btnThem)) {
			String ma = txtID.getText();
			String ten = txtTenKh.getText();
			String diachi = txtDiachi.getText();
			String sdt = txtSdt.getText();
			String cmnd = txtCmnd.getText();
			KhachHang kh =new KhachHang(ma,ten,diachi,sdt,cmnd);
			try {
				if (dao.themKhachHang(kh)) {
					clearTable();
					reloadData();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
					int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có muốn lập hóa đơn cho khách hàng này", "Chú ý",
							JOptionPane.YES_NO_OPTION);
					if (xacnhan == JOptionPane.YES_OPTION) {
						FormGiaoDienChinh.changeScreen(new FormLapHD());
					}
				}else {
					JOptionPane.showMessageDialog(this, "Có lỗi xảy ra! Vui lòng thử lại\nThêm không thành công");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
		if(o.equals(btnSua)) {
			int i = table.getSelectedRow();
			if (i != -1) {
				String ma = txtID.getText();
				String ten = txtTenKh.getText();
				String diachi = txtDiachi.getText();
				String sdt = txtSdt.getText();
				String cmnd = txtCmnd.getText();
				KhachHang kh =new KhachHang(ma,ten,diachi,sdt,cmnd);
				try {
					if (dao.suaThongtinKhachHang(kh)) {
						clearTable();
						reloadData();
						JOptionPane.showMessageDialog(this, "Sửa thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Lỗi");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			
		}
			else {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần cập nhật thông tin");
			}
		}
		if(o.equals(btnXoa)) {
			int row = table.getSelectedRow();
			if (row != -1) {
				try {
						int xacnhan = JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn xóa khách hàng này", "Chú ý",
								JOptionPane.YES_NO_OPTION);
						if (xacnhan == JOptionPane.YES_OPTION) {
							if (dao.delKhachHang(txtID.getText())) {
								tableModel.removeRow(row);
								JOptionPane.showMessageDialog(this, "Xóa thành công!");
								reloadData();
							} 
							else {
								JOptionPane.showMessageDialog(this, "Xóa khách hàng " + txtID.getText() + " thành công!");
							}
						}
					}
				 catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng để xóa");
		}
		if(o.equals(btnCapNhat)) {
			XoaTrang();
		}
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	private void XoaTrang() {
		txtID.setText("");
		txtTenKh.setText("");
		txtDiachi.setText("");
		txtSdt.setText("");
		txtCmnd.setText("");
		
	}
}
