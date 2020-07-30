package com.dao;

import com.entity.Room;

import java.util.*;

public class RoomDAO {

    protected static Set<Room> allRooms = new HashSet<>();

    static{
        Timer timer = new Timer();
        timer.schedule(new RecycleTask(), 30 * 1000, 30 * 1000);
    }


    public Room findOrCreateRoom(String user1, String user2) {
        Room result = findRoomByUserOneAndUserTwo(user1, user2);
        if(result != null){
            return new Room(result.getUser1(), result.getUser2(), result.getMessages());
        }
        Room newRoom = new Room(user1, user2);
        allRooms.add(new Room(user1, user2));
        return newRoom;
    }


    public Room findRoom(String user1, String user2) {
        Room room = findRoomByUserOneAndUserTwo(user1, user2);
        if(room == null){
            return null;
        }
        return new Room(room.getUser1(), room.getUser2(), room.getMessages());
    }


    public void save(Room room) {
        Room roomInSet = findRoomByUserOneAndUserTwo(room.getUser1(), room.getUser2());
        if(roomInSet != null){
            roomInSet.setMessages(room.getMessages());
            roomInSet.setLastModified(room.getLastModified());
        }
    }

    private Room findRoomByUserOneAndUserTwo(String user1, String user2){
        // not safe for threads
        for (Room room: allRooms) {
            if((room.getUser1().equals(user1) && room.getUser2().equals(user2))
                    || (room.getUser1().equals(user2) && room.getUser2().equals(user1))){
                return room;
            }
        }
        return null;
    }

    private static class RecycleTask extends TimerTask {
        private static final long TIMEOUT = 30 * 1000; // 30 seconds

        @Override
        public void run() {
            System.out.println("Recycle Task executed: " + new Date());
            long now = new Date().getTime();
            Set<Room> removeSet = new HashSet<>();
            for (Room room : RoomDAO.allRooms) {
                System.out.print(room);
                if(now - room.getLastModified() > TIMEOUT){
                    removeSet.add(room);
                    System.out.println(" removed");
                }
            }
            RoomDAO.allRooms.removeAll(removeSet);
        }
    }
}
