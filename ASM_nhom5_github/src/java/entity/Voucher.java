/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="Vouchers")
public class Voucher {

    @Id
    @Column(name="VoucherCode")
    private String code;

    @Column(name="DiscountValue")
    private double discountAmount;

    @Column(name="MinOrderValue")
    private double minOrderValue;

    @Column(name="StartDate")
    private LocalDateTime startDate;

    @Column(name="EndDate")
    private LocalDateTime endDate;

    @Column(name="UsageLimit")
    private int usageLimit;

    @Column(name="UsedCount")
    private int usedCount;

    @Column(name="IsActive")
    private boolean isActive;

    public double getDiscountAmount(){return discountAmount;}
    public double getMinOrderValue(){return minOrderValue;}
    public LocalDateTime getStartDate(){return startDate;}
    public LocalDateTime getEndDate(){return endDate;}
    public int getUsageLimit(){return usageLimit;}
    public int getUsedCount(){return usedCount;}
    public boolean isActive(){return isActive;}
    public void setUsedCount(int c){usedCount=c;}
}
