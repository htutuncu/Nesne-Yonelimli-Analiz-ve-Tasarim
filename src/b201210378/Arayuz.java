package b201210378;

import java.util.Scanner;

public class Arayuz {


    public static boolean GirisYap(IVeritabaniBaglantisi veritabaniBaglantisi){

        Scanner sc = new Scanner(System.in);
        System.out.println("Hosgeldiniz ! ");
        System.out.println("Kullanici Adi giriniz: ");
        String kullaniciAdi = sc.nextLine();
        System.out.println("Sifre giriniz: ");
        String sifre = sc.nextLine();

        Kullanici kullanici = new Kullanici.KullaniciBuilder()
                .kullaniciAdi(kullaniciAdi)
                .sifre(sifre)
                .build();


        return veritabaniBaglantisi.girisDogrula(kullanici);
    }

    public static void ArayuzuGoster() throws InterruptedException {

        System.out.println("Secim yapiniz. \n 1 - Cihazi ac\n 2 - Oturumu kapat ve cik");
        Scanner sc = new Scanner(System.in);
        int secim = sc.nextInt();
        if( secim != 1 ){
            System.out.println("Oturum kapatiliyor ...");
            return;
        }
        Publisher publisher = new Publisher();
        System.out.println("Cihaz aciliyor...");
        Thread.sleep(500);
        Cihaz cihaz = new Cihaz(new SagEyleyici(),new SolSicaklikAlgilayici());
        publisher.attach(new SagEyleyici());
        publisher.attach(new SolEyleyici());
        while (true){
            System.out.println("1 - Sag tarafin sicakligini oku");
            System.out.println("2 - Sol tarafin sicakligini oku");
            System.out.println("3 - Sogutucuyu ac");
            System.out.println("4 - Sogutucuyu kapat");
            System.out.println("5 - Oturumu ve cihazi kapat");
            secim = sc.nextInt();
            if( secim == 1){
                cihaz = new Cihaz(new SagEyleyici(),new SagSicaklikAlgilayici());
                int sicaklik = cihaz.sicaklikOku();
                System.out.println("Sag taraftaki sicaklik : "+ sicaklik + "°C");
                if(sicaklik>40){
                    publisher.notify("Kritik sicaklik algilandi. Tum sogutucular devreye aliniyor",cihaz);
                    System.out.println("Sicaklik dusuruldu. Yeni sicaklik = " + (sicaklik - 20) +  "°C");
                }

            }else if( secim == 2){
                cihaz = new Cihaz(new SolEyleyici(),new SolSicaklikAlgilayici());
                int sicaklik = cihaz.sicaklikOku();
                System.out.println("Sol taraftaki sicaklik : "+ sicaklik + "°C");
                if(sicaklik>40){
                    publisher.notify("Kritik sicaklik algilandi. Tum sogutucular devreye aliniyor",cihaz);
                    System.out.println("Sicaklik dusuruldu. Yeni sicaklik = " + (sicaklik - 20) +  "°C");
                }
            }else if( secim == 3){
                cihaz.sogutucuAc();
            }else if( secim == 4){
                cihaz.sogutucuKapat();
            }else if( secim == 5){
                System.out.println("Oturum kapatiliyor...");
                Thread.sleep(500);
                System.out.println("Cihaz kapatiliyor...");
                Thread.sleep(500);
                System.out.println("Hoscakalin !");
                break;
            }
        }
    }
}
