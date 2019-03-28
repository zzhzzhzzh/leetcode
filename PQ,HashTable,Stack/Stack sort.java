class Solution {
  public Stack<Integer> sortStack(Stack<Integer> input) {
    Stack<Integer> tempStack = new Stack<>();
    while (!input.isEmpty()) {
      int temp = input.pop();
      while (!tempSatck.isEmpty() && temp > tempStack.peek()) {
        input.push(tempStack.pop());
      }
      tempStack.push(temp);
    }
    return tempStack;
  }

}
