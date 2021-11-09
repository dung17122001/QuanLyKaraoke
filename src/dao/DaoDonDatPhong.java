package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
