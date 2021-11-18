package entity;

import java.awt.Toolkit;
import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import connect.ConnectDB;
import dao.DaoNhanVien;

public class NhanVien implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maNhanVien;
	private String tenNhanVien;
	private String gioiTinh;
	private Date ngaySinh;
	private String dienThoai;
	private String soCMND;
	private ChucVu ChucVu;
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNhanVien) {
		super();
		this.maNhanVien = maNhanVien;
	}

	


	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, Date ngaySinh, String dienThoai,
			String soCMND, entity.ChucVu chucVu) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.dienThoai = dienThoai;
		this.soCMND = soCMND;
		ChucVu = chucVu;
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}


	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}


	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public Date getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public String getDienThoai() {
		return dienThoai;
	}

	public void setDienThoai(String dienThoai) {
		this.dienThoai = dienThoai;
	}

	public String getSoCMND() {
		return soCMND;
	}

	public void setSoCMND(String soCMND) {
		this.soCMND = soCMND;
	}

	

	


	public ChucVu getChucVu() {
		return ChucVu;
	}

	public void setChucVu(ChucVu chucVu) {
		ChucVu = chucVu;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ChucVu == null) ? 0 : ChucVu.hashCode());
		result = prime * result + ((dienThoai == null) ? 0 : dienThoai.hashCode());
		result = prime * result + ((gioiTinh == null) ? 0 : gioiTinh.hashCode());
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		result = prime * result + ((soCMND == null) ? 0 : soCMND.hashCode());
		result = prime * result + ((tenNhanVien == null) ? 0 : tenNhanVien.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		if (ChucVu == null) {
			if (other.ChucVu != null)
				return false;
		} else if (!ChucVu.equals(other.ChucVu))
			return false;
		if (dienThoai == null) {
			if (other.dienThoai != null)
				return false;
		} else if (!dienThoai.equals(other.dienThoai))
			return false;
		if (gioiTinh == null) {
			if (other.gioiTinh != null)
				return false;
		} else if (!gioiTinh.equals(other.gioiTinh))
			return false;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		if (soCMND == null) {
			if (other.soCMND != null)
				return false;
		} else if (!soCMND.equals(other.soCMND))
			return false;
		if (tenNhanVien == null) {
			if (other.tenNhanVien != null)
				return false;
		} else if (!tenNhanVien.equals(other.tenNhanVien))
			return false;
		return true;
	}

	


	



	

	
	
}
