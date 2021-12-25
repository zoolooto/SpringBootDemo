package com.example.springbootdemo.Service.Impl;

import com.example.springbootdemo.Dao.PagelogMapper;
import com.example.springbootdemo.Service.PageLogService;
import com.example.springbootdemo.entity.PageData;
import com.example.springbootdemo.entity.Pagelog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PageLogServiceImpl implements PageLogService {

    @Autowired
    PagelogMapper pagelogMapper;
    @Override
    public boolean insertPage(Pagelog pagelog) {
         return  pagelogMapper.insertlog(pagelog)>0;
    }
    @Override
    public PageData selcertPage(){
        PageData pageData=new PageData();
        pageData.setSumloginNumbers(pagelogMapper.loginnumber());
        pageData.setSumconsumption(pagelogMapper.profitToday());
        return  pageData;
    }
    @Override
    public Pagelog selectPageByName(String name) {
       return pagelogMapper.selectByName(name);
    }

    @Override
    public boolean updatePage(String name) {
       return pagelogMapper.update(name);
    }
}
