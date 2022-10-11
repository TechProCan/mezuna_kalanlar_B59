package Pages;

public class AllPages {
    public AllPages(){

    }
    private MainPage mainPage;

    public MainPage mainPage(){
        if (mainPage==null){
            mainPage=new MainPage();
        }
        return mainPage;
    }
}
