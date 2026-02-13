/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import dao.VoucherDAO;
import entity.Voucher;
import java.time.LocalDateTime;

public class VoucherServiceImpl implements VoucherService{

    VoucherDAO dao=new VoucherDAO();

    public String check(String code,double total){

        Voucher v=dao.find(code);

        if(v==null) return "NOT_FOUND";
        if(!v.isActive()) return "DISABLED";

        LocalDateTime now=LocalDateTime.now();

        if(now.isBefore(v.getStartDate())||
           now.isAfter(v.getEndDate()))
            return "EXPIRED";

        if(v.getUsedCount()>=v.getUsageLimit())
            return "LIMIT";

        if(total<v.getMinOrderValue())
            return "NOT_ENOUGH";

        return "OK";
    }

    public double apply(String code,double total){
        Voucher v=dao.find(code);
        return total-v.getDiscountAmount();
    }
}
