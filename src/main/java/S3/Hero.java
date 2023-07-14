package S3;

public class Hero extends Substance implements Health, Mana {
    private int id;

    private int maxHealthPoint; // максимально количество здоровья
    private int currentHealthPoint; // текущее количество здоровья

    private int maxManaPoint; // максимально количество магический энергии
    private int currentManaPoint; // текущее количество магический энергии

    public Hero(int maxHealthPoint, int maxManaPoint, int id) {
        this.id = id;
        this.maxHealthPoint = maxHealthPoint;
        this.maxManaPoint = maxManaPoint;

        this.currentHealthPoint = maxHealthPoint;
        this.currentManaPoint = maxManaPoint;
    }

    public Hero(int maxHealthPoint, int maxManaPoint) {
        this(maxHealthPoint, maxManaPoint, nextId++);

    }

    public int getId() {
        return id;
    }

    @Override
    public int getCurrentHealth() {
        return this.currentHealthPoint;
    }

    @Override
    public void setCurrentHealth(int healthPoint) {
        this.currentHealthPoint = healthPoint;
    }

    @Override
    public int getMaxHealth() {
        return this.maxHealthPoint;
    }

    @Override
    public int getCurrentMana() {
        return this.currentManaPoint;
    }

    @Override
    public void setCurrentMana(int manaPoint) {
        this.currentManaPoint = manaPoint;
    }

    @Override
    public int getMaxMana() {
        return this.maxManaPoint;
    }
}
