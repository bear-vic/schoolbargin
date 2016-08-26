/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package UTS;

import junit.framework.TestCase;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.UserMapper;

public class Test1 extends TestCase {
	public void test01() {
		UserMapper um = (UserMapper) new ClassPathXmlApplicationContext(
				"spring-application.xml").getBean("userMapper");
		System.out.println(um.selectByUserName("hxg").getuPassword());
	}
}
