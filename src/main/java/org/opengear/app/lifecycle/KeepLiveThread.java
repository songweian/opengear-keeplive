package org.opengear.app.lifecycle;

public class KeepLiveThread extends Thread {

    public KeepLiveThread() {
        super("KeepLiveThread");
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(Integer.MAX_VALUE);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void shutdown() {
        interrupt();
    }

    public static void main(String[] args) {
        KeepLiveThread keepLiveThread = new KeepLiveThread();
        keepLiveThread.start();
    }
}
