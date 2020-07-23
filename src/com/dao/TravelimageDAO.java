package com.dao;

import com.entity.Travelimage;

import java.util.List;

public class TravelimageDAO extends BaseDAO<Travelimage> {
    public List<Travelimage> getAll() {
        String sql = "SELECT * FROM travelimage";
        return getForList(sql);
    }

    public void save(Travelimage image) {
        String sql = "INSERT INTO travelimage(imageId, title, description, latitude, longitude, cityCode, " +
                "country_RegionCodeIso, uid, path, content) VALUES(?,?,?,?,?,?,?,?,?,?)";
        update(sql, image.getImageId(), image.getTitle(), image.getDescription(), image.getLatitude(), image.getLongitude(),
                image.getCityCode(), image.getCountryRegionCodeIso(), image.getUid(), image.getPath(), image.getContent());
    }

    public Travelimage get(int id) {
        String sql = "SELECT * FROM travelimage WHERE imageId = ?";
        return get(sql, id);
    }

    public int getCount() {
        String sql = "SELECT count(id) FROM travelimage";
        return getForValue(sql);
    }

    /**
     * get for a specific number of objects
     * to deal with page division
     * @param starIndex startIndex, begin with 0
     * @param num number of result
     * @return
     */
    public List<Travelimage> getForPageByHot(int starIndex,int num) {
        String sql = "SELECT * FROM travelimage ORDER BY hot DESC, ImageID LIMIT ? , ?" ;

        return getForList(sql,starIndex,num);
    }


    public List<Travelimage> getForPageByTime(int starIndex,int num) {
        String sql = "SELECT * FROM travelimage ORDER BY timeUpload DESC, ImageID LIMIT ? , ?" ;
        return getForList(sql,starIndex,num);
    }
}
