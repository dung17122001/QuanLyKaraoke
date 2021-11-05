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

public class DAO_DichVu {

	public DAO_DichVu() {

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
			vector.add(rs.getString("giaTien")); 
			tableModel.addRow(vector);
		}
	}

	
	public ArrayList<DichVu> getalltbDichVu(){
		ArrayList<DichVu> dsdichvu= new ArrayList<DichVu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="Select *from DichVu";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDichVu=rs.getString(1);
				String tenDichVu=rs.getString(2);
				String giaTien=rs.getString(3);
				DichVu dv= new DichVu(maDichVu,tenDichVu,giaTien, null);
				dsdichvu.add(dv);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsdichvu;	
	}
	public boolean themDichVu(DichVu dv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into DichVu(maDichVu,tenDichVu,giaTien, null) VALUES(?,?,?,?)");
			ps.setString(1, dv.getMaDichVu());
			ps.setString(2, dv.getTenDichVu());
			ps.setString(3, dv.getGiaTien());
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

