import java.util.Arrays;

public class BinaryHeap {

  public Integer[] arr;
  private int size;

  public BinaryHeap() {
    arr = new Integer[10];
    size = 0;
  }

  public void add(int val) {
    // Grows array
    if (size >= arr.length) {
      arr = Arrays.copyOf(arr, arr.length * 2);
    }

    arr[size++] = val;

    int current = size - 1;
    int parent = (current - 1) / 2;

    // (parent >= 0 && parent < current) && 
    while ((arr[current] < arr[parent])) {
      swap(current, parent);
      current = parent;
      parent = (current - 1) / 2;
    }
  }

  public int remove() {
    assert size > 0;

    swap(0, size - 1);
    size--;

    if (size != 0) {
      shiftDown(0);
    }

    return arr[size];
  }

  private void shiftDown(int pos) {
    int smallestChild;

    while (!isLeaf(pos)) {
      smallestChild = pos * 2 + 1;// leftChild(pos);

      if ((smallestChild + 1 < size) && (arr[smallestChild] > arr[smallestChild + 1])) {
        smallestChild = smallestChild + 1;
      }

      if (arr[pos] <= arr[smallestChild]) {
        return;
      }

      swap(pos, smallestChild);
      pos = smallestChild;
    }
  }

  private boolean isLeaf(int pos) {
    return ((pos >= (size / 2)) && (pos <= size));
  }

  private void swap(int val_1, int val_2) {
    int temp = arr[val_1];
    arr[val_1] = arr[val_2];
    arr[val_2] = temp;
  }
}
