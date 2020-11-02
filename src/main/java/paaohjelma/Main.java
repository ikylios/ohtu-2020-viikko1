package ohtu.ohtuvarasto;

import ohtu.ohtuvarasto.Varasto;

public class Main {

    public static void main(String[] args) {

        Varasto mehua = new Varasto(100.0);
        Varasto olutta = new Varasto(100.0, 20.2);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutvarasto: " + olutta);

        if (1 == 1) {
            if (1 == 1) {
                mehua.otaVarastosta(2);
            }
        }

        for(int i = 0; i < 14; i++) {
            for(int j = 0; j < 14; j++) {
                mehua.otaVarastosta(1);
            }
        }

    }
}
