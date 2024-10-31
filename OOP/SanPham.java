import java.util.Scanner;

public abstract class SanPham {
    private String tenSP, loaiSP;
    private int soluongSP;
    private double gia;
    
    
//Constructors
    public SanPham() {
        tenSP = "";
        loaiSP = "";
        soluongSP = 0;
        gia = 0;
    }
    
    public SanPham(String tenSP, String loaiSP, int soluongSP, double gia) {
        this.tenSP = tenSP;
        this.loaiSP = loaiSP;
        this.soluongSP = soluongSP;
        this.gia = gia;
    }

//SET
    public void settenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public void setloaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public void setsoluongSP(int soluongSP) {
        this.soluongSP = soluongSP;
    }

    public void setgia(double gia) {
        this.gia = gia;
    }

//GET
    public String gettenSP() {
        return tenSP;
    }

    public String getloaiSP() {
        return loaiSP;
    }
    
    public int getsoluongSP() {
        return soluongSP;
    }

    public double getgia() {
        return gia;
    }

//NHAP & XUAT
    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ten san pham : ");
        tenSP = sc.nextLine();

        System.out.println("Loai san pham : ");
        loaiSP = sc.nextLine();

        System.out.println("So luong san pham : ");
        soluongSP = sc.nextInt();

        System.out.println("Gia san pham : ");
        gia = sc.nextDouble();

        sc.close();
    }

    public abstract void xuat();
}