var gdocContainerId = '#gdoc-macro-container';
console.log("Gdoc js loaded.");

if( jQuery(gdocContainerId).length > 0 ) {
	var pollForFiles = setInterval(function () {
		jQuery.load('/confluence/plugins/servlet/gdocs', function ( xhr ) {
			var data = xhr.responseText;
			console.log( data );
			if( data != '{}' ) {
				console.log( "files!" );
				jQuery(gdocContainerId).html(data);
			}
		});
	}, 1000);
}
