<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<%@ include file="/WEB-INF/jsp/header.jsp"%>

<div  ng-app="claimMaintenanceApp" >
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
	<ul class="nav nav-pills">
	  <li role="presentation"  ui-sref-active="active"><a ui-sref="Item({claimType:'property'})">Property Item Maintenance</a></li>
	  <li role="presentation"  ui-sref-active="active"><a ui-sref="Item({claimType:'home'})">Home Item Maintenance</a></li>
	  <li role="presentation"  ui-sref-active="active"><a ui-sref="Item({claimType:'commercial'})">Commercial Item Maintenance</a></li>
	  <li role="presentation"  ui-sref-active="active"><a ui-sref="newItem({claimType:'New Item'})">New Item</a></li>
	</ul>
	</div>
</div>

	<div ui-view></div>


</div>

<%@ include file="/WEB-INF/jsp/footer.jsp"%>