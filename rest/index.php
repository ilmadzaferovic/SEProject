<?php
ini_set('display_errors', 1);
ini_set('display_startup_errors', 1);
error_reporting(E_ALL);

require_once __DIR__.'/../vendor/autoload.php';
require_once __DIR__.'/services/BookService.class.php';
require_once __DIR__.'/services/ChallengeService.class.php';
require_once __DIR__.'/services/DnfService.class.php';
require_once __DIR__.'/services/ReviewService.class.php';


Flight::register('bookService', 'BookService');
Flight::register('challengeService', 'ChallengeService');
Flight::register('dnfService', 'DnfService');
Flight::register('reviewService', 'ReviewService');


  /* REST API documentation endpoint */
Flight::route('GET /docs.json', function(){
  $openapi = \OpenApi\scan('routes');
  header('Content-Type: application/json');
  echo $openapi->toJson();
});


require_once __DIR__.'/routes/BookRoutes.php';
require_once __DIR__.'/routes/ChallengeRoutes.php';
require_once __DIR__.'/routes/DnfRoutes.php';
require_once __DIR__.'/routes/ReviewRoutes.php';



Flight::start();
