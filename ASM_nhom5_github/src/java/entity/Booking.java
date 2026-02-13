/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="Bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookingID;

    private int roomID;
    private String customerEmail;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalPrice;
    private String status;

    public void setRoomID(int id){roomID=id;}
    public void setCustomerEmail(String e){customerEmail=e;}
    public void setCheckIn(LocalDate d){checkIn=d;}
    public void setCheckOut(LocalDate d){checkOut=d;}
    public void setTotalPrice(double p){totalPrice=p;}
    public void setStatus(String s){status=s;}

    public int getBookingID(){return bookingID;}
}
