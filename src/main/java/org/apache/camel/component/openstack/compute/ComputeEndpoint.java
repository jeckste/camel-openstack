package org.apache.camel.component.openstack.compute;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;
import org.openstack4j.api.OSClient;
import org.openstack4j.openstack.OSFactory;

/**
 * Represents a Openstack endpoint.
 */
public class ComputeEndpoint extends DefaultEndpoint {
	
	ComputeConfiguration configuration;
	private OSClient osClient;

    public ComputeEndpoint(ComputeConfiguration configuration) {
    	this.configuration = configuration;
    }

    public ComputeEndpoint(String uri, ComputeComponent component, ComputeConfiguration configuration) {
        super(uri, component);
        this.configuration = configuration;
    }

    public ComputeEndpoint(String endpointUri, ComputeConfiguration configuration) {
        super(endpointUri);
        this.configuration = configuration;
    }

    public Producer createProducer() throws Exception {
        return new ComputeProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new ComputeConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
    
	public OSClient getOsClient() {
		if(osClient == null) {
			osClient = createOsClient();
		}
		return osClient;
	}
	public void setOsClient(OSClient osClient) {
		this.osClient = osClient;
	}
    
    public OSClient createOsClient() {
    	if(configuration.getVersion().equals("2")) {
    		return OSFactory.builder()
            .endpoint("http://" + configuration.getEndpoint() + "/v2.0")
            .credentials(configuration.getUsername(),configuration.getPassword())
            .tenantName(configuration.getTenantName())
            .authenticate();
    	}
    	else if(configuration.getVersion().equals("3")) {
//    		return OSFactory.builderV3()
//            .endpoint("https://region-a.geo-1.identity.hpcloudsvc.com:35357/v3")
//            .credentials("admin","sample")
//            .domainName("324434234-HP-Domain")
//            .authenticate();
    		return null;
    	}
    	return null;
    }
}
