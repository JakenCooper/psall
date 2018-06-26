package com.jaken.psall.util;

import java.util.Arrays;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;

public class EncryptPropertyPlaceHolder extends PropertyPlaceholderConfigurer{

	private static final String[] ENCRYPT_PROP_NAMES;
	
	static{
		ENCRYPT_PROP_NAMES = new String[]{"jdbc.user","jdbc.password"};
		Arrays.sort(ENCRYPT_PROP_NAMES);
	}


	@Override
	protected String convertProperty(String propertyName, String propertyValue) {
		if(Arrays.binarySearch(ENCRYPT_PROP_NAMES, propertyName) < 0){
			return propertyValue;
		}
		if(StringUtils.isBlank(propertyValue)){
			return "";
		}
		try {
			String decryptedValue = Des.decrypt(propertyValue);
			return decryptedValue;
		} catch (Exception e) {
			e.printStackTrace();
			return propertyValue;
		}
	}
	
	
	public static void main(String[] args) {
		int index1 = Arrays.binarySearch(ENCRYPT_PROP_NAMES,"jdbc.password");
		int index2 =Arrays.binarySearch(ENCRYPT_PROP_NAMES, "jdbc.passwor");
		System.out.println(index1+" --- "+index2);
	}
}
