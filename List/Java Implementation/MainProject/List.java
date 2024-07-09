package MainProject;
public interface List <T> {
    public void  clear();
    public void insert(T element);
    public void append (T element);
    public T remove();
    public void moveToStart();
    public void moveToEnd();
    public void prev();
    public void next();
    public int length();
    public int currPos();
    public void moveToPos(int position);
    public T getValue();
    public int Search(T item);
}
