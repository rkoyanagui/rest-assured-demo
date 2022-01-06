package com.rkoyanagui.rest_assured_demo.utils;

import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

public interface World extends AutoCloseable
{
  /**
   * Returns the value to which the specified key is mapped, or throws a new {@link
   * IllegalStateException} if this map contains no mapping for the key.
   *
   * @param key the key whose associated value is to be returned
   * @param <T> the class of the value
   * @return the value to which the specified key is mapped
   */
  <T> T get(String key);

  /**
   * Returns the value to which the specified key is mapped, wrapped in a {@link Optional}, since
   * this map may or may not contain a mapping for the key.
   *
   * @param key the key whose associated value is to be returned
   * @param <T> the class of the value
   * @return the value to which the specified key is mapped
   */
  <T> Optional<T> getOpt(String key);

  /**
   * Returns the value to which the specified key is mapped, or {@code defaultValue} if this map
   * contains no mapping for the key.
   *
   * @param key          the key whose associated value is to be returned
   * @param defaultValue the default mapping of the key
   * @param <T>          the class of the value
   * @return the value to which the specified key is mapped
   */
  <T> T get(String key, T defaultValue);

  /**
   * Returns the value to which the specified key is mapped, or invokes {@code defaultValueSupplier}
   * and returns the result of that invocation if this map contains no mapping for the key.
   *
   * @param key                  the key whose associated value is to be returned
   * @param defaultValueSupplier a {@code Supplier} whose result is returned if no value is present
   * @param <T>                  the class of the value
   * @return the value to which the specified key is mapped
   */
  <T> T get(String key, Supplier<T> defaultValueSupplier);

  /**
   * Returns a {@code Map} containing all key-value pairs.
   *
   * @return a {@code Map} containing all key-value pairs
   */
  Map<String, Object> getAll();

  /**
   * Associates the specified value with the specified key in this {@code World}. If the {@code
   * World} previously contained a mapping for the key, the old value is replaced by the specified
   * value.
   *
   * @param key   key with which the specified value is to be associated
   * @param value value to be associated with the specified key
   * @return this {@code World}
   */
  World put(String key, Object value);
}
