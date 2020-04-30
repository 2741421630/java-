package com.xuexiaotian.bookstore.dao.impl;

import com.xuexiaotian.bookstore.dao.Dao;
import com.xuexiaotian.bookstore.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.*;
import java.util.List;

public class BaseDao<T> implements Dao<T> {
    private QueryRunner queryRunner = new QueryRunner();
    //获取当前类的父接口的泛型
    private Class<T> clazz;
    public BaseDao(){
        Type Superclass = this.getClass().getGenericSuperclass();
        if(Superclass instanceof ParameterizedType){
            ParameterizedType parameterizedType = (ParameterizedType) Superclass;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            if (typeArguments != null && typeArguments.length>0) {
                if(typeArguments[0] instanceof Class) {
                    clazz = (Class<T>) typeArguments[0];
                }
            }
        }
    }


    //1.添加一条记录并返回自动生成的主键,用原生的方式去实现;
    @Override
    public long insert(String sql, Object... args) {
        long id = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            //1.获取数据库的连接;
            conn = JdbcUtils.getConnection();
            //2.创建prepadstatem对象;
            ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            //3.填充sql语句中的占位符;
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            //4.执行sql语句;
            ps.executeUpdate();
            //5.获取自动生成的主键;
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //6.关闭相应的资源,结果集,prepadstatem对象,数据库的连接.
            JdbcUtils.release(rs,ps,conn);
        }
        return id;
    }
    //2.正常的增删改的更新操作;
    @Override
    public void update(String sql, Object... args) {
        Connection connection = null;
        try {
            //1.获取数据库的连接;
            connection = JdbcUtils.getConnection();
            //2.使用QueryRunner对象执行sql语句;
            queryRunner.update(connection,sql,args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //3.关闭相关资源
            JdbcUtils.release(connection);
        }
    }

    @Override
    public T getBean(String sql, Object... args) {
        Connection connection = null;
        try {
            //1.获取数据库的连接;
            connection = JdbcUtils.getConnection();
            //2.调用QueryRunner的query方法查询一条记录并转换为对象;
            return queryRunner.query(connection,sql,new BeanHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //3.关闭相应的资源;
            JdbcUtils.release(connection);
        }
        return null;
    }

    //4.查询多条记录并转换为一个对象集合的方法;
    @Override
    public List<T> getBeanList(String sql, Object... args) {
        Connection connection = null;
        try {
            //1.获取数据库的连接;
            connection = JdbcUtils.getConnection();
            //2.调用QueryRunner的query方法查询一条记录并转换为对象;
            return queryRunner.query(connection,sql,new BeanListHandler<>(clazz),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //3.关闭相应的资源;
            JdbcUtils.release(connection);
        }
        return null;
    }


    //5.获取单个值得方法,如统计人数,商品数量;
    @Override
    public <E> E getSingleValue(String sql, Object... args) {
        Connection connection = null;
        try {
            //获取数据库的连接
            connection = JdbcUtils.getConnection();
            //执行queryRunner的方法
           return (E) queryRunner.query(connection,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭数据库的连接
            JdbcUtils.release(connection);
        }
        return null;
    }

    //6.批量的执行增,删,改的更新操作.
    @Override
    public void batch(String sql, Object[]... params) {
        Connection connection = null;
        try {
            //获取数据库的连接;
            connection = JdbcUtils.getConnection();
            //执行queryRunner的batch方法;
            queryRunner.batch(connection,sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //关闭相关资源
            JdbcUtils.release(connection);
        }


    }
}
