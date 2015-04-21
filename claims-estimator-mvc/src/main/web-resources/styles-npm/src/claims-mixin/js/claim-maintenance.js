/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */
var claimItemServices = angular.module('claimItemServices', [ 'ngResource' ]);
var claimMaintenanceControllers = angular.module('claimMaintenanceControllers',
		[]);

claimItemServices.factory('ClaimItemsAll', [ '$resource', function($resource) {
	return $resource('/claims-estimator-mvc/service/claimitems', {}, {
		query : {
			method : 'GET',
			isArray : true
		}
	});
} ]);

claimMaintenanceControllers.controller('ClaimItemMaintenanceController', [
		'$scope', 'ClaimItemsAll', function($scope, ClaimItemsAll) {
			$scope.claimItems = ClaimItemsAll.query();
			$scope.orderProp = 'claimItemName';
		}]);

angular.module('claimMaintenance', ['claimMaintenanceControllers', 'claimItemServices']);
