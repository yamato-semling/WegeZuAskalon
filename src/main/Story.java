package main;

import assets.weapons.Knife;

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

    public void townGate(){
        ui.mainTextArea.setText("Du stehst vor dem Tore der Stadt Askalons. \nVor dem Tor steht eine Wache.");

        ui.choice1.setText("Ansprechen");
        ui.choice2.setText("Angreifen");
        ui.choice3.setText("Verlassen");
        ui.choice4.setText("");
    }

}
