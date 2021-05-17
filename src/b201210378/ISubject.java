package b201210378;

public interface ISubject {
    void attach(IObserver abone);
    void detach(IObserver abone);
    void notify(String mesaj,ICihaz cihaz);
}
