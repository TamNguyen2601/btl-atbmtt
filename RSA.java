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
        int soP = sc.nextInt();

        System.out.print("Nhap q: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: q phai la so nguyen.");
            sc.close();
            return;
        }
        int soQ = sc.nextInt();

        System.out.print("Nhap e: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: e phai la so nguyen.");
            sc.close();
            return;
        }
        int soE = sc.nextInt();

        System.out.print("Nhap m: ");
        if (!sc.hasNextInt()) {
            System.out.println("Loi: m phai la so nguyen.");
            sc.close();
            return;
        }
        int soM = sc.nextInt();

        if (!laSoNguyenTo(soP) || !laSoNguyenTo(soQ)) {
            System.out.println("Loi: p va q phai la so nguyen to.");
            sc.close();
            return;
        }

        if (!laSoDuong(soE) || !laSoDuong(soM)) {
            System.out.println("Loi: e va m phai la so nguyen duong.");
            sc.close();
            return;
        }

        int soN = soP * soQ;
        int phiN = (soP - 1) * (soQ - 1);

        if (phiN <= 1) {
            System.out.println("Loi: phiN khong hop le.");
            sc.close();
            return;
        }

        if (soE <= 0 || soE >= phiN) {
            System.out.println("Loi: e phai thoa 0 < e < phiN.");
            sc.close();
            return;
        }

        if (ucln(soE, phiN) != 1) {
            System.out.println("Loi: e va phiN khong nguyen to cung nhau, khong ton tai nghich dao modulo.");
            sc.close();
            return;
        }

        int soD = TimNghichDao.tim_nghich_dao_euclid_mo_rong(phiN, soE);
        if (soD == -1) {
            System.out.println("Loi: khong ton tai d = e^-1 (mod phiN).");
            sc.close();
            return;
        }

        int banMaC = luyThuaModulo(soM, soD, soN);
        int banRoM = luyThuaModulo(banMaC, soE, soN);

        System.out.println("-------------------------------");
        System.out.println("n = " + soN);
        System.out.println("phiN = " + phiN);
        System.out.println("d = " + soD);
        System.out.println("C = " + banMaC);
        System.out.println("M = " + banRoM);

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

    private static int ucln(int a, int b) {
        int soA = Math.abs(a);
        int soB = Math.abs(b);
        while (soB != 0) {
            int du = soA % soB;
            soA = soB;
            soB = du;
        }
        return soA;
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
