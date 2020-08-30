package cn.test.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListToMap {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<Account>();
        accounts.add(new Account(Long.parseLong("1"),"a"));
        accounts.add(new Account(Long.parseLong("2"),"b"));
        accounts.add(new Account(Long.parseLong("3"),"c"));
        accounts.add(new Account(Long.parseLong("4"),"d"));
        accounts.add(new Account(Long.parseLong("5"),"e"));
        Map<Long, String> idNameMap = getIdNameMap(accounts);
        System.out.println(idNameMap);
    }
    public static Map<Long, String> getIdNameMap(List<Account> accounts) {
        return accounts.stream().collect(Collectors.toMap(Account::getId, Account::getUsername));
    }
    private static class Account{
        private Long id;
        private String username;
        public Account(Long id,String username){
            this.id = id;
            this.username = username;
        }
        public Long getId(){
            return this.id;
        }

        public String getUsername() {
            return username;
        }
    }
}
