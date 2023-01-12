import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhâp số cần chuyển");
        int number = scanner.nextInt();
        int count = 0;
        int octNumber = 0;
        while (number > 0) {
            octNumber += (number % 8) * Math.pow(10, count);
            count++;
            number /= 8;
        }
        System.out.printf("số chuyển đổi là"+ octNumber);

    }

}
