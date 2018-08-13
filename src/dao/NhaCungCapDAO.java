package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.ConnectToDatabase;
import model.NhaCungCap;

public class NhaCungCapDAO implements ObjectDAO {
	Map<String, NhaCungCap> mapNhaCungCap = loadData();

	private Map<String, NhaCungCap> loadData() {
		Map<String, NhaCungCap> mapTemp = new HashMap<>();
		try {
			ResultSet resultSet = new ConnectToDatabase().selectData("select * from nhacungcap");
			while (resultSet.next()) {
				String maNhaCungCap = resultSet.getString(1);
				String tenNhaCungCap = resultSet.getString(2);
				String diaChi = resultSet.getString(3);
				String soDienThoai = resultSet.getString(4);
				String logo = resultSet.getString(5);
				NhaCungCap nhaCungCap = new NhaCungCap(maNhaCungCap, tenNhaCungCap, diaChi, soDienThoai, logo);
				mapTemp.put(nhaCungCap.getMaNhaCungCap(), nhaCungCap);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mapTemp;
	}

	@Override
	public boolean add(Object obj) {
		NhaCungCap nhaCungCap = (NhaCungCap) obj;
		mapNhaCungCap.put(nhaCungCap.getMaNhaCungCap(), nhaCungCap);
		String sql = "insert into nhacungcap values (?,?,?,?,?)";
		Connection connection = ConnectToDatabase.getConnect();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, nhaCungCap.getMaNhaCungCap());
			preparedStatement.setString(2, nhaCungCap.getTenNhaCungCap());
			preparedStatement.setString(3, nhaCungCap.getDiaChi());
			preparedStatement.setString(4, nhaCungCap.getSoDienThoai());
			preparedStatement.setString(5, nhaCungCap.getLogo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	// cả 2 phương thức del và remove đều sử dụng để xóa 1 Object tuy nhiên dùng 2
	// kiểu dữ liệu khác nhau là Statement và PreparedStatement
	// nó xẩy ra do việc truyền giá trị trực tiếp vào câu lệnh SQL.
    //việc truyền trực tiếp giá trị vào khi sử dụng đối tượng Statement. Còn với PreparedStatement thì đã khắc phục được điều đó.
	// Với PreparedStatement mỗi giá trị truyền vào đều phải thông qua việc check,
	// kiểm tra kiều với các hàm setString(), setInt() ..
	
	//Kết luận:
	//Với những trường hợp SQL không cần truyền vào tham số thì sẽ sử dụng đối tượng Statement
	//Với nhưng trường hợp SQL cần truyền vào tham số để filter trong việc select, delete, hay update thì sẽ sử dụng đối tượng PreparedStatement.
	@Override
	public boolean del(String id) {
		mapNhaCungCap.remove(id);
		try {
			new ConnectToDatabase().excuteSql("delete from nhacungcap where maNhaCungCap='" + id + "'");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	public boolean remove(String id) {
		mapNhaCungCap.remove(id);

		String sql = "delete from nhacungcap where maNhaCungCap = ? ";
		Connection connection = ConnectToDatabase.getConnect();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, new NhaCungCap().getMaNhaCungCap());
			preparedStatement.executeUpdate();//update dữ liệu lên database
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return false;
	}

	public static void main(String[] args) {
		NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
		System.out.println(nhaCungCapDAO.mapNhaCungCap);
		System.out.println(nhaCungCapDAO.mapNhaCungCap.size());

		// add object
//		nhaCungCapDAO.add(new NhaCungCap("NCC-Prada", "Prada", "Mỹ", "0987847232", "image/logoprada.jpg"));
//		System.out.println(nhaCungCapDAO.mapNhaCungCap);
//		System.out.println(nhaCungCapDAO.mapNhaCungCap.size());
//
//		// remove Object
		nhaCungCapDAO.remove("NCC-Prada");
		System.out.println(nhaCungCapDAO.mapNhaCungCap);
		System.out.println(nhaCungCapDAO.mapNhaCungCap.size());

		// delObject
//	nhaCungCapDAO.del("NCC-Prada");
//	System.out.println(nhaCungCapDAO.mapNhaCungCap);
//	System.out.println(nhaCungCapDAO.mapNhaCungCap.size());
	}
}
