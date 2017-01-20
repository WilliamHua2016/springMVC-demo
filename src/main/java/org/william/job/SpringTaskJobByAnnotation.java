package org.william.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service("springTaskJobByAnnotation") 
public class SpringTaskJobByAnnotation {
	
	@Scheduled(cron = "0/5 * * * * ?")
	public void springTaskJob(){
		
		System.out.println("这是spring task 注解方式定时器，每五秒执行一次,START");
		Date date = new Date();  
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateStr = sim.format(date);  
        System.out.println("这是spring task 注解方式定时器，每五秒执行一次,当前时间：" + dateStr+"END----");  	
    }

}
