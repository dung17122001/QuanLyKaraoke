package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Calendar;

import connect.ConnectDB;
import entity.DonDatPhong;
import entity.Phong;

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
	
	public boolean updateTrangThaiPhong() {
		Calendar c = Calendar.getInstance();
//        Date date = Date.valueOf(LocalDate.now());
//        c.setTime(date);
        Time time=new Time(c.getTime().getHours(), c.getTime().getMinutes(), 0);
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
}
