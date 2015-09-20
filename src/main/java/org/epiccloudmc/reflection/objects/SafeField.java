package org.epiccloudmc.reflection.objects;

import java.lang.reflect.Field;

import org.epiccloudmc.reflection.utils.Loggers;
import org.epiccloudmc.reflection.utils.Validate;

public class SafeField {

  private SafeObject object;
  private Field field;

  public SafeField(SafeObject object, Field field) {
    this.object = object;
    this.field = field;
  }

  public SafeObject getSafeObject() {
    return object;
  }

  public void write(Object value) {
    try {
      if (Validate.isNull(field)) {
        Loggers.warn("Trying to write to a field with a null value may cause errors.");
      }
      field.set(object.getObject(), value);
    } catch (Exception exception) {
      Loggers.severe("An error occured whilst attempting to write to field: " + field.getName(),
          exception);
    }
  }

  public SafeObject read() {
    try {
      if (Validate.isNull(field)) {
        Loggers.warn("Trying to write to a field with a null value may cause errors.");
      }
      return SafeObject.create(field.get(object.getObject()));
    } catch (Exception exception) {
      Loggers.severe("An error occured whilst attempting to read field: " + field.getName(),
          exception);
      return null;
    }
  }
}
