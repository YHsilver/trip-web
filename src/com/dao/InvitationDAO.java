package com.dao;

import com.entity.Invitation;

import java.util.List;

public class InvitationDAO extends BaseDAO<Invitation> {
    public List<Invitation> getAll() {
        String sql = "SELECT * FROM invitation";
        return getForList(sql);
    }

    public void save(Invitation iv){
        String sql = "INSERT INTO invitation(senderUid, receiverUid, state) VALUES(?,?,?)";
        update(sql, iv.getSenderUid(),iv.getReceiverUid(),iv.getState());
    }


    public void delete(int iid) {
        String sql = "DELETE FROM invitation WHERE invitationId = ?";
        update(sql, iid);
    }

    public void updateState(Invitation iv){
        String sql = "UPDATE invitation SET state = ? WHERE invitationId = ?";
        update(sql,iv.getState(),iv.getInvitationId());
    }


    public Invitation get(int iid){
        String sql = "SELECT * FROM invitation WHERE invitationId = ?";
        return get(sql,iid);

    }

    public List<Invitation> getBySenderUid(int suid){
        String sql = "SELECT * FROM invitation WHERE senderUid = ?";
        return getForList(sql,suid);

    }

    public List<Invitation> getBySenderAndReceiver(int suid,int ruid){
        String sql = "SELECT * FROM invitation WHERE senderUid = ? AND receiverUid = ?";
        return getForList(sql,suid,ruid);

    }

    public List<Invitation> getByReceiverUid(int ruid){
        String sql = "SELECT * FROM invitation WHERE receiverUid = ?";
        return getForList(sql,ruid);
    }


    public List<Invitation> getBySenderUidAndState(int suid, int state){
        String sql = "SELECT * FROM invitation WHERE senderUid = ? AND state = ?" ;
        return getForList(sql,suid,state);

    }


    public List<Invitation> getByReceiverUidAndState(int ruid, int state){
        String sql = "SELECT * FROM invitation WHERE receiverUid = ? AND state = ? ";
        return getForList(sql,ruid,state);
    }



}
