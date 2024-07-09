package MainProject;
public class Arr<T> implements List <T> {
    private static final int defaultSize= 10;
    private int maxSize;
    private int listSize;
    private int currentPosition;
    private T[] Ara;
    private int chunkSize;

    //constructors
    //no parameter, initializing the maxSize with defaultsize
    // if user doesn't provide chunksize, an empty array will be created by allocating defaultsize memory
   public Arr() {
        maxSize= defaultSize;
        listSize =0;
        currentPosition = 0;
        Ara = (T[]) new Object[maxSize];
    }

    // taking chunksize as parameter
    // if user provide chunksize  an empty array will be created by allocating given chunksize memory
    public Arr(int chunksize){
        this.chunkSize = chunksize;
        listSize = 0 ;
        currentPosition = 0;
        maxSize = chunkSize;
        Ara = (T[]) new Object[maxSize];
    }

    //taking chunksize and given array size as parameter, as well as taking the array as the third parameter
    // an array of given arraysize will be initialized by allocating memory of given chunksize.
    public Arr(int chunksize, int arraysize, T[] givenList) {
        if(arraysize<=chunksize && arraysize>=0) {
            this.chunkSize = chunksize;
            maxSize = chunksize;
            listSize = arraysize;
            currentPosition = 0;
            Ara = (T[]) new Object[maxSize];
            for (int i = 0; i < arraysize; i++) {
                Ara[i] = givenList[i];
            }
        }
        else System.out.println("Invalid list size");
    }

    @Override
    public void clear() {
        listSize=0;
        currentPosition=0;
    }

    @Override
    public void insert(T element) {
        if(listSize==maxSize) { // if the array is already fulfilled
            maxSize += chunkSize; // increasing the size of the array by chunksize
            T[] temp = (T[]) new Object[maxSize]; // allocating increased size in a temporary array
            for (int i = 0; i < currentPosition; i++) { //
                temp[i] = Ara[i];
            }
            for (int i = listSize; i > currentPosition; i--) { // right shifing all the elements till currentposition
                temp[i] = Ara[i - 1];
            }
            temp[currentPosition] = element; // storing the inserted element to the current position
            Ara = temp;   // storing the temporary array to the main array
            listSize++;
        }
        else{
            for(int i= listSize; i>currentPosition; i--){
                Ara[i]=Ara[i-1];            // right shifing all the elements till currentposition
            }
            Ara[currentPosition]= element;  // inserting the inserted element to the current position
            listSize++;
        }
    }

    @Override
    public void append(T element) {
        if(listSize==maxSize){
            maxSize += chunkSize; // if the array is already full
            T[] temp = (T[]) new Object[maxSize];
            for (int i = 0; i < listSize; i++) {
                temp[i] = Ara[i];
            }
            temp[listSize] = element;
            listSize++;
            Ara = temp;
        }
        else{
            Ara[listSize]= element;
            listSize++;
        }
    }

    @Override
    public T remove() {
        if(currentPosition<0 || currentPosition>=listSize)
            return null;
        else{
            T temp= Ara[currentPosition];
            for(int i=currentPosition;i<listSize;i++){
                Ara[i]=Ara[i+1];
            }
            listSize--;
            return temp;
        }
    }

    @Override
    public void moveToStart() {
        currentPosition=0;
    }

    @Override
    public void moveToEnd() {
        currentPosition=listSize-1;
    }

    @Override
    public void prev() {
        if(currentPosition!=0)
           currentPosition--;
    }

    @Override
    public void next() {
        if(currentPosition <listSize-1){
            currentPosition++;
        }
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        return currentPosition;
    }

    @Override
    public void moveToPos(int position) {
        if(position<0 || position>=listSize)
            System.out.println("Invalid Position");
        else
            currentPosition= position;
    }

    @Override
    public T getValue() {
        if(currentPosition<0 || currentPosition>=listSize) {
            System.out.println("Invalid Position");
            return null;
        }
        else
            return Ara[currentPosition];
    }

    @Override
    public int Search(T item) {
        for(int i=0 ;i <listSize ; i++){
            if(Ara[i]==item) return i;
        }
        return -1;
    }
}
