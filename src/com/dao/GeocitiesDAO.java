package com.dao;

import com.entity.Geocities;

import java.util.List;

public class GeocitiesDAO extends BaseDAO<Geocities> {

    public Geocities get(int id){
        String sql= "SELECT * FROM geocities WHERE GeoNameID = ?";
        return get(sql,id);
    }

    public List<Geocities> getAll(){
        String sql = "SELECT * FROM geocities";
        return getForList(sql);
    }

    public List<Geocities> getByRegion(String iso){
        String sql = "SELECT * FROM geocities WHERE CountryRegionCodeISO = ?";
        return getForList(sql,iso);
    }

    public List<Geocities> getContainWith(String name){
        String sql = "SELECT * FROM geocities WHERE AsciiName LIKE ?";
        return getForList(sql,"%"+name+"%");
    }
}
