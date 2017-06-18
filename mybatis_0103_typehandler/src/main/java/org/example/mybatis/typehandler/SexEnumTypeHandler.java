package org.example.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.example.mybatis.domain.Sex;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by 刘利民 on 2017/6/18.
 */
public class SexEnumTypeHandler implements TypeHandler<Sex> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Sex parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getI());
    }

    @Override
    public Sex getResult(ResultSet rs, String columnName) throws SQLException {
        int i = rs.getInt(columnName);
        return Sex.getSex(i);
    }

    @Override
    public Sex getResult(ResultSet rs, int columnIndex) throws SQLException {
        int i  = rs.getInt(columnIndex);
        return Sex.getSex(i);
    }

    @Override
    public Sex getResult(CallableStatement cs, int columnIndex) throws SQLException {
        int i = cs.getInt(columnIndex);
        return Sex.getSex(i);
    }
}
