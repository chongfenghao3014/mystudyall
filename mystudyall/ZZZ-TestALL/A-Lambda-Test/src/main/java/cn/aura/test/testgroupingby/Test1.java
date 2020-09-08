package cn.aura.test.testgroupingby;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        test1();
//        test2();
    }
    public static void test2(){

    }
    public static void test1(){
        List<Fruit> fruitList = new ArrayList<>();
        fruitList.add(new Fruit("apple", 6d));
        fruitList.add(new Fruit("apple", 6d));
        fruitList.add(new Fruit("banana", 7d));
        fruitList.add(new Fruit("banana", 7d));
        fruitList.add(new Fruit("banana", 7d));
        fruitList.add(new Fruit("grape",8d));
        Map<String, Long> map = fruitList.stream().
                collect(Collectors.groupingBy(Fruit::getName,Collectors.counting()));
        System.out.println(map);// {banana=3, apple=2, grape=1} 做统计

        Map<String, Long> map2 = fruitList.stream().map(Fruit::getName).
                collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map2);// {banana=3, apple=2, grape=1} 和上面相同

        map.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .forEachOrdered(System.out::println);// 逆序打印
//        banana=3
//        apple=2
//        grape=1

        Map<String, Double> sumMap = fruitList.stream().collect
                (Collectors.groupingBy(Fruit::getName,Collectors.summingDouble(Fruit::getPrice)));
        System.out.println(sumMap); // {banana=21.0, apple=12.0, grape=8.0} 求和

        Map<String, List<Fruit>> groupMap =
                fruitList.stream().collect(Collectors.groupingBy(Fruit::getName));
        System.out.println(groupMap); // 分组
        // {banana=[Fruit(name=banana, price=7.0), Fruit(name=banana, price=7.0), Fruit(name=banana, price=7.0)],
        // apple=[Fruit(name=apple, price=6.0), Fruit(name=apple, price=6.0)],
        // grape=[Fruit(name=grape, price=8.0)]}


        // group by price, uses 'mapping' to convert List<Fruit> to List<String>
        Map<String, List<Double>> groupMap2 =
                fruitList.stream().collect(
                        Collectors.groupingBy(
                                Fruit::getName,
                                Collectors.mapping(Fruit::getPrice, Collectors.toList())
                        ));
        System.out.println(groupMap2); // 根据不同的名字分为若干组
        //{banana=[7.0, 7.0, 7.0], apple=[6.0, 6.0], grape=[8.0]}

        Map<String, Set<Double>> groupMap3 =
                fruitList.stream().collect(
                        Collectors.groupingBy(
                                Fruit::getName,
                                Collectors.mapping(Fruit::getPrice, Collectors.toSet())
                        ));
        System.out.println(groupMap3); // 根据不同的名字分为若干组,转为set就是去重
        // {banana=[7.0], apple=[6.0], grape=[8.0]}
    }
}
