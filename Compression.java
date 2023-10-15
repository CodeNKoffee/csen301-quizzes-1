public class Compression {
  public static void compress(ArrayStack in) {
    ArrayStack compressed = new ArrayStack(in.size());
    ArrayStack temp = new ArrayStack(in.size());
    boolean found = false;

    while (!in.isEmpty()) {
      if (compressed.isEmpty()) {
        compressed.push(in.pop());
      } else {
        while (!compressed.isEmpty() && !found) {
          if (compressed.top() == in.top()) {
            found = true;
          } else {
            temp.push(compressed.pop());
          }
        }
        while (!temp.isEmpty()) {
          compressed.push(temp.pop());
        }
        if (!found) {
          compressed.push(in.pop());
        } else {
          in.pop();
        }
        found = false;
      }
    }

    while (!compressed.isEmpty()) {
      in.push(compressed.pop());
    }
  }

  public static void main(String[] args) {
    ArrayStack s1 = new ArrayStack(6);
    s1.push(5);
    s1.push(2);
    s1.push(5);
    s1.push(3);
    s1.push(2);
    s1.push(5);

    System.out.println("Before compressing s1: ");
    s1.printStack(); // Original stack
    compress(s1);

    System.out.println("After compressing s1: ");
    s1.printStack(); // Compressed stack

    ArrayStack s2 = new ArrayStack(6);
    s2.push(-2);
    s2.push(-12);
    s2.push(8);
    s2.push(8);
    s2.push(2);
    s2.push(12);

    System.out.println("Before compressing s2: ");
    s2.printStack(); // Original stack
    compress(s2);

    System.out.println("After compressing s2: ");
    s2.printStack(); // Compressed stack
  }
}
