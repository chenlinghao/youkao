package com.clh.service;

import com.clh.bean.Meet;
import com.clh.mapper.MeetMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MeetServiceImpl implements MeetService{
    @Resource
    private MeetMapper meetMapper;

    @Override
    public List list(Map map) {
        return meetMapper.list(map);
    }

    @Override
    public List listType() {
        return meetMapper.listType();
    }

    @Override
    public List listServer() {
        return meetMapper.listServer();
    }

    @Override
    public int add(Meet meet, String[] split) {
        int a = meetMapper.addMeet(meet);
        Map map = new HashMap();
        map.put("mid",meet.getMid());
        map.put("sids",split);
        int b = meetMapper.addMiddle(map);
        return a;
    }

    @Override
    public List listOne(Integer mid) {
        return meetMapper.listOne(mid);
    }

    @Override
    public int xiu(Meet meet, String[] split) {
        int a = meetMapper.xiuMeet(meet);
        Map map = new HashMap();
        map.put("mid",meet.getMid());
        map.put("sids",split);
        int c = meetMapper.deleteMiddle(map);
        int b = meetMapper.addMiddle(map);
        return a;
    }

    @Override
    public int delete(Integer mid) {
        int a = meetMapper.deleteMeet(mid);
        Map map = new HashMap();
        map.put("mid",mid);

        int c = meetMapper.deleteMiddle(map);

        return a;
    }
}
