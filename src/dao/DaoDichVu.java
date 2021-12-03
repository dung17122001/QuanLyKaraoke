package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.DichVu;
import entity.DonVi;
import entity.LoaiDichVu;
import entity.Phong;

public class DaoDichVu {
	public DaoDichVu() {
		
	}
	
	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maDichVu")); 
			vector.add(rs.getString("tenDichVu")); 
			vector.add(rs.getString("tenDonVi")); 
			vector.add(rs.getString("giaTien")); 
			vector.add(rs.getString("tenLoaiDV"));
			tableModel.addRow(vector);
		}
	}
	public ArrayList<DichVu> getTatCaDichVu(){
		ArrayList<DichVu> dsDV= new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from DichVu";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String maDonVi=rs.getString(3);
				double giaTien=rs.getDouble(4);
				String maLoaiDV=rs.getString(5);
				LoaiDichVu ldv=new LoaiDichVu(maLoaiDV);
				DonVi dvi=new DonVi(maDonVi);
				
				DichVu dv=new DichVu(maDichVu, tenDichVu,dvi, giaTien, ldv);
				dsDV.add(dv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsDV;	
	}
	public ArrayList<DichVu> getDichVuTheoLoai(String tenLoai){
		ArrayList<DichVu> dsDV= new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT * FROM DichVu INNER JOIN LoaiDichVu ON DichVu.maLoaiDV = LoaiDichVu.maLoaiDV where LoaiDichVu.tenLoaiDV like N'"+ tenLoai +"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String maDonVi=rs.getString(3);
				double giaTien=rs.getDouble(4);
				String maLoaiDV=rs.getString(5);
				LoaiDichVu ldv=new LoaiDichVu(maLoaiDV);
				DonVi dvi=new DonVi(maDonVi);
				
				DichVu dv=new DichVu(maDichVu, tenDichVu,dvi, giaTien, ldv);
				dsDV.add(dv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsDV;	
	}
	public ArrayList<DichVu> getDichVuTheoDonVi(String tenDvi){
		ArrayList<DichVu> dsDV= new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT * FROM DichVu INNER JOIN DonVi ON DichVu.maDonVi = DonVi.maDonVi where DonVi.tenDonVi like N'"+ tenDvi +"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String maDonVi=rs.getString(3);
				double giaTien=rs.getDouble(4);
				String maLoaiDV=rs.getString(5);
				LoaiDichVu ldv=new LoaiDichVu(maLoaiDV);
				DonVi dvi=new DonVi(maDonVi);
				
				DichVu dv=new DichVu(maDichVu, tenDichVu,dvi, giaTien, ldv);
				dsDV.add(dv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsDV;	
	}
	
	public DichVu getDichVuTheoTen(String tenDV) {
		DichVu dv=new DichVu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[DichVu] where tenDichVu like N'"+ tenDV +"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String maDonVi=rs.getString(3);
				double giaTien=rs.getDouble(4);
				String maLoaiDV=rs.getString(5);
				LoaiDichVu ldv=new LoaiDichVu(maLoaiDV);
				DonVi dvi=new DonVi(maDonVi);
				LoaiDichVu loaiDichVu=new LoaiDichVu(maLoaiDV);
				
				dv.setMaDichVu(maDichVu);
				dv.setTenDichVu(tenDichVu);
				dv.setDonVi(dvi);
				dv.setGiaTien(giaTien);
				dv.setLoaiDichVu(loaiDichVu);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dv;	
	}
	
	public DichVu getDichVuTheoMa(String maDV) {
		DichVu dv=new DichVu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from DichVu where maDichVu = '"+ maDV +"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String maDonVi=rs.getString(3);
				double giaTien=rs.getDouble(4);
				String maLoaiDV=rs.getString(5);
				LoaiDichVu ldv=new LoaiDichVu(maLoaiDV);
				DonVi dvi=new DonVi(maDonVi);
				LoaiDichVu loaiDichVu=new LoaiDichVu(maLoaiDV);
				
				dv.setMaDichVu(maDichVu);
				dv.setTenDichVu(tenDichVu);
				dv.setDonVi(dvi);
				dv.setGiaTien(giaTien);
				dv.setLoaiDichVu(loaiDichVu);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dv;	
	}
	public boolean themDichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into DichVu VALUES(?,?,?,?,?) ");
			ps.setString(1, dv.getMaDichVu());
			ps.setString(2, dv.getTenDichVu());
			ps.setString(3, dv.getDonVi().getMaDonVi());
			ps.setDouble(4, dv.getGiaTien());
			ps.setString(5, dv.getLoaiDichVu().getMaLoai());
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
	public boolean suaDichVu(DichVu dv) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement(
					"update DichVu set tenDichVu=?, maDonVi=? ,giaTien=?, maLoaiDV=? where maDichVu=?");
			ps.setString(1, dv.getTenDichVu());
			ps.setString(2, dv.getDonVi().getMaDonVi());
			ps.setDouble(3, dv.getGiaTien());
			ps.setString(4, dv.getLoaiDichVu().getMaLoai());
			ps.setString(5, dv.getMaDichVu());
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
	public boolean xoaDichVu(String maDV) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("delete DichVu where maDichVu = ?");
			ps.setString(1, maDV);
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
