<?php

class Config {
  public static function DB_HOST() {
    return Config::get_env("DB_HOST", "bmyiipw9suhxvh8yzjvw-mysql.services.clever-cloud.com");
  }

  public static function DB_USERNAME() {
    return Config::get_env("DB_USERNAME", "u7onjaueqfjdads9");
  }

  public static function DB_PASSWORD() {
    return Config::get_env("DB_PASSWORD", "xt6wOmJgCVCKOM15i7Bc");
  }

  public static function DB_SCHEME() {
    return Config::get_env("DB_SCHEME", "bmyiipw9suhxvh8yzjvw");
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


