package model;

public class PaketEventGroup extends PaketPhotobooth {
    private int limitGratis = 8;
    private double biayaEkstraPerLembar = 4000;
    private boolean sewaAksesorisEkstra;

    public PaketEventGroup(int kodeTransaksi, pelanggan pelanggan, int jumlahCetak, int durasiMenit, boolean sewaAksesorisEkstra) {
        super(kodeTransaksi, pelanggan, 120000, jumlahCetak, durasiMenit);
        this.sewaAksesorisEkstra = sewaAksesorisEkstra;
    }

    public boolean isSewaAksesorisEkstra() {
        return sewaAksesorisEkstra;
    }

    public void setSewaAksesorisEkstra(boolean sewaAksesorisEkstra) {
        this.sewaAksesorisEkstra = sewaAksesorisEkstra;
    }

    @Override
    public double hitungHargaTotal() {
        double total = getHargaDasar();

        if (getJumlahCetak() > limitGratis) {
            int lembarEkstra = getJumlahCetak() - limitGratis;
            total = total + (lembarEkstra * biayaEkstraPerLembar);
        }

        if (sewaAksesorisEkstra) {
            total = total + 20000;
        }

        return total;
    }

    @Override
    public void tampilStruk() {
        super.tampilStruk();
        System.out.println("Jenis Paket    : Event Group");
        System.out.println("Aksesoris Ekstra: " + (sewaAksesorisEkstra ? "Ya (+Rp 20.000)" : "Tidak"));
    }
}