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

public class FormQLDichVu extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtTimkiem;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnTim;
	private JButton btnTinhLuong;
	private JButton btnXoarong;
	private JTextField txtTenKh;
	private JTextField txtID;
	private JTextField txtCmnd;
	private JTextField txtDiachi;
	private JTextField txtSdt;
	private DefaultTableModel tableModel;
	public FormQLDichVu() {
		setBounds(0, 0, 1366,768);
		setLayout(null);
		
		JPanel pnTTNV = new JPanel();
		pnTTNV.setBackground(Color.WHITE);
		pnTTNV.setBorder(new TitledBorder(null, "THÔNG TIN DỊCH VỤ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTTNV.setBounds(0,0, 1366,190);
		pnTTNV.setLayout(null);
		add(pnTTNV);
		
		JLabel lbManv = new JLabel("Mã DV: ");
		lbManv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbManv.setBounds(10, 27, 96, 38);
		pnTTNV.add(lbManv);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(116, 31, 190, 30);
		pnTTNV.add(txtID);
		txtID.setColumns(10);
		
		JLabel lbTennv = new JLabel("Gía tiền:");
		lbTennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTennv.setBounds(10, 80, 96, 38);
		pnTTNV.add(lbTennv);
		
		txtTenKh = new JTextField();
		txtTenKh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKh.setBounds(501, 30, 190, 30);
		pnTTNV.add(txtTenKh);
		txtTenKh.setColumns(10);
		
		
		
		JLabel lbSdt = new JLabel("Tên DV:");
		lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSdt.setBounds(405, 24, 96, 38);
		pnTTNV.add(lbSdt);
		
		txtDiachi = new JTextField();
		txtDiachi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiachi.setBounds(116, 83, 190, 30);
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
		btnThem.setBounds(10, 10, 100, 30);
		btnThem.setFocusable(false);
		pnChucNang.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setForeground(SystemColor.controlText);
		btnSua.setBackground(new Color(255, 255, 153));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnSua.setBounds(120, 10, 100, 30);
		btnSua.setFocusable(false);
		pnChucNang.add(btnSua);
		
		btnXoa = new JButton("Xóa");
		btnXoa.setForeground(SystemColor.controlText);
		btnXoa.setBackground(new Color(255, 255, 153));
		btnXoa.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnXoa.setBounds(230, 10, 100, 30);
		btnXoa.setFocusable(false);
		pnChucNang.add(btnXoa);
		
		btnXoarong= new JButton("Xóa rỗng");
		btnXoarong.setForeground(SystemColor.controlText);
		btnXoarong.setBackground(new Color(255, 255, 153));
		btnXoarong.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnXoarong.setBounds(340, 10, 160, 30);
		btnXoarong.setFocusable(false);
		pnChucNang.add(btnXoarong);
		
		txtTimkiem = new JTextField();
		txtTimkiem.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		txtTimkiem.setBounds(800, 10, 400, 30);
		pnChucNang.add(txtTimkiem);
		txtTimkiem.setColumns(10);
		
		btnTim = new JButton("Tìm kiếm");
		btnTim.setFont(new Font("Times New Roman", Font.PLAIN, 26));
		btnTim.setBackground(new Color(255, 204, 102));
		btnTim.setBounds(1200, 10, 150, 30);
		pnChucNang.add(btnTim);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 230, 1368, 768);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH DỊCH VỤ:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(20,0, 380, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1366, 820);
		panel.add(scrollPane);
		
		String[] header = {"Mã DV", "Tên DV","Giá tiền"};
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
		
		btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTim.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoarong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnThem.addActionListener(this);
		btnSua.addActionListener(this);
		btnXoa.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoarong.addActionListener(this);
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
		// TODO Auto-generated method stub
		
	}

}
