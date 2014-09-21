package org.apache.camel.component.openstack.storage;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link StorageEndpoint}.
 */
public class StorageComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new StorageEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
