# Deskripsi Proyek

Sistem Kasir Photobooth merupakan aplikasi kasir berbasis TUI (Text User Interface) yang berfungsi membantu pengelola studio foto dalam mencatat, menampilkan, mengubah, menghapus, serta merekap hasil transaksi secara akurat dan efisien.

Aplikasi ini mendukung berbagai jenis paket photobooth yang memiliki skema perhitungan harga dan fasilitas berbeda seperti custom frame, softfile Google Drive, filter foto, dan sewa kostum/aksesoris.

**Fitur Utama Sistem:**

1. Create (Tambah Transaksi): Input data transaksi baru, pilih jenis paket foto, hitung otomatis total bayar, dan proses pembayaran dengan uang kembalian.

2. Read (Lihat Transaksi): Menampilkan seluruh rincian transaksi beserta detail pelanggan dan cetak struknya.

3. Update (Ubah Data): Mengubah data nama pelanggan, nomor telepon, atau jumlah lembar cetak berdasarkan ID Transaksi.

4. Delete (Hapus Transaksi): Menghapus data transaksi tertentu yang dibatalkan atau salah dari daftar.

5. Rekap Omset Studio: Menampilkan ringkasan total pendapatan studio dari seluruh transaksi yang berhasil.

6. Robust Input Validation (Looping Error Handling): Sistem dibekali validasi input sehingga tidak akan crash jika pengguna salah mengetik tipe data (misal: memasukkan huruf pada pilihan angka) atau mengosongkan input. Program akan otomatis meminta input ulang sampai benar.

# Alur Program

**1. Menu 1: Tambah Transaksi Baru (Create)**

a. Input Data Pelanggan: Kasir memasukkan nama pelanggan dan nomor telepon yang divalidasi agar tidak boleh kosong.

b. Pemilihan Paket & Parameter Foto: Kasir memilih salah satu dari 3 paket foto, menentukan durasi sesi foto (menit), serta jumlah lembar cetakan foto.

c. Input Opsi Khusus Paket: Sistem mengajukan pertanyaan fitur opsional sesuai paket yang dipilih, seperti frame warna kustom (Paket Basic Strip), filter foto & link softfile Google Drive (Paket VIP Digital), atau sewa aksesoris/kostum ekstra (Paket Event Group).

d. Kalkulasi Total Biaya: Total harga dihitung secara otomatis oleh sistem menggunakan konsep method overriding (hitungHargaTotal()).

e. Proses Pembayaran & Validasi Uang: Kasir memasukkan nominal uang pembayaran. Jika nominal kurang dari total biaya, sistem melakukan perulangan penginputan uang hingga nilainya mencukupi sebelum menghitung kembalian.

f. Penyimpanan Data & Auto Increment: Objek transaksi disimpan ke dalam ArrayList, nilai idCounter dinaikkan secara otomatis untuk transaksi berikutnya, dan sistem menampilkan pesan [SUCCESS]..

**2. Menu 2: Menampilkan Transaksi (Read)**

a. Pengecekan Ketersediaan Data: Sistem memeriksa status ArrayList. Apabila daftar transaksi masih kosong, sistem menampilkan pesan bahwa belum ada data yang terdaftar.

b. Iterasi & Pencetakan Polimorfis: Jika data tersedia, sistem menjalankan perulangan for-each untuk melintasi seluruh objek dan memanggil method tampilStruk() secara polimorfis.

c. Penyajian Struk Terstruktur: Layar mencetak rincian struk pembayaran lengkap secara rapi, mencakup ID transaksi, identitas pelanggan, jenis paket beserta fasilitas spesifiknya, jumlah cetakan, hingga total bayar akhir.

**3. Menu 3: Update Transaksi (Update)**

a. Validasi Awal & Input ID Sasaran: Sistem memastikan ketersediaan transaksi di memori, lalu meminta kasir memasukkan ID transaksi yang ingin diperbarui.

b. Pencarian Data (Linear Search): Sistem mencari ID yang cocok di dalam ArrayList. Jika ID tidak ditemukan, sistem menampilkan pesan peringatan.

c. Pengisian Data Baru & Setter Method: Jika ID ditemukan, kasir memasukkan nama baru, nomor telepon baru, dan jumlah cetak baru yang langsung diperbarui ke objek via method setter (setNama(), setNomorTelepon(), setJumlahCetak()).

d. Konfirmasi Tanpa Mengubah ID: Data diperbarui tanpa mengubah nomor ID transaksi awal yang sudah terbentuk, dilanjutkan dengan pesan konfirmasi bahwa pembaruan data berhasil.

**4. Menu 4: Hapus Transaksi (Delete)**

a. Pemeriksaan Data & Input ID: Kasir memasukkan ID transaksi yang hendak dibatalkan setelah sistem memastikan memori tidak kosong.

