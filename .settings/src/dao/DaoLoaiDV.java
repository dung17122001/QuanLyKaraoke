package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.ChucVu;
import entity.LoaiDichVu;

public class DaoLoaiDV {
	
	public DaoLoaiDV() {
		
	}
	
	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maLoaiDV")); 
			vector.add(rs.getString("tenLoaiDV")); 
			tableModel.addRow(vector);
		}
	}
	
	public ArrayList<LoaiDichVu> getTatCaLoaiDV(){
		ArrayList<LoaiDichVu> dsLDV= new ArrayList<LoaiDichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[LoaiDichVu]";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				LoaiDichVu loaiDichVu=new LoaiDichVu(maDichVu, tenDichVu);
				dsLDV.add(loaiDichVu);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsLDV;	
	}

	public LoaiDichVu getDichVuTheoMa(String maLoai) {
		LoaiDichVu ldv=new LoaiDichVu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[LoaiDichVu] where [maLoaiDV] = N'" + maLoai + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maLoaiDV=rs.getString(1);
				String tenLoai=rs.getString(2);
				ldv.setMaLoai(maLoaiDV);
				ldv.setTenLoaiDV(tenLoai);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return ldv;	
	}
	public LoaiDichVu getLoaiDichVuTheoTen(String tenDichVu) {
		LoaiDichVu ldv=new LoaiDichVu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[LoaiDichVu] where [tenLoaiDV] like N'" + tenDichVu + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maLoaiDV=rs.getString(1);
				String tenLoai=rs.getString(2);
				ldv.setMaLoai(maLoaiDV);
				ldv.setTenLoaiDV(tenLoai);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return ldv;	
	}
	//thêm
	public boolean themLoaiDichVu(LoaiDichVu ldv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into LoaiDichVu(maLoaiDV, tenLoaiDV) VALUES(?,?)");
			ps.setString(1,ldv.getMaLoai());
			ps.setString(2,ldv.getTenLoaiDV());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				ps.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return n > 0;
	}
	//Sua
		public boolean suaLoaiDichVu(LoaiDichVu ldv) {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement ps = null;
			int n = 0;
			try {
				ps = con.prepareStatement("update LoaiDichVu set tenLoaiDV=? where maLoaiDV=?");
				ps.setString(1,ldv.getTenLoaiDV());
				ps.setString(2,ldv.getMaLoai());
				n = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					ps.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			return n > 0;
		}
	//xoa
			public boolean delLoaiDichVu(String maLoaiDV) throws SQLException {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getCon();
				try {
					PreparedStatement ps = con.prepareStatement("delete from LoaiDichVu where maLoaiDV=?");
					ps.setString(1, maLoaiDV);
					int n = ps.executeUpdate();
					if (n > 0) {
						return true;
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
}
