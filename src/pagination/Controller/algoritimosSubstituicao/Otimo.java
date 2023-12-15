/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.Controller.algoritimosSubstituicao;

import java.util.List;
import pagination.Controller.Page;
import pagination.Controller.Ram;

/**
 *
 * @author lucas
 */
public class Otimo extends Base {
    public Otimo(List<Integer> sequencia, List<Page> pages, Ram ram) {
        super(sequencia, pages, ram);
    }
    
    @Override
    protected void change(int id) {
        for (Page page : this.pages) {
            if (page.getId() == id) {
                this.faltas++;
                page.getAccess();
                page.setIdade(System.nanoTime());
                this.molduras.set(ram.leastAcessed(), page);
                break;
            }
        }
        ram.setMolduras(this.molduras);
    }
}
