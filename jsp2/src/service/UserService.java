package service;

import java.util.Map;

public interface UserService {

	public String insertUser(Map hm);
	public Map<String, String> selectUser(Map hm);
}
