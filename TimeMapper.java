package com.zerock.myapp.persistence;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	@Select("SELECT sysdate FROM dual")
	public abstract String getNow();
	
} // end interface
