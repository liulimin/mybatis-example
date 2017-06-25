package org.example.mybatis.databaseidprovider;

import org.apache.ibatis.mapping.DatabaseIdProvider;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by 刘利民 on 2017/6/18.
 */
public class MyDatabaseIdProvider implements DatabaseIdProvider {

    private Properties properties = null;

    @Override
    public void setProperties(Properties p) {
        this.properties = p;
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        String dbName = dataSource.getConnection().getMetaData().getDatabaseProductName();
        String dbId = this.properties.get(dbName).toString();
        return dbId;
    }
}
