package MaHoaCoDien;

import java.util.Scanner;

public class VigenereLapKhoa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhap ban ro M
        System.out.print("Nhap ban ro (M): ");
        String m = sc.nextLine();

        // Nhap khoa K (dang chuoi)
        System.out.print("Nhap khoa K (dang chu): ");
        String k = sc.nextLine();

        // Thuc hien ma hoa
        String ketQua = maHoaVigenere(m, k);

        // Xuat ket qua
        System.out.println("-------------------------------");
        System.out.println("Ban ma hoa: " + ketQua);

        sc.close();
    }

    public static String maHoaVigenere(String text, String key) {
        StringBuilder result = new StringBuilder();
        key = key.toUpperCase(); // Chuan hoa khoa sang chu hoa
        int keyIndex = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                // Xac dinh do dich chuyen tu khoa K tai vi tri hien tai
                int shift = key.charAt(keyIndex) - 'A';

                if (Character.isUpperCase(ch)) {
                    char c = (char) (((ch - 'A' + shift) % 26) + 'A');
                    result.append(c);
                } else {
                    char c = (char) (((ch - 'a' + shift) % 26) + 'a');
                    result.append(c);
                }

                // Tang index cua khoa va quay vong (lap khoa)
                keyIndex = (keyIndex + 1) % key.length();
            } else {
                // Giu nguyen ky tu dac biet va khong tang keyIndex
                result.append(ch);
            }
        }
        return result.toString();
    }
}
