/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author User
 */
public class FoodListWithIterator<T> implements FoodListWithIteratorInterface<T> {
 private Node firstNode;
 private Node secondNode;
 private Node thirdNode;
 private Node fourthNode;
 private int numberOfEntries;

  public FoodListWithIterator() {
    clear();
  }


  public final void clear() {
    firstNode = null;    
    secondNode = null;
    thirdNode = null;
    fourthNode = null;
    numberOfEntries = 0;
  }


  public boolean addFood(T newEntry) {
    Node newNode = new Node(newEntry);

    if (isEmpty()) {
      firstNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = firstNode;					// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    numberOfEntries++;
    return true;
  }


  public boolean addFood(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.next = firstNode;
        firstNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = firstNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }

        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next = newNode;		// make the node before point to the new node
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }

  public boolean addOutletRest(T newEntry){
    Node newNode = new Node(newEntry);

    if (isEmpty()) {
      secondNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = secondNode;					// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    numberOfEntries++;
    return true;
  }
  public boolean addOutletRest(int newPosition, T newEntry){
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.next = secondNode;
        secondNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = secondNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }

        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next = newNode;		// make the node before point to the new node
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
  public boolean addFoodPrice(T newEntry){
    Node newNode = new Node(newEntry);

    if (isEmpty()) {
      thirdNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = thirdNode;					// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    numberOfEntries++;
    return true;
  }
  public boolean addFoodPrice(int newPosition, T newEntry){
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.next = thirdNode;
        thirdNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = thirdNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }

        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next = newNode;		// make the node before point to the new node
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
  public boolean addFoodDesc(T newEntry){
    Node newNode = new Node(newEntry);

    if (isEmpty()) {
      fourthNode = newNode;
    } else {                        // add to end of nonempty list
      Node currentNode = fourthNode;					// traverse linked list with p pointing to the current node
      while (currentNode.next != null) {		// while have not reached the last node
        currentNode = currentNode.next;
      }
      currentNode.next = newNode; // make last node reference new node
    }

    numberOfEntries++;
    return true; 
  }
  public boolean addFoodDesc(int newPosition, T newEntry){
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      Node newNode = new Node(newEntry);

      if (isEmpty() || (newPosition == 1)) {     // case 1: add to beginning of list
        newNode.next = fourthNode;
        fourthNode = newNode;
      } else {								                      // case 2: list is not empty and newPosition > 1
        Node nodeBefore = fourthNode;
        for (int i = 1; i < newPosition - 1; ++i) {
          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
        }

        newNode.next = nodeBefore.next;	// make new node point to current node at newPosition
        nodeBefore.next = newNode;		// make the node before point to the new node
      }

      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }



  public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;

    while (!found && (currentNode != null)) {
      if (anEntry.equals(currentNode.data)) {
        found = true;
      } else {
        currentNode = currentNode.next;
      }
    }

    return found;
  }


  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      Node currentNode = firstNode;
      for (int i = 0; i < givenPosition - 1; ++i) {
        currentNode = currentNode.next;		// advance currentNode to next node
      }
      result = currentNode.data;	// currentNode is pointing to the node at givenPosition
    }

    return result;
  }


  public int getNumberOfEntries() {
    return numberOfEntries;
  }
  


  @Override
  public boolean isEmpty() {
    boolean result;

    if (numberOfEntries == 0) {
      result = true;
    } else {
      result = false;
    }

    return result;
  }

  @Override
  public boolean isFull() {
    return false;
  }

  @Override
  public String toString() {
    String outputStr = "";
    Node currentNode = firstNode;
    while (currentNode != null) {
      outputStr += currentNode.data + "\n";
      currentNode = currentNode.next;
    }
    return outputStr;
  }

  @Override
  public Iterator<T> getIterator() {
    return new LinkedListIterator();
  }

  private class LinkedListIterator implements Iterator<T> {

    private Node currentNode;

    public LinkedListIterator() {
      currentNode = firstNode;
    }

    @Override
    public boolean hasNext() {
      return currentNode != null;
    }

    @Override
    public T next() {
      if (hasNext()) {
        T returnData = currentNode.data;
        currentNode = currentNode.next;
        return returnData;
      } else {
        throw new NoSuchElementException("Illegal call to next(); iterator is after end of list.");
      }
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  }

  private class Node {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data;
      this.next = null;
    }

    private Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }
  }
}
