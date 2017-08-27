import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exam {

	public static void main(String[] args) {
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		for(int i=1,max=5;i<=max;i++) {
			Map<String, String> hm = new HashMap<String,String>();
			hm.put("test", "value"+i);
			list.add(hm);
		}
		
		for(Map<String,String>m:list) {
			System.out.println(m);
		}
	}
}
