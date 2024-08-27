package com.spark.lms.common;

import java.util.ArrayList;
import java.util.List;

public class Constants {

	public static final String ROLE_ADMIN = "Admin";
	public static final String ROLE_LIBRARIAN = "Librarian";
	
	public static final String MEMBER_22IT1 = "22IT1";
	public static final String MEMBER_22IT2 = "22IT2";
	public static final String MEMBER_22IT3 = "22IT3";
	public static final List<String> MEMBER_TYPES = new ArrayList<String>() {{
	    add(MEMBER_22IT1);
	    add(MEMBER_22IT2);
	    add(MEMBER_22IT3);
	}};
	
	public static final Integer BOOK_STATUS_AVAILABLE = 1;
	public static final Integer BOOK_STATUS_ISSUED = 2;
	
	public static final Integer BOOK_NOT_RETURNED = 0;
	public static final Integer BOOK_RETURNED = 1;
}
