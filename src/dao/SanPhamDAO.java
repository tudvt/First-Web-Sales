package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.SanPham;



public class SanPhamDAO {


	private Map<String, SanPham> loadData() {
		Map<String, SanPham> mapSanPham= new HashMap<>();
		
		try {
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from sanpham");
			while (resultSet.next()) {
				String maSanPham= resultSet.getString(1);
				String ten= resultSet.getString(2);
				double giaDaGiam=resultSet.getDouble(3);
				double giaBan=resultSet.getDouble(4);
				int soLuong=resultSet.getInt(5);
				String nhaCungCap= resultSet.getString(6);
				String maLoai= resultSet.getString(7);
				String hinhAnh= resultSet.getString(8);
				int soLuongNhap= resultSet.getInt(9);
				int soLuongBan= resultSet.getInt(10);
				String maDanhMuc=resultSet.getString(11);
				SanPham sanPham = new SanPham(maSanPham, ten, giaDaGiam, giaBan, soLuong, nhaCungCap, maLoai, hinhAnh, soLuongNhap, soLuongBan,maDanhMuc);
				mapSanPham.put(sanPham.getMaSanPham(), sanPham);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapSanPham;
	}
	//lấy sản phẩm theo danh mục
	public Map<String, SanPham> getListProductByCategory(String id)  {
	Map<String, SanPham> mapSanPham= new HashMap<>();
		
		try {
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from sanpham  WHERE maDanhMuc = '" + id + "'");
			while (resultSet.next()) {
				String maSanPham= resultSet.getString(1);
				String ten= resultSet.getString(2);
				double giaDaGiam=resultSet.getDouble(3);
				double giaBan=resultSet.getDouble(4);
				int soLuong=resultSet.getInt(5);
				String nhaCungCap= resultSet.getString(6);
				String maLoai= resultSet.getString(7);
				String hinhAnh= resultSet.getString(8);
				int soLuongNhap= resultSet.getInt(9);
				int soLuongBan= resultSet.getInt(10);
				String maDanhMuc1=resultSet.getString(11);
				SanPham sanPham = new SanPham(maSanPham, ten, giaDaGiam, giaBan, soLuong, nhaCungCap, maLoai, hinhAnh, soLuongNhap, soLuongBan,maDanhMuc1);
				mapSanPham.put(sanPham.getMaSanPham(), sanPham);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapSanPham;
	}
	public SanPham getSanPham(String id) {
		SanPham sanPham = null;
		try {
			
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from sanpham  WHERE maSanPham = '" + id + "'");
			while (resultSet.next()) {
				String maSanPham= resultSet.getString(1);
				String ten= resultSet.getString(2);
				double giaDaGiam=resultSet.getDouble(3);
				double giaBan=resultSet.getDouble(4);
				int soLuong=resultSet.getInt(5);
				String nhaCungCap= resultSet.getString(6);
				String maLoai= resultSet.getString(7);
				String hinhAnh= resultSet.getString(8);
				int soLuongNhap= resultSet.getInt(9);
				int soLuongBan= resultSet.getInt(10);
				String maDanhMuc1=resultSet.getString(11);
				 sanPham = new SanPham(maSanPham, ten, giaDaGiam, giaBan, soLuong, nhaCungCap, maLoai, hinhAnh, soLuongNhap, soLuongBan,maDanhMuc1);
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sanPham;
	}
	
	public static void main(String[] args) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		System.out.println(sanPhamDAO.loadData().size());
		System.out.println(sanPhamDAO.getListProductByCategory("1").size());
		System.out.println(sanPhamDAO.getSanPham("AT001"));
	}
}
