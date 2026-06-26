import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        int target = in.nextInt();

        int i = 0;
        int j = arr.length - 1;

        while (i < j) {
            if (arr[i] + arr[j] == target) {
                System.out.println((i + 1) + " " + (j + 1));
                break;
            } else if (arr[i] + arr[j] > target) {
                j--;
            } else {
                i++;
            }
        }
    }
}
