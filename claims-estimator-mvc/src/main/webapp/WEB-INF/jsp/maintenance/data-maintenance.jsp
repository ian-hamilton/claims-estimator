<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div class="row clearfix">
	<div class="jumbotron">
		<div class="container">
			<h1>Claim Maintenance Application</h1>
			<p>This is the starting text for the Claims stuff. Need to add
				verbiage that will describe the solution.</p>
			<p>
				<a class="btn btn-primary btn-lg" href="#" role="button">Learn
					more »</a>
			</p>
		</div>
	</div>
</div>

<div class=row>
	<div class="col-md-2"></div>
	<div class="col-md-10">

	</div>
</div>

<div class="row" ng-app="claimMaintenanceApp">
	<div class="col-md-2"></div>
	<div class="col-md-6">
		<div ui-view></div>
	</div>
	<div class="col-md-4">
		<a ui-sref='propertyItem'>Property Item Maintenance</a> <br />
		<a ui-sref='commercialItem'>Commercial Item Maintenance</a> <br />
		<a ui-sref='homeItem'>Home Item Maintenance</a> <br />
		<a ui-sref='newItem'>New Item</a>
	</div>
</div>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>