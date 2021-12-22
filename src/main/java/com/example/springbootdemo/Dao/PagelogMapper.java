package com.example.springbootdemo.Dao;

import com.example.springbootdemo.entity.Pagelog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PagelogMapper {
    int insertlog(Pagelog pagelog);
    List<Pagelog> selectAll();
    int loginnumber();
    int profitToday();
}
