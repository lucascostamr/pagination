/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pagination.Controller;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lucas
 */
public class CadeiaReferencia {
    private List<Integer> pagesUniqueId = new ArrayList<>();
    private List<Integer> sequenceNormalized = new ArrayList<>();

    public CadeiaReferencia(String sequencia) {
        this.separate(sequencia);
    }

/**
 * Separa cada id em dois arrays, um array contendo apenas ids unicos e o outro contendo todos os ids.
 * @param sequencia uma string contendo uma sequencia de numeros, que no contexto sao Ids.
 */
    private void separate(String sequencia) {
        for(int i=0; i<sequencia.length(); i++) {
            int id = Integer.parseInt(String.valueOf(sequencia.charAt(i)));
            if(!this.pagesUniqueId.contains(id)) {
                this.pagesUniqueId.add(id);
            }
            this.sequenceNormalized.add(id);
        }
    }

    public List<Integer> getSequenceNormalized() {
        return this.sequenceNormalized;
    }

    public List<Integer> getUniqueIds() {
        return this.pagesUniqueId;
    }
}
