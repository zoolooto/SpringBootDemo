package com.example.springbootdemo.Service;

import com.example.springbootdemo.entity.PageData;
import com.example.springbootdemo.entity.Pagelog;

public interface PageLogService {
    public PageData selcertPage();
    public boolean insertPage(Pagelog pagelog);
    public Pagelog selectPageByName(String name);
    public boolean updatePage(String name);

}
