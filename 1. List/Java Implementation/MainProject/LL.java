package MainProject;
public class LL <T> implements List <T>{

    private LinkNode<T> head;
    private LinkNode<T> tail;
    private LinkNode<T> current;
    private int listSize;

    //constructors

    LL (int unusedSize) {
        this();
    }
    LL(){
        head=tail=current=new LinkNode<T>(null); // creating header node
        listSize=0;
    }
    public LL(int size, T[] givenList) {
        head = tail = current = new LinkNode<>(null); // header node
        for (int i = 0; i < size; i++) {
            LinkNode<T> tempnode = new LinkNode<>(givenList[i], null);
            tail.setNextNode(tempnode);
            tail = tempnode;
            listSize++;
        }
    }


    @Override
    public void clear() {
        head.setNextNode(null);
        current=tail=head= new LinkNode<T>(null);
        listSize=0;
    }

    @Override
    public void insert(T item) {
        current.setNextNode(new LinkNode<T>(item, current.getNextNode())); // 1. creating a new node
                                                                        // 2. setting the address of current node to the new node
                                                                        // 3. current k new node e point koraye dilam
                                                                        // ekhon new node tai current node
        if(tail== current) tail = current.getNextNode();
        listSize++;
    }

    @Override
    public void append(T element) {
        tail.setNextNode(new LinkNode<T>(element,null));  // new node create korlam , tail jake point kore mane last node
        // take notun node e point koraye dichchi
        tail= tail.getNextNode();
        this.listSize++;
    }

    @Override
    public T remove() {
        if(current.getNextNode()== null) return null;
        T item = current.getNextNode().getValue(); // current node er value
        if(tail == current.getNextNode()) tail=current;

        current.setNextNode(current.getNextNode().getNextNode()); // current jake ekhon point kortese tar poroborti node k point koraye dilam
        listSize--;
        return item;
    }

    @Override
    public void moveToStart() {
        current= head;
    }

    @Override
    public void moveToEnd() {
        LinkNode<T> temp = head;

        // traverse kore tail er ager node k khuje ber korte hobe , cause current er uchit hobe last node er ager node k point kora
        while (temp.getNextNode()!=tail){
            temp= temp.getNextNode();
        }
        current= temp; // temp e tail er ager node er address ache ekhon
    }

    @Override
    public void prev() {
        if(current==head) return;
        LinkNode<T> temp;
        for(temp = head; temp.getNextNode()!= current; temp= temp.getNextNode());

        current= temp;
    }

    @Override
    public void next() {
      //  if(current!=tail) current= current.getNextNode();
        if(current.getNextNode().getNextNode()== null) return;  // last node k point korle shorabo na
        current= current.getNextNode();
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        LinkNode<T> temp= head ;
        int count ;
        for(count=0 ; temp!= current; count++ ){
            temp= temp.getNextNode();
        }
       //  System.out.println(count);
       // System.out.println("Going to main function");
        return count;
    }

    @Override
    public void moveToPos(int position) {
        if(position>=0 && position<=listSize){
            current= head;
            for(int i=0; i<position;i++){
                current= current.getNextNode();
            }
        }
        else {
            System.out.println("Position is not in the range");
        }
    }

    @Override
    public T getValue() {
        if(current.getNextNode()== null) return null;
        return current.getNextNode().getValue();
    }

    @Override
    public int Search(T item) {
        LinkNode<T> temp= head;
        int i=0;
        while (temp!= null){

            if(temp.getValue()==item){
                i= i-1;
                return i;
            }
            i++;
            temp= temp.getNextNode();
        }
        return -1;
    }

}
