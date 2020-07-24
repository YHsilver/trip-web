package com.dao;

import com.entity.Travelimage;

import java.util.List;

public class TravelimageDAO extends BaseDAO<Travelimage> {
    public List<Travelimage> getAll() {
        String sql = "SELECT * FROM travelimage";
        return getForList(sql);
    }

    public void save(Travelimage image) {
        String sql = "INSERT INTO travelimage( title, description, latitude, longitude, cityCode, " +
                "countryRegionCodeIso, uid, path, content) VALUES(?,?,?,?,?,?,?,?,?)";
        update(sql, image.getTitle(), image.getDescription(), image.getLatitude(), image.getLongitude(),
                image.getCityCode(), image.getCountryRegionCodeIso(), image.getUid(), image.getPath(), image.getContent());
    }

    public Travelimage get(int id) {
        String sql = "SELECT * FROM travelimage WHERE imageId = ?";
        return get(sql, id);
    }

    public long getCount() {
        String sql = "SELECT count(ImageID) FROM travelimage";
        return (long)getForValue(sql);
    }

    public long getCountWithTitle(String txt) {
        String sql = "SELECT count(ImageID) FROM travelimage WHERE title Like ?";
        return (long)getForValue(sql,txt);
    }

    public long getCountWithTheme(String txt) {
        String sql = "SELECT count(ImageID) FROM travelimage WHERE theme Like ?";
        return (long)getForValue(sql,txt);
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


    public List<Travelimage> getForPageInTitleByHot(String txt, int starIndex,int num) {
        String sql = "SELECT * FROM travelimage WHERE title LIKE ? ORDER BY hot DESC, ImageID LIMIT ? , ?" ;

        return getForList(sql,txt,starIndex,num);
    }

    public List<Travelimage> getForPageInTitleByTime(String txt, int starIndex,int num) {
        String sql = "SELECT * FROM travelimage WHERE title LIKE ? ORDER BY timeUpload DESC, ImageID LIMIT ? , ?" ;

        return getForList(sql,txt,starIndex,num);
    }


    public List<Travelimage> getForPageInThemeByHot(String txt, int starIndex,int num) {
        String sql = "SELECT * FROM travelimage WHERE theme LIKE ? ORDER BY hot DESC, ImageID LIMIT ? , ?" ;

        return getForList(sql,txt,starIndex,num);
    }

    public List<Travelimage> getForPageInThemeByTime(String txt, int starIndex,int num) {
        String sql = "SELECT * FROM travelimage WHERE theme LIKE ? ORDER BY timeUpload DESC, ImageID LIMIT ? , ?" ;

        return getForList(sql,txt,starIndex,num);
    }
}
