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
public class Base {
    protected List<Integer> sequencia;
    protected List<Page> pages;
    protected List<Page> molduras;
    protected int faltas;
    protected Ram ram;

    /**
     * Classe utilizada para comparar e aplicar a paginacao na memoria
     *
     * @param sequencia sequecia de acessos a paginas na memoria
     * @param pages     paginas a serem carregadas na memoria
     * @param ram       memoria a ser carregada
     */
    public Base(List<Integer> sequencia, List<Page> pages, Ram ram) {
        this.sequencia = sequencia;
        this.pages = pages;
        this.ram = ram;
        this.molduras = ram.getMolduras();
        this.faltas = 0;
    }

    /**
     * Preenche a memoria com as primeiras paginas
     */
    protected void init() {
        for (int i = 0; i < this.ram.getTamanhoMoldura(); i++) {
            if(this.pages.size() == i) return;

            Page page = this.pages.get(i);

            page.getAccess();
            page.setIdade(System.nanoTime());
            this.faltas++;
            this.molduras.add(i, page);
            this.sequencia.remove(0);
            this.notContainMessage(page.getId());
            this.ram.showMoldura();
        }

        this.ram.setMolduras(this.molduras);
    }

    /**
     * Metodo que inicia metodos de checagem, mudanca e mostra numero de faltas
     */
    public void start() {
        for (int id : this.sequencia) {
            if (!this.check(id)) {
                this.change(id);
            }
            ram.showMoldura();
        }

        this.showFaltas();
    }

    /**
     * Verifica se a pagina esta presente na memoria
     *
     * @param id ID da pagina
     * @return TRUE se a pagina estiver em memoria; FALSE se a pagina nao estiver na
     *         memoria
     */
    protected boolean check(int id) {
        for (int i = 0; i < this.ram.getTamanhoMoldura(); i++) {
            Page page = this.molduras.get(i);

            if (page.getId() == id) {
                this.containMessage(id);
                page.getAccess();
                return true;
            }
        }
        this.notContainMessage(id);

        return false;
    }

    /**
     * Realiza a troca da pagina de acordo com o algoritimo de substituicao escolhido
     *
     *
     * @param id ID da pagina a ser carregada na memoria
     */
    protected void change(int id) {
        for (Page page : this.pages) {
            if (page.getId() == id) {
                this.faltas++;
                page.getAccess();
                page.setIdade(System.nanoTime());
                this.molduras.set(0, page);
                break;
            }
        }
        ram.setMolduras(this.molduras);
    }

    /**
     * Exibe o total de faltas, ou seja, o total de vezes que foi preciso trocar
     * paginas na memoria
     */
    private void showFaltas() {
        System.out.println("\nTotal de Faltas: " + this.faltas);
    }

    /**
     * Imprime na tela uma mensagem caso a pagina esteja presente na memoria
     * @param id ID da Pagina
     */
    protected void containMessage(int id) {
        System.out.println("\nContem: " + id);
    }

    /**
     * Imprime na tela uma mensagem caso a pagina nao esteja presente na memoria
     * @param id ID da Pagina
     */
    protected void notContainMessage(int id) {
        System.out.println("\nNao contem: " + id);
    }
}
