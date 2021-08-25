public class Main {

    public static void main(String[] args) {
        CarDealership carDealership = new CarDealership();
        AutoProducer autoProducer = new AutoProducer(null, "Tesla", carDealership);
        autoProducer.start();
        ThreadGroup buyers = new ThreadGroup("Покупатели");
        for (int i = 0; i < 2; i++) {
            new Buyer(buyers, "Покупатель " + (i + 1), carDealership).start();
        }
        while (carDealership.getSoldCars() < 10) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println();
            }
        }
        autoProducer.interrupt();
        buyers.interrupt();
    }
}


