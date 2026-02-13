/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Voucher;
import jakarta.persistence.EntityManager;
import utils.JpaUtils;

public class VoucherDAO {

    public Voucher find(String code){
        EntityManager em=JpaUtils.getEntityManager();
        Voucher v=em.find(Voucher.class,code);
        em.close();
        return v;
    }

    public void increase(String code){
        EntityManager em=JpaUtils.getEntityManager();
        em.getTransaction().begin();
        Voucher v=em.find(Voucher.class,code);
        v.setUsedCount(v.getUsedCount()+1);
        em.getTransaction().commit();
        em.close();
    }
}
