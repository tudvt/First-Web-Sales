package model;

public class SanPham {
String maSanPham;
String ten;
double giaDaGiam;
double giaBan;
int soLuong;
String nhaCungCap;
String maLoai;
String hinhAnh;
int soLuongNhap;
int soLuongBan;
public SanPham(String maSanPham, String ten, double giaDaGiam, double giaBan, int soLuong, String nhaCungCap,
		String maLoai, String hinhAnh, int soLuongNhap, int soLuongBan) {
	super();
	this.maSanPham = maSanPham;
	this.ten = ten;
	this.giaDaGiam = giaDaGiam;
	this.giaBan = giaBan;
	this.soLuong = soLuong;
	this.nhaCungCap = nhaCungCap;
	this.maLoai = maLoai;
	this.hinhAnh = hinhAnh;
	this.soLuongNhap = soLuongNhap;
	this.soLuongBan = soLuongBan;
}
public String getMaSanPham() {
	return maSanPham;
}
public void setMaSanPham(String maSanPham) {
	this.maSanPham = maSanPham;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
public double getGiaDaGiam() {
	return giaDaGiam;
}
public void setGiaDaGiam(double giaDaGiam) {
	this.giaDaGiam = giaDaGiam;
}
public double getGiaBan() {
	return giaBan;
}
public void setGiaBan(double giaBan) {
	this.giaBan = giaBan;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public String getNhaCungCap() {
	return nhaCungCap;
}
public void setNhaCungCap(String nhaCungCap) {
	this.nhaCungCap = nhaCungCap;
}
public String getMaLoai() {
	return maLoai;
}
public void setMaLoai(String maLoai) {
	this.maLoai = maLoai;
}
public String getHinhAnh() {
	return hinhAnh;
}
public void setHinhAnh(String hinhAnh) {
	this.hinhAnh = hinhAnh;
}
public int getSoLuongNhap() {
	return soLuongNhap;
}
public void setSoLuongNhap(int soLuongNhap) {
	this.soLuongNhap = soLuongNhap;
}
public int getSoLuongBan() {
	return soLuongBan;
}
public void setSoLuongBan(int soLuongBan) {
	this.soLuongBan = soLuongBan;
}
@Override
public String toString() {
	return "SanPham [maSanPham=" + maSanPham + ", ten=" + ten + ", giaDaGiam=" + giaDaGiam + ", giaBan=" + giaBan
			+ ", soLuong=" + soLuong + ", nhaCungCap=" + nhaCungCap + ", maLoai=" + maLoai + ", hinhAnh=" + hinhAnh
			+ ", soLuongNhap=" + soLuongNhap + ", soLuongBan=" + soLuongBan + "]";
}


}
