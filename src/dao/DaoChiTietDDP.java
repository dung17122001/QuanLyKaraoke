package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.ChiTietDDP;
import entity.DonDatPhong;

public class DaoChiTietDDP {
	public DaoChiTietDDP() {
		// TODO Auto-generated constructor stub
	}
	public boolean themChiTietDDP(ChiTietDDP ddp ) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into ChiTietDonDatPhong VALUES(?,?,?) ");
			ps.setString(1, ddp.getMaDDP());
			ps.setString(2, ddp.getPhong().getMaPhong());
			ps.setTime(3, ddp.getTime());
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
