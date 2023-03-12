import model.EmailType;
import service.PhoneBookService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        PhoneBookService service = new PhoneBookService();
        service.add("Arman", List.of("033322269", "033012232"));
        service.add("Karo", List.of("033322262", "033012235"));
        service.add("ArmanH", List.of("033322261", "033012231"));
        service.add("ArmanHam", List.of("033322266", "033012200"));
        service.add("Arm", List.of("033322248", "033012270"));

        System.out.println(service.searchBy("Karo"));
        System.out.println(service.deleteBy("Karoo"));
        System.out.println(service.searchBy("Karo"));

        service.updateBy("Arman", null, List.of("099", "088"), List.of("email1", "email 2"),
                null, null,EmailType.GMAIL);
        System.out.println(service.searchBy("Arman"));

        service.view();

        service.sortByName();

        service.view();
    }
}