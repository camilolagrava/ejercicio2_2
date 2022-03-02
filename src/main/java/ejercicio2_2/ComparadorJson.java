package ejercicio2_2;

import org.json.JSONObject;

import static org.json.JSONObject.getNames;

public class ComparadorJson {

    public String jsonAreEqual(String expected,String actual, String msgError){
        JSONObject e= new JSONObject(expected);
        JSONObject a = new JSONObject(actual);
        String result = this.equalJ(e,a,"","");

        if(result.equals("")){
            return "ok";
        }else {
            return result + "\nmensaje de error: "+msgError+"\n";
        }
    }

    private String equalJ(Object e, Object a,String position,String msg) {

        JSONObject pibote = new JSONObject();

        if(e.getClass().equals(pibote.getClass()) && a.getClass().equals(pibote.getClass())){

            JSONObject exp = (JSONObject) e;
            JSONObject act = (JSONObject) a;

            String[] expArr = getNames(exp);
            String[] actArr = getNames(act);


            if(expArr.length == actArr.length){
                boolean acc = false;
                for (int i = 0; i < expArr.length; i++) {
                    for (int j = 0; j < actArr.length; j++) {
                        if(expArr[i].equals(actArr[j]) ){
                            if(!(exp.get(expArr[i]).equals("IGNORE"))){
                                msg = msg+equalJ(exp.get(expArr[i]),act.get((actArr[j])),expArr[i],msg);
                            }
                            acc = true;
                        }
                    }
                    if( !acc ){
                        msg = msg + "\nEn: "+position+" "+expArr[i]+" no fue encontrado";
                    }
                }
            }else {
                msg = msg + "\nEn: "+position+" los json no tienen el mismo nuemro de items ";
            }


        }else{
            if (!e.equals(a)){
                    msg = msg + "\nEn: "+position+" el item no es igual";
            }
        }
        return msg;

    }


}
