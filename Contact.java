package uz.pdp.contact.models;

import java.util.List;

public class Contact {
    private String contactName;
    private List<String> numbers;

    public Contact(String contactName, List<String> numbers) {
        this.contactName = contactName;
        this.numbers = numbers;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public List<String> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<String> numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(contactName).append("%");
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numbers.size(); i++) {
            s.append(numbers.get(i)).append("#");
        }
        stringBuilder.append(s.toString()).append("\n");
        return stringBuilder.toString();
    }
}
