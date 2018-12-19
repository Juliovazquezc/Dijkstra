/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guidjisktra;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

/**
 *
 * @author JulioCésar
 */
public class Panel extends JPanel {
    GUI gui;
    
    public Panel(GUI gui){
        this.gui = gui;
    }
    
    @Override
    public void paintComponent(Graphics g){
        //Se invoca el método para que repinte el panel
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        
        
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        for(Enlace e : gui.enlaces){           
            //Parametros para el enlace
            g2.setColor(Color.BLUE);
            g2.drawLine(e.getNodo1X()+5, e.getNodo1Y()+5, e.getNodo2X()+7, e.getNodo2Y()+7);
            //Parametros para el peso del enlace
            g.setColor(Color.BLACK);
            int mitadX = (e.getNodo1X() + e.getNodo2X())/2;
            int mitadY = (e.getNodo1Y() + e.getNodo2Y())/2;
            g.drawString(String.valueOf(e.getPeso()), mitadX, mitadY);
        }
        
        //Pinta los routers
        for(Nodo n : gui.nodos){
            g.drawImage(gui.router, n.getNodoX(), n.getNodoY(),null);
            g.drawString(n.getNombre(), n.getNodoX(), n.getNodoY());
        }
    }
    
}
