claimItemServices.factory('ClaimItems', [ '$resource', function($resource) {
	return $resource('/claims-estimator-mvc/service/claimitems', {id:'@id'}, {
		query : {
			method : 'GET',
			isArray : true
		},
		queryAll : {
			method : 'GET',
			url: '/claims-estimator-mvc/service/claimitem/all',
			param: {claimType:'@claimType'},
			isArray : true
		},
		save : {
			method:'POST'
		},
		remove : {
			method: 'DELETE'
		},
		head : {
			method: 'GET',
			url: '/claims-estimator-mvc/service/claimitems/testHead',
		}
	});
}]);

var removeTemplate = '<input type="button" value="remove" ng-click="removeRow($index)" />';

claimMaintenanceControllers.controller('ClaimItemMaintenanceController', [
		'$scope', 'ClaimItems', function($scope, ClaimItems) {
			$scope.claimItems = ClaimItems.query();
			$scope.orderProp = 'claimItemName';
			$scope.totalServerItems = $scope.claimItems.length;
			
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
			    
			    
			 $scope.loadProperties = function() {
				 var head = ClaimItems.head();
				 var formFields = "[";
				 $.each(head, function(key, value) {
						 formFields += "{name:" + key + " type:" + value.type + "],";
				 });
				 formFields += "]";
				 $scopeFormFields = formFields;				 
			 };   	
			    
			 $scope.addRow = function() {
			      $scope.claimItems.push({claimItemName: 'Empty', claimItemAmount: 0});
			 };
			 		 
			 $scope.saveAllClaimItems = function() {
				 $.blockUI({ message: '<h1><img src="images/busy.gif" /> Just a moment...</h1>' }); 
				 angular.forEach($scope.claimItems, function(value, index){
					 ClaimItems.save({id:value.id}, value);
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
                	  $scope.claimItems = ClaimItems.query();
                  });
                  
                  //hack for visual
 				 setTimeout(function(){
 					 $.unblockUI(); 
 				  }, 1000);
			 };

		}]);