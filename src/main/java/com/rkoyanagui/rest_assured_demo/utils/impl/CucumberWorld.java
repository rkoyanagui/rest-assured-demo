package com.rkoyanagui.rest_assured_demo.utils.impl;

import com.google.common.collect.ImmutableMap;
import com.rkoyanagui.rest_assured_demo.core.CucumberComponent;
import com.rkoyanagui.rest_assured_demo.utils.World;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@CucumberComponent
public class CucumberWorld implements World
{
  protected final Map<String, Object> map;

  public CucumberWorld()
  {
    this.map = new HashMap<>();
  }

  protected static <T> Optional<T> getAndCast(final Map<String, Object> map, final String key)
  {
    return Optional.ofNullable(map.get(key))
        .map(o -> {
          T t = null;
          try
          {
            t = (T) o;
          }
          catch (ClassCastException ignored)
          {
            // Empty catch block. It is just too much trouble to generify this class's get()
            // methods. You would have to either provide a Class<T> argument, or use some reflection
            // magicks. I just need these methods to return null if an object fails the test
            // 'obj instanceof T', that is, if a value is associated to a given key but its type is
            // different from T.
          }
          return t;
        });
  }

  @Override
  public <T> T get(final String key)
  {
    return CucumberWorld.<T>getAndCast(map, key)
        .orElseThrow(() -> new IllegalStateException("Missing key='" + key + "'!"));
  }

  @Override
  public <T> Optional<T> getOpt(String key)
  {
    return CucumberWorld.getAndCast(map, key);
  }

  @Override
  public <T> T get(final String key, final T defaultValue)
  {
    return CucumberWorld.<T>getAndCast(map, key).orElse(defaultValue);
  }

  @Override
  public <T> T get(final String key, final Supplier<T> defaultValueSupplier)
  {
    return CucumberWorld.<T>getAndCast(map, key).orElseGet(defaultValueSupplier);
  }

  @Override
  public Map<String, Object> getAll()
  {
    return ImmutableMap.copyOf(map);
  }

  @Override
  public World put(final String key, final Object value)
  {
    map.put(key, value);
    return this;
  }

  @Override
  public void close()
  {
    map.clear();
  }
}
