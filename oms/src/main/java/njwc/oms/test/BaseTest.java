package njwc.oms.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 *
 ����spring��junit���ϣ�junit����ʱ����springIOC���� 
 */
@RunWith(SpringJUnit4ClassRunner.class)
//����junit spring�����ļ�
/*
 * @ContextConfiguration({"file:WebContent/WEB-INF/njwc-servlet.xml",
 * "classpath:config/*.xml", "file:WebContent/WEB-INF/web.xml",
 * "classpath:njwc.oms.mapper/ServiceMapper.xml"})
 */
@ContextConfiguration({"file:WebContent/WEB-INF/njwc-servlet.xml","classpath:config/beans.xml"})

public class BaseTest {

}
