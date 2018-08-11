package dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.LoaiSanPham;

public class LoaiSanPhamDAO {
	Map<String, LoaiSanPham> mapLoaiSanPham = loadData();

	private Map<String, LoaiSanPham> loadData() {
		Map<String, LoaiSanPham> mapTemp = new HashMap<>();

		try {
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from loaisanpham");
			while (resultSet.next()) {
				String maLoai = resultSet.getString(1);
				String tenLoai = resultSet.getString(2);
				String maNhaCungCap = resultSet.getString(3);
				String moTa = resultSet.getString(4);

				LoaiSanPham loaiSanPham = new LoaiSanPham(maLoai, tenLoai, maNhaCungCap, moTa);
				mapTemp.put(loaiSanPham.getMaLoai(), loaiSanPham);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mapTemp;
	}
public static void main(String[] args) {
	LoaiSanPhamDAO loaiSanPhamDAO = new LoaiSanPhamDAO();
	System.out.println(loaiSanPhamDAO.mapLoaiSanPham);
}
}
