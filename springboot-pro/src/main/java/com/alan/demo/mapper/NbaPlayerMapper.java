package com.alan.demo.mapper;

import com.alan.demo.entity.NbaPlayer;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface NbaPlayerMapper {

    @Select("select * from nba_player")
    public List<NbaPlayer> selectAll();
}