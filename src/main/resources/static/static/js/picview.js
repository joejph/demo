function ShowImage(obj, index, height, width) {

	var suffix = obj.value.substring(obj.value.lastIndexOf(".") + 1)
			.toLowerCase();
	var browserVersion = window.navigator.userAgent.toUpperCase();

	// 兼容ie和火狐
	if (browserVersion.indexOf("MSIE 6.0") > -1) {// ie6
		obj.select()
		jQuery("#imgHeadPhoto" + index).attr(
				"style",
				"width: " + width + "px; height: " + height
						+ "px;border: solid 1px #d2e2e2;");
		jQuery("#imgHeadPhoto" + index).attr("src",
				document.selection.createRange().text);

	} else if (browserVersion.indexOf("MSIE 7.0") > -1
			|| browserVersion.indexOf("MSIE 8.0") > -1) {// ie7、ie8
		// 滤镜实现
		obj.select();
		var newPreview = document.getElementById("divNewPreview" + index);
		newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = document.selection
				.createRange().text;
		newPreview.style.width = width;
		newPreview.style.height = height;
		newPreview.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").sizingMethod = 'scale';
		jQuery("#divPreview" + index).attr("style", "display:none");
		jQuery("#divNewPreview" + index)
				.attr(
						"style",
						"filter:progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=image);width: "
								+ width
								+ "px; height: "
								+ height
								+ "px;border:solid 1px #d2e2e2;");
	} else if (browserVersion.indexOf("Firefox") > -1) { // 火狐
		var objectURL = window.URL.createObjectURL(obj.files[0]);
		jQuery("#imgHeadPhoto" + index).attr(
				"style",
				"width: " + width + "px; height: " + height
						+ "px; border: solid 1px #d2e2e2;");
		jQuery("#imgHeadPhoto" + index).attr("src",
				window.URL.createObjectURL(obj.files[0]));
	} else if (obj.files) {
		// 兼容chrome，也可以兼容火狐，Chrome、Firefox上通过HTML5来实现
		var reader = new FileReader();
		reader.onload = function(evt) {
			jQuery("#imgHeadPhoto" + index).attr(
					"style",
					"width: " + width + "px; height:" + height
							+ "px; border: solid 1px #d2e2e2;");
			jQuery("#imgHeadPhoto" + index).attr("src", evt.target.result);
		}
		reader.readAsDataURL(obj.files[0]);
	}

}