
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class RamPanel extends JPanel {
    private Ram ram;

    public RamPanel(Ram ram) {
        this.ram = ram;
    }

    public void setRam(Ram ram) {
        this.ram = ram;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawMolduras(g);
    }

    private void drawMolduras(Graphics g) {
        List<Page> molduras = ram.getMolduras();
        int colWidth = getWidth() / ram.getTamanhoMoldura();

        for (int i = 0; i < molduras.size(); i++) {
            int x = i * colWidth;
            int y = molduras.get(i).getId() * 20; 

            g.drawString("x", x, y);
        }
    }

    public void updateMoldura() {
        repaint(); 
    }
}
