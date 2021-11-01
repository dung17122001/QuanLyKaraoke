package entity;

public class TaiKhoan {
	
	private String maNhanVien;
	private String tenTaiKhoan;
	private String matKhau;
	
	public TaiKhoan(String maNhanVien, String tenTaiKhoan, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenTaiKhoan = tenTaiKhoan;
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maNhanVien=" + maNhanVien + ", tenTaiKhoan=" + tenTaiKhoan + ", matKhau=" + matKhau + "]";
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenTaiKhoan() {
		return tenTaiKhoan;
	}

	public void setTenTaiKhoan(String tenTaiKhoan) {
		this.tenTaiKhoan = tenTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
		result = prime * result + ((matKhau == null) ? 0 : matKhau.hashCode());
		result = prime * result + ((tenTaiKhoan == null) ? 0 : tenTaiKhoan.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		if (matKhau == null) {
			if (other.matKhau != null)
				return false;
		} else if (!matKhau.equals(other.matKhau))
			return false;
		if (tenTaiKhoan == null) {
			if (other.tenTaiKhoan != null)
				return false;
		} else if (!tenTaiKhoan.equals(other.tenTaiKhoan))
			return false;
		return true;
	}
	
	
}
