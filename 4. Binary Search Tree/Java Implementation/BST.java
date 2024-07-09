public class BST implements BST_ADT {
    private LinkNode rootNode;

    public BST() {
        this.rootNode=null;
    }

    public BST(int data) {
        this.rootNode = new LinkNode(data);
        printBST(rootNode);
        System.out.println();
    }

    public LinkNode getRootNode() {
        return rootNode;
    }

    public void setRootNode(LinkNode rootNode) {
        this.rootNode = rootNode;
    }

    private LinkNode inserthelper(int data, LinkNode linkNode){
        if(linkNode==null){
            LinkNode tempNode= new LinkNode(data);
            return tempNode;
        }
        else if(data<=linkNode.getData()){
            linkNode.setLeftNode(inserthelper(data, linkNode.getLeftNode()));
        }
        else {
            linkNode.setRightNode(inserthelper(data, linkNode.getRightNode()));
        }
        return linkNode;
    }
    public void Insert(int data){
        inserthelper(data,rootNode);
        printBST(rootNode);
        System.out.println();
    }

    private int findMax(LinkNode node){
        if(node.getRightNode()==null){
            return node.getData();
        }
        return findMax(node.getRightNode());
    }

    private LinkNode deleteHelper(int data, LinkNode node){
        if(Find(data)==false) return null;
        if(data<node.getData()){
            node.setLeftNode(deleteHelper(data,node.getLeftNode()));
        }
        else if(data>node.getData()){
            node.setRightNode(deleteHelper(data,node.getRightNode()));

        }
        else if(data==node.getData()){
            if(node.getLeftNode()==null){
               if(node.getRightNode()==null){
                   node=null;
               }
               else{
                   node = node.getRightNode();
               }
           }
           else {
               if (node.getRightNode() == null) {
                   node = node.getLeftNode();
               } else {
                   int tempData = findMax(node.getLeftNode());
                   node.setData(tempData);
                   node.setLeftNode(deleteHelper(tempData, node.getLeftNode()));
               }

           }
        }

        return node;
    }

    public void Delete(int data){
        if(deleteHelper(data, rootNode)!=null) {
            printBST(rootNode);
            System.out.println();
        }
        else System.out.println("Invalid Operation");
    }

    private Boolean findHelper(int data, LinkNode node) {
        Boolean flag= false;
        if(node.getData()==data)
            flag=true;
        else if(data< node.getData() && node.getLeftNode()!=null ){
            flag=findHelper(data,node.getLeftNode());
        }
        else if(data> node.getData() && node.getRightNode()!=null ){
            flag=findHelper(data,node.getRightNode());
        }
        return flag;
    }

    public Boolean Find(int data) {
        return findHelper(data,rootNode);
    }

    // Traversals

    private void inOrderHelper(LinkNode node){
        if(node==null){
            return;
        }
        inOrderHelper(node.getLeftNode());
        System.out.print(node.getData()+ " ");
        inOrderHelper(node.getRightNode());
    }
    @Override
    public void InOrder() {
        inOrderHelper(rootNode);
        System.out.println();
    }

    private void postOrderHelper(LinkNode node){
        if(node==null){
            return;
        }
        postOrderHelper(node.getLeftNode());
        postOrderHelper(node.getRightNode());
        System.out.print(node.getData()+ " ");
    }

    @Override
    public void PostOrder() {
        postOrderHelper(rootNode);
        System.out.println();
    }

    private void preOrderHelper(LinkNode node) {
        if(node==null){
            return;
        }
        System.out.print(node.getData()+ " ");
        preOrderHelper(node.getLeftNode());
        preOrderHelper(node.getRightNode());
    }

    @Override
    public void PreOrder() {
        preOrderHelper(rootNode);
        System.out.println();
    }

    public void printBST(LinkNode node){
        if(node==null){
            return;
        }
        System.out.print(node.getData());
        if(node.getLeftNode()!=null || node.getRightNode()!=null){
            System.out.print("(");
            printBST(node.getLeftNode());
            System.out.print(")");
        }
        if(node.getLeftNode()!=null || node.getRightNode()!=null){
            System.out.print("(");
            printBST(node.getRightNode());
            System.out.print(")");
        }
    }
}
