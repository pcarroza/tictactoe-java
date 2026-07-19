package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.player.local.LocalProfileController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.player.ProfileRegistry;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.ProfileView;

public class ProfileFeature implements Feature {

    private final ProfileRegistry profileRegistry;

    public ProfileFeature(ProfileRegistry profileRegistry) {
        this.profileRegistry = profileRegistry;
    }

    @Override
    public void run() {
        LocalProfileController controller = new LocalProfileController(profileRegistry);
        ProfileView profileView = AppConfig.viewType().createProfileView();
        profileView.interact(controller);
    }
}
