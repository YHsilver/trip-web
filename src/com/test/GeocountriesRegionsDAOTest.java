package com.test;

import com.dao.GeocountriesRegionsDAO;
import com.entity.GeocountriesRegions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeocountriesRegionsDAOTest {

    @Test
    void getAll() {
    }

    @Test
    void get() {
    }

    @Test
    void getContainWith() {
        GeocountriesRegionsDAO dao = new GeocountriesRegionsDAO();
        List<GeocountriesRegions> li = dao.getContainWith("A");
        for (GeocountriesRegions regions : li)
            System.out.println(regions.getCurrencyName());

    }
}