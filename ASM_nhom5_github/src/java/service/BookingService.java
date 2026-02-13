/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.time.LocalDate;
import entity.Booking;

public interface BookingService {

    boolean available(int roomId,LocalDate in,LocalDate out);

    Booking hold(int roomId,String email,
                 LocalDate in,LocalDate out,double price);

    void confirm(int bookingId);
}
