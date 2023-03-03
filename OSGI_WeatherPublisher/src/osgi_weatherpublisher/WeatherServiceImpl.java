package osgi_weatherpublisher;

public class WeatherServiceImpl implements WeatherService {

	@Override
	public String getWeatherInfo(String location) {
		return "The current weather is sunny.";
	}

}