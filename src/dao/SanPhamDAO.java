package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.SanPham;



public class SanPhamDAO {
	Map<String, SanPham> mapSanPham = loadData();

	private Map<String, SanPham> loadData() {
		Map<String, SanPham> mapTemp= new HashMap<>();
		
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
				SanPham sanPham = new SanPham(maSanPham, ten, giaDaGiam, giaBan, soLuong, nhaCungCap, maLoai, hinhAnh, soLuongNhap, soLuongBan);
				mapTemp.put(sanPham.getMaSanPham(), sanPham);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
	}
	public static void main(String[] args) {
		SanPhamDAO sanPhamDAO = new SanPhamDAO();
		System.out.println(sanPhamDAO.mapSanPham);
	}
}
