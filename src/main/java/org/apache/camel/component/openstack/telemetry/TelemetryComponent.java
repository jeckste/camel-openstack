package org.apache.camel.component.openstack.telemetry;

import java.util.Map;

import org.apache.camel.Endpoint;
import org.apache.camel.impl.DefaultComponent;

/**
 * Represents the component that manages {@link TelemetryEndpoint}.
 */
public class TelemetryComponent extends DefaultComponent {

    protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
        Endpoint endpoint = new TelemetryEndpoint(uri, this);
        setProperties(endpoint, parameters);
        return endpoint;
    }
}
