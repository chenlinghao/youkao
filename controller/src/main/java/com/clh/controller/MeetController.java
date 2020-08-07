package com.clh.controller;

import com.clh.bean.Meet;
import com.clh.service.MeetService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MeetController {
    @Resource
    private MeetService meetService;
    @RequestMapping("list")
    public String list(Model model, @RequestParam(defaultValue = "1") Integer cpage,String mohu1,String mohu2,String mohu3,String mohu4) {
        Map map = new HashMap();
        map.put("mohu1", mohu1);
        map.put("mohu2", mohu2);
        map.put("mohu3", mohu3);
        map.put("mohu4", mohu4);

        PageHelper.startPage(cpage, 3);
        List list = meetService.list(map);
        PageInfo pageInfo = new PageInfo(list);
        model.addAttribute("map", map);
        model.addAttribute("list", list);
        model.addAttribute("p", pageInfo);
        return "list";

    }

    @RequestMapping("toAdd")
    public String toAdd(){
        return "add";
    }

    @RequestMapping("listType")
    @ResponseBody
    public Object listType(){
       List list =  meetService.listType();
       return list;
    }

    @RequestMapping("listServer")
    @ResponseBody
    public Object listServer(){
        List list =  meetService.listServer();
        return list;
    }

    @RequestMapping("add")
    public String add(Meet meet,String sid){
        int a  =  meetService.add(meet,sid.split(","));
        return "redirect:list";
    }

    @RequestMapping("toXiu")
    public String toXiu(Integer mid){
        return "xiu";
    }

    @RequestMapping("listOne")
    @ResponseBody
    public Object listOne(Integer mid){
        List list =  meetService.listOne(mid);
        return list;
    }

    @RequestMapping("xiu")
    public String xiu(Meet meet,String sid){
        int a  =  meetService.xiu(meet,sid.split(","));
        return "redirect:list";
    }
    @RequestMapping("delete")
    public String add(Integer mid){
        int a  =  meetService.delete(mid);
        return "redirect:list";
    }

}
