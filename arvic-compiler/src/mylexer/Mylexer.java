/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylexer;

import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import static java.lang.Character.isDigit;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Habaiba Abbasi
 */
public class Mylexer {
    public static boolean flag= false;
    static ArrayList<Token> finalToken= new ArrayList<Token>();
    private static void Lexer(String reading, int LineNumber) {
    ArrayList<Token> tokens = lex(reading,LineNumber);
    
    
    
    
    
    for(Token token : tokens) 
    {
    System.out.println(tokens);
    finalToken.add(token);
        
    }
   // numberofToken=tokens.size();
    return;
        
    }
    
/**
 *
 * @author Habiba Abbasii
 */
public static enum TokenType {
      
    
    // Token types 

    /**
     *
     */
    flo("[-+]?[\\d]*[.][\\d]+|[-+]?[\\d]+[.][\\d]*"),

    /**
     *
     */
    num("[-|+]?[0-9]+"),

    /**
     *
     */
    ch("[~][\\\\]?[\\\\]?[a-zA-Z0-9\\\\][~]"),

    /**
     *
     */
    bo("yes$|no$"),

    /**
     *
     */
    str("[@][a-z|A-Z|0-9|!|#|$|@|%}^|&}*|(|)]*[@]"), 
    //AddSub("mul$|div$|add$|sub$|[#]|[*]"),

    /**
     *
     */
    AddSub("add$|sub$"),

    /**
     *
     */
    MulDivMod("mul$|div$|[#]"),

    /**
     *
     */
    LOGICALOP("AND$|NOT$|OR$"),

    /**
     *
     */
    RO("<<$|>>$|>>->$|<<->$|->->$|NOT->$"),

    /**
     *
     */
    BITWISEOP("ANDB$|ORB$|NOT$|XOB$"),

    /**
     *
     */
    INCDEC("INC$|DEC$"),

    /**
     *
     */
    OPT("shr$|shl$"),

    /**
     *
     */
    WHITESPACE("[ \t\f\r\n]"),

    /**
     *
     */
    AssgnOp("->$"),

    /**
     *
     */
    PARAM("<$|>$"),

    /**
     *
     */
    BODYBRACKET("\\{$|\\}$"),

    /**
     *
     */
    ARRAYBRACKET("\\[$|\\]$"),

    /**
     *
     */
    Comma(","),

    /**
     *
     */
    Dot("[.]"),

    /**
     *
     */
    Colon(":"),

    /**
     *
     */
    KEYWORDS("cycle$|class$|life$|void$|home$|key$|set$|resume$|drop$|go$|last$|let$|fixed$|whether$|other$|deliver$|trial$|visit$|this$|blank$|formation$|old$"),
   // WORDBREAKER("[<|!|>|@|{|.|}]"),

    /**
     *
     */
    DT("num$|flo$|ch$|str$|bo$"),

    /**
     *
     */
    AccessMod("public$|private$|protected$"),

    /**
     *
     */
    TERMINATOR("!"),

    /**
     *
     */
    ID("[a-zA-Z][a-zA-Z0-9_]*"),

    /**
     *
     */
    Invalid("");
    

      //,INV_FLO(".[+|-]?|.[A-Z|a-z]+|.[0-9]+")

    /**
     *
     */
public final String pattern;
    private TokenType(String pattern) {
      this.pattern = pattern;
    }
  }

  

