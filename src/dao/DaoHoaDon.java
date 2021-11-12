package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;

import connect.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.Phong;
import gui.FormThongKeDoanhThu;
import gui.FormTimHoaDon;


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
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT Phong.maPhong, Phong.tenPhong, Phong.giaPhong, thoiGianTheoPhut=DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa) FROM Phong INNER JOIN ChiTietHoaDonPhong ON Phong.maPhong = ChiTietHoaDonPhong.maPhong INNER JOIN HoaDon ON "
					+ "ChiTietHoaDonPhong.maHoaDon = HoaDon.maHoaDon where HoaDon.ngayLap ='"+LocalDate.now()+"' and HoaDon.trangThai like N'Đã thanh toán'";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			int i=1;
			Object [] ds = null;
			while(rs.next()) {
				double giaTien=0.0;
				giaTien=rs.getDouble(3)*rs.getDouble(4)/60;
				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getDouble(4)/60+"h",tien.format(giaTien)}; 
				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
				
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	public void ThongKeDoanhThuPhongTheoTuan() {
//		DecimalFormat tien = new DecimalFormat("###,###,### VNĐ");
//		try {
//			Calendar ngayHienTai = Calendar.getInstance();
//	        Calendar ngayTruoc = Calendar.getInstance();
//			Connection con = ConnectDB.getCon();
//			PreparedStatement stmt = null;
//			String sql ="SELECT Phong.maPhong, Phong.tenPhong, Phong.giaPhong, thoiGianTheoPhut=DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa) FROM Phong INNER JOIN ChiTietHoaDonPhong ON Phong.maPhong = ChiTietHoaDonPhong.maPhong "
//					+ "INNER JOIN HoaDon ON ChiTietHoaDonPhong.maHoaDon = HoaDon.maHoaDon where HoaDon.ngayLap between '"+LocalDate.now()+"' and '"+ngayHienTai+"' and HoaDon.trangThai like N'Đã thanh toán'";
//			stmt = con.prepareStatement(sql);
//			ResultSet rs = stmt.executeQuery();
//			int i=1;
//			Object [] ds = null;
//			while(rs.next()) {
//				double giaTien=0.0;
//				giaTien=rs.getDouble(3)*rs.getDouble(4)/60;
//				ds = new Object [] { i++ ,rs.getString(1),rs.getString(2),tien.format(rs.getDouble(3)),rs.getDouble(4)/60+"h",tien.format(giaTien)}; 
//				FormThongKeDoanhThu.dfHangHoa.addRow(ds);
//				
//			}
//		}catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}

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
					+ "				  where HoaDon.maHoaDon=N'"+dk+"' or KhachHang.maKhachHang=N'"+dk+"' or KhachHang.soDienThoai=N'"+dk+"' or(Phong.tenPhong=N'"+dk+"' and HoaDon.trangThai=N'Chờ thanh toán')";
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
}
