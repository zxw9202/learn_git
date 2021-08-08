package com.zxw.springboot.sbdemo;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Test;

/**
 * 大数据量的插入---> 测试100万条数据  【一共5个字段的表】
 * 方法1、普通采用jdbc插入
 * 方法2、jdbc用事务进行提交  --> 事务提交是把语句一起执行
 * 方法3、batch语句   --> 内部实现是是把 values 后面的插入值变成成 values(,,,),(,,,,) ：
 */
public class BigDataTest {

    /**
     * 一、普通方式
     * 时间:10万条:16672ms 折合100万条 = 166.72秒
     */
    @Test
    public void test1(){
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement stmt  = null;
        long t1 = System.currentTimeMillis();
        try {
            stmt = conn.prepareStatement("insert into test_yxtj values(?,?,?,?,?)");
            for (int i = 0; i <100000; i++) {
                stmt.setInt(1, i);
                stmt.setFloat(2, i);
                stmt.setString(3, i+"");
                stmt.setInt(4, i);
                stmt.setInt(5, i);
                stmt.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(null, stmt, conn);
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }

    /**
     * 二、事务提交 :
     * 时间:10万条:13558ms 折合100万条 = 135.5秒
     */
    @Test
    public void test2(){
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement stmt  = null;
        long t1 = System.currentTimeMillis();
        try {
            conn.setAutoCommit(false);
            stmt = conn.prepareStatement("insert into test_yxtj values(?,?,?,?,?)");
            for (int i = 0; i <100000; i++) {
                stmt.setInt(1, i);
                stmt.setFloat(2, i);
                stmt.setString(3, i+"");
                stmt.setInt(4, i);
                stmt.setInt(5, i);
                stmt.execute();
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(null, stmt, conn);
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }

    /**
     * 三、批处理：
     * 特别注意:需要url参数加:rewriteBatchedStatements=true
     * url范例: jdbc:mysql://127.0.0.1/XXX?characterEncoding=UTF-8&rewriteBatchedStatements=true
     * 时间 : 10万条:1273ms 折合100万条 = 12.73秒
     */
    @Test
    public void test3(){
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement stmt  = null;
        long t1 = System.currentTimeMillis();
        try {
            stmt = conn.prepareStatement("insert into test_yxtj values(?,?,?,?,?)");
            for (int i = 0; i <100000; i++) {
                stmt.setInt(1, i);
                stmt.setFloat(2, i);
                stmt.setString(3, i+"");
                stmt.setInt(4, i);
                stmt.setInt(5, i);
                stmt.addBatch();
            }
            stmt.executeBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(null, stmt, conn);
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }


    /**
     * 四、事务+批处理并且分批执行
     * 结论:加事务时间无影响，但是分批次能提供效率的增加
     * 时间:100万条:9900ms 折合100万条 = 9.99秒
     * 时间:500万条:46943ms = 47秒
     */
    @Test
    public void test4(){
        Connection conn = JDBCUtil.getConnection();
        PreparedStatement stmt  = null;
        long t1 = System.currentTimeMillis();
        try {
            //conn.setAutoCommit(false);  /**取消事务对时间无太大影响！！*/
            stmt = conn.prepareStatement("insert into test_yxtj values(?,?,?,?,?)");

//            for (int i = 1; i <=100; i++) { //1万条一次
//                for (int j = 1; j <=10000; j++) {
//                    stmt.setInt(1, ((i-1)*10000)+j);
//                    stmt.setFloat(2, ((i-1)*10000)+j);
//                    stmt.setString(3, ((i-1)*10000)+j+"");
//                    stmt.setInt(4, ((i-1)*10000)+j);
//                    stmt.setInt(5, ((i-1)*10000)+j);
//                    stmt.addBatch();
//                }
//                stmt.executeBatch();
//                stmt.clearBatch(); /**清除缓存*/
//                System.out.println("执行到第"+i+"外循环");
//            }

            //conn.commit();

            //-------> 上面固定了100万条，假如不确定多少数据量的情况，就不好指定2层循环.可采用下面的样子
            int size = 5000000;
            for (int i = 0; i < size; i++) {
                stmt.setInt(1, i);
                stmt.setFloat(2, i);
                stmt.setString(3, i+"");
                stmt.setInt(4, i);
                stmt.setInt(5, i);
                stmt.addBatch();
                if(i%10000==0||i==size-1){ //1万次一条，或者最后一次进行提交。
                    stmt.executeBatch();
                    stmt.clearBatch(); /**清除缓存*/
                    System.out.println("执行到第"+i/10000+"外循环");
                }
            }

        } catch (SQLException e) {
//            try {
//                conn.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            }
        }finally {
            JDBCUtil.release(null, stmt, conn);
        }
        long t2 = System.currentTimeMillis();
        System.out.println((t2-t1));
    }

}