b. Penelusuran Indeks List: Sistem menelusuri ArrayList berdasarkan indeks untuk menemukan posisi objek dengan ID yang cocok.

c. Eksekusi Penghapusan: Jika ID ditemukan, objek dihapus dari daftar menggunakan remove(index) dan sistem menampilkan pesan konfirmasi keberhasilan.

d. Penanganan ID Tidak Valid: Jika ID transaksi tidak ditemukan di dalam daftar, sistem menginformasikan pesan peringatan dan membatalkan proses penghapusan secara aman.

**5. Menu 5: Rekap Omset Studio**

a. Akumulasi Pendapatan: Sistem mengiterasi seluruh transaksi di dalam ArrayList, menampilkan ringkasan ID, nama pelanggan, dan total bayar tiap transaksi, sambil menjumlahkan biayanya ke variabel total omset.

b. Penyajian Hasil Rekap: Sistem menampilkan daftar ringkas seluruh transaksi beserta nilai TOTAL OMSET STUDIO yang berhasil dikumpulkan.

c. Sistem Tetap Berjalan: Variabel perulangan utama tetap bernilai true sehingga setelah rekap ditampilkan, program tidak dihentikan melainkan langsung mengembalikan kasir ke tampilan menu utama.

**6. Menu 6: Keluar**

a. Penghentian Perulangan Utama: Kasir memilih menu 6, lalu sistem mengubah variabel kontrol berjalan menjadi false untuk menghentikan perulangan menu utama.

b. Pengosongan Sumber Daya: Sistem menutup objek Scanner untuk membebaskan alokasi input pada memori.

c. Terminasi Aplikasi: Sistem mencetak pesan terima kasih di layar konsol dan menghentikan seluruh eksekusi program Java secara aman dan bersih.

# Penjelasan Output
<img width="612" height="260" alt="image" src="https://github.com/user-attachments/assets/ea5252fc-f70d-44d5-b51a-6b59c7d2f19e" />

Tampilan screenshot di atas menunjukkan alur eksekusi penuh saat kasir melayani transaksi baru melalui Menu 1. Proses diawali dengan kasir memilih opsi nomor 1 pada menu utama, kemudian memasukkan identitas pelanggan berupa nama Jara dan nomor telepon 086754675467.   Selanjutnya, kasir memilih Paket Basic Strip (pilihan 1) berharga dasar Rp 35.000 dengan durasi foto 10 menit dan jumlah cetak 2 lembar. Kasir juga mengaktifkan fitur frame warna kustom dengan memilih opsi y, yang memberikan tambahan biaya kustomisasi sebesar Rp 5.000. Melalui pemanggilan metode hitungHargaTotal(), sistem secara otomatis mengkalkulasi keseluruhan biaya hingga menghasilkan Total Bayar sebesar Rp 40.000.   Proses diakhiri dengan kasir menginputkan nominal uang pembayaran dari pelanggan sebesar Rp 40.000, sehingga sistem mencatat nilai kembalian sebesar Rp 0. Setelah pembayaran terverifikasi mencukupi, sistem mencetak notifikasi [SUCCESS] yang menandakan bahwa objek transaksi baru telah berhasil disimpan ke dalam daftar memori ArrayList secara aman

<img width="622" height="269" alt="image" src="https://github.com/user-attachments/assets/6bb7a619-3d18-4113-b0f0-06f6284eeabc" />


<img width="613" height="274" alt="image" src="https://github.com/user-attachments/assets/af47e28a-b1bd-41ad-bd25-a7e0491d9ee4" />


<img width="613" height="344" alt="image" src="https://github.com/user-attachments/assets/d7599f4d-f4f6-4100-bf06-a91af3273664" />

<img width="620" height="119" alt="image" src="https://github.com/user-attachments/assets/5e251f8b-b831-4396-b265-74da330de4ca" />

<img width="616" height="183" alt="image" src="https://github.com/user-attachments/assets/9cfef7cb-8dff-4709-90b3-1c191e45b895" />

<img width="619" height="129" alt="image" src="https://github.com/user-attachments/assets/58a194c9-0b22-4e9b-8e81-23c2d2bf802a" />

<img width="611" height="147" alt="image" src="https://github.com/user-attachments/assets/5074c538-feef-4eeb-8e3b-68dc039e49a2" />

<img width="606" height="349" alt="image" src="https://github.com/user-attachments/assets/fc85bcc0-f17d-4b13-92ae-1c106cf5ed49" />

<img width="623" height="177" alt="image" src="https://github.com/user-attachments/assets/2c204054-f8ba-4b5d-8676-e8421ad17bb7" />

<img width="619" height="175" alt="image" src="https://github.com/user-attachments/assets/9ea16235-718a-4ac5-bf3c-5bd5036fc88a" />


