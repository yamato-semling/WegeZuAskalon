package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game {

    ChoiceHandler cHandler = new ChoiceHandler();
    UI ui = new UI();
    ViewManager vm = new ViewManager(ui);
    Story story = new Story(this,ui,vm);

    String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public static void main(String[] args) {

        new Game();
    }

    public Game(){

        ui.createUI(cHandler);
        story.defaultSetup();
        vm.showTitleScreen();
    }

    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String choice = event.getActionCommand();

            switch (choice){
                case "start":
                    vm.gameStart();
                    story.townGate();
                    break;
                case "c1": story.selectPosition(nextPosition1); break;
                case "c2": story.selectPosition(nextPosition2); break;
                case "c3": story.selectPosition(nextPosition3); break;
                case "c4": story.selectPosition(nextPosition4); break;
            }
        }
    }
}