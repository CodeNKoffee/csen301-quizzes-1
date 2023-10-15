public class ComparingSequences {
  public static boolean containsSequence(ArrayStack s1, ArrayStack s2) {
    int size = s2.size();
    int count = 0;
    ArrayStack tmp = new ArrayStack(size);
    while (!s2.isEmpty() && !s1.isEmpty()) {
      if (s1.top() != s2.top()) {
        if (count != 0) {
          for (int i = 0; i < count; i++) {
            s2.push(tmp.pop());
          }
          count = 0;
        }
        else s1.pop();
      }
      else if (s1.top() == s2.top()) {
        s1.pop();
        tmp.push(s2.pop());
        count++;
        if (count == size) {
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
    s2.push(1);
    s2.push(2);
    s2.push(1);
    System.out.println(containsSequence(s1, s2));
  }
}
