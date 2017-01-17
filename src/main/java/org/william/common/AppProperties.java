package org.william.common;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppProperties {

	@Value("myProperty.testKey")
	private String testKey;

	public String getTestKey() {
		return testKey;
	}

}
