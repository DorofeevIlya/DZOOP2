package S2;
import java.lang.reflect.*;

public class Homework {
    public static final String ANSI_RESET   = "\u001B[0m";
//    public static final String ANSI_BLACK   = "\u001B[30m";
    public static final String ANSI_RED     = "\u001B[31m";
    public static final String ANSI_GREEN   = "\u001B[32m";
    public static final String ANSI_YELLOW  = "\u001B[33m";
//    public static final String ANSI_BLUE    = "\u001B[34m";
    public static final String ANSI_PURPLE  = "\u001B[35m";
//    public static final String ANSI_CYAN    = "\u001B[36m";
//    public static final String ANSI_WHITE   = "\u001B[37m";
    public static void main(String[] args) {

        Render render = new Render();

        // ========== ЗДАНИЯ ==========
        Building building = new Building(1000);
        building.setCurrentHealthPoint(500);

        // ========== ГЕРОИ ==========
        Hero hero = new Hero(100, 100);
        hero.setCurrentHealthPoint(60);
        hero.setCurrentManaPoint(20);

        // ========== НЕЙТРАЛЬНЫЕ ==========
        Neutral neutral = new Neutral(100);
        neutral.setCurrentHealthPoint(30);

        // В консоли должно быть примерно так: Текущий уровень здоровья: 50, максимальный уровень здоровья: 100

        // ========== ЗДАНИЯ ==========
        System.out.println("Здание");
        render.showIndicator(building);

        // ========== ГЕРОИ ==========
        System.out.println("Герой");
        render.showIndicator(hero);

        // ========== НЕЙТРАЛЬНЫЕ ==========
        System.out.println("Нейтральный");
        render.showIndicator(neutral);

        System.out.println(ANSI_RED + "This text has a red background but default text!" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "This text has a green background but default text!" + ANSI_RESET);
    } // End Main

    static class Render {
        /**
         * Если объект обладает уровнем здоровья, то отображается индикатор с текущим уровнем здоровья.
         * Если объект обладает уровнем магический энергии, то отображается индикатор с текущим уровнем энергии.
         * * В качестве упрощения, пусть вывод на дисплей = запись информации в консоль.
         */
        public void showIndicator(Object object) {
            // Не должно быть упоминания конкретных классов!!!
            if (object != null) {
                Class<?> ob = object.getClass();
                for (int i = 0; i < ob.getDeclaredMethods().length; i++) {
                    Method method = ob.getDeclaredMethods()[i];
                    switch (method.getName()) {
                        case "getMaxHealthPoint" -> {
                            try {
                                Object res = method.invoke(object);
                                System.out.println(getColor((int)res) + "Максимальный уровень здоровья: " + res + ANSI_RESET);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case "getCurrentHealthPoint" -> {
                            try {
                                Object res = method.invoke(object);
                                System.out.println(getColor((int)res) + "Текущий уровень здоровья: " + res + ANSI_RESET);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case "getMaxManaPoint" -> {
                            try {
                                Object res = method.invoke(object);
                                System.out.println(getColor((int)res) + "Максимальный уровень маны: " + res + ANSI_RESET);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        case "getCurrentManaPoint" -> {
                            try {
                                Object res = method.invoke(object);
                                System.out.println(getColor((int)res) + "Текущий уровень маны: " + res + ANSI_RESET);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } // end switch
                }
            }
        } // end showIndicator
        private String getColor(int res){
            String color = ANSI_GREEN;
            if (res < 75) color = ANSI_YELLOW;
            if (res < 50) color = ANSI_PURPLE;
            if (res < 25) color = ANSI_RED;
            return color;
        }

    } // End class Render

    static class Building implements HealthImpl {
        private final int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья
        public Building(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }
        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }

        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
    } // End class Building

    static class Hero implements HealthImpl, ManaImpl {
        private final int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья
        private final int maxManaPoint; // максимально количество магический энергии
        private int currentManaPoint; // текущее количество магический энергии
        public Hero(int maxHealthPoint, int maxManaPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.maxManaPoint = maxManaPoint;

            this.currentHealthPoint = maxHealthPoint;
            this.currentManaPoint = maxManaPoint;
        }
        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }
        public void setCurrentManaPoint(int currentManaPoint) {
            this.currentManaPoint = currentManaPoint;
        }

        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }
        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
        @Override
        public int getCurrentManaPoint() {
            return currentManaPoint;
        }
        @Override
        public int getMaxManaPoint() {
            return maxManaPoint;
        }
    } // End class Hero

    static class Neutral implements HealthImpl {
        private final int maxHealthPoint; // максимально количество здоровья
        private int currentHealthPoint; // текущее количество здоровья
        public Neutral(int maxHealthPoint) {
            this.maxHealthPoint = maxHealthPoint;
            this.currentHealthPoint = maxHealthPoint;
        }
        public void setCurrentHealthPoint(int currentHealthPoint) {
            this.currentHealthPoint = currentHealthPoint;
        }
        @Override
        public int getCurrentHealthPoint() {
            return currentHealthPoint;
        }
        @Override
        public int getMaxHealthPoint() {
            return maxHealthPoint;
        }
    } // End class Neutral
}
