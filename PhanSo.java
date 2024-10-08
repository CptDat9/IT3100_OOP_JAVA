import java.util.Scanner;

public class PhanSo {
    private int tuSo;
    private int mauSo;
// -----------------------------------------------------------------------------

    // Constructor không đối số
    public PhanSo() {}

    // Constructor với tham số
    public PhanSo(int tuSo, int mauSo) {
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
// -----------------------------------------------------------------------------

    // Nhập giá trị phân số
    public static PhanSo nhapPhanSo(int index) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap phan so thu " + index);
        System.out.print("Tu so cua phan so thu " + index + ": ");
        int tuSo = sc.nextInt();
        int mauSo;
        do {
            System.out.print("Mau so cua phan so thu " + index + ": ");
            mauSo = sc.nextInt();
            if (mauSo == 0) {
                System.out.println("Mau so không thể bằng 0. Vui long nhap lai.");
            }
        } while (mauSo == 0);
        return new PhanSo(tuSo, mauSo);
    }
// -----------------------------------------------------------------------------

    // Tìm ước chung lớn nhất (UCLN)
    public static int UCLN(int a, int b) {
        if (b == 0) {
            return a;
        }
        return UCLN(b, a % b);
    }
// -----------------------------------------------------------------------------

    // Rút gọn phân số
    public PhanSo toiGian() {
        int ucln = UCLN(Math.abs(tuSo), Math.abs(mauSo));
        return new PhanSo(tuSo / ucln, mauSo / ucln);
    }
// -----------------------------------------------------------------------------

    // Cộng hai phân số
    public static PhanSo cong(PhanSo ps1, PhanSo ps2) {
        int tuSo = ps1.tuSo * ps2.mauSo + ps2.tuSo * ps1.mauSo;
        int mauSo = ps1.mauSo * ps2.mauSo;
        return new PhanSo(tuSo, mauSo).toiGian();
    }
// -----------------------------------------------------------------------------

    // Trừ hai phân số
    public static PhanSo tru(PhanSo ps1, PhanSo ps2) {
        int tuSo = ps1.tuSo * ps2.mauSo - ps2.tuSo * ps1.mauSo;
        int mauSo = ps1.mauSo * ps2.mauSo;
        return new PhanSo(tuSo, mauSo).toiGian();
    }
// -----------------------------------------------------------------------------

    // Nhân hai phân số
    public static PhanSo nhan(PhanSo ps1, PhanSo ps2) {
        int tuSo = ps1.tuSo * ps2.tuSo;
        int mauSo = ps1.mauSo * ps2.mauSo;
        return new PhanSo(tuSo, mauSo).toiGian();
    }
// -----------------------------------------------------------------------------

    // Chia hai phân số
    public static PhanSo chia(PhanSo ps1, PhanSo ps2) {
        int tuSo = ps1.tuSo * ps2.mauSo;
        int mauSo = ps1.mauSo * ps2.tuSo;
        return new PhanSo(tuSo, mauSo).toiGian();
    }
// -----------------------------------------------------------------------------

    // Hiển thị phân số
    public void hienThi() {
        if (mauSo == 1 || tuSo == 0) {
            System.out.print(tuSo);
        } else {
            System.out.println(tuSo + "/" + mauSo);
        }
    }
// -----------------------------------------------------------------------------

    public static void main(String[] args) {
        PhanSo ps1 = nhapPhanSo(1);
        PhanSo ps2 = nhapPhanSo(2); 
        System.out.println("Phan so 1 (toi gian):");
        ps1.toiGian().hienThi();
        System.out.println();
        System.out.println("Phan so 2 (toi gian):");
        ps2.toiGian().hienThi();
        System.out.println();
        
        System.out.print("Tong hai phan so: ");
        cong(ps1, ps2).hienThi();
        System.out.println();

        System.out.print("Hieu (Phan so 1 - Phan so 2): ");
        tru(ps1, ps2).hienThi();
        System.out.println();

        System.out.print("Tich hai phan so: ");
        nhan(ps1, ps2).hienThi();
        System.out.println();

        if (ps2.tuSo != 0) {
            System.out.print("Thuong (Phan so 1 / Phan so 2): ");
            chia(ps1, ps2).hienThi();
            System.out.println();
        } else {
            System.out.println("Khong the thuc hien phep chia (Phan so 1 / Phan so 2)");
        }
    }
}
