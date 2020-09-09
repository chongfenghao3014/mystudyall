package cn.aura.mapper;

import cn.aura.entity.PrintRecord;
import cn.aura.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrintRecordMapper{
    PrintRecord findPrintRecordById(Integer id);
}
