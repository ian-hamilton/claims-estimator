<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="row clearfix">
	<div class="jumbotron">
		<div class="container">
			<h1>Claims Robot!</h1>
			<p>This is the starting text for the Claims stuff. Need to add
				verbiage that will describe the solution.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more »</a>
			</p>
		</div>
	</div>
</div>

<div class="container" ng-app="claimMaintenanceApp">
	<div class="row" ng-controller="ClaimItemMaintenanceController">
		.
		<div class="col-md-8 column">
				<div class="gridStyle" ng-grid="gridOptions"></div>
				<button ng-click="addRow()">Add Row</button>
				<button ng-click="saveAllClaimItems()">Save All</button>
		</div>
		<div class="col-md-4"></div>
	</div>
</div>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>