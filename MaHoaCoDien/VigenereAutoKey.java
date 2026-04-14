package MaHoaCoDien;

import java.util.Scanner;

public class VigenereAutoKey {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhap ban ro M
        System.out.print("Nhap ban ro (M): ");
        String m = sc.nextLine();

        // Nhap khoa K ban dau
        System.out.print("Nhap khoa K (ban dau): ");
        String k = sc.nextLine();

        // Thuc hien ma hoa
        String ketQua = maHoaAutokey(m, k);

        // Xuat ket qua
        System.out.println("-------------------------------");
        System.out.println("Ban ma hoa (Autokey): " + ketQua);

        sc.close();
    }

    public static String maHoaAutokey(String text, String key) {
        StringBuilder result = new StringBuilder();

        // Chuan hoa du lieu ve chu hoa de tinh toan
        String upperText = text.toUpperCase().replaceAll("[^A-Z]", "");
        String upperKey = key.toUpperCase().replaceAll("[^A-Z]", "");

        // Tao chuoi khoa tu dong (Autokey): Key + Plaintext
        // Vi du: M = "HELLO", K = "AB" -> Luong khoa = "ABHEL"
        StringBuilder autoKey = new StringBuilder(upperKey);
        autoKey.append(upperText);

        int keyIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetter(ch)) {
                // Lay ky tu tu luong khoa autokey
                int shift = autoKey.charAt(keyIndex) - 'A';

                if (Character.isUpperCase(ch)) {
                    char c = (char) (((ch - 'A' + shift) % 26) + 'A');
                    result.append(c);
                } else {
                    char c = (char) (((ch - 'a' + shift) % 26) + 'a');
                    result.append(c);
                }
                keyIndex++;
            } else {
                // Giu nguyen ky tu dac biet
                result.append(ch);
            }
        }
        return result.toString();
    }
}
