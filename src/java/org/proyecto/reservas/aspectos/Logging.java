/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.reservas.aspectos;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.JoinPoint;


/**
 *
 * @author skp
 */
@Aspect
public class Logging {
    
    
    @After("execution(* org.proyecto.reservas.modelo.Administrador.*(..))")
    public void logTodos(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto accion del Administrador: " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* org.proyecto.reservas.modelo.Administrador.autorizarUsuario(..))")
    public void logAfterAutorizarUsuario(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto Administrador.autorizarUsuario: " + joinPoint.getSignature().getName());
    }
    @After("execution(* org.proyecto.reservas.modelo.Administrador.desautorizarUsuario(..))")
    public void logAfterDesautorizarUsuario(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto Administrador.desautorizarUsuario: " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* org.proyecto.reservas.modelo.Administrador.autorizarReserva(..))")
    public void logAfterAutorizarReserva(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto Administrador.autorizarReserva: " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* org.proyecto.reservas.modelo.Administrador.desautorizarReserva(..))")
    public void logAfterDesautorizarReserva(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto Administrador.autorizarReserva: " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* org.proyecto.reservas.modelo.Administrador.denegarReserva(..))")
    public void logAfterDenegarReserva(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto Administrador.denegarReserva: " + joinPoint.getSignature().getName());
    }
    
    @After("execution(* org.proyecto.reservas.modelo.Administrador.verReservas(..))")
    public void logAfterVerReservas(JoinPoint joinPoint)
    {
        System.out.println("Se ejecuto Administrador.verReservas: " + joinPoint.getSignature().getName());
    }
    
    
}
