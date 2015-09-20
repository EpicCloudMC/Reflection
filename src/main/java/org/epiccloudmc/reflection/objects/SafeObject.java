package org.epiccloudmc.reflection.objects;

import org.epiccloudmc.reflection.utils.Loggers;
import org.epiccloudmc.reflection.utils.Validate;

public class SafeObject {

  private SafeClass clazz;
  private Object object;

  public SafeObject(SafeClass clazz, Object object) {
    this.clazz = clazz;
    this.object = object;
  }

  public SafeClass getSafeClass() {
    return clazz;
  }

  public Object getObject() {
    return object;
  }

  public SafeField getField(String name) {
    try {
      if (Validate.isNull(name)) {
        Loggers.warn("Trying to create a SafeField with a null value may cause errors.");
      }
      return new SafeField(this, clazz.getInternalClass().getDeclaredField(name));
    } catch (Exception exception) {
      Loggers.severe("An error occured whilst attempting to find field: " + name, exception);
      return null;
    }
  }

  public static SafeObject create(Object value) {
    if (Validate.isNull(value)) {
      Loggers.warn("Trying to create a SafeObject with a null value may cause errors.");
    }
    return new SafeObject(new SafeClass(value.getClass()), value);
  }
}
