public class MyLinkedList {

    public INode head;
    public INode tail;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(INode newNode) {
        if (this.tail == null) {
            this.tail = newNode;
        }
        if (this.head == null) {
            this.head = newNode;
        } else {
            INode tempNode = this.head;
            this.head = newNode;
            this.head.setNext(tempNode);
        }
    }
    public void append(INode myNode) {
        if (this.head == null) {
            this.head = myNode;
        }
        if (this.tail == null) {
            this.tail = myNode;
        } else {
            this.tail.setNext(myNode);
            this.tail = myNode;
        }
    }
    public void insert(INode myNode,INode newNode){    //(firstNode,SecondNode)
        INode tempNode = myNode.getNext();
        myNode.setNext(newNode);                    //creating and interchanging
        newNode.setNext(tempNode);

    }
    public INode popFirst(){
        INode tempNode=this.head;
        this.head=this.head.getNext();
        return tempNode;
    }
    public INode popLast(){
        INode tempNode = head;
        while (tempNode.getNext()!=((tail))){
            tempNode = tempNode.getNext();
        }
        this.tail = tempNode;
        tempNode = tempNode.getNext();
       return tempNode ;
    }
    public boolean searchElement(INode searchNode){
        INode tempNode = this.head;
        while (tempNode != null){
            if (tempNode.getKey().equals(searchNode.getKey())){
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }
    //search the element and inserting .
    public boolean searchAndInsertElement(INode searchNode, INode insertNode){
        INode tempNode = this.head;
        while (tempNode != null){
            if (tempNode.getKey().equals(searchNode.getKey())){
                insert(tempNode, insertNode);                  //calling method for inserting
                return true;
            }
            tempNode = tempNode.getNext();
        }
        return false;
    }
    public Integer size(){
        Integer size = 0;
        INode tempNode = this.head;
        while(tempNode != null){
            size++;
            tempNode = tempNode.getNext();
        }
        return size;
    }
    public void searchAndDelete(INode searchNode) {
        if (searchElement(searchNode)){
            System.out.println("Linked List size before deleting element : "+size());
            INode nextNode = searchNode.getNext();
            INode tempNode = nextNode.getNext();
            if (nextNode != tail){
                searchNode.setNext(tempNode);
                System.out.println("Linked List size after deleting element : "+size());
            }
        }
    }


    public  void show() {
    	INode node=head;
    	while(node.getNext()!=null) {
    		System.out.println(node.getKey());
    		node=node.getNext();
    	}
    	System.out.println(node.getKey());
    }
}
