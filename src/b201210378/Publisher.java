package b201210378;

import java.util.ArrayList;
import java.util.List;

public class Publisher implements ISubject{

    private List<IObserver> eyleyiciler;

    public Publisher(){
        eyleyiciler = new ArrayList<>();
    }

    @Override
    public void attach(IObserver eyleyici) {
        eyleyiciler.add(eyleyici);
    }

    @Override
    public void detach(IObserver eyleyici) {
        eyleyiciler.remove(eyleyici);
    }

    @Override
    public void notify(String mesaj,ICihaz cihaz) {
        System.out.println(mesaj);
        for(IObserver observer : eyleyiciler){
            observer.update();
        }
    }
}
