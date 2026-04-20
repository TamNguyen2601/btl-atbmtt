package MaHoaCoDien;

import java.util.Scanner;

public class VigenereAutoKey {
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
        System.out.print("Nhap tu khoa ban dau: ");
        String tuKhoaInput = sc.nextLine();

        if (!tuKhoaInput.matches("[a-zA-Z]+")) {
            System.out.println("Loi: Tu khoa chi duoc phep chua chu cai.");
            sc.close();
            return;
        }

        String banMa = maHoaAutokey(banRoInput, tuKhoaInput);

        System.out.println("-------------------------------");
        System.out.println("Ban ma thu duoc (c): " + banMa);

        sc.close();
    }

    public static String maHoaAutokey(String banRo, String tuKhoa) {
        StringBuilder ketQuaBanMa = new StringBuilder();

        String banRoInHoa = banRo.toUpperCase();
        String tuKhoaInHoa = tuKhoa.toUpperCase();

        StringBuilder luongKhoa = new StringBuilder(tuKhoaInHoa);
        luongKhoa.append(banRoInHoa);

        for (int i = 0; i < banRoInHoa.length(); i++) {
            int p = banRoInHoa.charAt(i) - 'A';
            int k = luongKhoa.charAt(i) - 'A';

            int c = (p + k) % 26;

            char kyTuMaHoa = (char) (c + 'A');
            ketQuaBanMa.append(kyTuMaHoa);
        }

        return ketQuaBanMa.toString();
    }
}