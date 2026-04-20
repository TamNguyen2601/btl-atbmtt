import java.util.Scanner;

public class TimNghichDao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so b: ");
        int b = sc.nextInt();
        System.out.print("Nhap modulo m: ");
        int m = sc.nextInt();

        int nghich_dao = tim_nghich_dao_euclid_mo_rong(m, b);

        System.out.println("-------------------------------");
        if (nghich_dao == -1) {
            System.out.println("Khong ton tai nghich dao modulo");
        } else {
            System.out.println("Nghich dao modulo la: " + nghich_dao);
        }

        sc.close();
    }

    public static int tim_nghich_dao_euclid_mo_rong(int m, int b) {
        int a1 = 0, a2 = m;
        int b1 = 1, b2 = b;

        while (true) {
            if (b2 == 0) {
                return -1;
            }

            if (b2 == 1) {
                if (b1 < 0) {
                    b1 = b1 + m;
                }
                return b1;
            }

            int q = a2 / b2;

            int t1 = a1 - q * b1;
            int t2 = a2 - q * b2;

            a1 = b1;
            a2 = b2;

            b1 = t1;
            b2 = t2;
        }
    }
}