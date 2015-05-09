var registrationService = angular.module('registrationService', [ 'ngResource' ]);
var registrationControllers = angular.module('registrationControllers',	[]);

var registrationApp = angular.module('registrationApp',	['registrationControllers', 'registrationService']);

registrationService.factory('Registration', ['$resource', function($resource) {
	return  $resource('/claims-estimator-mvc/service/userregistration', {},{
		save : { method:'POST' }		
	});	
}]);

registrationService.factory("State", ["$q", "$timeout", function($q, $timeout) {
	return {
		getMyState : function() {
			var deferred = $q.defer();
			$timeout(function() { // WE USE A TIMER TO DO THE SIMULATION
				var s = "NY";
				deferred.resolve(s);
			}, 2000);
			return deferred.promise;
		},
		getStates: function() {
			var deferred = $q.defer();
			$timeout(function() { // WE USE A TIMER TO DO THE SIMULATION
				var data = [{"name":"Alabama","abbreviation":"AL"},{"name":"Alaska","abbreviation":"AK"},{"name":"American Samoa","abbreviation":"AS"},{"name":"Arizona","abbreviation":"AZ"},{"name":"Arkansas","abbreviation":"AR"},{"name":"California","abbreviation":"CA"},{"name":"Colorado","abbreviation":"CO"},{"name":"Connecticut","abbreviation":"CT"},{"name":"Delaware","abbreviation":"DE"},{"name":"District Of Columbia","abbreviation":"DC"},{"name":"Federated States Of Micronesia","abbreviation":"FM"},{"name":"Florida","abbreviation":"FL"},{"name":"Georgia","abbreviation":"GA"},{"name":"Guam","abbreviation":"GU"},{"name":"Hawaii","abbreviation":"HI"},{"name":"Idaho","abbreviation":"ID"},{"name":"Illinois","abbreviation":"IL"},{"name":"Indiana","abbreviation":"IN"},{"name":"Iowa","abbreviation":"IA"},{"name":"Kansas","abbreviation":"KS"},{"name":"Kentucky","abbreviation":"KY"},{"name":"Louisiana","abbreviation":"LA"},{"name":"Maine","abbreviation":"ME"},{"name":"Marshall Islands","abbreviation":"MH"},{"name":"Maryland","abbreviation":"MD"},{"name":"Massachusetts","abbreviation":"MA"},{"name":"Michigan","abbreviation":"MI"},{"name":"Minnesota","abbreviation":"MN"},{"name":"Mississippi","abbreviation":"MS"},{"name":"Missouri","abbreviation":"MO"},{"name":"Montana","abbreviation":"MT"},{"name":"Nebraska","abbreviation":"NE"},{"name":"Nevada","abbreviation":"NV"},{"name":"New Hampshire","abbreviation":"NH"},{"name":"New Jersey","abbreviation":"NJ"},{"name":"New Mexico","abbreviation":"NM"},{"name":"New York","abbreviation":"NY"},{"name":"North Carolina","abbreviation":"NC"},{"name":"North Dakota","abbreviation":"ND"},{"name":"Northern Mariana Islands","abbreviation":"MP"},{"name":"Ohio","abbreviation":"OH"},{"name":"Oklahoma","abbreviation":"OK"},{"name":"Oregon","abbreviation":"OR"},{"name":"Palau","abbreviation":"PW"},{"name":"Pennsylvania","abbreviation":"PA"},{"name":"Puerto Rico","abbreviation":"PR"},{"name":"Rhode Island","abbreviation":"RI"},{"name":"South Carolina","abbreviation":"SC"},{"name":"South Dakota","abbreviation":"SD"},{"name":"Tennessee","abbreviation":"TN"},{"name":"Texas","abbreviation":"TX"},{"name":"Utah","abbreviation":"UT"},{"name":"Vermont","abbreviation":"VT"},{"name":"Virgin Islands","abbreviation":"VI"},{"name":"Virginia","abbreviation":"VA"},{"name":"Washington","abbreviation":"WA"},{"name":"West Virginia","abbreviation":"WV"},{"name":"Wisconsin","abbreviation":"WI"},{"name":"Wyoming","abbreviation":"WY"}];
				deferred.resolve(data);
			}, 500);
			return deferred.promise;
		}
	}

}]);

registrationControllers.controller('RegistrationController',
				['$scope', 'Registration', 'State', function($scope, Registration, State){
					$scope.master = {};
					$scope.stateSelected = {};
					$scope.states = [];
					
					State.getStates().then(function(states) {
						$scope.states = states;
					});
					
					$scope.findState = function(state) {
						for(var s=0;s<$scope.states.length;s++) {
							if(state == $scope.states[s].abbreviation) {
								$scope.selectedState = $scope.states[s];
								break;
							}
						};
					};
					
					$scope.save = function(userRegistration) {
						$.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
						userRegistration.state = $scope.stateSelected.abbreviation;
						Registration.save(userRegistration).$promise.then(
							function (userData){
								$scope.master = userData;
								$scope.findState(userData.state);
							}	
						); 
						
						 //hack for visual
		 				 setTimeout(function(){
		 					 $.unblockUI(); 
		 				  }, 1000);
					};
					
				}]);