package cn.aura.service;

import cn.aura.entity.PrintRecord;
import cn.aura.entity.User;
import cn.aura.mapper.PrintRecordMapper;
import cn.aura.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImpl implements UpdateService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    PrintRecordMapper printRecordMapper;

    public boolean updateUser(User user) {
        boolean flag = false;
        if(user != null){
            if(user.getAge() == 18){
                PrintRecord printRecordById = printRecordMapper.findPrintRecordById(user.getId());
                System.out.println("printRecordById.getEntryType--->>"+printRecordById.getEntryType());
                if(printRecordById != null){
                    if (printRecordById.getEntryType() == 3){
                        user.setNickname("你成年了->"+(user.getNickname() == null ?"":user.getNickname()));
                        userMapper.fUpdateById(user);
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }
}
