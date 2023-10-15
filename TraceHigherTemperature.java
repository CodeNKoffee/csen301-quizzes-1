import java.util.Arrays;

public class TraceHigherTemperature {
  public static int[] findHigherTemperature(int[] temperatures) {
    int[] result = new int[temperatures.length];
    ArrayStack stack = new ArrayStack(temperatures.length);

    for (int i = 0; i < temperatures.length; i++) {
      while (!stack.isEmpty() && temperatures[i] > temperatures[stack.top()]) {
        int previousDay = stack.pop();
        result[previousDay] = i - previousDay;
        // Trace statement to show what's happening
        System.out.println("Comparing day " + i + " (" + temperatures[i] + "°C) to day " + previousDay + " (" + temperatures[previousDay] + "°C). You waited " + (i - previousDay) + " days.");
      }
      stack.push(i);
    }

    while (!stack.isEmpty()) {
      result[stack.pop()] = 0;
    }

    return result;
  }

  public static void main(String[] args) {
    int[] temperatures1 = {30, 40, 50, 60};
    int[] result1 = findHigherTemperature(temperatures1);
    System.out.println(Arrays.toString(result1)); // Output: [1, 1, 1, 0]

    int[] temperatures2 = {73, 74, 75, 71, 69, 72, 76, 73};
    int[] result2 = findHigherTemperature(temperatures2);
    System.out.println(Arrays.toString(result2)); // Output: [1, 1, 4, 2, 1, 1, 0, 0]
  }
}

