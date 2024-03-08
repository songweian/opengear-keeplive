package org.opengear.app.lifecycle;

import java.util.ArrayList;
import java.util.List;

public class App {

    KeepLiveThread keepLiveThread = new KeepLiveThread();
    private List<AppLifecycle> appLifecycles = new ArrayList<>();

    public void start() {
        keepLiveThread.start();
        appLifecycles.forEach(AppLifecycle::start);
    }

    public void addAppLifecycle(AppLifecycle appLifecycle) {
        appLifecycles.add(appLifecycle);
    }

    public void stop() {
        appLifecycles.forEach(AppLifecycle::stop);
        keepLiveThread.interrupt();
    }
}
