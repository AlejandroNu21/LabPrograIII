/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.Persona;
import Servicio.IPersona;
import com.alejandro.BD.ConexionAMYSQL;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author COREI5 10TH GEN
 */
public class Personas implements IPersona {

    ConexionAMYSQL con = new ConexionAMYSQL();
    Connection conexion = con.getConecction();

    public ArrayList<Persona> ListaPersonas() {
        ArrayList<Persona> listado = null;

        ConexionAMYSQL con = new ConexionAMYSQL();
        Connection conexion = con.getConecction();

        try {
            listado = new ArrayList<Persona>();
            CallableStatement cb = conexion.prepareCall("select * from contactos");
            ResultSet resultado = cb.executeQuery();

            while (resultado.next()) {
                Persona p = new Persona();
                p.setId(resultado.getInt("Id"));
                p.setNombre(resultado.getString("Nombre"));
                p.setEdad(resultado.getInt("Edad"));
                p.setEmail(resultado.getString("Email"));
                p.setNumeroDeTelefono(resultado.getString("NumeroDeTelefono"));

                listado.add(p);
            }

        } catch (Exception e) {
        }
        return listado;
    }

    public void AddPersonas(Persona p) {
        try {
            CallableStatement cb = conexion.prepareCall("insert into "
                    + "contactos (Nombre,Edad,Email,NumeroDeTelefono) values('" + p.getNombre() + "','" + p.getEdad() + "','" + p.getEmail() + "','" + p.getNumeroDeTelefono() + "')");
            cb.execute();

            JOptionPane.showMessageDialog(null, "Persona Agregada", "Mensaje sistems", 1);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error" + ex.toString(), "Mensaje sistems", 1);
        }
    }

    public void UpdatePersona(Persona p) {
        ConexionAMYSQL con = new ConexionAMYSQL();
        Connection conexion = con.getConecction();
        try {
            CallableStatement cb = conexion.prepareCall("update Contactos set Nombre=?, Edad=?, Email=?, NumeroDeTelefono=? where idContactos=?");
            cb.setString(1, p.getNombre());
            cb.setInt(2, p.getEdad());
            cb.setString(3, p.getEmail());
            cb.setString(4, p.getNumeroDeTelefono());
            cb.setInt(5, p.getId());
            cb.execute();

            JOptionPane.showMessageDialog(null, "Actualizado");

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error" + ex);
        }

    }

    }


