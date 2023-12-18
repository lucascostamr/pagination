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
import pagination.Controller.algoritimosSubstituicao.LRU;

/**
 *
 * @author lucas
 */
public class Pagination {
    private static Scanner input;
    private static List<Page> pages;

    private static Ram ram;
    private static CadeiaReferencia referencia;
    private static FIFO fifo;
    private static Otimo otimo;
    private static LRU lru;

    private static String sequencia;
    private static int molduras, algoritimo;

    private static boolean running = true;
    private static boolean changeInput = false;
    private static boolean sameInput = false;

    private static void setInputs() {
        System.out.println("Digite a sequecia: ");
        sequencia = input.next();
        System.out.println("\nDigite o tamanho da moldura: ");
        molduras = input.nextInt();
        
        setAlgorithm();
    }

    private static void setAlgorithm() {
        System.out.println("\nEscolha o algoritimo de substituicao: 1 (FIFO); 2 (OPT); 3 (LRU)");
        algoritimo = input.nextInt();
    }

    private static void badInput() {
        System.out.println("\nFaca uma escolha valida!");
    }

    private static void again() {
        int answer;
        System.out.println("\n 1 (Mudar input); 2 (Manter input); 3 (Finalizar)");
        answer = input.nextInt();

        if(answer == 1) {
            changeInput = true;
        } else if (answer == 2) {
            sameInput = true;
        } else if (answer == 3) {
            running = false;
        } else {
            badInput();
        }
    }

    private static void init() {
        pages = new ArrayList<>();
        ram = new Ram(molduras);
        referencia = new CadeiaReferencia(sequencia);

        for (int i : referencia.getUniqueIds()) {
            pages.add(new Page(i));
        }
    }

    private static void chooseAlgorithm() {
         if(algoritimo == 1) {
            fifo = new FIFO(referencia.getSequenceNormalized(), pages, ram);
            fifo.start();
        } else if(algoritimo == 2) {
            otimo = new Otimo(referencia.getSequenceNormalized(), pages, ram);
            otimo.start();
        } else if(algoritimo == 3) {
            lru = new LRU(referencia.getSequenceNormalized(), pages, ram);
            lru.start();
        } else {
            badInput();
        }
    }

    public static void main(String[] args) throws Exception {
        input = new Scanner(System.in);

        setInputs();
        init();

        while(running) {
            if(changeInput) {
                setInputs();
                init();
                changeInput = false;
            } else if(sameInput) {
                setAlgorithm();
                init();
                sameInput = false;
            }
            
            chooseAlgorithm();

            again();
        }

        input.close();
    }
}
