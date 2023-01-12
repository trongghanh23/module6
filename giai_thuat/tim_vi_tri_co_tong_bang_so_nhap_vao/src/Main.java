import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Nhập vào số tổng");
        int number = scanner.nextInt();
        int array[] = {1,10,3,2,3};
        boolean flag = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == number) {
                    flag = false;
                    System.out.printf("vị trí thứ: " + i + "và vị trí thứ: " + j);

                }
            }
        }
        if (flag) {
            System.out.printf("không có vị trí phù hợp");
        }

    }
}