public class ImABarbieGirl {
  public static boolean isUnique(ArrayStack in) {
    ArrayStack tempUnique = new ArrayStack(in.size());
    ArrayStack temp = new ArrayStack(in.size());
    boolean isUnique = true;
  
    while (!in.isEmpty() && isUnique) {
      tempUnique.push(in.pop());
  
      while (!in.isEmpty() && isUnique) {
        if (tempUnique.top() == in.top()) {
          isUnique = false;
        } else {
          temp.push(in.pop());
        }
      }
  
      while (!temp.isEmpty()) {
        in.push(temp.pop());
      }
    }
  
    while (!tempUnique.isEmpty()) {
      in.push(tempUnique.pop());
    }
  
    return isUnique;
  }
  
  public static void main(String[] args) {
    ArrayStack s1 = new ArrayStack(14);
    s1.push(3);
    s1.push(8);
    s1.push(12);
    s1.push(2);
    s1.push(9);
    s1.push(17);
    s1.push(43);
    s1.push(-8);
    s1.push(46);
    s1.push(203);
    s1.push(14);
    s1.push(97);
    s1.push(10);
    s1.push(4);
  
    System.out.println("s1 is unique: " + isUnique(s1)); // Should return true
  
    ArrayStack s2 = new ArrayStack(11);
    s2.push(4);
    s2.push(7);
    s2.push(2);
    s2.push(3);
    s2.push(9);
    s2.push(12);
    s2.push(-47);
    s2.push(-19);
    s2.push(308);
    s2.push(3);
    s2.push(74);
  
    System.out.println("s2 is unique: " + isUnique(s2)); // Should return false
  }  
}
