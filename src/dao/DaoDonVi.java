package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.DonVi;
import entity.LoaiDichVu;

public class DaoDonVi {

	public DaoDonVi(){
		
	}
	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maDonVi")); 
			vector.add(rs.getString("tenDonVi")); 
			tableModel.addRow(vector);
		}
	}
	public ArrayList<DonVi> getTatCaDonVi(){
		ArrayList<DonVi> dsdvi= new ArrayList<DonVi>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[DonVi]";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonVi=rs.getString(1);
				String tenDonVi=rs.getString(2);
				DonVi donVi=new DonVi(maDonVi, tenDonVi);
				dsdvi.add(donVi);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dsdvi;	
	}
	public DonVi getDonViTheoMa(String ma) {
		DonVi dvi=new DonVi();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[DonVi] where [maDonVi] = N'" + ma + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonVi=rs.getString(1);
				String tenDonVi=rs.getString(2);
				dvi.setMaDonVi(maDonVi);
				dvi.setTenDonVi(tenDonVi);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dvi;	
	}
	public DonVi getDonViTheoTen(String ten) {
		DonVi dvi=new DonVi();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			String sql="select * from [dbo].[DonVi] where [tenDonVi] like N'" + ten + "'";
			PreparedStatement ps = con.prepareStatement(sql);	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String maDonVi=rs.getString(1);
				String tenDonVi=rs.getString(2);
				dvi.setMaDonVi(maDonVi);
				dvi.setTenDonVi(tenDonVi);
			}
		}
			catch (SQLException e) {
				e.printStackTrace();
			}
		
		return dvi;	
	}
	//thêm
		public boolean themDonVi(DonVi dv) throws SQLException {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getCon();
			PreparedStatement ps = null;
			int n = 0;
			try {
				ps = con.prepareStatement("insert into DonVi(maDonVi, tenDonVi) VALUES(?,?)");
				ps.setString(1,dv.getMaDonVi());
				ps.setString(2,dv.getTenDonVi());
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
		//xoa
				public boolean delDonVi(String maDVi) throws SQLException {
					ConnectDB.getInstance();
					Connection con = ConnectDB.getCon();
					try {
						PreparedStatement ps = con.prepareStatement("delete from DonVi where maDonVi=?");
						ps.setString(1, maDVi);
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
