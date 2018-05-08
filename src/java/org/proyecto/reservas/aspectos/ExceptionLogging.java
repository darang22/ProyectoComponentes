/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.proyecto.reservas.aspectos;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

/**
 *
 * @author skp
 */
@Aspect
public class ExceptionLogging {
    
    @AfterThrowing(
            pointcut = "execution(* org.proyecto.reservas.modelo.*.*(..))",
            throwing = "ex"
    )
    public void afterThrowingLog(JoinPoint joinPoint, Exception ex){
        
        System.out.println("AfterThrowing: Excepcion en el metodo: "
                            +joinPoint.getSignature().getName()
                            +",  Clase: "+joinPoint.getTarget().getClass().getName());
        System.out.println("Excepcion: "+ex.getMessage());
        
    }
   
    
}
