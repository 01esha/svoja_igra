package svojak;

public class ClassProperty {
    private final static ClassProperty instance = new ClassProperty();

    public static ClassProperty getInstance() {
        return instance;
    }

    private String Theme1Name = "gfgf";

    public String ThemeNameGet() {
        return Theme1Name;
    }
    public void ThemeNameSet(String Theme) {
        Theme1Name = Theme;
    }
    
}
