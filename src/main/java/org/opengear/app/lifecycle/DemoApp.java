package org.opengear.app.lifecycle;

public class DemoApp {


    public static void main(String[] args) {
        App app  = new App();

        app.addAppLifecycle(new AppLifecycle() {
            @Override
            public void start() {
                System.out.println("app started");
            }

            @Override
            public void stop() {
                System.out.println("app stopped");
            }
        });
        app.start();

        Thread t = new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (true) {
                    try {
                        i++;
                        if(i > 10){
                            app.stop();
                            return;
                        }
                        Thread.sleep(500);
                        System.out.println("Hello from thread");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t.setDaemon(true);
        t.start();
    }
}
