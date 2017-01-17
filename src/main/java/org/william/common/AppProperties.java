package org.william.common;

import org.springframework.beans.factory.annotation.Value;

public class AppProperties {

	@Value("myProperty.testKey")
	private String testKey;

	public String getTestKey() {
		return testKey;
	}

}
