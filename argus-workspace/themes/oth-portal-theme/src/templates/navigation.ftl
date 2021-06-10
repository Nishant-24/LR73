<nav class="${nav_css_class}" id="navigation" role="navigation">
	<ul class="nav" aria-label="<@liferay.language key="site-pages" />" role="menubar">
		<#list nav_items as nav_item>
			<@navItem item=nav_item>
				<#if nav_item.hasChildren()>

					<#if nav_item.isSelected()>
						<ul class="nav" role="menu">
							<#list nav_item.getChildren() as nav_child>
								<@navItem item=nav_child />
							</#list>
						</ul>
					<#else>
						<div class="dropdown-menu dropdown-menu-indicator-start">
							<div class="arrow"></div>
							<span class="dropdown-item-text font-weight-normal">${nav_item.getName()}</span>
							<#list nav_item.getChildren() as nav_child>
								<#if nav_item_icon_hash[nav_child.getName()?lower_case]??>
									<#assign nav_item_icon = nav_item_icon_hash[nav_child.getName()?lower_case] />
								</#if>

								<a class="dropdown-item" href="${nav_child.getURL()}">
									<span class="dropdown-item-indicator-start">
										<svg class="lexicon-icon ">
											<use xlink:href="${themeDisplay.getPathThemeImages()}/argus/icons.svg#${nav_item_icon!"account"}" />
										</svg>
									</span>
									${nav_child.getName()}
								</a>
							</#list>
						</div>
					</#if>
				</#if>
			</@>
		</#list>
	</ul>

	<button class="btn btn-sm btn-unstyled btn-toggle-nav js-toggle-navigation">
		<span class="inline-text">
			<@liferay.language key="minimize-menu" />
		</span>
		<span class="inline-item">
			<svg class="lexicon-icon lexicon-icon-angle-right">
				<use xlink:href="${themeDisplay.getPathThemeImages()}/clay/icons.svg#angle-right" />
			</svg>
		</span>
	</button>
</nav>

<#macro navItem item>
	<#assign
		nav_item_css_class = "nav__item"
		nav_item_layout = item.getLayout()
		nav_link_css_class = "nav__link"
	/>

	<#if item.isSelected()>
		<#assign nav_item_css_class = nav_item_css_class + " selected" />
	</#if>

	<#if layout.getRegularURL(request) == item.getURL()>
		<#assign nav_link_css_class = nav_link_css_class + " active" />
	</#if>

	<#if nav_item_icon_hash[item.getName()?lower_case]??>
		<#assign nav_item_icon = nav_item_icon_hash[item.getName()?lower_case] />
	</#if>

	<li class="${nav_item_css_class}" id="layout_${item.getLayoutId()}" role="presentation">
		<a class="${nav_link_css_class}" aria-labelledby="layout_${item.getLayoutId()}" href="${item.getURL()}" ${item.getTarget()} role="menuitem">
			<svg class="nav__icon">
				<use xlink:href="${themeDisplay.getPathThemeImages()}/argus/icons.svg#${nav_item_icon!"account"}" />
			</svg>
			<span class="nav__name">${item.getName()}</span>
		</a>

		<#nested>
	</li>
</#macro>