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