# Sistem Managemen Stock Barang
![daftar_barang](https://user-images.githubusercontent.com/81602971/123668356-39537780-d865-11eb-9c3b-8d921da34e95.PNG)

Deskripsi
------------------------------------------------------------------------------------
Sistem managemen stock barang adalah sebuah aplikasi web yang digunakan untuk mengelola transaksi barang masuk dan barang keluar dan dapat mengatur harga pada masing-masing barang.

Demo
------------------------------------------------------------------------------------
klik untuk melihat demo
https://system-management-stock.herokuapp.com/

| username | password |
| :---: | :---: |
| john | test123 | 

Spesifikasi
------------------------------------------------------------------------------------
- Eclipse IDE for Enterprise Java Developers Versi 2020-06
- Java JDK 8
- pgAdmin 4 (untuk database management system)

#### Teknologi yang digunakan
- Spring boot versi 2.4.3
- Thymeleaf (untuk template egine)
- SB Admin 2 (Web Template)
- PostgreSQL

Fitur
------------------------------------------------------------------------------------
1. Login & Registrasi 
	- Untuk saat ini hanya tersedia untuk admin
2. Daftar Barang
	- Tambah baru data nama barang dan harga barang
	- Menampilkan list data barang masuk & barang keluar serta jumlah barang saat ini
	- Update data barang
	- Hapus data barang
	- Cetak data daftar barang saat ini (format: Excel, CSV, PDF)
3. Transaksi Barang Masuk
	- Tambah baru data barang masuk
	- Menampilkan list data barang masuk dan tanggal transaksi barang masuk.
	- Update data barang masuk
	- Hapus data barang masuk
	- Cetak data barang masuk (format: Excel, CSV, PDF)
4. Transaksi Barang Keluar
	- Tambah baru data barang keluar
	- Menampilkan list data barang keluar dan tanggal transaksi barang keluar.
	- Update data barang keluar
	- Hapus data barang keluar.
	- Cetak data barang keluar (format: Excel, CSV, PDF)


Instalasi	
------------------------------------------------------------------------------------
#### Menggunakan Git
```bash
git clone https://github.com/SYHRL360/stock-management.git
```

#### Download ZIP
[download](https://github.com/SYHRL360/stock-management/archive/refs/heads/main.zip)

Setup
------------------------------------------------------------------------------------
#### Database configuration
1. Buka file `application.properties`
2. Ubah configurasi databese seperti berikut :
```
# PostgreSQL Connection
app.datasource.driverClassName=org.postgresql.Driver
app.datasource.jdbc-url=jdbc:postgresql://ec2-54-224-120-186.compute-1.amazonaws.com/d80il3apc0emvu
app.datasource.username=llsvnaiyaollgb
app.datasource.password=3fc3763bb53ac338c021e40153553b52c39221f64fdd68eb15b48aa1b976fefd
```
menjadi seperti berikut ini:
```
# PostgreSQL Connection
app.datasource.driverClassName=org.postgresql.Driver
app.datasource.jdbc-url=jdbc:postgresql://localhost:5432/portfolio_spring_inventory_db
app.datasource.username=postgres
app.datasource.password=password_pgadmin
```
3. Buka pgAdmin pada sidebar pilih `Database Name --> Schemas --> public`. 
4. Lalu klik kanan pada `public` pilih `Restore` dari menu dropdown menu.
5. Pada jendala yang terbuka arahkan ke file `stock_management_heroku.sql` yang ada pada folder postgres_dump.
6. Klik `Restore` dan pengaturan pada pgAdmin
7. Lakukan setep 3-6 pada setiap tabel yang ingin di import.


#### Jalankan Aplikasi
1. Buka Eclipse IDE
2. Pilih `File -> Import -> Maven -> Existing Maven project`
3. Klik kanan pada project dan klik `Run As -> Maven install` untuk mengenerate file.
4. Untuk menjalankan aplikasi klik kanan pada file yang memiliki main method pilih `Run As -> Java Application`
5. Buka browser lalu kunjungi http://localhost:8080

Screen Shoot
------------------------------------------------------------------------------------
1. Halaman Login
![halaman_login](https://user-images.githubusercontent.com/81602971/123669531-62c0d300-d866-11eb-80e4-dc27eb22a010.PNG)

2. Halaman Dashboard
![halaman_dashboard](https://user-images.githubusercontent.com/81602971/123669888-ca771e00-d866-11eb-8486-4443a182da99.PNG)

3. Daftar Barang
![daftar_barang](https://user-images.githubusercontent.com/81602971/123669638-7ff5a180-d866-11eb-83fc-efc40af06deb.PNG)

4. Form Barang Masuk
![form_produk_masuk](https://user-images.githubusercontent.com/81602971/123669720-94399e80-d866-11eb-832c-1de3d560f9b7.PNG)

5. Export Tabel Barang
![export_barang](https://user-images.githubusercontent.com/81602971/123669809-b03d4000-d866-11eb-8265-9dceb21b0223.PNG)

License
------------------------------------------------------------------------------------
[MIT License](https://opensource.org/licenses/MIT)

