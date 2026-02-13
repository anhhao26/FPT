/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.Room;
import jakarta.persistence.EntityManager;
import utils.JpaUtils;
import java.util.List;

public class RoomDAO {

    public List<Room> findAvailable(int people){

        EntityManager em=JpaUtils.getEntityManager();

        List<Room> list=em.createQuery(
            "FROM Room r WHERE r.capacity >= :p AND r.isActive=true",
            Room.class)
            .setParameter("p",people)
            .getResultList();

        em.close();
        return list;
    }

    public Room find(int id){
        EntityManager em=JpaUtils.getEntityManager();
        Room r=em.find(Room.class,id);
        em.close();
        return r;
    }
}

