import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;

public class Menu {

    ReplyKeyboardMarkup getMainMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow helpRow = new KeyboardRow();
        KeyboardRow choosePlatformRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        helpRow.add(Constants.HELP);
        choosePlatformRow.add(Constants.CHOOSE_PLATFORM);
        keyboard.add(helpRow);
        keyboard.add(choosePlatformRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    ReplyKeyboardMarkup getPlatformMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow steamRow = new KeyboardRow();
        KeyboardRow originRow = new KeyboardRow();
        KeyboardRow uplayRow = new KeyboardRow();
        KeyboardRow menuRow2 = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        steamRow.add(Constants.STEAM);
        originRow.add(Constants.ORIGIN);
        uplayRow.add(Constants.UPLAY);
        menuRow2.add(Constants.MENU);
        keyboard.add(steamRow);
        keyboard.add(originRow);
        keyboard.add(uplayRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    ReplyKeyboardMarkup getSteamKeysMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow steamKeyRow1 = new KeyboardRow();
        KeyboardRow steamKeyRow2 = new KeyboardRow();
        KeyboardRow menuRow2 = new KeyboardRow();


        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        steamKeyRow1.add(Constants.STEAMKEY30);
        steamKeyRow2.add(Constants.STEAMKEY120);
        menuRow2.add(Constants.MENU);
        keyboard.add(steamKeyRow1);
        keyboard.add(steamKeyRow2);
        keyboard.add(menuRow2);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
