package com.mccorby.ioc_game.domain.rules;

import com.mccorby.ioc_game.domain.Player;
import ioc_container.CheckableRule;

/**
 * This is a rule of a game that requires a precondition and a postcondition to be satisfied
 * The rule has a body that is passed as a dependency (IoC)
 */
public class PlayerNameRule extends CheckableRule {

    private Player player;

    public PlayerNameRule(Player player) {
        this.player = player;
    }

    @Override
    public boolean preExecution() {
        return player.getName() != null;
    }

    @Override
    public void executeBody() {
        player.setName("Name was modified");
    }

    @Override
    public boolean postExecution() {
        return player.getName() != null;
    }

    @Override
    public String toString() {
        return "Player Name Rule";
    }
}
