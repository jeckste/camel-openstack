package org.apache.camel.component.openstack.image;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.impl.DefaultEndpoint;

/**
 * Represents a Openstack endpoint.
 */
public class ImageEndpoint extends DefaultEndpoint {

    public ImageEndpoint() {
    }

    public ImageEndpoint(String uri, ImageComponent component) {
        super(uri, component);
    }

    public ImageEndpoint(String endpointUri) {
        super(endpointUri);
    }

    public Producer createProducer() throws Exception {
        return new ImageProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        return new ImageConsumer(this, processor);
    }

    public boolean isSingleton() {
        return true;
    }
}
