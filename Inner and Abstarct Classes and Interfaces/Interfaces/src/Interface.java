public class Interface {

    public static void main(String[] args) {
    ITelephone danielsPhone; //DeskPhone danielsPhone (alternative)
    danielsPhone = new DeskPhone(123456);
    danielsPhone.powerOn();
    danielsPhone.callPhone(123456);
    danielsPhone.answer();

    danielsPhone = new MobilePhone(234567);
    danielsPhone.powerOn();
    danielsPhone.callPhone(234567);
    danielsPhone.answer();
    }
}
