/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.Objects;

/**
 *
 * @author Steven
 */
public class Cargo {
    private int cargoid;
    private String cargo;
    private double sueldo;

    public Cargo() {
    }

    public Cargo(int cargoid, String cargo, double sueldo) {
        this.cargoid = cargoid;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public Cargo(String cargo) {
        this.cargo = cargo;
    }

    
    public int getCargoid() {
        return cargoid;
    }

    public void setCargoid(int cargoid) {
        this.cargoid = cargoid;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return cargo ;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cargo other = (Cargo) obj;
        if (!Objects.equals(this.cargo, other.cargo)) {
            return false;
        }
        return true;
    }

    
    
    
}
