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
public class var {
 
private String name;
private String type;
private int scope;
private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
private int func_no;
 public var(String name, String type,int scope) {
      this.name = name;
      this.type = type;
      this.scope=scope;
     
    }
 public var(String name, String type,int scope,int size) {
      this.name = name;
      this.type = type;
      this.scope=scope;
      this.size=size;
    }
   

    public int getFunc_no() {
        return func_no;
    }

    public void setFunc_no(int func_no) {
        this.func_no = func_no;
    }
var(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(int scope) {
        this.scope = scope;
    }





}
