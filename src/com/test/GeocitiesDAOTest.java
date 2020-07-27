package com.test;

import com.dao.GeocitiesDAO;
import com.entity.Geocities;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


class GeocitiesDAOTest {


    @Test
    void getAll() {
        GeocitiesDAO dao= new GeocitiesDAO();
        String str="";
        List<String> list = new ArrayList<>(Arrays.asList(str.split(",")));
        list.add("2");
        String newStr=String.join(",",list);
        System.out.println("+++"+newStr);

    }

    @Test
    void getByRegionTest() {
        GeocitiesDAO dao= new GeocitiesDAO();
        List<Geocities> li = dao.getByRegion("US");
        for(Geocities city: li){
            System.out.println(city.getCountryRegionCodeIso());
        }
    }

}