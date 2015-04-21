<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

	<div class="row clearfix">
		<div class="jumbotron">
			<div class="container">
				<h1>Claims Robot!</h1>
				<p>This is the starting text for the Claims stuff. Need to add verbiage that will describe the solution.</p>
				<p>
					<a class="btn btn-primary btn-lg" href="#" role="button">Learn
						more »</a>
				</p>
			</div>
		</div>
	</div>
	
<div class="row clearfix">	.
	<div class="container" ng-app='claimMaintenance'>
		<div class="col-md-8 column">	
				
			<div ng-controller='ClaimItemMaintenanceController'>
			
				<ul>
					<li ng-repeat="claimItem in claimItems">
						<span>{{claimItem.claimItemName}}</span>
						<p>{{claimItem.claimItemDesc}}</p>
					</li>
				</ul>
			
			</div>		
		</div>
	</div>	
</div>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>