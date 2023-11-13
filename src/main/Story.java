package main;

import assets.weapons.Knife;
import assets.weapons.LongSword;

public class Story {

    Game game;
    UI ui;
    ViewManager vm;
    Player player = new Player();

    public Story(Game g, UI userInterface, ViewManager vManager){

        game = g;
        ui = userInterface;
        vm = vManager;
    }

    public void defaultSetup(){

        player.hp = 10;
        ui.hpNumLabel.setText(""+player.hp);

        player.currentWeapon = new Knife();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

    }
    public void selectPosition(String nextPosition){

        switch (nextPosition){
            case "townGate":
                townGate();
                break;
            case "talkGuard":
                talkGuard();
                break;
            case "attackGuard":
                attackGuard();
                break;
            case "crossroad":
                crossRoad();
                break;
            default:
                break;
        }
    }

    public void townGate(){
        ui.mainTextArea.setText("Du stehst vor dem Tore der Stadt Askalons. \nVor dem Tor steht eine Wache.");

        ui.choice1.setText("Ansprechen");
        ui.choice2.setText("Angreifen");
        ui.choice3.setText("Verlassen");
        ui.choice4.setText("");

        game.nextPosition1 = "talkGuard";
        game.nextPosition2 = "attackGuard";
        game.nextPosition3 = "crossRoad";
        game.nextPosition4 = "";
    }
    public void talkGuard(){
        ui.mainTextArea.setText("Wache: Abend, der Herr! \nSie sind mir ein frisches Gesicht, \nes kommen keine Fremde in unsre Stadt rein!");

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void attackGuard(){
        ui.mainTextArea.setText("Wache: Bist du verrückt geworden?! \nKapituliere jetzt noch oder du wirsts bereuen! \n\n(Du erhälst 3 Schaden.)");

        player.hp = player.hp - 3;
        ui.hpNumLabel.setText(""+player.hp);

        ui.choice1.setText(">");
        ui.choice2.setText("");
        ui.choice3.setText("");
        ui.choice4.setText("");

        game.nextPosition1 = "townGate";
        game.nextPosition2 = "";
        game.nextPosition3 = "";
        game.nextPosition4 = "";
    }
    public void crossRoad(){
        ui.mainTextArea.setText("Du bist an einer Kreuzung angekommen. \n\n(Du bist von Süden gekommen.)");

        player.hp = player.hp + 3;
        ui.hpNumLabel.setText(""+player.hp);

        ui.choice1.setText("Nach Norden");
        ui.choice2.setText("Nach Osten");
        ui.choice3.setText("Nach Süden");
        ui.choice4.setText("Nach Westen");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";
    }
    public void north(){
        ui.mainTextArea.setText("Du kommst an einem Fluss an und ruhistig aus. \n\n(Du heilst dich für 2HP.))");

        ui.choice1.setText("Nach Norden");
        ui.choice2.setText("Nach Osten");
        ui.choice3.setText("Nach Süden");
        ui.choice4.setText("Nach Westen");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";
    }
    public void east(){
        ui.mainTextArea.setText("Du läufst in eine Waldhütte rein und findest ein Schwert, das gehört nun dir. \n\n(Du rüstest das Schwert aus.)");

        player.currentWeapon = new LongSword();
        ui.weaponNameLabel.setText(player.currentWeapon.name);

        ui.choice1.setText("Nach Norden");
        ui.choice2.setText("Nach Osten");
        ui.choice3.setText("Nach Süden");
        ui.choice4.setText("Nach Westen");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";
    }
    public void west(){
        ui.mainTextArea.setText("Du triffst ein Goblin!");

        ui.choice1.setText("Nach Norden");
        ui.choice2.setText("Nach Osten");
        ui.choice3.setText("Nach Süden");
        ui.choice4.setText("Nach Westen");

        game.nextPosition1 = "north";
        game.nextPosition2 = "east";
        game.nextPosition3 = "townGate";
        game.nextPosition4 = "west";
    }


}
