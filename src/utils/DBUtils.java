package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class DBUtils {
	public static boolean verifyReader(int number, String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select number, password from reader where number = ? and password = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);
			st.setString(2, password);

			rs = st.executeQuery();
			rs.last();
			if (rs.getRow() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
		return false;
	}

	public static Map<String, Object> getStudentInfo(int number) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		Map<String, Object> resultMap = new HashMap<String, Object>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select number, name, sex, age, telephone, email from reader where number = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);

			rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int count = rsmd.getColumnCount();
			String[] colNames = new String[count];
			for (int i = 1; i <= count; i++) {
				colNames[i - 1] = rsmd.getColumnLabel(i);
			}

			while (rs.next()) {
				for (String column : colNames) {
					resultMap.put(column, rs.getObject(column));
				}
			}

			return resultMap;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static boolean updateReaderInfo(int number, String telephone, String age, String email) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "update reader set telephone = ?, age = ?, email = ? where number = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, telephone);
			st.setInt(2, Integer.valueOf(age));
			st.setString(3, email);
			st.setInt(4, number);

			int result = st.executeUpdate();
			return result != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static boolean updateReaderPassword(int number, String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "update reader set password = ? where number = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, password);
			st.setInt(2, number);

			int result = st.executeUpdate();
			return result != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static String getNowPassword(int number) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "select password from reader where number = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);

			rs = st.executeQuery();
			rs.next();
			return rs.getString("password");
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static boolean checkReaderNumber(int number) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select number from reader where number = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);

			rs = st.executeQuery();
			rs.last();
			if (rs.getRow() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
		return false;
	}

	public static boolean registerReader(int number, String name, String sex, String email, String telephone,
			String age, String password, String verifyPassword) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "insert into reader(number, name, sex, email, telephone, age, password) "
					+ "values (?,		 ?,	   ?,   ?,     ?,         ?,   ?)";
			st = conn.prepareStatement(sql);
			st.setString(2, name);
			st.setInt(1, number);
			st.setString(3, sex);
			st.setString(4, email);
			st.setString(5, telephone);
			st.setString(6, age);
			st.setString(7, password);

			int result = st.executeUpdate();
			return result != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static Vector<Vector<String>> getAllBookInfos() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select name, isbn, book_writer, publish_press, publish_time, total, remain from book";
			st = conn.prepareStatement(sql);

			rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Vector<String> rowData = new Vector<>();

				for (int j = 1; j < columnCount + 1; j++) {
					rowData.add(rs.getString(j));
				}
				resultData.add(rowData);
			}
			return resultData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static Vector<Vector<String>> getBookInfo(String bookName) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select isbn, name, book_writer, publish_press, publish_time, total, remain from book "
					+ "where name like ?";
			st = conn.prepareStatement(sql);
			st.setString(1, "%" + bookName + "%");

			rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Vector<String> rowData = new Vector<>();

				for (int j = 1; j < columnCount + 1; j++) {
					rowData.add(rs.getString(j));
				}
				resultData.add(rowData);
			}
			return resultData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static boolean borrowOneBook(int number, String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "insert into borrow(reader_number, isbn, borrow_time) " + "values (?,		 ?,	   now())";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);
			st.setString(2, isbn);

			int result = st.executeUpdate();

			String sql2 = "update book set remain = remain - 1 where isbn = ?";
			st = conn.prepareStatement(sql2);
			st.setString(1, isbn);
			int result2 = st.executeUpdate();

			return result != 0 && result2 != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static boolean verifyBorrow(int readerNumber, String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select reader_number, isbn from borrow where reader_number = ? and isbn = ? and borrow_time is not null";
			st = conn.prepareStatement(sql);
			st.setInt(1, readerNumber);
			st.setString(2, isbn);

			rs = st.executeQuery();
			rs.last();
			if (rs.getRow() > 0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
		return false;
	}

	public static Vector<Vector<String>> getAllBorrowedBookInfos(int number) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select book.name, book.isbn, book_writer, publish_press, publish_time, borrow_time from reader, borrow, book "
					+ "WHERE reader.number = borrow.reader_number AND book.isbn = borrow.isbn AND reader.number = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);

			rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Vector<String> rowData = new Vector<>();

				for (int j = 1; j < columnCount + 1; j++) {
					rowData.add(rs.getString(j));
				}
				resultData.add(rowData);
			}
			return resultData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static Vector<Vector<String>> getBorrowedBookInfos(Integer number, String bookName) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select book.name, book.isbn, book_writer, publish_press, publish_time, borrow_time from reader, borrow, book "
					+ "WHERE reader.number = borrow.reader_number AND book.isbn = borrow.isbn AND reader.number = ? and book.name like ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);
			st.setString(2, "%" + bookName + "%");

			rs = st.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while (rs.next()) {
				Vector<String> rowData = new Vector<>();

				for (int j = 1; j < columnCount + 1; j++) {
					rowData.add(rs.getString(j));
				}
				resultData.add(rowData);
			}
			return resultData;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

	public static boolean returnOneBook(int number, String isbn) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "delete from borrow where reader_number = ? and isbn = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);
			st.setString(2, isbn);

			int result = st.executeUpdate();

//			String sql2 = "insert into borrow_history(reader_number,isbn,borrow_time) select reader_number, isbn, borrow_time from borrow where reader_number = ? and isbn = ?";
//			st = conn.prepareStatement(sql2);
//			st.setInt(1, number);
//			st.setString(2, isbn);
//
//			int result2 = st.executeUpdate();
//			
//			String sql3 = "update borrow_history set return_time = now() where reader_number = ? and isbn = ?";
//			st = conn.prepareStatement(sql3);
//			st.setInt(1, number);
//			st.setString(2, isbn);
//
//			int result3 = st.executeUpdate();

			String sql4 = "update book set remain = remain + 1 where isbn = ?";
			st = conn.prepareStatement(sql4);
			st.setString(1, isbn);
			int result4 = st.executeUpdate();

			return result != 0 && /** result2!=0 && result3 != 0 && **/
					result4 != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
}
