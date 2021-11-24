package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
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

import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;


public class FrmXuatHD extends JFrame implements Printable,ActionListener {

	private static JPanel contentPane;
	public static JTable table;
	public static JLabel lblQLT;
	public static JLabel lblDiaChi;
	public static JLabel lblDienThoai;
	public static JLabel lblMHDon ;
	public static JLabel lblHD;
	public static JLabel lblNgayLap;
	public static JLabel lblHoTenKH ;
	public static JLabel lblDiaChiKH;
	public static JLabel lbCMND;
	public static JLabel lblSDTKH;
	public static JLabel lblTenKH1;
	public static JLabel lblLoaiHD1;
	public static JLabel lblMaHD;
	public static JLabel lblNgayLap1;
	public static JLabel lblDCKH1 ;
	public static JLabel lbSoCMND ;
	public static JLabel lblsdtkh1;
	public static JLabel lblTongTien,lblTienNhan,lblTienThoi,lbTenNV;
	private static JPanel panel;
	public static DefaultTableModel tableModel ;
	public static int stt=1;
	private JLabel lbTN;
	private JLabel lbTThoi;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmXuatHD frame = new FrmXuatHD();
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
	public FrmXuatHD() {
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
		panel.setBounds(432, 11, 616, 724);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		lblQLT = new JLabel("KARAOKE NICE");
		lblQLT.setBounds(237, 10, 146, 27);
		lblQLT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblQLT.setForeground(new Color(255, 0, 0));
		panel.add(lblQLT);
		
		lblDiaChi = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChi.setBounds(33, 62, 75, 14);
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblDiaChi);
		
