package org.epiccloudmc.reflection.objects;

import org.epiccloudmc.reflection.utils.Loggers;
import org.epiccloudmc.reflection.utils.Validate;

public class SafeClass {

  private Class<?> clazz;

  public SafeClass(Class<?> clazz) {
    this.clazz = clazz;
  }

  public Class<?> getInternalClass() {
    return clazz;
  }

  public SafeObject create() {
    try {
      if (Validate.isNull(clazz)) {
        Loggers.warn("Trying to create a SafeObject with a null value may cause errors.");
      }
      return new SafeObject(this, clazz.newInstance());
    } catch (Exception exception) {
      Loggers.severe("An error occured whilst attempting to create an instance of class: " + clazz,
          exception);
      return null;
    }
  }
}
