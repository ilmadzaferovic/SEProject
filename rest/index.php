<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

use Firebase\JWT\JWT;
use Firebase\JWT\Key;

require_once __DIR__.'/../vendor/autoload.php';
require_once __DIR__.'/services/BookService.class.php';
require_once __DIR__.'/services/ChallengeService.class.php';
require_once __DIR__.'/services/CollageService.class.php';
require_once __DIR__.'/services/DnfRsnService.class.php';
require_once __DIR__.'/services/DnfService.class.php';
require_once __DIR__.'/services/ReviewService.class.php';
require_once __DIR__.'/services/UserService.class.php';
require_once __DIR__.'/dao/UserDao.class.php';

Flight::register('bookService', 'BookService');
Flight::register('challengeService', 'ChallengeService');
Flight::register('collageService', 'CollageService');
Flight::register('dnfrsnService', 'DnfRsnService');
Flight::register('dnfService', 'DnfService');
Flight::register('reviewService', 'ReviewService');
Flight::register('userService', 'UserService');
Flight::register('userDao', 'UserDao');

Flight::map('error', function(Exception $ex){
    // Handle error
    Flight::json(['message' => $ex->getMessage()], 500);
});

Flight::route('/*', function(){
    //perform JWT decode
    $path = Flight::request()->url;
    if ($path == '/login') return TRUE;
    if ($path == '/register') return TRUE; // exclude login route from middleware
  
    $headers = getallheaders();
    if (@!$headers['Authorization']){
      Flight::json(["message" => "Authorization is missing"], 403);
      return FALSE;
    }else{
      try {
        $decoded = (array)JWT::decode($headers['Authorization'], new Key(Config::JWT_SECRET(), 'HS256'));
        Flight::set('user', $decoded);
        return TRUE;
      } catch (\Exception $e) {
        Flight::json(["message" => "Authorization token is not valid"], 403);
        return FALSE;
      }
    }
  });

require_once __DIR__.'/routes/BookRoutes.php';
require_once __DIR__.'/routes/ChallengeRoutes.php';
require_once __DIR__.'/routes/CollageRoutes.php';
require_once __DIR__.'/routes/DnfRoutes.php';
require_once __DIR__.'/routes/DnfRsnRoutes.php';
require_once __DIR__.'/routes/ReviewRoutes.php';
require_once __DIR__.'/routes/UserRoutes.php';


Flight::start();
?>