package com.Gongdae9.room.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Hashtable;

@Service
@Slf4j
public class RoomSessionService {
    private Hashtable<Long, HashSet<Long>> roomSessions;

    public void setJoin(Long roomId, Long userId){
        roomSessions.putIfAbsent(roomId, new HashSet<>());
        roomSessions.get(roomId).add(userId);
    }

    public boolean isJoin(Long roomId, Long userId){
        if (!roomSessions.contains(roomId)) return false;
        return roomSessions.get(roomId).contains(userId);
    }

    public void deleteJoin(Long roomId, Long userId){
        roomSessions.get(roomId).remove(userId);
    }
}