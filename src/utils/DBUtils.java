package utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

import javax.swing.JOptionPane;

public class DBUtils {
	public static boolean verifyReader(int number, String password) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select number, password from reader where number = ? and   password = ? ";
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
//new Adminenter 鍏ュ彛
	public static boolean verifyAdmin(int number, String password,String name) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select number, password ,name from admin where number = ? and password = ?";
			//琛ㄧず鏁版嵁搴撴彃鍙欐牸寮�
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
	
	public static boolean chongzhi_Password(int number) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "update reader set password =123456  where number = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);

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
	
	//new 鍦∟ewspaper瀵煎叆鏃跺�欎娇鐢ㄧ殑鏂规硶 鎶ュ垔鍏ュ簱
	public static boolean checkNews_Number(String name) {  //鍒ゆ柇鎶ュ垔鏄惁瀛樺湪,鍚堢悊鎬�
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select name from reader where name  = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, name);

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
	//鏂板缓鏂规硶  娣诲姞鏁版嵁News_paper
	public static boolean registerNEWS(String  name,String publish_press,String publish_Time,int  total,int price, String author) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "insert into book( name, publish_press,book_writer,publish_Time,  total,remain, price) "
					+ "values (?,    ?,	   ?,   ?,     ?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, publish_press);
			st.setString(3,author);
			st.setString(4, publish_Time);
			st.setInt(5, total);
			st.setInt(6,total);
			st.setInt(7, price);
			

			int result = st.executeUpdate();
			return result != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	
	
// 浠ヤ笅浠ｇ爜  锛氳繑鍥炰竴涓〃鏁版嵁鍦ㄥ埗浣滆〃鏃跺�欑敤鍒帮紝鍦∟ewspaperBorrowedTableModel涓娇鐢紝浼犺緭data 鍙橀噺
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
			return resultData;//杩斿洖涓�涓〃鏁版嵁鍦ㄥ埗浣滆〃鏃跺�欑敤鍒帮紝鍦∟ewspaperBorrowedTableModel涓娇鐢紝浼犺緭data 鍙橀噺
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	
	
