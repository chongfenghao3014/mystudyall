package cn.aura.test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestGroupingBy {
    private static class Person {
        String id;
        String name;
        String age;
        public String getId() {
            return id;
        }
        public void setId(String id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getAge() {
            return age;
        }
        public void setAge(String age) {
            this.age = age;
        }
        public Person() {
        }
        public Person(String id, String name, String age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
        @Override
        public String toString() {
            return "Person{" +
                    "id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", age='" + age + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) {
        //groupingBy使用
        System.out.println("=======groupingBy==========");
        Stream<Person> stream = Stream.of(new Person("1", "aa", "12"),
                new Person("1", "bb", "13"), new Person("3", "cc", "14"));
        System.out.println(stream.collect(Collectors.groupingBy(x -> x.id))); // 使用id分组
        //{1=[Person{id='1', name='aa', age='12'}, Person{id='1', name='bb', age='13'}], 3=[Person{id='3', name='cc', age='14'}]}

        //groupingBy
        Map<String, List<Person>> tempMap = Stream.of(new Person("1", "aa", "12"),
                new Person("1", "bb", "13"), new Person("3", "cc", "14"))
                .collect(Collectors.groupingBy(x -> x.id));
        for (String s : tempMap.keySet()) {
            tempMap.get(s).stream().forEach(x -> System.out.println(x));
        }
//        Person{id='1', name='aa', age='12'}
//        Person{id='1', name='bb', age='13'}
//        Person{id='3', name='cc', age='14'}



        Map<Boolean, List<Integer>> collectGroup = Stream.of(1, 2, 3, 4)
                .collect(Collectors.groupingBy(it -> it > 3));
        System.out.println("collectGroup : " + collectGroup);
        //collectGroup : {false=[1, 2, 3], true=[4]}
    }
}
