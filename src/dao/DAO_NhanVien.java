package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import connect.ConnectDB;
import entity.NhanVien;

public class DAO_NhanVien {

	public DAO_NhanVien() {

	}
	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maNhanVien")); 
			vector.add(rs.getString("tenNhanVien")); 
			vector.add(rs.getString("gioiTinh")); 
			vector.add(rs.getDate("ngaySinh")); 
			vector.add(rs.getString("dienThoai")); 
			vector.add(rs.getString("soCMND")); 
			vector.add(rs.getString("chucVu")); 
			tableModel.addRow(vector);
		}
	}

	
	public ArrayList<NhanVien> getalltbNhanVien(){
		ArrayList<NhanVien> dsnhanvien= new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from NhanVien";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNhanVien=rs.getString(1);
				String tenNhanVien=rs.getString(2);
				String gioiTinh=rs.getString(3);
				Date ngaySinh=rs.getDate(4);
				String dienThoai=rs.getString(5);
				String soCMND=rs.getString(6);
				String chucVu=rs.getString(7);
				NhanVien nv= new NhanVien(maNhanVien,tenNhanVien,gioiTinh,ngaySinh,dienThoai,soCMND,chucVu);
				dsnhanvien.add(nv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsnhanvien;	
	}
	public boolean themNhanVien(NhanVien nv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into NhanVien(maNhanVien, tenNhanVien, gioiTinh, ngaySinh,dienThoai,soCMND, chucVu) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, nv.getMaNhanVien());
			ps.setString(2, nv.getTenNhanVien());
			ps.setString(3, nv.getGioiTinh());
			ps.setDate(4, nv.getNgaySinh());
			ps.setString(5, nv.getDienThoai());
			ps.setString(6, nv.getSoCMND());
			ps.setString(7, nv.getChucVu());
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
}
