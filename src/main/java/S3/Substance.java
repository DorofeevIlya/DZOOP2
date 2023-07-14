package S3;
public abstract class Substance {
    private int id;

    public int getId() {
        return id;
    }

    protected static int nextId = 1;
}