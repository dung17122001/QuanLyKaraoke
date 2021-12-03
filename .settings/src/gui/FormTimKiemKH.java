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
import dao.DaoKhachHang;
import entity.KhachHang;

public class FormTimKiemKH extends JPanel implements ActionListener, MouseListener{

	private static final long serialVersionUID = 1L;
	private JTextField txtTimMaKH;
	private JTextField txtTimTenKH;
	private JTextField txtTimSdtKH;
	private JTextField txtTimSocmKH;
	private JTextField txtTimDiaChi;
	private JButton btnTimKiem;
	private JButton btnCapNhat,btnLapHoaDon,btnDatPhong;
	private JTable table;
	private DefaultTableModel tableModel;
	private DaoKhachHang dao = new DaoKhachHang();
	
	public FormTimKiemKH() {
		
		setBounds(0, 0, 1366, 766);
		setLayout(null);
		
		//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
		DaoKhachHang dao_khachhang = new DaoKhachHang(); 
				
		JPanel pnTimKiem = new JPanel();
		pnTimKiem.setBackground(Color.WHITE);
		pnTimKiem.setBorder(new TitledBorder(null, "THÔNG TIN TÌM KIẾM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTimKiem.setBounds(0,0, 1366,210);
		pnTimKiem.setLayout(null);
		add(pnTimKiem);
		
		JLabel lblMaKH = new JLabel("Mã khách hàng:");
		lblMaKH.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaKH.setBounds(50, 50, 300, 30);
		pnTimKiem.add(lblMaKH);

		txtTimMaKH = new JTextField();
		txtTimMaKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimMaKH.setBounds(300, 50, 300, 30);
		pnTimKiem.add(txtTimMaKH);
		txtTimMaKH.setColumns(10);
		
	    
        JLabel lblTenKH = new JLabel("Tên khách hàng:");
        lblTenKH.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTenKH.setBounds(50, 100, 300, 30);
        pnTimKiem.add(lblTenKH);

		txtTimTenKH = new JTextField();
		txtTimTenKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimTenKH.setBounds(300, 100, 300, 30);
		pnTimKiem.add(txtTimTenKH);
		txtTimTenKH.setColumns(10);
	
        JLabel lblDiaChi = new JLabel("Địa chỉ:");
        lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblDiaChi.setBounds(50, 150, 300, 30);
        pnTimKiem.add(lblDiaChi);

        txtTimDiaChi = new JTextField();
        txtTimDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 24));
        txtTimDiaChi.setBounds(300, 150, 900, 30);
		pnTimKiem.add(txtTimDiaChi);
		txtTimDiaChi.setColumns(10);
	    
		
        JLabel lblSdt = new JLabel("Số điện thoại:");
        lblSdt.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblSdt.setBounds(700, 50, 300, 30);
        pnTimKiem.add(lblSdt);

		txtTimSdtKH = new JTextField();
		txtTimSdtKH.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSdtKH.setBounds(900, 50, 300, 30);
		pnTimKiem.add(txtTimSdtKH);
		txtTimSdtKH.setColumns(10);
        
		
        JLabel lblCmnd = new JLabel("CMND:");
        lblCmnd.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblCmnd.setBounds(700, 100, 300, 30);
        pnTimKiem.add(lblCmnd);

		txtTimSocmKH = new JTextField();
		txtTimSocmKH .setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtTimSocmKH .setBounds(900, 100, 300, 30);
		pnTimKiem.add(txtTimSocmKH );
		txtTimSocmKH .setColumns(10);
		
		
        JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.WHITE);
		pnChucNang.setBounds(0,210, 1366,50);
		pnChucNang.setLayout(null);
		add(pnChucNang);
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setForeground(SystemColor.controlText);
		btnTimKiem.setBackground(new Color(255, 255, 153));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTimKiem.setBounds(143, 5, 180, 40);
		btnTimKiem.setFocusable(false);
		pnChucNang.add(btnTimKiem);
		
		btnCapNhat= new JButton("Tải lại");
		btnCapNhat.setForeground(SystemColor.controlText);
		btnCapNhat.setBackground(new Color(255, 255, 153));
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCapNhat.setBounds(450, 5, 180, 40);
		btnCapNhat.setFocusable(false);
		pnChucNang.add(btnCapNhat);
		
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnDatPhong = new JButton("Đặt phòng");
		btnDatPhong.setForeground(Color.BLACK);
		btnDatPhong.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnDatPhong.setFocusable(false);
		btnDatPhong.setBackground(new Color(255, 255, 153));
		btnDatPhong.setBounds(750, 5, 180, 40);
		pnChucNang.add(btnDatPhong);
		
