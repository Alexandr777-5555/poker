package ps;


import ps.evulator.HandEvaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * реализует функциональность игрового стола
 */

public class GameTable implements Table {

    private CardsDeck deck;
    private List<Player> playerList;
    private boolean win;


    public void setDeck(CardsDeck deck) {
        this.deck = deck;
    }

    public GameTable(List<Player> playerList) {
        this.playerList = playerList;
    }


    @Override
    public void dealCards(CardsDeck deck) {

        for (Player player : playerList) {
            int id = player.getId();
            if (id == 1) {
                player.setHand(deck.getCards1Player());
            }
            if (id == 2) {
                player.setHand(deck.getCards2Player());
            }
            if (id == 3) {
                player.setHand(deck.getCards3Player());
            }
        }
    }

    @Override
    public void game() {

        int count = 0;


        while (isWin() == false) {  // до победы

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");


            int bank = 0;

            // тут новая колода карт!!!

            init();
            deck.shuffle(); // перемешаем колоду
            dealCards(deck); // присваиваем игрокам карманные карты
            printHandsPlayer(); // распечатаем руки у игроков ранг и ставки

            for (Player player : playerList) {

                bank += player.chipsInPot(player.bet());
            }

            System.out.println("Общий банк равен" + bank);

            // действие игроков на префлопе!!!
            System.out.println("Карты флоп :" + deck.getFlop()); // раздать флоп
            System.out.println("Карты терн :" + deck.getTern()); // раздать терн
            System.out.println("Карты ривер :" + deck.getRiver()); // раздать ривер

            System.out.println();


            System.out.println("ОБЩИЕ КАРТЫ : " + deck.commonCards());


            determinationHandsPLayer();


            int winner = winner();

            System.out.println("победил игрок" + winner);


            chipsToWinner(winner, bank);
            //TODO передаем фишки победителю
            // делаем проверку если у игрока остаток фишек после раздачи 0 то игрока будем удалять из списка


            printAmountChips();


            count++;


            checkGameOver();

            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

            if (checkWinner() == true) {// условие победы
                win = true;
                System.out.println("Выиграл игру игрок ");
                printAmountChips();
            }
            destroy();
        }


    }

    /**
     * проверка остатка фишек у игрока
     */
    private void checkGameOver() {
        for (int i = 0; i < playerList.size(); i++) {
            if (playerList.get(i).getChips() == 0) {
                playerList.remove(i);
            }
        }
    }


    /**
     * проверка есть победитель в игре
     *
     * @return
     */
    private boolean checkWinner() {

        if (playerList.size() == 1) {
            return true;
        }
        return false;
    }


    /**
     * отдать фишки победителю
     *
     * @param id
     * @param bank
     */
    private void chipsToWinner(int id, int bank) {

        for (Player player : playerList) {
            if (player.getId() == id) {
                player.setChips(player.getChips() + bank);
            }
        }

    }


    /**
     * определение силы рук у игроков
     */
    private void determinationHandsPLayer() {
        for (Player player : playerList) {
            player.setStrongHand(0);
            String allHand = deck.allHandPlayer(player.getId());
            int strongHand = HandEvaluator.rankHand(CardsDeck.valueOf(allHand));
            player.setStrongHand(strongHand);
        }
    }


    /**
     * определяем победителя раздачи
     */
    private int winner() {

        List<Integer> players = new ArrayList<>();
        for (Player player : playerList) {
            players.add(player.getStrongHand());
        }
        Integer max = Collections.max(players); // у кого самая сильная рука
        for (Player player : playerList) {
            player.setWin(false);
            if (player.getStrongHand() == max) {
                player.setWin(true);
            }
        }
        int id = 0;
        for (Player player : playerList) {
            if (player.isWin() == true) {
                id = player.getId();
            }
        }
        return id;
    }


    private void init() {
        deck = new CardsDeck(); // init
    }

    private void destroy() {
        if (deck != null) {
            System.out.println(deck.toString());
            deck = null;
        }

    }

    private void printHandsPlayer() {
        for (Player player : playerList) {
            System.out.println("рука " + player.getHand() + " у игрока " + player.getId() + " ранг " + player.rangHand() + "ставка " + player.bet());
        }
    }


    private void printAmountChips() {
        for (Player player : playerList) {
            System.out.println("у игрока " + player.getId() + " остаток фишек : " + player.getChips());
        }
    }


    @Override
    public void dealFlop() {

    }

    @Override
    public void dealTern() {

    }

    @Override
    public void dealRiver() {

    }


    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
