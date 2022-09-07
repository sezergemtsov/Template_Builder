public class Person {
    private final String name;
    private final String scdName;
    private int age = -1;
    private String address = null;

    public Person(String name, String scdName) throws IlligalArgumentsException {
        if (name == null) {
            throw new IlligalArgumentsException("name must be value");
        } else if (scdName==null) {
            throw new IlligalArgumentsException("second name must be value");
        }
        this.name = name;
        this.scdName = scdName;
    }

    public Person(String name, String scdName, int age) throws IlligalArgumentsException {
        this(name,scdName);
        try {
            setAge(age);
        } catch (IlligalArgumentsException e) {
            throw new RuntimeException(e);
        }
    }

    private void setAge(int age) throws IlligalArgumentsException {
        if (this.age == -1) {
            if (age < 150 & age >= 0) {
                this.age = age;
            } else {
                throw new IlligalArgumentsException("age must be more then 0 and less then 150");
            }
        } else {
            throw new IlligalArgumentsException("Age was already set");
        }
    }

    public void happyBirthday() {
        age += 1;
    }

    public boolean hasAge() {
        if (age != -1) {
            return true;
        }
        return false;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getScdName() {
        return scdName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
    public boolean hasAddress() {
        if (address != null) {
            return true;
        }
        return false;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder childBuilder = new PersonBuilder();
        childBuilder.setScdName(this.scdName);
        childBuilder.setAge(0);
        childBuilder.setAddress(this.address);
        return childBuilder;
    }

    @Override
    public String toString() {
        return name + " " + scdName;
    }
}
