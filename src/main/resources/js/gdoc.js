var gdocContainerId = '#gdoc-macro-container';

// Because this file  is currently loaded to every page, we need to know if our plugin exists before doing anything.
if( jQuery(gdocContainerId).length > 0 ) {
	var pollForFiles = setInterval(function () {
		jQuery.load('/confluence/plugins/servlet/gdocs', function ( text ) {
			var data = text; // jQuery.parseJSON( text );
			console.log( data );
			if( data != '{}' ) {
				jQuery(gdocContainerId).html('<pre>' + data + '</pre>');
				clearInterval( pollForFiles );
			}
		});
	}, 1000);
}
