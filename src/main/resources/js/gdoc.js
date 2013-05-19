var gdocContainerId = '#gdoc-macro-container';
var gdocsJsonUrl = 'http://localhost:1990/confluence/plugins/servlet/gdocs';

AJS.toInit(function () {
	// Because this file  is currently loaded to every page, 
	// we need to know if our plugin exists before doing anything.
	if( AJS.$(gdocContainerId).length > 0 ) {
		var pollForFiles = setInterval(function () {
			console.log( 'fetch files until any - then stop.');
			AJS.$.ajax({
				url: gdocsJsonUrl,
				type: 'GET',
				// Complete callback (responseText is used internally)
				complete: function( data, status ) {
					var json = null;
					try {
						json = JSON.parse( data.responseText );
					} catch ( e ) {
						json = null;
					}
					console.log( json );
					if( json && json.length && json.length > 0 ) {
						AJS.$(gdocContainerId).html('<pre>' + JSON.stringify( json ) + '</pre>');
						// files updated, no repeat
						clearInterval( pollForFiles );
					}
				}
			});
		}, 1000);
	}
});
