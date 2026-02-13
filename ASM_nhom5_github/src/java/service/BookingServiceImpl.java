/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.BookingDAO;
import entity.Booking;
import java.time.LocalDate;

public class BookingServiceImpl implements BookingService{

    BookingDAO dao=new BookingDAO();

    public boolean available(int id,LocalDate in,LocalDate out){
        return dao.available(id,in,out);
    }

    public Booking hold(int roomId,String email,
                        LocalDate in,LocalDate out,double price){

        if(!dao.available(roomId,in,out))
            throw new RuntimeException("ROOM_NOT_AVAILABLE");

        Booking b=new Booking();
        b.setRoomID(roomId);
        b.setCustomerEmail(email);
        b.setCheckIn(in);
        b.setCheckOut(out);
        b.setTotalPrice(price);
        b.setStatus("PENDING");

        dao.save(b);
        return b;
    }

    public void confirm(int id){
        Booking b=dao.find(id);
        b.setStatus("PAID");
        dao.update(b);
    }
}
