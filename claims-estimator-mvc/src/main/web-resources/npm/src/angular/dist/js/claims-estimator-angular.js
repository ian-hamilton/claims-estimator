

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
/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */
var claimItemServices = angular.module('claimItemServices', [ 'ngResource' ]);
var claimMaintenanceControllers = angular.module('claimMaintenanceControllers',	[]);

var claimMaintenanceApp = angular.module('claimMaintenanceApp', 
		['claimMaintenanceControllers', 'claimItemServices', 'ngGrid', 'ui.router', 'formly', 'formlyBootstrap']);

claimMaintenanceApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('Item', {
		url : '/item-list/:claimType',
		templateUrl : 'html/maintenance/item-list.html',
		controller : 'ClaimItemListMaintenanceController'
	}).state('newItem', {
		url : '/newItem',
		templateUrl : 'html/maintenance/new-item.html',
		controller : 'ClaimItemMaintenanceController'
	});;
	
} ]);
claimItemServices.factory('ClaimItems', [ '$resource', function($resource) {
	return {
		claims : $resource('/claims-estimator-mvc/service/claimitems', {id:'@id'}, {
			query : { method : 'GET',
					url: '/claims-estimator-mvc/service/claimitems/all?claimType=property',
					param: {claimType:'@claimType'},
					isArray : true
				},
			save : {
					method:'POST'
				}
		}),
		claimsMetadata : $resource('/claims-estimator-mvc/service/claimitems', {id:'@id'}, {
			query : { method : 'GET',
				url: '/claims-estimator-mvc/service/claimitems/testHead'
			}
		})
	};
}]);

var removeTemplate = '<input type="button" value="remove" ng-click="removeRow($index)" />';

claimMaintenanceControllers.controller('ClaimItemMaintenanceController', [
	'$scope', 'ClaimItems', '$stateParams', function($scope, ClaimItems, $state) {
		var vm = this;
		vm.claimItem = {};
		ClaimItems.claimsMetadata.query().$promise.then(
						        function( head ){
						        	vm.formFields = claims.generateFields(head);
								 }
						      );
			
						
     }]);
                                                       
claimMaintenanceControllers.controller('ClaimItemListMaintenanceController', [
		'$scope', 'ClaimItems', '$stateParams', function($scope, ClaimItems, $state) {
			$scope.claimItems = ClaimItems.claims.query();
			$scope.orderProp = 'claimItemName';
			$scope.totalServerItems = $scope.claimItems.length;
			$scope.regheader = $state.claimType;
			
			
			    $scope.gridOptions = { 
			        data: 'claimItems',
			        columnDefs: [{field:'claimItemName', displayName:'Item Name', enableCellEdit: true}, 
			                     {field:'claimItemAmount', displayName:'Item Cost', enableCellEdit: true},
			                     {field:'claimItemDesc', displayName:'Item Description', enableCellEdit: true},
			                     {field: 'remove', displayName: '', cellTemplate: removeTemplate}],
			        showGroupPanel: false,
			        jqueryUITheme: true,
			        enablePaging: false,
			        showFooter: true,
			        enableCellSelection: true,
			        enableRowSelection: true,
			        plugins: [new ngGridFlexibleHeightPlugin({ maxHeight : 1000})]
			    };    
				 	
			    
			 $scope.addRow = function() {
			      $scope.claimItems.push({claimItemName: 'Empty', claimItemAmount: 0});
			 };
			 		 
			 $scope.saveAllClaimItems = function() {
				 $.blockUI({ message: '<h1><img src="images/busy.gif" /> Just a moment...</h1>' }); 
				 angular.forEach($scope.claimItems, function(value, index){
					 ClaimItems.claims.save({id:value.id}, value);
				 });

				 //hack for visual
				 setTimeout(function(){
					 $.unblockUI(); 
				  }, 2000);
			 };
			 
			 $scope.removeRow = function() {
				 $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
				  var index = this.row.rowIndex;
				  var value = $scope.claimItems[index];
                  ClaimItems.remove({id:value.id}, value, function(index){
                	  $scope.claimItems = ClaimItems.claimss.query();
                  });
                  
                  //hack for visual
 				 setTimeout(function(){
 					 $.unblockUI(); 
 				  }, 1000);
			 };

		}]);


claimMaintenanceApp.directive("dynamicName",function($compile){
    return {
        restrict:"A",
        terminal:true,
        priority:1000,
        link:function(scope,element,attrs){
            element.attr('name', scope.$eval(attrs.dynamicName));
            element.removeAttr("dynamic-name");
            $compile(element)(scope);
        }
    }
});
/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. License: MIT
 */ 

var claims = {
		
		generateFields : function(schema) {
			var index=0;
			var formFields = new Array();
			
			 $.each(schema.properties, function(key, value) {
        		var formField = new Object();
        		formField.templateOptions = new Object();
        		
        		formField.key = key;
        		
        		switch(value.type) {
        			case 'string':
        				formField.type = 'input';
        				break;
        			default:
        				formField.type = 'input';
        		}
        		
        		formField.templateOptions.required = value.required;
        		formField.templateOptions.label = key;        		
        		
        		formFields[index++] = formField;
        	 });
			 
			 return formFields;
		}
		
}