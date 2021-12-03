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
import entity.DonVi;
import entity.LoaiDichVu;
import dao.DaoDichVu;
import dao.DaoDonVi;
import dao.DaoKhachHang;
import dao.DaoLoaiDV;

public class FormTimKiemDV extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnTimKiem;
	private JButton btnCapNhat;
	private JTextField txtGiaDV;
	private JTextField txtID;
	private JTextField txtTenDV;
	private JComboBox<String> cbLoaiDV;
	private DefaultTableModel tableModel;
	private DecimalFormat df = new DecimalFormat("#,### VNĐ");
	private DaoDichVu daoDichVu = new DaoDichVu();
	private DaoLoaiDV daoLoaiDV=new DaoLoaiDV();
	private DaoDonVi daoDonVi=new DaoDonVi();
	
	public FormTimKiemDV() {
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
		pnTTNV.setBorder(new TitledBorder(null, "THÔNG TIN TÌM KIẾM", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTTNV.setBounds(0,0, 1366,190);
		pnTTNV.setLayout(null);
		add(pnTTNV);
		
		JLabel lblMaNV = new JLabel("Mã dịch vụ:");
		lblMaNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblMaNV.setBounds(20, 40, 200, 30);
		pnTTNV.add(lblMaNV);

		txtID= new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 24));
		txtID.setBounds(250, 40, 300, 30);
		pnTTNV.add(txtID);
		txtID.setColumns(10);
		
		
        
        JLabel lblTenNV = new JLabel("Tên dịch vụ:");
        lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblTenNV.setBounds(20, 100, 300, 30);
        pnTTNV.add(lblTenNV);

        txtTenDV = new JTextField();
        txtTenDV.setFont(new Font("Tahoma", Font.PLAIN, 24));
        txtTenDV.setBounds(250, 100, 300, 30);
        pnTTNV.add(txtTenDV);
		txtTenDV.setColumns(10);
		
		
        JLabel lblNsNV = new JLabel("Giá dịch vụ:");
        lblNsNV.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lblNsNV.setBounds(700, 40, 200, 30);
        pnTTNV.add(lblNsNV);

        txtGiaDV = new JTextField();
        txtGiaDV.setFont(new Font("Tahoma", Font.PLAIN, 24));
        txtGiaDV.setBounds(930, 40, 300, 30);
        pnTTNV.add(txtGiaDV);
		txtGiaDV.setColumns(10);
		
		JLabel lbTenLoai = new JLabel("Tên loại DV ");
		lbTenLoai.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lbTenLoai.setBounds(700, 100, 200, 30);
		pnTTNV.add(lbTenLoai);
		
		cbLoaiDV = new JComboBox<String>();
		cbLoaiDV.setFont(new Font("Tahoma", Font.PLAIN, 26));
		cbLoaiDV.setBounds(930, 100, 300, 30);
		pnTTNV.add(cbLoaiDV);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.WHITE);
		pnChucNang.setBounds(0,190, 1366,50);
		pnChucNang.setLayout(null);
		add(pnChucNang);
		
		
		btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(new Color(255, 204, 102));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnTimKiem.setBounds(450, 5, 180, 40);
		pnChucNang.add(btnTimKiem);
		
		btnCapNhat = new JButton("Tải lại");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnCapNhat.setBackground(new Color(255, 204, 102));
		btnCapNhat.setBounds(800, 5, 180, 40);
		pnChucNang.add(btnCapNhat);
		
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 260, 1366, 420);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH DỊCH VỤ:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(500,0, 500, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1350, 280);
		panel.add(scrollPane);
		
		String[] header = {"Mã DV", "Tên DV","Đơn vị","Giá dịch vụ","Loại dịch vụ"};
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
		LoadTatCaDichVu();
		ThemDuLieuVaoCbLoaiDV();
		
		btnTimKiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	
		btnTimKiem.addActionListener(this);
		btnCapNhat.addActionListener(this);
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
		Object o = e.getSource();
		if(o.equals(btnTimKiem)) {
			String timkiemma = txtID.getText().toLowerCase().trim();
			String timkiemten = txtTenDV.getText().toLowerCase().trim();
			String timkiemgia = txtGiaDV.getText().toLowerCase().trim();
			String timtenloaidv =(String) cbLoaiDV.getSelectedItem();
			
			//tim theo ma
			if (!timkiemma.equals("")) {
				tableModel.setRowCount(0);
				try {
					daoDichVu.loadData("select DichVu.maDichVu,DichVu.tenDichVu,DonVi.tenDonVi,DichVu.giaTien,LoaiDichVu.tenLoaiDV From ((DichVu  INNER JOIN DonVi ON DichVu.maDonVi = DonVi.maDonVi) INNER JOIN LoaiDichVu ON DichVu.maLoaiDV = LoaiDichVu.maLoaiDV) where maDichVu like N'%" + timkiemma + "%'", tableModel);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				txtID.setText("");
			} else {
				//tim theo ten 
				
				if (!timkiemten.equals("")) {
					tableModel.setRowCount(0);
					try {
						daoDichVu.loadData("select DichVu.maDichVu,DichVu.tenDichVu,DonVi.tenDonVi,DichVu.giaTien,LoaiDichVu.tenLoaiDV From ((DichVu  INNER JOIN DonVi ON DichVu.maDonVi = DonVi.maDonVi) INNER JOIN LoaiDichVu ON DichVu.maLoaiDV = LoaiDichVu.maLoaiDV) where tenDichVu like N'%" + timkiemten + "%'", tableModel);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					txtTenDV.setText("");
				} else {
					//timkiemgia
					
					if (!timkiemten.equals("")) {
						tableModel.setRowCount(0);
						try {
							daoDichVu.loadData("select DichVu.maDichVu,DichVu.tenDichVu,DonVi.tenDonVi,DichVu.giaTien,LoaiDichVu.tenLoaiDV From ((DichVu  INNER JOIN DonVi ON DichVu.maDonVi = DonVi.maDonVi) INNER JOIN LoaiDichVu ON DichVu.maLoaiDV = LoaiDichVu.maLoaiDV) where giaTien like N'%" + timkiemgia + "%'", tableModel);
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						txtGiaDV.setText("");
					} else {
						//timtenloaidv
						
						if (!timtenloaidv.equals("")) {
							tableModel.setRowCount(0);
							try {
								daoDichVu.loadData("select DichVu.maDichVu,DichVu.tenDichVu,DonVi.tenDonVi,DichVu.giaTien,LoaiDichVu.tenLoaiDV From ((DichVu  INNER JOIN DonVi ON DichVu.maDonVi = DonVi.maDonVi) INNER JOIN LoaiDichVu ON DichVu.maLoaiDV = LoaiDichVu.maLoaiDV)  where tenLoaiDV like N'%" + timtenloaidv + "%'", tableModel);
							} catch (SQLException e1) {
								e1.printStackTrace();
							}
							cbLoaiDV.setToolTipText("");
						} else {
							
							return;
					}
				return;
					}
			}
		}
		}
		
		if(o.equals(btnCapNhat)) {
			clearTable();
			LoadTatCaDichVu();
		}
	}
	
	public void LoadTatCaDichVu() {
		ArrayList<DichVu> dsdv=new ArrayList<DichVu>();
		dsdv=daoDichVu.getTatCaDichVu();
		for(DichVu dv:dsdv) {
			LoaiDichVu ldv=new LoaiDichVu();
			DonVi dvi= new DonVi();
			ldv=daoLoaiDV.getDichVuTheoMa(dv.getLoaiDichVu().getMaLoai());
			dvi=daoDonVi.getDonViTheoMa(dv.getDonVi().getMaDonVi());
			tableModel.addRow(new Object[] {
					dv.getMaDichVu(),dv.getTenDichVu(),dvi.getTenDonVi(),df.format(dv.getGiaTien()),ldv.getTenLoaiDV()
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

}

