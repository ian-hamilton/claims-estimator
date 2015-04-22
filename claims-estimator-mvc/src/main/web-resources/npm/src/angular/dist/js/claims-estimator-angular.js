

/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */
var claimItemServices = angular.module('claimItemServices', [ 'ngResource' ]);
var claimMaintenanceControllers = angular.module('claimMaintenanceControllers',
		[]);

claimItemServices.factory('ClaimItems', [ '$resource', function($resource) {
	return $resource('/claims-estimator-mvc/service/claimitems', {id:'@id'}, {
		query : {
			method : 'GET',
			isArray : true
		},
		save : {
			method:'POST'
		}
	});
}]);


claimMaintenanceControllers.controller('ClaimItemMaintenanceController', [
		'$scope', 'ClaimItems', function($scope, ClaimItems) {
			$scope.claimItems = ClaimItems.query();
			$scope.orderProp = 'claimItemName';
			$scope.totalServerItems = $scope.claimItems.length;
			
			    $scope.gridOptions = { 
			        data: 'claimItems',
			        columnDefs: [{field:'claimItemName', displayName:'Item Name', enableCellEdit: true}, 
			                     {field:'claimItemAmount', displayName:'Item Cost', enableCellEdit: true},
			                     {field:'claimItemDesc', displayName:'Item Description', enableCellEdit: true}],
			        showGroupPanel: false,
			        jqueryUITheme: true,
			        enablePaging: false,
			        showFooter: true,
			        enableCellSelection: true,
			        enableRowSelection: true,
			        enableCellEdit: true,
			        plugins: [new ngGridFlexibleHeightPlugin({ maxHeight : 1000})]
			    };
			    
			 $scope.addRow = function() {
			      $scope.claimItems.push({claimItemName: 'Empty', claimItemAmount: 0});
			 };
			 		 
			 $scope.saveAllClaimItems = function() {
				 angular.forEach($scope.claimItems, function(value, index){
					 ClaimItems.save({id:value.id}, value);
				 });
			 };

		}]);

angular.module('claimMaintenanceApp', ['claimMaintenanceControllers', 'claimItemServices', 'ngGrid']);
