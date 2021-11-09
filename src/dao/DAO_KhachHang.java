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
	public boolean suaThongtinKhachHang(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update KhachHang set tenKhachHang=?, diaChi=?, soDienThoai=?, soCMND=?  where maKhachHang=?");
			ps.setString(1, kh.getTenKhachHang());
			ps.setString(2, kh.getDiaChi());
			ps.setString(3, kh.getSoDienThoai());
			ps.setString(4, kh.getSoCMND());
			ps.setString(5, kh.getMaKhachHang());
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
	/*
	 tìm khách hàng theo maKhachHang
	 */
	public KhachHang getKhachHangByMaKhachHang(String maKhachHang) throws SQLException {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang where maKhachHang = '" + maKhachHang + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maKH = rs.getString(1);
			String ten = rs.getString(2);
			String diachi = rs.getString(3);
			String phone = rs.getString(4);
			String cmnd = rs.getString(5);
			kh = new KhachHang(maKH, ten, diachi, phone, cmnd);
		}
		return kh;
	}
	/*
	 tìm khách hàng theo ten
	 */
	public KhachHang getKhachHangByTenKH(String tenKhachHang) throws SQLException {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang where ngaySinh = '" + tenKhachHang + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maKH = rs.getString(1);
			String ten = rs.getString(2);
			String diachi = rs.getString(3);
			String phone = rs.getString(4);
			String cmnd = rs.getString(5);
			kh = new KhachHang(maKH, ten, diachi, phone, cmnd);
		}
		return kh;
	}
	/*
	 tìm khách hàng theo sdt 
	 */
	public KhachHang getKhachHangBySdtKhachHang(String soDienThoai) throws SQLException {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where KhachHang = '" + soDienThoai + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maKH = rs.getString(1);
			String ten = rs.getString(2);
			String diachi = rs.getString(3);
			String phone = rs.getString(4);
			String cmnd = rs.getString(5);
			kh = new KhachHang(maKH, ten, diachi, phone, cmnd);
		}
		return kh;
	}
	/*
	 tìmkhách hàng theo sCMND 
	 */
	public KhachHang getKhachHangByCmndNhanVien(String soCMND) throws SQLException {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang where soCMND = '" + soCMND + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maKH = rs.getString(1);
			String ten = rs.getString(2);
			String diachi = rs.getString(3);
			String phone = rs.getString(4);
			String cmnd = rs.getString(5);
			kh = new KhachHang(maKH, ten, diachi, phone, cmnd);
		}
		return kh;
	}
	/*
	 tìm khách hàng theo địa chi 
	 */
	public KhachHang getKhachHangByDiaChiKhachHang(String diaChi) throws SQLException {
		KhachHang kh = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from KhachHang where diaChi = '" + diaChi + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maKH = rs.getString(1);
			String ten = rs.getString(2);
			String diachi = rs.getString(3);
			String phone = rs.getString(4);
			String cmnd = rs.getString(5);
			kh = new KhachHang(maKH, ten, diachi, phone, cmnd);
		}
		return kh;
	}
	//xoa nhan vien
	public boolean delKhachHang(String maKhachHang) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("delete from KhachHang where maKhachHang=?");
			ps.setString(1,maKhachHang);
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

