package ch.ansermgw.angryword;

import com.badlogic.gdx.Game;

import java.util.Enumeration;
import java.util.Stack;

import ch.ansermgw.angryword.activities.Welcome;

public class AngrywordMain extends Game {
    public static Stack<Game> activities;

    @Override
    public void create() {
        activities = new Stack<>();

        Game welcome = new Welcome();
        welcome.create();

        activities.push(welcome);
    }

    @Override
    public void render() {
        activities.peek().render();
    }

    @Override
    public void dispose() {
        Enumeration<Game> activitiesEnum = activities.elements();

        while (activitiesEnum.hasMoreElements()) {
            Game nextActivity = activitiesEnum.nextElement();
            nextActivity.dispose();
        }
    }
}
