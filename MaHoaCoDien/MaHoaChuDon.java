package MaHoaCoDien;

import java.util.Scanner;

public class MaHoaChuDon {
    public static final String BANG_CHU_CAI_CHUAN = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input: M = LIKEFATHERLIKESO
        System.out.print("Nhap ban ro (p): ");
        String banRoInput = sc.nextLine();

        if (!banRoInput.matches("[a-zA-Z]+")) {
            System.out.println("Loi: Dau vao chi duoc phep chua chu cai.");
            sc.close();
            return;
        }
        // Key: K = LYFGMKNERXJPQIVATOHSZDBUCW
        System.out.print("Nhap khoa hoan vi (26 chu cai): ");
        String khoaInput = sc.nextLine().toUpperCase();

        if (khoaInput.length() != 26 || !khoaInput.matches("[A-Z]+")) {
            System.out.println("Loi: Khoa phai co dung 26 chu cai va khong chua ky tu dac biet.");
        } else {
            String banMa = maHoaChuDon(banRoInput, khoaInput);
            System.out.println("-------------------------------");
            System.out.println("Ban ma thu duoc (c): " + banMa);
        }

        sc.close();
    }

    public static String maHoaChuDon(String banRo, String khoa) {
        StringBuilder ketQuaBanMa = new StringBuilder();
        String banRoInHoa = banRo.toUpperCase();

        for (int i = 0; i < banRoInHoa.length(); i++) {
            char kyTuHienTai = banRoInHoa.charAt(i);
            int chiSo = BANG_CHU_CAI_CHUAN.indexOf(kyTuHienTai);

            char kyTuThayThe = khoa.charAt(chiSo);
            ketQuaBanMa.append(kyTuThayThe);
        }

        return ketQuaBanMa.toString();
    }
}