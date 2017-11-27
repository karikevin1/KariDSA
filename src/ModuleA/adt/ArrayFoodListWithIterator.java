/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;
import ModuleA.adt.FoodListWithIteratorInterface;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 *
 * @author User
 */
public class ArrayFoodListWithIterator<T> implements FoodListWithIteratorInterface<T> {
  private T[] list; // array of list entries
  private int numberOfEntries;
  private static final int DEFAULT_INITIAL_CAPACITY = 25;

  public ArrayFoodListWithIterator() {
    this(DEFAULT_INITIAL_CAPACITY);
  } // end default constructor

  public ArrayFoodListWithIterator(int initialCapacity) {
    numberOfEntries = 0;
    // the cast is safe because the new array contains null entries
    @SuppressWarnings("unchecked")
    T[] tempList = (T[]) new Object[initialCapacity];
    list = tempList;
  } // end constructor

  public Iterator<T> getIterator() {
    return new IteratorForArrayList();
  } // end getIterator

  public boolean addFood(T newEntry) {
    if (isArrayFull()) {
      doubleArray();
    }

    list[numberOfEntries] = newEntry;
    numberOfEntries++;
    return true;
  }

  public boolean addFood(int newPosition, T newEntry) {
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      if (isArrayFull()) {
        doubleArray();
      }

      makeRoom(newPosition);
      list[newPosition - 1] = newEntry;
      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
  }
   public boolean addOutletRest(T newEntry){
    if (isArrayFull()) {
      doubleArray();
    }

    list[numberOfEntries] = newEntry;
    numberOfEntries++;
    return true;
   }
   public boolean addOutletRest(int newPosition, T newEntry){
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      if (isArrayFull()) {
        doubleArray();
      }

      makeRoom(newPosition);
      list[newPosition - 1] = newEntry;
      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
   }
   public boolean addFoodPrice(T newEntry){
    if (isArrayFull()) {
      doubleArray();
    }

    list[numberOfEntries] = newEntry;
    numberOfEntries++;
    return true;
   }
   public boolean addFoodPrice(int newPosition, T newEntry){
    boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      if (isArrayFull()) {
        doubleArray();
      }

      makeRoom(newPosition);
      list[newPosition - 1] = newEntry;
      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
   }
   public boolean addFoodDesc(T newEntry){
        if (isArrayFull()) {
      doubleArray();
    }

    list[numberOfEntries] = newEntry;
    numberOfEntries++;
    return true;
   }
   public boolean addFoodDesc(int newPosition, T newEntry){
         boolean isSuccessful = true;

    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
      if (isArrayFull()) {
        doubleArray();
      }

      makeRoom(newPosition);
      list[newPosition - 1] = newEntry;
      numberOfEntries++;
    } else {
      isSuccessful = false;
    }

    return isSuccessful;
   }



  public void clear() {
    numberOfEntries = 0;
  }


  public T getEntry(int givenPosition) {
    T result = null;

    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
      result = list[givenPosition - 1];
    }

    return result;
  }

  public boolean contains(T anEntry) {
    boolean found = false;
    for (int index = 0; !found && (index < numberOfEntries); index++) {
      if (anEntry.equals(list[index])) {
        found = true;
      }
    }

    return found;
  }

  public int getNumberOfEntries() {
    return numberOfEntries;
  }

  public boolean isEmpty() {
    return numberOfEntries == 0;
  }

  public boolean isFull() {
    return false;
  }

  public String toString() {
    String outputStr = "";
    for (int index = 0; index < numberOfEntries; ++index) {
      outputStr += list[index] + "\n";
    }

    return outputStr;
  }

  private boolean isArrayFull() {
    return numberOfEntries == list.length;
  }

  /**
   * Task: Doubles the size of the array of list entries.
   */
  private void doubleArray() {
    T[] oldList = list; // save reference to array of list entries
    int oldSize = oldList.length;     // save old max size of array

    list = (T[]) new Object[2 * oldSize];    // double size of array

    // copy entries from old array to new, bigger array
    for (int index = 0; index < oldSize; index++) {
      list[index] = oldList[index];
    }
  } // end doubleArray

  /**
   * Task: Makes room for a new entry at newPosition. Precondition: 1 <=
   * newPosition <= numberOfEntries + 1; numberOfEntries is list's
   * numberOfEntries before addition.
   */
  private void makeRoom(int newPosition) {
    int newIndex = newPosition - 1;
    int lastIndex = numberOfEntries - 1;

    // move each entry to next higher index, starting at end of
    // list and continuing until the entry at newIndex is moved
    for (int index = lastIndex; index >= newIndex; index--) {
      list[index + 1] = list[index];
    }
  }

  /**
   * Task: Shifts entries that are beyond the entry to be removed to the next
   * lower position. Precondition: list is not empty; 1 <= givenPosition <
   * numberOfEntries; numberOfEntries is list's numberOfEntries before removal.
   */
  private void removeGap(int givenPosition) {
    // move each entry to next lower position starting at entry after the
    // one removed and continuing until end of list
    int removedIndex = givenPosition - 1;
    int lastIndex = numberOfEntries - 1;

    for (int index = removedIndex; index < lastIndex; index++) {
      list[index] = list[index + 1];
    }
  }

  //  < Segment 15.25 begins a description of the following inner class. >
  private class IteratorForArrayList implements Iterator<T> {

    private int nextIndex;
    private boolean wasNextCalled; // needed by remove

    private IteratorForArrayList() {
      nextIndex = 0;
      wasNextCalled = false;
    } // end default constructor

    //    < Implementations of the methods in the interface Iterator go here;
    //      you can see them in Segments 15.26 through 15.28. >
    //    . . .
    @Override
    public boolean hasNext() {
      return nextIndex < numberOfEntries;
    }

    @Override
    public T next() {
      if (hasNext()) {
        wasNextCalled = true;
        T nextEntry = list[nextIndex];
        nextIndex++; // advance iterator

        return nextEntry;
      } else {
        throw new NoSuchElementException("Illegal call to next();"
                + "iterator is after end of list.");
      }
    }

  } // end IteratorForArrayList
}
