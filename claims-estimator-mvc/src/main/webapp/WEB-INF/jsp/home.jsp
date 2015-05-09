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

<div class="row">
	.
	<div class="container">
		<div class="col-md-8 column">
			<div class="well bs-component">
				<form role="form" class="form-horizontal">
					<fieldset>
					<legend></legend>
						<div class="form-group">
							<label for="exampleInputEmail1" class="col-lg-2 control-label">Email address</label>
							<div class="col-lg-10">
							<input type="email" class="form-control" id="exampleInputEmail1"
								autocomplete="off"
								style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDiEFu6xIcAAAAXhJREFUOMvNk8FLVFEUxn/ffRdmIAla1CbBFDGCpoiQWYlBLty7UHAvEq2HYLhveDMws2/TIly6E9SdIEj+AVYgRaTgXhe2C968x2nhTOjow8pNZ/ede/ide893Lvx3UavVhkMIk30dQqiGECpF9e68CCG8LpfL3yStAAIk6Z2kT3Ect68C+AGdSroFVEII82aWSXoGYGYHVwE0qOM43pU0BXw3s1zSI2AnSZKXhYB6vT7inLvd7XZ/eu8fOOe2JEW9zjkwZ2bHkoayLDtpt9ufLzzBe/8GWC6VSpc7nIE2pLPLeu/fA0uDQ3T/6pp6039uZnfN7Ieke1EUrQOu3/VawPloNBrbwIyZ7TvnLvg/+mKOJ3xk88NR4R4sADM92fp9MDRMdXaRxenHVMbuFy8SMAFkZval2Wyu9ZN3Hk4zWx0nAtKsWwxotVrNNE2f5nn+CrB+/nRvlSR5y2EK0TWbSKfT+fo3Lribfr4bA/yfl56y2kkuZX8BjXVyqMs8oFcAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
							</div>
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1" class="col-lg-2 control-label">Password</label>
						<div class="col-lg-10">
						<input type="password" class="form-control" id="exampleInputPassword1"
								autocomplete="off"
								style="background-image: url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAABAAAAASCAYAAABSO15qAAAABmJLR0QA/wD/AP+gvaeTAAAACXBIWXMAAAsTAAALEwEAmpwYAAAAB3RJTUUH3QsPDiEFu6xIcAAAAXhJREFUOMvNk8FLVFEUxn/ffRdmIAla1CbBFDGCpoiQWYlBLty7UHAvEq2HYLhveDMws2/TIly6E9SdIEj+AVYgRaTgXhe2C968x2nhTOjow8pNZ/ede/ide893Lvx3UavVhkMIk30dQqiGECpF9e68CCG8LpfL3yStAAIk6Z2kT3Ect68C+AGdSroFVEII82aWSXoGYGYHVwE0qOM43pU0BXw3s1zSI2AnSZKXhYB6vT7inLvd7XZ/eu8fOOe2JEW9zjkwZ2bHkoayLDtpt9ufLzzBe/8GWC6VSpc7nIE2pLPLeu/fA0uDQ3T/6pp6039uZnfN7Ieke1EUrQOu3/VawPloNBrbwIyZ7TvnLvg/+mKOJ3xk88NR4R4sADM92fp9MDRMdXaRxenHVMbuFy8SMAFkZval2Wyu9ZN3Hk4zWx0nAtKsWwxotVrNNE2f5nn+CrB+/nRvlSR5y2EK0TWbSKfT+fo3Lribfr4bA/yfl56y2kkuZX8BjXVyqMs8oFcAAAAASUVORK5CYII=); background-attachment: scroll; background-position: 100% 50%; background-repeat: no-repeat;">
						</div>
						</div>
						<button type="submit" class="btn btn-primary">Submit</button>
					</fieldset>
				</form>
			</div>
		</div>

		<div class="col-md-4 column">
			<div class="list-group">
				<a href="#" class="list-group-item">
					<blockquote>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<small>Someone famous <cite>Source Title</cite></small>
					</blockquote>
				</a> <a href="#" class="list-group-item">
					<blockquote>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<small>Someone famous <cite>Source Title</cite></small>
					</blockquote>
				</a> <a href="#" class="list-group-item"> <img
					src="<c:url value="/images/success.png"/>" alt="Claims Success"
					class="img-responsive large-icon">
					<blockquote>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
							Integer posuere erat a ante.</p>
						<small>Someone famous <cite>Source Title</cite></small>
					</blockquote>
				</a>
			</div>
		</div>
	</div>
</div>



<%@ include file="/WEB-INF/jsp/footer.jsp"%>