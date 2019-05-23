package demo.first.source;

public class Employee {

    private String name;
    private GeneralAddress generalAddress;
    private SpecialAddress specialAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GeneralAddress getGeneralAddress() {
        return generalAddress;
    }

    public void setGeneralAddress(GeneralAddress generalAddress) {
        this.generalAddress = generalAddress;
    }

    public SpecialAddress getSpecialAddress() {
        return specialAddress;
    }

    public void setSpecialAddress(SpecialAddress specialAddress) {
        this.specialAddress = specialAddress;
    }
}
