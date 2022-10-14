package com.springbootservicelocatorfactory.springbootservicelocatorfactory.registry;

public interface AdapterService<T> {
    public void process(T request);
}
