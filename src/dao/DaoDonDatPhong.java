package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import connect.ConnectDB;
import entity.DonDatPhong;
import entity.LoaiPhong;
import entity.Phong;
import gui.FormNhanPhong;
import gui.FormTimHoaDon;

public class DaoDonDatPhong {

	public DaoDonDatPhong() {
	}
	
	public boolean themDonDatPhong(DonDatPhong ddp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into DonDatPhong VALUES(?,?,?,?) ");
			ps.setString(1, ddp.getMaDonDatPhong());
			ps.setDate(2, (Date) ddp.getThoiGianDat());
			ps.setString(3, ddp.getKhachHang().getMaKhachHang());
			ps.setString(4, ddp.getNhanVien().getMaNhanVien());
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
	
	public Time layGioDatPhong(String maPhong) {
		Time t = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement ps = null;
			String sql="select thoiGianDat\r\n"
					+ "FROM     ChiTietDonDatPhong INNER JOIN\r\n"
					+ "                  DonDatPhong ON ChiTietDonDatPhong.maDonDatPhong = DonDatPhong.maDonDatPhong INNER JOIN\r\n"
					+ "                  Phong ON ChiTietDonDatPhong.maPhong = Phong.maPhong\r\n"
					+ "				  where ngayDat='"+LocalDate.now()+"' and ChiTietDonDatPhong.maPhong=N'"+maPhong+"'";
			ps=con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				t=rs.getTime(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	public boolean updateTrangThaiPhong(Time time) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			String sql="update Phong set trinhTrang=N'Được đặt lúc "+time+"'"
					+ "FROM     ChiTietDonDatPhong INNER JOIN\r\n"
					+ "                  DonDatPhong ON ChiTietDonDatPhong.maDonDatPhong = DonDatPhong.maDonDatPhong INNER JOIN\r\n"
					+ "                  Phong ON ChiTietDonDatPhong.maPhong = Phong.maPhong\r\n"
					+ "				  where ngayDat='"+LocalDate.now()+"'";
			ps = con.prepareStatement(sql);
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
	
	public void getTatCaDonDatPhong(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Object [] ds = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			int i=1;
			String sql="SELECT KhachHang.tenKhachHang, KhachHang.soDienThoai, Phong.tenPhong, DonDatPhong.ngayDat, ChiTietDonDatPhong.thoiGianDat\r\n"
					+ "FROM     ChiTietDonDatPhong INNER JOIN\r\n"
					+ "                  DonDatPhong ON ChiTietDonDatPhong.maDonDatPhong = DonDatPhong.maDonDatPhong INNER JOIN\r\n"
					+ "                  KhachHang ON DonDatPhong.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n"
					+ "                  Phong ON ChiTietDonDatPhong.maPhong = Phong.maPhong where ngayDat between '"+LocalDate.now()+"' and '2100-12-1'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),rs.getString(3),simpleDateFormat.format(rs.getDate(4)),rs.getString(5)}; 
				FormNhanPhong.tableModel.addRow(ds);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public void getDonDatPhongTheoSDTorCMND(String text){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Object [] ds = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			int i=1;
			String sql="SELECT KhachHang.tenKhachHang, KhachHang.soDienThoai, Phong.tenPhong, DonDatPhong.ngayDat, ChiTietDonDatPhong.thoiGianDat\r\n"
					+ "FROM     ChiTietDonDatPhong INNER JOIN\r\n"
					+ "                  DonDatPhong ON ChiTietDonDatPhong.maDonDatPhong = DonDatPhong.maDonDatPhong INNER JOIN\r\n"
					+ "                  KhachHang ON DonDatPhong.maKhachHang = KhachHang.maKhachHang INNER JOIN\r\n"
					+ "                  Phong ON ChiTietDonDatPhong.maPhong = Phong.maPhong where ngayDat between '"+LocalDate.now()+"' and '2100-12-1' and soCMND='"+text+"' or soDienThoai='"+text+"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				ds = new Object [] {i++,rs.getString(1),rs.getString(2),rs.getString(3),simpleDateFormat.format(rs.getDate(4)),rs.getString(5)}; 
				FormNhanPhong.tableModel.addRow(ds);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
}
