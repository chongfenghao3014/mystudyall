package cn.aura.entity;

import lombok.Data;

@Data
public class PrintRecord {
    private Integer id;
    private String orderCode;
    private String createByUserId;
    private String createBy;
    private Byte entryType;
}
