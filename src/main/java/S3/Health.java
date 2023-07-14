package S3;

public interface Health {
    public int getCurrentHealth();
    public void setCurrentHealth(int healthPoint);

    int getMaxHealth();
}
