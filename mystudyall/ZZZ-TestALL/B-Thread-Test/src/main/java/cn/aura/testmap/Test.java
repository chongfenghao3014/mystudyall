package cn.aura.testmap;

public class Test {
    private static class Person{
        private Person next;
    }
    public static void main(String[] args) {
        Person person = new Person();
        person.next = person;
        while(true){
            Person p = person.next;
            System.out.println("11");
            if(p == null){
                break;
            }
        }
    }
}
