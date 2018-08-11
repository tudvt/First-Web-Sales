	// cả 2 phương thức del và remove đều sử dụng để xóa 1 Object tuy nhiên dùng 2
	// kiểu dữ liệu khác nhau là Statement và PreparedStatement
	// nó xẩy ra do việc truyền giá trị trực tiếp vào câu lệnh SQL.
    //việc truyền trực tiếp giá trị vào khi sử dụng đối tượng Statement. Còn với PreparedStatement thì đã khắc phục được điều đó.
	// Với PreparedStatement mỗi giá trị truyền vào đều phải thông qua việc check,
	// kiểm tra kiều với các hàm setString(), setInt() ..
	
	//Kết luận:
	//Với những trường hợp SQL không cần truyền vào tham số thì sẽ sử dụng đối tượng Statement
	//Với nhưng trường hợp SQL cần truyền vào tham số để filter trong việc select, delete, hay update thì sẽ sử dụng đối tượng PreparedStatement.

//Statement
public void excuteSql(String sql) throws Exception {
		Connection connect = getConnect();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}
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
//	PreparedStatement
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
}
