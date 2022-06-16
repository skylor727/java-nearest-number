import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String arrayNumbers = sc.nextLine();
        int[] numArr = Arrays.stream(arrayNumbers.split(" ")).mapToInt(Integer::parseInt).toArray();
        int numToCompare = sc.nextInt();
        ArrayList<Integer> distances = new ArrayList<>();

        for (int i = 0; i < numArr.length; i++) {
            int n1 = numArr[i];
            int distance = n1 - numToCompare;
            distance = distance < 0 ? distance * -1 : distance;
            distances.add(distance);
        }

        int smallestNum = distances.get(0);
        for (int i = 0; i < distances.size(); i++) {
            int currentNum = distances.get(i);
            if (currentNum < smallestNum) smallestNum = currentNum;
        }
        ArrayList<Integer> indexesOfShortestDistances = indexesOf(distances, smallestNum);
        ArrayList<Integer> closestNums = new ArrayList<>();
        for (int i = 0; i < indexesOfShortestDistances.size(); i++) {
            int currNum = indexesOfShortestDistances.get(i);
            closestNums.add(numArr[currNum]);
        }
        Collections.sort(closestNums);
        for (int num : closestNums) {
            System.out.print(num + " ");
        }
    }

    public static ArrayList indexesOf(ArrayList<Integer> nums, int valueToSearchFor) {
        ArrayList<Integer> matches = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int currentNum = nums.get(i);
            if (currentNum == valueToSearchFor) matches.add(i);
        }
        return matches;
    }
}