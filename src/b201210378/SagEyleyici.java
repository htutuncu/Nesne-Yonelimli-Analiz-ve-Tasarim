package b201210378;

public class SagEyleyici implements IEyleyici,IObserver{
    @Override
    public void sogutucuAc() {
        System.out.println("Sag taraftaki sogutucu calistirildi. Sicaklik dusuyor.");
    }

    @Override
    public void sogutucuKapat() {
        System.out.println("Sag taraftaki sogutucu kapatildi.");
    }

    @Override
    public void update() {
        System.out.println("Sag sogutucu kritik sogutma durumuna geciyor.");
    }
}
