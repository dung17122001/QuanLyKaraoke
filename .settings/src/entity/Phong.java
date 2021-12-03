package entity;

import java.util.Objects;

public class Phong {
	
	private String maPhong;
	private String tenPhong;
	private String tinhTrang;
	private double giaPhong;
	private LoaiPhong LoaiPhong;
	
	public Phong(String maPhong, String tenPhong, String tinhTrang, double giaPhong, entity.LoaiPhong loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.tinhTrang = tinhTrang;
		this.giaPhong = giaPhong;
		LoaiPhong = loaiPhong;
	}
	
	public Phong() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

	public Phong(String maPhong, String tenPhong, double giaPhong) {
		super();
		this.maPhong = maPhong;
		this.tenPhong = tenPhong;
		this.giaPhong = giaPhong;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tenPhong=" + tenPhong + ", tinhTrang=" + tinhTrang + ", giaPhong="
				+ giaPhong + ", LoaiPhong=" + LoaiPhong + "]";
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

	public double getGiaPhong() {
		return giaPhong;
	}

	public void setGiaPhong(double giaPhong) {
		this.giaPhong = giaPhong;
	}

	public LoaiPhong getLoaiPhong() {
		return LoaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		LoaiPhong = loaiPhong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maPhong);
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
		return Objects.equals(maPhong, other.maPhong);
	}

	
	
}
