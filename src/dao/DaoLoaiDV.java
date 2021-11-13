package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiDichVu;

public class DaoLoaiDV {
	public DaoLoaiDV() {
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
}
