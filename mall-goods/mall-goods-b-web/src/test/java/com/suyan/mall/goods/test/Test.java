/*
 * Copyright (c) 2020.
 * 项目名称：素焉商城
 * 创建人：素焉
 * 开源地址: https://github.com/lixaviers/mall
 */
package com.suyan.mall.goods.test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suyan.utils.FileUtil;

public class Test {
    public static void main(String[] args) throws Exception {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("insert into tb_address (id,parent_id,name,order_num,address_level,address_code) values(10000,0,'中国',1,1, '');");
        String fileName = "/a.json";
        String jsonContext = FileUtil.getResourceContent(fileName);
        JSONArray objects = JSONObject.parseArray(jsonContext);
        int id = 10000;
        int sort = 1;
        for (Object object : objects) {
            id++;
            JSONObject jsonObject = JSONObject.parseObject(object.toString());
            String name = jsonObject.getString("name");
            String code = jsonObject.getString("code");
            System.out.println("insert into tb_address (id,parent_id,name,order_num,address_level,address_code) values(" + id + ",10000,'" + name + "'," + sort + ",2, '" + code + "');");
            JSONArray children = jsonObject.getJSONArray("children");
            int parentId = id;
            int childSort = 1;
            for (Object child : children) {
                id++;
                JSONObject childJsonObject = JSONObject.parseObject(child.toString());
                System.out.println("insert into tb_address (id,parent_id,name,order_num,address_level,address_code) values(" + id + "," + parentId + ",'" + childJsonObject.getString("name") + "'," + childSort + ",3, '" + childJsonObject.getString("code") + "');");
                int pId = id;
                int oSort = 1;
                for (Object o : childJsonObject.getJSONArray("children")) {
                    id++;
                    JSONObject temp = JSONObject.parseObject(o.toString());
                    System.out.println("insert into tb_address (id,parent_id,name,order_num,address_level,address_code) values(" + id + "," + pId + ",'" + temp.getString("name") + "'," + oSort + ",4, '" + temp.getString("code") + "');");
                    oSort++;
                }
                childSort++;
            }
            sort++;
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }
}
