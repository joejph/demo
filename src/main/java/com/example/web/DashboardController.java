package com.example.web;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DashboardController {
    public  class Apple
    {
        public int size;
        public String color;
        public double weight;

        public Apple(int size, String color, double weight)
        {
            this.color = color;
            this.weight = weight;
            this.size = size;
        }
    }

    @RequestMapping("/")
    public String dashboard(){
        return "homepage/home";
    }

    @RequestMapping("/tableDemoAjax/")
    @ResponseBody
    public List<Apple> tableDemoAjax(@RequestParam String aoData) {
        /*
        System.out.println("enter tableDemoAjax");


        JSONArray jsonarray = JSONArray.parseArray(aoData);
        String sEcho = null;      //记录操作的次数
        int iDisplayStart = 0;    // 起始索引
        int iDisplayLength = 0;   // 每页显示的行数


        //这里获取从前台传递过来的参数，从而确保是否分页、是否进行查询、是否排序等
        for (int i = 0; i < jsonarray.size(); i++) {
            JSONObject obj = (JSONObject) jsonarray.get(i);
            if (obj.get("name").equals("sEcho"))
                sEcho = obj.get("value").toString();

            if (obj.get("name").equals("iDisplayStart"))
                iDisplayStart = obj.getIntValue("value");
            if (obj.get("name").equals("iDisplayLength"))
                iDisplayLength = obj.getIntValue("value");
        }

        // 生成20条测试数据，在实际开发中这里的数据应该是根据分页、排序、查询等情况从数据库中进行查询的
        List<String[]> lst = new ArrayList<String[]>();
        for (int i = 0; i < 100; i++) {
            String[] d = { "firstname"+i,"lastname"+i,"address"+i };
            lst.add(d);
        }

        JSONObject getObj = new JSONObject();
        System.out.println("sEcho:"+sEcho);
        getObj.put("sEcho", sEcho);
        getObj.put("iTotalRecords", lst.size());          //实际的行数
        getObj.put("iTotalDisplayRecords", lst.size());   //显示的行数,这个要和上面写的一样

        getObj.put("aaData", lst.subList(iDisplayStart,iDisplayStart + iDisplayLength));//要以JSON格式返回，否则前台没法显示
        return getObj.toString();
        */
        List<Apple> la = new ArrayList<Apple>();
        la.add(new Apple(1, "red", 3.4));
        la.add(new Apple(1, "red", 3.4));
        la.add(new Apple(1, "red", 3.4));
        la.add(new Apple(1, "red", 3.4));
        return la;
    }

}
