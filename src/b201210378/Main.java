package b201210378;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        while(true){
            if(Arayuz.GirisYap(new VeritabaniPostgreSQL())) {
                Arayuz.ArayuzuGoster();
                break;
            }else
                System.out.println("\nTekrar deneyin !");
        }
    }
}
