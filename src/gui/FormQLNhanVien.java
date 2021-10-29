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

public class FormQLNhanVien extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnSua;
	private JButton btnXoarong;
	private JButton btnLuu;
	private JTextField txtTenNv;
	private JTextField txtID;
	private JTextField txtNgaySinh;
	private JTextField txtGioitinh;
	private JTextField txtCmnd;
	private JTextField txtChucVu;
	private JTextField txtSdt;
	private DefaultTableModel tableModel;
	public FormQLNhanVien() {
		setBounds(0, 0, 1352, 539);
		setLayout(null);
		
		JPanel pnTTNV = new JPanel();
		pnTTNV.setBackground(Color.WHITE);
		pnTTNV.setBorder(new TitledBorder(null, "THÔNG TIN NHÂN VIÊN", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnTTNV.setBounds(0,0, 1366,190);
		pnTTNV.setLayout(null);
		add(pnTTNV);
		
		JLabel lbManv = new JLabel("Mã NV: ");
		lbManv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbManv.setBounds(10, 27, 96, 38);
		pnTTNV.add(lbManv);
		
		txtID = new JTextField();
		txtID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtID.setBounds(116, 31, 190, 30);
		pnTTNV.add(txtID);
		txtID.setColumns(10);
		
		JLabel lbTennv = new JLabel("Tên NV: ");
		lbTennv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbTennv.setBounds(405, 24, 96, 38);
		pnTTNV.add(lbTennv);
		
		txtTenNv = new JTextField();
		txtTenNv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNv.setBounds(501, 30, 190, 30);
		pnTTNV.add(txtTenNv);
		txtTenNv.setColumns(10);
		
		JLabel lbGt = new JLabel("Giới tính:");
		lbGt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbGt.setBounds(855, 24, 96, 38);
		pnTTNV.add(lbGt);
		
		txtGioitinh = new JTextField();
		txtGioitinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGioitinh.setBounds(955, 30, 190, 30);
		pnTTNV.add(txtGioitinh);
		txtGioitinh.setColumns(10);
		
		JLabel lbNs = new JLabel("Ngày sinh:");
		lbNs.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbNs.setBounds(10, 80, 96, 38);
		pnTTNV.add(lbNs);
		
		txtNgaySinh = new JTextField();
		txtNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNgaySinh.setBounds(116, 83, 190, 30);
		pnTTNV.add(txtNgaySinh);
		txtNgaySinh.setColumns(10);
		
		JLabel lbScm = new JLabel("Số CMND:");
		lbScm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbScm.setBounds(405, 80, 96, 30);
		pnTTNV.add(lbScm);
		
		txtCmnd = new JTextField();
		txtCmnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtCmnd.setBounds(501, 83, 190, 30);
		pnTTNV.add(txtCmnd);
		txtCmnd.setColumns(10);
		
		JLabel lbSdt = new JLabel("Số điện thoại:");
		lbSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbSdt.setBounds(855, 83, 190, 30);
		pnTTNV.add(lbSdt);
		
		txtSdt = new JTextField();
		txtSdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSdt.setBounds(955, 88, 190, 30);
		pnTTNV.add(txtSdt);
		txtSdt.setColumns(10);
		
		JLabel lbCv = new JLabel("Chức vụ: ");
		lbCv.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbCv.setBounds(10, 137, 96, 38);
		pnTTNV.add(lbCv);
		
		txtChucVu = new JTextField();
		txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChucVu.setBounds(116, 140, 190, 30);
		pnTTNV.add(txtChucVu);
		txtChucVu.setColumns(10);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.WHITE);
		pnChucNang.setBounds(0,190, 1366,40);
		pnChucNang.setLayout(null);
		add(pnChucNang);
		
		btnSua = new JButton("Cập nhật");
		btnSua.setForeground(SystemColor.controlText);
		btnSua.setBackground(new Color(255, 255, 153));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnSua.setBounds(10, 10, 150, 30);
		btnSua.setFocusable(false);
		pnChucNang.add(btnSua);
		
		btnXoarong= new JButton("Xóa rỗng");
		btnXoarong.setForeground(SystemColor.controlText);
		btnXoarong.setBackground(new Color(255, 255, 153));
		btnXoarong.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnXoarong.setBounds(170, 10, 150, 30);
		btnXoarong.setFocusable(false);
		pnChucNang.add(btnXoarong);
		
		btnLuu= new JButton("Lưu");
		btnLuu.setForeground(SystemColor.controlText);
		btnLuu.setBackground(new Color(255, 255, 153));
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnLuu.setBounds(330, 10, 150, 30);
		btnLuu.setFocusable(false);
		pnChucNang.add(btnLuu);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 238, 204));
		panel.setBounds(0, 230, 1368, 768);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblDSNV = new JLabel("DANH SÁCH NHÂN VIÊN:");
		lblDSNV.setHorizontalAlignment(SwingConstants.LEFT);
		lblDSNV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblDSNV.setBounds(20,0, 380, 40);
		panel.add(lblDSNV);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 30, 1366, 820);
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
		
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnXoarong.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLuu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnSua.addActionListener(this);
		btnXoarong.addActionListener(this);
		btnLuu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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