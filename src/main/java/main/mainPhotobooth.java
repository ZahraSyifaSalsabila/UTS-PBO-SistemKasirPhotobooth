package main;

import java.util.ArrayList;
import java.util.Scanner;
import model.*;

public class mainPhotobooth {

    private static String inputString(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            if (!text.isEmpty()) {
                return text;
            }
            System.out.println("[ERROR] Input tidak boleh kosong! Harap masukkan teks dengan benar.");
        }
    }

    private static int inputInt(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("[ERROR] Input tidak boleh kosong! Harap masukkan angka.");
                continue;
            }
            try {
                return Integer.parseInt(text);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa ANGKA BULAT! Silakan coba lagi.");
            }
        }
    }

    private static int inputIntPositif(Scanner input, String prompt) {
        while (true) {
            int val = inputInt(input, prompt);
            if (val > 0) {
                return val;
            }
            System.out.println("[ERROR] Nilai harus lebih besar dari 0! Silakan coba lagi.");
        }
    }

    private static int inputIntRange(Scanner input, String prompt, int min, int max) {
        while (true) {
            int val = inputInt(input, prompt);
            if (val >= min && val <= max) {
                return val;
            }
            System.out.println("[ERROR] Pilihan harus berupa angka antara " + min + " sampai " + max + "!");
        }
    }

    private static double inputDouble(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim();
            if (text.isEmpty()) {
                System.out.println("[ERROR] Input tidak boleh kosong! Harap masukkan nominal uang.");
                continue;
            }
            try {
                double val = Double.parseDouble(text);
                if (val >= 0) {
                    return val;
                }
                System.out.println("[ERROR] Nominal tidak boleh angka negatif!");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] Input harus berupa ANGKA/NOMINAL yang valid!");
            }
        }
    }

    private static boolean inputYesNo(Scanner input, String prompt) {
        while (true) {
            System.out.print(prompt);
            String text = input.nextLine().trim().toLowerCase();
            if (text.equals("y") || text.equals("ya")) {
                return true;
            } else if (text.equals("n") || text.equals("tidak")) {
                return false;
            }
            System.out.println("[ERROR] Input tidak valid! Harap ketik 'y' (ya) atau 'n' (tidak).");
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<PaketPhotobooth> daftarTransaksi = new ArrayList<>();

        int idCounter = 1;
        boolean berjalan = true;

        while (berjalan) {
            System.out.println("\n========================================");
            System.out.println("    SISTEM KASIR PHOTOBOOTH (CRUD)      ");
            System.out.println("========================================");
            System.out.println("1. Tambah Transaksi Baru ");
            System.out.println("2. Lihat Semua Transaksi ");
            System.out.println("3. Ubah Data Transaksi   ");
            System.out.println("4. Hapus Transaksi       ");
            System.out.println("5. Lihat Rekap Omset Studio");
            System.out.println("6. Keluar Program");
            
            int pilihanMenu = inputIntRange(input, "Pilih Menu (1-6): ", 1, 6);

            switch (pilihanMenu) {
                case 1:
                    System.out.println("\n--- TAMBAH TRANSAKSI BARU ---");
                    int kodeTrx = idCounter;
                    int idPel = idCounter;

                    String nama = inputString(input, "Masukkan Nama Pelanggan : ");
                    String noTelp = inputString(input, "Masukkan No. Telepon    : ");

                    pelanggan pelangganBaru = new pelanggan(idPel, nama, noTelp);

                    System.out.println("\nPilih Jenis Paket Photobooth:");
                    System.out.println("1. Paket Basic Strip (Rp 35.000 | Include 2 Lembar)");
                    System.out.println("2. Paket VIP Digital  (Rp 75.000 | Include 4 Lembar)");
                    System.out.println("3. Paket Event Group  (Rp 120.000 | Include 8 Lembar)");
                    int pilihanPaket = inputIntRange(input, "Pilihan Paket (1/2/3): ", 1, 3);

                    int durasi = inputIntPositif(input, "Masukkan Durasi Sesi Foto (Menit): ");
                    int lembarCetak = inputIntPositif(input, "Masukkan Jumlah Lembar Cetak Foto: ");

                    PaketPhotobooth transaksiBaru = null;

                    if (pilihanPaket == 1) {
                        boolean customFrame = inputYesNo(input, "Gunakan Frame Warna Custom? (y/n): ");
                        transaksiBaru = new PaketBasicStrip(kodeTrx, pelangganBaru, lembarCetak, durasi, customFrame);
                    } else if (pilihanPaket == 2) {
                        String filter = inputString(input, "Pilih Filter Foto (Vintage/BW/Cyber): ");
                        boolean softfile = inputYesNo(input, "Tambah Link Softfile Google Drive? (y/n): ");
                        transaksiBaru = new PaketVIPDigital(kodeTrx, pelangganBaru, lembarCetak, durasi, softfile, filter);
                    } else if (pilihanPaket == 3) {
                        boolean aksesoris = inputYesNo(input, "Sewa Aksesoris & Costume Ekstra? (y/n): ");
                        transaksiBaru = new PaketEventGroup(kodeTrx, pelangganBaru, lembarCetak, durasi, aksesoris);
                    }

                    double totalHarga = transaksiBaru.hitungHargaTotal();
                    System.out.println("\nTotal Bayar: Rp " + (long) totalHarga);
                    
                    double uangBayar = 0;
                    while (true) {
                        uangBayar = inputDouble(input, "Masukkan Nominal Uang Pembayaran: Rp ");
                        if (uangBayar >= totalHarga) {
                            break;
                        }
                        System.out.println("[ERROR] Uang pembayaran kurang! Total bayar adalah Rp " + (long) totalHarga + ". Silakan masukkan nominal yang cukup.");
                    }

                    System.out.println("Kembalian  : Rp " + (long) (uangBayar - totalHarga));
                    System.out.println("[SUCCESS] Pembayaran Berhasil! Transaksi BERHASIL disimpan.");
                    daftarTransaksi.add(transaksiBaru);
                    idCounter++;
                    break;

                case 2:
                    System.out.println("\n--- DAFTAR SELURUH TRANSAKSI ---");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada data transaksi yang terdaftar.");
                    } else {
                        for (PaketPhotobooth trx : daftarTransaksi) {
                            trx.tampilStruk();
                            System.out.println("Total Bayar    : Rp " + (long) trx.hitungHargaTotal());
                            System.out.println("----------------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\n--- UBAH DATA TRANSAKSI ---");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada data transaksi untuk diubah.");
                        break;
                    }

                    int idUbah = inputIntPositif(input, "Masukkan ID Transaksi yang ingin diubah: ");

                    PaketPhotobooth trxDitemukan = null;
                    for (PaketPhotobooth trx : daftarTransaksi) {
                        if (trx.getKodeTransaksi() == idUbah) {
                            trxDitemukan = trx;
                            break;
                        }
                    }

                    if (trxDitemukan != null) {
                        System.out.println("Data ditemukan untuk Pelanggan: " + trxDitemukan.getPelanggan().getNama());
                        String namaBaru = inputString(input, "Masukkan Nama Baru     : ");
                        String noTelpBaru = inputString(input, "Masukkan No. Telp Baru : ");
                        int cetakBaru = inputIntPositif(input, "Masukkan Jumlah Cetak Baru: ");

                        trxDitemukan.getPelanggan().setNama(namaBaru);
                        trxDitemukan.getPelanggan().setNomorTelepon(noTelpBaru);
                        trxDitemukan.setJumlahCetak(cetakBaru);

                        System.out.println("\n[SISTEM] Data transaksi ID " + idUbah + " berhasil diperbarui!");
                    } else {
                        System.out.println("Transaksi dengan ID " + idUbah + " tidak ditemukan!");
                    }
                    break;

                case 4:
                    System.out.println("\n--- [DELETE] HAPUS TRANSAKSI ---");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada data transaksi untuk dihapus.");
                        break;
                    }

                    int idHapus = inputIntPositif(input, "Masukkan ID Transaksi yang ingin dihapus: ");

                    boolean statusHapus = false;
                    for (int i = 0; i < daftarTransaksi.size(); i++) {
                        if (daftarTransaksi.get(i).getKodeTransaksi() == idHapus) {
                            daftarTransaksi.remove(i);
                            statusHapus = true;
                            System.out.println("\n[SISTEM] Transaksi ID " + idHapus + " berhasil dihapus!");
                            break;
                        }
                    }

                    if (!statusHapus) {
                        System.out.println("Transaksi dengan ID " + idHapus + " tidak ditemukan!");
                    }
                    break;

                case 5:
                    System.out.println("\n========================================");
                    System.out.println("  REKAP AKHIR SELURUH TRANSAKSI STUDIO  ");
                    System.out.println("========================================");
                    if (daftarTransaksi.isEmpty()) {
                        System.out.println("Belum ada transaksi untuk direkap.");
                    } else {
                        double totalOmset = 0;
                        for (PaketPhotobooth trx : daftarTransaksi) {
                            System.out.println("ID Transaksi: " + trx.getKodeTransaksi() + " | Pelanggan: " + trx.getPelanggan().getNama() + " | Total: Rp " + (long) trx.hitungHargaTotal());
                            totalOmset += trx.hitungHargaTotal();
                        }
                        System.out.println("----------------------------------------");
                        System.out.println("TOTAL OMSET STUDIO: Rp " + (long) totalOmset);
                    }
                    System.out.println("========================================");
                    break;

                case 6:
                    berjalan = false;
                    System.out.println("\nTerima kasih telah menggunakan Sistem Kasir Photobooth. Sampai jumpa!");
                    break;
            }
        }

        input.close();
    }
}