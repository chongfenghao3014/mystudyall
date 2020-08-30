package cn.aura.mapper;

import cn.aura.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
//@Component("UserMapper")  //加上这个也不会报错，加上后可以不让spring的引入报错。
public interface UserMapper extends BaseMapper<User> {
}
