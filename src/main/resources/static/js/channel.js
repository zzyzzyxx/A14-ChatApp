window.onload = function() {
	"use strict";
	var messagesEl = document.querySelector("#messages")
	var userName = sessionStorage.getItem('name')
	if (userName == null && window.location.pathname !== '/welcome') {
		window.location.href = '/welcome'
	} else {
		userName = sessionStorage.getItem('name')
	}
	var messageEl = null
	let input = document.querySelector("#chatText")
	var message
	const queryString = window.location.href	
	let channelId = queryString.substring(queryString.lastIndexOf("/") + 1, queryString.length);

	async function handleEnter(e){
		if (e.key === 'Enter') {
			sendMessage()
			updateMessages()
		}
	}
	
	async function sendMessage() {
		console.log(input.value)
		 message = {
			'channelId': channelId,
			'messageContent': input.value,
			'userName': userName
		}
		input.value = ''
		
		try {
			const response = await fetch('/api/send-message', {
				method: 'POST',
				headers: {'Content-Type': 'application/json'},
				body: JSON.stringify(message)
			})
			
		} catch (error) {
			console.log('An error occured.', error)
			
		}
	}

	function appendMessage(userName, message) {
		
		messageEl = document.createElement('p')
		messageEl.innerHTML = `<span style="font-weight: bold">${userName}:</span> ${message}`
		messagesEl.appendChild(messageEl)

	}
	async function getAllMessages() {
		try {
			const response = await fetch('/api/list-messages?' + new URLSearchParams({channelId}), {
				method: 'GET',
				headers: {'Content-Type': 'application/json'}
			})
			return response.json()
			
		} catch (error) {
			console.log('There was an error.', error)
		}
	}
	async function updateMessages() {
		const messages = await getAllMessages()

		messagesEl.innerHTML = ''
		for (let message of messages) {
			appendMessage(message.userName, message.messageContent)
		}
	}

	setInterval(updateMessages, 500);
	input.addEventListener('keypress', handleEnter)
}



