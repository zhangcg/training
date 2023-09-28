package jp.co.picasoft.training.common.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.picasoft.training.common.bean.SystemDate;
import jp.co.picasoft.training.common.mapper.SystemDateMapper;

@Service
public class SystemDateService {

    @Autowired
    private SystemDateMapper systemDateMapper;
    
    public SystemDate getSystemDate() {
        return systemDateMapper.getSystemDate();
    }
}
