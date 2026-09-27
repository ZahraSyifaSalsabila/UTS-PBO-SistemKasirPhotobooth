package model;

public class pelanggan {
    private int idPelanggan;
    private String nama;
    private String nomorTelepon;

    public pelanggan(int idPelanggan, String nama, String nomorTelepon) {
        this.idPelanggan = idPelanggan;
        this.nama = nama;
        this.nomorTelepon = nomorTelepon;
    }

    public int getIdPelanggan() {
        return idPelanggan;
    }

    public void setIdPelanggan(int idPelanggan) {
        this.idPelanggan = idPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorTelepon() {
        return nomorTelepon;
    }

    public void setNomorTelepon(String nomorTelepon) {
        this.nomorTelepon = nomorTelepon;
    }
}