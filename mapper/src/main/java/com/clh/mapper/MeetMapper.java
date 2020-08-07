package com.clh.mapper;

import com.clh.bean.Meet;

import java.util.List;
import java.util.Map;

public interface MeetMapper {

    List list(Map map);

    List listType();

    List listServer();

    int addMeet(Meet meet);

    int addMiddle(Map map);

    List listOne(Integer mid);

    int xiuMeet(Meet meet);

    int deleteMiddle(Map map);

    int deleteMeet(Integer mid);
}
