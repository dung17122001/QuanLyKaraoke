package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import connect.ConnectDB;
import entity.TaiKhoan;



public class DaoTaiKhoan {

	public void loadData(String sql, DefaultTableModel tableModel) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			vector.add(rs.getString("maNhanVien")); 
			vector.add(rs.getString("tenTaiKhoan"));  
			vector.add(rs.getString("matKhau"));  
			tableModel.addRow(vector);
		}
	}
	
	public ArrayList<TaiKhoan> getDsTaikhoan() throws SQLException {
		ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		ConnectDB.getInstance();
        Connection con=ConnectDB.getCon();
		String sql = "select * from TaiKhoan";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			TaiKhoan tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3));
			dstk.add(tk);
		}
		return dstk;
	}
	public TaiKhoan getTaiKhoanByID(String idTaikhoan) throws SQLException {
		TaiKhoan tk = null;
		ConnectDB.getInstance();
        Connection con=ConnectDB.getCon();
		String sql = "select * from TaiKhoan where idtaikhoan = N'"+idTaikhoan+"'";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		return tk;
	}
	/**Kiểm tra tên tài khoản có tồn tại hay không => mục đích: tạo tài khoản cho nhân viên mới không bị trùng
	 * 
	 * @param taikhoan
	 * @return tk
	 * @throws SQLException
	 */
	public TaiKhoan checkTenTaikhoanAvailable(String taikhoan) throws SQLException {
		TaiKhoan tk = null;
		ConnectDB.getInstance();
        Connection con=ConnectDB.getCon();
        String sql = "select * from TaiKhoan where tentaikhoan = N'"+taikhoan+"'";
        PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		return tk;
	}
	
	//thêm tài khoản
	public boolean themTaikhoan(TaiKhoan tk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("insert into TaiKhoan values(?,?,?)");
			ps.setString(1, tk.getMaTaikhoan());
			ps.setString(2, tk.getTenTaikhoan());
			ps.setString(3, tk.getMatKhau());
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
	
	//đổi mk
	public boolean doiMatkhau(TaiKhoan tk, String matkhaumoi) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n = 0;
		try {
			ps = con.prepareStatement("update TaiKhoan set MatKhau=? where TenTaiKhoan=?");
			ps.setString(1, matkhaumoi);
			ps.setString(2, tk.getTenTaikhoan());
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
	public boolean delTaiKhoan(String maNhanVien) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("delete from TaiKhoan where maNhanVien=?");
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
	
	/**Tìm tài khoản theo tên tài khoản
	 * 
	 * @param tenTK
	 * @return
	 */
	public TaiKhoan getTaikhoanByName(String tenTK) {
		TaiKhoan tk = null;
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		String sql = "select * from TaiKhoan where TenTaiKhoan = N'" + tenTK + "'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				tk = new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tk;
	}
	/**Kiểm tra tài khoản mật khẩu để đăng nhập
	 * 
	 * @param user
	 * @param pass
	 * @return
	 */
	public boolean checkAccount(String user, String pass) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		int n=0;
		try {
			String sql = "select * from TaiKhoan where TenTaiKhoan =? and MatKhau=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				n++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return n>0 ? true : false;
	}
	
	public String getChucVu(String user) {
		String chucvu="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		try {
			String sql = "SELECT ChucVu.tenChucVu\r\n"
					+ "FROM     TaiKhoan INNER JOIN\r\n"
					+ "                  NhanVien ON TaiKhoan.maNhanVien = NhanVien.maNhanVien INNER JOIN\r\n"
					+ "                  ChucVu ON NhanVien.maChucVu = ChucVu.maChucVu where tenTaiKhoan like N'"+user+"'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				chucvu=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return chucvu;
	}
	
	public String getMaNV(String user) {
		String manv="";
		ConnectDB.getInstance();
		Connection con = ConnectDB.getCon();
		PreparedStatement ps = null;
		try {
			String sql = "SELECT NhanVien.maNhanVien\r\n"
					+ "FROM     TaiKhoan INNER JOIN\r\n"
					+ "                  NhanVien ON TaiKhoan.maNhanVien = NhanVien.maNhanVien\r\n"
					+ "				  where tenTaiKhoan like N'"+user+"'";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				manv=rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return manv;
	}
    
}
