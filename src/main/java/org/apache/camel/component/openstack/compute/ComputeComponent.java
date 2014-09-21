package org.apache.camel.component.openstack.compute;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link ComputeEndpoint}.
 */
public class ComputeComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        ComputeConfiguration configuration = new ComputeConfiguration();
        setProperties(configuration, parameters);
        if (remaining == null || remaining.trim().length() == 0) {
            throw new IllegalArgumentException("endpoint must be specified.");
        }
        configuration.setEndpoint(remaining);
        
        if (configuration.getUsername() == null || configuration.getPassword() == null) {
            throw new IllegalArgumentException("Openstack username and password must be specified");
        }
    	Endpoint endpoint = new ComputeEndpoint(uri, this, configuration);
        return endpoint;
    }
}
