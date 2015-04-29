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
		<ul class="nav nav-pills">
			<li role="presentation" class="active"><a ui-sref='/'>Home</a></li>
			<li role="presentation"><a ui-sref='property-item-list/property'>Property Items</a></li>
			<li role="presentation"><a ui-sref='commercial-item-list/commercial'>Commercial Items</a></li>
			<li role="presentation"><a ui-sref='home-item-list/home'>Home Items</a></li>
		</ul>
	</div>
</div>

<div class="row">
	<div class="col-md-2"></div>
	<div class="col-md-6">
		<div ui-view></div>
	</div>
	<div class="col-md-4">
		<a ui-sref='item'>Back to Item Maintenance</a>
	</div>
</div>


<%@ include file="/WEB-INF/jsp/footer.jsp"%>