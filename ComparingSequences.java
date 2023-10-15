public class ComparingSequences {
  public static boolean containsSequence(ArrayStack s1, ArrayStack s2) {
    int size = s2.size();
    int count = 0;
    ArrayStack dump = new ArrayStack(s1.size());
    ArrayStack tmp = new ArrayStack(size);
    while (!s2.isEmpty() && !s1.isEmpty()) {
      if (s1.top() != s2.top()) {
        if (count != 0) {
          for (int i = 0; i < count; i++) {
            s2.push(tmp.pop());
          }
          count = 0;
        }
        else dump.push(s1.pop());
      }
      else if (s1.top() == s2.top()) {
        dump.push(s1.pop());
        tmp.push(s2.pop());
        count++;
        if (count == size) {
          // -- DEBUGGING -- STARTS HERE --------------
          System.out.println("S1 before restoration:");
          s1.printStack();
          System.out.println("S2 before restoration:");
          s2.printStack();
          System.out.println("TMP for S2 before emptying:");
          tmp.printStack();
          System.out.println("DUMP for S1 before emptying:");
          dump.printStack();
          System.out.println(tmp.size() + " " + dump.size());
          // -- DEBUGGING -- ENDS HERE --------------
          int tmpSize = tmp.size();
          int dumpSize = dump.size();
          for (int i = 0; i < tmpSize; i++) {
            s2.push(tmp.pop());
            System.out.println("i: " + i); // ---------------- DEBUGGING ----------------
          }
          for (int j = 0; j < dumpSize; j++) {
            s1.push(dump.pop());
            System.out.println("j: " + j); // ---------------- DEBUGGING ----------------
          }
          System.out.println("After Restoration");
          s1.printStack();
          s2.printStack();
          return true;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    ArrayStack s1 = new ArrayStack(9);
    ArrayStack s2 = new ArrayStack(3);
    s1.push(1);
    s1.push(6);
    s1.push(2);
    s1.push(1);
    s1.push(4);
    s1.push(1);
    s1.push(2);
    s1.push(1);
    s1.push(9);
    s2.push(2);
    s2.push(1);
    s2.push(2);
    System.out.println(containsSequence(s1, s2));
  }
}
