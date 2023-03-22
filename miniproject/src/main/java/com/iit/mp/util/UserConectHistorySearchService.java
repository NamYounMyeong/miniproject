package com.iit.mp.util;

import java.util.HashMap;
import java.util.List;

public interface UserConectHistorySearchService {

	public List<HashMap<String, Object>> selectListLog(HashMap<String, Object> param); 
	
	public int saveLog(HashMap<String, Object> param);
	
	public String selectlastStatus();
	
}
