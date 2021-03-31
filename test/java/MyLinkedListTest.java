import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.Test;

import java.util.stream.Stream;

public class MyLinkedListTest {
  // static  MyLinkedList myLinkedList = new MyLinkedList();
    @Test
    public void given3Numbers_WhenAddedToLinkedList_ShouldAddedToTop() {
        MyNode<Integer> myFirstNode = new MyNode<>(70);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(56);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.add(mySecondNode);
        myLinkedList.add(myThirdNode);
        System.out.println("The result after adding to the front:");
        myLinkedList.show();
        boolean result = 	myLinkedList.head.equals(myThirdNode) &&
        					myLinkedList.head.getNext().equals(mySecondNode) &&
        					myLinkedList.tail.equals(myFirstNode);
        Assertions.assertTrue(result);
    }

    @Test
    public void given3Numbers_whenAddedToLinkedList_ShouldAddedToBottom(){
        MyNode<Integer> myFirstNode=new MyNode<>(56);
        MyNode<Integer> mySecondNode=new MyNode<>(30);
        MyNode<Integer> myThirdNode=new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);
        System.out.println("The results after appending:-");
        myLinkedList.show();
        boolean result= myLinkedList.head.equals(myFirstNode) &&
                        myLinkedList.head.getNext().equals(mySecondNode)&&
                        myLinkedList.tail.equals(myThirdNode);
        Assertions.assertTrue(result);

    }
    @Test
    public void given3Numbers_WhenInsertingSecondInBetween_ShouldPassLinkedListTest() {
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode, mySecondNode);     //inserting in between
        System.out.println("The result after inserting:");
        myLinkedList.show();
        boolean result = myLinkedList.head.equals(myFirstNode) &&
                myLinkedList.head.getNext().equals(mySecondNode) &&
                myLinkedList.tail.equals(myThirdNode);
        Assertions.assertTrue(result);
    }
    @Test
    public void  givenFirstElement_WhenDeleted_ShouldPassLinkedListTest() {
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode, mySecondNode);
        myLinkedList.popFirst();                                                            //deleting size
        System.out.println("The deleted element is :"+myFirstNode.getKey());
        myLinkedList.show();
        boolean result = myLinkedList.head.equals(mySecondNode) &&
                          myLinkedList.tail.equals(myThirdNode);
        Assertions.assertTrue(result);

    }
    @Test
    public void givenLastElement_WhenDeleted_ShouldPassLinkedListTest() {
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode, mySecondNode);
        myLinkedList.popLast();
        System.out.println("The deleted element is :" +myThirdNode.getKey());
        myLinkedList.show();
        boolean result =    myLinkedList.head.equals(myFirstNode) &&
                            myLinkedList.tail.equals(mySecondNode);
        Assertions.assertTrue(result);
    }
    @Test
    public void givenElement_WhenSearch_ShouldPassTest() {
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);

        MyLinkedList myLinkedList = new MyLinkedList();

        myLinkedList.append(myFirstNode);
        myLinkedList.append(mySecondNode);
        myLinkedList.append(myThirdNode);

        myLinkedList.show();
        System.out.println("The searching element[True-present;False-absent] "+myLinkedList.searchElement(myThirdNode));
        boolean result = myLinkedList.searchElement(myThirdNode);
        Assertions.assertTrue(result);
    }
    @Test
    public void givenElements_SearchFirstNodeAndInsertSecondNode_ShouldPassTest() {
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);
        MyNode<Integer> myFourthNode = new MyNode<>(40);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode, mySecondNode);
        System.out.println("Before search and inserting operation:\t");
        myLinkedList.show();

        boolean result = myLinkedList.searchAndInsertElement(mySecondNode, myFourthNode);

        System.out.println("\n After Search and inserting operation:");
        myLinkedList.show();
        Assertions.assertTrue(result);
    }
    @Test
    public void givenElements_SearchAndDelete_ShouldReturnSize() {
        MyNode<Integer> myFirstNode = new MyNode<>(56);
        MyNode<Integer> mySecondNode = new MyNode<>(30);
        MyNode<Integer> myThirdNode = new MyNode<>(70);
        MyNode<Integer> myFourthNode = new MyNode<>(40);
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode, mySecondNode);
        myLinkedList.insert(mySecondNode, myFourthNode);
        System.out.println("Before deleting:");
        myLinkedList.show();
        myLinkedList.searchAndDelete(mySecondNode);
        System.out.println("After deleting");
        myLinkedList.show();
        Integer result = myLinkedList.size();
        Assertions.assertEquals(3, result);
    }

    @Test
    public void givenElements_SortAndInsert_ShouldReturnAscendingOrder(){
        MyNode<Integer> myFirstNode=new MyNode<>(56);
        MyNode<Integer> mySecondNode=new MyNode<>(30);
        MyNode<Integer> myThirdNode=new MyNode<>(70);
        MyNode<Integer> myFourthNode=new MyNode<>(40);
        MyLinkedList myLinkedList=new MyLinkedList();
        myLinkedList.add(myFirstNode);
        myLinkedList.append(myThirdNode);
        myLinkedList.insert(myFirstNode, mySecondNode);
        myLinkedList.insert(mySecondNode, myFourthNode);
        System.out.println("Before sorting the linkedList");
        myLinkedList.show();
        myLinkedList.sortAndInsert(myFirstNode);
        myLinkedList.sortAndInsert(mySecondNode);
        myLinkedList.sortAndInsert(myThirdNode);
        myLinkedList.sortAndInsert(myFourthNode);
        System.out.println("After sorting the elements are stored in ascending order");
        myLinkedList.show();
    }

}


