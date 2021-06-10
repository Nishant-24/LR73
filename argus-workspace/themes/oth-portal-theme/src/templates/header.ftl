<header id="header" role="banner">
	<div>
		<a class="${logo_css_class}" href="${site_default_url}">
			<span class="logo__icon">
				<svg class="logo__symbol">
					<use xlink:href="${themeDisplay.getPathThemeImages()}/argus/icons.svg#logo-symbol" />
				</svg>
				<svg class="logo__wordmark">
					<use xlink:href="${themeDisplay.getPathThemeImages()}/argus/icons.svg#logo-wordmark" />
				</svg>
			</span>
			<span class="logo__title">
				<#if carrierName??>
					${carrierName}
				<#else>
					<@liferay.language key="the-argus-group" />
				</#if>
			</span>
		</a>
	</div>
	<div class="user-personal-bar">
		<div class="dropdown">
			<button class="btn btn-unstyled dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<span class="sticker sticker-lg">
					<span class="inline-item">
						<@liferay_ui["user-portrait"]
							cssClass="sticker-lg"
							user=user
						/>
					</span>
				</span>
			</button>

			<div class="dropdown-menu">
				<span class="dropdown-subheader">${user_name}</span>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" href="${sign_out_url}">${sign_out_text}</a>
			</div>
		</div>
	</div>
</header>