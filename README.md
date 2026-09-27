# Deskripsi Proyek

Sistem Kasir Photobooth merupakan aplikasi kasir berbasis Text User Interface (TUI) yang dirancang khusus untuk membantu pengelola studio foto dalam mengelola operasional transaksi harian secara akurat, cepat, dan efisien. Sistem ini hadir sebagai solusi pencatatan digital untuk meminimalisir risiko kesalahan manusia (human error), mempercepat proses pelayanan kasir, serta menyajikan data keuangan studio secara terstruktur.

Aplikasi ini mendukung penuh seluruh pengolahan data CRUD (Create, Read, Update, Delete) dan dilengkapi dengan fitur rekapitulasi omset studio secara real-time. Selain itu, sistem dapat menangani berbagai jenis paket photobooth yang memiliki skema perhitungan harga dan kustomisasi fasilitas berbeda—seperti penggunaan custom frame, opsi filter foto, pengiriman softfile via Google Drive, hingga persewaan kostum dan aksesoris ekstra.

Dikembangkan dengan menerapkan prinsip Pemrograman Berbasis Objek (OOP) seperti Inheritance dan Polymorphism, aplikasi ini juga dilapisi proteksi input validation berbasis helper loop dan penanganan eksepsi (try-catch). Hal ini memastikan sistem dapat berjalan dengan sangat stabil, ramah pengguna (user-friendly), dan bebas dari risiko crash meskipun kasir memasukkan tipe data yang salah atau mengosongkan input.

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

**1. Menu 1 Pilihan Basic Strip**

<img width="612" height="260" alt="image" src="https://github.com/user-attachments/assets/ea5252fc-f70d-44d5-b51a-6b59c7d2f19e" />

a. Input Identitas Pelanggan: Kasir memilih menu 1 lalu menginput nama pelanggan (Jara) dan nomor telepon (086754675467).

b. Pemilihan Paket & Hitung Otomatis: Kasir memilih Paket Basic Strip (10 menit, 2 lembar) dengan fitur frame custom (y), sehingga sistem menghitung Total Bayar: Rp 40.000 (Rp 35.000 harga dasar + Rp 5.000 biaya kustom).

c. Pembayaran & Simpan Data: Kasir menginput uang bayar Rp 40.000 (Kembalian Rp 0), lalu sistem menampilkan pesan [SUCCESS] tanda data transaksi telah berhasil disimpan ke memori ArrayList.

**2. Menu 1 Pilihan VIP Digital**

<img width="622" height="269" alt="image" src="https://github.com/user-attachments/assets/6bb7a619-3d18-4113-b0f0-06f6284eeabc" />

a. Input Identitas Pelanggan: Kasir memilih menu 1 lalu memasukkan nama pelanggan (Rifqy) dan nomor telepon (098756785467).

b. Pemilihan Paket & Hitung Otomatis: Kasir memilih Paket VIP Digital (pilihan 2) dengan durasi 15 menit, 5 lembar cetak foto, pilihan filter BW, dan tanpa tambahan softfile Google Drive (n). Sistem menghitung Total Bayar: Rp 80.000 (Rp 75.000 harga dasar + Rp 5.000 untuk tambahan 1 lembar cetak).

c. Pembayaran & Kembalian: Kasir menginput uang pembayaran Rp 90.000, sistem secara otomatis menghitung Kembalian: Rp 10.000, dan menampilkan notifikasi [SUCCESS] tanda transaksi berhasil disimpan ke memori ArrayList.   

**3. Menu 1 Pilihan Event Group**

<img width="613" height="274" alt="image" src="https://github.com/user-attachments/assets/af47e28a-b1bd-41ad-bd25-a7e0491d9ee4" />

a. Input Identitas & Paket: Kasir memilih menu 1 lalu menginput nama pelanggan (Vira), nomor telepon (097812435647), serta memilih Paket Event Group (pilihan 3) dengan durasi 20 menit, 8 lembar cetak, dan sewa kostum ekstra (y). Sistem secara otomatis menghitung Total Bayar: Rp 140.000 (Rp 120.000 harga dasar + Rp 20.000 sewa aksesoris/kostum).

b. Validasi Error Pembayaran (Looping): Saat kasir pertama kali menginput nominal Rp 100.000, sistem mendeteksi uang kurang, menampilkan pesan peringatan berwarna merah, dan melakukan looping otomatis untuk meminta masukan uang ulang tanpa membatalkan transaksi atau membuat program crash.

