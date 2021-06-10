<%@ include file="./init.jsp" %>

<div class="container-fluid container-fluid-max-xl container-view">
	<div class="row">
		<portlet:actionURL name="<%= SampleDataGeneratorCommandNames.ACTION_RESET_ALL_DATA %>" var="resetAllDataURL" />
		<portlet:actionURL name="<%= SampleDataGeneratorCommandNames.ACTION_EXECUTE_BULK_LOAD %>" var="executeBulkLoadURL" />

		<div class="col-md-2">
			<aui:form action="${resetAllDataURL}" method="post" name="resetAllDataFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "resetAllData('" + renderResponse.getNamespace() + "resetAllDataFm');" %>'>
				<button class="btn btn-primary" type="submit">
					<span class=""><liferay-ui:message key="reset-all-data" /></span>
				</button>
			</aui:form>
		</div>
		<div class="col-md-4">
			<aui:form action="${executeBulkLoadURL}" method="post" name="executeBulkLoadFm" onSubmit='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "executeBulkLoad('" + renderResponse.getNamespace() + "executeBulkLoadFm');" %>'>
				<button class="btn btn-primary" type="submit">
					<span class=""><liferay-ui:message key="execute-bulk-load" /></span>
				</button>
			</aui:form>
		</div>
		<div class="col-md-6"/>
	</div>
</div>

<aui:script>
	function <portlet:namespace />resetAllData(formName) {
		var form = document.getElementById(formName);

		if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-reset-everything-with-sample-data") %>')) {
			submitForm(form);
		}
	}
	function <portlet:namespace />executeBulkLoad(formName) {
		var form = document.getElementById(formName);

		if (confirm('<%= UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-reset-everything-with-new-dataset") %>')) {
			submitForm(form);
		}
	}
</aui:script>