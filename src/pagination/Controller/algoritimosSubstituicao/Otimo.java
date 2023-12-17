/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.Controller.algoritimosSubstituicao;

import java.util.ArrayList;
import java.util.List;
import pagination.Controller.Page;
import pagination.Controller.Ram;

/**
 *
 * @author lucas
 */
public class Otimo extends Base {
    private List<Integer> distanceToAcess;

    public Otimo(List<Integer> sequencia, List<Page> pages, Ram ram) {
        super(sequencia, pages, ram);
        
        this.distanceToAcess = new ArrayList<>(sequencia);

        this.init();
    }
    
    @Override
    protected boolean check(int id) {
        if(!this.distanceToAcess.isEmpty()) {
            this.distanceToAcess.remove(0);
        }
        
        for (int i = 0; i < this.ram.getTamanhoMoldura(); i++) {
            Page page = this.molduras.get(i);

            if (page.getId() == id) {
                System.out.println("\nContem: " + id);
                page.getAccess();
                return true;
            }
        }
        System.out.println("\nNao contem: " + id);

        
        return false;
    }

    @Override
    protected void change(int id) {
        for (Page page : this.pages) {
            if (page.getId() == id) {
                this.faltas++;
                page.getAccess();
                page.setIdade(System.nanoTime());
                this.molduras.set(ram.getMaisTempoSemAcesso(this.distanceToAcess), page);                
                break;
            }
        }
        ram.setMolduras(this.molduras);
    }
}
