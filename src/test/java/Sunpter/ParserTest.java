package Sunpter;

import command.*;
import exception.SunpterException;
import org.junit.jupiter.api.Test;
import parser.Parser;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {
    private final Parser parser = new Parser();

    @Test
    void testParseCommand_addCommand() throws SunpterException {
        Command command = parser.parseCommand("ADD Buy milk");
        assertInstanceOf(AddCommand.class, command);
    }

    @Test
    void testParseCommand_deleteCommand() throws SunpterException {
        Command command = parser.parseCommand("DELETE 2");
        assertInstanceOf(DeleteCommand.class, command);
    }

    @Test
    void testParseCommand_markCommand() throws SunpterException {
        Command command = parser.parseCommand("MARK 1");
        assertInstanceOf(MarkCommand.class, command);
    }

    @Test
    void testParseCommand_unmarkCommand() throws SunpterException {
        Command command = parser.parseCommand("UNMARK 3");
        assertInstanceOf(UnmarkCommand.class, command);
    }

    @Test
    void testParseCommand_listCommand() throws SunpterException {
        Command command = parser.parseCommand("LIST");
        assertInstanceOf(ListCommand.class, command);
    }

    @Test
    void testParseCommand_byeCommand() throws SunpterException {
        Command command = parser.parseCommand("BYE");
        assertInstanceOf(ByeCommand.class, command);
    }

    @Test
    void testParseCommand_invalidCommand() {
        Exception exception = assertThrows(SunpterException.class, () ->
                parser.parseCommand("UNKNOWN 123"));
        assertEquals("Incorrect Commmand", exception.getMessage());
    }
}

