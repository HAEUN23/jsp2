package service;

import java.util.Map;

public interface UserService {

	public String insertUser(Map<String, String>  hm);
	public Map<String, String> selectUser(Map<String, String>  hm);
}
