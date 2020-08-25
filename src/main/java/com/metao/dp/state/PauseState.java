package com.metao.dp.state.another;

/**
 * Concrete states provide the special implementation for all interface methods.
 */
public class PauseState extends State {

    PauseState(Player player) {
        super(player);
        player.setPlaying(false);
    }

    @Override
    public String onPause() {
        if (player.isPlaying()) {
            player.changeState(new ReadyState(player));
            return "Stop playing";
        }else{
            return "Paused...";
        }
    }

    @Override
    public String onPlay() {
        player.changeState(new ReadyState(player));
        return "Ready";
    }

    @Override
    public String onNext() {
        return "Paused...";
    }

    @Override
    public String onPrevious() {
        return "Paused...";
    }
}
