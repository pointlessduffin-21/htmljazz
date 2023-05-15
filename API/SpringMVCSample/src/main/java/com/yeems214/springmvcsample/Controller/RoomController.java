package com.yeems214.springmvcsample.Controller;

import com.yeems214.springmvcsample.Service.RoomServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import com.yeems214.springmvcsample.Model.Room;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.ArrayList;

@Controller
@RequestMapping("/rooms")
public class RoomController {
    private RoomServices roomServices;

    @Autowired
    public RoomController(RoomServices roomServices) {
        super();
        this.roomServices = roomServices;
    }
    @GetMapping
    public String getAllRooms(Model model) {
        model.addAttribute("rooms", this.roomServices.getAllRooms());
        return "rooms";
    }
}
