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
		</div>
		<div class="col-md-4">
			<form novalidate class="simple-form">
				Item Name: <input type="text" ng-model="claimItem.claimItemName" /><br />
				Item Cost: <input type="text" ng-model="claimItem.claimItemAmount" /><br />
				Item Desc: <input type="text" ng-model="claimItem.claimItemDesc" /><br />
				<input type="button" ng-click="reset()" value="Reset" /> <input
					type="submit" ng-click="update(claimItem)" value="Save" />
			</form>
		</div>
	</div>
</div>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>