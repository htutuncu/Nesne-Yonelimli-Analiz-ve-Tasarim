package b201210378;

public class SolEyleyici implements IEyleyici,IObserver{
    @Override
    public void sogutucuAc() {
        System.out.println("Sol taraftaki sogutucu calistirildi. Sicaklik dusuyor.");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sol taraftaki sogutucu kapatildi.");
    }

    @Override
    public void update() {
        System.out.println("Sol sogutucu kritik sogutma durumuna geciyor.");
    }
}
