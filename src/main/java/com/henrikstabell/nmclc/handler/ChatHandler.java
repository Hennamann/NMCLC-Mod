package com.henrikstabell.nmclc.handler;

import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ChatHandler {

    @SubscribeEvent
    public void onGetChatMessage(ClientChatEvent event) {
        String message = event.getMessage();

        if (message.startsWith("/")) {
            String lowerCapsMessage = message.toLowerCase();
            event.setMessage(lowerCapsMessage);
        }
    }
}
