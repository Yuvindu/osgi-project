package osgi_locationsubscriber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import osgi_locationpublisher.LocationPublish;
import osgi_weatherpublisher.WeatherService;

public class Activator implements BundleActivator {

	private ServiceReference<LocationPublish> locationServiceReference;
	private ServiceReference<WeatherService> weatherServiceReference;
    private LocationPublish locationService;
    private WeatherService weatherService;

    public void start(BundleContext context) throws Exception {
        System.out.println("Location subscriber started.");
        locationServiceReference = context.getServiceReference(LocationPublish.class);
        weatherServiceReference = context.getServiceReference(WeatherService.class);
        if (locationServiceReference != null && weatherServiceReference != null) {
            locationService = context.getService(locationServiceReference);
            weatherService = context.getService(weatherServiceReference);
            List<String> locations = locationService.getLocations();
            System.out.println("Available locations: " + locations);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a location to get weather information: ");
            String location = br.readLine();
            String weather = weatherService.getWeatherInfo(location);
            System.out.println("Weather information for " + location + ": " + weather);
        } else {
            System.out.println("Location or weather service not found.");
        }
    }

    public void stop(BundleContext context) throws Exception {
        if (locationServiceReference != null) {
            context.ungetService(locationServiceReference);
        }
        if (weatherServiceReference != null) {
            context.ungetService(weatherServiceReference);
        }
        System.out.println("Location subscriber stopped.");
    }

}