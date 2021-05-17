package b201210378;

public class Cihaz implements ICihaz{

    private final IEyleyici eyleyici;
    private final ISicaklikAlgilayici sicaklikAlgilayici;

    public Cihaz(IEyleyici eyleyici, ISicaklikAlgilayici sicaklikAlgilayici){
        this.eyleyici = eyleyici;
        this.sicaklikAlgilayici = sicaklikAlgilayici;
    }

    @Override
    public int sicaklikOku() {
        return sicaklikAlgilayici.sicaklikOku();
    }

    @Override
    public void sogutucuAc() {
        eyleyici.sogutucuAc();
    }

    @Override
    public void sogutucuKapat() {
        eyleyici.sogutucuKapat();
    }


}
