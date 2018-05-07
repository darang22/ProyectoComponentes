package org.proyecto.reservas.modelo;

import java.util.Date;

/**
 *
 * @author dsalazar
 */
public class Reserva {
    Date inicio;
    Date fin;
    short autorizada;
    String codigoSolicitante;
    Aula aula;
}