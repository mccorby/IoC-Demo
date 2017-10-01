package com.mccorby.ioc_game;

import com.mccorby.ioc_game.domain.Player;
import com.mccorby.ioc_game.domain.rules.BoardInitRule;
import com.mccorby.ioc_game.domain.rules.PlayerNameRule;
import ioc_container.CheckableRule;
import ioc_container.Logger;
import ioc_container.RuleCheckerContainer;
import ioc_container.containers.SimpleRuleCheckerContainer;

public class GameApp {

    public static void main(String[] args) {
        Logger logger = new SystemOutLogger();
        Player player = new Player("Player 1");
        CheckableRule playerNameRule = new PlayerNameRule(player);

        boolean[][] board = new boolean[10][10];
        CheckableRule boardInitRule = new BoardInitRule(board);

        RuleCheckerContainer container = new SimpleRuleCheckerContainer(logger);
        container.addRule(playerNameRule);
        container.addRule(boardInitRule);
    }
}
