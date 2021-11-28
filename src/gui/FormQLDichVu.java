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
import java.text.DecimalFormat;
import java.util.ArrayList;

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
import entity.DichVu;
import entity.LoaiDichVu;
import entity.LoaiPhong;
import entity.Phong;
import dao.DaoDichVu;
import dao.DaoLoaiDV;

public class FormQLDichVu extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnCapNhat;
	private JTextField txtGiaDV;
	private JTextField txtID;
	private JTextField txtTenDV;
	private JTextField txtDonViTinh;
	private JComboBox<String> cbLoaiDV;
	private DefaultTableModel tableModel;
	private DecimalFormat df = new DecimalFormat("#,### VNĐ");
	private DaoDichVu daoDichVu = new DaoDichVu();
	private DaoLoaiDV daoLoaiDV=new DaoLoaiDV();
	public FormQLDichVu() {
		setBounds(0, 0, 1366,768);
		setLayout(null);
		
		//connect database
		try {
			ConnectDB.getInstance().connect();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		JPanel pnTTNV = new JPanel();
		pnTTNV.setBackground(Color.WHITE);
		pnTTNV.setBorder(new TitledBorder(null, "THÔNG TIN DỊCH VỤ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTTNV.setBounds(0,0, 1366,190);
		pnTTNV.setLayout(null);
		add(pnTTNV);
		
		JLabel lbMadv = new JLabel("Mã DV: ");
		lbMadv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbMadv.setBounds(310, 30, 96, 38);
		pnTTNV.add(lbMadv);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(415, 30, 190, 30);
		pnTTNV.add(txtID);
		txtID.setColumns(10);
	
		JLabel lbTendv = new JLabel("Tên DV:");
		lbTendv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTendv.setBounds(705, 30, 96, 38);
		pnTTNV.add(lbTendv);
		
		txtTenDV = new JTextField();
		txtTenDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenDV.setBounds(815, 30, 190, 30);
		pnTTNV.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		JLabel lbDonViTinh = new JLabel("Đơn vị tính:");
		lbDonViTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbDonViTinh.setBounds(310, 80, 96, 38);
		pnTTNV.add(lbDonViTinh);
		
		txtDonViTinh = new JTextField();
		txtDonViTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDonViTinh.setBounds(415, 80, 190, 30);
		pnTTNV.add(txtDonViTinh);
		txtDonViTinh.setColumns(10);
		
		JLabel lbGiadv = new JLabel("Giá dịch vụ:");
		lbGiadv .setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGiadv .setBounds(705, 80, 96, 38);
		pnTTNV.add(lbGiadv );
		
		txtGiaDV = new JTextField();
		txtGiaDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGiaDV.setBounds(815, 80, 190, 30);
		pnTTNV.add(txtGiaDV);
		txtGiaDV.setColumns(10);
		
		JLabel lbLoaidv = new JLabel("Loại DV:");
		lbLoaidv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbLoaidv.setBounds(310, 130, 96, 38);
		pnTTNV.add(lbLoaidv);
		
		cbLoaiDV = new JComboBox<String>();
		cbLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbLoaiDV.setBounds(415, 130, 190, 30);
		pnTTNV.add(cbLoaiDV);
		
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
		
		JLabel lblDSNV = new JLabel("DANH SÁCH DỊCH VỤ:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(500,0, 500, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 300);
		panel.add(scrollPane);
		
		String[] header = {"Mã DV", "Tên DV","Đơn vị tính","Giá dịch vụ","Loại dịch vụ"};
		tableModel = new DefaultTableModel(header, 0){
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
					false, false, false,false,false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			};
		
		table = new JTable()
		{
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
					c.setBackground(row % 2 == 0 ? getBackground() : new Color(218, 223, 225));
				return c;
			}
			
            public boolean getScrollableTracksViewportWidth()
            {
                return getPreferredSize().width < getParent().getWidth();
            }
            @Override
            public void doLayout()
            {
                TableColumn resizingColumn = null;

                if (tableHeader != null)
                    resizingColumn = tableHeader.getResizingColumn();

                //  Viewport size changed. May need to increase columns widths

                if (resizingColumn == null)
                {
                    setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
                    super.doLayout();
                }

                //  Specific column resized. Reset preferred widths

                else
                {
                    TableColumnModel tcm = getColumnModel();

                    for (int i = 0; i < tcm.getColumnCount(); i++)
                    {
                        TableColumn tc = tcm.getColumn(i);
                        tc.setPreferredWidth( tc.getWidth() );
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
		
		/* //Add thông tin vào bảng
		try {
			dao_dichvu.loadData("select * from DichVu ", tableModel); 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		//Add thông tin vào bảng
		LoadTatCaDichVu();
		ThemDuLieuVaoCbLoaiDV();
		
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
		txtTenDV.setText(tableModel.getValueAt(i, 1).toString());
		txtDonViTinh.setText(tableModel.getValueAt(i,2).toString());
		txtGiaDV.setText(tableModel.getValueAt(i, 3).toString());
		cbLoaiDV.setSelectedItem(tableModel.getValueAt(i, 4).toString());
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
			String maDV=txtID.getText();
			String tenDV=txtTenDV.getText();
			String donVi=txtDonViTinh.getText();
			Double giaDV=Double.parseDouble(txtGiaDV.getText());
			String tenLoaiDV=cbLoaiDV.getSelectedItem().toString();
			
			
			LoaiDichVu ldv=daoLoaiDV.getLoaiDichVuTheoTen(tenLoaiDV);
			DichVu dv=new DichVu(maDV, tenDV,donVi, giaDV, ldv);
			
				if (daoDichVu.themDichVu(dv)) {
					clearTable();
					LoadTatCaDichVu();
					JOptionPane.showMessageDialog(this, "Thêm thành công");
				} else
					JOptionPane.showMessageDialog(this, "Lỗi");
		}
		if(o.equals(btnSua)) {
			
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn dịch vụ cần sửa");
			} else {
				String maDV=txtID.getText();
				String tenDV=txtTenDV.getText();
				String donVi=txtDonViTinh.getText();
				Double giaDV=Double.parseDouble(txtGiaDV.getText());
				String tenLoaiDV=cbLoaiDV.getSelectedItem().toString();
			
				LoaiDichVu ldv=daoLoaiDV.getLoaiDichVuTheoTen(tenLoaiDV);
				DichVu dv=new DichVu(maDV, tenDV,donVi, giaDV, ldv);
				
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn sửa dịch vụ này không ?", "Cảnh báo",
						JOptionPane.YES_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					daoDichVu.suaDichVu(dv);
					clearTable();
					LoadTatCaDichVu();
					JOptionPane.showMessageDialog(this, "Đã sửa");
					XoaTrang();
				}
				if(tl==JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(this, "Đã hủy");
				}
			}
			
		}
		if(o.equals(btnXoa)) {
			String maDV=txtID.getText();
			if (table.getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(this, "Hãy chọn dịch vụ cần xóa");
			} else {
				int tl;
				tl = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa dịch vụ này không ?", "Cảnh báo",
						JOptionPane.YES_OPTION);
				if (tl == JOptionPane.YES_OPTION) {
					daoDichVu.xoaDichVu(maDV);
					clearTable();
					LoadTatCaDichVu();
					JOptionPane.showMessageDialog(this, "Đã xóa");
				}
				if(tl==JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(this, "Đã hủy");
				}
			}
		}
		if(o.equals(btnCapNhat)) {
			XoaTrang();
		}
	}
	
	public void LoadTatCaDichVu() {
		ArrayList<DichVu> dsdv=new ArrayList<DichVu>();
		dsdv=daoDichVu.getTatCaDichVu();
		for(DichVu dv:dsdv) {
			LoaiDichVu ldv=new LoaiDichVu();
			ldv=daoLoaiDV.getDichVuTheoMa(dv.getLoaiDichVu().getMaLoai());
			tableModel.addRow(new Object[] {
					dv.getMaDichVu(),dv.getTenDichVu(),dv.getDonVi(),df.format(dv.getGiaTien()),ldv.getTenLoaiDV()
			});
		}
		
	}
	
	public void ThemDuLieuVaoCbLoaiDV() {
		ArrayList<LoaiDichVu> dsldv=new ArrayList<LoaiDichVu>();
		dsldv=daoLoaiDV.getTatCaLoaiDV();
		for(LoaiDichVu ldv: dsldv) {
			cbLoaiDV.addItem(ldv.getTenLoaiDV());
		}
	}

	private void clearTable() {
		while (table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	private void XoaTrang() {
		txtID.setText("");
		txtGiaDV.setText("");
		txtTenDV.setText("");
	}
}
