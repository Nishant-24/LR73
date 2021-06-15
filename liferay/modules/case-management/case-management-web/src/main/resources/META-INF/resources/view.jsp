<%@ include file="/init.jsp" %>

<liferay-ui:search-container
	id="casesSearchContainer"
	searchContainer="${casesSearchContainer}"
>
	<liferay-ui:search-container-row
		className="com.argus.oth.cases.management.model.Cases"
		keyProperty="caseId"
		modelVar="cases"
	>
		<liferay-ui:search-container-column-text
			name="last-updated"
		>
			<fmt:formatDate pattern="MM/dd/yyyy" value="${cases.lastUpdated}" />
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="case-id"
			value="${cases.caseId}"
		/>

		<liferay-ui:search-container-column-text
			name="client-name"
			value="${cases.clientName}"
		/>

		<liferay-ui:search-container-column-text
			name="diag-code"
			value="${cases.primaryCode}"
		/>

		<liferay-ui:search-container-column-text
			name="charged-amount"
		>
			<c:choose>
				<c:when test="${cases.chargedAmount != 'NA'}">
					<fmt:formatNumber type="currency" value="${cases.chargedAmount}" />
				</c:when>
				<c:otherwise>
					${cases.chargedAmount}
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="reprice-amount"
		>
			<c:choose>
				<c:when test="${cases.repricedAmount != 'NA'}">
					<fmt:formatNumber type="currency" value="${cases.repricedAmount}" />
				</c:when>
				<c:otherwise>
					${cases.repricedAmount}
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="paid-amount"
		>
			<c:choose>
				<c:when test="${cases.paidAmount != 'NA'}">
					<fmt:formatNumber type="currency" value="${cases.paidAmount}" />
				</c:when>
				<c:otherwise>
					${cases.paidAmount}
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="savings-percent"
		>
			<c:choose>
				<c:when test="${cases.savingsPercent != 'NA'}">
					<fmt:formatNumber maxFractionDigits="2" type="number" value="${cases.savingsPercent}" />
				</c:when>
				<c:otherwise>
					${cases.savingsPercent}
				</c:otherwise>
			</c:choose>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text
			name="status"
			value="${cases.status}"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator
		displayStyle="list"
		markupView="lexicon"
	/>
</liferay-ui:search-container>