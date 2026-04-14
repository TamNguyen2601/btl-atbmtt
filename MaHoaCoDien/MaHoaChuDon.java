package MaHoaCoDien;

import java.util.Scanner;

public class MaHoaChuDon {
    // Bang chu cai chuan de doi chieu
    public static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhap ban ro M
        System.out.print("Nhap ban ro (M): ");
        String m = sc.nextLine();

        // Nhap khoa K (K phai la mot chuoi 26 chu cai hoan vi)
        // Vi du: QWERTYUIOPASDFGHJKLZXCVBNM
        System.out.print("Nhap khoa K (26 chu cai hoan vi): ");
        String k = sc.nextLine().toUpperCase();

        if (k.length() != 26) {
            System.out.println("Loi: Khoa K phai co dung 26 chu cai!");
        } else {
            // Thuc hien ma hoa
            String ketQua = maHoaChuDon(m, k);

            // Xuat ket qua
            System.out.println("-------------------------------");
            System.out.println("Ban ma hoa: " + ketQua);
        }

        sc.close();
    }

    public static String maHoaChuDon(String text, String key) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                // Tim vi tri cua ky tu trong bang chu cai chuan
                char upperCh = Character.toUpperCase(ch);
                int index = ALPHABET.indexOf(upperCh);

                // Lay ky tu tuong ung tai vi tri do trong khoa K
                char replacement = key.charAt(index);

                // Giu nguyen dinh dang hoa/thuong
                if (Character.isLowerCase(ch)) {
                    result.append(Character.toLowerCase(replacement));
                } else {
                    result.append(replacement);
                }
            } else {
                // Giu nguyen ky tu dac biet, so, khoang trang
                result.append(ch);
            }
        }
        return result.toString();
    }
}
