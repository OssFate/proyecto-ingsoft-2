package t3webproject;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProcesoRaton extends MouseAdapter {
    int RatonX = 25, RatonY = 25;
    
    @Override
    public void mouseEntered( MouseEvent evt ){
        RatonX = evt.getX();
        RatonY = evt.getY();
        
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 180 && RatonY <= 247)){
            // Eventos para el botón "Iniciar"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 256 && RatonY <= 325)){
            // Eventos para el botón "Crear partida"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 334 && RatonY <= 401)){
            // Eventos para el botón "Créditos"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 411 && RatonY <= 478)){
            // Evento para el botón "Salir"
        }
    }
    
    @Override
    public void mouseExited( MouseEvent evt){
        RatonX = evt.getX();
        RatonY = evt.getY();
        
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 180 && RatonY <= 247)){
            // Eventos para el botón "Iniciar"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 256 && RatonY <= 325)){
            // Eventos para el botón "Crear partida"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 334 && RatonY <= 401)){
            // Eventos para el botón "Créditos"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 411 && RatonY <= 478)){
            // Evento para el botón "Salir"
            //System.exit(0);
        }
    }
    
    @Override
    public void mousePressed( MouseEvent evt ) {
        RatonX = evt.getX();
        RatonY = evt.getY();
        
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 180 && RatonY <= 247)){
            // Eventos para el botón "Iniciar"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 256 && RatonY <= 325)){
            // Eventos para el botón "Crear partida"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 334 && RatonY <= 401)){
            // Eventos para el botón "Créditos"
        }
        if((RatonX >= 90 && RatonX <= 317)&&(RatonY >= 411 && RatonY <= 478)){
            // Evento para el botón "Salir"
            System.exit(0);
        }
    }
    
    public int getRatonX() { return RatonX; }
    public void setRatonX(int RatonX) { this.RatonX = RatonX; }
    public int getRatonY() { return RatonY; }
    public void setRatonY(int RatonY) { this.RatonY = RatonY; }
}
