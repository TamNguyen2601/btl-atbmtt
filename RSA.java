import java.util.Scanner;

public class RSA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap p: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: p phai la so nguyen.");
            sc.close();
            return;
        }
        int p = sc.nextInt();

        System.out.print("Nhap q: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: q phai la so nguyen.");
            sc.close();
            return;
        }
        int q = sc.nextInt();

        System.out.print("Nhap e: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: e phai la so nguyen.");
            sc.close();
            return;
        }
        int e = sc.nextInt();

        System.out.print("Nhap m: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: m phai la so nguyen.");
            sc.close();
            return;
        }
        int m = sc.nextInt();

        if (!laSoNguyenTo(p) || !laSoNguyenTo(q)) {
            System.out.println("Loi: p va q phai la so nguyen to.");
            sc.close();
            return;
        }

        if (!laSoDuong(e) || !laSoDuong(m)) {
            System.out.println("Loi: e va m phai la so nguyen duong.");
            sc.close();
            return;
        }

        int n = p * q;
        int phiN = (p - 1) * (q - 1);

        int d = TimNghichDao.tim_nghich_dao_euclid_mo_rong(phiN, e);
        if (d == -1) {
            System.out.println("Loi: khong ton tai d = e^-1 (mod phiN).");
            sc.close();
            return;
        }

        int C = luyThuaModulo(m, d, n);
        int M = luyThuaModulo(C, e, n);

        System.out.println("-------------------------------");
        System.out.println("n = " + n);
        System.out.println("phiN = " + phiN);
        System.out.println("d = " + d);
        System.out.println("C = " + C);
        System.out.println("M = " + M);

        sc.close();
    }

    private static boolean laSoDuong(int x) {
        return x > 0;
    }

    private static boolean laSoNguyenTo(int so) {
        if (so < 2) {
            return false;
        }
        for (int i = 2; i * i <= so; i++) {
            if (so % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static int luyThuaModulo(int coSo, int soMu, int modulo) {
        if (modulo == 1) {
            return 0;
        }

        int ketQua = 1;
        int b = coSo % modulo;
        if (b < 0) {
            b += modulo;
        }

        int mu = soMu;
        while (mu > 0) {
            if ((mu & 1) == 1) {
                ketQua = (ketQua * b) % modulo;
            }
            b = (b * b) % modulo;
            mu >>= 1;
        }
        return ketQua;
    }
}
