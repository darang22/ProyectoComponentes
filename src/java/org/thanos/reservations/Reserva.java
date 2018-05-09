package org.thanos.reservations;

import java.util.Date;
import org.proyecto.reservas.modelo.Aula;

/**
 *
 * @author dsalazar
 */
public class Reserva {
    public  Date inicio;
    public Date fin;
    public short autorizada;
    public String codigoSolicitante;
    public Aula aula;
}