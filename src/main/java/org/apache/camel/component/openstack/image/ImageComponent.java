package org.apache.camel.component.openstack.image;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link ImageEndpoint}.
 */
public class ImageComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new ImageEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
