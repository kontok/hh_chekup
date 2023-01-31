import java.util.Scanner;
public class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String dates = in.nextLine();
        String[] arrayDates = dates.split(" ");
        int n = Integer.parseInt(arrayDates[0]), m = Integer.parseInt(arrayDates[1]), s = Integer.parseInt(arrayDates[2]);
        int maxCount = Math.max(n, m);
        int userCount, userCountA = 0, userCountB = 0;
        String[] a = new String[maxCount];
        String[] b = new String[maxCount];
        int resultA = s, resultB = s, sumA = 0;
        for (int i = 0; i < maxCount; i++) {
            String str = in.nextLine();
            String[] numbers = str.split(" ");
            a[i] = numbers[0];
            b[i] = numbers[1];
            if ((!a[i].equals("-")) && (Integer.parseInt(a[i]) <= resultA) && userCountA == i) {
                userCountA += 1;
                resultA -= Integer.parseInt(a[i]);
                sumA += Integer.parseInt(a[i]);
            }
            if ((!b[i].equals("-")) && (Integer.parseInt(b[i]) <= resultB) && userCountB == i) {
                userCountB += 1;
                resultB -= Integer.parseInt(b[i]);
            }
        }
        userCount = Math.max(userCountA, userCountB);
        for (int i = userCountA - 1; i >= 0 ; i--){
            if (i != userCountA - 1) sumA -= Integer.parseInt(a[i + 1]);
            int result = s - sumA;
            int steps = i + 1, y = 0;
            while (y < userCountB && result >= Integer.parseInt(b[y])){
                result -= Integer.parseInt(b[y]);
                steps += 1;
                y += 1;
            }
            userCount = Math.max(userCount, steps);
        }
        System.out.println(userCount);
    }
  }