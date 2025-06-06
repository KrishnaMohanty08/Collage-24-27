import java.util.*;
public class d21_q2{
  public static int[] deckRevealedIncreasing(int[] deck){
    Arrays.sort(deck);
    int n = deck.length;
    Deque<Integer> indexQueue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
        indexQueue.add(i);
    }
    int[] result = new int[n];
    for (int card :deck) {
        int index = indexQueue.pollFirst();
        result[index] = card;
        if (!indexQueue.isEmpty()) {
           indexQueue.addLast(indexQueue.pollFirst());
        }
    }
    return result;
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n =sc.nextInt();
    int[] deck = new int[n];
    for (int i = 0; i < n; i++) {
      deck[i] = sc.nextInt();
    }
    int[] initialOrder = deckRevealedIncreasing(deck);
      System.out.println(Arrays.toString(initialOrder));
  }
}
    