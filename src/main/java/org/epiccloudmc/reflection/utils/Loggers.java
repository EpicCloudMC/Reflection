package org.epiccloudmc.reflection.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Loggers {

  private static Logger logger = Logger.getLogger("Reflection");

  public static void log(Level level, String message) {
    logger.log(level, message);
  }

  public static void log(Level level, String message, Throwable throwable) {
    logger.log(level, message);
  }

  public static void info(String message) {
    log(Level.INFO, message);
  }

  public static void info(String message, Throwable throwable) {
    log(Level.INFO, message, throwable);
  }

  public static void warn(String message) {
    log(Level.WARNING, message);
  }

  public static void warn(String message, Throwable throwable) {
    log(Level.WARNING, message, throwable);
  }

  public static void severe(String message) {
    log(Level.SEVERE, message);
  }

  public static void severe(String message, Throwable throwable) {
    log(Level.SEVERE, message, throwable);
  }
}
