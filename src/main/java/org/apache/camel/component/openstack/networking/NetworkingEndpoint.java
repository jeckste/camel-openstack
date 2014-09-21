package org.apache.camel.component.openstack.networking;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * Represents a Openstack endpoint.
 */
public class NetworkingEndpoint extends DefaultEndpoint {

    public NetworkingEndpoint() {
    }

    public NetworkingEndpoint(String uri, NetworkingComponent component) {
        super(uri, component);
    }

    public NetworkingEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new NetworkingProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new NetworkingConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
}
