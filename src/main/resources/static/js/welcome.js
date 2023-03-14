window.onload = function() {
	"use strict"
 
if (typeof window === "undefined") {
	console.log("Oops, `window` is not defined")
} else {
	const selectedName = prompt("Type your nick:")
	sessionStorage.setItem('name', selectedName)

}

}