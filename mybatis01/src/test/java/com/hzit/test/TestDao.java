package com.hzit.test;

import com.hzit.dao.TblClassMapper;
import com.hzit.dao.TblStudentMapper;
import com.hzit.dao.UserInfoDao;
import com.hzit.entity.TblClass;
import com.hzit.entity.Tblstudent;
import com.hzit.entity.UserInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Administrator on 2016/9/6.
 */
public class TestDao {
    String resource = "config.xml";
    UserInfoDao dao = null;
    TblClassMapper tblClassMapper;
    @Before
    public void inist() {
        try {
            Reader reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession sqlSession = factory.openSession();
            dao = sqlSession.getMapper(UserInfoDao.class);
            tblClassMapper=sqlSession.getMapper(TblClassMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testFindAll(){
        List<UserInfo> list= dao.findAll();
        for(UserInfo u : list){
            System.out.println(u);
        //    System.out.println(u.getUsernmae()+"\t"+u.getPass());
        }

    }
    @Test
    public void testClass(){

        TblClass c= tblClassMapper.findById("001");
        System.out.println(c.getCid()+c.getCname()+"老师"+c.getTblTeacher().getTeaName());
    }

}
