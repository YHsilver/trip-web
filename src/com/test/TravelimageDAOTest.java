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
        TravelimageDAO dao = new TravelimageDAO();
        Travelimage img=new Travelimage();
        img.setUserName("asdasda");
        img.setTheme("asd");
        dao.save(img);

    }

    @Test
    void get() {
        TravelimageDAO idao = new TravelimageDAO();
        idao.get(8);
    }

    @Test
    void getCount() {
        TravelimageDAO dao = new TravelimageDAO();
        System.out.println(dao.getCount());

        System.out.println(dao.getCountWithTitle("%%"));
        System.out.println(dao.getCountWithTheme("%%"));

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