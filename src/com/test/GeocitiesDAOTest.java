package com.test;

import com.dao.GeocitiesDAO;
import com.entity.Geocities;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;


class GeocitiesDAOTest {


    @Test
    void getAll() {
        GeocitiesDAO dao= new GeocitiesDAO();


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