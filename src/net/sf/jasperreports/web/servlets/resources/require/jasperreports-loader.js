define(["jquery/amd/jquery-1.7.1"], function($) {
	
	var loader = new function() {
		this.styles = {};

		/** 
		 * Dynamically loads a css file 
		 */
		this.loadStyle = function (styleName, styleUrl, isAbsoluteUrl) {
			// prevent the style tag from being created more than once 
			if (!jr.styles[styleName]) {
				if (!isAbsoluteUrl) {
					styleUrl = jr.APPLICATION_CONTEXT_PATH + styleUrl;
				}
				var styleElement = document.createElement('link');
				styleElement.setAttribute('rel', 'stylesheet');
				styleElement.setAttribute('type', 'text/css');
				styleElement.setAttribute('href', styleUrl);
				document.getElementsByTagName('head')[0].appendChild(styleElement);
				this.styles[styleName] = styleUrl;
			}
		};
		
		this.ajaxLoad = function (config) {
			$.ajax(config.url, {
				type: 'POST',
				data: config.options,
				success: function(data, textStatus, jqXHR) {
					console.log(data);
				}
			});
		};
		
		this.runAction = function(report, options) {
			$.ajax(report.config.url, {
				type: 'POST',
				data: options,
				success: function(data, textStatus, jqXHR) {
					console.log(data);
				}
			});
		};	
	};
	
	return loader;
});
