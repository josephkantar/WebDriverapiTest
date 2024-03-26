package driver;


import factory.DriverFactory;

import java.time.Duration;
import java.util.Objects;

public class Driver {

    private Driver() {
    }

    public static void initDriver() {
        if (Objects.isNull(DriverMngr.getDriver())) {
            DriverMngr.setDriver(DriverFactory.createDriver());
            DriverMngr.getDriver().manage().window().maximize();
            DriverMngr.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }

    public static void quitDriver() {
        if (Objects.nonNull(DriverMngr.getDriver())) {
            DriverMngr.getDriver().quit();
            DriverMngr.unload();

        }
    }
}
