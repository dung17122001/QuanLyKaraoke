package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;

import connect.ConnectDB;
import entity.ChiTietHoaDonPhong;
import gui.FormTimHoaDon;

public class DaoCTHoaDonPhong {

	public DaoCTHoaDonPhong() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean themChiTietHDPhong(ChiTietHoaDonPhong hdp ) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into ChiTietHoaDonPhong VALUES(?,?,?,?) ");
			ps.setString(1, hdp.getHoaDon().getMaHoaDon());
			ps.setString(2, hdp.getPhong().getMaPhong());
			ps.setTime(3, hdp.getGioVao());
			ps.setTime(4, hdp.getGioRa());
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
	
	public boolean capNhatGioRa(String maHoaDon, Time time) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update ChiTietHoaDonPhong set gioRa='"+time+"' where maHoaDon=N'"+maHoaDon+"'\r\n"
					+ "");
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
	
	public Double soGioDaHat(String maHD) {
		Double gio=0.0;
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="select thoiGian=DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)\r\n"
					+ "from ChiTietHoaDonPhong where maHoaDon=N'"+maHD+"'\r\n"
					+ "";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				gio=rs.getDouble(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return gio;
	}
	
	public Double tinhTienPhong(String maHD) {
		Double tien=0.0;
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT tongtienphong=SUM([giaPhong]/60*(DATEDIFF(N,ChiTietHoaDonPhong.gioVao,ChiTietHoaDonPhong.gioRa)))\r\n"
					+ "FROM     ChiTietHoaDonPhong INNER JOIN\r\n"
					+ "                  Phong ON ChiTietHoaDonPhong.maPhong = Phong.maPhong \r\n"
					+ "where maHoaDon=N'"+maHD+"'\r\n"
					+ "group by maHoaDon\r\n"
					+ "";
			stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				tien=rs.getDouble(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return tien;
	}
	
}
