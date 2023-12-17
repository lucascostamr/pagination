/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pagination.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import pagination.Controller.algoritimosSubstituicao.FIFO;
import pagination.Controller.algoritimosSubstituicao.Otimo;

/**
 *
 * @author lucas
 */
public class Pagination {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Scanner input;
        List<Page> pages;

        Ram ram;
        CadeiaReferencia referencia;
        FIFO fifo;
        Otimo otimo;

        String sequencia;
        int molduras;

        // input = new Scanner(System.in);
        // System.out.println("Digite a sequecia: ");
        // sequencia = input.nextLine();
        // System.out.println("\nDigite o tamanho da moldura: ");
        // molduras = input.nextInt();
        // input.close();

        sequencia = "70120304230321201701";
        molduras = 3;

        pages = new ArrayList<>();
        ram = new Ram(molduras);
        referencia = new CadeiaReferencia(sequencia);

        for (int i : referencia.getUniqueIds()) {
            pages.add(new Page(i));
        }

    //    fifo = new FIFO(referencia.getSequenceNormalized(), pages, ram);
    //    fifo.start();

        otimo = new Otimo(referencia.getSequenceNormalized(), pages, ram);
        otimo.start();
    }
    
}
