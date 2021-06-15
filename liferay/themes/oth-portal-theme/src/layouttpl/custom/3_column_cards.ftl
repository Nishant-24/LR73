<div class="columns-3 p-4" id="main-content" role="main">
	<div class="portlet-layout row row-cols-1 row-cols-md-3">
		<div class="col-md-4 portlet-column portlet-column-first" id="column-1">
			${processor.processColumn("column-1", "card h-100 portlet-column-content portlet-column-content-first")}
		</div>

		<div class="col-md-4 portlet-column" id="column-2">
			${processor.processColumn("column-2", "card h-100 portlet-column-content")}
		</div>

		<div class="col-md-4 portlet-column portlet-column-last" id="column-3">
			${processor.processColumn("column-3", "card h-100 portlet-column-content portlet-column-content-last")}
		</div>
	</div>
</div>