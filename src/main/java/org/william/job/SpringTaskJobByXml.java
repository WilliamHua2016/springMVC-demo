package org.william.job;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.william.util.LoggerUtil;

@Service("springTaskJobByXml") 
public class SpringTaskJobByXml {
	
	@Autowired
	private ThreadPoolTaskExecutor taskExecutor;
	
	public void springTaskJob(){
		
		System.out.println("这是spring task xml配置方式定时器，每五秒执行一次,START");
		Date date = new Date();  
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        String dateStr = sim.format(date);  
        System.out.println("这是spring task xml配置方式定时器，每五秒执行一次,当前时间：" + dateStr+"END----");  	
        callThreadPoolTask();
    }
	
	private void callThreadPoolTask() {
		taskExecutor.execute(new Runnable() {
			
			@Override
			public void run() {
				LoggerUtil.info(this, "ThreadPoolTaskExecutor demo");
			}
		});
	}

}
