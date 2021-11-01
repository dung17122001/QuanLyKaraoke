package entity;

public class Ca {

	private String maCa;
	private String tenCa;
	private String thoiGian;
	private String luong;
	
	public Ca(String maCa, String tenCa, String thoiGian, String luong) {
		super();
		this.maCa = maCa;
		this.tenCa = tenCa;
		this.thoiGian = thoiGian;
		this.luong = luong;
	}

	@Override
	public String toString() {
		return "Ca [maCa=" + maCa + ", tenCa=" + tenCa + ", thoiGian=" + thoiGian + ", luong=" + luong + "]";
	}

	public String getMaCa() {
		return maCa;
	}

	public void setMaCa(String maCa) {
		this.maCa = maCa;
	}

	public String getTenCa() {
		return tenCa;
	}

	public void setTenCa(String tenCa) {
		this.tenCa = tenCa;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getLuong() {
		return luong;
	}

	public void setLuong(String luong) {
		this.luong = luong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((luong == null) ? 0 : luong.hashCode());
		result = prime * result + ((maCa == null) ? 0 : maCa.hashCode());
		result = prime * result + ((tenCa == null) ? 0 : tenCa.hashCode());
		result = prime * result + ((thoiGian == null) ? 0 : thoiGian.hashCode());
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
		Ca other = (Ca) obj;
		if (luong == null) {
			if (other.luong != null)
				return false;
		} else if (!luong.equals(other.luong))
			return false;
		if (maCa == null) {
			if (other.maCa != null)
				return false;
		} else if (!maCa.equals(other.maCa))
			return false;
		if (tenCa == null) {
			if (other.tenCa != null)
				return false;
		} else if (!tenCa.equals(other.tenCa))
			return false;
		if (thoiGian == null) {
			if (other.thoiGian != null)
				return false;
		} else if (!thoiGian.equals(other.thoiGian))
			return false;
		return true;
	}
	
	
}
