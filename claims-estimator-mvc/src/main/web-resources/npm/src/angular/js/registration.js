var registrationService = angular.module('registrationService', [ 'ngResource' ]);
var registrationControllers = angular.module('registrationControllers',	[]);

var registrationApp = angular.module('registrationApp',	['registrationControllers', 'registrationService']);