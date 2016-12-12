/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.sql.Date;
import java.util.Objects;




/**
 *
 * @author Steven
 */
public class Trabajador {
    /*ATRIBUTOS*/
    private int trabajadorid;
    private String cedula;
    private String nombres;
    private String apellidos;
    private Date fecha_nac;
    private String sexo;
    private String direccion;
    private String telefono;
    private String contraseña;
    private Cargo cargo;

     /*METODO CONSTRUCTOR POR DEFECTO*/
    public Trabajador() {
    }
    
     /*METODO CONSTRUCTOR POR PARAMETROS*/

    public Trabajador(int trabajadorid, String cedula, String nombres, String apellidos, Date fecha_nac, String sexo, String direccion, String telefono, String contraseña, Cargo cargo) {
        this.trabajadorid = trabajadorid;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fecha_nac = fecha_nac;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.contraseña = contraseña;
        this.cargo = cargo;
    }
    

     /*METODOS GET AND SET*/

    public int getTrabajadorid() {
        return trabajadorid;
    }

    public void setTrabajadorid(int trabajadorid) {
        this.trabajadorid = trabajadorid;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

   

    
   
    
    

    
    
    
}
