package org.example.mybatis.persistence;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.domain.Sex;
import org.example.mybatis.domain.User;
import org.junit.Test;

public class UserPersistenceByMapperTest {
    @Test
    public void userDaoTest() throws Exception {
        String resource = "mybatis-config.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(reader);

        SqlSession session = factory.openSession();
        UserMapper userMapper = session.getMapper(UserMapper.class);

        User user = new User();
        user.setUserName("hongye");
        user.setPassword("123456");
        user.setComment("备注");
        user.setSex(Sex.FMAIL);
        user.setSex2(Sex.FMAIL);
        user.setSex3(Sex.FMAIL);

        userMapper.insert(user);

        /*List<User> users = userMapper.selectAll();
        Iterator<User> iter = users.iterator();
        while (iter.hasNext()) {
            User u = iter.next();
            System.out.println("用" +
                    "户名：" + u.getUserName() + "密码："
                    + u.getPassword() + " 性别：" + u.getSex());
        }*/

        session.commit();
        session.close();
    }
}