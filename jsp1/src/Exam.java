import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Exam {

	public static void main(String[] args) {
		String sql ="update user";
		sql += " set id='blue'";
		sql += " where user_no=5";
		System.out.println(sql);
		
	}
}
