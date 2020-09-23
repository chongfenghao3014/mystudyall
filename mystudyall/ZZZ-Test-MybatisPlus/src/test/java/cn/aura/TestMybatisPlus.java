package cn.aura;

import cn.aura.entity.User;
import cn.aura.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = {App.class})
@RunWith(SpringRunner.class)
public class TestMybatisPlus {
    @Autowired
    UserMapper userMapper;
    @Test
    public void contextLoads() {
        System.out.println("00000000");
        Integer id=1;
        User user = userMapper.selectById(id);
        // 执行的sql SELECT id,nickname,role,username,age,sex FROM user WHERE id=?
        // 注意如果字段名称是userName，那么查询的列名就是user_name.
        System.out.println(user);
    }
    @Test
    public void selectByWrapper(){
        //创建条件构造器
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<User>();
        userQueryWrapper.select("id","username");// 查询指定列
        userQueryWrapper.eq("nickname","tom");
        User user= userMapper.selectOne(userQueryWrapper );
        // sql语句  SELECT id,username FROM user WHERE nickname = ?
        // 如果不指定列，默认情况下，会查询在User类中所有的字段。
        System.out.println(user);
    }

    @Test
    public void updateUserAge(){
        User user = new User();
        user.setId(3);
        user.setNickname("你成年了->");
        user.setAge(18);
        try {
            userMapper.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("1111122222222233333333333");
        }
    }
    @Test
    public void insertUser(){
        User user = new User();
        user.setId(2);
        user.setAge(18);
        userMapper.insert(user);
    }

}
