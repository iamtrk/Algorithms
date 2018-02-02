public class test {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        pthread a = new pthread(list);
        cthread b = new cthread(list);

        a.start();
        b.start();

    }
}

class pthread extends Thread {
    List<Integer> list;

    pthread(List<Integer> list) {
        this.list = list;
    }
    
    // CURRENT THREAD MUST GET THE LOCK ON THE TARGET OBJECT BEFORE IT CAN CALL wait()/ notify() or notifyAll() METHODS.

    public void run() {
        int n = 0;
        while (true) {
            synchronized (list) {
                if (list.size() == 2) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("Putting: "+n);
                list.add(n);
                n++;
                list.notifyAll();
                try {
                    Thread.sleep(1000);
                    System.out.println("producer waiting completed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // lock relinquishing happens here.
            }
        }

    }
}

class cthread extends Thread {
    List<Integer> list;

    cthread(List<Integer> list) {
        this.list = list;
    }

    public void run() {

        while (true) {
            synchronized (list) {
                if (list.isEmpty()) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Got:" +list.remove(0));
                // notifyAll doesn't relinquish the monitor here.
                list.notifyAll();
                try {
                    Thread.sleep(1000);
                    System.out.println("Consumer waiting completed");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // lock relinquishing happens here.
            }
        }

    }
}
