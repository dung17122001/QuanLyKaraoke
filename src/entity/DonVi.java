package entity;

public class DonVi {

	private String maDonVi;
	private String tenDonVi;
	
	public DonVi(String maDonVi, String tenDonVi) {
		super();
		this.maDonVi = maDonVi;
		this.tenDonVi = tenDonVi;
	}

	public DonVi(String maDonVi) {
		super();
		this.maDonVi = maDonVi;
	}
	
	public DonVi() {
		
	}

	@Override
	public String toString() {
		return "DonVi [maDonVi=" + maDonVi + ", tenDonVi=" + tenDonVi + "]";
	}

	public String getMaDonVi() {
		return maDonVi;
	}

	public void setMaDonVi(String maDonVi) {
		this.maDonVi = maDonVi;
	}

	public String getTenDonVi() {
		return tenDonVi;
	}

	public void setTenDonVi(String tenDonVi) {
		this.tenDonVi = tenDonVi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maDonVi == null) ? 0 : maDonVi.hashCode());
		result = prime * result + ((tenDonVi == null) ? 0 : tenDonVi.hashCode());
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
		DonVi other = (DonVi) obj;
		if (maDonVi == null) {
			if (other.maDonVi != null)
				return false;
		} else if (!maDonVi.equals(other.maDonVi))
			return false;
		if (tenDonVi == null) {
			if (other.tenDonVi != null)
				return false;
		} else if (!tenDonVi.equals(other.tenDonVi))
			return false;
		return true;
	}
	
}
