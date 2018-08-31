package com.util;

import java.util.HashMap;
import java.util.Map;

public class QueryBuilderFactory {

	Map<QueryBuilderType, QueryBuilder> queryBuilders;
	
	{
		queryBuilders = new HashMap<QueryBuilderType, QueryBuilder>();
		queryBuilders.put(QueryBuilderType.CurrentTimeAndDay, new CurrentTimeFoodTruckQueryBuilder());
	}
	
	public QueryBuilder getQueryBuilder(QueryBuilderType queryBuilderType) {
		return queryBuilders.get(queryBuilderType);
	}
}
