public class HigherTemprature {
  public static void findHigherTemprature(ArrayStack x) {
    int size = x.size();
    ArrayStack reversedX = new ArrayStack(size);
    ArrayStack y = new ArrayStack(size);
    for (int i = 0; i < size; i++) {
      reversedX.push(x.pop());
    }
    System.out.println(reversedX.top());
  }

  public static void main(String[] args) {
    ArrayStack x = new ArrayStack(4);
    x.push(30);
    x.push(40);
    x.push(50);
    x.push(60);
    findHigherTemprature(x);
  }
}