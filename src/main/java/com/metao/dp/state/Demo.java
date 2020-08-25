package com.metao.dp.state.another;

import com.metao.dp.state.another.Player;
import com.metao.dp.state.another.UI;

/**
 * Demo class. Everything comes together here.
 */
public class Demo {
    public static void main(String[] args) {
        Player player = new Player();
        UI ui = new UI(player);
        ui.init();
    }
}
