package com.test;

import com.dao.TravelimageDAO;
import com.dao.TraveluserDAO;
import com.entity.Travelimage;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TravelimageDAOTest {

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
    void getCount() {
    }

    @Test
    void getForPage() {
        TravelimageDAO dao = new TravelimageDAO();
        List<Travelimage> hotest = dao.getForPageByHot(0,5);


        for (Travelimage travelimage: hotest){
            System.out.println(travelimage.getPath());
        }



    }
}