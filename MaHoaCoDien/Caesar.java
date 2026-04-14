package MaHoaCoDien;

import java.util.Scanner;

public class Caesar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhap ban ro M
        System.out.print("Nhap ban ro (M): ");
        String m = sc.nextLine();

        // Nhap khoa K
        System.out.print("Nhap khoa dich chuyen (K): ");
        int k = sc.nextInt();

        // Thuc hien ma hoa
        String ketQua = maHoa(m, k);

        // Xuat ket qua
        System.out.println("-------------------------------");
        System.out.println("Ban ma hoa: " + ketQua);

        sc.close();
    }

    public static String maHoa(String text, int k) {
        StringBuilder result = new StringBuilder();

        // Xu ly khoa K de luon nam trong khoang 0-25
        k = k % 26;
        if (k < 0)
            k += 26;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            // Ma hoa chu hoa (A-Z)
            if (Character.isUpperCase(ch)) {
                char c = (char) (((int) ch + k - 65) % 26 + 65);
                result.append(c);
            }
            // Ma hoa chu thuong (a-z)
            else if (Character.isLowerCase(ch)) {
                char c = (char) (((int) ch + k - 97) % 26 + 97);
                result.append(c);
            }
            // Giu nguyen ky tu dac biet, so, khoang trang
            else {
                result.append(ch);
            }
        }
        return result.toString();
    }
}
