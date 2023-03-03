package osgi_locationpublisher;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {
	
	ServiceRegistration publishServiceregistration;

	public void start(BundleContext context) throws Exception {
		LocationPublish service = new LocationPublishImpl();
		publishServiceregistration = context.registerService(LocationPublish.class.getName(), service, null);
        System.out.println("Location Service Started");
	} 

	public void stop(BundleContext bundleContext) throws Exception {
		publishServiceregistration.unregister();
	        System.out.println("Location Service Ended");
	}

}
