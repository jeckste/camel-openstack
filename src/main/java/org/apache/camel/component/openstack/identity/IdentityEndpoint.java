package org.apache.camel.component.openstack.identity;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * Represents a Openstack endpoint.
 */
public class IdentityEndpoint extends DefaultEndpoint {

    public IdentityEndpoint() {
    }

    public IdentityEndpoint(String uri, IdentityComponent component) {
        super(uri, component);
    }

    public IdentityEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new IdentityProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new IdentityConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
}
