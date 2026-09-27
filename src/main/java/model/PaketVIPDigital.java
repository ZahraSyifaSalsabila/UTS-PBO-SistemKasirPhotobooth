package model;

public class PaketVIPDigital extends PaketPhotobooth {
    private int limitGratis = 4;
    private double biayaEkstraPerLembar = 5000;
    private boolean sertakanSoftfile;
    private String pilihanFilter;

    public PaketVIPDigital(int kodeTransaksi, pelanggan pelanggan, int jumlahCetak, int durasiMenit, boolean sertakanSoftfile, String pilihanFilter) {
        super(kodeTransaksi, pelanggan, 75000, jumlahCetak, durasiMenit);
        this.sertakanSoftfile = sertakanSoftfile;
        this.pilihanFilter = pilihanFilter;
    }

    public boolean isSertakanSoftfile() {
        return sertakanSoftfile;
    }

    public void setSertakanSoftfile(boolean sertakanSoftfile) {
        this.sertakanSoftfile = sertakanSoftfile;
    }

    public String getPilihanFilter() {
        return pilihanFilter;
    }

    public void setPilihanFilter(String pilihanFilter) {
        this.pilihanFilter = pilihanFilter;
    }

    @Override
    public double hitungHargaTotal() {
        double total = getHargaDasar();

        if (getJumlahCetak() > limitGratis) {
            int lembarEkstra = getJumlahCetak() - limitGratis;
            total = total + (lembarEkstra * biayaEkstraPerLembar);
        }

        if (sertakanSoftfile) {
            total = total + 10000;
        }

        return total;
    }

    @Override
    public void tampilStruk() {
        super.tampilStruk();
        System.out.println("Jenis Paket    : VIP Digital");
        System.out.println("Pilihan Filter : " + pilihanFilter);
        System.out.println("Softfile Drive : " + (sertakanSoftfile ? "Ya (+Rp 10.000)" : "Tidak"));
    }
}