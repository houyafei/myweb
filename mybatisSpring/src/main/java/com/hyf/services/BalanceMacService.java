package com.hyf.services;

import com.hyf.mappers.mappers.BalanceMacMapper;
import com.hyf.models.BalanceMacModel;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 数据处理
 *
 * @author yafei.hou  on 2018/3/20
 */
public class BalanceMacService {


    private static final SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();


    private SqlSessionFactory sqlSessionFactory;

    public BalanceMacService() {
        initMethod();
    }

    public BalanceMacService(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    private void initMethod() {
        InputStream stream = null;
        try {
            stream = Resources.getResourceAsStream("SqlMapConfig.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = sqlSessionFactoryBuilder.build(stream);
    }


    public void insertBalanceMac() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BalanceMacMapper balanceMacMapper = sqlSession.getMapper(BalanceMacMapper.class);
        List<BalanceMacModel> list = new ArrayList<BalanceMacModel>();
        BalanceMacModel balanceMacModel = new BalanceMacModel();
        balanceMacModel.setMac("11111eees");
        balanceMacModel.setCreateTime(new Date());
        balanceMacModel.setOrderNumber(12232112);
        balanceMacModel.setSnNumber("adjfjasdw");
        balanceMacModel.setType("s9");
        list.add(balanceMacModel);
        balanceMacMapper.insertBalanceMac(list);

    }

}