	public static Vector<Vector<String>> getAllreaderInfos() {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from borrow";
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
			return resultData;//杩斿洖涓�涓〃鏁版嵁鍦ㄥ埗浣滆〃鏃跺�欑敤鍒帮紝鍦∟ewspaperBorrowedTableModel涓娇鐢紝浼犺緭data 鍙橀噺
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	
	public static Vector<Vector<String>> getBookInfo(String bookName) {//鏌ヨ涔﹀悕
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select name, isbn, book_writer, publish_press, publish_time, total, remain from book "
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
	
	public static Vector<Vector<String>> getreadernumInfo(String num) {//鏌ヨ浜哄悕鐨勫彿鐮�
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Vector<Vector<String>> resultData = new Vector<>();
		try {
			conn = JDBCUtils.getConnection();

			String sql = "select * from borrow "
					+ "where reader_number = ?";
			st = conn.prepareStatement(sql);
			int number=Integer.parseInt(num);
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
	
	public static boolean borrowOneBook(int number, String isbn) {//璁㈤槄涓�鏈�
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			conn = JDBCUtils.getConnection();

			String sql = "insert into borrow(reader_number, isbn, borrow_time,shixiao_time) " + "values (?,		 ?,	   now(),date_add(CURRENT_DATE(), interval 1 year ))";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);
			st.setString(2, isbn);
			int result = st.executeUpdate();

			String sql2 = "update book set remain = remain - 1 where isbn = ?";
			st = conn.prepareStatement(sql2);
			st.setString(1, isbn);
			int result2 = st.executeUpdate();
			
			//杩樿鏀�   澧炲姞history鐨勮褰�  涓嶈褰曞綊杩樻椂闂�                 閿欎簡
			/*String sql3 = "insert into borrow_history(reader_number, isbn, borrow_time) " + "values (?,		 ?, now())";
			//String sql3 = "insert into borrow(reader_number, isbn, borrow_time) " + "values (?,		 ?,	   now())";
			st = conn.prepareStatement(sql3);
			st.setInt(1, number);
			st.setString(2, isbn);
			int result3 = st.executeUpdate();*/
			
			

			return result != 0 && result2 != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	
	///////
	public static boolean jiechu_borrowOneBook(int number, String isbn) {//瑙ｉ櫎璁㈤槄
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		int isbn2=Integer.valueOf(isbn);
		//鏃堕棿绫诲瀷
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		
		

		try {
			conn = JDBCUtils.getConnection();
			
		
			String sql0= "select borrow_time into Timestamp from borrow where isbn=? and number =?";//鏌ヨ鍊熼槄鏃堕棿
			st = conn.prepareStatement(sql0);
			st.setInt(1, number);
			st.setString(2, isbn);
	
			String sql = "delete from borrow "+
					"where isbn=? and reader_number=?";//鍒犻櫎璁板綍瀹屾垚
			st = conn.prepareStatement(sql);
			st.setInt(1, isbn2);
			st.setInt(2, number);
			int result = st.executeUpdate();
	
			//澧炲姞history璁板綍锛屽�熼槄鐨勮褰�
			String sql1 = "insert into borrow_history(reader_number, isbn, borrow_time,return_time) " + "values (?,		 ?,?,   now())";
			st = conn.prepareStatement(sql1);
			st.setInt(1, number);
			st.setString(2, isbn);
			st.setTimestamp(3, sqlTime);
			int result1 = st.executeUpdate();

			String sql2 = "update book set remain = remain + 1 where isbn = ?";//鐩稿叧鐨勮褰曞鍔�1鏈�
			st = conn.prepareStatement(sql2);
			st.setString(1, isbn);
			int result2 = st.executeUpdate();
		
			
			//return result != 0 && result2 != 0 && result1 != 0;
			return result != 0 ;//&& result2 != 0 ;
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

			String sql = "select book.name, book.isbn, book_writer, publish_press, publish_time, borrow_time from reader, borrow, book_view2"
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
			
			

			
			/*String sql3 = "insert into borrow_history(reader_number, isbn, borrow_time) " + "values (?,		 ?, now())";
			//String sql3 = "insert into borrow(reader_number, isbn, borrow_time) " + "values (?,		 ?,	   now())";
			st = conn.prepareStatement(sql3);
			st.setInt(1, number);
			st.setString(2, isbn);
			int result3 = st.executeUpdate();*/
			//娣诲姞鏁版嵁   浼氭湁涓�鐐归棶棰�
			//String sql1 = "insert into borrow_history(reader_number, isbn, borrow_time,return_time) " + "values (?,		 ?,?,   now())";
			String sql2 = "insert into borrow_history(reader_number,isbn,borrow_time) (select reader_number, isbn, borrow_time from borrow where reader_number = ? and isbn = ?)";
			st = conn.prepareStatement(sql2);
			st.setInt(1, number);
			st.setString(2, isbn);
			int result2 = st.executeUpdate();
			
			//鍒犻櫎borrow琛ㄧ殑璁板綍
			String sql = "delete from borrow where reader_number = ? and isbn = ?";
			st = conn.prepareStatement(sql);
			st.setInt(1, number);
			st.setString(2, isbn);
			int result = st.executeUpdate();
			
			
			//String sql3 = "update borrow_history set return_time = now() where reader_number = ? and isbn = ? ";
			String sql3 = "update borrow_history set return_time = now() where reader_number = ? and isbn = ?  order by id desc limit 1";
			st = conn.prepareStatement(sql3);
			st.setInt(1, number);
			st.setString(2, isbn);
			int result3 = st.executeUpdate();
			
			
			String sql4 = "update book set remain = remain + 1 where isbn = ?";
			st = conn.prepareStatement(sql4);
			st.setString(1, isbn);
			int result4 = st.executeUpdate();

			return result != 0 && result2!=0 && result3 != 0 && result4 != 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtils.release(conn, st, rs);
		}
	}

    //删除报刊	
	public static boolean deletePaper(String PNo) {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtils.getConnection();
			String sql="delete from book where isbn =?";
			st=conn.prepareStatement(sql);
			st.setString(1, PNo);
			int result=st.executeUpdate();
			return result!=0;
			/**
			 * 
			 * 
			 * 
			 * 		
			} catch (Exception e) {
			e.printStackTrace();
			return null;
			
			
			 */
		} catch (Exception e) {
		e.printStackTrace();
			return false;
		}finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	
	//报刊名修改
	public static boolean changePaperName(String PNo, String Pname) {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtils.getConnection();
			
			String sql="update book set name = ? where isbn = ?";
			st=conn.prepareStatement(sql);
			st.setString(1, Pname);
			st.setString(2, PNo);
			int result=st.executeUpdate();
			return result!=0;
		} catch (Exception e) 
		{
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	//报刊作者修改
	public static boolean changePaperWriter(String PNo, String Pwriter) {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtils.getConnection();
			
			String sql="update book set book_writer = ? where isbn = ?";
			st=conn.prepareStatement(sql);
			st.setString(1, Pwriter);
			st.setString(2, PNo);
			int result=st.executeUpdate();
			return result!=0;
		} catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	//报刊出版社修改
	public static boolean changePaperPress(String PNo, String Ppress) {
		Connection conn=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		
		try {
			conn=JDBCUtils.getConnection();
			
			String sql="update book set publish_press = ? where isbn = ?";
			st=conn.prepareStatement(sql);
			st.setString(1, Ppress);
			st.setString(2, PNo);
			int result=st.executeUpdate();
			return result!=0;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}finally {
			JDBCUtils.release(conn, st, rs);
		}
	}
	//报刊出版时间修改
		public static boolean changePapertime(String PNo, String Ptime) {
			Connection conn=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			
			try {
				conn=JDBCUtils.getConnection();
				
				String sql="update book set publish_time = ? where isbn = ?";
				st=conn.prepareStatement(sql);
				st.setString(1, Ptime);
				st.setString(2, PNo);
				int result=st.executeUpdate();
				return result!=0;
			} catch (Exception e)
			{
				e.printStackTrace();
				return false;
			}finally {
				JDBCUtils.release(conn, st, rs);
			}
		}
		//报刊出版价格修改
				public static boolean changePaperprice(String PNo, String Pprice) {
					Connection conn=null;
					PreparedStatement st=null;
					ResultSet rs=null;
					
					try {
						conn=JDBCUtils.getConnection();
						
						String sql="update book set price = ? where isbn = ?";
						st=conn.prepareStatement(sql);
						st.setString(1, Pprice);
						st.setString(2, PNo);
						int result=st.executeUpdate();
						return result!=0;
					} catch (Exception e)
					{
						e.printStackTrace();
						return false;
					}finally {
						JDBCUtils.release(conn, st, rs);
					}
				}
		
}
