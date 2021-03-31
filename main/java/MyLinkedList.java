// https://www.geeksforgeeks.org/how-to-sort-a-linkedlist-in-java/     -->InsertionOrder
import java.util.Comparator;

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
    /*
    // function to insert a new_node in a list. Note that
    // this function expects a pointer to head_ref as this
    // can modify the head of the input linked list
    // (similar to push())
    void sortedInsert(node newnode)
    {
        // Special case for the head end
        if (sorted == null || sorted.val >= newnode.val)
        {
            newnode.next = sorted;
            sorted = newnode;
        }
        else
        {
            node current = sorted;

            // Locate the node before the point of insertion
            while (current.next != null && current.next.val < newnode.val)
            {
                current = current.next;
            }

            newnode.next = current.next;
            current.next = newnode;
        }
    }

    */
    public void sortAndInsert(INode myNode){
        INode tempnode = head;
        INode prevNode = null;
        while (tempnode != null && (int) myNode.getKey() >= (int) tempnode.getKey()) {
            prevNode = tempnode;
            tempnode = tempnode.getNext();
        }
        if(prevNode == null)
            this.head = myNode;
        else
            prevNode.setNext(myNode);
        myNode.setNext(tempnode);
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
