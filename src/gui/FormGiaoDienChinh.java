package gui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class FormGiaoDienChinh extends JFrame  implements ActionListener, MouseListener {
	private static final long serialVersionUID = -1554680235689968471L;
	private JPanel contentPane;
	private JLabel txtUsername;
	private static JPanel panel_Manage;
	private JMenuBar menuBar;
	private JMenu mnQLNhanVien;
	private JMenu mnQLKhachHang;
	private JMenuItem mntmSuaNV;
	private JMenuItem mntmTimKiemNV;
	private JMenuItem mntmChucVu;
	private JMenuItem mntmSuaKH;
	private JMenuItem mntmTimKiemKH;
	private JMenu mnQlDichVu;
	private JMenuItem mntmSuaDV;
	private JMenuItem mntmTimKiemDV;
	private JMenuItem mntmThemLDV;
	private JMenuItem mntmThemDonVi;
	private JMenu mnQLPhong;
	private JMenuItem mntmCapNhatPhong;
	private JMenuItem mntmTimPhong;
	private JMenu mnQLHoaDon;
	private JMenuItem mntmThemHoaDon;
	private JMenuItem mntmThemDonDatPhong;
	private JMenuItem mntmTimKiemHoaDon;
	private JMenu mnQLThongKe;
	private JMenuItem mntmThongKeDoanhThu;
	private JMenuItem mntmThongKeKH;
	private JMenuItem mntmThongKeNV,mntmLoaiPhong;
	private JButton btnDangXuat;
	
	public FormGiaoDienChinh(){
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnQLNhanVien = new JMenu("Nhân Viên");
		mnQLNhanVien.setIcon(new ImageIcon("img\\nhanvien.jpg"));
		mnQLNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		menuBar.add(mnQLNhanVien);
		
		mntmSuaNV = new JMenuItem("Cập nhật nhân viên");
		mntmSuaNV.setIcon(new ImageIcon("img\\sua.png"));
		mntmSuaNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLNhanVien.add(mntmSuaNV);
		
		mntmTimKiemNV = new JMenuItem("Tìm kiếm");
		mntmTimKiemNV.setIcon(new ImageIcon("img\\timkiem.png"));
		mntmTimKiemNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLNhanVien.add(mntmTimKiemNV);
		
		mntmChucVu = new JMenuItem("Chức vụ");
		mntmChucVu.setIcon(new ImageIcon("img\\sua.png"));
		mntmChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLNhanVien.add(mntmChucVu);
		
		mnQLKhachHang = new JMenu("Khách Hàng");
		mnQLKhachHang.setIcon(new ImageIcon("img\\img\\icon1.png"));
		mnQLKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		menuBar.add(mnQLKhachHang);
		
		mntmSuaKH = new JMenuItem("Cập nhật khách hàng");
		mntmSuaKH.setIcon(new ImageIcon("img\\sua.png"));
		mntmSuaKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLKhachHang.add(mntmSuaKH);
		
		mntmTimKiemKH = new JMenuItem("Tìm kiếm");
		mntmTimKiemKH.setIcon(new ImageIcon("img\\timkiem.png"));
		mntmTimKiemKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLKhachHang.add(mntmTimKiemKH);
		
		mnQlDichVu = new JMenu("Dịch vụ");
		mnQlDichVu.setIcon(new ImageIcon("img\\img\\icon2.png"));
		mnQlDichVu.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		menuBar.add(mnQlDichVu);
		
		mntmSuaDV = new JMenuItem("Cập nhật dịch vụ");
		mntmSuaDV.setIcon(new ImageIcon("img\\sua.png"));
		mntmSuaDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQlDichVu.add(mntmSuaDV);
		
		mntmTimKiemDV = new JMenuItem("Tìm kiếm");
		mntmTimKiemDV.setIcon(new ImageIcon("img\\timkiem.png"));
		mntmTimKiemDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQlDichVu.add(mntmTimKiemDV);
		
		mntmThemLDV = new JMenuItem("Loại dịch vụ");
		mntmThemLDV.setIcon(new ImageIcon("img\\sua.png"));
		mntmThemLDV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQlDichVu.add(mntmThemLDV);
		
		mntmThemDonVi = new JMenuItem("Đơn vị");
		mntmThemDonVi.setIcon(new ImageIcon("img\\sua.png"));
		mntmThemDonVi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQlDichVu.add(mntmThemDonVi);
		
		
		mnQLPhong = new JMenu("Phòng");
		mnQLPhong.setIcon(new ImageIcon("img\\icon3.png"));
		mnQLPhong.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		menuBar.add(mnQLPhong);
		
		mntmCapNhatPhong = new JMenuItem("Cập nhật phòng");
		mntmCapNhatPhong.setIcon(new ImageIcon("img\\sua.png"));
		mntmCapNhatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(mntmCapNhatPhong);
		
		mntmLoaiPhong = new JMenuItem("Cập nhật loại phòng");
		mntmLoaiPhong.setIcon(new ImageIcon("img\\sua.png"));
		mntmLoaiPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(mntmLoaiPhong);
		
		mntmTimPhong = new JMenuItem("Tìm kiếm");
		mntmTimPhong.setIcon(new ImageIcon("img\\timkiem.png"));
		mntmTimPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(mntmTimPhong);
		
		mnQLHoaDon = new JMenu("Hóa đơn");
		mnQLHoaDon.setIcon(new ImageIcon("img\\hoadon.png"));
		mnQLHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		menuBar.add(mnQLHoaDon);
		
		mntmThemHoaDon = new JMenuItem("Lập hóa đơn");
		mntmThemHoaDon.setIcon(new ImageIcon("img\\them.jpg"));
		mntmThemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLHoaDon.add(mntmThemHoaDon);
		
		mntmThemDonDatPhong = new JMenuItem("Thêm đơn đặt phòng");
		mntmThemDonDatPhong.setIcon(new ImageIcon("img\\them.jpg"));
		mntmThemDonDatPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLPhong.add(mntmThemDonDatPhong);
		
		mntmTimKiemHoaDon = new JMenuItem("Thanh toán");
		mntmTimKiemHoaDon.setIcon(new ImageIcon("img\\timkiem.png"));
		mntmTimKiemHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLHoaDon.add(mntmTimKiemHoaDon);
		
		mnQLThongKe = new JMenu("Thống kê");
		mnQLThongKe.setIcon(new ImageIcon("img\\thongke.jpg"));
		mnQLThongKe.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		menuBar.add(mnQLThongKe);
		
		mntmThongKeDoanhThu = new JMenuItem("Thống kê doanh thu");
		mntmThongKeDoanhThu.setIcon(new ImageIcon("img\\dthu.png"));
		mntmThongKeDoanhThu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLThongKe.add(mntmThongKeDoanhThu);
		
		mntmThongKeKH = new JMenuItem("Thống kê khách hàng");
		mntmThongKeKH.setIcon(new ImageIcon("img\\khachhang.png"));
		mntmThongKeKH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLThongKe.add(mntmThongKeKH);
		
		mntmThongKeNV = new JMenuItem("Thống kê nhân viên");
		mntmThongKeNV.setIcon(new ImageIcon("img\\nhanvien.png"));
		mntmThongKeNV.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		mnQLThongKe.add(mntmThongKeNV);
		
		//Thêm sự kiện
		mntmSuaDV.addActionListener(this);
		mntmSuaKH.addActionListener(this);
		mntmSuaNV.addActionListener(this);
		mntmThemDonDatPhong.addActionListener(this);
		mntmThemHoaDon.addActionListener(this);
		mntmCapNhatPhong.addActionListener(this);
		mntmThongKeDoanhThu.addActionListener(this);
		mntmThongKeKH.addActionListener(this);
		mntmThongKeNV.addActionListener(this);
		mntmTimKiemDV.addActionListener(this);
		mntmTimKiemHoaDon.addActionListener(this);
		mntmTimKiemKH.addActionListener(this);
		mntmTimKiemNV.addActionListener(this);
		mntmTimPhong.addActionListener(this);
		mntmChucVu.addActionListener(this);
		mntmLoaiPhong.addActionListener(this);
		mntmThemDonVi.addActionListener(this);
		mntmThemLDV.addActionListener(this);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBounds(0, 0, 1366,768);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1352, 129);
		panel.setBackground(new Color(204,204,204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		setTitle("Quản lý karaoke Nice");
		setSize(1366,768);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		JLabel lblTieuDe = new JLabel("Karaoke Nice");
		lblTieuDe.setForeground(Color.BLUE);
		lblTieuDe.setFont(new Font("Times New Roman", Font.BOLD, 70));
		lblTieuDe.setBounds(500,20, 500, 50);
		panel.add(lblTieuDe);
		
		try {
			setIconImage(ImageIO.read(new File("img/logo.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			BufferedImage image = ImageIO.read(new File("img/logo.png")); 
			Area clip = new Area( new Rectangle(0, 0,0, 0) ); 
			Area oval = new Area( new Ellipse2D.Double(0,0, 0, 0) ); 
			clip.subtract( oval ); //Khung ảnh
			Graphics g2d = image.createGraphics(); 
			g2d.setClip(clip); //Ảnh đại diện admin
			g2d.setColor(new Color(0, 0, 255));
			g2d.fillRect(0, 0, image.getWidth(), image.getHeight()); 
			JLabel lblImage = new JLabel();
			lblImage.setIcon(new ImageIcon(image));
			lblImage.setBackground(SystemColor.control);
			lblImage.setBounds(0,-22, 250, 165);
			panel.add(lblImage);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		JLabel lblUser = new JLabel("Người dùng:");
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblUser.setBounds(1071, 39, 120, 31);
		panel.add(lblUser);
		
		txtUsername = new JLabel("NV001");
		txtUsername.setForeground(Color.WHITE);
		txtUsername.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		txtUsername.setBounds(1201, 39, 128, 31);
		panel.add(txtUsername);
		
		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon("img\\dangxuat.jpg"));
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDangXuat.setBounds(1069, 85, 182, 40);
		btnDangXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnDangXuat);
		panel.revalidate();
		panel.repaint();
		
		panel_Manage = new JPanel();
		panel_Manage.setBounds(0, 129, 1352, 565);
		contentPane.add(panel_Manage);
		panel_Manage.setLayout(null);
		
	}
	public static void changeScreen(JPanel newScreen) {

		panel_Manage.removeAll();
		panel_Manage.add(newScreen);
		panel_Manage.repaint();
		panel_Manage.revalidate();

	}

	public static void main(String[] args) throws SQLException {	
		FormGiaoDienChinh frm = new FormGiaoDienChinh();
		frm.setVisible(true);
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
		Object o=e.getSource();
		if(o.equals(mntmSuaNV)) {
			changeScreen(new FormQLNhanVien());
		}
		if(o.equals(mntmTimKiemNV)) {
			changeScreen(new FormTimKiemNV());
			
		}
		if(o.equals(mntmChucVu)) {
			changeScreen(new FormThemCV());
			
		}
		if(o.equals(mntmSuaKH)) {
			changeScreen(new FormQLKhachHang());
		}
		if(o.equals(mntmTimKiemKH)) {
			changeScreen(new FormTimKiemKH());
		}
		if(o.equals(mntmSuaDV)) {
			changeScreen(new FormQLDichVu());
		}
		
		if(o.equals(mntmTimKiemDV)) {
			changeScreen(new FormTimKiemDV());
		}
		
		if(o.equals(mntmThemLDV)) {
			changeScreen(new FormLoaiDV());
		}
		if(o.equals(mntmThemDonVi)) {
			changeScreen(new FormDonVi());
		}
		if(o.equals(mntmCapNhatPhong)) {
			changeScreen(new FormQLPhong());
		}
		if(o.equals(mntmTimPhong)) {
			changeScreen(new FormTimPhong());
		}
		if(o.equals(mntmThemHoaDon)) {
			changeScreen(new FormLapHD());
		}
		if(o.equals(mntmThemDonDatPhong)) {
			changeScreen(new FormDatPhong());
		}
		if(o.equals(mntmTimKiemHoaDon)) {
			changeScreen(new FormTimHoaDon());
		}
		if(o.equals(mntmThongKeDoanhThu)) {
			changeScreen(new FormThongKeDoanhThu());
		}
		if(o.equals(mntmThongKeKH)) {
			changeScreen(new FormThongKeKhachHang());
		}
		if(o.equals(mntmThongKeNV)) {
			changeScreen(new FormThongKeNV());
		}
		if(o.equals(mntmLoaiPhong)) {
			changeScreen(new FormLoaiPhong());
		}
		
	}
}