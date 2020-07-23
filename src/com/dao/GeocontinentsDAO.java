package com.dao;

import com.entity.Geocontinents;

import java.util.List;

public class GeocontinentsDAO extends BaseDAO<Geocontinents> {
    public List<Geocontinents> getAll(){
        String sql="SELECT continentCode, continentName ,geoNameId FROM geocontinents";
        return getForList(sql);
    }

    public Geocontinents get(String continentCode){
        String sql = "SELECT continentCode, continentName, geoNameId FROM geocontinents WHERE continentCode = ?";
        return get(sql,continentCode);
    }

}
