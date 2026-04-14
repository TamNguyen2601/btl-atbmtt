import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhap du lieu dau vao
        System.out.println("--- THUAT TOAN RSA (KIEU INT) ---");
        System.out.print("Nhap p: ");
        int p = sc.nextInt();

        System.out.print("Nhap q: ");
        int q = sc.nextInt();

        System.out.print("Nhap e: ");
        int e = sc.nextInt();

        System.out.print("Nhap thong diep M: ");
        int M = sc.nextInt();

        // 2. Tinh toan n va phi(n)
        int n = p * q;
        int phi = (p - 1) * (q - 1);

        // 3. Tim d (nghich dao modulo e mod phi)
        // Dung thuat toan Euclid mo rong don gian
        int d = 0;
        for (int i = 1; i < phi; i++) {
            if ((e * i) % phi == 1) {
                d = i;
                break;
            }
        }

        // 4. Ma hoa va Giai ma
        // Ma hoa: C = M^e % n
        int C = tinhModPow(M, e, n);

        // Giai ma: M_prime = C^d % n
        int M_prime = tinhModPow(C, d, n);

        // 5. Xuat ket qua
        System.out.println("\n--- KET QUA ---");
        System.out.println("a) Khoa cong khai PU = {" + e + ", " + n + "}");
        System.out.println("b) Khoa rieng PR = {" + d + ", " + n + "}");
        System.out.println("c) Ban ma C = " + C);
        System.out.println("d) Giai ma C ta duoc M' = " + M_prime);
        System.out.println("e) Nhiem vu: BAO MAT (Confidentiality)");

        sc.close();
    }

    // Ham tinh (co so^mu) % modulo de tranh tran so kieu int
    public static int tinhModPow(int coSo, int mu, int modulo) {
        long res = 1;
        long base = coSo % modulo;
        while (mu > 0) {
            if (mu % 2 == 1)
                res = (res * base) % modulo;
            base = (base * base) % modulo;
            mu = mu / 2;
        }
        return (int) res;
    }
}