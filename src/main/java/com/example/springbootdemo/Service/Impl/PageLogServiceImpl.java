package com.example.springbootdemo.Service.Impl;

import com.example.springbootdemo.Dao.PagelogMapper;
import com.example.springbootdemo.Service.PageLogService;
import com.example.springbootdemo.entity.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageLogServiceImpl implements PageLogService {
    @Autowired
    PagelogMapper pagelogMapper;
    public PageData selcertPage(){
        PageData pageData=new PageData();
        pageData.setSumloginNumbers(pagelogMapper.loginnumber());
        pageData.setSumconsumption(pagelogMapper.profitToday());
        return  pageData;
    }
}
