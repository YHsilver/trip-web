package com.dao;

import com.entity.GeocountriesRegions;

import java.util.List;

public class GeocountriesRegionsDAO extends BaseDAO<GeocountriesRegions> {
    public List<GeocountriesRegions> getAll(){
        String sql = "SELECT * FROM geocountries_regions";
        return getForList(sql);
    }

    public GeocountriesRegions get(String iso){
        String sql = "SELECT * FROM geocountries_regions WHERE iso = ?";
        return get(sql,iso);
    }

    public GeocountriesRegions getByName(String name){
        String sql = "SELECT * FROM geocountries_regions WHERE CountryRegionName = ?";
        return get(sql,name);
    }



    public List<GeocountriesRegions> getContainWith(String name){
        String sql = "SELECT * FROM geocountries_regions WHERE CountryRegionName LIKE ?";
        return getForList(sql,"%"+name+"%");
    }

}
