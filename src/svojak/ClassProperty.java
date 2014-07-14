package svojak;

public class ClassProperty {
    private final static ClassProperty instance = new ClassProperty();

    public static ClassProperty getInstance() {
        return instance;
    }

    private String Theme1Name = "тема 1";
    private String Theme2Name = "тема 2";
    private String Theme3Name = "тема 3";
    private String Theme4Name = "тема 4";
    private String Theme5Name = "тема 5";
    private short numberTour = 1;
    private int [][] arr_bonus;

    public String ThemeNameGet(int i) {        
        switch (i){
            case 1 :                
                return Theme1Name;
            case 2 :
                return Theme2Name;
            case 3 :
                return Theme3Name;
            case 4 :
                return Theme4Name;
            case 5 :
                return Theme5Name;
        }
        return " ";
    }
    public void ThemeNameSet(String Theme, int i) {
        switch (i){
           case 1 :
                Theme1Name = Theme;
                break;
           case 2 :
                Theme2Name = Theme;
                break;
           case 3 :
                Theme3Name = Theme;
                break;
           case 4 :
                Theme4Name = Theme;
                break;
           case 5 :
                Theme5Name = Theme;
                break;
        }
    }
    
    public short TourNumGet(){
        return numberTour;
    }
    public void TourNumSet(short Num){
        numberTour = Num;
    }
    
    public void arrBonusSet(int MaxTheme){
        arr_bonus = new int [MaxTheme][5];
    }
}
