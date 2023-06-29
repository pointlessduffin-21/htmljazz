package com.yeems214.springmvcsample.Service;

import com.yeems214.springmvcsample.Model.Room;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServices {
    private static List<Room> rooms = new ArrayList<>();

    static {
        for (int i=0; i<10; i++) {
            rooms.add(new Room(i, "Room " + i, "R" + i, "This is room " + i));
        }
    }

    public List<Room> getAllRooms() {
        return rooms;
    }


}