		btnLapHoaDon = new JButton("Lập hóa đơn");
		btnLapHoaDon.setForeground(Color.BLACK);
		btnLapHoaDon.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnLapHoaDon.setFocusable(false);
		btnLapHoaDon.setBackground(new Color(255, 255, 153));
		btnLapHoaDon.setBounds(1052, 5, 205, 40);
		pnChucNang.add(btnLapHoaDon);
		
		btnLapHoaDon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDatPhong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnTimKiem.addActionListener(this);
		btnCapNhat.addActionListener(this);
		btnLapHoaDon.addActionListener(this);
		btnDatPhong.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 260, 1366, 420);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSKH = new JLabel("DANH SÁCH KHÁCH HÀNG:");
		lblDSKH.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSKH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSKH.setBounds(500,0, 500, 40);
		panel.add(lblDSKH);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 280);
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
		
	}
	public void actionPerformed(ActionEvent e) {
		
		Object o = e.getSource();
		if (o.equals(btnTimKiem)) {
			String timkiemma = txtTimMaKH.getText().toLowerCase().trim();
			String timkiemten = txtTimTenKH.getText().toLowerCase().trim();
			String timkiemdc = txtTimDiaChi.getText().toLowerCase().trim();
			String timkiemsdt = txtTimSdtKH.getText().toLowerCase().trim();
			String timsocmnd = txtTimSocmKH.getText().toLowerCase().trim();
			//tim theo ma 
			
				if (!timkiemma.equals("")) {
					tableModel.setRowCount(0);
					try {
						dao.loadData("select * from KhachHang where maKhachHang like N'%" + timkiemma + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTimMaKH.setText("");
				} else {
					//tim theo ten 
					
					if (!timkiemten.equals("")) {
						tableModel.setRowCount(0);
						try {
							dao.loadData("select * from KhachHang where tenKhachHang like N'%" + timkiemten + "%'", tableModel);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						txtTimTenKH.setText("");
					} else {
						//tim theo dia chi
						
						if (!timkiemdc.equals("")) {
							tableModel.setRowCount(0);
							try {
								dao.loadData("select * from KhachHang where diaChi like N'%" + timkiemdc + "%'", tableModel);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							txtTimDiaChi.setText("");
						} else {
							//tim theo sdt 
							
							if (!timkiemsdt.equals("")) {
								tableModel.setRowCount(0);
								try {
									dao.loadData("select * from KhachHang where soDienThoai like N'%" + timkiemsdt + "%'", tableModel);
								} catch (SQLException e1) {
									e1.printStackTrace();
								}
								txtTimSdtKH.setText("");
							} else {
								//tim theo soCMND 
								
								if (!timsocmnd.equals("")) {
									tableModel.setRowCount(0);
									try {
										dao.loadData("select * from KhachHang where soCMND like N'%" + timsocmnd + "%'", tableModel);
									} catch (SQLException e1) {
										e1.printStackTrace();
									}
									txtTimSocmKH.setText("");
								} else {
									JOptionPane.showMessageDialog(this, "Nhập thông tin cần tìm", "Lỗi",
											JOptionPane.ERROR_MESSAGE);
									return;
								}
							
							}
						}
					}
				}		
		}
		if(o.equals(btnCapNhat)) {
			reloadData();
		}
		if(o.equals(btnDatPhong)) {
			int i=table.getSelectedRow();
			if(i==-1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần đặt phòng");
			}
			else {
				
				try {
					FormGiaoDienChinh.changeScreen(new FormDatPhong());
					FormDatPhong.khachHang=dao.getKhachHangByMaKhachHang(tableModel.getValueAt(i, 0).toString());
					//KhachHang kh=dao.getKhachHangByMaKhachHang(tableModel.getValueAt(i, 0).toString());
					FormDatPhong.lbTenKhachHang.setText(FormDatPhong.khachHang.getTenKhachHang());
					FormDatPhong.lbSDT.setText(FormDatPhong.khachHang.getSoDienThoai());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			
		}
		if(o.equals(btnLapHoaDon)) {
			int i=table.getSelectedRow();
			if(i==-1) {
				JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần lập hóa đơn");
			}
			else {
				try {
					FormGiaoDienChinh.changeScreen(new FormLapHD());
					FormLapHD.khachHang=dao.getKhachHangByMaKhachHang(tableModel.getValueAt(i, 0).toString());
					//KhachHang kh=dao.getKhachHangByMaKhachHang(tableModel.getValueAt(i, 0).toString());
					FormLapHD.lbTenKhachHang.setText(FormLapHD.khachHang.getTenKhachHang());
					FormLapHD.lbSDT.setText(FormLapHD.khachHang.getSoDienThoai());
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
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
		DaoKhachHang dao_khachhang = new DaoKhachHang();
		try {
			tableModel.setRowCount(0);
			dao_khachhang.loadData("select * from KhachHang ", tableModel);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
