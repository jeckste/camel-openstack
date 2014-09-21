package org.apache.camel.component.openstack.identity;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link IdentityEndpoint}.
 */
public class IdentityComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new IdentityEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
