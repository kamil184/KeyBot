import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import orm.Key;
import orm.KeyDao;

public class KeyBot extends TelegramLongPollingCommandBot {

    public KeyBot() {
        StartCommand startCommand = new StartCommand(this);
        register(startCommand);
    }

    public String getBotUsername() {
        return "CamelKeys";
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        Message msg = update.getMessage();
        long chatId = msg.getChatId();
        Menu menu = new Menu();
        switch (msg.getText()){
            case Constants.STEAMKEY15: {
                buy(Constants.STEAM, 15, chatId);
                break;
            }
            case Constants.STEAMKEY50: {
                buy(Constants.STEAM, 50, chatId);
                break;
            }
            case Constants.STEAMKEYAAA: {
                buy(Constants.STEAM, 250, chatId);
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
                sendKeyboardMarkupToUser(chatId,menu.getHelpMenuReplyKeyboard(),Constants.INFOTEXT);
                break;
            }
            case Constants.HELPSTEAMKEY15:{
                sendMessageToUser(chatId,Constants.INFOSTEAMKEY15);
                break;
            }
            case Constants.HELPSTEAMKEY50:{
                sendMessageToUser(chatId,Constants.INFOSTEAMKEY50);
                break;
            }
            case Constants.HELPSTEAMKEYAAA:{
                sendMessageToUser(chatId,Constants.INFOSTEAMKEYAAA);
            }
            default:{
                if (!msg.getText().equals("/start")){
                    sendMessageToUser(chatId, "Извини, но я тебя не понимаю, \nпопробуй нажать /start");
                }
            }
        }
    }

    private void buy(String platform, int price, long chatId){
        Thread method2Thread = new Thread(() -> {
            Buy buy = new Buy();
            Menu menu = new Menu();
            KeyDao dao = new KeyDao();
            Key key = dao.get(platform, price);
            if(key == null){
                sendMessageToUser(chatId,"Просим прощения, ключи " + platform + " по " + price + " рублей закончились, попробуйте купить в следующий раз или выберите другой раздел");
            }else {
                dao.reserve(key, chatId);
                boolean b;
                String comId = buy.getAlphaNumericString(15);
                sendMessageToUser(chatId, "Проведите платеж в размере " + price + " руб на номер +79370073938 (qiwi), в комментарии укажите то, что я пришлю ниже.\n**Внимание!** Без этого комментария платеж засчитан не будет!");
                sendMessageToUser(chatId, comId);
                b = buy.Sell(price, comId);
                //sendKeyboardMarkupToUser(chatId,menu.getMainMenuReplyKeyboard());
                if (b) {
                    sendMessageToUser(chatId, "Платеж найден, вот Ваш ключ:");
                    sendMessageToUser(chatId, key.getKey());
                    dao.delete(key);
                    sendKeyboardMarkupToUser(chatId, menu.getMainMenuReplyKeyboard(), "Возвращаю в меню");
                } else {
                    dao.reserve(key, -1);
                    sendMessageToUser(chatId, "Платеж не найден.\n Если Вы уверены, что это ошибка, обратитесь в раздел меню -> помощь.");
                }
            }
        });method2Thread.start();
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

    /*private static String getUserInfo(Message message, String type) {
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
    }*/
}