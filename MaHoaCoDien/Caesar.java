package MaHoaCoDien;

import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // M = AWOMANGIVESANDFO
        System.out.print("Nhap ban ro (p): ");
        String banRoInput = sc.nextLine();

        if (!banRoInput.matches("[a-zA-Z]+")) {
            System.out.println("Loi: Dau vao chi duoc phep chua chu cai.");
            sc.close();
            return;
        }

        System.out.print("Nhap khoa tinh tien (k): ");
        if (sc.hasNextInt()) {
            int khoaK = sc.nextInt();
            String banMa = maHoaCaesar(banRoInput, khoaK);

            System.out.println("-------------------------------");
            System.out.println("Ban ma thu duoc (c): " + banMa);
        } else {
            System.out.println("Loi: Khoa k phai la mot so nguyen.");
        }

        sc.close();
    }

    public static String maHoaCaesar(String banRo, int khoa) {
        StringBuilder ketQuaBanMa = new StringBuilder();

        int khoaHieuChinh = khoa % 26;
        if (khoaHieuChinh < 0) {
            khoaHieuChinh += 26;
        }

        for (int i = 0; i < banRo.length(); i++) {
            char kyTuHienTai = banRo.charAt(i);
            char chuHoa = Character.toUpperCase(kyTuHienTai);

            int p = chuHoa - 'A';
            int c = (p + khoaHieuChinh) % 26;

            char kyTuMaHoa = (char) (c + 'A');
            ketQuaBanMa.append(kyTuMaHoa);
        }

        return ketQuaBanMa.toString();
    }
}