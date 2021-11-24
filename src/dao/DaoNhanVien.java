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
import entity.ChucVu;
import entity.LoaiPhong;
import entity.NhanVien;
import entity.Phong;

public class DaoNhanVien {

	public DaoNhanVien() {

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
			vector.add(rs.getString("tenChucVu")); 
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
				String manv=rs.getString(1);
				String tennv=rs.getString(2);
				String gt=rs.getString(3);
				Date ns=rs.getDate(4);
				String dt=rs.getString(5);
				String socm=rs.getString(6);
				String maChucVu=rs.getString(7);
				ChucVu lcv=new ChucVu(maChucVu);
				NhanVien nv= new NhanVien(manv,tennv,gt,ns,dt,socm,lcv);
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
			ps = con.prepareStatement("insert into NhanVien(maNhanVien, tenNhanVien, gioiTinh, ngaySinh,dienThoai,soCMND, maChucVu) VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, nv.getMaNhanVien());
			ps.setString(2, nv.getTenNhanVien());
			ps.setString(3, nv.getGioiTinh());
			ps.setDate(4, nv.getNgaySinh());
			ps.setString(5, nv.getDienThoai());
			ps.setString(6, nv.getSoCMND());
			ps.setString(7, nv.getChucVu().getMaChucVu());
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
	
	public boolean suaThongtinNhanvien(NhanVien nv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update NhanVien set tenNhanVien=?, gioiTinh=?, ngaySinh=?, dienThoai=?, soCMND=?, maChucVu=?  where maNhanVien=?");
			ps.setString(1, nv.getTenNhanVien());
			ps.setString(2, nv.getGioiTinh());
			ps.setDate(3, nv.getNgaySinh());
			ps.setString(4, nv.getDienThoai());
			ps.setString(5, nv.getSoCMND());
			ps.setString(6, nv.getChucVu().getMaChucVu());
			ps.setString(7, nv.getMaNhanVien());
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
	 tìm nhân viên theo maNhanVien
	 */
	public NhanVien getNhanvienByMaNhanVien(String maNhanVien) throws SQLException {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where maNhanVien = '" + maNhanVien + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maNV = rs.getString(1);
			String ten = rs.getString(2);
			String gt = rs.getString(3);
			Date ns = rs.getDate(4);
			String phone = rs.getString(5);
			String cmnd = rs.getString(6);
			String chucvu = rs.getString(7);
			ChucVu lcv=new ChucVu();
			nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
		}
		return nv;
	}
	/*
	 tìm nhân viên theo tenNhanVien
	 */
	public NhanVien getNhanvienByTenNhanVien(String tenNhanVien) throws SQLException {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where tenNhanVien = '" + tenNhanVien + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maNV = rs.getString(1);
			String ten = rs.getString(2);
			String gt = rs.getString(3);
			Date ns = rs.getDate(4);
			String phone = rs.getString(5);
			String cmnd = rs.getString(6);
			String chucvu = rs.getString(7);
			ChucVu lcv=new ChucVu();
			nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
		}
		return nv;
	}
	/*
	 tìm nhân viên theo tenNhanVien
	 */
	public NhanVien getNhanvienByNsNhanVien(String ngaySinh) throws SQLException {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where ngaySinh = '" + ngaySinh + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maNV = rs.getString(1);
			String ten = rs.getString(2);
			String gt = rs.getString(3);
			Date ns = rs.getDate(4);
			String phone = rs.getString(5);
			String cmnd = rs.getString(6);
			String chucvu = rs.getString(7);
			ChucVu lcv=new ChucVu();
			nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
		}
		return nv;
	}
	/*
	 tìm nhân viên theo sdt NhanVien
	 */
	public NhanVien getNhanvienBySdtNhanVien(String dienThoai) throws SQLException {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where dienThoai = '" + dienThoai + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maNV = rs.getString(1);
			String ten = rs.getString(2);
			String gt = rs.getString(3);
			Date ns = rs.getDate(4);
			String phone = rs.getString(5);
			String cmnd = rs.getString(6);
			String chucvu = rs.getString(7);
			ChucVu lcv=new ChucVu();
			nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
		}
		return nv;
	}
	/*
	 tìm nhân viên theo sCMND NhanVien
	 */
	public NhanVien getNhanvienByCmndNhanVien(String soCMND) throws SQLException {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where soCMND = '" + soCMND + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maNV = rs.getString(1);
			String ten = rs.getString(2);
			String gt = rs.getString(3);
			Date ns = rs.getDate(4);
			String phone = rs.getString(5);
			String cmnd = rs.getString(6);
			String chucvu = rs.getString(7);
			ChucVu lcv=new ChucVu();
			nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
		}
		return nv;
	}
	/*
	 tìm nhân viên theo chuc vu NhanVien
	 */
	public NhanVien getNhanvienByChucVuNhanVien(String maChucVu) throws SQLException {
		NhanVien nv = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from NhanVien where maChucVu = '" + maChucVu + "'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			String maNV = rs.getString(1);
			String ten = rs.getString(2);
			String gt = rs.getString(3);
			Date ns = rs.getDate(4);
			String phone = rs.getString(5);
			String cmnd = rs.getString(6);
			String chucvu = rs.getString(7);
			ChucVu lcv=new ChucVu();
			nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
		}
		return nv;
	}
	//xoa nhan vien
	public boolean delNhanVien(String maNhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("delete from NhanVien where maNhanVien=?");
			ps.setString(1, maNhanVien);
			int n = ps.executeUpdate();
			if (n > 0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public NhanVien getNVTheoHD(String mahd){
		NhanVien nv = null;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT NhanVien.*\r\n"
					+ "FROM     HoaDon INNER JOIN\r\n"
					+ "                  NhanVien ON HoaDon.maNhanVien = NhanVien.maNhanVien where maHoaDon=N'"+mahd+"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maNV = rs.getString(1);
				String ten = rs.getString(2);
				String gt = rs.getString(3);
				Date ns = rs.getDate(4);
				String phone = rs.getString(5);
				String cmnd = rs.getString(6);
				String chucvu = rs.getString(7);
				ChucVu lcv=new ChucVu();
				nv= new NhanVien(maNV,ten,gt,ns,phone,cmnd,lcv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return nv;	
	}
}
