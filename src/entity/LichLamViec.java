package entity;

public class LichLamViec {
	
	private String maNhanVien;
	private String maCa;
	
	public LichLamViec(String maNhanVien, String maCa) {
		super();
		this.maNhanVien = maNhanVien;
		this.maCa = maCa;
	}

	@Override
	public String toString() {
		return "LichLamViec [maNhanVien=" + maNhanVien + ", maCa=" + maCa + "]";
	}

	public String getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maCa == null) ? 0 : maCa.hashCode());
		result = prime * result + ((maNhanVien == null) ? 0 : maNhanVien.hashCode());
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
		LichLamViec other = (LichLamViec) obj;
		if (maCa == null) {
			if (other.maCa != null)
				return false;
		} else if (!maCa.equals(other.maCa))
			return false;
		if (maNhanVien == null) {
			if (other.maNhanVien != null)
				return false;
		} else if (!maNhanVien.equals(other.maNhanVien))
			return false;
		return true;
	}
	
	
}
