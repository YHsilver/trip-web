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
        update(sql, travelimagefavor.getFavorId(), travelimagefavor.getUid(), travelimagefavor.getImageId());
    }

    public Travelimagefavor getByFavorId(int favorId) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor WHERE favorId = ?";
        return get(sql, favorId);
    }

    public List<Travelimagefavor> getAllByUid(int uid) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor WHERE uid = ? ";
        return getForList(sql, uid);
    }

    public List<Travelimagefavor> getPartByUid(int uid, int startIndex, int num) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor WHERE uid = ? LIMIT ?, ?";
        return getForList(sql, uid, startIndex, num);
    }

    public List<Travelimagefavor> getByImageId(int iid) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor WHERE imageId = ?";
        return getForList(sql, iid);
    }

    public Travelimagefavor getByImageIdAndUid(int iid, int uid) {
        String sql = "SELECT favorId, uid, imageId FROM travelimagefavor WHERE imageId = ? AND uid= ?";
        return get(sql, iid, uid);
    }


    public long getCount() {
        String sql = "SELECT count(FavorID) FROM travelimagefavor";
        return (long)getForValue(sql);
    }

    public long getCountByUid(int uid) {
        String sql = "SELECT count(FavorID) FROM travelimagefavor WHERE UID = ?";
        return (long)getForValue(sql, uid);
    }

    public long getValue(String uid, String iid) {
        String sql = "SELECT count(FavorID) FROM travelimagefavor WHERE UID = ? AND ImageID = ?";
        return (long) getForValue(sql, uid, iid);
    }


    public void delete(int fid) {
        String sql = "DELETE FROM travelimagefavor WHERE FavorID = ?";
        update(sql, fid);
    }

}
