package com.example.midan.Bootstrap;

import com.example.midan.model.Employee;
import com.example.midan.model.Guest;
import com.example.midan.model.Offer;
import com.example.midan.model.Room;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Employee> employeeList = new ArrayList<>();
    public static List<Guest> guestList = new ArrayList<>();
    public static List<Offer> offerList = new ArrayList<>();
    public static List<Room> roomList = new ArrayList<>();
}
