package org.example.mybatis.sql;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class AddressSqlProvider {
	private static final String TABLE_NAME = "t_address";
	
	public String getSelectAllSql() {
		BEGIN();
		SELECT("*");
		FROM(TABLE_NAME);
		return SQL();
	}
}
