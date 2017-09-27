package br.com.pixeon.security;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

import com.google.gson.Gson;

import br.com.pixeon.app.bean.MessageBean;

public class MessageDecoder implements Decoder.Text<MessageBean> {

    private static Gson gson = new Gson();

    @Override
    public MessageBean decode(String s) throws DecodeException {
        MessageBean message = gson.fromJson(s, MessageBean.class);
        return message;
    }

    @Override
    public boolean willDecode(String s) {
        return (s != null);
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
