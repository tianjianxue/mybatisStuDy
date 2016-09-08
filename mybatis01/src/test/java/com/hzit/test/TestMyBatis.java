package com.hzit.test;

import com.hzit.dao.TblStudentMapper;
import com.hzit.entity.Tblstudent;
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
public class TestMyBatis {
    String resource = "config.xml";
    SqlSession sqlSession;

    @Before
    public void inist(){
        try {
            Reader reader=Resources.getResourceAsReader(resource);
            SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(reader);
            sqlSession= factory.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testselectone(){
        String statument="com.hzit.dao.TblStudentMapper.findById";
        Tblstudent tblstudent= sqlSession.selectOne(statument,123);
        System.out.println(tblstudent);
    }
    @Test
    public void testselectAll(){
        String statument="com.hzit.dao.TblStudentMapper.findAll";
        List<Tblstudent> tblstudent= sqlSession.selectList(statument);
        System.out.println(tblstudent);
    }
    @Test
    public void testselect(){
        String statument="com.hzit.dao.TblStudentMapper.findAll";
        sqlSession.select(statument, new ResultHandler() {
            public void handleResult(ResultContext resultContext) {
                Tblstudent tbl=(Tblstudent)resultContext.getResultObject();
                System.out.println(tbl);
            }
        });
    }
    @Test
    public void testInsert(){
        String statment="com.hzit.dao.TblStudentMapper.add";
        Tblstudent tbl=new Tblstudent();
        tbl.setStuAge("20");
        tbl.setStuName("jack");
        tbl.setStuSex("男");
        sqlSession.insert(statment,tbl);
        sqlSession.commit();
    }
    @Test
    public void testdel(){
        String statment="com.hzit.dao.TblStudentMapper.del";
        int num=sqlSession.delete(statment,1022);
        System.out.println(num);
        sqlSession.commit();
    }
    @Test
    public void testupdate(){
        String statment="com.hzit.dao.TblStudentMapper.update";
        Tblstudent tbl=new Tblstudent();
        tbl.setStuAge("20");
        tbl.setStuName("123");
        tbl.setStuSex("男");
        tbl.setStuId(1023);
        int num=sqlSession.update(statment,tbl);
        System.out.println(num);
        sqlSession.commit();
    }
    @Test
    public void testFenYe(){
        String statment="com.hzit.dao.TblStudentMapper.findAll";
        List<Tblstudent> data=sqlSession.selectList(statment,null,new RowBounds(5,10));
        System.out.println(data.size());
        for(Tblstudent tbl :data){
            System.out.println(tbl);
        }
        sqlSession.commit();
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
