package cn.test.jdbc;

import cn.util.SleepUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.concurrent.CyclicBarrier;

/*
* jdbc超时机制：https://blog.csdn.net/lc87624/article/details/84383899?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare
* https://blog.csdn.net/zdx1515888659/article/details/80775193
* */
public class TestJDBCSafe {// 20200831---01


    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/zzz_test";
    private static String USER = "root";
    private static String PASSWORD = "root"; // 大小写转换ctrl+shift+u
    private static int total = 500;
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(total, new Runnable() {
        public void run() {
            System.out.println("运行结束。。。。。");
        }
    });
    public static void main(String[] args) {
        for(int i=0;i<total;i++){
            new Thread(new Runnable() {
                public void run() {
                    test1();
                }
            }).start();
        }

    }
    public static void test1() {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            Class.forName(TestJDBCSafe.JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
//            conn.setAutoCommit(false);
            String sql = "update testuser set age = age+1 where id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1,1);
            System.out.println(statement.toString());// 打印sql
            cyclicBarrier.await();
            int ret = statement.executeUpdate();
            System.out.println("修改的行数是"+ret);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        conn.commit();
        try {
            statement.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
