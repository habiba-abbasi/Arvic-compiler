/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylexer;

/**
 *
 * @author Habiba Abbasii
 */
public class Method {
    
private int scope;
private int func_no;
private String Class_;
private String name;
private String RT;
private String[] argsList;


    Method(String name, int sco, String class_, String Ret_type, String[] argsList) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    this.name = name;
    this.Class_=class_;
    this.RT = Ret_type;
      this.argsList=argsList;
    
    
    }
//String habiba(int a,String b){
//return "habiba";}
//int habiba(char a ,String b){
//   // String b="habiba";
//return 1;}
     
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRT() {
        return RT;
    }

    public void setRT(String RT) {
        this.RT = RT;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }

    public int getFunc_no() {
        return func_no;
    }

    public void setFunc_no(int func_no) {
        this.func_no = func_no;
    }

    public String[] getArgsList() {
        return argsList;
    }

    public void setArgsList(String[] argsList) {
        this.argsList = argsList;
    }

    public String getClass_() {
        return Class_;
    }

    public void setClass_(String Class_) {
        this.Class_ = Class_;
    }

   
}
