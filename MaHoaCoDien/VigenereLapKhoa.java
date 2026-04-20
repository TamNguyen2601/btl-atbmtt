package MaHoaCoDien;

import java.util.Scanner;

public class VigenereLapKhoa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // input: M = HONESTYISTHEBE
        System.out.print("Nhap ban ro (p): ");
        String banRoInput = sc.nextLine();

        if (!banRoInput.matches("[a-zA-Z]+")) {
            System.out.println("Loi: Dau vao chi duoc phep chua chu cai.");
            sc.close();
            return;
        }
        // input K = ABADBE
        System.out.print("Nhap khoa lap (k): ");
        String khoaInput = sc.nextLine();

        if (!khoaInput.matches("[a-zA-Z]+")) {
            System.out.println("Loi: Khoa chi duoc phep chua chu cai.");
            sc.close();
            return;
        }

        String banMa = maHoaVigenere(banRoInput, khoaInput);

        System.out.println("-------------------------------");
        System.out.println("Ban ma thu duoc (c): " + banMa);

        sc.close();
    }

    public static String maHoaVigenere(String banRo, String khoa) {
        StringBuilder ketQuaBanMa = new StringBuilder();

        String banRoInHoa = banRo.toUpperCase();
        String khoaInHoa = khoa.toUpperCase();
        int doDaiKhoa = khoaInHoa.length();

        for (int i = 0; i < banRoInHoa.length(); i++) {
            int p = banRoInHoa.charAt(i) - 'A';
            int k = khoaInHoa.charAt(i % doDaiKhoa) - 'A';

            int c = (p + k) % 26;

            char kyTuMaHoa = (char) (c + 'A');
            ketQuaBanMa.append(kyTuMaHoa);
        }

        return ketQuaBanMa.toString();
    }
}