		lblDienThoai = new JLabel("\u0110i\u1EC7n tho\u1EA1i:");
		lblDienThoai.setBounds(33, 38, 75, 14);
		lblDienThoai.setForeground(Color.BLUE);
		lblDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblDienThoai);
		
		lblMHDon = new JLabel("M\u00E3 h\u00F3a \u0111\u01A1n:");
		lblMHDon.setBounds(33, 86, 75, 14);
		lblMHDon.setForeground(Color.BLUE);
		lblMHDon.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblMHDon);
		
		lblHD = new JLabel("HÓA ĐƠN THANH TOÁN");
		lblHD.setBounds(202, 111, 193, 35);
		lblHD.setHorizontalAlignment(SwingConstants.CENTER);
		lblHD.setForeground(new Color(0, 0, 255));
		lblHD.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(lblHD);
		
		lblNgayLap = new JLabel("Ng\u00E0y l\u1EADp:");
		lblNgayLap.setBounds(323, 83, 75, 20);
		lblNgayLap.setForeground(Color.BLUE);
		lblNgayLap.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		panel.add(lblNgayLap);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 145, 596, 84);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblHoTenKH = new JLabel("H\u1ECD t\u00EAn Kh\u00E1ch h\u00E0ng:");
		lblHoTenKH.setForeground(new Color(0, 0, 255));
		lblHoTenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblHoTenKH.setBounds(10, 11, 116, 14);
		panel_1.add(lblHoTenKH);
		
		lblDiaChiKH = new JLabel("\u0110\u1ECBa ch\u1EC9:");
		lblDiaChiKH.setForeground(Color.BLUE);
		lblDiaChiKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChiKH.setBounds(10, 61, 75, 14);
		panel_1.add(lblDiaChiKH);
		
		lbCMND = new JLabel("Số CMND: ");
		lbCMND.setForeground(Color.BLUE);
		lbCMND.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbCMND.setBounds(10, 35, 75, 14);
		panel_1.add(lbCMND);
		
		lblSDTKH = new JLabel("S\u1ED1 \u0111i\u1EC7n tho\u1EA1i:");
		lblSDTKH.setForeground(Color.BLUE);
		lblSDTKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblSDTKH.setBounds(296, 36, 106, 14);
		panel_1.add(lblSDTKH);
		
		lblTenKH1 = new JLabel("");
		lblTenKH1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTenKH1.setBounds(128, 12, 147, 14);
		panel_1.add(lblTenKH1);
		
		lbSoCMND = new JLabel("");
		lbSoCMND.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbSoCMND.setBounds(84, 37, 122, 14);
		panel_1.add(lbSoCMND);
		
		lblsdtkh1 = new JLabel("");
		lblsdtkh1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblsdtkh1.setBounds(380, 37, 122, 14);
		panel_1.add(lblsdtkh1);
		
		lblDCKH1 = new JLabel("");
		lblDCKH1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDCKH1.setBounds(66, 61, 482, 14);
		panel_1.add(lblDCKH1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new LineBorder(new Color(0, 0, 128), 1, true));
		scrollPane_1.setBounds(10, 239, 596, 308);
		panel.add(scrollPane_1);
		
		
		String[] tb = new String[] {"STT","Mã hàng hóa","Tên hàng hóa","Đơn Giá","Số Lượng","Thành Tiền"};

		tableModel = new DefaultTableModel(tb,0);
		table = new JTable(tableModel);
		table.setBackground(Color.WHITE);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(63);
		scrollPane_1.setViewportView(table);
		
		JLabel lblSDT1 = new JLabel("0385142640 - 0329218740");
		lblSDT1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSDT1.setBounds(117, 38, 199, 14);
		panel.add(lblSDT1);
		
		JLabel lblDiaChi1 = new JLabel("45 Nguyễn Thái Sơn - Gò Vấp - Tp. Hồ Chí Minh");
		lblDiaChi1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblDiaChi1.setBounds(118, 56, 342, 27);
		panel.add(lblDiaChi1);
		
		lblMaHD = new JLabel("");
		lblMaHD.setBounds(118, 87, 162, 14);
		panel.add(lblMaHD);
		
		lblLoaiHD1 = new JLabel("");
		lblLoaiHD1.setBounds(460, 52, 120, 14);
		panel.add(lblLoaiHD1);
		
		lblNgayLap1 = new JLabel("");
		lblNgayLap1.setBounds(386, 86, 126, 14);
		panel.add(lblNgayLap1);
		
		JLabel lblTT = new JLabel("Tổng tiền:");
		lblTT.setBounds(358, 557, 92, 24);
		panel.add(lblTT);
		lblTT.setForeground(Color.BLUE);
		lblTT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTongTien.setBounds(460, 557, 146, 24);
		panel.add(lblTongTien);
		lblTongTien.setHorizontalAlignment(SwingConstants.RIGHT);
		
		lbTThoi = new JLabel("Tiền thối lại:");
		lbTThoi.setForeground(Color.BLUE);
		lbTThoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbTThoi.setBounds(358, 625, 92, 24);
		panel.add(lbTThoi);
		
		lblTienThoi = new JLabel("");
		lblTienThoi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTienThoi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTienThoi.setBounds(460, 625, 146, 24);
		panel.add(lblTienThoi);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 659, 596, 31);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCamOn = new JLabel("Cảm ơn quý khách, hẹn gặp lại!");
		lblCamOn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCamOn.setBounds(210, 0, 233, 24);
		panel_2.add(lblCamOn);
		
		JLabel lblNewLabel = new JLabel("Nhân viên lập hóa đơn:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 690, 151, 24);
		panel.add(lblNewLabel);
		
		lbTenNV = new JLabel("");
		lbTenNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbTenNV.setBounds(152, 690, 131, 24);
		panel.add(lbTenNV);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(358, 591, 248, 24);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		lbTN = new JLabel("Tiền nhận:");
		lbTN.setBounds(0, 0, 69, 24);
		panel_3.add(lbTN);
		lbTN.setForeground(Color.BLUE);
		lbTN.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lblTienNhan = new JLabel("");
		lblTienNhan.setBounds(102, 0, 146, 24);
		panel_3.add(lblTienNhan);
		lblTienNhan.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblTienNhan.setHorizontalAlignment(SwingConstants.RIGHT);
		
	}
	
	public void printInHoaDon() {
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
}
