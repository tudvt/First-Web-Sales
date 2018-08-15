package model;

public class DanhMuc {

    private String maDanhMuc;
    private String tenDanhMuc;

    public DanhMuc() {
    }

	public DanhMuc(String maDanhMuc, String tenDanhMuc) {
		super();
		this.maDanhMuc = maDanhMuc;
		this.tenDanhMuc = tenDanhMuc;
	}

	public String getMaDanhMuc() {
		return maDanhMuc;
	}

	public void setMaDanhMuc(String maDanhMuc) {
		this.maDanhMuc = maDanhMuc;
	}

	public String getTenDanhMuc() {
		return tenDanhMuc;
	}

	public void setTenDanhMuc(String tenDanhMuc) {
		this.tenDanhMuc = tenDanhMuc;
	}

	@Override
	public String toString() {
		return "DanhMuc [maDanhMuc=" + maDanhMuc + ", tenDanhMuc=" + tenDanhMuc + "]"+"\n";
	}
	
}