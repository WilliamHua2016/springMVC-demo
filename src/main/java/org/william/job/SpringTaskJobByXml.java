package org.william.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service("springTaskJobByXml") 
public class SpringTaskJobByXml {
	
	public void springTaskJob(){
		
		System.out.println("这是spring task xml配置方式定时器，每五秒执行一次,START");
		Date date = new Date();  
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateStr = sim.format(date);  
        System.out.println("这是spring task xml配置方式定时器，每五秒执行一次,当前时间：" + dateStr+"END----");  	
    }

}
