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

    ReplyKeyboardMarkup getRandomSteamKeysMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow steamKeyRow1 = new KeyboardRow();
        KeyboardRow steamKeyRow2 = new KeyboardRow();
        KeyboardRow steamKeyRow3 = new KeyboardRow();
        KeyboardRow steamKeyRow4 = new KeyboardRow();
        KeyboardRow menuRow2 = new KeyboardRow();


        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        steamKeyRow4.add(Constants.STEAMKEY5);
        steamKeyRow1.add(Constants.STEAMKEY15);
        steamKeyRow2.add(Constants.STEAMKEY50);
        steamKeyRow3.add(Constants.STEAMKEYAAA);
        menuRow2.add(Constants.MENU);
        keyboard.add(steamKeyRow1);
        keyboard.add(steamKeyRow2);
        keyboard.add(steamKeyRow3);
        keyboard.add(steamKeyRow4);
        keyboard.add(menuRow2);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    ReplyKeyboardMarkup getAAASteamKeysMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow steamKeyRow1 = new KeyboardRow();
        KeyboardRow menuRow2 = new KeyboardRow();


        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        steamKeyRow1.add(Constants.STEAMKEYGTA);
        menuRow2.add(Constants.MENU);
        keyboard.add(steamKeyRow1);
        keyboard.add(menuRow2);
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
        steamKeyRow2.add(Constants.STEAMKEYSAAA);
        steamKeyRow1.add(Constants.STEAMKEYSRANDOM);
        menuRow2.add(Constants.MENU);
        keyboard.add(steamKeyRow1);
        keyboard.add(steamKeyRow2);
        keyboard.add(menuRow2);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }

    ReplyKeyboardMarkup getHelpMenuReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow steamKeyRow1 = new KeyboardRow();
        KeyboardRow steamKeyRow2 = new KeyboardRow();
        KeyboardRow steamKeyRow3 = new KeyboardRow();
        KeyboardRow menuRow2 = new KeyboardRow();


        replyKeyboardMarkup.setOneTimeKeyboard(true);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        steamKeyRow1.add(Constants.HELPSTEAMKEY15);
        steamKeyRow2.add(Constants.HELPSTEAMKEY50);
        steamKeyRow3.add(Constants.HELPSTEAMKEYAAA);
        menuRow2.add(Constants.MENU);
        keyboard.add(steamKeyRow1);
        keyboard.add(steamKeyRow2);
        keyboard.add(steamKeyRow3);
        keyboard.add(menuRow2);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}
