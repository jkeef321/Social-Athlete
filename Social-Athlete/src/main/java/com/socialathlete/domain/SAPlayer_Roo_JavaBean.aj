// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.socialathlete.domain;

import com.socialathlete.domain.SAPlayer;
import com.socialathlete.domain.SATeam;

privileged aspect SAPlayer_Roo_JavaBean {
    
    public String SAPlayer.getPlayerName() {
        return this.playerName;
    }
    
    public void SAPlayer.setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    public SATeam SAPlayer.getTeam() {
        return this.team;
    }
    
    public void SAPlayer.setTeam(SATeam team) {
        this.team = team;
    }
    
    public String SAPlayer.getTwitterAccount() {
        return this.twitterAccount;
    }
    
    public void SAPlayer.setTwitterAccount(String twitterAccount) {
        this.twitterAccount = twitterAccount;
    }
    
}
