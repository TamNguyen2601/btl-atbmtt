import java.util.Scanner;

public class TimNghichDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhap a va n
        System.out.print("Nhap so a: ");
        int a = sc.nextInt();
        System.out.print("Nhap modulo n: ");
        int n = sc.nextInt();

        // Tim nghich dao modulo
        int x = findInverse(a, n);

        // Xuat ket qua
        System.out.println("-------------------------------");
        if (x == -1) {
            System.out.println("Khong ton tai nghich dao modulo vi gcd(a, n) != 1");
        } else {
            System.out.println("Nghich dao modulo x = a^-1 mod n la: " + x);
            System.out.println("Kiem tra: (" + a + " * " + x + ") % " + n + " = " + (1L * a * x % n));
        }

        sc.close();
    }

    public static int findInverse(int a, int n) {
        int m0 = n;
        int y = 0, x = 1;

        if (n == 1)
            return 0;

        while (a > 1) {
            // Neu n = 0 ma a > 1 thi gcd != 1
            if (n == 0)
                return -1;

            // q la thuong so
            int q = a / n;
            int t = n;

            // n la so du (giong thuat toan Euclid thong thuong)
            n = a % n;
            a = t;
            t = y;

            // Cap nhat x va y theo cong thuc Euclid mo rong
            y = x - q * y;
            x = t;
        }

        // Dam bao x la so duong
        if (x < 0)
            x += m0;

        // Kiem tra lai neu a ban dau va n ban dau khong nguyen to cung nhau
        // (Neu a sau vong lap khong bang 1 nghia la gcd > 1)
        if (a != 1)
            return -1;

        return x;
    }
}
