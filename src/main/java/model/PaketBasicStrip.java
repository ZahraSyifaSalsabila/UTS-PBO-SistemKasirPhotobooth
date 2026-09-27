package model;

public class PaketBasicStrip extends PaketPhotobooth {
    private int limitGratis = 2;
    private double biayaEkstraPerLembar = 10000;
    private boolean frameWarnaCustom;

    public PaketBasicStrip(int kodeTransaksi, pelanggan pelanggan, int jumlahCetak, int durasiMenit, boolean frameWarnaCustom) {
        super(kodeTransaksi, pelanggan, 35000, jumlahCetak, durasiMenit);
        this.frameWarnaCustom = frameWarnaCustom;
    }

    public boolean isFrameWarnaCustom() {
        return frameWarnaCustom;
    }

    public void setFrameWarnaCustom(boolean frameWarnaCustom) {
        this.frameWarnaCustom = frameWarnaCustom;
    }

    @Override
    public double hitungHargaTotal() {
        double total = getHargaDasar();

        if (getJumlahCetak() > limitGratis) {
            int lembarEkstra = getJumlahCetak() - limitGratis;
            total = total + (lembarEkstra * biayaEkstraPerLembar);
        }

        if (frameWarnaCustom) {
            total = total + 5000;
        }

        return total;
    }

    @Override
    public void tampilStruk() {
        super.tampilStruk();
        System.out.println("Jenis Paket    : Basic Strip");
        System.out.println("Custom Frame   : " + (frameWarnaCustom ? "Ya (+Rp 5.000)" : "Tidak"));
    }
}