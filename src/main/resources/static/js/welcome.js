window.onload = function() {
	"use strict"
 
if (typeof window === "undefined") {
	console.log("Undefined window")
} else {
	const selectedName = prompt("Type your nick:")
	sessionStorage.setItem('name', selectedName)

}

}