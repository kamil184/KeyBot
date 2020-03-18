import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.K;
import org.telegram.telegrambots.extensions.bots.commandbot.commands.ICommandRegistry;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.bots.AbsSender;

import java.util.ArrayList;

public final class StartCommand extends BotsCommand {

    private final ICommandRegistry mCommandRegistry;

    public StartCommand(ICommandRegistry commandRegistry) {
        super("start", "старт");
        mCommandRegistry = commandRegistry;
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        SendMessage message = new SendMessage();
        message.setChatId(chat.getId().toString());
        message.setText("Привет, я бот по продаже игровых ключей");

        Menu menu = new Menu();

        message.setReplyMarkup(menu.getMainMenuReplyKeyboard());

        execute(absSender, message, user);
    }


}