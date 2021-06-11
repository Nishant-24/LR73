<%@ include file="/init.jsp" %>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">

		<%
		String signedInAs = HtmlUtil.escape(user.getFullName());

		if (themeDisplay.isShowMyAccountIcon() && (themeDisplay.getURLMyAccount() != null)) {
			String myAccountURL = String.valueOf(themeDisplay.getURLMyAccount());

			signedInAs = "<a class=\"signed-in\" href=\"" + HtmlUtil.escape(myAccountURL) + "\">" + signedInAs + "</a>";
		}
		%>

		<liferay-ui:message arguments="<%= signedInAs %>" key="you-are-signed-in-as-x" translateArguments="<%= false %>" />
	</c:when>
	<c:otherwise>

		<%
		String formName = "loginForm";

		if (windowState.equals(LiferayWindowState.EXCLUSIVE)) {
			formName += "Modal";
		}

		String redirect = ParamUtil.getString(request, "redirect");

		String login = (String)SessionErrors.get(renderRequest, "login");

		if (Validator.isNull(login)) {
			login = LoginUtil.getLogin(request, "login", company);
		}

		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");

		if (Validator.isNull(authType)) {
			authType = company.getAuthType();
		}

		boolean backdoorEnabled = GetterUtil.getBoolean(PropsUtil.get("login.backdoor.enabled"), false);
		%>

		<div class="login">
			<div class="login__container">
				<portlet:actionURL name="/login/login" secure="<%= PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS || request.isSecure() %>" var="loginURL">
					<portlet:param name="mvcRenderCommandName" value="/login/login" />
				</portlet:actionURL>

				<header class="login__header">
					<svg class="login__logo">
						<use xlink:href="<%= themeDisplay.getPathThemeImages() %>/argus/icons.svg#logo-color"></use>
					</svg>
				</header>
				<section class="login__body">
					<h1 class="login__title"><liferay-ui:message key="carrier-portal" /></h1>

					<aui:form action="<%= loginURL %>" autocomplete='<%= PropsValues.COMPANY_SECURITY_LOGIN_FORM_AUTOCOMPLETE ? "on" : "off" %>' cssClass="sign-in-form" method="post" name="<%= formName %>" onSubmit="event.preventDefault();" validateOnBlur="<%= false %>">
						<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
						<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
						<aui:input name="doActionAfterLogin" type="hidden" value="<%=portletName.equals(PortletKeys.FAST_LOGIN) %>" />

						<div class="inline-alert-container lfr-alert-container"></div>

						<liferay-util:dynamic-include key="com.liferay.login.portlet#/login.jsp#alertPre" />

						<c:choose>
							<c:when test='<%= SessionMessages.contains(request, "forgotPasswordSent") %>'>
								<div class="alert alert-success">
									<liferay-ui:message key="your-request-completed-successfully" />
								</div>
							</c:when>
							<c:when test='<%= SessionMessages.contains(request, "userAdded") %>'>

								<%
								String userEmailAddress = (String)SessionMessages.get(request, "userAdded");
								%>

								<div class="alert alert-success">
									<liferay-ui:message key="thank-you-for-creating-an-account" />

									<c:if test="<%= company.isStrangersVerify() %>">
										<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="your-email-verification-code-was-sent-to-x" translateArguments="<%= false %>" />
									</c:if>
									<c:if test="<%= PrefsPropsUtil.getBoolean(company.getCompanyId(), PropsKeys.ADMIN_EMAIL_USER_ADDED_ENABLED) %>">
										<c:choose>
											<c:when test="<%= PropsValues.LOGIN_CREATE_ACCOUNT_ALLOW_CUSTOM_PASSWORD %>">
												<liferay-ui:message key="use-your-password-to-login" />
											</c:when>
											<c:otherwise>
												<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="you-can-set-your-password-following-instructions-sent-to-x" translateArguments="<%= false %>" />
											</c:otherwise>
										</c:choose>
									</c:if>
								</div>
							</c:when>
							<c:when test='<%= SessionMessages.contains(request, "userPending") %>'>

								<%
								String userEmailAddress = (String)SessionMessages.get(request, "userPending");
								%>

								<div class="alert alert-success">
									<liferay-ui:message arguments="<%= HtmlUtil.escape(userEmailAddress) %>" key="thank-you-for-creating-an-account.-you-will-be-notified-via-email-at-x-when-your-account-has-been-approved" translateArguments="<%= false %>" />
								</div>
							</c:when>
						</c:choose>

						<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
						<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
						<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
						<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />

						<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">

							<%
							UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
							%>

							<c:choose>
								<c:when test="<%= ule.passwordPolicy.isRequireUnlock() %>">
									<liferay-ui:message key="this-account-is-locked" />
								</c:when>
								<c:otherwise>
									<%
									Format dateFormat = FastDateFormatFactoryUtil.getDateTime(FastDateFormatConstants.SHORT, FastDateFormatConstants.LONG, locale, TimeZone.getTimeZone(ule.user.getTimeZoneId()));
									%>

									<liferay-ui:message arguments="<%= dateFormat.format(ule.user.getUnlockDate()) %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
								</c:otherwise>
							</c:choose>
						</liferay-ui:error>

						<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

						<liferay-util:dynamic-include key="com.argus.login.portlet#/login.jsp#alertPost" />

						<portlet:actionURL var="carrierLoginURL">
							<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="<%= OpenIdConnectWebKeys.OPEN_ID_CONNECT_REQUEST_ACTION_NAME %>" />
							<portlet:param name="<%= OpenIdConnectWebKeys.OPEN_ID_CONNECT_PROVIDER_NAME %>" value="<%= HtmlUtil.escape((String)request.getAttribute("openIdProviderName")) %>" />
							<portlet:param name="redirect" value="<%= redirect %>" />
						</portlet:actionURL>
						
						<portlet:actionURL var="adminLoginURL">
							<portlet:param name="<%= ActionRequest.ACTION_NAME %>" value="<%= OpenIdConnectWebKeys.OPEN_ID_CONNECT_REQUEST_ACTION_NAME %>" />
							<portlet:param name="<%= OpenIdConnectWebKeys.OPEN_ID_CONNECT_PROVIDER_NAME %>" value="<%= HtmlUtil.escape((String)request.getAttribute("adminProviderName")) %>" />
							<portlet:param name="redirect" value="<%= redirect %>" />
						</portlet:actionURL>

						<h5 class="mb-3"><liferay-ui:message key="log-in-options" /></h5>

						<aui:a cssClass="btn btn-primary btn-block" href="<%=carrierLoginURL %>" label="log-in-as-insurance-carrier" />

						<aui:a cssClass="btn btn-outline-primary btn-block" href="<%= adminLoginURL %>" label="log-in-as-one-team-health" />

						<c:if test="<%= backdoorEnabled && PortalUtil.getCurrentURL(request).contains("backdoor=true") %>">
							<aui:fieldset>

								<%
								String loginLabel = null;

								if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
									loginLabel = "email-address";
								}
								else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
									loginLabel = "screen-name";
								}
								else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
									loginLabel = "id";
								}
								%>

								<aui:input autoFocus="<%= windowState.equals(LiferayWindowState.EXCLUSIVE) || windowState.equals(WindowState.MAXIMIZED) %>" cssClass="clearable" label="<%= loginLabel %>" name="login" showRequiredLabel="<%= false %>" type="text" value="<%= login %>">
									<aui:validator name="required" />

									<c:if test="<%= authType.equals(CompanyConstants.AUTH_TYPE_EA) %>">
										<aui:validator name="email" />
									</c:if>
								</aui:input>

								<aui:input name="password" showRequiredLabel="<%= false %>" type="password" value="<%= password %>">
									<aui:validator name="required" />
								</aui:input>

								<span id="<portlet:namespace />passwordCapsLockSpan" style="display: none;"><liferay-ui:message key="caps-lock-is-on" /></span>

								<c:if test="<%= company.isAutoLogin() && !PropsValues.SESSION_DISABLED %>">
									<aui:input checked="<%= rememberMe %>" name="rememberMe" type="checkbox" />
								</c:if>
							</aui:fieldset>

							<aui:button-row>
								<aui:button type="submit" value="sign-in" />
							</aui:button-row>
						</c:if>
					</aui:form>
				</section>
				<footer class="login__footer">
					<liferay-ui:message key="learn-more-about-carrier-portal-from-one-team-health" />
				</footer>
			</div>
			<div class="login__splash"></div>
		</div>

		<aui:script sandbox="<%= true %>">
			var form = document.getElementById('<portlet:namespace /><%= formName %>');

			if (form) {
				form.addEventListener('submit', function(event) {
					<c:if test="<%= Validator.isNotNull(redirect) %>">
						var redirect = form.querySelector('#<portlet:namespace />redirect');

						if (redirect) {
							var redirectVal = redirect.getAttribute('value');

							redirect.setAttribute('value', redirectVal + window.location.hash);
						}
					</c:if>

					submitForm(form);
				});

				var password = form.querySelector('#<portlet:namespace />password');

				if (password) {
					password.addEventListener('keypress', function(event) {
						Liferay.Util.showCapsLock(
							event,
							'<portlet:namespace />passwordCapsLockSpan'
						);
					});
				}
			}
		</aui:script>
	</c:otherwise>
</c:choose>