  public static ArrayList<Token> lex(String input,int lno) {
    // The tokens to return
    ArrayList<Token> tokens = new ArrayList<Token>();

    // Lexer logic begins here
    StringBuffer tokenPatternsBuffer = new StringBuffer();
    for (TokenType tokenType : TokenType.values())
      tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
    Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));
   
  
      

    // Begin matching tokens
    Matcher matcher = tokenPatterns.matcher(input);
    while (matcher.find()) {
        //System.out.println("arr: "+arr[i]);
        
      if (matcher.group(TokenType.flo.name()) != null) {
        tokens.add(new Token(TokenType.flo, matcher.group(TokenType.flo.name()),lno));
        break;
      }
      if (matcher.group(TokenType.num.name()) != null) {
        tokens.add(new Token(TokenType.num, matcher.group(TokenType.num.name()),lno));
        break;
      }
      else if (matcher.group(TokenType.ch.name()) != null) {
        tokens.add(new Token(TokenType.ch, matcher.group(TokenType.ch.name()),lno));
        break;
      } else if (matcher.group(TokenType.LOGICALOP.name()) != null) {
        tokens.add(new Token(TokenType.LOGICALOP, matcher.group(TokenType.LOGICALOP.name()),lno));
        break;
      }
     else if (matcher.group(TokenType.AddSub.name()) != null) {
        tokens.add(new Token(TokenType.AddSub, matcher.group(TokenType.AddSub.name()),lno));
     break;
      }
     else if (matcher.group(TokenType.MulDivMod.name()) != null) {
        tokens.add(new Token(TokenType.MulDivMod, matcher.group(TokenType.MulDivMod.name()),lno));
     break;
      }
     else if (matcher.group(TokenType.OPT.name()) != null) {
        tokens.add(new Token(TokenType.OPT, matcher.group(TokenType.OPT.name()),lno));
       break;
      } else if (matcher.group(TokenType.BITWISEOP.name()) != null) {
        tokens.add(new Token(TokenType.BITWISEOP, matcher.group(TokenType.BITWISEOP.name()),lno));
        break;
      }else if (matcher.group(TokenType.AssgnOp.name()) != null) {
        tokens.add(new Token(TokenType.AssgnOp, matcher.group(TokenType.AssgnOp.name()),lno));
       break;
      }
      else if (matcher.group(TokenType.LOGICALOP.name()) != null) {
        tokens.add(new Token(TokenType.LOGICALOP, matcher.group(TokenType.LOGICALOP.name()),lno));
     break;
     }else if (matcher.group(TokenType.RO.name()) != null) {
        tokens.add(new Token(TokenType.RO, matcher.group(TokenType.RO.name()),lno));
     break;
     }  
        else if (matcher.group(TokenType.INCDEC.name()) != null) {
        tokens.add(new Token(TokenType.INCDEC, matcher.group(TokenType.INCDEC.name()),lno));
        break;
      }
         else if (matcher.group(TokenType.str.name()) != null ) {
        tokens.add(new Token(TokenType.str, matcher.group(TokenType.str.name()),lno));
        break;
      }
         else if (matcher.group(TokenType.Colon.name()) != null ) {
        tokens.add(new Token(TokenType.Colon, matcher.group(TokenType.Colon.name()),lno));
        break;
      }
          else if (matcher.group(TokenType.Dot.name()) != null ) {
        tokens.add(new Token(TokenType.Dot, matcher.group(TokenType.Dot.name()),lno));
        break;
      }
          else if (matcher.group(TokenType.bo.name()) != null ) {
        tokens.add(new Token(TokenType.bo, matcher.group(TokenType.bo.name()),lno));
        break;
      }
         else if (matcher.group(TokenType.KEYWORDS.name()) != null) {
        tokens.add(new Token(TokenType.KEYWORDS, matcher.group(TokenType.KEYWORDS.name()),lno));
        break;
      }
      /* else if (matcher.group(TokenType.Dot.name()) != null) {
        tokens.add(new Token(TokenType.Dot, matcher.group(TokenType.Dot.name()),lno));
        break;
      } */
      else if (matcher.group(TokenType.TERMINATOR.name()) != null) {
        tokens.add(new Token(TokenType.TERMINATOR, matcher.group(TokenType.TERMINATOR.name()),lno));
        break;
      }
      else if (matcher.group(TokenType.AccessMod.name()) != null) {
        tokens.add(new Token(TokenType.AccessMod, matcher.group(TokenType.AccessMod.name()),lno));
        break;
      }
        else if (matcher.group(TokenType.DT.name()) != null) {
        tokens.add(new Token(TokenType.DT, matcher.group(TokenType.DT.name()),lno));
        break;
      }
       
       else if (matcher.group(TokenType.ID.name()) != null) {
        tokens.add(new Token(TokenType.ID, matcher.group(TokenType.ID.name()),lno));
        break;
       }
       
       else if (matcher.group(TokenType.PARAM.name()) != null) {
        tokens.add(new Token(TokenType.PARAM, matcher.group(TokenType.PARAM.name()),lno));
        break;
       }
       
       else if (matcher.group(TokenType.Comma.name()) != null) {
        tokens.add(new Token(TokenType.Comma, matcher.group(TokenType.Comma.name()),lno));
        break;
       }
      else if (matcher.group(TokenType.BODYBRACKET.name()) != null) {
        tokens.add(new Token(TokenType.BODYBRACKET, matcher.group(TokenType.BODYBRACKET.name()),lno));
        break;
       }
       else if (matcher.group(TokenType.ARRAYBRACKET.name()) != null) {
        tokens.add(new Token(TokenType.ARRAYBRACKET, matcher.group(TokenType.ARRAYBRACKET.name()),lno));
        break;
       }
     
        else if (matcher.group(TokenType.WHITESPACE.name()) != null){
       // tokens.add(new Token(TokenType.WHITESPACE, matcher.group(TokenType.WHITESPACE.name()),lno));
        break;
    }  
       else{
           // (matcher.group(TokenType.WHITESPACE.name()) == null)
          //  tokens.add(new Token(TokenType., matcher.group(TokenType.SINGLECOMMENTS.name()),lno))
           System.out.println("(Invalid ,"+input+","+ lno+")");
           flag= true;
           break;
        }
    
     }
    return tokens;
  }
  
  
  
    public static void main(String[] args) throws FileNotFoundException, IOException 
   {  
       
     //  System.out.println("here->"+new Semantic().comparison("num","OR", "num"));
       
       int codepoint=0x1F600;
       readFile(new File("in.txt"));
       if(flag==true)
       {
           System.out.println("ERROR Alert !\nCannot Proceed To Syntactical phase ");
           flag=false;
       }
       else{ 
           SyntaxAnalyser Sy = new SyntaxAnalyser();
           
             boolean answer= Sy.main_class();
       
            if(answer==true)
                    System.out.println("PARSED");
            else 
                    System.out.println("SYNTAX ERROR Alert  !\nAt token ~> "+finalToken.get(Sy.tokenindex).data+"\nAt line ~> "+finalToken.get(Sy.tokenindex).line_no);
            }
       
Semantic Se = new Semantic();
Se.main_class(); 

//
//ICG icg=new ICG();
//icg.main_class();
           
}

    private static void readFile(File MyFile) throws FileNotFoundException, IOException {
        
    
    String reading="";
    long lenOfFile =MyFile.length();
    int LineNumber=1;
     FileReader cont = new FileReader(MyFile);
        
         char a,b,p,q = 0;
         long i;
    for (i = 0; i <lenOfFile; i++)
        {
            char c = (char) cont.read();
            
            switch(c){
            
                case '\r':
                case '\n':
                LineNumber++;        //JUMP to next line
                //break;
                case ' ': 
                     if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                    
                    switch(c){
                    
                          case '\r': cont.read(); i++; break;
                          case '\n' :  
                               //LineNumber++;
                              break;        //JUMP to next line
                        }
                  break;
               case '.':
                  
                        int t=(int)reading.length();
                        System.out.println("t is "+t);
                     if (reading!="")
                     {
                        if((reading.charAt(t-1) == '+') || (reading.charAt(t-1) == '-') ||((reading.charAt(t-1)>='0')&&(reading.charAt(t-1)<='9')))
                               {

                                   reading += c;

                                   while(true)
                                   {
                                       a=(char)cont.read();i++;
                                       if( (a >='0') && (a <='9'))
                                        reading = reading + a;
                                       else if(a=='.'){
                                       Lexer(reading,LineNumber);
                                       reading="";
                                       reading+='.';

                                      }
                                       else{
                            String temp="";
                              temp+=a;
                       Lexer(reading,LineNumber);
                        reading="";
                        reading=temp;
                        break;

                                   }                                 
                                   }



                               }

                       else
                           {
                                   Lexer(reading,LineNumber);
                                   Lexer(".",LineNumber);
                                   reading="";
                                   break;
                           }
                        }
                     else{
                     Lexer(".",LineNumber);
                     
                     }
                   break;
                case '-':
                   
                    a=(char)cont.read();i++;
                    if(a =='>')
                    {
                        if(reading != "")
                       {  
                         Lexer(reading,LineNumber);
                         reading="";
                       }
                      
                        p=(char)cont.read();i++;
                        
                      if((p =='-'))
                        {
                            q=(char)cont.read();i++;
                            if(q=='>'){
                        Lexer("->->",LineNumber);
                        break;
                            }
                            else {
                                Lexer("->",LineNumber);
                             reading+=p;
                             reading+=q;
                             break;
                            
                            }
                       }
                      else{
                      if(p!=' ')
                      reading+=p;
                      Lexer("->",LineNumber);
                      break;
                      }
                    
//                      else{
//                        
//                        Lexer("->",LineNumber);
//                        reading+=p;
//                        reading+=q;
//                        break;
//                        }   
                     
                    }
                      
                case '!':                               //line terminating
                          if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                         Lexer("!",LineNumber);
                         reading="";
                          break;
                          
                case '|':                                      //single line comment
                     if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                    a = (char) cont.read();
                    i++;
                    if(a == '|'){
                    String comment = "||";
                    
                    while(true){
                        b=(char)cont.read();
                        i++;
                        if (b=='\n' || b=='\r')
                  
                                 break;
                            
                        comment+=b;
                    }
                        System.out.println("Single Line Comment : "+comment);
                    break;
                    
                    
                    }
                    else{
                    String comment = "|";                 //multi line comments
                    
                                    
                             while(true)
                                 {
                                    b = (char) cont.read();
                                    i++;
                                    if(b == '|')
                                          {
                                           //System.out.println(comment);
                                          // if(comment.compareTo("|")==0)
                                            // {
                                              comment+=b;
                                              System.out.println("Multi Line Comment :"+comment);
                                                 break;
                                              // }
                                             //   comment = "";
                                           }
                                 else   if(MyFile.length()-i==0)
                         {
                             System.out.println("ERROR END REACHED!!!");
                             return;
                         }
                                      else
                                           {
                                              comment = comment+b;
                                            }
                                   }
                    }
                                          
                                   break;
                                                // for multi line comment
                
                case '@':
                    String value="@";
                    if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                   
                    while(true)
                    {
                    
                        a = (char) cont.read();
                        i++; 
                         
                        if(a == '\\')
                        {
                           char d = (char) cont.read();
                           i++; 
                              if(d == '@')
                               value =value+ d;
                              
                        }
                        else  if(a =='@')
                        {
                        value += a;
                        Lexer(value,LineNumber);
                        System.out.println(""+value);
                        break;
                        }
                        else if(MyFile.length()-i==0)
                         {
                             System.out.println("ERROR: TOKEN ->  "+value+" \"\\END REACHED!!!");
                             return;
                         }
                        else{
                        value += a; 
                        
                        }
                    }
                    break;
                    
                case '~':
                
                     if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                    String ch="~";
                    
                    a=(char) cont.read(); i++;
                    if(a =='\\'){
                        ch+=a;
                    for (int j=0;j<2;j++){
                        
                        a=(char) cont.read(); i++;
                        ch+=a;
                    }
                    Lexer(ch,LineNumber);
                    break;
                    }
                    else
                    {
                        ch+=a;
                        a=(char) cont.read(); i++;
                        ch+=a;
                       Lexer(ch,LineNumber); 
                       break;
                     }
                   
                    
                case '{':
                     if(reading != "")
                    {
                     Lexer(reading,LineNumber);
                      reading="";
                    }
                    Lexer("{",LineNumber);
                    break;
                 
                case '}':
                     if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                    Lexer("}",LineNumber);
                    break;
                    
                case '[':
                     if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                    Lexer("[",LineNumber);
                    break;
                    
                 case ']':
                     if(reading != "")
                    {
                     Lexer(reading,LineNumber);
                     reading="";
                    }
                     Lexer("]",LineNumber);
                     break;  
                    
                 case ',':
                     if(reading != "")
                    {
                   Lexer(reading,LineNumber);
                   reading="";
                    }
                    Lexer(",",LineNumber);
                    break;
                    
                 case '<':

                    
                    a=(char)cont.read();i++;
                    if(a =='<')
                    { 
                                if(reading != "")
                               {  
                                 Lexer(reading,LineNumber);
                                 reading="";
                               }
                              else
                                  reading="";
                                p=(char)cont.read();i++;

                              if((p =='-'))
                                {
                                    q=(char)cont.read();i++;
                                    if(q=='>')
                                    {
                                        Lexer("<<->",LineNumber);
                                        break;
                                    }
                                    else
                                    {

                                     Lexer("<<",LineNumber);
                                     reading+=p;
                                     reading+=q;
                                     break;

                                    }
                           }
                          else
                          {
                                if(p !=' ')
                                reading+=p;
                                Lexer("<<",LineNumber);
                                break;
                                  }

                            }
                          else
                          {


                          if(reading != "")
                           {  
                             Lexer(reading,LineNumber);
                             reading="";
                           }
                          if(a!=' ')
                          reading+=a;
                          Lexer("<",LineNumber);
                          break;
                          }
                    
                    case '>':
                           a=(char)cont.read();i++;
                        if(a =='>')
                        { 
                                if(reading != "")
                               {  
                                 Lexer(reading,LineNumber);
                                 reading="";
                               }
                              else
                                    reading="";
                            p=(char)cont.read();i++;

                          if((p =='-'))
                            {
                                q=(char)cont.read();i++;
                                if(q=='>')
                                {
                                    Lexer(">>->",LineNumber);
                                    break;
                                }
                                else
                                {

                                 Lexer(">>",LineNumber);
                                 reading+=p;
                                 reading+=q;
                                 break;

                                }
                           }
                          else
                          {
                            if(p !=' ')
                            reading+=p;
                            Lexer(">>",LineNumber);
                            break;
                              }

                            }
                      else
                      {
                      
                      
                      if(reading != "")
                       {  
                         Lexer(reading,LineNumber);
                         reading="";
                       }
                      if(a!=' ')
                      reading+=a;
                      Lexer(">",LineNumber);
                      break;
                      }
                    
                case 'N':
                   
                    a=(char)cont.read();i++;
                    if(a=='O'){
                      b=(char)cont.read();i++;
                       
                      if(b=='T'){
                      p=(char)cont.read();i++;
                      /*q=(char)cont.read();i++;    
                         if((p == '-')&&(q == '>')){
                         Lexer(reading,LineNumber);
                         Lexer("NOT->",LineNumber);
                         reading="";
                         break;
                         }
                        */
                        if(p == '-')
                        {
                          q=(char)cont.read();i++;
                            if(q == '>'){
                                if(reading != "")
                                     {
                                     Lexer(reading,LineNumber);
                                     reading="";
                                          }
                            Lexer("NOT->",LineNumber);
                            reading="";
                            break;
                              }
                            else{
                           Lexer("NOT",LineNumber);
                                 if(reading != "")
                                     {
                                     Lexer(reading,LineNumber);
                                      reading="";
                                      }
                           reading+=p;
                           reading+=q; 
                            
                          }
                        
                          }
                         else{  
                         Lexer("NOT",LineNumber);
                                if(reading != "")
                                        {
                                      Lexer(reading,LineNumber);
                                       reading="";
                                         } 
                                if(p!=' ')
                                reading+=p;
                         break;
                         
                         
                         }
                      
                      
                      }
                      else{
                    reading+=c;
                    reading+=a;
                    reading+=b;  
                      break;
                      }
                    
                    
                    
                    
                    }
                    else{
                    
                    reading+=c;
                    reading+=a;
                    break;
                    
                    }
                    
                    
            case 'A':
                   
                    a=(char)cont.read();i++;
                    if(a=='N'){
                      b=(char)cont.read();i++;
                       
                      if(b=='D'){
                      p=(char)cont.read();i++;
                      
                        if(p == 'B'){
                                if(reading != "")
                                     {
                                     Lexer(reading,LineNumber);
                                     reading="";
                                          }
                            Lexer("ANDB",LineNumber);
                            reading="";
                            break;
                              }
                      
                       else{ 
                            if(reading != "")
                                        {
                                      Lexer(reading,LineNumber);
                                       reading="";
                                         } 
                         Lexer("AND",LineNumber);
                                if(p!=' ')
                                reading+=p;
                         break;
                         
                         
                         }
                      
                      
                      }
                      else{
                    reading+=c;
                    reading+=a;
                    reading+=b;  
                      break;
                      }
                    
                    
                    
                    
                    }
                    else{
                    
                    reading+=c;
                    reading+=a;
                    break;
                    
                    }
                  case 'O':
                   
                    a=(char)cont.read();i++;
                    if(a=='R'){
                      b=(char)cont.read();i++;
                       
                      if(b=='B'){
                     
                                if(reading != "")
                                     {
                                     Lexer(reading,LineNumber);
                                     reading="";
                                          }
                            Lexer("ORB",LineNumber);
                            
                            break;
                              }
                      
                       
                      
                      
                      
                      else{
                      Lexer("OR",LineNumber);
                      if(b!=' ')
                      reading+=b;  
                      break;
                      }
                    
                    
                    
                    
                    }
                    else{
                    
                    reading+=c;
                    reading+=a;
                    break;
                    
                    }
                default:
                    reading = reading + c;
                    
            
            }
            
            
        }

    
    
    
    }
    
        
 
   
}
    


