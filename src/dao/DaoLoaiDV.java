package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connect.ConnectDB;
import entity.LoaiDichVu;
import entity.LoaiPhong;

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
}
