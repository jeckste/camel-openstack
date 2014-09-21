package org.apache.camel.component.openstack.storage;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * Represents a Openstack endpoint.
 */
public class StorageEndpoint extends DefaultEndpoint {

    public StorageEndpoint() {
    }

    public StorageEndpoint(String uri, StorageComponent component) {
        super(uri, component);
    }

    public StorageEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new StorageProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new StorageConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
}
