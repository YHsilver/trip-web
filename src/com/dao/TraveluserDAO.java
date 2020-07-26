package com.dao;

import com.entity.Traveluser;

import java.util.List;

public class TraveluserDAO extends BaseDAO<Traveluser> {
    public List<Traveluser> getAll() {
        String sql = "SELECT * FROM traveluser";
        return getForList(sql);
    }

    public void save(Traveluser user) {
        String sql = "INSERT INTO traveluser(email, userName, pass, state, dateJoined, dateLastModified) VALUES(?,?,?,?,?,?)";
        update(sql, user.getEmail(), user.getUserName(), user.getPass(), user.getState(), user.getDateJoined(), user.getDateLastModified());
    }

    public void update(Traveluser user){
        String sql = "UPDATE traveluser SET " +
                "email = ?," +
                "userName = ?," +
                "pass = ?," +
                "State = ?," +
                "friendsUid = ?," +
                "historyImageId = ? " +
                "WHERE UID = ?";
        update(sql, user.getEmail(), user.getUserName(), user.getPass(), user.getState(), user.getFriendsUid(),
                user.getHistoryImageId(),user.getUid());

    }

    public Traveluser get(int id) {
        String sql = "SELECT * FROM traveluser WHERE uid = ?";
        return get(sql, id);
    }

    public Traveluser getByName(String username) {
        String sql = "SELECT * FROM traveluser WHERE UserName = ?";
        return get(sql, username);
    }

    public long getCountWithName(String name) {
        String sql = "SELECT count(uid) FROM traveluser WHERE UserName = ?";

        return (long)getForValue(sql, name);

    }

}

