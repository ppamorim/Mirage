package com.jorgecastilloprz.mirage.bus;

/**
 * @author Jorge Castillo Pérez
 */
public interface EventBus {

  void post(final Object event);

  void register(Object object);

  void unregister(Object object);
}
