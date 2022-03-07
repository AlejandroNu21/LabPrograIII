/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Entidades.Persona;
import java.util.ArrayList;

/**
 *
 * @author Josss_k4ptalp
 */
public interface IPersona {
    
    ArrayList<Persona> ListaPersonas();
    
    void AddPersonas(Persona persona);

    void UpdatePersona(Persona persona);
}
