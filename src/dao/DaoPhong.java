package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.LoaiPhong;
import entity.Phong;

public class DaoPhong {
	public DaoPhong() {
	}
	public void getDuLieuPhong(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maPhong")); 
			vector.add(rs.getString("tenPhong")); 
			vector.add(rs.getString("tenLoai")); 
			vector.add(rs.getString("giaPhong")); 
			vector.add(rs.getString("trinhTrang"));
			tableModel.addRow(vector);
		}
	}
	
	public ArrayList<Phong> getTatCaPhong(){
		ArrayList<Phong> dsphong= new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from Phong";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				String trinhTrang=rs.getString(3);
				float giaPhong=rs.getFloat(4);
				String maLoaiPhong=rs.getString(5);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong);
				Phong p=new Phong(maPhong, tenPhong, trinhTrang,giaPhong, lp);
				dsphong.add(p);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsphong;	
	}
	
	//Tim theo 2 combox
	public ArrayList<Phong> getTatCaPhongTheoDieuKien(String dk1, String dk2){
		ArrayList<Phong> dsphong= new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT * FROM Phong INNER JOIN LoaiPhong ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong where LoaiPhong.tenLoai like N'" + dk1 + "' and Phong.trinhTrang like N'"+dk2+"' ";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				String trinhTrang=rs.getString(3);
				float giaPhong=rs.getFloat(4);
				String maLoaiPhong=rs.getString(5);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong);
				Phong p=new Phong(maPhong, tenPhong, trinhTrang,giaPhong, lp);
				dsphong.add(p);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsphong;	
	}
	
	public ArrayList<Phong> getPhongTheoThongTinTimKiem(String cbtrinhtrang,String cbtenloai, String textbox){
		ArrayList<Phong> dsphong= new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT * FROM Phong INNER JOIN LoaiPhong ON Phong.maLoaiPhong = LoaiPhong.maLoaiPhong where (Phong.trinhTrang like N'"+cbtrinhtrang+"' and LoaiPhong.tenLoai like N'" + cbtenloai + "') and (Phong.maPhong=N'"+ textbox +"' or Phong.tenPhong like '%"+ textbox +"%')";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				String trinhTrang=rs.getString(3);
				float giaPhong=rs.getFloat(4);
				String maLoaiPhong=rs.getString(5);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong);
				Phong p=new Phong(maPhong, tenPhong, trinhTrang,giaPhong, lp);
				dsphong.add(p);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsphong;	
	}
	
	public boolean themPhong(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into Phong VALUES(?,?,?,?,?) ");
			ps.setString(1, p.getMaPhong());
			ps.setString(2, p.getTenPhong());
			ps.setString(3, p.getTinhTrang());
			ps.setDouble(4, p.getGiaPhong());
			ps.setString(5, p.getLoaiPhong().getMaLoaiPhong());
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
	
	public boolean SuaPhong(Phong p) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement(
					"update Phong set tenPhong=?, trinhTrang=?, giaPhong=?,maLoaiPhong=? where maPhong=?");
			ps.setString(1, p.getTenPhong());
			ps.setString(2, p.getTinhTrang());
			ps.setDouble(3, p.getGiaPhong());
			ps.setString(4, p.getLoaiPhong().getMaLoaiPhong());
			ps.setString(5, p.getMaPhong());
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
	
	public boolean xoaPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("delete Phong where maPhong = ?");
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
	
	public Phong getPhongTheoMa(String ma){
		Phong p=new Phong();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from Phong where maPhong ='"+ma+"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				String trinhTrang=rs.getString(3);
				float giaPhong=rs.getFloat(4);
				String maLoaiPhong=rs.getString(5);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong);
				p.setMaPhong(maPhong);
				p.setTenPhong(tenPhong);
				p.setGiaPhong(giaPhong);
				p.setTinhTrang(trinhTrang);
				p.setLoaiPhong(lp);
				
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return p;	
	}
	
	public Phong getPhongTheoTen(String ma){
		Phong p=new Phong();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from Phong where tenPhong ='"+ma+"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				String trinhTrang=rs.getString(3);
				float giaPhong=rs.getFloat(4);
				String maLoaiPhong=rs.getString(5);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong);
				p.setMaPhong(maPhong);
				p.setTenPhong(tenPhong);
				p.setGiaPhong(giaPhong);
				p.setTinhTrang(trinhTrang);
				p.setLoaiPhong(lp);
				
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return p;	
	}
	
	public boolean updateTrinhTrangPhong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement(
					"update [dbo].[Phong] set trinhTrang=N'Đang sử dụng' where maPhong='"+maPhong+"'");
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
	
	public boolean updatePhongThanhTrong(String maPhong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement(
					"update [dbo].[Phong] set trinhTrang=N'Trống' where tenPhong='"+maPhong+"'");
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
	
	public ArrayList<Phong> getPhongTuDonDatPhong(String sdt){
		ArrayList<Phong> dsphong= new ArrayList<Phong>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT Phong.*\r\n"
					+ "FROM     Phong INNER JOIN\r\n"
					+ "                  ChiTietDonDatPhong ON Phong.maPhong = ChiTietDonDatPhong.maPhong INNER JOIN\r\n"
					+ "                  DonDatPhong INNER JOIN\r\n"
					+ "                  KhachHang ON DonDatPhong.maKhachHang = KhachHang.maKhachHang ON ChiTietDonDatPhong.maDonDatPhong = DonDatPhong.maDonDatPhong\r\n"
					+ "				  where soDienThoai=N'"+sdt+"' and ngayDat='"+LocalDate.now()+"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maPhong=rs.getString(1);
				String tenPhong=rs.getString(2);
				String trinhTrang=rs.getString(3);
				float giaPhong=rs.getFloat(4);
				String maLoaiPhong=rs.getString(5);
				LoaiPhong lp=new LoaiPhong(maLoaiPhong);
				Phong p=new Phong(maPhong, tenPhong, trinhTrang,giaPhong, lp);
				dsphong.add(p);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsphong;	
	}
	
}
