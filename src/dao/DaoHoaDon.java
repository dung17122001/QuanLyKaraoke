package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JOptionPane;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;
import gui.FormThongKeDoanhThu;
import gui.FormThongKeKhachHang;
import gui.FormThongKeNV;
import gui.FormTimHoaDon;
import gui.FrmXuatHD;


public class DaoHoaDon {
	public DaoHoaDon() {
		
	}
	
	public boolean themHoaDon(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into HoaDon VALUES(?,?,?,?,?)");
			ps.setString(1, hd.getMaHoaDon());
			ps.setDate(2, hd.getNgayLap());
			ps.setString(3, hd.getTrangThai());
			ps.setString(4, hd.getKhachHang().getMaKhachHang());
			ps.setString(5, hd.getNhanVien().getMaNhanVien());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public void ThongKeDoanhThuPhongTheoNgay() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT Phong.maPhong, Phong.tenPhong, Phong.giaPhong, SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))as tgtheophut FROM Phong INNER JOIN ChiTietHoaDonPhong ON Phong.maPhong = ChiTietHoaDonPhong.maPhong INNER JOIN HoaDon ON ChiTietHoaDonPhong.maHoaDon = HoaDon.maHoaDon\r\n"
					+ "where HoaDon.ngayLap ='"+LocalDate.now()+"' and HoaDon.trangThai like N'Đã thanh toán' group by  Phong.maPhong, Phong.tenPhong, Phong.giaPhong order by giaPhong*SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				double giaTien=0.0;
				giaTien=rs.getDouble(3)*rs.getDouble(4)/60;
				FormThongKeDoanhThu.tongTienPhong=FormThongKeDoanhThu.tongTienPhong+giaTien;
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),sl.format(rs.getDouble(4)/60)+" h",tien.format(giaTien)}; 
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeDoanhThuPhongTheoTuan() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT Phong.maPhong, Phong.tenPhong, Phong.giaPhong, SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)) as tgtheophut FROM Phong INNER JOIN ChiTietHoaDonPhong ON Phong.maPhong = ChiTietHoaDonPhong.maPhong "
					+ "INNER JOIN HoaDon ON ChiTietHoaDonPhong.maHoaDon = HoaDon.maHoaDon where HoaDon.ngayLap between '"+dateFormat.format(c1.getTime())+"' and '"+dateFormat.format(c2.getTime())+"' and HoaDon.trangThai like N'Đã thanh toán'"
							+ "group by  Phong.maPhong, Phong.tenPhong, Phong.giaPhong order by giaPhong*SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				double giaTien=0.0;
				giaTien=rs.getDouble(3)*rs.getDouble(4)/60;
				FormThongKeDoanhThu.tongTienPhong=FormThongKeDoanhThu.tongTienPhong+giaTien;
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),sl.format(rs.getDouble(4)/60)+" h",tien.format(giaTien)}; 
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeDoanhThuPhongTheoThang() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT Phong.maPhong, Phong.tenPhong, Phong.giaPhong, SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))as tgtheophut FROM Phong INNER JOIN ChiTietHoaDonPhong ON Phong.maPhong = ChiTietHoaDonPhong.maPhong INNER JOIN HoaDon ON ChiTietHoaDonPhong.maHoaDon = HoaDon.maHoaDon\r\n"
					+ "where MONTH(HoaDon.ngayLap)="+LocalDate.now().getMonthValue()+" and HoaDon.trangThai like N'Đã thanh toán' group by  Phong.maPhong, Phong.tenPhong, Phong.giaPhong order by giaPhong*SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				double giaTien=0.0;
				giaTien=rs.getDouble(3)*rs.getDouble(4)/60;
				FormThongKeDoanhThu.tongTienPhong=FormThongKeDoanhThu.tongTienPhong+giaTien;
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),sl.format(rs.getDouble(4)/60)+" h",tien.format(giaTien)}; 
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeDoanhThuPhongTheoNam() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT Phong.maPhong, Phong.tenPhong, Phong.giaPhong, SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))as tgtheophut FROM Phong INNER JOIN ChiTietHoaDonPhong ON Phong.maPhong = ChiTietHoaDonPhong.maPhong INNER JOIN HoaDon ON ChiTietHoaDonPhong.maHoaDon = HoaDon.maHoaDon\r\n"
					+ "where YEAR(HoaDon.ngayLap)="+LocalDate.now().getYear()+" and HoaDon.trangThai like N'Đã thanh toán' group by  Phong.maPhong, Phong.tenPhong, Phong.giaPhong order by giaPhong*SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				double giaTien=0.0;
				giaTien=rs.getDouble(3)*rs.getDouble(4)/60;
				FormThongKeDoanhThu.tongTienPhong=FormThongKeDoanhThu.tongTienPhong+giaTien;
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),sl.format(rs.getDouble(4)/60)+" h",tien.format(giaTien)}; 
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeDoanhThuDichVuTheoNgay() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien, SUM(ChiTietHoaDonDichVu.soLuong), thanhtien=SUM(ChiTietHoaDonDichVu.soLuong)*giaTien\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where HoaDon.ngayLap='"+LocalDate.now()+"' and HoaDon.trangThai=N'Đã thanh toán'"
					+ " group by DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien"
					+ " order by thanhtien desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getInt(4),tien.format(rs.getDouble(5))}; 
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				FormThongKeDoanhThu.tongTienDV=FormThongKeDoanhThu.tongTienDV+rs.getDouble(5);
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void ThongKeDoanhThuDichVuTheoTuan() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="\r\n"
					+ "SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien,SUM(soLuong) as sl, thanhtien=SUM(soLuong)*giaTien\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where HoaDon.ngayLap between'"+dateFormat.format(c1.getTime())+"' and '"+dateFormat.format(c2.getTime())+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien"
					+ " order by thanhtien desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getInt(4),tien.format(rs.getDouble(5))};
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				FormThongKeDoanhThu.tongTienDV=FormThongKeDoanhThu.tongTienDV+rs.getDouble(5);
			}
			FormThongKeDoanhThu.stt=i;
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeDoanhThuDichVuTheoThang() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien,SUM(soLuong) as sl, thanhtien=SUM(soLuong)*giaTien\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where MONTH(HoaDon.ngayLap)="+LocalDate.now().getMonthValue()+" and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien"
					+ " order by thanhtien desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getInt(4),tien.format(rs.getDouble(5))};
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				FormThongKeDoanhThu.tongTienDV=FormThongKeDoanhThu.tongTienDV+rs.getDouble(5);
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeDoanhThuDichVuTheoNam() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat sl = new DecimalFormat("### 0.0");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien,SUM(soLuong) as sl, thanhtien=SUM(soLuong)*giaTien\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where YEAR(HoaDon.ngayLap)="+LocalDate.now().getYear()+" and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien"
					+ " order by thanhtien desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=FormThongKeDoanhThu.stt;
			Object [] ds = null;
			while(rs.next()) {
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getInt(4),tien.format(rs.getDouble(5))};
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				FormThongKeDoanhThu.tongTienDV=FormThongKeDoanhThu.tongTienDV+rs.getDouble(5);
			}
			FormThongKeDoanhThu.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void LayHoaDonChoThanhToan() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DISTINCT  HoaDon.maHoaDon, Phong.tenPhong, KhachHang.tenKhachHang, ChiTietHoaDonPhong.gioVao, HoaDon.trangThai\r\n"
					+ "FROM     KhachHang INNER JOIN\r\n"
					+ "                  HoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon ON KhachHang.maKhachHang = HoaDon.maKhachHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong\r\n"
					+ "				  where HoaDon.trangThai=N'Chờ thanh toán'\r\n"
					+ "";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			while(rs.next()) {
				ds = new Object [] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getTime(4),rs.getString(5)}; 
				FormTimHoaDon.dfHoaDon.addRow(ds);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void LayThongTinPhongTuHoaDonDaTraPhong(String maHD) {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat df=new DecimalFormat("###.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT ChiTietHoaDonPhong.maPhong, Phong.tenPhong, Phong.giaPhong\r\n"
					+ "FROM     ChiTietHoaDonPhong INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong\r\n"
					+ "where maHoaDon='"+maHD+"'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			int i=1;
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),df.format(FormTimHoaDon.gioDaHat)+" h",tien.format(rs.getDouble(3)*FormTimHoaDon.gioDaHat)}; 
				FormTimHoaDon.dfHangHoa.addRow(ds);
				
			}
			FormTimHoaDon.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void LayThongTinPhongTuHoaDon(String maHD) {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat df=new DecimalFormat("###.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT ChiTietHoaDonPhong.maPhong, Phong.tenPhong, Phong.giaPhong\r\n"
					+ "FROM     ChiTietHoaDonPhong INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong\r\n"
					+ "where maHoaDon='"+maHD+"'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			int i=1;
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),0+" h",tien.format(0)}; 
				FormTimHoaDon.dfHangHoa.addRow(ds);
				
			}
			FormTimHoaDon.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//in
	public void LayThongTinPhongTuHoaDonChoHoaDon(String maHD) {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat df=new DecimalFormat("###.0");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT ChiTietHoaDonPhong.maPhong, Phong.tenPhong, Phong.giaPhong\r\n"
					+ "FROM     ChiTietHoaDonPhong INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong\r\n"
					+ "where maHoaDon='"+maHD+"'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			int i=1;
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),df.format(FormTimHoaDon.gioDaHat)+" h",tien.format(rs.getDouble(3)*FormTimHoaDon.gioDaHat)}; 
				FrmXuatHD.tableModel.addRow(ds);
				
			}
			FrmXuatHD.stt=i;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void LayThongTinDichVuTuHoaDon(String maHD) {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien, ChiTietHoaDonDichVu.soLuong, thanhtien=soLuong*giaTien\r\n"
					+ "FROM     ChiTietHoaDonDichVu INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu where maHoaDon='"+maHD+"'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			int i=FormTimHoaDon.stt;
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getInt(4),tien.format(rs.getDouble(5))}; 
				FormTimHoaDon.dfHangHoa.addRow(ds);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//in
	public void LayThongTinDichVuTuHoaDonChoHoaDon(String maHD) {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DichVu.maDichVu, DichVu.tenDichVu, DichVu.giaTien, ChiTietHoaDonDichVu.soLuong, thanhtien=soLuong*giaTien\r\n"
					+ "FROM     ChiTietHoaDonDichVu INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu where maHoaDon='"+maHD+"'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			int i=FrmXuatHD.stt;
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getInt(4),tien.format(rs.getDouble(5))}; 
				FrmXuatHD.tableModel.addRow(ds);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void layGioVaoTheoHoaDon(String maHD) {
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="select DISTINCT gioVao from [dbo].[ChiTietHoaDonPhong] where maHoaDon=N'"+maHD+"'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				FormTimHoaDon.gioVao=rs.getTime(1);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean capNhatSoLuongDV(String maHD,String maDV,int sl) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update [dbo].[ChiTietHoaDonDichVu] set soLuong=soLuong+"+sl+" where maDichVu=N'"+maDV+"' and maHoaDon=N'"+maHD+"'");
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public boolean capNhatTrangThaiHoaDon(String maHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update [dbo].[HoaDon] set trangThai=N'Đã thanh toán' where maHoaDon=N'"+maHD+"'");
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	
	public void LayHoaDonTheoDK(String dk) {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT DISTINCT  HoaDon.maHoaDon, Phong.tenPhong, KhachHang.tenKhachHang, ChiTietHoaDonPhong.gioVao, HoaDon.trangThai\r\n"
					+ "FROM     KhachHang INNER JOIN\r\n"
					+ "                  HoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon ON KhachHang.maKhachHang = HoaDon.maKhachHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong\r\n"
					+ "				  where HoaDon.maHoaDon=N'"+dk+"' or KhachHang.maKhachHang=N'"+dk+"' or KhachHang.soDienThoai=N'"+dk+"' or(Phong.tenPhong=N'"+dk+"' and HoaDon.trangThai=N'Chờ thanh toán') and HoaDon.trangThai=N'Chờ thanh toán'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			Object [] ds = null;
			while(rs.next()) {
				ds = new Object [] {rs.getString(1),rs.getString(2),rs.getString(3),rs.getTime(4),rs.getString(5)}; 
				FormTimHoaDon.dfHoaDon.addRow(ds);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeKhachHangTheoNgay() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi,sogio=SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)),tongtienphong=SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "tongtiendv=sum([soLuong]*[giaTien])\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where HoaDon.ngayLap='"+LocalDate.now()+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi order by SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0.0;
				tongTien=rs.getDouble(6)+rs.getDouble(7);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),gio.format(rs.getDouble(5)/60),tien.format(tongTien)}; 
				FormThongKeKhachHang.dfKhachHang.addRow(ds);
			}
			FormThongKeKhachHang.sokh=i-1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeKhachHangTheoTuan() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi,sogio=SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)),tongtienphong=SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "tongtiendv=sum([soLuong]*[giaTien])\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where HoaDon.ngayLap between'"+dateFormat.format(c1.getTime())+"' and '"+dateFormat.format(c2.getTime())+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi order by SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0.0;
				tongTien=rs.getDouble(6)+rs.getDouble(7);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),gio.format(rs.getDouble(5)/60),tien.format(tongTien)}; 
				FormThongKeKhachHang.dfKhachHang.addRow(ds);
			}
			FormThongKeKhachHang.sokh=i-1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeKhachHangTheoThang() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi,sogio=SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)),tongtienphong=SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "tongtiendv=sum([soLuong]*[giaTien])\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where MONTH(HoaDon.ngayLap)='"+LocalDate.now().getMonthValue()+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi order by SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0.0;
				tongTien=rs.getDouble(6)+rs.getDouble(7);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),gio.format(rs.getDouble(5)/60),tien.format(tongTien)}; 
				FormThongKeKhachHang.dfKhachHang.addRow(ds);
			}
			FormThongKeKhachHang.sokh=i-1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeKhachHangTheoNam() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi,sogio=SUM(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)),tongtienphong=SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "tongtiendv=sum([soLuong]*[giaTien])\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  KhachHang ON HoaDon.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where YEAR(HoaDon.ngayLap)='"+LocalDate.now().getYear()+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by KhachHang.maKhachHang,KhachHang.tenKhachHang,KhachHang.soDienThoai,KhachHang.diaChi order by SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0.0;
				tongTien=rs.getDouble(6)+rs.getDouble(7);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),gio.format(rs.getDouble(5)/60),tien.format(tongTien)}; 
				FormThongKeKhachHang.dfKhachHang.addRow(ds);
			}
			FormThongKeKhachHang.sokh=i-1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeNhanVienTheoNgay() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai,COUNT(NhanVien.maNhanVien) as slhd,sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "sum([soLuong]*[giaTien])\r\n"
					+ "FROM     NhanVien INNER JOIN\r\n"
					+ "                  HoaDon ON NhanVien.maNhanVien = HoaDon.maNhanVien INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where HoaDon.ngayLap='"+LocalDate.now()+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai\r\n"
					+ "				  order by sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+\r\n"
					+ "					sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0.0;
				tongTien=tongTien+rs.getDouble(6)+rs.getDouble(5);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),tien.format(tongTien)}; 
				FormThongKeNV.dfNhanVien.addRow(ds);
				FormThongKeNV.shd=FormThongKeNV.shd+rs.getInt(4);
				FormThongKeNV.tongTien=FormThongKeNV.tongTien+tongTien;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeNhanVienTheoTuan() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        Date date = Date.valueOf(LocalDate.now());
        c1.setTime(date);
        c2.setTime(date);
        c1.roll(Calendar.DATE, -7);
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai,COUNT(NhanVien.maNhanVien) as slhd,sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "sum([soLuong]*[giaTien])\r\n"
					+ "FROM     NhanVien INNER JOIN\r\n"
					+ "                  HoaDon ON NhanVien.maNhanVien = HoaDon.maNhanVien INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where HoaDon.ngayLap between'"+dateFormat.format(c1.getTime())+"' and '"+dateFormat.format(c2.getTime())+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai\r\n"
					+ "				  order by sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+\r\n"
					+ "					sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0;
				tongTien=rs.getDouble(6)+rs.getDouble(5);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),tien.format(tongTien)}; 
				FormThongKeNV.dfNhanVien.addRow(ds);
				FormThongKeNV.shd=FormThongKeNV.shd+rs.getInt(4);
				FormThongKeNV.tongTien=FormThongKeNV.tongTien+tongTien;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeNhanVienTheoThang() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai,COUNT(NhanVien.maNhanVien) as slhd,sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "sum([soLuong]*[giaTien])\r\n"
					+ "FROM     NhanVien INNER JOIN\r\n"
					+ "                  HoaDon ON NhanVien.maNhanVien = HoaDon.maNhanVien INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where MONTH(HoaDon.ngayLap)='"+LocalDate.now().getMonthValue()+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai\r\n"
					+ "				  order by sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+\r\n"
					+ "					sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0;
				tongTien=rs.getDouble(6)+rs.getDouble(5);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),tien.format(tongTien)}; 
				FormThongKeNV.dfNhanVien.addRow(ds);
				FormThongKeNV.shd=FormThongKeNV.shd+rs.getInt(4);
				FormThongKeNV.tongTien=FormThongKeNV.tongTien+tongTien;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void ThongKeNhanVienTheoNam() {
		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
		DecimalFormat gio=new DecimalFormat("0.0 h");
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai,COUNT(NhanVien.maNhanVien) as slhd,sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa))),\r\n"
					+ "sum([soLuong]*[giaTien])\r\n"
					+ "FROM     NhanVien INNER JOIN\r\n"
					+ "                  HoaDon ON NhanVien.maNhanVien = HoaDon.maNhanVien INNER JOIN\r\n"
					+ "                  ChiTietHoaDonPhong ON HoaDon.maHoaDon = ChiTietHoaDonPhong.maHoaDon INNER JOIN\r\n"
					+ "                  ChiTietHoaDonDichVu ON HoaDon.maHoaDon = ChiTietHoaDonDichVu.maHoaDon INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "				  where YEAR(HoaDon.ngayLap)='"+LocalDate.now().getYear()+"' and HoaDon.trangThai=N'Đã thanh toán'\r\n"
					+ "				  group by NhanVien.maNhanVien, NhanVien.tenNhanVien, NhanVien.dienThoai\r\n"
					+ "				  order by sum([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))+\r\n"
					+ "					sum([soLuong]*[giaTien]) desc";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double tongTien=0;
				tongTien=rs.getDouble(6)+rs.getDouble(5);
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4),tien.format(tongTien)}; 
				FormThongKeNV.dfNhanVien.addRow(ds);
				FormThongKeNV.shd=FormThongKeNV.shd+rs.getInt(4);
				FormThongKeNV.tongTien=FormThongKeNV.tongTien+tongTien;
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}