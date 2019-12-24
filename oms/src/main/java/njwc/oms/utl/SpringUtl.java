package njwc.oms.utl;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public final class SpringUtl implements ApplicationContextAware {
	private static ApplicationContext applicationContext = null;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		if (SpringUtl.applicationContext == null) {
			SpringUtl.applicationContext = applicationContext;
		}
	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	//通过
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
	
	//通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
           return getApplicationContext().getBean(clazz);
    }
}
