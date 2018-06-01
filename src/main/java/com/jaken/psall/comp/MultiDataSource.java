package com.jaken.psall.comp;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

public class MultiDataSource extends AbstractRoutingDataSource{

	private static final ThreadLocal<String> dataSourceKey = new ThreadLocal<String>();
	
	public static void setDatasourceKey(String key){
		dataSourceKey.set(key);
	}
	
	@Override
	protected Object determineCurrentLookupKey() {
		return dataSourceKey.get();
	}

	
}
