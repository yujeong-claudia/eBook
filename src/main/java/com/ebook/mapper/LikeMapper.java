package com.ebook.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LikeMapper {

	// input:X   output:List<Map>
	public List<Map<String, Object>> selectLikeList();
}
