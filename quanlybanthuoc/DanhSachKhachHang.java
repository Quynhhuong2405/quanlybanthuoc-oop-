package quanlybanthuoc;

import java.util.Scanner;

public class DanhSachKhachHang {
    private KhachHang[] danhSachKhachHang;
    private int n; // Số lượng khách hàng hiện có
    private Scanner sc;

    // Constructor, khởi tạo mảng danh sách khách hàng với kích thước tối đa là 100
    public DanhSachKhachHang() {
        this.danhSachKhachHang = new KhachHang[100]; // Mảng cố định kích thước 100
        this.n = 0; // Ban đầu không có khách hàng
        this.sc = new Scanner(System.in);
    }

    // Thêm khách hàng vào danh sách
    public void themKhachHang() {
        if (n >= danhSachKhachHang.length) {
            System.out.println("Danh sach da day, khong the them khach hang.");
            return;
        }

        System.out.print("Nhap ten khach hang: ");
        String tenKhachHang = sc.nextLine();
        System.out.print("Nhap so dien thoai: ");
        String soDienThoai = sc.nextLine();
        System.out.print("Nhap ma hoa don: ");
        String maHoaDon = sc.nextLine();
        System.out.print("Nhap ten san pham: ");
        String tenSanPham = sc.nextLine();
        System.out.print("Nhap gia san pham: ");
        double gia = sc.nextDouble();
        System.out.print("Nhap so luong san pham: ");
        int soLuong = sc.nextInt();
        sc.nextLine(); // Xóa bộ nhớ đệm

        // Tạo đối tượng KhachHang và thêm vào danh sách
        KhachHang khachHang = new KhachHang(tenKhachHang, soDienThoai, maHoaDon, tenSanPham, gia, soLuong);
        danhSachKhachHang[n] = khachHang;
        n++;
        System.out.println("Them khach hang thanh cong.");
    }

    // Xóa khách hàng theo mã hóa đơn
    public void xoaKhachHang() {
        System.out.print("Nhap ma hoa don khach hang can xoa: ");
        String maHoaDon = sc.nextLine();
        boolean daXoa = false;

        for (int i = 0; i < n; i++) {
            if (danhSachKhachHang[i].getMaHoaDon().equals(maHoaDon)) {
                // Xóa khách hàng, dịch chuyển phần tử còn lại về trước
                for (int j = i; j < n - 1; j++) {
                    danhSachKhachHang[j] = danhSachKhachHang[j + 1];
                }
                danhSachKhachHang[n - 1] = null; // Xóa phần tử cuối cùng
                n--; // Giảm số lượng khách hàng
                daXoa = true;
                break;
            }
        }

        if (daXoa) {
            System.out.println("Xoa khach hang thanh cong.");
        } else {
            System.out.println("Khong tim thay khach hang voi ma hoa don: " + maHoaDon);
        }
    }

    // Sửa thông tin khách hàng theo mã hóa đơn
    public void suaKhachHang() {
        System.out.print("Nhap ma hoa don khach hang can sua: ");
        String maHoaDon = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (danhSachKhachHang[i].getMaHoaDon().equals(maHoaDon)) {
                System.out.print("Nhap ten khach hang moi: ");
                danhSachKhachHang[i].setTenKhachHang(sc.nextLine());
                System.out.print("Nhap so dien thoai moi: ");
                danhSachKhachHang[i].setSoDienThoai(sc.nextLine());
                System.out.print("Nhap ten san pham moi: ");
                danhSachKhachHang[i].setTenSanPham(sc.nextLine());
                System.out.print("Nhap gia san pham moi: ");
                danhSachKhachHang[i].setGia(sc.nextDouble());
                System.out.print("Nhap so luong moi: ");
                danhSachKhachHang[i].setSoLuong(sc.nextInt());
                sc.nextLine(); // Xóa bộ nhớ đệm
                System.out.println("Sua thong tin khach hang thanh cong.");
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma hoa don: " + maHoaDon);
    }

    // Tìm kiếm khách hàng theo mã hóa đơn
    public void timKiemKhachHang() {
        System.out.print("Nhap ma hoa don khach hang can tim: ");
        String maHoaDon = sc.nextLine();
        for (int i = 0; i < n; i++) {
            if (danhSachKhachHang[i].getMaHoaDon().equals(maHoaDon)) {
                System.out.println("Thong tin khach hang: " + danhSachKhachHang[i]);
                return;
            }
        }
        System.out.println("Khong tim thay khach hang voi ma hoa don: " + maHoaDon);
    }

    // Xuất danh sách khách hàng
    public void xuatDanhSachKhachHang() {
        if (n == 0) {
            System.out.println("Danh sach khach hang trong.");
        } else {
            System.out.println("Danh sach khach hang:");
            for (int i = 0; i < n; i++) {
                System.out.println(danhSachKhachHang[i]);
            }
        }
    }

    // Menu cho người dùng
    public void menu() {
        int choice;
        do {
            System.out.println("\n======BANG LUA CHON======");
            System.out.println("1. Them khach hang");
            System.out.println("2. Xoa khach hang");
            System.out.println("3. Sua thong tin khach hang");
            System.out.println("4. Tim kiem khach hang");
            System.out.println("5. Xuat danh sach");
            System.out.println("6. Thoat");
            System.out.print("Lua chon cua ban la: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> themKhachHang();
                case 2 -> xoaKhachHang();
                case 3 -> suaKhachHang();
                case 4 -> timKiemKhachHang();
                case 5 -> xuatDanhSachKhachHang();
                case 6 -> System.out.println("Thoat chuong trinh");
                default -> System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 6);
    }
}
