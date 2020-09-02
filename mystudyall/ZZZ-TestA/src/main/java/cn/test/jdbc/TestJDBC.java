package cn.test.jdbc;

import cn.util.SleepUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
/*
* jdbc超时机制：https://blog.csdn.net/lc87624/article/details/84383899?utm_medium=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare&depth_1-utm_source=distribute.pc_relevant_t0.none-task-blog-BlogCommendFromMachineLearnPai2-1.compare
* https://blog.csdn.net/zdx1515888659/article/details/80775193
* */
public class TestJDBC {// 我是第二个人的提交
    // testttt
    private static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static String DB_URL = "jdbc:mysql://localhost:3306/zzz_test";
    private static String USER = "root";
    private static String PASSWORD = "root"; // 大小写转换ctrl+shift+u

    public static void main(String[] args) {

        try {
            test1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void test1() throws Exception{
        Connection conn = null;
        PreparedStatement statement = null;
        Class.forName(TestJDBC.JDBC_DRIVER);
        conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        conn.setAutoCommit(false);
        String sql = "update testuser set user_name = ? where id = ?";
        statement = conn.prepareStatement(sql);
        statement.setString(1,"bob3");
        statement.setInt(2,1);
        System.out.println(statement.toString());// 打印sql
        int ret = statement.executeUpdate();
        System.out.println("修改的行数是"+ret);
        SleepUtil.sleepS(10);
        System.out.println("准备提交事务。。");
        // 如果提交事务时，关闭了数据库，这个方法会抛出异常。
        // MySQLNonTransientConnectionException: Communications link failure during commit
        // 意思是提交期间连接通信异常。
        conn.commit();
        statement.close();
        conn.close();
    }
}
