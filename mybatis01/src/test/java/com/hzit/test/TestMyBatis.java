package com.hzit.test;

import com.hzit.dao.TblStudentMapper;
import com.hzit.entity.Tblstudent;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class TestMyBatis {
    String resource = "config.xml";
    @Test
    public void one(){

        //加载mybatis的配置文件（它也加载关联的映射文件）
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        //映射sql的标识字符串
        String statement = "com.hzit.dao.TblStudent.findList";
        //执行查询返回一个唯一user对象的sql
        List<Tblstudent> user = session.selectList(statement);
        System.out.println(user.size());

    }

    @Test
    public void two(){
        try {
            Reader reader= Resources.getResourceAsReader(resource);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
            SqlSession session= factory.openSession();
            TblStudentMapper mapper= session.getMapper(TblStudentMapper.class);
            List<Tblstudent> list= mapper.findAll();
            System.out.println(list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
