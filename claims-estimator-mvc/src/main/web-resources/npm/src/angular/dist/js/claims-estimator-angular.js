

/**
 * @license Inertia v1.0
 * 
 * Inertia, Inc. 
 * License: MIT
 */
var claimItemServices = angular.module('claimItemServices', [ 'ngResource' ]);
var claimMaintenanceControllers = angular.module('claimMaintenanceControllers',	[]);

var claimMaintenanceApp = angular.module('claimMaintenanceApp', 
		['claimMaintenanceControllers', 'claimItemServices', 'ngGrid', 'ui.router']);

claimMaintenanceApp.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('propertyItem', {
		url : '/property-item-list/:claimType',
		templateUrl : 'html/maintenance/property-item-list.html',
		controller : 'ClaimItemMaintenanceController'
	}).state('commercialItem', {
		url : '/commercial-item-list/:claimType',
		templateUrl : 'html/maintenance/commercial-item-list.html',
		controller : 'ClaimItemMaintenanceController'
	}).state('homeItem', {
		url : '/home-item-list/:claimType',
		templateUrl : 'html/maintenance/home-item-list.html',
		controller : 'ClaimItemMaintenanceController'
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
		'$scope', 'ClaimItems', function($scope, ClaimItems) {
			$scope.claimItems = ClaimItems.claims.query();
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
					 ClaimItems.claimsMetadata.query().$promise.then(
								        function( head ){
								        	 var formFields = '{ "name" : "FormFields", "fields" : [';
								        	 var appender = '';
								        	 $.each(head.properties, function(key, value) {
								        		 formFields += appender;
												 formFields += '{"label" : "' + key + '", "name" : "' + key + '", "type" : "text", "required" : true, "data" :""}';
												 appender = ',';
								        	 });
										 formFields += "]}";	
										 $scope.entity = JSON.parse(formFields);
										 }
								      );
					 
							 
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

    // unblock when ajax activity stops
    $(document).ajaxStop($.unblockUI); 
 
    function test() { 
        $.ajax({ url: 'wait.php', cache: false }); 
    } 

    $(document).ready(function() { 
    	
 
    $(document).ready(function() { 
        $('#saveAllItems2').click(function() { 
            $.blockUI({ message: '<h1><img src="busy.gif" /> Just a moment...</h1>' }); 
        }); 
    });
    
    });