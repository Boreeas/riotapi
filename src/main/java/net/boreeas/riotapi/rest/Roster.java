package net.boreeas.riotapi.rest;

import lombok.Getter;

import java.util.List;

/**
 * Created on 4/14/2014.
 */
@Getter
public class Roster {
    private List<TeamMemberInfo> memberList;
    private long ownerId;
}
