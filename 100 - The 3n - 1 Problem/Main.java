import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by armkillbill on 4/1/2017.
 */
class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Main m = new Main();
        m.run();
    }

    private void run() throws FileNotFoundException {
        System.setIn(new FileInputStream("input.txt"));
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            int num1 = in.nextInt();
            int num2 = in.nextInt();
            int a, b;
            int maxSeq = 0;

            if (num1 > num2) {
                a = num2;
                b = num1;
            } else {
                a = num1;
                b = num2;
            }

            for (int i = a; i <= b; i++) {
                int nSeq = getSeqLen(i);
                if (nSeq > maxSeq) {
                    maxSeq = nSeq;
                }
            }

            System.out.println(num1 + " " + num2 + " " + maxSeq);
        }
    }

    private int getSeqLen(int num) {
        int count = 1;

        while (num != 1) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num = (num * 3) + 1;
            }
            count++;
        }

        return count;
    }
}
