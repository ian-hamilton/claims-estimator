

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
			$scope.totalServerItems = $scope.claimItems.length;
			
			    $scope.gridOptions = { 
			        data: 'claimItems',
			        columnDefs: [{field:'claimItemName', displayName:'Item Name'}, 
			                     {field:'claimItemAmount', displayName:'Item Cost'},
			                     {field:'claimItemDesc', displayName:'Item Description'}],
			        showGroupPanel: false,
			        jqueryUITheme: true,
			        enablePaging: false,
			        showFooter: true,
			        plugins: [new ngGridFlexibleHeightPlugin({ maxHeight : 1000})]
			    };
		}]);

angular.module('claimMaintenanceApp', ['claimMaintenanceControllers', 'claimItemServices', 'ngGrid']);
