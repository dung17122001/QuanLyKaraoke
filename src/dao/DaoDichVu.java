package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.DichVu;
import entity.LoaiDichVu;
import entity.LoaiPhong;
import entity.Phong;

public class DaoDichVu {
	public DaoDichVu() {
		
	}
	public ArrayList<DichVu> getDichVuTheoLoai(String tenLoai){
		ArrayList<DichVu> dsDV= new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="SELECT * FROM DichVu INNER JOIN LoaiDichVu ON DichVu.maLoaiDV = LoaiDichVu.maLoaiDV where LoaiDichVu.tenLoai like N'"+ tenLoai +"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				double giaTien=rs.getDouble(3);
				String maLoaiDV=rs.getString(4);
				LoaiDichVu ldv=new LoaiDichVu(maLoaiDV);
				DichVu dv=new DichVu(maDichVu, tenDichVu, giaTien, ldv);
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
				String maDV=rs.getString(1);
				String tenDichVu=rs.getString(2);
				double giaTien=rs.getDouble(3);
				String maLoaiDV=rs.getString(4);
				LoaiDichVu loaiDichVu=new LoaiDichVu(maLoaiDV);
				dv.setMaDichVu(maDV);
				dv.setTenDichVu(tenDichVu);
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
			String sql="select * from [dbo].[DichVu] where maDichVu = '"+ maDV +"'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String madv=rs.getString(1);
				String tenDichVu=rs.getString(2);
				double giaTien=rs.getDouble(3);
				String maLoaiDV=rs.getString(4);
				LoaiDichVu loaiDichVu=new LoaiDichVu(maLoaiDV);
				dv.setMaDichVu(madv);
				dv.setTenDichVu(tenDichVu);
				dv.setGiaTien(giaTien);
				dv.setLoaiDichVu(loaiDichVu);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dv;	
	}
}
