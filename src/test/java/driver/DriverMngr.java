package driver;

import org.openqa.selenium.WebDriver;

public class DriverMngr {
    private static ThreadLocal<WebDriver> dr = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverReferans) {
        dr.set(driverReferans);
    }

    public static void unload(){
        dr.remove();
}
}
