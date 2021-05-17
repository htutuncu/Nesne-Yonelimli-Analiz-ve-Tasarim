package b201210378;

import java.util.Random;

public class SagSicaklikAlgilayici implements ISicaklikAlgilayici {
    @Override
    public int sicaklikOku() {
        Random random = new Random();
        int sicaklik = random.nextInt(55);

        return sicaklik;
    }
}
