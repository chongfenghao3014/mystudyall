package cn.aura.aop;

import cn.aura.entity.PrintRecord;
import cn.aura.entity.User;
import cn.aura.mapper.PrintRecordMapper;
import cn.aura.mapper.UserMapper;
import cn.aura.service.UpdateService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TestAop {
    @Autowired
    UpdateService updateService;

    @Pointcut("execution(public * cn.aura.mapper.UserMapper.update*(..)) || " +
              "execution(public * cn.aura.mapper.UserMapper.insert*(..))")
    public void pointcut() {
    }

    @Before("pointcut()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        System.out.println("before...................");
    }
    @AfterReturning(value="pointcut()" ,returning="ret")
    public void myAfterReturning(JoinPoint joinPoint,Object ret){
        System.out.println("myAfterReturning..................");
        Object[] args = joinPoint.getArgs();
        if(args != null && args.length > 0){
            for (int i=0;i<args.length;i++){
                User user = null;
                try {
                    user = (User)args[i];
                } catch (Exception e) {
                    return;
                }
                boolean b = updateService.updateUser(user);
                System.out.println("结果："+b);
            }
        }
    }

}