c. Pembayaran Ulang & Simpan Data: Kasir memasukkan ulang nominal yang cukup yaitu Rp 150.000. Sistem menghitung nilai Kembalian: Rp 10.000 dan menampilkan notifikasi [SUCCESS] tanda transaksi telah berhasil disimpan ke memori ArrayList

**4. Menu 2 Menampilkan Data Transaksi**

<img width="613" height="344" alt="image" src="https://github.com/user-attachments/assets/d7599f4d-f4f6-4100-bf06-a91af3273664" />

<img width="620" height="119" alt="image" src="https://github.com/user-attachments/assets/5e251f8b-b831-4396-b265-74da330de4ca" />

a. Membuka Daftar Transaksi: Kasir memilih menu 2 (Lihat Semua Transaksi) untuk mengecek seluruh riwayat pesanan yang telah tercatat di sistem.

b. Menampilkan Struk Lengkap: Sistem menampilkan bentuk struk pembayaran untuk setiap pelanggan (Jara, Rifqy, dan Vira) yang baru dimasukkan secara berurutan dan rapi.

c. Rincian Fasilitas & Total Bayar: Setiap struk memperlihatkan detail pesanan mulai dari nomor transaksi, nama pelanggan, jenis paket, fasilitas tambahan yang diambil, hingga total harga yang sudah dibayar.


**5. Menu 3 Update Data Transaksi**

<img width="616" height="183" alt="image" src="https://github.com/user-attachments/assets/9cfef7cb-8dff-4709-90b3-1c191e45b895" />

<img width="619" height="129" alt="image" src="https://github.com/user-attachments/assets/58a194c9-0b22-4e9b-8e81-23c2d2bf802a" />

a. Cari ID Transaksi: Kasir memilih menu 3 lalu memasukkan ID transaksi 1 milik pelanggan Jara. 

b. Penginputan Data Baru: Kasir memperbarui jumlah cetak foto menjadi 3 lembar, lalu sistem menampilkan notifikasi bahwa data ID 1 berhasil diperbarui.

c. Hasil Perubahan Struk: Pada struk transaksi, jumlah cetak foto otomatis berubah menjadi 3 lembar dan total bayar otomatis menyesuaikan dari Rp 40.000 menjadi Rp 50.000 karna ada penambahan strip.

**6. Menu 4 Delete Data Transaksi**

<img width="611" height="147" alt="image" src="https://github.com/user-attachments/assets/5074c538-feef-4eeb-8e3b-68dc039e49a2" />

<img width="606" height="349" alt="image" src="https://github.com/user-attachments/assets/fc85bcc0-f17d-4b13-92ae-1c106cf5ed49" />

a. Input ID yang Dihapus: Kasir memilih menu 4 (Hapus Transaksi) lalu memasukkan ID transaksi 3.

b. Konfirmasi Penghapusan: Sistem memproses penghapusan dan memberikan notifikasi [SISTEM] Transaksi ID 3 berhasil dihapus!. 

c. Verifikasi Daftar Terbaru: Saat kasir mengecek kembali daftar transaksi melalui menu 2, data transaksi ID 3 (Vira) sudah terhapus secara permanen dari daftar

**7. Menu 5 Rekap Omset Studio**

<img width="623" height="177" alt="image" src="https://github.com/user-attachments/assets/2c204054-f8ba-4b5d-8676-e8421ad17bb7" />

a. Akses Rekap Omset: Kasir memilih menu 5 (Lihat Rekap Omset Studio) untuk melihat ringkasan seluruh transaksi aktif dan total pendapatan studio.

b. Rincian Singkat Transaksi: Sistem menampilkan daftar transaksi aktif (ID 1 milik Jara sebesar Rp 50.000 dan ID 2 milik Rifqy sebesar Rp 80.000) secara ringkas.

c. Kalkulasi Total Omset: Sistem secara otomatis menjumlahkan seluruh transaksi tersebut dan menampilkan TOTAL OMSET STUDIO: Rp 130000

**8. Menu 6 Keluar**

<img width="619" height="175" alt="image" src="https://github.com/user-attachments/assets/9ea16235-718a-4ac5-bf3c-5bd5036fc88a" />

a. Akses Menu Keluar: Kasir memilih menu 6 (Keluar Program) saat jam operasional atau shift kerja telah selesai.

b. Pesan Penutup: Sistem menampilkan salam penutup "Terima kasih telah menggunakan Sistem Kasir Photobooth. Sampai jumpa!" dan menghentikan perulangan aplikasi secara aman.

c. Penghentian Sukses: Tampilan keterangan BUILD SUCCESS menandakan seluruh proses program berhasil diakhiri secara bersih tanpa adanya error atau crash.
