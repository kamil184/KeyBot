import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class KeyBot extends TelegramLongPollingCommandBot {

    public KeyBot() {
        HelpCommand helpCommand = new HelpCommand(this);
        //register(helpCommand);
        BuyCommand buyCommand = new BuyCommand(this);
        //register(buyCommand);
        StartCommand startCommand = new StartCommand(this);
        //register(startCommand);
        ChoosePlatformCommand choosePlatformCommand = new ChoosePlatformCommand(this);
        //register(choosePlatformCommand);
    }

    public String getBotUsername() {
        return "CamelKeys";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        long chatId = msg.getChatId();
        Buy buy = new Buy();
        String comId;
        Menu menu = new Menu();
        switch (msg.getText()){
            case Constants.STEAMKEY1: {
                boolean b;
                comId = buy.getAlphaNumericString(15);
                sendMessageToUser(chatId,"Проведите платеж в размере 30 рублей на номер +79370073938 (qiwi), в комментарии укажите то, что я пришлю ниже.\n**Внимание!** Без этого комментария платеж засчитан не будет!");
                sendMessageToUser(chatId,comId);
                b=buy.Sell(30,comId);
               // sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard());
                if(b) {
                    sendMessageToUser(chatId, "Платеж найден, вот Ваш ключ:"); //todo достать из бд ключ
                    sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Возвращаю в меню");
                }else
                    sendMessageToUser(chatId,"Платеж не найден.\n Если Вы уверены, что это ошибка, обратитесь в раздел меню -> помощь.");
                break;
            }
            case Constants.STEAMKEY2: {
                boolean b;
                comId= buy.getAlphaNumericString(15);
                sendMessageToUser(chatId,"Проведите платеж в размере 120 руб на номер +79370073938 (qiwi), в комментарии укажите то, что я пришлю ниже.\n**Внимание!** Без этого комментария платеж засчитан не будет!");
                sendMessageToUser(chatId,comId);
                b=buy.Sell(120,comId);
                //sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard());
                if(b) {
                    sendMessageToUser(chatId, "Платеж найден, вот Ваш ключ:"); //todo достать из бд ключ
                    sendKeyboardMarkupToUser(chatId, menu.getMainMenuReplyKeyboard(), "Возвращаю в меню");
                }else
                    sendMessageToUser(chatId,"Платеж не найден.\n Если Вы уверены, что это ошибка, обратитесь в раздел меню -> помощь.");
                break;
            }
            case "Купить": {
                sendKeyboardMarkupToUser(chatId,menu.getPlatformMenuReplyKeyboard(),"Выберите платформу");
                break;
            }
            case "Steam": {
                sendKeyboardMarkupToUser(chatId,menu.getSteamKeysMenuReplyKeyboard(),"Выберите товар");
                break;
            }
            case "Origin":{
                sendMessageToUser(chatId,"Упс,этот раздел еще в разработке...");
                break;
            }
            case "Uplay":{
                sendMessageToUser(chatId,"Упс,этот раздел еще в разработке...");
                break;
            }
            case "Меню":{
                sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard(),"Выберите раздел меню");
                break;
            }
            case "Помощь":{
                sendMessageToUser(chatId,Constants.HELPTEXT);
                break;
            }
        }
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
    private void sendKeyboardMarkupToUser(long chatId,ReplyKeyboardMarkup replyKeyboardMarkup,String reply){
       SendMessage message = new SendMessage();
       message.setReplyMarkup(replyKeyboardMarkup);
       message.setText(reply);
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