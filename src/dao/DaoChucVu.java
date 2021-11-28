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
import entity.LoaiPhong;
import entity.NhanVien;

public class DaoChucVu {

	public DaoChucVu() {
	}
	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maChucVu")); 
			vector.add(rs.getString("tenChucVu"));  
			tableModel.addRow(vector);
		}
	}
	public ArrayList<ChucVu> getTatCaLoaiCV(){
		ArrayList<ChucVu> dsCV= new ArrayList<ChucVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[ChucVu]";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maChucVu=rs.getString(1);
				String tenChucVu=rs.getString(2);
				ChucVu cv=new ChucVu(maChucVu,tenChucVu);
				dsCV.add(cv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsCV;	
	}
	public ChucVu getChucVuTheoMa(String maChucVu) {
		ChucVu lcv=new ChucVu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[ChucVu] where [maChucVu] = N'" + maChucVu + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String macv=rs.getString(1);
				String tencv=rs.getString(2);
				lcv.setMaChucVu(macv);
				lcv.setTenChucVu(tencv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return lcv;	
	}
	public ChucVu getChucVuTheoTen(String tenChucVu) {
		ChucVu lcv=new ChucVu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[ChucVu] where [tenChucVu] like N'" + tenChucVu + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String macv=rs.getString(1);
				String tencv=rs.getString(2);
				lcv.setMaChucVu(macv);
				lcv.setTenChucVu(tencv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return lcv;	
	}
	//THÊM
	public boolean themChucVu(ChucVu cv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into ChucVu(maChucVu, tenChucVu) VALUES(?,?)");
			ps.setString(1,cv.getMaChucVu());
			ps.setString(2, cv.getTenChucVu());
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
		public boolean delChucVu(String maChucVu) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			try {
				PreparedStatement ps = con.prepareStatement("delete from ChucVu where maChucVu=?");
				ps.setString(1, maChucVu);
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
