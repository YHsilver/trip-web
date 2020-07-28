package com.test;

import com.dao.GeocountriesRegionsDAO;
import com.entity.GeocountriesRegions;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeocountriesRegionsDAOTest {

    @Test
    void getAll() {
        //%E5%85%B3%E4%BA%8Ejsp%E7%9A%84%E6%B3%9B%E5%9E%8B%E6%94%AF%E6%8C%81

        try {
            System.out.println(URLDecoder.decode("%E5%85%B3%E4%BA%8Ejsp%E7%9A%84%E6%B3%9B%E5%9E%8B%E6%94%AF%E6%8C%81","UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


}

    @Test
    void get() {
        GeocountriesRegionsDAO rdao = new GeocountriesRegionsDAO();

        GeocountriesRegions region = rdao.getByName("Canada");

        System.out.println(region);
    }

    @Test
    void getContainWith() {
        GeocountriesRegionsDAO dao = new GeocountriesRegionsDAO();
        List<GeocountriesRegions> li = dao.getContainWith("A");
        for (GeocountriesRegions regions : li)
            System.out.println(regions.getCurrencyName());

    }
}