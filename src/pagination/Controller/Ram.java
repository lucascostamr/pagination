/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.Controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author lucas
 */
public class Ram {
    private List<Page> molduras;
    private int qntMolduras;

    public Ram(int qntMolduras) {
        this.molduras = new ArrayList<>(qntMolduras);
        this.qntMolduras = qntMolduras;
    }

    public List<Page> getMolduras() {
        return this.molduras;
    }

    public void setMolduras(List<Page> newMolduras) {
        this.molduras = newMolduras;
    }

    public void fill(Page page, int index) {
        this.molduras.add(index, page);
    }

    public int getOlderPosition() {
        Page.setTempoAtual(System.nanoTime());

        Page page = this.molduras
                .stream()
                .max(Comparator.comparing(Page::getTempoNaMemoria))
                .orElse(null);

        return this.molduras.indexOf(page);
    }
    
    public int leastAcessed() {
        Page page = this.molduras
                .stream()
                .min(Comparator.comparing(Page::getUltimoAcesso))
                .orElse(null);

        return this.molduras.indexOf(page);
    }
    
    public void showMoldura() {
        List<Integer> pageIdsMoldura = new ArrayList<>();

        for (Page page : this.molduras) {
            pageIdsMoldura.add(page.getId());
        }

        System.out.println(pageIdsMoldura.toString());
    }

    public int getTamanhoMoldura() {
        return this.qntMolduras;
    }
}
