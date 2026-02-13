/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Booking;
import jakarta.persistence.EntityManager;
import utils.JpaUtils;
import java.time.LocalDate;

public class BookingDAO {

    public boolean available(int roomId,LocalDate in,LocalDate out){

        EntityManager em=JpaUtils.getEntityManager();

        Long count=em.createQuery(
        "SELECT COUNT(b) FROM Booking b "+
        "WHERE b.roomID=:id "+
        "AND b.status IN ('PENDING','PAID') "+
        "AND (:in < b.checkOut AND :out > b.checkIn)",
        Long.class)
        .setParameter("id",roomId)
        .setParameter("in",in)
        .setParameter("out",out)
        .getSingleResult();

        em.close();
        return count==0;
    }

    public void save(Booking b){
        EntityManager em=JpaUtils.getEntityManager();
        em.getTransaction().begin();
        em.persist(b);
        em.getTransaction().commit();
        em.close();
    }

    public Booking find(int id){
        EntityManager em=JpaUtils.getEntityManager();
        Booking b=em.find(Booking.class,id);
        em.close();
        return b;
    }

    public void update(Booking b){
        EntityManager em=JpaUtils.getEntityManager();
        em.getTransaction().begin();
        em.merge(b);
        em.getTransaction().commit();
        em.close();
    }
}
