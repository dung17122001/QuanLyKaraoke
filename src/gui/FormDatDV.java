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
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class FormDatDV extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnHuy;
	private DefaultTableModel dfPhong;
	private JTable tablePhong;
	private DefaultTableModel dfDichVu;
	private JTable tableDichVu;
	private DefaultTableModel tableModel;
	private Component sscrollDV;
	public FormDatDV() {
		setBounds(0, 0, 1366,768);
		setLayout(null);
		
		JPanel pnPDD = new JPanel();
		pnPDD.setBackground(Color.WHITE);
		pnPDD.setBorder(new TitledBorder(null, "PHÒNG ĐANG DÙNG", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnPDD.setBounds(0,0, 688,190);
		pnPDD.setLayout(null);
		add(pnPDD);
		
		String []header= {"Mã phòng","Tên phòng","Loại phòng"};
		dfPhong=new DefaultTableModel(header,0);
		tablePhong=new JTable(dfPhong);
		tablePhong.setRowHeight(20);
		JScrollPane scrollPhong;
		pnPDD.setLayout(null);
		scrollPhong=new JScrollPane(tablePhong,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPhong.setBounds(10, 20, 680, 170);
		scrollPhong.setBackground(new Color(248,248,248));
		pnPDD.add(scrollPhong);
		
		JPanel pnDSDVVD = new JPanel();
		pnDSDVVD.setBackground(Color.WHITE);
		pnDSDVVD.setBorder(new TitledBorder(null, "DANH SÁCH DỊCH VỤ VỪA ĐẶT", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDSDVVD.setBounds(689,0, 688,170);
		pnDSDVVD.setLayout(null);
		add(pnDSDVVD);
		
		String []header1= {"Mã dịch vụ","Tên dịch vụ","Thời gian đặt"};
		dfDichVu=new DefaultTableModel(header1,0);
		tableDichVu=new JTable(dfDichVu);
		tableDichVu.setRowHeight(20);
		JScrollPane scrollDichVu;
		pnPDD.setLayout(null);
		scrollDichVu=new JScrollPane(tableDichVu,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollDichVu.setBounds(10, 20, 650, 185);
		scrollDichVu.setBackground(new Color(248,248,248));
		pnDSDVVD.add(scrollDichVu);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBackground(Color.WHITE);
		pnChucNang.setBounds(0,190, 1366,40);
		pnChucNang.setLayout(null);
		add(pnChucNang);
		
		btnSua = new JButton("Đặt DV");
		btnSua.setForeground(SystemColor.controlText);
		btnSua.setBackground(new Color(255, 255, 153));
		btnSua.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnSua.setBounds(340, 10, 130, 30);
		btnSua.setFocusable(false);
		pnChucNang.add(btnSua);
		
		btnHuy = new JButton("Hủy DV");
		btnHuy.setForeground(SystemColor.controlText);
		btnHuy.setBackground(new Color(255, 255, 153));
		btnHuy.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnHuy.setBounds(590, 10, 130, 30);
		btnHuy.setFocusable(false);
		pnChucNang.add(btnHuy);
		
		btnLuu= new JButton("Lưu");
		btnLuu.setForeground(SystemColor.controlText);
		btnLuu.setBackground(new Color(255, 255, 153));
		btnLuu.setFont(new Font("Times New Roman", Font.PLAIN, 28));
		btnLuu.setBounds(840, 10, 130, 30);
		btnLuu.setFocusable(false);
		pnChucNang.add(btnLuu);

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
		
		String[] header2 = {"Mã DV", "Tên DV","Giá dịch vụ"};
		tableModel = new DefaultTableModel(header2, 0){
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
		
		btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLuu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHuy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		btnHuy.addActionListener(this);
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

