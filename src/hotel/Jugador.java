/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel;

import java.util.ArrayList;

/**
 *
 * @author Danny
 */
public class Jugador {
    private String name;
    private Integer dinero;
    private ArrayList <Hoteles> hoteles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDinero() {
        return dinero;
    }

    public void setDinero(Integer dinero) {
        this.dinero = dinero;
    }

    public ArrayList<Hoteles> getHoteles() {
        return hoteles;
    }

    public void setHoteles(ArrayList<Hoteles> hoteles) {
        this.hoteles = hoteles;
    }

    public Jugador(String name) {
        this.name=name;
        this.dinero=25000000;
        hoteles= new ArrayList <>();
    }
    
    
}
