/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bengkelproject;

import java.util.Scanner;

public class ProgramBengkel {

    static String nama, nomor_plat,jenis_motor,pilih_oli,output;
    static int  hargaOli,hargaSparepart;
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Outputpembuat();
        String simpan;
        int a = 0;
        do {
            BacaIdentitas();
            int motor_pengguna=jenisMotor();
            String layanan= layanan_1(motor_pengguna);
            String sparepart = input_Sparepart();
            String catatan = keluhanUser();
            int harga = hargaTotal(layanan,motor_pengguna);
            Output(jenis_motor,layanan,catatan,sparepart,harga);//int motor, String layanan,String keluhan, String sparepart,int harga_total
            System.out.print("\n Apakah data sudah benar? Y/N ");
            System.out.println("                                                                                              exit program : x");
            System.out.print(" ");
            simpan = input.next();
            if(simpan.equalsIgnoreCase("y")){
                a++;
                System.out.println("Nomor Antrian : "+a);
            }
            else if(simpan.equalsIgnoreCase("n")){
                System.out.println("Nomor Antrian : - ");
            }
            System.out.println("Nomor Antrian : ");
        } while (simpan.equalsIgnoreCase("y") || simpan.equalsIgnoreCase("n"));
    }

    static void BacaIdentitas() {
        System.out.println("\n\n");
        System.out.println("        SELAMAT DATANG DI AHHAY,HADIR UNTUK MEMBANTU MASALAH MOTOR ANDA\n" +"   ____________________________________________________________________________");
        System.out.print("\nMasukkan Nama Anda        : ");
        nama = input.next();
        System.out.print("Masukkan Nomor Plat Motor : ");
        nomor_plat = input.next();
    }
    static int jenisMotor(){
        System.out.println();
        System.out.println("Jenis motor :");
        String[] jenisMotor = {" Matic\n" , " Manual"};
        for (int i = 0; i < jenisMotor.length; i++) {
            System.out.print((i + 1) + "." + jenisMotor[i]);
        }
        System.out.print("\n Apakah jenis motor anda? ");
        String n = input.next();
        int jm = (Integer.valueOf(n));
        jenis_motor = jenisMotor[jm - 1];
        return jm;
    }
    
    // d = jenis motor
    //program untuk layanan
    static String layanan_1(int d) {
        System.out.println("\nLayanan Kami : ");
        String[] layanan = {"Servis\n", "Ganti oli\n" ,"Servis dan Ganti oli\n"};
        for (int i = 0; i < layanan.length; i++) {
            System.out.print((i + 1) + "." + layanan[i]);
        }
        System.out.print(" Pilih layanan : ");
        String pilihan1 = input.next();
        int pil_1 = (Integer.valueOf(pilihan1));
        if (pil_1>0 || pil_1<=3) {   //untuk mencegah eror saat masukan input
        } else {
            System.out.print(" Masukkan pilihan kembali : ");
            pilihan1 = input.next();
        }
        pil_1 = (Integer.valueOf(pilihan1));
        String pilih_layanan1 = layanan[pil_1 - 1];
        pil_oli(pil_1,d);
        return pilih_layanan1;
    }

    static void pil_oli(int pil_1,int d){
        if (d==1){
            input_oliMatic(pil_1);
        }
        else if (d==2){
            input_oliManual(pil_1);
        }
}
    
    //program untuk oli
    static String input_oliMatic(int n) {
        if(n==2||n==3){         //percabangan jika pilihan layanan memilih oli dan servis oli
        System.out.println("\nPilih Pergantian Oli");
        String[] oli = {"Oli Mesin\n", "Oli gardan\n", "Oli Mesin dan Gardan\n"};
        for (int i = 0; i < oli.length; i++) {
            System.out.print((i + 1) + "." + oli[i]);
        }
        System.out.print(" Masukkan pilihan : ");
        String pilihOli = input.next();
        int pil_oli = (Integer.valueOf(pilihOli));
        if (pil_oli>0 || pil_oli<=3) {
        } else {
            System.out.print(" Masukkan pilihan kembali : ");
            pilihOli = input.next();
            pil_oli = (Integer.valueOf(pilihOli));
        }
        input_hargaOli1(pil_oli);
        pilih_oli = oli[pil_oli - 1];
        }
        else {                  //percabangan jika pilihan layanan hanya servis
            pilih_oli = "-";
        }
        return pilih_oli;
    }

    static String input_oliManual(int n) {
        if(n==2||n==3){
        System.out.println("\nPilih Pergantian Oli");
        String[] oli = {"Oli Mesin\n","Oli Transmisi\n","Oli Mesin dan Transmisi\n"};
        for (int i = 0; i < oli.length; i++) {
            System.out.print((i + 1) + "." + oli[i]);
        }
        System.out.print(" Masukkan pilihan : ");
        String pilihOli = input.next();
        int pil_oli = (Integer.valueOf(pilihOli));
        if (pil_oli>0 || pil_oli<=3) {
        } else {
            System.out.print(" Masukkan pilihan kembali : ");
            pilihOli = input.next();
            pil_oli = (Integer.valueOf(pilihOli));
        }
        input_hargaOli2(pil_oli);
        pilih_oli = oli[pil_oli - 1];
        }
        else {
            pilih_oli = "-";
        }
        return pilih_oli;
    }
    
    //program untuk sparepart
    static String input_Sparepart() {
        String[] sparepart = {"  Busi", "  Ban dalam depan","  Ban dalam belakang","  Ban luar depan",
                              "  Ban luar belakang","  Rantai", "  Drive Belt", "  Coolant", "  Kampas rem", 
                              " Filter udara", " Aki", " Perbersihan CVT", " Lampu depan"," Lampu belakang",
                              " Lampu seign"," Kampas kopling"," Gir depan"," Gir belakang"," Tidak ada"};
        System.out.println("\nPergantian Sparepart");
        for (int i = 0; i < sparepart.length; i++) {
            System.out.print((i + 1) + "." + sparepart[i]+"\n");
        }
        System.out.print(" Masukkan pilihan : ");
        int n = input.nextInt();
        input_hargaSparepart(n);
        String pilihan = sparepart[n - 1];
        String pil_spare = " ";
        pil_spare = pilihan ;
        if (n > 0 && n < sparepart.length) {
            String jawab2 = "";
            System.out.println("\n Adakah tambahan lainnya (Y/N)?");
            System.out.print(" ");
            String jawab = input.next();
            do {
                if (jawab.equalsIgnoreCase("y")) {
                    System.out.print("\n Masukkan tambahan : ");
                    int x = input.nextInt();
                    if (n > 0 && n < sparepart.length){
                    input_hargaSparepart(x);
                    pilihan = sparepart[x - 1];
                    }
                    else{
                       pil_spare =" -\n"; 
                    }
                    pil_spare += (","+pilihan);
                    System.out.println("\n Adakah tambahan lainnya (Y/N)?");
                    System.out.print(" ");
                    jawab2 = input.next();
                }
            } while (jawab2.equalsIgnoreCase("y"));
        }
        else{
            pil_spare =" -\n";
        }
        String pilihan_spare = pil_spare;
        return pilihan_spare;
    }
    
    //program untuk keluhan
    static String keluhanUser() {
        System.out.println("\n Catatan performa motor anda ? (silahkan tulis di bawah)");
        System.out.print(" ");
        String keluhan = input.next();
        return keluhan;
    }
    
    
    //program untuk harga
    static int input_hargaOli1(int b1){
        int harga_oli=0;
        switch (b1) {
            case 1:
                harga_oli = 28200 ;
                break;
            case 2:
                harga_oli = 35000 ;
                break;
            case 3:
                harga_oli = 28200+35000;
                break;
            default:
                break;
        }
        hargaOli=harga_oli;
        return harga_oli;
    }
        
    
     static int input_hargaOli2(int b2){
        int harga_oli=0;
        switch (b2) {
            case 1:
                harga_oli = 35000 ;
                break;
            case 2:
                harga_oli = 30000 ;
                break;
            case 3:
                harga_oli = 35000+30000;
                break;
            default:
                break;
        }
        
        return harga_oli;
    }
     
     
    static int input_hargaSparepart(int a){//a = pilihan sparepart 
        int harga_sparepart = 0;
        switch (a) {
            case 1:
                harga_sparepart = harga_sparepart + 13200;
                break;
            case 2:
                harga_sparepart = harga_sparepart + 24700;
                break;
            case 3:
                harga_sparepart = harga_sparepart + 30600;
                break;
            case 4:
                harga_sparepart = harga_sparepart + 160000;
                break;
            case 5:
                harga_sparepart = harga_sparepart + 201500;
                break;
            case 6:
                harga_sparepart = harga_sparepart + 65000;
                break;
            case 7:
                harga_sparepart = harga_sparepart + 133000;
                break;
            case 8:
                harga_sparepart = harga_sparepart + 38500;
                break;
            case 9:
                harga_sparepart = harga_sparepart + 53000;
                break;
            case 10:
                harga_sparepart = harga_sparepart + 51000;
                break;
            case 11:
                harga_sparepart = harga_sparepart + 284000;
                break;
            case 12:
                harga_sparepart = harga_sparepart + 45000;
                break;
            case 13:
                harga_sparepart = harga_sparepart + 25000;
                break;
            case 14:
                harga_sparepart = harga_sparepart + 13500;
                break;
            case 15:
                harga_sparepart = harga_sparepart + 51000;
                break;
            case 16:
                harga_sparepart = harga_sparepart + 480000;
                break;
            case 17:
                harga_sparepart = harga_sparepart + 35500;
                break;
            case 18:
                harga_sparepart = harga_sparepart + 132000;
                break;
            default:
                harga_sparepart = harga_sparepart + 0;
                break;
        }
        hargaSparepart=harga_sparepart;
        return harga_sparepart;
    }
    static int hargaTotal(String layanan,int motor){
        int harga_total;
        if(layanan.equals("Ganti oli\n")){
            harga_total = 0;
        }
        else if (layanan.equals("Servis\n")) {
            if(motor==1){
            harga_total = 65000;
            }
            else if (motor==2){
            harga_total = 85000;    
            }
        }
            harga_total=hargaOli+hargaSparepart;
        return harga_total;
    }
    
    static void Output(String motor, String layanan,String keluhan, String sparepart,int harga_total) {
        System.out.println();
        System.out.println("\t                     DATA SERVIS             ");
        System.out.println("\t         ------------------------------------");
        System.out.println("\t | Nama                \t:  " + nama);
        System.out.println("\t | No plat motor       \t:  " + nomor_plat);
        System.out.print("\t | Jenis motor         \t: " + motor);
        System.out.print("\t | Layanan             \t:  " + layanan);
        System.out.print("\t | Pergantian oli      \t:  " + pilih_oli);
        System.out.print("\t | Pergantian sparepart\t: "+sparepart+"\n");
        System.out.print("\t | Perkiraan Biaya     \t: ");
        System.out.println(" Rp. " + harga_total+" *");
        System.out.println("\t | Keluhan performa  \t:  " + keluhan);
        System.out.println("\n \t * biaya dapat berubah jika ada saran pergantian sparepart oleh mekanik");
        System.out.println("\t        -------------------------------------");
    }
    
    static void Outputpembuat(){
        System.out.println(" ______________________________________________");
        System.out.println("| Kelompok D :                                 |");
        System.out.println("| 1 Gerardus Kristha Bayu Indraputra 215314004 |\n"+
                           "| 2. Davino Triyono 215314013                  |\n"+
                           "| 3. Mikael Oktavian Dwi Sukmadianto 215314029 |");
        System.out.println(" _______________________________________________\n");

    }
}
