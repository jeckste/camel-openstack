package org.apache.camel.component.openstack.networking;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link NetworkingEndpoint}.
 */
public class NetworkingComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new NetworkingEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
