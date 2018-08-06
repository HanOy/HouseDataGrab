package com.oyh;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
	public static void main(String[] args) throws Exception {
		JdbcUtils jdbc = new JdbcUtils();
		jdbc.getConnection();
		String sql = "select district,community from house";
		
		List<Map<String,Object>> list = jdbc.findResult(sql, null);
		
		List<String> result = new ArrayList<String>();
		for (Map<String, Object> map : list) {
			result.add(map.get("district").toString() + map.get("community").toString());
		}
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(result);
		System.out.println(jsonStr);
		
	}
}
