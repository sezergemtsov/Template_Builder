public class PersonBuilder {

    private String name;
    private String scdName;
    private int age = -1;
    private String address = null;

    public PersonBuilder() {
    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setScdName(String scdName) {
        this.scdName = scdName;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build(){

            Person person = null;
            try {
                if (age != -1) {
                    person = new Person(name, scdName, age);
                    if (address != null) {
                        person.setAddress(address);
                    }
                    return person;
                } else {
                    person = new Person(name, scdName);
                    if (address != null) {
                        person.setAddress(address);
                    }
                    return person;
                }
            } catch (IlligalArgumentsException e) {
                throw new RuntimeException(e);
            }
    }

}
