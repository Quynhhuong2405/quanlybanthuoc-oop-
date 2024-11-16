package quanlybanthuoc;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyTaiKhoan {
    private static ArrayList<TaiKhoan> danhSachTaiKhoan = new ArrayList<>();
    private static TaiKhoan adminAccount = new TaiKhoan("admin", "admin123", "Admin");
    private static Scanner sc = new Scanner(System.in);

    // Phương thức đăng nhập tĩnh
    public static void dangNhap() {
        System.out.print("Tên đăng nhập: ");
        String tenDangNhap = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String matKhau = sc.nextLine();

        if (adminAccount.kiemTraDangNhap(tenDangNhap, matKhau)) {
            System.out.println("Đăng nhập thành công với quyền Admin.");
            quanLyTaiKhoan();
        } else {
            for (TaiKhoan tk : danhSachTaiKhoan) {
                if (tk.kiemTraDangNhap(tenDangNhap, matKhau)) {
                    System.out.println("Đăng nhập thành công với quyền Nhân viên.");
                    return;
                }
            }
            System.out.println("Sai tên đăng nhập hoặc mật khẩu!");
        }
    }

    // Phương thức đăng ký tĩnh
    public static void dangKy() {
        System.out.print("Nhập tên đăng nhập: ");
        String tenDangNhap = sc.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String matKhau = sc.nextLine();

        TaiKhoan tkMoi = new TaiKhoan(tenDangNhap, matKhau, "Nhân viên");
        danhSachTaiKhoan.add(tkMoi);
        System.out.println("Đăng ký tài khoản thành công!");
    }

    // Phương thức quản lý tài khoản tĩnh
    private static void quanLyTaiKhoan() {
        int luaChon;
        do {
            System.out.println("\n--- Quản lý tài khoản ---");
            System.out.println("1. Thêm tài khoản");
            System.out.println("2. Sửa tài khoản");
            System.out.println("3. Xóa tài khoản");
            System.out.println("4. Thoát");
            System.out.print("Chọn: ");
            luaChon = sc.nextInt();
            sc.nextLine();

            switch (luaChon) {
                case 1 -> themTaiKhoan();
                case 2 -> suaTaiKhoan();
                case 3 -> xoaTaiKhoan();
                case 4 -> System.out.println("Thoát quản lý tài khoản.");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 4);
    }

    // Phương thức thêm tài khoản tĩnh
    private static void themTaiKhoan() {
        System.out.print("Tên đăng nhập: ");
        String tenDangNhap = sc.nextLine();
        System.out.print("Mật khẩu: ");
        String matKhau = sc.nextLine();

        TaiKhoan tkMoi = new TaiKhoan(tenDangNhap, matKhau, "Nhân viên");
        danhSachTaiKhoan.add(tkMoi);
        System.out.println("Thêm tài khoản thành công!");
    }

    // Phương thức sửa tài khoản tĩnh
    private static void suaTaiKhoan() {
        System.out.print("Nhập tên đăng nhập của tài khoản cần sửa: ");
        String tenDangNhap = sc.nextLine();

        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getTenDangNhap().equals(tenDangNhap)) {
                System.out.print("Nhập mật khẩu mới: ");
                String matKhauMoi = sc.nextLine();
                tk.setMatKhau(matKhauMoi);
                System.out.println("Sửa tài khoản thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản!");
    }

    // Phương thức xóa tài khoản tĩnh
    private static void xoaTaiKhoan() {
        System.out.print("Nhập tên đăng nhập của tài khoản cần xóa: ");
        String tenDangNhap = sc.nextLine();

        for (TaiKhoan tk : danhSachTaiKhoan) {
            if (tk.getTenDangNhap().equals(tenDangNhap)) {
                danhSachTaiKhoan.remove(tk);
                System.out.println("Xóa tài khoản thành công!");
                return;
            }
        }
        System.out.println("Không tìm thấy tài khoản!");
    }
}
