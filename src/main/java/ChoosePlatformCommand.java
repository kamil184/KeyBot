import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;

public final class ChoosePlatformCommand extends BotsCommand {

    private final ICommandRegistry mCommandRegistry;

    public ChoosePlatformCommand(ICommandRegistry commandRegistry) {
        super(Constants.CHOOSE_PLATFORM, "список доступных платформ");
        mCommandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {

        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        message.setText("Выберите платформу");

        message.setReplyMarkup(getReplyKeyboard());

        execute(absSender, message, user);
    }

    ReplyKeyboardMarkup getReplyKeyboard(){
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        ArrayList<KeyboardRow> keyboard = new ArrayList<>();
        KeyboardRow steamRow = new KeyboardRow();
        KeyboardRow originRow = new KeyboardRow();

        replyKeyboardMarkup.setOneTimeKeyboard(false);
        replyKeyboardMarkup.setSelective(true);
        replyKeyboardMarkup.setResizeKeyboard(true);

        keyboard.clear();
        steamRow.add(Constants.STEAM);
        originRow.add(Constants.ORIGIN);
        keyboard.add(steamRow);
        keyboard.add(originRow);
        replyKeyboardMarkup.setKeyboard(keyboard);
        return replyKeyboardMarkup;
    }
}