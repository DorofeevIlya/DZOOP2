package S3;

import java.util.ArrayList;
import java.util.Random;

import static S2.Homework.*;

public class Main {
    public static void main(String[] args) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";
        final String ANSI_PURPLE  = "\u001B[35m";
//        Random rand = new Random();
        Render render = new Render();

        Building building1 = new Building(100);
        building1.setCurrentHealth(80);
        render.showIndicator(building1);

        Hero hero1 = new Hero(100, 100);
        hero1.setCurrentHealth(30);
        hero1.setCurrentMana(40);
        render.showIndicator(hero1);

        Neutral neutral1 = new Neutral(100);
        neutral1.setCurrentHealth(10);
        render.showIndicator(neutral1);
    }

    static class Render {
        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         */
        public void showIndicator(Substance substance) {
            System.out.println("\u001B[0m"+substance.getClass().toString().substring(substance.getClass().toString().indexOf(".")+1)+" id: "+substance.getId());
            if (substance instanceof Health) {
                int max=((Health) substance).getMaxHealth();
                System.out.println(colorIndocator((int)max) + "Максимальный уровень здоровья: " + max + ANSI_RESET);
                int curr=((Health) substance).getCurrentHealth();
                System.out.println(colorIndocator((int)curr) + "Текущий уровень здоровья: " + curr + ANSI_RESET);
            }
            if (substance instanceof Mana) {
                int max=((Mana) substance).getMaxMana();
                System.out.println(colorIndocator((int)max) + "Максимальный уровень маны: " + max + ANSI_RESET);
                int curr=((Mana) substance).getCurrentMana();
                System.out.println(colorIndocator((int)curr) + "Текущий уровень маны: " + curr + ANSI_RESET);
            }
        }
       private String colorIndocator (int curr) {
           String color = ANSI_GREEN;
           if (curr < 75) color = ANSI_YELLOW;
           if (curr < 50) color = ANSI_PURPLE;
           if (curr < 25) color = ANSI_RED;
           return color;
        }
   }
}
