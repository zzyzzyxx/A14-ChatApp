window.onload = function() {
	"use strict";

	const selectedName = sessionStorage.getItem('name');

	if (selectedName == null) {
		const name = prompt("Type your nick:");
		sessionStorage.setItem('name', name);
	} else {
		// Name is already stored
	}
};
