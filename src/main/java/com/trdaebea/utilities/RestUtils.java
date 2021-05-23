package com.trdaebea.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
public static String first_name() {
	String generatedString = RandomStringUtils.randomAlphabetic(1);
	return ("john"+generatedString);
	
}
public static String last_name() {
	String generatedString = RandomStringUtils.randomAlphabetic(1);
	return ("ram"+generatedString);
	
}

}
