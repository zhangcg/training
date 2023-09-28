package jp.co.picasoft.training.common.bean;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class SystemDate {
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss" ,timezone = "Asia/Tokyo")
    private Timestamp systemDate;
}
