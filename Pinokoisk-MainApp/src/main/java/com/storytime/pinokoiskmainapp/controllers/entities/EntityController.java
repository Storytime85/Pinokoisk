package com.storytime.pinokoiskmainapp.controllers.entities;

import com.storytime.pinokoiskmainapp.dto.AvgRating;

import java.util.HashMap;
import java.util.Map;

public abstract class EntityController {
    Map<Long, AvgRating> squishUsersAndCritics(Map<Long, AvgRating> users, Map<Long, AvgRating> critics) {
        Map<Long, AvgRating> all = new HashMap<>();
        users.forEach((k,v) ->
                all.put( k, new AvgRating(v,critics.get(k))));
        critics.forEach((k,v) ->
        {
            if (!all.containsKey(k))
                all.put(k,v);
        });
        return all;
    }
}
