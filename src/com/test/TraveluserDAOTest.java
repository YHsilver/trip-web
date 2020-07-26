package com.test;

import com.alibaba.fastjson.JSONArray;
import com.dao.TraveluserDAO;
import com.entity.Traveluser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TraveluserDAOTest {

    @Test
    void getAll() {
        TraveluserDAO dao=new TraveluserDAO();
        Traveluser user=dao.getByName("123456");


        System.out.println(user.getHistoryImageId());


    }

    @Test
    void save() {

    }

    @Test
    void get() {
    }

    @Test
    void getByName() {
    }

    @Test
    void getCountWithName() {
        TraveluserDAO dao=new TraveluserDAO();
        long num = dao.getCountWithName("luisg");
        System.out.println(num);

    }
}