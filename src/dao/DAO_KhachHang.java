package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import connect.ConnectDB;
import entity.KhachHang;

public class DAO_KhachHang {

	public DAO_KhachHang() {

	}
	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maKhachHang")); 
			vector.add(rs.getString("tenKhachHang")); 
			vector.add(rs.getString("diaChi")); 
			vector.add(rs.getString("soDienThoai")); 
			vector.add(rs.getString("soCMND")); 
			tableModel.addRow(vector);
		}
	}

	
	public ArrayList<KhachHang> getalltbKhachHang(){
		ArrayList<KhachHang> dskhachhang= new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from KhachHang";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maKhachHang=rs.getString(1);
				String tenKhachHang=rs.getString(2);
				String diaChi=rs.getString(3);
				String soDienThoai=rs.getString(4);
				String soCMND=rs.getString(5);
				KhachHang kh= new KhachHang(maKhachHang,tenKhachHang,diaChi,soDienThoai,soCMND);
				dskhachhang.add(kh);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dskhachhang;	
	}
	public boolean themKhachHang(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into KhachHang(maKhachHang, tenKhachHang, diaChi, soDienThoai,soCMND) VALUES(?,?,?,?,?)");
			ps.setString(1, kh.getMaKhachHang());
			ps.setString(2, kh.getTenKhachHang());
			ps.setString(3, kh.getDiaChi());
			ps.setString(4, kh.getSoDienThoai());
			ps.setString(5, kh.getSoCMND());
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

