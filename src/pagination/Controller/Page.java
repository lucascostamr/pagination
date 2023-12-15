/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.Controller;

/**
 *
 * @author lucas
 */
public class Page {
    private static long tempoAtual;
    private int id;
    private int qntAcesso = 0;
    private int prioridade;
    private int conteudo;
    private long idade;
    private long ultimoAcesso;
    private long tempoMemoria;

    public Page(int id, int prioridade, int conteudo) {
        this.id = id;
        this.ultimoAcesso = System.nanoTime();
        this.prioridade = prioridade;
        this.conteudo = conteudo;
    }

    public Page(int id, int prioridade) {
        this.id = id;
        this.ultimoAcesso = System.nanoTime();
        this.prioridade = prioridade;
    }

    public Page(int id) {
        this.id = id;
        this.ultimoAcesso = System.nanoTime();
    }

    public void getAccess() {
        this.qntAcesso++;
        this.ultimoAcesso = System.nanoTime();
        return;
    }

    public int getId() {
        return this.id;
    }

    public long getUltimoAcesso() {
        return this.ultimoAcesso;
    }

    public int getQuantidadeAcessos() {
        return qntAcesso;
    }

    public long getIdade() {
        return this.idade;
    }

    public long getTempoNaMemoria() {
        this.tempoMemoria = tempoAtual - this.idade;
        return this.tempoMemoria;
    }

    public static void setTempoAtual(long tempo) {
        tempoAtual = tempo;
        return;
    }

    public void setIdade(long idade) {
        this.idade = idade;
        return;
    }
}
