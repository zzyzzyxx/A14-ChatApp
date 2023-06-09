package com.sebastianwrobel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sebastianwrobel.dto.Channel;
import com.sebastianwrobel.repository.ChannelRepository;


@Service
public class ChannelService {

	@Autowired
	private ChannelRepository channelRepo;
	
	public Map<Long, Channel> getChannels() {
	return channelRepo.getChannels();	
	}

	public List<Channel> getChannelNames() {
		List<Channel> channels = new ArrayList<Channel>(channelRepo.getChannels().values());
		return channels;
	}

}
