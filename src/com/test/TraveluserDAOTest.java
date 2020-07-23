package com.test;

import com.dao.TraveluserDAO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TraveluserDAOTest {

    @Test
    void getAll() {
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