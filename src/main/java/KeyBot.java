import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class KeyBot extends TelegramLongPollingCommandBot {

    public KeyBot() {
        HelpCommand helpCommand = new HelpCommand(this);
        register(helpCommand);
        BuyCommand buyCommand = new BuyCommand(this);
        register(buyCommand);
        StartCommand startCommand = new StartCommand(this);
        register(startCommand);
        ChoosePlatformCommand choosePlatformCommand = new ChoosePlatformCommand(this);
        register(choosePlatformCommand);
    }

    public String getBotUsername() {
        return "CamelKeys";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        sendMessageToUser(msg.getChatId(), "Такой команды нет, попробуй /help");
    }

    private void sendMessageToUser(long chatId, String text) {
        SendMessage message = new SendMessage();
        message.setText(text);
        message.setChatId(chatId);
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.err.println(e);
        }
    }

    @Override
    public String getBotToken() {
        return "1121809496:AAHnrgriH3039nq59ePJyWoKXS1Mrc_y0uo";
    }

    public static SendMessage sendInlineKeyBoardMessage(long chatId, Message message) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        //List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("Зарегаться").setCallbackData("Создатель этого бота"));
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("God").setCallbackData("This bot creator"));
        keyboardButtonsRow1.add(new InlineKeyboardButton().setText("UserInfo").setCallbackData("Я знаю многое о тебе, " + getUserInfo(message, "userName") + " aka " + getUserInfo(message, "firstName") + " " + getUserInfo(message, "lastName")));
        // keyboardButtonsRow2.add(inlineKeyboardButton2);
        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        //rowList.add(keyboardButtonsRow2);
        inlineKeyboardMarkup.setKeyboard(rowList);
        return new SendMessage().setChatId(chatId).setText("Ну чтож").setReplyMarkup(inlineKeyboardMarkup);
    }

    private static String getUserInfo(Message message, String type) {
        switch (type) {
            case "firstName":
                return message.getFrom().getFirstName();
            case "lastName":
                return message.getFrom().getLastName();
            case "id":
                return message.getFrom().getId().toString();
            case "userName":
                return message.getFrom().getUserName();
        }
        return null;
    }
}