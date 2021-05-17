package b201210378;

public class Kullanici{
    private String kullaniciAdi;
    private String sifre;
    private String isim;

    public Kullanici(KullaniciBuilder builder){
        this.kullaniciAdi = builder.kullaniciAdi;
        this.isim = builder.isim;
        this.sifre = builder.sifre;
    }

    public String getKullaniciAdi(){
        return kullaniciAdi;
    }
    public String getSifre(){
        return sifre;
    }
    public String getIsim(){
        return isim;
    }




    public static class KullaniciBuilder{
        private String kullaniciAdi;
        private String sifre;
        private String isim;

        public KullaniciBuilder(){

        }

        public KullaniciBuilder kullaniciAdi(String kullaniciAdi){
            this.kullaniciAdi = kullaniciAdi;
            return this;
        }

        public KullaniciBuilder sifre(String sifre){
            this.sifre = sifre;
            return this;
        }

        public KullaniciBuilder isim(String isim){
            this.isim = isim;
            return this;
        }

        public Kullanici build(){
            return new Kullanici(this);
        }

    }
}
