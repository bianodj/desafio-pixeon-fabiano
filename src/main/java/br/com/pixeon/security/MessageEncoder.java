package br.com.pixeon.security;

import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import br.com.pixeon.app.bean.MessageBean;

public class MessageEncoder implements Encoder.Text<MessageBean> {

    private static Gson gson = new Gson();

    @Override
    public String encode(MessageBean message) throws EncodeException {
        String json = gson.toJson(message);
        return json;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        // Custom initialization logic
    }

    @Override
    public void destroy() {
        // Close resources
    }
}
