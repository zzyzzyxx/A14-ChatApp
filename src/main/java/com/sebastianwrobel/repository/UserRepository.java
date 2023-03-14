package com.sebastianwrobel.repository;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.sebastianwrobel.dto.Channel;
import com.sebastianwrobel.dto.Message;
import com.sebastianwrobel.dto.MessageDto;
import com.sebastianwrobel.dto.User;

@Repository
public class UserRepository {

	private List<MessageDto> messages = new ArrayList<>();
	private long userId = 1;

	public Map<Long, User> userData = new HashMap<>();
	public Map<Long, Channel> allChannelMap = new HashMap<>();
	public Map<Long, Message> allChatMap = new HashMap<>();

	private void populateUsers(User user) {
		Message chat1 = new Message(1L, null);

		user = new User();
		Map<Long, Message> chatMap = new HashMap<>();

		chatMap.put(chat1.getMessageId(), chat1);
		Map<Long, Message> placeHolderChat = new HashMap<>();
		placeHolderChat.put(1L, chat1);

		allChatMap.put(chat1.getMessageId(), chat1);


		Channel chan1 = new Channel("Default", 1L, placeHolderChat, userData);

		Map<Long, Channel> chat1ChannelMap = new HashMap<>();
		chat1ChannelMap.put(1L, chan1);
		allChannelMap.put(1L, chan1);

		chan1.setChats(chatMap);
	}

	public User save(User user) {
		return userData.put(user.getUserId(), user);
	}

	public User findById(Long userId) {
		return userData.get(userId);
	}

	public Set<User> getUsers() {
		return null;
	}

	public Map<Long, Channel> getChannels() {
		populateUsers(null);
		return allChannelMap;

	}

	public List<MessageDto> listMessages(Long channelId) {
		return messages.stream().filter((m) -> m.getChannelId().equals(channelId))
				.collect(Collectors.toList());
	
	}

	public User addUser(User user) {
		populateUsers(user);

		return user;
	}

	public void setUserId(User newUser) {
		newUser.setUserId(userId++);

	}

	public void getExistingUser(User user) {
		populateUsers(user);
		
	}

	public void addMessage(MessageDto message) {
		messages.add(message);
		
	}

}
