package entity;

import java.io.Serializable;
import java.sql.Date;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicInteger;

import connect.ConnectDB;
import dao.DAO_NhanVien;

public class NhanVien {
	
	private String maNhanVien;
	private String tenNhanVien;
	private String gioiTinh;
	private Date ngaySinh;
	private String dienThoai;
	private String soCMND;
	private String chucVu;
	private Ca Ca;
	
	
	public NhanVien(String maNhanVien, String tenNhanVien, String gioiTinh, Date ngaySinh, String dienThoai,
			String soCMND, String chucVu, entity.Ca ca) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.dienThoai = dienThoai;
		this.soCMND = soCMND;
		this.chucVu = chucVu;
		Ca = ca;
	}

	

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", gioiTinh=" + gioiTinh
				+ ", ngaySinh=" + ngaySinh + ", dienThoai=" + dienThoai + ", soCMND=" + soCMND + ", chucVu=" + chucVu
				+ ", Ca=" + Ca + "]";
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

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	
	public Ca getCa() {
		return Ca;
	}

	public void setCa(Ca ca) {
		Ca = ca;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Ca == null) ? 0 : Ca.hashCode());
		result = prime * result + ((chucVu == null) ? 0 : chucVu.hashCode());
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
		if (Ca == null) {
			if (other.Ca != null)
				return false;
		} else if (!Ca.equals(other.Ca))
			return false;
		if (chucVu == null) {
			if (other.chucVu != null)
				return false;
		} else if (!chucVu.equals(other.chucVu))
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
