package pagination.Controller.algoritimosSubstituicao;

import java.util.List;
import pagination.Controller.Page;
import pagination.Controller.Ram;

public class LRU extends Base {
    /**
     * Algoritimo de Substituicao LRU(Least Recently Used)
     *
     * @param sequencia sequecia de acessos a paginas na memoria
     * @param pages     paginas a serem carregadas na memoria
     * @param ram       memoria a ser carregada
     */
    public LRU(List<Integer> sequencia, List<Page> pages, Ram ram) {
        super(sequencia, pages, ram);

        this.init();
    }

    @Override
    protected void change(int id) {
        for (Page page : this.pages) {
            if (page.getId() == id) {
                this.faltas++;
                page.getAccess();
                page.setIdade(System.nanoTime());
                this.molduras.set(this.ram.leastAcessed(), page);
                break;
            }
        }
        ram.setMolduras(this.molduras);
    }
}
