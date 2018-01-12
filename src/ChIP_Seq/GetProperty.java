package ChIP_Seq;

/**
 * Created by lily on 8/31/16.
 */
public class GetProperty {
    public GetProperty(){
        super();
    }
    public static String getPropertyByName(String path,String name){
        String result="";
        try{
            result=java.util.ResourceBundle.getBundle(path).getString(name);
            System.out.println("name:"+result);
        }catch(Exception e){
            System.out.println("getPropertyByName error:"+name);
        }
        return result;
    }
}
