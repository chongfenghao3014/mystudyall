package cn.aura.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName(value = "user")
public class User  extends Model<User> implements Serializable {
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    private String nickname;
    private Integer role;
    private String username;// 注意如果字段名称是userName，那么查询的列名就是user_name.
    private Integer age;
    private Integer sex;
    @Override
    public String toString(){
        return "id:"+id+" ,nickname:"+nickname+" ,role"+role+" ,username"+username+" ,age"+age;
    }
}

