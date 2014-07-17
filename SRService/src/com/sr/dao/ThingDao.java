package com.sr.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ThingDao {
	List<ThingDto> search(@Param("phrase") String phrase);
}
