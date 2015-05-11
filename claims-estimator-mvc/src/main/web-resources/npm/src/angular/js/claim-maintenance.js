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