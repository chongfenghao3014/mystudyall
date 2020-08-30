package cn.test.testbasic;

public class TestOver {
    private static class F{
        public void test(){
            System.out.println("FFFFFFFFFFFF");
        }
    }
    private static class S extends F{
        public void test() {
            String s = super.toString();
            System.out.println(s);
            System.out.println(toString());
            super.test();
            System.out.println("ssssssssss");
        }
    }
    public static void main(String[] args) {
        S s = new S();
        s.test();
    }
}
