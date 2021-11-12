package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connect.ConnectDB;


public class PhatSinhMa {
	
	public String maPhong() {
		String maphong="";
		try {
			ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select CONCAT('P', RIGHT(CONCAT('000',ISNULL(right(max(maPhong),3),0) + 1),3)) from [dbo].[Phong] where maPhong like N'P%'";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next())
		{
			maphong = rs.getString(1);
		}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return maphong;
	}
	
	public String maDonDatPhong() {
		String maddp="";
		try {
			ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select CONCAT('DDP', RIGHT(CONCAT('000',ISNULL(right(max(maDonDatPhong),3),0) + 1),3)) from [dbo].[DonDatPhong] where maDonDatPhong like N'DDP%'";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next())
		{
			maddp = rs.getString(1);
		}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return maddp;
	}
	
	public String maKhachHang() {
		String makh="";
		try {
			ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select CONCAT('KH', RIGHT(CONCAT('000',ISNULL(right(max(maKhachHang),3),0) + 1),3)) from [dbo].[KhachHang] where maKhachHang like N'KH%'";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next())
		{
			makh = rs.getString(1);
		}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return makh;
	}
	
	//lấy mã KH lớn nhất
	public String maKhachHangVuaThem() {
		String makh="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		try {
		String sql = "select CONCAT('KH', RIGHT(CONCAT('000',ISNULL(right(max(maKhachHang),3),0)),3)) from [dbo].[KhachHang] where maKhachHang like N'KH%'";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next())
		{
			makh = rs.getString(1);
		}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return makh;
	}
	
	public String maHoaDon() {
		String mahd="";
		try {
			ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select CONCAT('HD', RIGHT(CONCAT('000',ISNULL(right(max(maHoaDon),3),0) + 1),3)) from dbo.HoaDon where maHoaDon like N'HD%' ";
		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(sql);
		while(rs.next())
		{
			mahd = rs.getString(1);
		}
		} catch (SQLException e) {
			// TODO: handle 
			e.printStackTrace();
		}
		return mahd;
	}
}
