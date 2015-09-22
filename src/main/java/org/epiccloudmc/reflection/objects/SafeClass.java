package org.epiccloudmc.reflection.objects;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

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

  public SafeObject create(SafeObject... objects) {
    try {
      List<Class<?>> construct_classes = new ArrayList<Class<?>>();
      List<Object> construct_objects = new ArrayList<Object>();
      for (SafeObject object : objects) {
        construct_classes.add(object.getSafeClass().getInternalClass());
        construct_objects.add(object.getInternalObject());
      }
      Constructor<?> constructor =
          clazz.getConstructor(construct_classes.toArray(new Class<?>[construct_classes.size()]));
      Object value =
          constructor.newInstance(construct_objects.toArray(new Object[construct_objects.size()]));
      return SafeObject.create(value, false);
    } catch (Exception exception) {
      Loggers.severe("An error occured whilst attempting to create an instance of class: " + clazz,
          exception);
      return null;
    }
  }
}
