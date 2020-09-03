package com.example.firstarapp;

import com.google.ar.core.Config;
import com.google.ar.core.Session;
import com.google.ar.sceneform.ux.ArFragment;

public class CustomFragment extends ArFragment {
    //we can't use multiple identical fragment for ar app -> configure
    @Override
    protected Config getSessionConfiguration(Session session) {
        Config config = new Config(session);
        config.setUpdateMode(Config.UpdateMode.LATEST_CAMERA_IMAGE);
        config.setFocusMode(Config.FocusMode.AUTO);
        session.configure(config);

        this.getArSceneView().setupSession(session);
        ((MainActivity) getActivity()).setUpDatabase(config,session);
        return config;
    }
}
