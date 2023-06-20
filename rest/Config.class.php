<?php

class Config {
  public static function DB_HOST() {
    return Config::get_env("DB_HOST", "127.0.0.1");
  }

  public static function DB_USERNAME() {
    return Config::get_env("DB_USERNAME", "ilma_dzaf123");
  }

  public static function DB_PASSWORD() {
    return Config::get_env("DB_PASSWORD", "ilmailmailma");
  }

  public static function DB_SCHEME() {
    return Config::get_env("DB_SCHEME", "reading_journal");
  }

  public static function DB_PORT() {
    return Config::get_env("DB_PORT", "3306");
  }

  public static function JWT_SECRET() {
    return Config::get_env("JWT_SECRET", "qfA0H7waHc");
  }

  public static function get_env($name, $default) {
    return isset($_ENV[$name]) && trim($_ENV[$name]) !== '' ? $_ENV[$name] : $default;
  }
}


