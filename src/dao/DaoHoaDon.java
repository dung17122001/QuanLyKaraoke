package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import connect.ConnectDB;
import gui.FormThongKeDoanhThu;


public class DaoHoaDon {
	public DaoHoaDon() {
		
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

	
}
