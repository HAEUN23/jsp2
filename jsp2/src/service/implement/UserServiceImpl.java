package service.implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Map;

import common.DBConnector;
import service.UserService;

public class UserServiceImpl implements UserService {

	@Override
	public String insertUser(Map hm) {

		String result = hm.get("name") + "님 뭔 이윤지는 모르겄는디 회원가입 실패했어요.";
		Connection con;
		try {
			con = DBConnector.getCon();
			String sql = "insert into user(id,password,name,hobby)";
			sql += " values(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, (String)hm.get("id"));
			ps.setString(2, (String)hm.get("pwd"));
			ps.setString(3, (String)hm.get("name"));
			ps.setString(4, (String)hm.get("hobby"));
			int row = ps.executeUpdate();
			if(row==1) {
				result = hm.get("name") + "님 회원가입에 성공하셨습니다.";
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Map<String, String> selectUser(Map hm) {
		// TODO Auto-generated method stub
		return null;
	}

}
