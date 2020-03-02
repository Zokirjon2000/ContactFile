package ContactFile;

import java.util.List;
import java.util.Map;

public class WriteContactFile {

    private String name;
    private List<String> contactnumber ;

    public WriteContactFile(String name, List<String> contactnumber) {
        this.name = name;
        this.contactnumber = contactnumber;
    }
    public WriteContactFile(){

    }

    public List<String> getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(List<String> contactnumber) {
        this.contactnumber = contactnumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  name  + " -> " + contactnumber + "  "   ;
    }
}
