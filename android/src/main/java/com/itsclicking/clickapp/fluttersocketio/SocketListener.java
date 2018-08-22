package com.itsclicking.clickapp.fluttersocketio;

import com.github.nkzawa.emitter.Emitter;
import com.google.gson.Gson;

import io.flutter.plugin.common.MethodChannel;

public class SocketListener implements Emitter.Listener {

    private MethodChannel _methodChannel;
    private String _event;
    private String _callback;

    public SocketListener(MethodChannel methodChannel, String event, String callback) {
        _methodChannel = methodChannel;
        _event = event;
        _callback = callback;
    }

    public String getCallback() {
        return _callback;
    }

    @Override
    public void call(Object... args) {
        if (args != null && _methodChannel != null && !Utils.isNullOrEmpty(_event)
                && !Utils.isNullOrEmpty(_callback)) {
            _methodChannel.invokeMethod(_event + "|" + _callback, args[0].toString());
        }
    }
}