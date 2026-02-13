/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import service.*;
import java.time.LocalDate;

public class BookingController {

    BookingService booking=new BookingServiceImpl();
    VoucherService voucher=new VoucherServiceImpl();

    public String book(int roomId,String email,
                       LocalDate in,LocalDate out,
                       double price,String code){

        String result=voucher.check(code,price);

        if(!result.equals("OK"))
            return result;

        price=voucher.apply(code,price);

        var b=booking.hold(roomId,email,in,out,price);

        return "BOOKED:"+b.getBookingID()+":"+price;
    }

    public void confirm(int bookingId){
        booking.confirm(bookingId);
    }
}

