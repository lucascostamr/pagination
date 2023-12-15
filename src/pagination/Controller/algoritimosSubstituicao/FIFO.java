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
public class FIFO extends Base{
    /**
     * Algoritimo de Substituicao FIFO(First In, First Out)
     *
     * @param sequencia sequecia de acessos a paginas na memoria
     * @param pages     paginas a serem carregadas na memoria
     * @param ram       memoria a ser carregada
     */
    public FIFO(List<Integer> sequencia, List<Page> pages, Ram ram) {
        super(sequencia, pages, ram);
    }
    
    @Override
    protected void change(int id) {
        for (Page page : this.pages) {
            if (page.getId() == id) {
                this.faltas++;
                page.getAccess();
                page.setIdade(System.nanoTime());
                this.molduras.set(ram.getOlderPosition(), page);
                break;
            }
        }
        ram.setMolduras(this.molduras);
    }
}
   
