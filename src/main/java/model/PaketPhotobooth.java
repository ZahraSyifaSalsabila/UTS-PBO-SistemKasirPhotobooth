package model;

public class PaketPhotobooth {
    private int kodeTransaksi;
    private pelanggan pelanggan;
    private double hargaDasar;
    private int jumlahCetak;
    private int durasiMenit;

    public PaketPhotobooth(int kodeTransaksi, pelanggan pelanggan, double hargaDasar, int jumlahCetak, int durasiMenit) {
        this.kodeTransaksi = kodeTransaksi;
        this.pelanggan = pelanggan;
        this.hargaDasar = hargaDasar;
        this.jumlahCetak = jumlahCetak;
        this.durasiMenit = durasiMenit;
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public void setKodeTransaksi(int kodeTransaksi) {
        this.kodeTransaksi = kodeTransaksi;
    }

    public pelanggan getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(pelanggan pelanggan) {
        this.pelanggan = pelanggan;
    }

    public double getHargaDasar() {
        return hargaDasar;
    }

    public void setHargaDasar(double hargaDasar) {
        this.hargaDasar = hargaDasar;
    }

    public int getJumlahCetak() {
        return jumlahCetak;
    }

    public void setJumlahCetak(int jumlahCetak) {
        this.jumlahCetak = jumlahCetak;
    }

    public int getDurasiMenit() {
        return durasiMenit;
    }

    public void setDurasiMenit(int durasiMenit) {
        this.durasiMenit = durasiMenit;
    }

    public double hitungHargaTotal() {
        return hargaDasar;
    }

    public void tampilStruk() {
        System.out.println("========================================");
        System.out.println("        STRUK SELF-PHOTO STUDIO         ");
        System.out.println("========================================");
        System.out.println("Kode Transaksi : " + kodeTransaksi);
        System.out.println("ID Pelanggan   : " + pelanggan.getIdPelanggan());
        System.out.println("Nama Pelanggan : " + pelanggan.getNama());
        System.out.println("No. Telepon    : " + pelanggan.getNomorTelepon());
        System.out.println("Durasi Sesi    : " + durasiMenit + " Menit");
        System.out.println("Jumlah Cetak   : " + jumlahCetak + " Lembar");
    }

    public void tampilStruk(String pesanTambahan) {
        tampilStruk();
        System.out.println("Catatan        : " + pesanTambahan);
    }
}