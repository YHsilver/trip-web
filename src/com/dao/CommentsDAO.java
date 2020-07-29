package com.dao;

import com.entity.Comments;

import java.util.List;

public class CommentsDAO extends BaseDAO<Comments> {
    public List<Comments> getAll() {
        String sql = "SELECT * FROM comments";
        return getForList(sql);
    }

    public Comments getById(int cid) {
        String sql = "SELECT * FROM comments WHERE cid = ?";
        return get(sql,cid);
    }

    public void save(Comments comment) {
        String sql = "INSERT INTO comments(username,imageId,comment) VALUES (?,?,?)";
        update(sql,comment.getUsername(),comment.getImageId(),comment.getComment());
    }

    public void updateHeat(Comments comment){
        String sql = "UPDATE comments SET " +
                "hot = ? " +
                "WHERE cid = ?";
        update(sql, comment.getHot(),comment.getCid());

    }

    public List<Comments> getAllByTimeForImg(int iid) {
        String sql = "SELECT * FROM comments WHERE imageId = ? ORDER BY time DESC";
        return getForList(sql,iid);
    }

    public List<Comments> getAllByHotForImg(int iid) {
        String sql = "SELECT *FROM comments WHERE imageId = ? ORDER BY hot DESC";
        return getForList(sql,iid);
    }

}
