import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Exam {

	public static void main(String[] args) {
		Map map = new HashMap();
		map.put("key1", "값이다~");
		map.put("key2", "값이다~");
		map.put("key3", "값이다~");
		map.put("key4", "값이다~");
		map.put("key5", "값이다~");
		map.put("key6", "값이다~");
		map.put("key7", "값이다~");
		map.put("key8", "값이다~");
		map.put("key9", "값이다~");
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext()) {
			String key = it.next().toString();
			System.out.print("key =>" + key);
			System.out.println(",value =>" + map.get(key));
		}
		
	}
}
