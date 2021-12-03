package entity;

public class TaiKhoan {
	
	private String maTaikhoan;
	private String tenTaikhoan;
	private String matKhau;
	public TaiKhoan(String maTaikhoan, String tenTaikhoan, String matKhau) {
		super();
		this.maTaikhoan = maTaikhoan;
		this.tenTaikhoan = tenTaikhoan;
		this.matKhau = matKhau;
	}
	public String getMaTaikhoan() {
		return maTaikhoan;
	}
	public void setMaTaikhoan(String maTaikhoan) {
		this.maTaikhoan = maTaikhoan;
	}
	public String getTenTaikhoan() {
		return tenTaikhoan;
	}
	public void setTenTaikhoan(String tenTaikhoan) {
		this.tenTaikhoan = tenTaikhoan;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	@Override
	public String toString() {
		return "TaiKhoan [maTaikhoan=" + maTaikhoan + ", tenTaikhoan=" + tenTaikhoan + ", matKhau=" + matKhau + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTaikhoan == null) ? 0 : maTaikhoan.hashCode());
		result = prime * result + ((matKhau == null) ? 0 : matKhau.hashCode());
		result = prime * result + ((tenTaikhoan == null) ? 0 : tenTaikhoan.hashCode());
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
		if (maTaikhoan == null) {
			if (other.maTaikhoan != null)
				return false;
		} else if (!maTaikhoan.equals(other.maTaikhoan))
			return false;
		if (matKhau == null) {
			if (other.matKhau != null)
				return false;
		} else if (!matKhau.equals(other.matKhau))
			return false;
		if (tenTaikhoan == null) {
			if (other.tenTaikhoan != null)
				return false;
		} else if (!tenTaikhoan.equals(other.tenTaikhoan))
			return false;
		return true;
	}
	
	
}
