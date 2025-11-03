package com.mariam.sprin_jdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.mariam.sprin_jdbc.entity.Student;

public class CustomResultSetExtractor_getByAddress implements ResultSetExtractor<Map<String, List<String>>>{

	@Override
	public Map<String, List<String>> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		
		Map<String, List<String>> map = new HashMap<>();
		
		while(rs.next()) {
			
			String name = rs.getString("name");
			String address = rs.getString("address");
			
			if(!map.containsKey(address)) {
				
				List<String> names = new ArrayList<>();
				names.add(name);
				
				map.put(address, names);
				
			}else {
					List<String> list = map.get(address);			
				    list.add(name);
			}
					
		}
		return map;
	}

	
	
}
