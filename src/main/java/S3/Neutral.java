package S3;

public class Neutral extends Substance implements Health {
    private int id;

    private int maxHealthPoint; // максимально количество здоровья
    private int currentHealthPoint; // текущее количество здоровья

    public Neutral(int maxHealthPoint, int id) {
        this.id = id;
        this.maxHealthPoint = maxHealthPoint;
        this.currentHealthPoint = maxHealthPoint;
    }

    public Neutral(int maxHealthPoint) {
        this(maxHealthPoint, nextId++);
    }

    public void setCurrentHealthPoint(int currentHealthPoint) {
        this.currentHealthPoint = currentHealthPoint;
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

}
