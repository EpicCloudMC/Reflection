package org.epiccloudmc.reflection.utils;

import org.epiccloudmc.reflection.objects.SafeClass;

public class Classes {

  public static SafeClass getClass(String name) {
    try {
      if (Validate.isNull(name)) {
        Loggers.warn("Trying to write to create a SafeClass with a null value may cause errors.");
      }
      return new SafeClass(Class.forName(name));
    } catch (Exception exception) {
      Loggers.severe("An error occured whilst attempting to find class " + name, exception);
      return null;
    }
  }
}
