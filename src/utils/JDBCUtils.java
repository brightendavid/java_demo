package utils;//Java 连接 MySQL 需要驱动包在lib目录

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;

/**
 * 
 * JDBC工具类，数据库连接和释放连接
 */
public class JDBCUtils {
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;

	// 加载驱动，获取数据库连接信息
	static {
		try {
			// 加载配置文件
			InputStream in = JDBCUtils.class.getResourceAsStream("DB.properties");
			Properties properties = new Properties();
			properties.load(in);
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			password = properties.getProperty("password");
			// 加载驱动，必须先导入驱动JAR包
			Class.forName(driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 获取数据库连接
	 * 
	 * @throws SQLException
	 */
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 释放资源
	 * 
	 * @param connection
	 * @param statement
	 * @param resultSet
	 */
	public static void release(Connection connection, PreparedStatement statement, ResultSet resultSet) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
