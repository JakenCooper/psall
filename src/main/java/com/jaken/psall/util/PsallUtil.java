package com.jaken.psall.util;

import java.util.UUID;

public class PsallUtil {
	public synchronized static String genUUID(){
		return UUID.randomUUID().toString();
	}
}
