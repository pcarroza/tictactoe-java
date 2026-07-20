package com.citadel.tictactoe.core.modules;

import com.citadel.tictactoe.controllers.modules.player.local.LocalProfileController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.player.ProfileRegistry;
import com.citadel.tictactoe.views.console.core.Module;
import com.citadel.tictactoe.views.core.ProfileView;

public class ProfileModule implements Module {

    private final ProfileRegistry profileRegistry;

    public ProfileModule(ProfileRegistry profileRegistry) {
        this.profileRegistry = profileRegistry;
    }

    @Override
    public void run() {
        LocalProfileController controller = new LocalProfileController(profileRegistry);
        ProfileView profileView = AppConfig.viewType().createProfileView();
        profileView.interact(controller);
    }
}
