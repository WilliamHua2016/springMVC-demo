package org.william.common;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

/**
 * tomcat容器启动时加载初始化数据
 * 
 * @author huawai
 * 
 */
@Component
public class LoadInitResourceService {

	@PostConstruct
	public void postConstruct() {
		loadInitData();
	}

	public void loadInitData() {

		System.out.println("@@@@@@@@@@@@@@容器启动时加载数据到内存@@@@@@@@@@@@@");
	}

}
