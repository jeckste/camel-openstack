package org.apache.camel.component.openstack.telemetry;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * Represents a Openstack endpoint.
 */
public class TelemetryEndpoint extends DefaultEndpoint {

    public TelemetryEndpoint() {
    }

    public TelemetryEndpoint(String uri, TelemetryComponent component) {
        super(uri, component);
    }

    public TelemetryEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new TelemetryProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new TelemetryConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
}
