public class Buyer extends Thread {

    final CarDealership carDealership;
    final int TIME_FOR_MAKING_DECISION = 1000;

    public Buyer(ThreadGroup group, String name, CarDealership carDealership) {
        super(group, name);
        this.carDealership = carDealership;
    }

    @Override
    public void run() {
        buyCar();
    }

    public void buyCar() {
        try {
            while (!isInterrupted()) {
                System.out.println(Thread.currentThread().getName() + " зашел в автосалон");
                System.out.println(Thread.currentThread().getName() + " выбирает машину");
                Thread.sleep(TIME_FOR_MAKING_DECISION);
                System.out.println(Thread.currentThread().getName() + " определился с выбором");
                carDealership.sellCar();
            }
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " покинул автосалон в момент раздумий");
        }
    }
}


