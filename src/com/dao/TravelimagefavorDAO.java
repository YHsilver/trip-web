package com.dao;

import com.entity.Travelimagefavor;

import java.util.List;

public class TravelimagefavorDAO extends BaseDAO<Travelimagefavor> {
    public List<Travelimagefavor> getAll() {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor";
        return getForList(sql);
    }

    public void save(Travelimagefavor travelimagefavor) {
        String sql = "INSERT INTO travelimagefavor(favorId, uid, imageId) VALUES(?,?,?)";
        update(sql,travelimagefavor.getFavorId(),travelimagefavor.getUid(),travelimagefavor.getImageId());
    }

    public Travelimagefavor getByFavorId(int favorId) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor WHERE favorId = ?";
        return get(sql,favorId);
    }

    public List<Travelimagefavor> getByUid(int uid){
        String sql= "SELECT favorId, uid, imageId FROM travelimagefavor WHERE uid = ?";
        return getForList(sql,uid);
    }

    public List<Travelimagefavor> getByImageId(int iid){
        String sql= "SELECT favorId, uid, imageId FROM travelimagefavor WHERE imageId = ?";
        return getForList(sql,iid);
    }


    public int getCount() {
        String sql = "SELECT count(id) FROM travelimagefavor";
        return getForValue(sql);
    }


    /**
     * get for a specific number of objects
     * to deal with page division
     * @param starIndex
     * @param num
     * @return
     */
    public List<Travelimagefavor> getForPage(int starIndex, int num) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor LIMIT ?,?" ;
        return getForList(sql,starIndex,num);
    }


    public long getValue(String uid,String iid) {
        String sql = "SELECT count(FavorID) FROM travelimagefavor WHERE UID = ? AND ImageID = ?";
        return (long)getForValue(sql,uid,iid);
    }
}
