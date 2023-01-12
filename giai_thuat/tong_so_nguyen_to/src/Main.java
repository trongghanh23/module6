import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        System.out.print("Nhập số lượng số nguyên tố cần tính");
        int number = scanner.nextInt();
        int count = 0;
        int prime = 2;
        boolean check;

        while (count < number) {
            check = true;
            for (int i = 2; i <= Math.sqrt(prime); i++) {
                if (prime % i == 0) {
                    check = false;
                    break;
                }
            }

            if (check) {
                total += prime;
                count++;
            }

            prime++;
        }
    }
}