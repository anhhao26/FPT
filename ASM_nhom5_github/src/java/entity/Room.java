/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import jakarta.persistence.*;

@Entity
@Table(name="Rooms")
public class Room {

    @Id
    private int roomID;
    private String roomType;
    private int capacity;
    private double price;
    private boolean isActive;

    public int getRoomID(){return roomID;}
    public double getPrice(){return price;}
}
