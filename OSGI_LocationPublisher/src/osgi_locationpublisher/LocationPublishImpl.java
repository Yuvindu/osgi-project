package osgi_locationpublisher;

import java.util.ArrayList;
import java.util.List;

public class LocationPublishImpl implements LocationPublish{

	@Override
	public List<String> getLocations() {
		List<String> locations = new ArrayList<String>();
        locations.add("Colombo");
        locations.add("Kandy");
        locations.add("Galle");
        // Add additional locations here
        return locations;
	}

}
