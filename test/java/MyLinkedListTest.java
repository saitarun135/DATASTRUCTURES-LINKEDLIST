import org.junit.jupiter.api.Assertions;
import org.junit.Test;

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

}
