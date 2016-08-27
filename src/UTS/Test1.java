/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package UTS;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserMapper;

public class Test1 extends TestCase {
	public void test01() {
		UserMapper um = (UserMapper) new ClassPathXmlApplicationContext(
				"spring-application.xml").getBean("userMapper");
		System.out.println(um.selectByUserName("hxg").getuPassword());
	}
	public void test2(){
		Map map=new HashMap();
		map.put(1, 2);
		map.put(2, 3);
		System.out.println(map.size());
		map.remove(1);
		System.out.println(map);
		System.out.println(map.size());
	}
}
