public class SunpterException extends IllegalArgumentException{
    public SunpterException() {
        super("You have not entered a valid Sunpter command. Please try again with \n" +
                "todo deadline event mark unmark or Bye");
    }
}
