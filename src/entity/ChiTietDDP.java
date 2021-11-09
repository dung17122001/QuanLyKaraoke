package entity;

import java.sql.Time;
import java.util.Objects;

public class ChiTietDDP {
	private String maDDP;
	private Time time;
	private Phong phong;
	
	public ChiTietDDP() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietDDP(String maDDP, Time time, Phong phong) {
		super();
		this.maDDP = maDDP;
		this.time = time;
		this.phong = phong;
	}

	public String getMaDDP() {
		return maDDP;
	}

	public void setMaDDP(String maDDP) {
		this.maDDP = maDDP;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maDDP);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietDDP other = (ChiTietDDP) obj;
		return Objects.equals(maDDP, other.maDDP);
	}

	@Override
	public String toString() {
		return "ChiTietDDP [maDDP=" + maDDP + ", time=" + time + ", phong=" + phong + "]";
	}
	
	
}
