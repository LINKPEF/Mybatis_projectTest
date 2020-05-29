package com.itheima.test;


import com.itheima.Dao.IUserDao;
import com.itheima.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 *
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception{
        //1读取配置文件 连接数据库
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");

        //2创建sqlSessionfactory工厂 生产操作对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);

        //3使用工厂生产sqlsession对象 操作数据库
        SqlSession session = factory.openSession();
        //4使用sqlsession创建dao接口的代理对象
        IUserDao userdao = session.getMapper(IUserDao.class);
        //5使用代理对象执行方法
        List<User> users = userdao.findAll();
        for(User user:users){
            System.out.println(user);
        }
        //6释放资源
        session.close();
        in.close();
    }
}
