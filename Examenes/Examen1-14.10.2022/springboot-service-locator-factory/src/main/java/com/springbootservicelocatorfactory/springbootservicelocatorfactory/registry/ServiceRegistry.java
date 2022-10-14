package com.springbootservicelocatorfactory.springbootservicelocatorfactory.registry;

public interface ServiceRegistry {
    public <T> AdapterService<T> getService(String serviceName);
}
