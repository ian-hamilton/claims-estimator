claimItemServices.factory('ClaimItems', [ '$resource', function($resource) {
	return {
		claims : $resource('/service/claimitems', {id:'@id'}, {
			query : { method : 'GET',
					url: '/service/claimitems/all',
					param: {claimType:'@claimType'},
					isArray : true
				},
			save : {
					method:'POST'
				}
		}),
		claimsMetadata : $resource('/service/claimitems', {id:'@id'}, {
			query : { method : 'GET',
				url: '/service/claimitems/testHead'
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
		
		vm.submit = function() {
			 ClaimItems.claims.save({id:vm.claimItem.id}, vm.claimItem).$promise.then(
					 function(result) {
						 vm.claimItem = result;
		});
			 
			 //hack for visual
				 setTimeout(function(){
					 $.unblockUI(); 
				  }, 1000);
		};	
						
     }]);
                                                       
claimMaintenanceControllers.controller('ClaimItemListMaintenanceController', [
		'$scope', 'ClaimItems', '$stateParams', function($scope, ClaimItems, $state) {
			$scope.claimItems = ClaimItems.claims.query({'claimType' : $state.claimType});
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


//claimMaintenanceApp.directive("dynamicName",function($compile){
//    return {
//        restrict:"A",
//        terminal:true,
//        priority:1000,
//        link:function(scope,element,attrs){
//            element.attr('name', scope.$eval(attrs.dynamicName));
//            element.removeAttr("dynamic-name");
//            $compile(element)(scope);
//        }
//    }
//});