package cn.aura.test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    private static class UserBean{
        private String userName;
        private String hobbit;
        private Integer age;
        public UserBean(String userName,String hobbit,Integer age){
            this.userName = userName;
            this.hobbit = hobbit;
            this.age = age;
        }
        public String getUserName() {
            return userName;
        }
        public Integer getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        List<UserBean> userList = new ArrayList<>();
        UserBean userBean = new UserBean("张三","热爱学习", 21);
        userList.add(userBean);

        userBean = new UserBean("张三2","热爱学习2", 25);
        userList.add(userBean);

        userBean = new UserBean("张三3","热爱学习3", 27);
        userList.add(userBean);

        userBean = new UserBean("张三4","热爱学习2", 26);
        userList.add(userBean);

        System.out.println(userList);
//        Map<String,Integer> map =
//                userList.stream().collect(Collectors.toMap(UserBean::getUserName, UserBean::getAge,
//                        (key1,key2) ->key2)); // key 重复的话，会用后面的覆盖前面的。

//        Map<String,Integer> map =  // key重复会报错
//                userList.stream().collect(Collectors.toMap(UserBean::getUserName, UserBean::getAge));

//        Map<String,UserBean> map =  // key重复同样报错  userBeanL -> userBeanL是一个返回本身的lambda表达式
//                userList.stream().collect(Collectors.toMap(UserBean::getUserName, userBeanL->userBeanL));

//        Map<String,UserBean> map =  // 和上面的相同， 是一种更优雅的方式。
//                userList.stream().collect(Collectors.toMap(UserBean::getUserName, Function.identity()));

        TreeMap<String,UserBean> map =  // 可以指定map
                userList.stream().collect(Collectors.toMap(UserBean::getUserName, Function.identity(),(key1,key2)->key2, TreeMap::new));

        System.out.println(map);
    }
}
