package learnandtry.guava.predicates;

public class AppBean {

    private String name;
    private Boolean enabled;

    public AppBean(String name) {
        this.name = name;
    }

    public AppBean(Boolean enabled) {
        this.enabled = enabled;
    }

    public AppBean(String name, Boolean enabled) {
        this.name = name;
        this.enabled = enabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
