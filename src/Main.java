import model.email.Email;
import model.email.EmailType;
import model.phone.Phone;
import model.phone.PhoneType;
import service.PhoneBookService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBookService service = new PhoneBookService();
        service.add("Arman", List.of(new Phone("0333222690", PhoneType.HOME)));
        service.add("Karo", List.of(new Phone("0123456789", PhoneType.WORK), new Phone("0333222691", PhoneType.SCHOOL)));
        service.add("ArmanH", List.of(new Phone("0987653698", PhoneType.MOBILE)));



        service.updateBy("Arman", "Armo",
                List.of(new Phone("0123456798", PhoneType.HOME)),
                List.of(new Email("arman@mail.com", EmailType.GMAIL)),
                null);

        service.view();

        service.updateBy("Karo", "Karen",
                List.of(new Phone("0987653698", PhoneType.SCHOOL)),
                List.of(new Email("arman@mail.com", EmailType.GMAIL)),
                null);


        service.sortByName();

        service.view();
    }
}