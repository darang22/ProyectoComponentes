package org.proyecto.reservas.modelo;

import org.thanos.reservations.Reserva;
import java.util.Date;

/**
 *
 * @author dsalazar
 */
public abstract class Usuario {
    String username;
    int codigo;
    boolean autorizado;
    boolean activo;
    
    
    void peticionReserva(Date inicio, Date fin){
        
    }
    
    void cancelarReserva(Reserva reserva){
        
    }
    
    void BusquedaAulasDisponibles(Date inicio, Date fin, int capacidad){
        
    }
}
