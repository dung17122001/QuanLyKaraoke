package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.UIDefaults;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.DaoHoaDon;
import entity.KhachHang;
import entity.NhanVien;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;


public class FormInThongKeKH extends JFrame implements Printable,ActionListener {

	private static JPanel contentPane;
	public static JTable table;
	public static JLabel lblQLT;
	public static JLabel lblDiaChi;
	public static JLabel lblDienThoai;
	public static JLabel lblHD;
	public static JLabel lblLoaiHD1;
	public static JLabel lblThoiGian,lblTenNV;
	private static JPanel panel;
	public static DefaultTableModel tableModel ;
	public static int stt=1;
	
	private DaoHoaDon daoHoaDon=new DaoHoaDon();
	private JPanel panel_1;
	private JLabel lblNV;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormInThongKeKH frame = new FormInThongKeKH();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormInThongKeKH() {
		setTitle("HÓA ĐƠN KARAOKE NICE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setSize( 1199, 775);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.setBounds(286, 11, 899, 724);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		lblQLT = new JLabel("KARAOKE NICE");
		lblQLT.setBounds(388, 10, 146, 27);
		lblQLT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQLT.setForeground(Color.BLACK);
		panel.add(lblQLT);
		
		lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setBounds(33, 62, 75, 14);
		lblDiaChi.setForeground(Color.BLACK);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDiaChi);
		
		lblDienThoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i:");
		lblDienThoai.setBounds(33, 38, 75, 14);
		lblDienThoai.setForeground(Color.BLACK);
		lblDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDienThoai);
		
		lblHD = new JLabel("THỐNG KÊ NHÂN VIÊN");
		lblHD.setBounds(358, 113, 207, 35);
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHD.setForeground(Color.BLACK);
		lblHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblHD);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane_1.setBounds(10, 195, 866, 471);
		panel.add(scrollPane_1);
		
		
		String[] tb = new String[] {"STT","Mã nhân viên","Tên nhân viên","Số điện thoại","Số hóa đơn đã lập", "Tổng tiền hóa đơn"};

		tableModel = new DefaultTableModel(tb,0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane_1.setViewportView(table);
		
		JLabel lblSDT1 = new JLabel("0385142640 - 0329218740");
		lblSDT1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT1.setBounds(118, 38, 199, 14);
		panel.add(lblSDT1);
		
		JLabel lblDiaChi1 = new JLabel("45 Nguyễn Thái Sơn - Gò Vấp - Tp. Hồ Chí Minh");
		lblDiaChi1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChi1.setBounds(118, 56, 342, 27);
		panel.add(lblDiaChi1);
		
		lblLoaiHD1 = new JLabel("");
		lblLoaiHD1.setBounds(460, 52, 120, 14);
		panel.add(lblLoaiHD1);
		
		JLabel lblTG = new JLabel("Thời gian thống kê:");
		lblTG.setForeground(Color.BLACK);
		lblTG.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTG.setBounds(33, 164, 151, 14);
		panel.add(lblTG);
		
		lblThoiGian = new JLabel("");
		lblThoiGian.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblThoiGian.setBounds(186, 158, 342, 27);
		panel.add(lblThoiGian);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setLayout(null);
		panel_1.setBounds(10, 676, 396, 38);
		panel.add(panel_1);
		
		lblNV = new JLabel("Nhân viên lập báo cáo: ");
		lblNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNV.setBounds(10, 10, 136, 17);
		panel_1.add(lblNV);
		
		lblTenNV = new JLabel("");
		lblTenNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenNV.setBounds(179, 10, 168, 17);
		panel_1.add(lblTenNV);
		
		setTableAlternateRow();
	}
	
	public void printInThongKe() {
		PrinterJob job = PrinterJob.getPrinterJob();
		job.setPrintable(this);
		boolean ok = job.printDialog();
		if(ok) {
			try {
				job.print();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
			Graphics2D g2d = (Graphics2D) graphics;
			if(pageIndex>0) {
				return NO_SUCH_PAGE;
			}
			g2d.translate(pageFormat.getImageableX(),pageFormat.getImageableY());
			panel.printAll(graphics);
			return PAGE_EXISTS;
		}
	
	public static void clearTable() {
		while (table.getRowCount() > 0) {
			tableModel.removeRow(0);
		}
	}
	public void setTableAlternateRow() {
		UIDefaults defaults = UIManager.getLookAndFeelDefaults();
		if (defaults.get("Table.alternateRowColor") == null)
			defaults.put("Table.alternateRowColor", new Color(218, 223, 225));
	}
}
