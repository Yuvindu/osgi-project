package osgi_weatherpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

    private ServiceRegistration<WeatherService> registration;

    public void start(BundleContext context) throws Exception {
        System.out.println("Weather service started.");

        // Create an instance of the WeatherServiceImpl class
        WeatherService weatherService = new WeatherServiceImpl();

        // Register the service with the framework
        registration = context.registerService(WeatherService.class, weatherService, null);
        System.out.println("WeatherService published");
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Weather service stopped.");

        // Unregister the service from the framework
        registration.unregister();
    }
}





