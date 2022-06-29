package osnovni;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Loto2 {

    public static void main(String[] args) {

        System.out.println("Biraj \n 1: loto 7 od 35 \n 2: loto 6 od 45 \n 3: Odredi sam");

        Scanner korisnickiUnos = new Scanner(System.in);
        switch (korisnickiUnos.nextInt()){
            case 1:
                igrajLoto(7, 35);
                break;
            case 2:
                igrajLoto(6, 45);
                break;
            case 3:
                System.out.println("Koliko brojeva želite izvući? ");
                int brojevaZaIzvuci = korisnickiUnos.nextInt();
                System.out.println("Od koliko mogućih? ");
                int odMaxBrojeva = korisnickiUnos.nextInt();
                igrajLoto(brojevaZaIzvuci, odMaxBrojeva);
                break;

        }
    }

    private static void igrajLoto(int brojeva, int od){
        ispisiNaslovIgre(brojeva, od);
        int[] izvuceniBrojevi = izvuciBrojeve(brojeva, od);
        ispisiBrojeve(izvuceniBrojevi);
        ispisiPozdravnuPoruku();
    }

    private static int[] izvuciBrojeve(int brojevaZaIzvuci, int maxBroj) {

        int[] izvuceniBrojevi = new int[brojevaZaIzvuci];
        int izvuceniBroj;

        for (int i = 0; i < izvuceniBrojevi.length; i++) {
            izvuceniBroj = izvuciSlucajanBroj(1, maxBroj);
            if(Arrays.asList(izvuceniBrojevi).contains(izvuceniBroj)){
                izvuceniBroj = izvuciSlucajanBroj(1, maxBroj);
            }
            izvuceniBrojevi[i] = izvuciSlucajanBroj(1, maxBroj);

        }
        return izvuceniBrojevi;
    }

    private static int izvuciSlucajanBroj(int min, int max){
        Random rd = new Random();
        return rd.nextInt(max-min+1) + min;
    }

    private static void ispisiNaslovIgre(int brojeva, int odMax){
        System.out.println("Igra loto "+ brojeva + " od " +  odMax + " započinje !! \nA izvučeni brojevi su:");
    }

    private static void ispisiBrojeve(int[] izvuceniBrojevi){
        for (int i = 0; i < izvuceniBrojevi.length; i++) {
            System.out.print(izvuceniBrojevi[i] +" ");
        }
    }

    private static void ispisiPozdravnuPoruku() {
        System.out.println("\nHvala vam što ste se igrali s nama i nadama se da ste nešto i osvojili.");
    }
}

