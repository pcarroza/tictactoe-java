package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.player.local.LocalProfileController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.ProfileView;

public class ProfileFeature implements Feature {

    @Override
    public void run() {
        LocalProfileController controller = new LocalProfileController();
        ProfileView profileView = AppConfig.viewType().createProfileView();
        profileView.interact(controller);
    }
}
