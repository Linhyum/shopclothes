package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Category;
import Model.Customer;
import Model.Product;
import Model.User;

public class DaoMySql {

	public void setlistProduct(Customer e) throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String insert = "INSERT INTO product_bill (id_product, id_custom, quantity, datetime, name, email, address, phone ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			for (Product i : e.getListPro()) {

				try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes",
						"root", "123456"); PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

					preparedStatement.setInt(1, i.getId());
					preparedStatement.setInt(2, e.getIduser()); // Set id_custom
					preparedStatement.setInt(3, i.getQuantity()); // Set quantity
					preparedStatement.setString(4, e.getDate()); // Set datetime
					preparedStatement.setString(5, e.getName());
					preparedStatement.setString(6, e.getEmail());
					preparedStatement.setString(7, e.getAddress());
					preparedStatement.setString(8, e.getPhone());

					// Execute the query
					preparedStatement.executeUpdate();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}

		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
			throw e1; // rethrow the ClassNotFoundException
		}
	}

	public Product getProductid(String id) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product where id = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");
				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, id);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				// Gán đối tượng Product cho biến product
				Product product = new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getInt(8));
				// Trả về đối tượng Product
				return product;
			}
		}
		return null;
	}

	// lay ra danh sách sản phẩm theo danh mục
	public List<Product> getListProductCategory(String cateid) throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product where cateid = ?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, cateid);
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8)));
			}

		}
		return list;
	}

	// lay ra tat ca danh muc trong csdl
	public List<Category> AllCategory() throws ClassNotFoundException, SQLException {
		List<Category> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from category";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Category(rs.getString(1), rs.getString(2)));
			}

		}
		return list;
	}

	// danh sach san pham
	public List<Product> getAllProduct() throws ClassNotFoundException, SQLException {
		List<Product> list = new ArrayList<>();
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from product";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");
				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				list.add(new Product(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getInt(8)));
			}

		}
		return list;
	}

	// Tạo ra phương thức đăng nhập lấy thông tin từ cơ sở dữ liệu
	public User loginUser(String username, String pass) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from user where username =? and pass =?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return null;
	}

	// kiem tra ten nguoi dung co trong csdl hay chua
	public User checkUSer(String username) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String select = "select * from user where username =?";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");

				// Tạo câu lệnh sử dụng đối tượng kết nối
				PreparedStatement preparedStatement = connection.prepareStatement(select)) {
			preparedStatement.setString(1, username);

			// thực hiện chọn truy vấn
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getInt(7));
			}

		} catch (SQLException e) {
			e.getStackTrace();
		}
		return null;
	}

	public void register(String username, String pass, String email, String phonenumber) throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String insert = "insert into user (username, pass, email, phonenumber, isSell, isAdmin) values (?, ?, ?, ?, 0, 0)";
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
				"123456");

				PreparedStatement preparedStatement = connection.prepareStatement(insert)) {
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, phonenumber);
			// thực hiện chọn truy vấn
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.getStackTrace();
		}

	}

// luu thong tin tong hoa don 
	public static void billOrder(int idcustomer, int quantity, double sumtotol, String date)
			throws ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String insert = "INSERT INTO bill_order_sum (idcustomer, quantity, sumtotol, date) VALUES (?, ?, ?, ?)";

			try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shopclothes", "root",
					"123456"); PreparedStatement preparedStatement = connection.prepareStatement(insert)) {

				preparedStatement.setInt(1, idcustomer);
				preparedStatement.setInt(2, quantity);
				preparedStatement.setDouble(3, sumtotol);
				preparedStatement.setString(4, date);

				// Execute the query
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e; // rethrow the ClassNotFoundException
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		// Create a sample customer
//		Customer customer = new Customer();
//		customer.setIduser(123); // Set the customer's ID
//		customer.setDate("2023-12-17"); // Set the date
//
//		// Create a list of products to be associated with the customer
//		List<Product> productList = new ArrayList<>();
//		productList.add(new Product(1, "Product1", "image1.jpg", 10.0, "Title1", "Description1", 1, 3)); // Example
//																											// product
//		productList.add(new Product(2, "Product2", "image2.jpg", 5.0, "Title2", "Description2", 2, 2)); // Example
//																										// product
//
//		customer.setListPro(productList);
//
//		// Create an instance of the class containing the billOrder1 method
//		DaoMySql instance = new DaoMySql();
//
//		try {
//			// Call the billOrder1 method to insert the product information into the
//			// database
//			instance.setlistProduct(customer);
//
//			System.out.println("Product information inserted successfully!");
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}

	}
	
}
