package entity;

public class Phong {
	
	private String maPhong;
	private String tenPhong;
	private String tinhTrang;
	private String giaPhong;
	private String maLoaiPhong;
	
	public Phong(String maPhong, String tenPhong, String tinhTrang, String giaPhong, String maLoaiPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.tinhTrang = tinhTrang;
		this.giaPhong = giaPhong;
		this.maLoaiPhong = maLoaiPhong;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", tinhTrang=" + tinhTrang + ", giaPhong="
				+ giaPhong + ", maLoaiPhong=" + maLoaiPhong + "]";
	}

	public String getMaPhong() {
		return maPhong;
	}

	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public String getTenPhong() {
		return tenPhong;
	}

	public void setTenPhong(String tenPhong) {
		this.tenPhong = tenPhong;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public String getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(String giaPhong) {
		this.giaPhong = giaPhong;
	}

	public String getMaLoaiPhong() {
		return maLoaiPhong;
	}

	public void setMaLoaiPhong(String maLoaiPhong) {
		this.maLoaiPhong = maLoaiPhong;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((giaPhong == null) ? 0 : giaPhong.hashCode());
		result = prime * result + ((maLoaiPhong == null) ? 0 : maLoaiPhong.hashCode());
		result = prime * result + ((maPhong == null) ? 0 : maPhong.hashCode());
		result = prime * result + ((tenPhong == null) ? 0 : tenPhong.hashCode());
		result = prime * result + ((tinhTrang == null) ? 0 : tinhTrang.hashCode());
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
		Phong other = (Phong) obj;
		if (giaPhong == null) {
			if (other.giaPhong != null)
				return false;
		} else if (!giaPhong.equals(other.giaPhong))
			return false;
		if (maLoaiPhong == null) {
			if (other.maLoaiPhong != null)
				return false;
		} else if (!maLoaiPhong.equals(other.maLoaiPhong))
			return false;
		if (maPhong == null) {
			if (other.maPhong != null)
				return false;
		} else if (!maPhong.equals(other.maPhong))
			return false;
		if (tenPhong == null) {
			if (other.tenPhong != null)
				return false;
		} else if (!tenPhong.equals(other.tenPhong))
			return false;
		if (tinhTrang == null) {
			if (other.tinhTrang != null)
				return false;
		} else if (!tinhTrang.equals(other.tinhTrang))
			return false;
		return true;
	}
	
	
}
