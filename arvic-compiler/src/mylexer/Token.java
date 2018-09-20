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
public class Token {
    public Mylexer.TokenType type;
    public String data;
    int line_no;

    
    
    public Token(Mylexer.TokenType type, String data,int line_no) {
      this.type = type;
      this.data = data;
      this.line_no=line_no;
     
    }

   

    @Override
    public String toString() {
        
     return String.format("(%s , %s , %d)", type.name(), data, line_no);
    }
  }
