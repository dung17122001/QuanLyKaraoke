package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class DaoLoaiPhong {
	public DaoLoaiPhong() {
		// TODO Auto-generated constructor stub
	}
	
	public ArrayList<LoaiPhong> getTatCaLoaiPhong(){
		ArrayList<LoaiPhong> dsLoai= new ArrayList<LoaiPhong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[LoaiPhong]";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maLoaiPhong=rs.getString(1);
				String tenLoai=rs.getString(2);
				String moTa=rs.getString(3);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong, tenLoai, moTa);
				dsLoai.add(lp);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsLoai;	
	}
	
	public LoaiPhong getLoaiPhongTheoTen(String tenPhong) {
		LoaiPhong lp=new LoaiPhong();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[LoaiPhong] where [tenLoai] like N'" + tenPhong + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maLoaiPhong=rs.getString(1);
				String tenLoai=rs.getString(2);
				String moTa=rs.getString(3);
				lp.setMaLoaiPhong(maLoaiPhong);
				lp.setMoTa(moTa);
				lp.setTenLoai(tenLoai);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return lp;	
	}
	
	public LoaiPhong getLoaiPhongTheoMa(String maPhong) {
		LoaiPhong lp=new LoaiPhong();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[LoaiPhong] where [maLoaiPhong] = N'" + maPhong + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maLoaiPhong=rs.getString(1);
				String tenLoai=rs.getString(2);
				String moTa=rs.getString(3);
				lp.setMaLoaiPhong(maLoaiPhong);
				lp.setMoTa(moTa);
				lp.setTenLoai(tenLoai);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return lp;	
	}
	
	public boolean themLoaiPhong(LoaiPhong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into LoaiPhong VALUES(?,?,?) ");
			ps.setString(1, p.getMaLoaiPhong());
			ps.setString(2, p.getTenLoai());
			ps.setString(3, p.getMoTa());
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
	
	public boolean SuaPhong(LoaiPhong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement(
					"update LoaiPhong set tenLoai=?, moTa=? where maLoaiPhong=?");
			ps.setString(1, p.getTenLoai());
			ps.setString(2, p.getMoTa());
			ps.setString(3, p.getMaLoaiPhong());
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
	
	public boolean xoaLoaiPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("delete LoaiPhong where maLoaiPhong = ?");
			ps.setString(1, maPhong);
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
