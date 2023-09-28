package jp.co.picasoft.training.common.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import jp.co.picasoft.training.common.bean.SystemDate;

@Mapper
public interface SystemDateMapper {
    @Select("SELECT SYSDATE() as system_date")
    public SystemDate getSystemDate();
}
