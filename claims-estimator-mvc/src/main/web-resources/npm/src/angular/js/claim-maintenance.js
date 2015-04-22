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
			$scope.master = {};
			
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
			    
			 $scope.reset = function() {
			     $scope.claimItem = angular.copy($scope.master);
			 };
			 
			 $scope.update = function(claimItem) {
				 ClaimItems.save({id:claimItem.id}, claimItem, function(data) {
					 $scope.claimItems = ClaimItems.query();
					 $scope.reset();
				 });
				
			 };
			  
			 $scope.reset();
		}]);

angular.module('claimMaintenanceApp', ['claimMaintenanceControllers', 'claimItemServices', 'ngGrid']);
