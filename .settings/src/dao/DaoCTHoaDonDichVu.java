package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connect.ConnectDB;
import entity.ChiTietHoaDonDichVu;
import entity.ChiTietHoaDonPhong;

public class DaoCTHoaDonDichVu {
	public DaoCTHoaDonDichVu() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean themChiTietHDDichVu(ChiTietHoaDonDichVu hddv ) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into ChiTietHoaDonDichVu VALUES(?,?,?) ");
			ps.setString(1, hddv.getHoaDon().getMaHoaDon());
			ps.setString(2, hddv.getDichVu().getMaDichVu());
			ps.setInt(3, hddv.getSoLuong());
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
	
	public Double tinhTienDichVu(String maHD) {
		Double tien=0.0;
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = null;
			String sql ="SELECT tongtiendv=sum([soLuong]*[giaTien])\r\n"
					+ "FROM     ChiTietHoaDonDichVu INNER JOIN\r\n"
					+ "                  DichVu ON ChiTietHoaDonDichVu.maDichVu = DichVu.maDichVu\r\n"
					+ "where maHoaDon=N'"+maHD+"'\r\n"
					+ "group by maHoaDon";
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
