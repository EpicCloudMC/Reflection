package org.epiccloudmc.reflection.utils;

public class Validate {

  public static Boolean isNull(Object... objects) {
    for (Object object : objects) {
      if (object == null) {
        return true;
      }
    }
    return false;
  }
}
