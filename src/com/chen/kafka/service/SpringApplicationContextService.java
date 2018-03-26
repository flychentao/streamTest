package com.chen.kafka.service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * 
 * <p>
 * <pre>
 * <b>类描述：</b>
 * 	注入spring applicationContext
 *  便于在非spring管理的对象中调用spring的bean对象
 * <b>作者：</b>
 * 	chentaoaa
 * <b>创建时间：</b> 
 * 	2017年3月23日 下午1:59:02
 * </pre>
 * </p>
 */
@Service
public class SpringApplicationContextService  implements ApplicationContextAware {  
	  
    private static ApplicationContext context;  
  
    @Override  
    public void setApplicationContext(ApplicationContext context) throws BeansException {  
    	SpringApplicationContextService.context = context;  
    }  
     
    /**
     * 
     * <p>
     * <pre>
     * <b>方法描述：</b>
     * 	获取spring 的bean对象
     * <b>作者：</b>
     * 	chentaoaa
     * <b>创建时间：</b> 
     * 	2017年3月23日 下午2:00:38
     * </pre>
     * @param beanName
     * @return
     * </p>
     */
    public static Object getSpringBean(String beanName) {  
        if(StringUtils.isNotBlank(beanName)){
        	return context==null?null:context.getBean(beanName);          	
        }
        return null;
    }  

}
