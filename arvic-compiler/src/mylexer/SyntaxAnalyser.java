/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylexer;

import java.util.ArrayList;


/**
 *
 * @author Habiba Abbasii
 */
public class SyntaxAnalyser {
    
   static ArrayList<Token> finalToken= new Mylexer().finalToken;
 
    public static int tokenindex=0;
   
      

 //structure of class
    
 public static  boolean main_class()
    {
        
              if(finalToken.get(tokenindex).data.equals("public"))
               {
                   tokenindex++;
                
                     if(opt_final())
                     {
                       if(finalToken.get(tokenindex).data.equals("class"))
                         { 
                             tokenindex++;

                             if(finalToken.get(tokenindex).type.name().equals("ID"))
                               {
                                   tokenindex++;
                                  if(I1())
                                     {
                                        if(finalToken.get(tokenindex).data.equals("{"))
                                          {
                                              tokenindex++;
                                            if(mc_body())
                                               {
                                                 if(finalToken.get(tokenindex).data.equals("}"))
                                                  {
                                                     finalToken.get(tokenindex).data+="EndClass";
                                                     
                                                      if(tokenindex<finalToken.size()-1)
                                                      {
                                                         tokenindex++;
                                                            if(class_st())
                                                            {
                                                                return true;
                                                            }
                                                      
                                                      }
                                                      else
                                                      {
                                                         return true;
                                                      }
                                                  }
                                               }
                                          }                         
                                     }
                                
                         }
                     }
                   }
                } 
             
              
   return false;
    }
    
    public static boolean class_st()
    {     
      if(finalToken.get(tokenindex).data.equals("fixed")||
      finalToken.get(tokenindex).data.equals("last")||
      finalToken.get(tokenindex).type.name().equals("AccessMod")||      
      finalToken.get(tokenindex).data.equals("class"))
       
      {
          if(ACC_MOD())
               {
                if(opt_static())
                   {
                     if(opt_final())
                     {
                       if(finalToken.get(tokenindex).data.equals("class"))
                         { 
                             tokenindex++;
                            if(finalToken.get(tokenindex).type.name().equals("ID"))
                               {
                                   tokenindex++;
                                  if(I1())
                                     {
                                        if(finalToken.get(tokenindex).data.equals("{"))
                                          {
                                              tokenindex++;
                                            if(class_body())
                                               {
                                                 if(finalToken.get(tokenindex).data.equals("}"))
                                                  {
                                                     finalToken.get(tokenindex).data+="EndClass";
                                                     
                                                      if(tokenindex<finalToken.size()-1)
                                                      {
                                                         tokenindex++;
                                                            if(class_st())
                                                            {
                                                                return true;
                                                            }
                                                      
                                                      }
                                                      else
                                                      {
                                                         return true;
                                                      }
                                                  }
                                               }
                                          }                         
                                     }
                                }
                         }
                     }
                   }
                } 
              }
//   else if(
//      finalToken.get(tokenindex).type.name().equals("DT")||      
//      finalToken.get(tokenindex).data.equals("class")||
//      finalToken.get(tokenindex).data.equals("void")||
//      finalToken.get(tokenindex).type.name().equals("ID"))
//        {
//           return true;
//    
//        }
      
        return false;
    }
    //main class terminals:
    static boolean mc_body()
    {
        if(finalToken.get(tokenindex).data.equals("public")){
            if(home_st())
            {
              if(class_body())
              {

               return true;
              }
            }

        }
      System.out.println("mc_body call Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
      return false;
    }
    
    static boolean home_st()
    
    {
        
      if(finalToken.get(tokenindex).data.equals("public"))
        {
            tokenindex++;
            if(finalToken.get(tokenindex).data.equals("fixed"))
                {
                    tokenindex++;
                    if(finalToken.get(tokenindex).data.equals("void"))
                    {
                        tokenindex++;
                        if(finalToken.get(tokenindex).data.equals("home"))
                        {
                            tokenindex++;
                            if(finalToken.get(tokenindex).data.equals("<"))
                            {
                                tokenindex++;
                                if(finalToken.get(tokenindex).data.equals("let"))
                                {
                                    tokenindex++;
                                    if(finalToken.get(tokenindex).data.equals("str"))
                                    {
                                        tokenindex++;
                                        if(finalToken.get(tokenindex).type.name().equals("ID"))
                                        {
                                            tokenindex++;
                                          if(finalToken.get(tokenindex).data.equals("["))
                                          {
                                              tokenindex++;
                                              if(finalToken.get(tokenindex).data.equals("]"))
                                              {
                                                  tokenindex++;
                                                  if(finalToken.get(tokenindex).data.equals(">"))
                                                  {
                                                      tokenindex++;
                                                      if(finalToken.get(tokenindex).data.equals("{"))
                                                      {
                                                          tokenindex++;
                                                          if(M_st_f())
                                                          {
                                                           if(finalToken.get(tokenindex).data.equals("}"))
                                                           {
                                                               finalToken.get(tokenindex).data+="exit";
                                                             tokenindex++;
                                                             return true;
                                                           }
                                                          }
                                                      }
                                                  }
                                              }
                                          }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
        }
      System.out.println("Home call Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
      return false;
    
    }
   
                                                        //function call nonterminal

    /**
     *
     * @return
     */
    public static boolean fun_call()
    {
      if(finalToken.get(tokenindex).type.name().equals("ID"))
      { 
          tokenindex++;
        if(finalToken.get(tokenindex).data.equals("<"))
        {  
            tokenindex++;
           
           if(null_exp())
            {
                if(finalToken.get(tokenindex).data.equals(">"))
                {
                  tokenindex++;
                        if(finalToken.get(tokenindex).data.equals("!"))
                            {
                                tokenindex++;
                                return true;

                      }
                }

              }
        
        
        
        }
      
      }
        
      System.out.println("Function call Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
      return false;
    }
    
                                                         //// loops Definations
                                                       // 1. if else code

    /**
     *
     * @return
     */
    public static boolean whether_Other()
    {
      if(finalToken.get(tokenindex).data.equals("whether"))
      { 
          tokenindex++;
         if(finalToken.get(tokenindex).data.equals("<"))
          { 
            tokenindex++;
         
           if(exp())
            {
                    if(finalToken.get(tokenindex).data.equals(">"))
                    {
                      tokenindex++;
                            if(func_body())
                          { 
                              if(other_st())
                               return true;

                          }
                    }
         
         }
        
        
        
        }
      }
System.out.println("Whether other Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
    }
    
    static boolean other_st(){
        
  
            if(finalToken.get(tokenindex).data.equals("other"))
            {  
                tokenindex++;
                 if(func_body())
                   {
                    return true;
                    }
           }

            
            else  if(
            finalToken.get(tokenindex).data.equals("life")||
            finalToken.get(tokenindex).data.equals("go")||
            finalToken.get(tokenindex).data.equals("whether")||
            finalToken.get(tokenindex).data.equals("key")||
            finalToken.get(tokenindex).data.equals("cycle")||
            finalToken.get(tokenindex).data.equals("let")||
            finalToken.get(tokenindex).type.name().equals("ID")||
            finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).data.equals("drop")||
            finalToken.get(tokenindex).data.equals("resume")||
            finalToken.get(tokenindex).data.equals("deliver")||
            finalToken.get(tokenindex).data.equals("set")||
            finalToken.get(tokenindex).data.equals("trial")||
            finalToken.get(tokenindex).data.equals("}"))
     {
     return true;
     }
     System.out.println("other Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    }
                                                             // 2. While statement
 static boolean life_st()
  {
    if(finalToken.get(tokenindex).data.equals("life"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).data.equals("<"))
        {
            tokenindex++;
            
                  if(exp())
                   {
                        if(finalToken.get(tokenindex).data.equals(">"))
                            {
                                tokenindex++;
                                if(func_body())
                                   {
                                   return true;
                                   }
                            }
                    }
         
        }
    }
    
     System.out.println("life Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
  return false;
  }
                                                      //3. Do while statement
   static boolean go_life_st()
  {
    if(finalToken.get(tokenindex).data.equals("go"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).data.equals("{"))
        {
            tokenindex++;
            if(M_st_f())
             {
                 if(finalToken.get(tokenindex).data.equals("}"))
                     {
                         tokenindex++;
                         if(finalToken.get(tokenindex).data.equals("life"))
                            {
                                tokenindex++;
                              if(finalToken.get(tokenindex).data.equals("<"))
                                  {
                                      tokenindex++;
                                       
                                            if(exp())
                                             {
                                                if(finalToken.get(tokenindex).data.equals(">"))
                                                {
                                                    tokenindex++;
                                                    if(finalToken.get(tokenindex).data.equals("!"))
                                                        {
                                                            tokenindex++;
                                                            return true;
                                                          }
                                                }
                                             }      
                                  }
                            }
                     }
             }
        }
    }
      System.out.println("Go life Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
  return false;
  }
                                                     //3. Switch statement    
 static boolean Sw_st()
  {
    if(finalToken.get(tokenindex).data.equals("key"))
    {
        tokenindex++;
       if (finalToken.get(tokenindex).data.equals("<"))
       {
           tokenindex++;
         if (exp())
            {
                //tokenindex++;
              if (finalToken.get(tokenindex).data.equals(">"))
                 {
                     tokenindex++;
                     if (Sw_body())
                        {
                            return true;
                        }
                 }
            }
        }
     }
      System.out.println("Sw_st Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
      return false;
  }
 
 static boolean Sw_body()
  {
    if(finalToken.get(tokenindex).data.equals("{"))
    {
        tokenindex++;
       if(trial_st())
       {
         if (Set_st())
            {
               if(finalToken.get(tokenindex).data.equals("}"))
                     {
                         tokenindex++;
                         return true;
                     }
             }
        }
        
     }
    
    
      System.out.println("Sw_body Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
   }
 
 static boolean trial_st(){

      if(finalToken.get(tokenindex).data.equals("trial"))
        {
            tokenindex++;
            if(ID_Const_Sw())
                {
                    tokenindex++;
                if (finalToken.get(tokenindex).data.equals(":"))
                    {   
                        tokenindex++;
                        if(trial_body())
                         {
                             return true;
                         }
                    }
                 }
        
            }
 //follow
      else if(finalToken.get(tokenindex).data.equals("trial")||
         finalToken.get(tokenindex).data.equals("set")||
         finalToken.get(tokenindex).data.equals("}"))
 {
 return true;
 }
 
 
   System.out.println("trial_st Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }
 static boolean trial_body(){

                        if(M_st_f())
                        {

                          if(trial_st())
                          {
                           return true;
                          }

                        }
 
   System.out.println("trial_body Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
  return false;
 }
 static boolean Set_st(){
  
 
          if(finalToken.get(tokenindex).data.equals("set"))
            {
                tokenindex++;
            
                if (finalToken.get(tokenindex).data.equals(":"))
                    {
                        tokenindex++;
                    if(trial_body())
                         {
                             return true;
                         }
                    
                    }
        
            }
 //follow
   else if(
         finalToken.get(tokenindex).data.equals("set")||
         finalToken.get(tokenindex).data.equals("}"))
         {
 
    return true;
 }
 
   System.out.println("Set_st Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
  return false;
 }
 static boolean ID_Const_Sw(){
 
     
     if(finalToken.get(tokenindex).type.name().equals("num")||
        finalToken.get(tokenindex).type.name().equals("str")||
        finalToken.get(tokenindex).type.name().equals("ch")||
        finalToken.get(tokenindex).type.name().equals("bo"))
        {
           // tokenindex++;
          return true;
        }
       System.out.println("ID_Const_Sw Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
 
 }
                                                 //4. For Loop.
 static boolean cycle_st()
 {
      if(finalToken.get(tokenindex).data.equals("cycle"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).data.equals("<"))
        {
            tokenindex++;
            if(X())
             {
                 if(Y())
                     {
                       if(finalToken.get(tokenindex).data.equals("!"))
                         {
                            tokenindex++;
                            if(Z())
                              {
                                if(finalToken.get(tokenindex).data.equals(">"))
                                     {
                                      tokenindex++;
                                         if(func_body())
                                              {
                                             return true;
                                                        
                                              }
                                        }
                                }
                            }
                   }
             }
        }
    }
    
      System.out.println("Cycle_st Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
 }
 
static boolean X(){
  if(finalToken.get(tokenindex).type.name().equals("ID"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
        {
            tokenindex++;
            if(X1())
             {
                if(finalToken.get(tokenindex).data.equals("!"))
                                         {
                                             tokenindex++;
                                             return true;
                                              
                                     }
             }
        }
    }
    
  else if(finalToken.get(tokenindex).data.equals("let"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).type.name().equals("DT"))
        {
            tokenindex++;
            if(finalToken.get(tokenindex).type.name().equals("ID"))
             {
                 tokenindex++;
                 if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                     {
                         tokenindex++;
                       if(list_cy())
                         {
                           if(finalToken.get(tokenindex).data.equals("!"))
                                     {
                                             tokenindex++;
                                             return true;
                                                        
                                              
                                     }
                                
                            }
                   }
             }
        }
    }
    
    
  else if(finalToken.get(tokenindex).data.equals("!"))
       {
          tokenindex++;
          return true;
                                                        
                                              
         } 
  
 System.out.println("X Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}
static boolean T(){

if(X2())
    return true;

else if(N_T()){
   
   return true;
   }
//follow
else if(finalToken.get(tokenindex).data.equals("!"))
        {
        return true;
        }
 System.out.println("T Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}
static boolean X1(){

     if(finalToken.get(tokenindex).type.name().equals("ID"))
{
    
    tokenindex++;
    if(T())
    {
        
        return true;
    }
}
    else if(finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
                                 
              {
               if(ID_Const())
               {
                    if(X3())
                    {
                      return true;
                    }
               }
              }
System.out.println("X1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}

static boolean X2(){
    
 if(finalToken.get(tokenindex).data.equals(","))
 {
  if(list_cy1())
    {
//        if(finalToken.get(tokenindex).data.equals("!"))
//            {
//            tokenindex++;
            return true;
//         }  
    }
}
 
 else if(finalToken.get(tokenindex).type.name().equals("AssgnOp")) 
     
 {
     if(list_cy2())
    {
//        if(finalToken.get(tokenindex).data.equals("!"))
//        {
//          tokenindex++;
          return true;
//         }  
   }
 }
// else if(finalToken.get(tokenindex).data.equals("!"))
//       {
//          tokenindex++;
//          return true;
//         }  
//follow
 else if(finalToken.get(tokenindex).data.equals("!"))
        {
        return true;
        }
 System.out.println("X2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}
static boolean X3()
{
 
 if(finalToken.get(tokenindex).data.equals(","))
 {
     if(list_cy1())
     {
//        if(finalToken.get(tokenindex).data.equals("!"))
//        {
//          tokenindex++;
          return true;
//         }  
    } 
}
//  else if(finalToken.get(tokenindex).data.equals("!"))
//   {
//              tokenindex++;
//                return true;
//   }
 //follow
else if(finalToken.get(tokenindex).data.equals("!"))
        {
        return true;
        }
    System.out.println("X3 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}

 static boolean Y(){
  
         if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
           if(exp())
            {
              return true;
            }
         }
  
      else if( 
        finalToken.get(tokenindex).data.equals("!") )
     { 
         return true;
    }
   System.out.println("Y Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }

 
static boolean Z(){

       if(finalToken.get(tokenindex).type.name().equals("ID"))
       {
        tokenindex++;
          if(Z1())
          return true;
       }
       else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
       {
           tokenindex++;
         if(finalToken.get(tokenindex).type.name().equals("ID"))
         {
            tokenindex++;
            return true;
         }
       }
  else if(finalToken.get(tokenindex).data.equals(">"))
     {
    return true;
    }
 System.out.println("Z Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }

 static boolean Z1(){
  if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
       {
        tokenindex++;
          return true;
       }
       else if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
       {
           tokenindex++;
        if(ID_Const())
                                 
              {
               return true;
             }
       }
  System.out.println("Z1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;

 }
 
                                         
static boolean list_cy(){
  
  if(finalToken.get(tokenindex).type.name().equals("ID"))
  {
    tokenindex++;
       if(list_cy3())
       return true;
 
  }
  if(finalToken.get(tokenindex).type.name().equals("flo")||
                    finalToken.get(tokenindex).type.name().equals("num")||
                    finalToken.get(tokenindex).type.name().equals("str")||
                    finalToken.get(tokenindex).type.name().equals("ch")||
                    finalToken.get(tokenindex).type.name().equals("bo"))
                                 
              {
               tokenindex++;
                    if(list_cy1())
                    return true;
 
  }
System.out.println("list_cy Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}

static boolean list_cy1(){

 
       if(finalToken.get(tokenindex).data.equals(","))
        {
           tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("ID"))
            {
               tokenindex++;
                 if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                     {
                         tokenindex++;
                         if(finalToken.get(tokenindex).type.name().equals("ID")||
                            finalToken.get(tokenindex).type.name().equals("flo")||
                            finalToken.get(tokenindex).type.name().equals("num")||
                            finalToken.get(tokenindex).type.name().equals("str")||
                            finalToken.get(tokenindex).type.name().equals("ch")||
                            finalToken.get(tokenindex).type.name().equals("bo"))
            {
              
                                tokenindex++;
                                   if(list_cy1())
                                   {
                                       return true;
                                    }

                                }
                   }
             }
        }
    
     //follow
       else if(finalToken.get(tokenindex).data.equals("!"))
   {  
   return true;
   }

System.out.println("list_cy1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}

static boolean list_cy2(){

 
       if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
        {
           tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("ID"))
            {
              tokenindex++;
                 if(list_cy2())
                     {
                        return true;
                   }
             }
        }
 else if(finalToken.get(tokenindex).data.equals("!"))
   {  
   return true;
   }

System.out.println("list_cy2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;


}
static boolean list_cy3()
{
    if(finalToken.get(tokenindex).data.equals(","))
    {
            if(list_cy1())
            return true;
    
        }
    if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
    {
           if(list_cy2())
            return true;
    
        }
     if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
         {  
                
            if(N_T())
             {
                return true;
            }
         }
 System.out.println("list_cy3 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}
static boolean INDEC(){

    if(finalToken.get(tokenindex).type.name().equals("ID"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
        {
          tokenindex++;
          return true;
        }
    }
    else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
    {
        tokenindex++;
        if(finalToken.get(tokenindex).type.name().equals("ID"))
        {
          tokenindex++;
          return true;
        }
    }
    System.out.println("INDEC Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}

static boolean let_st()
{


      if(finalToken.get(tokenindex).data.equals("let"))
      {
       tokenindex++;
         if(finalToken.get(tokenindex).type.name().equals("DT"))
           {
               tokenindex++;
               return true;
           }
      }
 
else if(finalToken.get(tokenindex).data.equals("let")||
         finalToken.get(tokenindex).type.name().equals("ID"))
 { 
 return true;
 }

System.out.println("let_st Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}
static boolean declx(){

if(let_st())
   {
       if(finalToken.get(tokenindex).type.name().equals("ID"))
        {
           tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
            {
                 tokenindex++;
                 if(list_cy())
                     {
                        return true;
                   }
             }
        }
    
   }

System.out.println("declx Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}
                                             // function body
   
    static boolean func_body()
    {
    
          if((finalToken.get(tokenindex).data.equals("life")||
             finalToken.get(tokenindex).data.equals("go")||
             finalToken.get(tokenindex).data.equals("whether")||
             finalToken.get(tokenindex).data.equals("key")||
             finalToken.get(tokenindex).data.equals("cycle")||
             finalToken.get(tokenindex).data.equals("let")||
             finalToken.get(tokenindex).type.name().equals("ID")||
             finalToken.get(tokenindex).type.name().equals("INCDEC")||
             finalToken.get(tokenindex).data.equals("deliver")||
            finalToken.get(tokenindex).data.equals("drop")||
            finalToken.get(tokenindex).data.equals("resume")))
          { 
              if(S_st_f())
              return true;
          }
           
          else if(finalToken.get(tokenindex).data.equals("{"))
          { 
              tokenindex++;
                if(M_st_f())
                {
                      if(finalToken.get(tokenindex).data.equals("}"))
                        {
                            tokenindex++;
                           return true;
              
                        }
               }
          
         }
          else if(finalToken.get(tokenindex).data.equals("!"))
          {
              tokenindex++;
             return true;
          }

      
System.out.println("func_body Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
    
    }
    
    /**
     *
     * @return
     */
    public static boolean decl(){
        
        if(finalToken.get(tokenindex).data.equals("let"))
        {
          tokenindex++;
            if (finalToken.get(tokenindex).type.name().equals("DT"))
            {
             tokenindex++;
              if (finalToken.get(tokenindex).type.name().equals("ID"))
              {
                tokenindex++;
                if(select())
                {
                   if(finalToken.get(tokenindex).data.equals("!"))
                 {
                     tokenindex++;
                     return true;
                 }
                }
              } 
              
            }
        }
        else
            if (finalToken.get(tokenindex).type.name().equals("ID"))
              {
                tokenindex++;
                if(select_last())
                {
                       if(finalToken.get(tokenindex).data.equals("!"))
                            {
                                tokenindex++;
                                return true;
                            }
                }
              }
        System.out.println("decl Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
        return false;
        
    }

    /**
     *
     * @return
     */
    public static boolean array_list()
    {
    
         if(finalToken.get(tokenindex).data.equals(","))
      { 
          tokenindex++;
        
           if(exp())
            {
                if(array_list())
                {
                 return true;
                }
              }
               
      }
         //follow
 if(finalToken.get(tokenindex).data.equals("]"))
     {         
    return true;
    }
     System.out.println("array_list Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    
    }

    /**
     *
     * @return
     */
    public static boolean array_init()
    {
         if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
        {
            tokenindex++;
               if(finalToken.get(tokenindex).data.equals("["))
                { 
                  tokenindex++;
                    
                        if(exp())
                                 {
                                 if(array_list())
                                 {
                                   if(finalToken.get(tokenindex).data.equals("]"))  
                                   {
                                       tokenindex++;
                                       return true;
                                   }
                                 }
                             }
                       
                        }
        
    }
      
 else if(finalToken.get(tokenindex).data.equals(","))
       {
            if(id_list())  
            return true;
       }
 else if(finalToken.get(tokenindex).data.equals("."))
       {
            if(S1a())  
            return true;
       }    
 //follow
          else if(finalToken.get(tokenindex).data.equals("!"))
       {
            return true;
       }
     System.out.println("array_init Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    }
    
    public static boolean array_init1()
    {
//         if(finalToken.get(tokenindex).data.equals("["))
//                { 
//                  tokenindex++;
//                    
//                        if(exp())
//                                 {
//                                 if(array_list())
//                                 {
//                                   if(finalToken.get(tokenindex).data.equals("]"))  
//                                   {
//                                       tokenindex++;
//                                       return true;
//                                   }
//                                 }
//                             }
//                       
//                        }
//        
//      else if(finalToken.get(tokenindex).type.name().equals("flo")||
//            finalToken.get(tokenindex).type.name().equals("num")||
//            finalToken.get(tokenindex).type.name().equals("str")||
//            finalToken.get(tokenindex).type.name().equals("ch")||
//            finalToken.get(tokenindex).type.name().equals("bo"))
//           {  
//               if(ID_Const())
//               {
//                   return true;
//               }
//           }
//         
 if(finalToken.get(tokenindex).type.name().equals("AssgnOp")) 
       {
           tokenindex++;
            if(array_init2())
            {
                 return true;
           }

            
      }
 else if(finalToken.get(tokenindex).data.equals(".")) //first of S1a
    {
    
      if(S1a())
      {
      
      return true;
      }
    }
 
         //follow
         else if(finalToken.get(tokenindex).data.equals("!"))
             {
                 return true;
             }
     System.out.println("array_init1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    }
    
    
public static boolean array_init2()
{
         if(finalToken.get(tokenindex).data.equals("["))
                { 
                  tokenindex++;
                    
                        if(exp())
                                 {
                                 if(array_list())
                                 {
                                   if(finalToken.get(tokenindex).data.equals("]"))  
                                   {
                                       tokenindex++;
                                       return true;
                                   }
                                 }
                             }
                       
                        }
         
else if(finalToken.get(tokenindex).type.name().equals("ID")) 
       {
           tokenindex++;
            if(S1a())
            {
                 return true;
           }

            
      }
 
     System.out.println("array_init2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
}
    /**
     *
     * @return
     */
 public static boolean obj_call()
  { 
       if( finalToken.get(tokenindex).type.name().equals("ID")||
            finalToken.get(tokenindex).type.name().equals("INCDEC")||
           finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
            {
                if(null_exp())
                {
                return true;
                }
            }
       
       else if (finalToken.get(tokenindex).data.equals("old"))
         { 
             tokenindex++;
             if(DT_ID())
             {
               if(Bra_Arr())
               {
                   return true;
               }             
             }  
         }
     System.out.println("obj_call Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    }
 
 public static boolean obj_call1()
  { 
   if(finalToken.get(tokenindex).data.equals("old")||
           finalToken.get(tokenindex).type.name().equals("ID")||
            finalToken.get(tokenindex).type.name().equals("INCDEC")||
           finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
      {   
        if(obj_call())
        {
            return true;
        }    
       }
   //follow
   else if(finalToken.get(tokenindex).data.equals(">")||
           finalToken.get(tokenindex).data.equals("]"))
   {
   
   return true;
   }
        
 System.out.println("obj_call Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
  return false;
  }
    public static boolean id_list()
    {
     if(finalToken.get(tokenindex).data.equals(","))
        { 
           tokenindex++;
             if(finalToken.get(tokenindex).type.name().equals("ID"))
            { 
                tokenindex++;
                 if(select())
                    {
                    return true;
                    }
            }
        }
     else if(finalToken.get(tokenindex).data.equals("!"))
     {
       
     return true;
     }
      System.out.println("id_list Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
    return false;
    }

    /**
     *
     * @return
     */
    public static boolean N_T()
    {
     if(O_())
      {
       if(N_())
       {
         if(M_())
           {
              if(J_())
                {
                   if(I_())
                    {
                       if(H_())
                        {
                          if(G_())
                            {
                              if(F_())
                                {
                                  if(exp_())
                                        {
                                          return true;
                                        }
                                }  
                            }
                       }
                    }
                }
           }
       }
       }
    
    
     System.out.println("N_T Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
    return false;
    }

    /**
     *
     * @return
     */
 public static boolean id_init5b()
{

  if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
         {  
                
            if(N_T())
             {
                return true;
            }
         }
  else   if(S1c())
                return true;
            
System.out.println("id_init5b Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}    
 public static boolean id_init5a()
{

  if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
         {  
                
            if(N_T())
             {
                return true;
            }
         }
  
  else  if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
  {
      if(in())
             {
                 if(S1c())
                return true;
            }
  }
System.out.println("id_init5a Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
}

     public static boolean id_init5()
    {
        if(finalToken.get(tokenindex).data.equals("["))                       //first of id_init
                {     
                tokenindex++;
                
                        if(exp())
                        {
                            if(finalToken.get(tokenindex).data.equals("]"))                       //first of id_init
                            {     
                                tokenindex++;
                                if(id_init5a())
                                {
                                    return true;
                                 
                                }
                            }
                
                        }
                 }
else
        if(finalToken.get(tokenindex).data.equals("<"))                       //first of id_init
                {     
                tokenindex++;
                
                        if(P_L())
                        {
                            if(finalToken.get(tokenindex).data.equals(">"))                       //first of id_init
                            {     
                                tokenindex++;
                                if(id_init5b())
                                {
                                    return true;
                                 
                                }
                            }
                
                        }
                 }
   else   if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))//
         {  
                
            if(in())
             {
                return true;
            }
         }
       
   else  if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
         {  
                
            if(N_T())
             {
                return true;
            }
         }
        //follow
   else if(finalToken.get(tokenindex).data.equals("!"))
   {
   return true;
   }   
     System.out.println("id_init5 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 public static boolean id_init4a()
    {
      
  if(finalToken.get(tokenindex).data.equals(">"))
         {  
             tokenindex++;   
                return true;
         }
  else if(finalToken.get(tokenindex).data.equals(","))
      {
          if(P_L2())
       {
         if(finalToken.get(tokenindex).data.equals(">"))
         {  
             tokenindex++;   
            
               if(N_T())
               {
                    return true;
               }
           
           }
       }
      }
     System.out.println("id_init4a Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 
public static boolean id_init4()
    {
      if(finalToken.get(tokenindex).data.equals(">"))
         {  
             tokenindex++;   
            if(N_T())
             {
                return true;
            }
         }
   else  if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
 {
     if(exp())
       {
           if(id_init4a())
           {
               if(N_T())
               {
                    return true;
               }
           }
       }
 }
     System.out.println("id_init4 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }

    public static boolean id_init3()
    {
 if(finalToken.get(tokenindex).data.equals("<"))                       //first of id_init
       {     
     tokenindex++;
        if(id_init4())
            {
                return true;
                }
       }
          
 else  if(finalToken.get(tokenindex).data.equals("."))                       //first of id_init
       {     
     tokenindex++;
         if(finalToken.get(tokenindex).type.name().equals("ID"))                       //first of id_init
                {     
                tokenindex++;
                 if(id_init5())
                    {
                return true;
                }
         }
       }
  else  if(finalToken.get(tokenindex).data.equals("["))                       //first of id_init
                {     
                tokenindex++;
                
                        if(exp())
                        {
                            if(finalToken.get(tokenindex).data.equals("]"))                       //first of id_init
                            {     
                                tokenindex++;
                                if(P2())
                                {
                                    if(N_T())
                                    {
                                    return true;
                                    }
                                }
                            }
                
                        }
                 }
 else  if(finalToken.get(tokenindex).type.name().equals("INCDEC"))                       //first of id_init
                {     
                tokenindex++;
                
                        if(N_T())
                        {
                          return true;
                        }
                 }
 
else if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
        if(N_T())
        {
          return true;
        }
        
    } 
else   if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))                       //first of id_init
       {     
        if(id_init1())
            {
                return true;
                }
       }
        //follow
 else  if(finalToken.get(tokenindex).data.equals("!"))
      {
      return true;
      }
       
 System.out.println("id_init3 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
    }

    
    public static boolean id_init2()
    {
    if(finalToken.get(tokenindex).type.name().equals("ID"))
    {
        tokenindex++;
         if(id_init3())
                {
                    return true;
                }
        }
     else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
       { 
           tokenindex++;
          if(finalToken.get(tokenindex).type.name().equals("ID"))
                {
                    tokenindex++;
                 if(N_T())
                     {
                              return true;
                    }
               }
        }
     
       else
           if(finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
           {  
               if(ID_Const())
               {
                    if(N_T())
                       {
                           return true;
                       }
                    }
           }

     System.out.println("id_init2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }

    /**
     *
     * @return
     */
    public static boolean id_init1()
    {
      if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
         {  
             tokenindex++;   
            if(id_init2())
             {
                return true;
            }
         }
      //follow
      else  if(finalToken.get(tokenindex).data.equals("!"))
         {
             return true;
         }
     System.out.println("id_init1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }

public static boolean id_initm()
{

 if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
       {  
           tokenindex++;
         if(finalToken.get(tokenindex).type.name().equals("ID"))
         { 
             tokenindex++;   
                if(N_T())
                {
                    return true;
                }
       }
      }
       else
           if(finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
           {  
               if(ID_Const())
               {
                    if(N_T())
                       {
                           return true;
                       }
                    }
           }
       else if(finalToken.get(tokenindex).type.name().equals("ID"))
         {  
             tokenindex++;   
            if(id_init3())
             {
                return true;
            }
         }
       
     System.out.println("id_init2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
}    
    
 public static boolean DT_ID()
  {
      if(finalToken.get(tokenindex).type.name().equals("DT"))
      {
          tokenindex++;
      return true;
      }
      else if(finalToken.get(tokenindex).type.name().equals("ID"))
      {
          tokenindex++;
      return true;
      }
      
    System.out.println("DT_ID Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
   }
 public static boolean Bra_Arr()
 {
    if(finalToken.get(tokenindex).data.equals("<"))
       {
         tokenindex++;
       
           if(obj_call1())
            {
                   if(finalToken.get(tokenindex).data.equals(">"))
                        {
                        tokenindex++;
                        return true;
                        }
           }
             
       }
    
     else if(finalToken.get(tokenindex).data.equals("["))
       {
          tokenindex++;
           if(null_exp())
            {
             if(finalToken.get(tokenindex).data.equals("]"))
                 {
                  tokenindex++;
                  return true;
                }
             }
         
             
       }
 
 
   System.out.println("Bra_Arr Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
   return false;
  }
    /**
     *
     * @return
     */
 
 public static boolean id_init()
  {
     
       if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
       {   
           tokenindex++;
           if(id_inita())
            { 
                return true;
            }
       }
       else  if(finalToken.get(tokenindex).data.equals(","))
               {
                   if(id_list())
                          {
                         return true;
          
                             }
                    }
       //follow
       else if(finalToken.get(tokenindex).data.equals("!"))
     {      
       return true;
     }
     System.out.println("id_init Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
  }

     public static boolean id_inita()
    {
     
       if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
       {  
           tokenindex++;
         if(finalToken.get(tokenindex).type.name().equals("ID"))
         { 
             tokenindex++;   
                if(N_T())
                {
                   if(id_list())
                    {
                       return true;
                   }

                }
       }
      }
       else
           if(finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
           {  
               if(ID_Const())
               {
                    if(N_T())
                       {
                       if(id_list())
                           {
                                return true;
                           }
                       }
                    }
           }
       else if(finalToken.get(tokenindex).type.name().equals("ID"))
         {  
             tokenindex++;   
            if(id_inita1())
             {
                return true;
            }
         }
       
//         else if(finalToken.get(tokenindex).data.equals("<")||
//                finalToken.get(tokenindex).data.equals("[")||
//                finalToken.get(tokenindex).type.name().equals("MulDivMod")||
//                finalToken.get(tokenindex).type.name().equals("AddSub")||
//                finalToken.get(tokenindex).type.name().equals("OPT")||
//                finalToken.get(tokenindex).type.name().equals("RO")||
//                finalToken.get(tokenindex).data.equals("ANDB")||
//                finalToken.get(tokenindex).data.equals("XOB")||
//                finalToken.get(tokenindex).data.equals("ORB")||
//                finalToken.get(tokenindex).data.equals("AND")||
//                finalToken.get(tokenindex).data.equals("OR"))
//                    {
//                      if(Bracket())
//                      {
//                          if(N_T())
//                             {
//                                if(id_list())
//                                  { 
//                                      return true;
//                                  }
//                             }
//                      }
//                    }
//    else if(finalToken.get(tokenindex).data.equals("old"))
//         { 
//             tokenindex++;
//             if(DT_ID())
//             {
//               if(Bra_Arr())
//               {
//                   return true;
//               }             
//             }
//         
//         }
//    else if(finalToken.get(tokenindex).type.name().equals("ID"))
//         {
//             tokenindex++;
//             if(id_init2())
//                 return true;
//         }
System.out.println("id_inita Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
   
   public static boolean id_inita1()
    {
       
        if(finalToken.get(tokenindex).data.equals("["))
            {
           tokenindex++;
              if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
                  { 
                    if(exp())
                     {
                          if(finalToken.get(tokenindex).data.equals("]"))
                             {
                                 tokenindex++;
                                         if(P2())
                                         {
                                         if(N_T())
                                                {
                                                 if(id_list())
                                                    { 
                                                        return true;
                                                    }
                                                }
                                         }

                        }
                     }
                    }    
           
        }
        else if(finalToken.get(tokenindex).data.equals("<"))
        { 
            if(id_initaa())
                return true;
        }
      else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
      {
       tokenindex++;
           if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
      else if(finalToken.get(tokenindex).data.equals("."))
           {
               tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("ID"))
           {    
               tokenindex++;
               if(id_initab())
                    {
                            return true;
                     
                    }
           
           
           }
    }
      else if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
          if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
      

     else if(finalToken.get(tokenindex).type.name().equals("AssgnOp")||
             finalToken.get(tokenindex).data.equals(","))
        {
         if(id_init())
                {
                    return true;
                }
        }
     
//     else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
//       { 
//           tokenindex++;
//          if(N_T())
//                {
//                 if(id_list())
//                     {
//                              return true;
//                    }
//               }
//        }
//     
//       else if(finalToken.get(tokenindex).data.equals("<"))
//       {
//        tokenindex++;
//           
//           if(exp())
//            {
//                if(finalToken.get(tokenindex).data.equals(">"))
//                  {
//                     tokenindex++;
//                    if(finalToken.get(tokenindex).data.equals("!"))
//                    { 
//                        tokenindex++;
//                         if(id_init3())
//                            {
//                                return true;
//                            }
//
//                    }
//                  }
//           }
//           
//       }
//        else if(finalToken.get(tokenindex).data.equals("."))
//         { 
//             tokenindex++;
//                if(fun_call())
//                { 
//                   if(id_init4())
//                    { 
//                       return true;
//                    }
//                }
//         
// 
// follow
else if(finalToken.get(tokenindex).data.equals("!"))
        { 
            return true;
        }
        

     System.out.println("id_inita1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
  public static boolean id_initaa()
{ 
     if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
       {
           if(exp())
            {
                if(id_initaaa())
                  {
                                return true;
                            }

           }
           
       }
     else if(finalToken.get(tokenindex).data.equals(">"))
      {
          tokenindex++;
          if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
    
    System.out.println("id_initaa Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
   public static boolean id_initaaa()
{ 
    
    if(finalToken.get(tokenindex).data.equals(","))
        { 
           tokenindex++;
             if(exp())
            { 
                 if(P_L2())
                    {
                      if(finalToken.get(tokenindex).data.equals(">"))
                      { 
                          if(N_T())
                          {
                           if(id_list())
                              { 
                                  return true;
                              }
                          }
                          }
                    }
            }
        }
    
    else if(finalToken.get(tokenindex).data.equals(">"))
      {
          tokenindex++;
          if(id_initaaa1())
                    {
                            return true;
                      
                    }
      }
    
    
    
System.out.println("id_initaaa Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
    }
   
 public static boolean id_initaaa1()
{
    
if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
          if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
      
    //follow
 else if(finalToken.get(tokenindex).data.equals("!"))
     {      
       return true;
     }
System.out.println("id_initaaa1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }
 public static boolean id_initab()
{
    if(finalToken.get(tokenindex).data.equals("["))
       {
          tokenindex++;
           if(exp())
            {
             if(finalToken.get(tokenindex).data.equals("]"))
                 {
                  tokenindex++;
                  if(id_initabb())
                  return true;
                }
             }
       }

else if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
          if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
else if(finalToken.get(tokenindex).data.equals("<"))
       {
          tokenindex++;
           if(P_L())
            {
             if(finalToken.get(tokenindex).data.equals(">"))
                 {
                  tokenindex++;
                  if(id_initabc())
                  return true;
                }
             }
       }
      
 else if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
     {
       if(in())
       {
     
         return true;
       }
     }
 if(finalToken.get(tokenindex).data.equals("."))  //first
        {
            if(S1a())
            {
                return true;
            }
        }
      //follow
 else if(finalToken.get(tokenindex).data.equals("!"))
     {      
       return true;
     }
    System.out.println("id_initab Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    } 
public static boolean id_initabb()
{ 
   if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
          if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
   else if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
     {
       if(in())
       {
         if(S1c())
         return true;
       }
     }
    
    
System.out.println("id_initabb Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
    } 
public static boolean id_initabc()
{ 
    if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
          if(N_T())
                    {
                     if(id_list())
                        { 
                            return true;
                        }
                    }
      }
     if(finalToken.get(tokenindex).data.equals("."))  //first
        {
            if(S1c())
            {
                return true;
            }
        }
    
    System.out.println("id_initabc Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
public static boolean id_initb()
{
        
      if(finalToken.get(tokenindex).type.name().equals("AssgnOp")||
             finalToken.get(tokenindex).data.equals(","))
        {
         if(id_init())
                {
                    return true;
                }
        }
     
 
       else if(finalToken.get(tokenindex).data.equals("<"))
       {
        tokenindex++;
           
           if(exp())
            {
                if(finalToken.get(tokenindex).data.equals(">"))
                  {
                     tokenindex++;
                     return true;
                   }

                 
                  
           }
           
       }
               
 else if(finalToken.get(tokenindex).data.equals("."))   //first
  {
      if(S1a())
      { return true;
      
      }
 }
     
System.out.println("id_initb Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
    }

    static boolean ACC_MOD(){
   
            if(finalToken.get(tokenindex).type.name().equals("AccessMod"))
            {
                tokenindex++;
                 return true;
            }
            
else if(finalToken.get(tokenindex).data.equals("fixed")||
      finalToken.get(tokenindex).data.equals("last")||
        finalToken.get(tokenindex).data.equals("let")||
      finalToken.get(tokenindex).type.name().equals("AccessMod")||
      finalToken.get(tokenindex).type.name().equals("DT")||      
      finalToken.get(tokenindex).data.equals("class")||                      //first & follow
      finalToken.get(tokenindex).data.equals("void")||
      finalToken.get(tokenindex).type.name().equals("ID"))
        {            
    return true;
        }
    System.out.println("ACC_MOD Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    
    }
  static boolean opt_static(){
   
          if(finalToken.get(tokenindex).data.equals("fixed"))
             {  
                 tokenindex++;
                return true;
            }
          
          else if(finalToken.get(tokenindex).data.equals("fixed")||
      finalToken.get(tokenindex).data.equals("last")||
      finalToken.get(tokenindex).type.name().equals("AccessMod")||
      finalToken.get(tokenindex).data.equals("class")||
      finalToken.get(tokenindex).type.name().equals("DT")||                        //first and follow
      finalToken.get(tokenindex).data.equals("void")||
      finalToken.get(tokenindex).data.equals("let")||
      finalToken.get(tokenindex).type.name().equals("ID"))
        {
         return true;
        }
    System.out.println("opt_static Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    
    }
    
  static boolean opt_final(){
  
          if(finalToken.get(tokenindex).data.equals("last"))
             {
              tokenindex++;
                return true;
            } 
          
 else  if(finalToken.get(tokenindex).data.equals("fixed")||
      finalToken.get(tokenindex).data.equals("last")||
         finalToken.get(tokenindex).data.equals("let")||
      finalToken.get(tokenindex).type.name().equals("AccessMod")||          //first and follow
      finalToken.get(tokenindex).data.equals("class")||
      finalToken.get(tokenindex).data.equals("void")||
      finalToken.get(tokenindex).type.name().equals("DT")||
       finalToken.get(tokenindex).type.name().equals("ID"))
        {         
            return true;
        }
    System.out.println("opt_final Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
    
    }
     
     static boolean I1(){
        
             if(finalToken.get(tokenindex).data.equals("inherited"))
            { 
            tokenindex++;
                if(finalToken.get(tokenindex).type.name().equals("ID"))
                {
                        tokenindex++;
                      return true;
                }
            }
             else if(
            finalToken.get(tokenindex).data.equals("{"))                         //first and follow
         {
             return true;
         }
         System.out.println("I1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
        return false;
    }
     
     static boolean class_b(){
        if(class_body())
        {
          if(class_b1())
          {
          return true; 
          }
        
        }
        System.out.println("class_b Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
        return false;
    }
     
     static boolean class_b1()
     {
       
         if(Home_st())
         {
            if(class_body())
           {
             return true;
           }
         }
         else if(finalToken.get(tokenindex).data.equals("public")||
          finalToken.get(tokenindex).data.equals("}"))                   //fisrt and follow
       {       
       
       return true;
       }
              
     System.out.println("class_b1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }
  
  static boolean Home_st()
  {
     if(finalToken.get(tokenindex).data.equals("public"))
     {
         tokenindex++;
        if(finalToken.get(tokenindex).data.equals("fixed"))
        {
            tokenindex++;
          if(finalToken.get(tokenindex).data.equals("void"))
            {
                tokenindex++;
              if(finalToken.get(tokenindex).data.equals("home"))
                 {
                     tokenindex++;
                        if(finalToken.get(tokenindex).data.equals("<"))
                           {
                              tokenindex++;
                             if(finalToken.get(tokenindex).data.equals("str"))
                               {
                                   tokenindex++;
                                if(finalToken.get(tokenindex).data.equals("["))
                                {
                                    tokenindex++;
                                  if(exp())
                                    {
                                     if(finalToken.get(tokenindex).data.equals("]"))
                                        {
                                            tokenindex++;
                                          if(finalToken.get(tokenindex).type.name().equals("ID"))
                                            {
                                                tokenindex++;
                                            if(finalToken.get(tokenindex).data.equals(">"))
                                                {
                                                    tokenindex++;
                                                if(finalToken.get(tokenindex).data.equals("{"))
                                                  {
                                                      tokenindex++;
                                                    if(M_st_f())
                                                       {
     
                                                         if(finalToken.get(tokenindex).data.equals("}"))
                                                                    {
                                                                        tokenindex++;
                                                                        return true;
                                                                      }     
                                                        }
                                                     }
                                                }
                                            }
     
                                         }
     
                                     }
     
                                 }
                                }
                            }
     
                    }
     
            }
     
        }
     
     }
             
     System.out.println("Home_st Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }   
     
     static boolean class_body()
     {
      
           if(finalToken.get(tokenindex).type.name().equals("ID"))
           {
            tokenindex++;
             if(class_body1())
              {
              return true;
             }
            }
          else if(finalToken.get(tokenindex).data.equals("let"))
           {
             tokenindex++;
             if(finalToken.get(tokenindex).type.name().equals("DT"))
              {
                tokenindex++;
                if(finalToken.get(tokenindex).type.name().equals("ID"))
                 { 
                  tokenindex++;
                   if(select())
                    {
                      if(finalToken.get(tokenindex).type.name().equals("TERMINATOR"))
                         {
                           tokenindex++;
                           if(class_body())
                              {
                                return true;
                               }
               
                          }
              
              }
            
            }
          }
         }
         else if(finalToken.get(tokenindex).data.equals("fixed")||
                finalToken.get(tokenindex).data.equals("last")||
                finalToken.get(tokenindex).type.name().equals("AccessMod")||
                finalToken.get(tokenindex).type.name().equals("DT")||      
                finalToken.get(tokenindex).data.equals("class")||
                finalToken.get(tokenindex).data.equals("void")||
                finalToken.get(tokenindex).type.name().equals("ID"))
                 { 
                     if(ACC_MOD())
                     {
                            if(opt_static())
                                 {
                                if(opt_final())
                                    { 
                                   if(class_body2())
                                      {
                                     return true;
                                         }
                                    }
                                 }
                              }
                 }
           //follow
         else  if(finalToken.get(tokenindex).type.name().equals("ID")||
          finalToken.get(tokenindex).data.equals("let")||
          finalToken.get(tokenindex).type.name().equals("AccessMod")||
          finalToken.get(tokenindex).data.equals("fixed")|
          finalToken.get(tokenindex).data.equals("last")||
          finalToken.get(tokenindex).data.equals("class")||               //first and follow
          finalToken.get(tokenindex).data.equals("void")||
          finalToken.get(tokenindex).type.name().equals("DT")||
          finalToken.get(tokenindex).data.equals("}"))
         {
       return true;
         }
               
     System.out.println("class_body Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }
     
static boolean class_body2()
     { 
          if(finalToken.get(tokenindex).data.equals("class"))
            {
                tokenindex++;
              if(finalToken.get(tokenindex).type.name().equals("ID"))
                {
                    tokenindex++;
                  if(I1())
                    {
                      if(finalToken.get(tokenindex).data.equals("{"))
                      { 
                          tokenindex++;
                          if(class_body())
                          {
                              if(finalToken.get(tokenindex).data.equals("}"))
                               {
                                finalToken.get(tokenindex).data+="EndClass";
                                tokenindex++;
                                  if(class_body())
                                    {
                                      return true;
                                    }
                              }
                          }    
                      }
                    }
                }
            }
     
          else if(finalToken.get(tokenindex).type.name().equals("DT")||
                  finalToken.get(tokenindex).data.equals("void"))
          {
                    if(ret_Type())
                {
                  if(finalToken.get(tokenindex).type.name().equals("ID"))
                    {
                        tokenindex++;
                      if(finalToken.get(tokenindex).data.equals("<"))
                      {
                          tokenindex++;
                        if(def())
                        {
                           if(finalToken.get(tokenindex).data.equals(">"))
                           {
                               tokenindex++;
                            if(finalToken.get(tokenindex).data.equals("{"))
                             {
                                 tokenindex++;
                              if(M_st_f())
                              {
                               if(finalToken.get(tokenindex).data.equals("}"))
                               {
                                   tokenindex++;
                                   if(class_body())
                                      {   
                                          return true;
                                      }    
                                }
                             }
                           }
                        }
                      }

                    }
                 }


           }
          } 
              else if(finalToken.get(tokenindex).data.equals("let"))
           {
             tokenindex++;
             if(finalToken.get(tokenindex).type.name().equals("DT"))
              {
                tokenindex++;
                if(finalToken.get(tokenindex).type.name().equals("ID"))
                 { 
                  tokenindex++;
                   if(Array_yes_no())
                    {
                        if(array_def())
                        {
                            if(class_body())
                                return true;
                        }
                    }
                    
              
              
            
                 }
          }
         }
          
 System.out.println("class_body2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
     }

 static boolean array_def()
 {    
 if(finalToken.get(tokenindex).data.equals("!"))
 {
     tokenindex++;
    return true;
 }
 else if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                        {        
                            tokenindex++;
                                if(finalToken.get(tokenindex).data.equals("old"))
                             {
                                     tokenindex++;
                                    if(DT_ID())
                                    {
                                        if(Bra_Arr())
                                        {
                                           if(finalToken.get(tokenindex).data.equals("!"))
                                                 {
                                                   tokenindex++;
                                                   return true;
                                                 }
                                                
                                         }
            
                                      }
                               }
                        }
                        
 
 
 
 
 
       
 System.out.println("array_def Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
  }
 
 static boolean Array_yes_no()
 {
   if(finalToken.get(tokenindex).data.equals("["))
    {
         tokenindex++;
         if(null_exp())
            {
         if(finalToken.get(tokenindex).data.equals("]"))
            {
       tokenindex++;
      return true;
      }
                                    
            }
     }
   //folow
   else if(finalToken.get(tokenindex).data.equals("!")||
           finalToken.get(tokenindex).type.name().equals("AssgnOp")||
           finalToken.get(tokenindex).type.name().equals("ID"))
   {
   return true;
   }
 
 System.out.println("array_yes_no Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
  }
 static boolean M_st_f()
   {
     
        if(finalToken.get(tokenindex).data.equals("life")||
             finalToken.get(tokenindex).data.equals("go")||
             finalToken.get(tokenindex).data.equals("whether")||
             finalToken.get(tokenindex).data.equals("key")||
             finalToken.get(tokenindex).data.equals("cycle")||
             finalToken.get(tokenindex).data.equals("deliver")||
             finalToken.get(tokenindex).data.equals("drop")||
             finalToken.get(tokenindex).data.equals("resume")||
             finalToken.get(tokenindex).data.equals("let")||
             finalToken.get(tokenindex).type.name().equals("ID")||
             finalToken.get(tokenindex).type.name().equals("INCDEC"))
                {
                  if(S_st_f())
                    {
                        if(M_st_f())
                        {
                         return true;
                        }
                    }      
                     }
        //follow
  else if(finalToken.get(tokenindex).data.equals("trial")||
             finalToken.get(tokenindex).data.equals("set")||
             finalToken.get(tokenindex).data.equals("}"))
     {       
     return true;
    }
             
     System.out.println("M_St_f Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
      return false;
 }
  

   
    static boolean S_st_f()
     {
         if(finalToken.get(tokenindex).data.equals("cycle"))         //for loop
         {
              if(cycle_st())
             return true;
         }
         else if(finalToken.get(tokenindex).data.equals("go")){  //do while         
            if(go_life_st())  
           return true;
         }
         
         else  if(finalToken.get(tokenindex).data.equals("life")){
                                                                       //while
           if(life_st()) 
           return true;
         }
         
         else  if(finalToken.get(tokenindex).data.equals("whether")){
            //if else
           if(whether_Other()) 
           return true;
         }
         
         else  if(finalToken.get(tokenindex).data.equals("key")){
            //switch
           if(Sw_st()) 
           return true;
         }
         
    else
         if(finalToken.get(tokenindex).data.equals("let"))
         {
             tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("DT"))
             {
                 tokenindex++;
               if(finalToken.get(tokenindex).type.name().equals("ID"))
                 {
                     tokenindex++;
                   if(select())
                   {
                    if(finalToken.get(tokenindex).data.equals("!"))
                    {
                      tokenindex++;
                      return true;
                    }
                   }
                 }
             
             }
         }
  else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
         {
             tokenindex++;
               if(finalToken.get(tokenindex).type.name().equals("ID"))
                    {
                        tokenindex++;
                         if(finalToken.get(tokenindex).data.equals("!")){
                         tokenindex++;
                            return true;  
                        }  
                    }
          }  
        else if(finalToken.get(tokenindex).data.equals("drop"))
         {
             tokenindex++;
          if(finalToken.get(tokenindex).data.equals("!"))
          {
                   tokenindex++;       
                 return true;
          }
         }
         
          

 else if(finalToken.get(tokenindex).data.equals("deliver"))
         {
              tokenindex++;
              if(Y())
                    {
                       if(finalToken.get(tokenindex).data.equals("!"))
                       {
                        tokenindex++;
                         return true;  
                         }
                    
                }
          }
 
 else if(finalToken.get(tokenindex).data.equals("resume"))
         {
             tokenindex++;
          if(finalToken.get(tokenindex).data.equals("!"))
          {
                   tokenindex++;       
                 return true;
          }
         }
          
 else
    if(finalToken.get(tokenindex).type.name().equals("DT"))
         {
             tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("ID"))
             {
                 tokenindex++;
               if(Array_yes_no())
                 {
               if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                 {
                     tokenindex++;
                   if(finalToken.get(tokenindex).data.equals("old"))
                   {
                       tokenindex++;
                       
                    if(DT_ID())
                    {
                        if(Bra_Arr())
                       {
                            if(finalToken.get(tokenindex).data.equals("!"))
                            {
                              tokenindex++;
                              return true;
                            }
                           }
                    }    }
                 }
                 }
             }
         }
          
         else if(finalToken.get(tokenindex).type.name().equals("ID"))
         {
             tokenindex++;
            if(S_st_f1())
                {
                return true;
                }
         }
         
      
         
      
                   
         System.out.println("S_st_f Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
         return false;
     }

 static boolean S_st_f1(){
if(finalToken.get(tokenindex).data.equals("["))
                        {
                            tokenindex++;
                            if(S_st_f2())
                                {
                                    return true;
                                }
              
                        }
else if(finalToken.get(tokenindex).data.equals("<"))
                        {
                            tokenindex++;
                            if(null_exp())
                            {

                                if(finalToken.get(tokenindex).data.equals(">"))
                                {
                                    tokenindex++;
                                    if(finalToken.get(tokenindex).data.equals("!"))
                                {
                                    tokenindex++;
                                    return true;
                                }
                                }
              
                        }
                }
else 
     if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
     {
         tokenindex++;
          if(finalToken.get(tokenindex).data.equals("!")){
                         tokenindex++;
                            return true;  
                        }
     }
                

 else
    if(finalToken.get(tokenindex).type.name().equals("ID"))
         {
             tokenindex++;
           if(Array_yes_no())
                 {
               if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                 {
                     tokenindex++;
                   if(finalToken.get(tokenindex).data.equals("old"))
                   {
                       tokenindex++;
                       
                    if(DT_ID())
                    {
                        if(Bra_Arr())
                       {
                            if(finalToken.get(tokenindex).data.equals("!"))
                            {
                              tokenindex++;
                              return true;
                            }
                           }
                    }    }
                 }
                 }
             }
         

 else   if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                 {
                     tokenindex++;                
                    if(S_st_f3())
                    {
                              return true;
                        }
                    }

 else   if(finalToken.get(tokenindex).data.equals("."))
                 {
                     tokenindex++;                
                    if(finalToken.get(tokenindex).type.name().equals("ID"))
                    {
                        tokenindex++;
                          if(select_last2())
                       {
                            if(finalToken.get(tokenindex).data.equals("!"))
                            {
                              tokenindex++;
                              return true;
                            }
                           }
                        }
                    }
//else 
//     if(exp())
//     {
//         
//          if(finalToken.get(tokenindex).data.equals("!")){
//                         tokenindex++;
//                            return true;  
//                        }
//     }
 
// else  if(finalToken.get(tokenindex).data.equals("!"))
//                            {
//                              tokenindex++;
//                              return true;
//                            }
                               
 System.out.println("S_st_f2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
  }

 static boolean S_st_f2(){
     
 if(finalToken.get(tokenindex).data.equals("]"))
 {
                 tokenindex++;
               if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                 {
                     tokenindex++;
                   if(finalToken.get(tokenindex).data.equals("old"))
                   {
                       tokenindex++;
                       
                    if(DT_ID())
                    {
                        if(Bra_Arr())
                       {
                            if(finalToken.get(tokenindex).data.equals("!"))
                            {
                              tokenindex++;
                              return true;
                            }
                           }
                    }    }
                 }
                 }
            
 
 else if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
 {
     if(exp())
     {
         if(finalToken.get(tokenindex).data.equals("]"))
         {
          tokenindex++;
         if(array_init1())
         {
              if(finalToken.get(tokenindex).data.equals("!"))
                            {
                              tokenindex++;
                              return true;
                            }
                 
             }
         }
     }
 }
     
     
     
 System.out.println("S_st_f2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
     }
 
 static boolean S_st_f3(){
     if(finalToken.get(tokenindex).data.equals("old"))
                   {
                       tokenindex++;
                       
                    if(DT_ID())
                    {
                        if(Bra_Arr())
                       {
                            if(finalToken.get(tokenindex).data.equals("!"))
                            {
                              tokenindex++;
                              return true;
                            }
                           }
                    }
                   }
     else if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         
     {
         if(id_init2())
         {
            if(finalToken.get(tokenindex).data.equals("!"))
                {
                                     tokenindex++;
                                         return true;

                }
           }
     
     }
   
 System.out.println("S_st_f3 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
     }
         
 static boolean S2(){
     
     if(finalToken.get(tokenindex).type.name().equals("flo")||
        finalToken.get(tokenindex).type.name().equals("num")||
        finalToken.get(tokenindex).type.name().equals("str")||
        finalToken.get(tokenindex).type.name().equals("ch")||
        finalToken.get(tokenindex).type.name().equals("bo"))
             {
                if(ID_Const())
                {
                  if(S3())  
                        return true;
                }
             }
     
     else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
     {
        tokenindex++;
         if(finalToken.get(tokenindex).type.name().equals("ID"))
         {
             tokenindex++;
             if(N_T())
             {
                 if(id_list())
                 {
                     if(finalToken.get(tokenindex).data.equals("!"))
                     {
                         tokenindex++;
                         return true;
                     }
                 }
             }
         }
     }
     
     if(finalToken.get(tokenindex).data.equals("<")||
                finalToken.get(tokenindex).data.equals("[")||
                finalToken.get(tokenindex).type.name().equals("MulDivMod")||
                finalToken.get(tokenindex).type.name().equals("AddSub")||
                finalToken.get(tokenindex).type.name().equals("OPT")||
                finalToken.get(tokenindex).type.name().equals("RO")||
                finalToken.get(tokenindex).data.equals("ANDB")||
                finalToken.get(tokenindex).data.equals("XOB")||
                finalToken.get(tokenindex).data.equals("ORB")||
                finalToken.get(tokenindex).data.equals("AND")||
                finalToken.get(tokenindex).data.equals("OR"))
                    {
                      if(Bracket())
                      {
                          if(N_T())
                             {
                                if(id_list())
                                  { 
                                         if(finalToken.get(tokenindex).data.equals("!"))
                                                {
                                                    tokenindex++;
                                                    return true;
                                                  }

                                  }
                             }
                      }
                    }
      else if(finalToken.get(tokenindex).type.name().equals("ID"))
         {  
             tokenindex++;   
            if(id_init2())
             {
                 if(finalToken.get(tokenindex).data.equals("!"))
                {
                    tokenindex++;
                    return true;
                  }
              }
         }
    
    
     System.out.println("delever return Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 
  static boolean S3()
  {
        if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
      {
       
             if(N_T())
                           {
                                if(id_list())
                                  { 
                                         if(finalToken.get(tokenindex).data.equals("!"))
                                                {
                                                    tokenindex++;
                                                    return true;
                                                  }

                                  }
                             }
      }
  
     else if(finalToken.get(tokenindex).data.equals("!"))
     {   
     return true;
     }                         
  
     System.out.println("S3  Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
  }
     
 
  static boolean select()
     {
        
        if(finalToken.get(tokenindex).data.equals("["))
        {  
          tokenindex++;
            if(null_exp())
                     {
                       if(finalToken.get(tokenindex).data.equals("]"))
                        {
                            tokenindex++;
                             if(array_init())
                                 {
                                      return true;
                                 }

                         }
                     
                     }
        }
    else   if(finalToken.get(tokenindex).type.name().equals("AssgnOp")||
               finalToken.get(tokenindex).data.equals(","))                       //first of id_init
       {     
        if(id_init())
            {
                return true;
                }
       }
    //follow
   else if(finalToken.get(tokenindex).data.equals("!"))
     {   
     return true;
     }  
     System.out.println("select Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }
  
public static boolean select_last()
{

        if(finalToken.get(tokenindex).data.equals("["))
        {  
          tokenindex++;
            if(exp())
                     {
                       if(finalToken.get(tokenindex).data.equals("]"))
                        {
                            tokenindex++;
                             if(array_init1())
                                 {
                                      return true;
                                 }

                         }
                     
                     }
        }
    else   if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))                       //first of id_init
       {     
        if(id_init1())
            {
                return true;
                }
       }
    else if(finalToken.get(tokenindex).data.equals(".")) //first of S1a
    {
       tokenindex++;
      if(finalToken.get(tokenindex).type.name().equals("ID"))
      {
           tokenindex++;
                if(select_last2())
                return true;
        }
    }    
     
     
     
System.out.println("select_last Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
     
}
    
static boolean select2a()
{ 
           if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))
                        {        
                            tokenindex++;
                                if(finalToken.get(tokenindex).data.equals("old"))
                             {
                                     tokenindex++;
                                    if(DT_ID())
                                    {
                                        if(Bra_Arr())
                                        {
                                            return true;
                                        }
                                    }
            
                                 }
                        }
    //follow
           else  if(finalToken.get(tokenindex).data.equals("!"))
                             {
                             return true;
                             }      
 System.out.println("select2a Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }

static boolean select_last2()
{ 
   if(finalToken.get(tokenindex).type.name().equals("AssgnOp"))                       //first of id_init
       {     
        if(id_init1())
            {
                return true;
                }
       }  
   
   else if(finalToken.get(tokenindex).data.equals("<"))
        {  
          tokenindex++;
            if(exp())
                     {
                       if(finalToken.get(tokenindex).data.equals(">"))
                        {
                            tokenindex++;
                              return true;
                        }
                     }
        }
 System.out.println("select_last2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }

static boolean ID_Const()
     { 
         
     if(finalToken.get(tokenindex).type.name().equals("flo")||
        finalToken.get(tokenindex).type.name().equals("num")||
        finalToken.get(tokenindex).type.name().equals("str")||
        finalToken.get(tokenindex).type.name().equals("ch")||
        finalToken.get(tokenindex).type.name().equals("bo"))
        {
            tokenindex++;
          return true;
        }
               
return false;
    }
    
 static boolean S1()
 {
       if(finalToken.get(tokenindex).type.name().equals("AssgnOp")) 
       {
           tokenindex++;
            if(S2())
            {
                 return true;
           }

            
      }
       
     else if(finalToken.get(tokenindex).data.equals("<"))
     {
         tokenindex++;
               if(null_exp())
               {
                     if(finalToken.get(tokenindex).data.equals(">"))
                        {
                            tokenindex++;
                            if(finalToken.get(tokenindex).data.equals("!"))
                                {
                                    tokenindex++;
                                    return true;
                                }
              
                        }
                }
     }
     
     else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
     {
         tokenindex++;
         return true;
     }
     
     else if(finalToken.get(tokenindex).data.equals("["))
     {
         tokenindex++;
           if(exp())
            {
                if(finalToken.get(tokenindex).data.equals("]"))
                    {
                        tokenindex++;
                        if(S1_Opt())
                        {
                                return true;

                        }

                    }
               
         }
     }
     
   else if(finalToken.get(tokenindex).data.equals(","))
     {
         tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("ID"))
            {
                tokenindex++;
                if(select())
                    {
                         if(finalToken.get(tokenindex).data.equals("!"))
                            {
                                tokenindex++;
                                return true;

                            }
                        }

                    }
               
         }
   
    else if(finalToken.get(tokenindex).type.name().equals("ID"))
       {
           tokenindex++;
           if(Array_yes_no())
           {
             if(S1_())
                 return true;
           }      
       }
         
 else if(finalToken.get(tokenindex).data.equals("."))   //first
  {
      if(S1a())
      {
         if(finalToken.get(tokenindex).data.equals("!"))
                            {
                                tokenindex++;
                                return true;

                            }
  
      }
  }
     System.out.println("S1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 static boolean S1_Opt()
     {   
        if(finalToken.get(tokenindex).type.name().equals("AssgnOp")||   //first
           finalToken.get(tokenindex).data.equals(",")) 
       {  
          if(array_init())
                        {
                            if(finalToken.get(tokenindex).data.equals("!"))
                            {
                                tokenindex++;
                                return true;

                            }
                        
                        }
       }
 else if(finalToken.get(tokenindex).data.equals("."))
  {
      if(S1a())
      {
         if(finalToken.get(tokenindex).data.equals("!"))
                            {
                                tokenindex++;
                                return true;

                            }
                        }  
  }
 System.out.println("S1_Opt Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
return false;
    }
 static boolean S1_()
     {   
         
     if(finalToken.get(tokenindex).type.name().equals("AssgnOp")) 
                 {
                    tokenindex++;
                    if(S2_())
                        return true;
                 }     
 System.out.println("S1_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 static boolean S2_()
     {   
         
               if(finalToken.get(tokenindex).data.equals("old"))
                     {
                          tokenindex++;
                               if(DT_ID())
                                    {
                                       
                                       if(Bra_Arr())
                                                {
                                                     if(finalToken.get(tokenindex).data.equals("!"))
                                                    {
                                                        tokenindex++;
                                                      return true;
                                                            }
                     }  
               }
             }
   else if(finalToken.get(tokenindex).type.name().equals("ID"))
                                    {
                                       tokenindex++;
                                       if(S1a())
                                     {
                                        if(finalToken.get(tokenindex).data.equals("!"))
                                                    {
                                                        tokenindex++;
                                                      return true;
                                                            }
                                        }
                     
               }
 System.out.println("S2_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 static boolean S1a()
     {   
         if(finalToken.get(tokenindex).data.equals("."))
             {
                 tokenindex++;
                 if(finalToken.get(tokenindex).type.name().equals("ID"))
                 {
                    tokenindex++;
                    if(S1b()) 
                    return true;
                 }
             }
         //follow
         else if(finalToken.get(tokenindex).data.equals("!"))
             {
                 return true;
             }
 System.out.println("S1a Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }
 static boolean S1b()
{   
      if(finalToken.get(tokenindex).data.equals("<"))
       {
         tokenindex++;
       
           if(P_L())
            {
                   if(finalToken.get(tokenindex).data.equals(">"))
                        {
                        tokenindex++;
                        if(S1c())
                        return true;
                        }
           }
             
       }
     else if(finalToken.get(tokenindex).data.equals("["))
       {
          tokenindex++;
         
           if(exp())
            {
             if(finalToken.get(tokenindex).data.equals("]"))
                 {
                  tokenindex++;
                  if(in())
                  {
                      if(S1c())
                      return true;
                  }
                }
             }
         
             
       }
     else if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
     {
       if(in())
       {
     
         return true;
       }
     }
     else  if(finalToken.get(tokenindex).data.equals("XOB")||
       finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("MulDivMod")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
       finalToken.get(tokenindex).data.equals("AND")||
       finalToken.get(tokenindex).data.equals("ANDB")||
       finalToken.get(tokenindex).data.equals("OR")||
       finalToken.get(tokenindex).data.equals("ORB"))
         {  
                
            if(N_T())
             {
                return true;
            }
         }
      else if(finalToken.get(tokenindex).data.equals("."))
       {       
        if(S1c())   
        return true; 
       }
         //follow
   else if(finalToken.get(tokenindex).data.equals("!"))
       {       
        return true; 
       }
 System.out.println("S1b Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    }

 static boolean S1c()
     { 
        if(finalToken.get(tokenindex).data.equals("."))  //first
        {
            if(S1a())
            {
                return true;
            }
        } 
         
         //follow
   else if(finalToken.get(tokenindex).data.equals("!"))
       {       
        return true; 
       }
 System.out.println("S1c Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
    } 
     static boolean ret_Type()
     { 
       
      if(finalToken.get(tokenindex).type.name().equals("DT"))
        { 
            tokenindex++;
            return true;
        }
      

      else if(finalToken.get(tokenindex).data.equals("void"))
        {
            tokenindex++;
           return true;   
        }
      System.out.println("ret_type Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
       return false;
     }
     
     static boolean class_body1()
     {
       if(finalToken.get(tokenindex).data.equals("<"))
       {
          tokenindex++;
          if(params())
          {
            if(finalToken.get(tokenindex).data.equals(">"))
             {
              tokenindex++;
                 if(finalToken.get(tokenindex).data.equals("{"))
                 {
                    tokenindex++;
                     if(M_st_f())
                        {
                          if(finalToken.get(tokenindex).data.equals("}"))
                             {
                                  tokenindex++;
                                     if(class_body())
                                     {
                                         return true;
                                     }
                             }
                         }
              
                  }
             }
          }
       
       }
       
 else if(finalToken.get(tokenindex).type.name().equals("AssgnOp")||
        finalToken.get(tokenindex).data.equals(",")||                 //first of select
        finalToken.get(tokenindex).data.equals("["))
{
if(select())
       {
         if(finalToken.get(tokenindex).data.equals("!"))
             {
              tokenindex++;
                 if(class_body())
                      {
                        return true;
                       }
             }
       }
}

System.out.println("class_body1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
       return false;
     
     }
     
  static boolean params()
     {
       if(finalToken.get(tokenindex).data.equals("let")||
        finalToken.get(tokenindex).type.name().equals("ID"))
       {
          if(ex())
            {
             if(Pex())
                {
                return true;
                }
       
            }
     }
       //follow
     else if(finalToken.get(tokenindex).data.equals("let")||
        finalToken.get(tokenindex).data.equals("class")||
        finalToken.get(tokenindex).type.name().equals("ID")||
        finalToken.get(tokenindex).data.equals(">"))
      {
       return true;
       }
    
      System.out.println("params Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }
  
   static boolean Pex()
     {
      
      if(finalToken.get(tokenindex).data.equals(","))
      {
             if(list())
                {
                return true;
                }
     }
      //follow
else if(finalToken.get(tokenindex).data.equals(",")||
        finalToken.get(tokenindex).data.equals(">"))
      {      
       return true;
       }
    
      System.out.println("PEX Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }

  static boolean P1()
  {

       
       if(finalToken.get(tokenindex).data.equals("["))
            {
           tokenindex++;
              if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
                  { 
                    if(exp())
                     {
                          if(finalToken.get(tokenindex).data.equals("]"))
                             {
                                 tokenindex++;
                                         if(P2())
                                         return true;

                        }
                     }
                    }    
           
        }
      else if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
      {
       tokenindex++;
       return true;
      }
      
      else if(finalToken.get(tokenindex).data.equals("<"))
            {
             tokenindex++;
                if(P_L())
                 {
                      if(finalToken.get(tokenindex).data.equals(">"))
                         {
                            tokenindex++;
                            return true;

                    }
                 }

           
        }
      
      else 
         if(finalToken.get(tokenindex).data.equals("."))
        {
           tokenindex++;
            if(finalToken.get(tokenindex).type.name().equals("ID"))
            {
              tokenindex++;
              
              if(Bracket())
              return true;    
          
          }
       }
         //follow
else if(finalToken.get(tokenindex).data.equals("[")||
      finalToken.get(tokenindex).data.equals("<")||
      finalToken.get(tokenindex).data.equals(".")||
      finalToken.get(tokenindex).type.name().equals("INCDEC")||
      finalToken.get(tokenindex).type.name().equals("MulDivMod")||
      finalToken.get(tokenindex).type.name().equals("AddSub")||
      finalToken.get(tokenindex).type.name().equals("OPT")||
      finalToken.get(tokenindex).type.name().equals("RO")||
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
   { 
     return true;
  
   }
   
   System.out.println("P1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
   return false;
  }
  
 static boolean P2()
  {
  
  
      if(finalToken.get(tokenindex).data.equals("."))
       {
         tokenindex++;
          if(finalToken.get(tokenindex).type.name().equals("ID"))
          {
              tokenindex++;
              
             if(Bracket())
            return true;    
          
          }
       }
  //follow
else if(finalToken.get(tokenindex).data.equals(".")||
      finalToken.get(tokenindex).type.name().equals("MulDivMod")||
      finalToken.get(tokenindex).type.name().equals("AddSub")||
      finalToken.get(tokenindex).type.name().equals("OPT")||
      finalToken.get(tokenindex).type.name().equals("RO")||                 //first and follow of P2
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
  {
  
  return true;
  }
  
 System.out.println("P2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
  
  }
  static boolean list()
     {
       if(finalToken.get(tokenindex).data.equals(","))
       {
           tokenindex++;
        if(ex())
        {
          if(params())
          {
            return true;  
          }
        }
       }
       
    System.out.println("list Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }

 static boolean ex(){
     
     if(finalToken.get(tokenindex).data.equals("let"))
         {
             tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("DT"))
             {
                 tokenindex++;
                  if(finalToken.get(tokenindex++).type.name().equals("ID")&& array())
                    {
                    return true;
                     }
             }
            
         }
     else if(finalToken.get(tokenindex).type.name().equals("ID"))
         {
             tokenindex++;
           if(finalToken.get(tokenindex).type.name().equals("ID"))
             {
                 tokenindex++;
                  if(array())
                    {
                    return true;
                     }
             }
            
         }

     System.out.println("ex Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }
     
     
     static boolean array()
     {
       
         if(finalToken.get(tokenindex).data.equals("["))
            {
           tokenindex++;
             
                if(null_exp())
                 {
                      if(finalToken.get(tokenindex).data.equals("]"))
                         {
                         tokenindex++;
                         return true;

                    }
                 }
                    
           
        }
//follow
else if(finalToken.get(tokenindex).data.equals("[")||
          finalToken.get(tokenindex).data.equals(",")||
          finalToken.get(tokenindex).data.equals(".")||
          finalToken.get(tokenindex).data.equals(">")||
          finalToken.get(tokenindex).data.equals("let")||
          finalToken.get(tokenindex).data.equals("class")||
          finalToken.get(tokenindex).type.name().equals("ID"))
        {
         return true;
       }
                  
       System.out.println("array Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
       return false;
      }
     
                                                                     //Method
 static boolean def(){
   
            if(finalToken.get(tokenindex).data.equals("let"))
             {
                 tokenindex++;
                 if(finalToken.get(tokenindex).type.name().equals("DT"))
                 {
                     tokenindex++;
                     if(finalToken.get(tokenindex).type.name().equals("ID"))
                      {
                          tokenindex++;
                          if(select1())
                              {
                                  return true;
                            }
                      }
                 }
             }
            //follow
  else if(finalToken.get(tokenindex).data.equals("let")||
      finalToken.get(tokenindex).data.equals(">"))
    {
    return true;
    }
              
   System.out.println("def Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }

 static boolean select1()
  {
    if(f_list())
    {
    return true;
    }
    
    else if(finalToken.get(tokenindex).data.equals("["))
       {
          tokenindex++;
         
           if(null_exp())
            {
               if(finalToken.get(tokenindex).data.equals("]"))
                 {
                      tokenindex++;
                        if(f_list())
                               {
                                   return true;
                             }
          }
         
             
       }
       }
     System.out.println("select1 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
  }
 
 static boolean null_exp()
 {
  
         if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
           if(exp())
            {
              return true;
            }
         }
          // follow
else if(finalToken.get(tokenindex).data.equals("]")||
        finalToken.get(tokenindex).data.equals(">"))
     { 
    return true;
    }
 
     System.out.println("null exp Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
 }

 static boolean in()
 {
  
         if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
           if(exp())
            {
              return true;
            }
         }
          // follow
else if(finalToken.get(tokenindex).data.equals("!")||
        finalToken.get(tokenindex).data.equals("."))
     { 
    return true;
    }
 
     System.out.println("in Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
 }

 static boolean f_list()
  {
       if(finalToken.get(tokenindex).data.equals(","))
          {
             tokenindex++;
             if(def())
                 return true;
          }
//follow
else if(finalToken.get(tokenindex).data.equals(",")||
       finalToken.get(tokenindex).data.equals(">"))
      {
       
    return true;
     }
               
    System.out.println("f_list Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
   return false;   
  }
 
 
 static boolean exp()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
        if(F())
          {
           if(exp_())
           {
           
             return true;
           }
          
          }
         }  
          //follow
          if(finalToken.get(tokenindex).data.equals(">")||
             finalToken.get(tokenindex).data.equals("]"))
              return true;
    System.out.println("exp Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
  }
     
 static boolean exp_()
  {
     
  
       if(finalToken.get(tokenindex).data.equals("OR"))
       {tokenindex++;
        if(F())
        {
          if(G_())
          {
            
            return true;
          }
        }
       }
//follow
else if(finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
   {
   return true;
   }

  System.out.println("exp_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
  }
     
     
     static boolean F()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(G())
          {
           if(F_())
           {
           
           return true;
           }
          
          }
     }
     System.out.println("F Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
     return false;
     }
     
 static boolean F_()
  {
     
   
       if(finalToken.get(tokenindex).data.equals("AND"))
       {
        tokenindex++;
        if(G())
        {
          if(F_())
          {
            return true;
          }
        }
       }
else if(finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("!"))
   {
   return true;
   }

   System.out.println("F_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
  }
 
      static boolean G()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(H())
          {
           if(G_())
           {
           
           return true;
           }
          
          }
         }
    System.out.println("G Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }
      
      
 static boolean G_()
  {
    
       if(finalToken.get(tokenindex).data.equals("ORB"))
       { 
           tokenindex++;
        if(H())
        {
          if(G_())
          {
            return true;
          }
        }
       }
       //follow
else if(finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
            finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
      {
   return true;
     }
  System.out.println("G_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
  return false;
  }
 
     static boolean H()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(I())
          {
           if(H_())
           {
           
           return true;
           }
          
          }
         }
    System.out.println("H Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
     return false;
     }

  static boolean H_()
  {
     
  
       if(finalToken.get(tokenindex).data.equals("XOB"))
       {
           tokenindex++;
                if(I())
                {
                  if(H_())
                  {
                      return true;
                  }
                }
       }
       //follow
else  if(finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
            finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
   {
   return true;
   }
   System.out.println("H_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
  return false;
  }

  static boolean I()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(J())
          {
           if(I_())
           {
             return true;
           }
          
          }
         }
     System.out.println("I Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
     return false;
     }

  static boolean I_()
  {
     
   
       if(finalToken.get(tokenindex).data.equals("ANDB"))
       {
           tokenindex++;
        if(J())
        {
          if(I_())
          {
            return true;
          }
        }
       }
       //follow
else if(finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
   {
        return true;
   }
   System.out.println("I_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
  return false;
  }
  
  static boolean J()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(M())
          {
           if(J_())
           {
             return true;
           }
          }
         }
       System.out.println("J Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
     return false;
     }

 static boolean J_()
 {
   
       if(finalToken.get(tokenindex).type.name().equals("RO"))
       {
           tokenindex++;
         if(M())
         {
           if(J_())
         {
           return true;
         }   
        }   
      }
        // follow
else if(finalToken.get(tokenindex).type.name().equals("RO")||
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
   {
   return true;
   }
   
 System.out.println("J_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
 return false;
 }

 static boolean M()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(N())
          {
           if(M_())
           {
           
           return true;
           }
          
          }
     }
   System.out.println("M Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }
 
static boolean M_()
 {
    
      if(finalToken.get(tokenindex).type.name().equals("OPT"))
        {  
            tokenindex++;
          if(N())
          {
             if(M_())
            {
              return true;
            }
          }
        }
     // follow
else if(finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
    {
            return true;
    }
 
  System.out.println("M_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
 }

 static boolean N()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(O())
          {
           if(N_())
           {
           return true;
           }
          
          }
         }
    System.out.println("N Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }
 
  static boolean N_()
  {
    
      if(finalToken.get(tokenindex).type.name().equals("AddSub"))
        {
            tokenindex++;
         if(O())
          {
          if(N_())
           {
            return true;
           }
          }
        }
      //follow
else if(finalToken.get(tokenindex).type.name().equals("OPT")||
       finalToken.get(tokenindex).type.name().equals("RO")||
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
    {
    return true;
    }  
 
  System.out.println("N_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
  return false;
    }
  
  
    static boolean O()
     {
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                     //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
       if(P())
          {
           if(O_())
           {
           
           return true;
           }
          
          }
         }
     
    System.out.println("O Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }

 static boolean O_()
     {
     
        if(finalToken.get(tokenindex).type.name().equals("MulDivMod"))
        { 
            tokenindex++;
            if(P())
            {
              if(O_())
              {
                return true;
              }
             }  
        }   
        //follow
else   if(finalToken.get(tokenindex).type.name().equals("MulDivMod")||
         finalToken.get(tokenindex).type.name().equals("AddSub")||
       finalToken.get(tokenindex).type.name().equals("OPT")||
        finalToken.get(tokenindex).type.name().equals("RO")||
      finalToken.get(tokenindex).data.equals("ANDB")||
      finalToken.get(tokenindex).data.equals("XOB")||
      finalToken.get(tokenindex).data.equals("ORB")||
      finalToken.get(tokenindex).data.equals("AND")||
      finalToken.get(tokenindex).data.equals("OR")||
      finalToken.get(tokenindex).data.equals(">")||
      finalToken.get(tokenindex).data.equals(",")||
      finalToken.get(tokenindex).data.equals("]")||
      finalToken.get(tokenindex).data.equals("!"))
       {
            return true;
          
       }
     
    System.out.println("O_ Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }
    
 static boolean P()
     {

         if(finalToken.get(tokenindex).type.name().equals("INCDEC"))
         {
             tokenindex++;
             if(finalToken.get(tokenindex).type.name().equals("ID"))
             {
                 tokenindex++;
                 return true;
             }
         }
         
         else if(finalToken.get(tokenindex).type.name().equals("flo")||
           finalToken.get(tokenindex).type.name().equals("num")||
           finalToken.get(tokenindex).type.name().equals("str")||
           finalToken.get(tokenindex).type.name().equals("ch")||
           finalToken.get(tokenindex).type.name().equals("bo"))
                                 
              {
               if(ID_Const())
                return true;
             }
         else if(finalToken.get(tokenindex).type.name().equals("ID"))
         {
             tokenindex++;
                 if(P1())
                 return true;
         }
          
         
     
    System.out.println("P Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }

 static boolean Bracket()
  {
   
      if(finalToken.get(tokenindex).data.equals("<"))
       {
         tokenindex++;
       
           if(P_L())
            {
                   if(finalToken.get(tokenindex).data.equals(">"))
                        {
                        tokenindex++;
                        return true;
                        }
           }
             
       }
     else if(finalToken.get(tokenindex).data.equals("["))
       {
          tokenindex++;
          
          if(finalToken.get(tokenindex).type.name().equals("INCDEC")||
            finalToken.get(tokenindex).type.name().equals("ID")||                    //first of expression
            finalToken.get(tokenindex).type.name().equals("flo")||
            finalToken.get(tokenindex).type.name().equals("num")||
            finalToken.get(tokenindex).type.name().equals("str")||
            finalToken.get(tokenindex).type.name().equals("ch")||
            finalToken.get(tokenindex).type.name().equals("bo"))
         { 
           if(exp())
            {
             if(finalToken.get(tokenindex).data.equals("]"))
                 {
                  tokenindex++;
                  return true;
                }
             }
         }
             
       }
     //follow
   else if(finalToken.get(tokenindex).data.equals("<")||
       finalToken.get(tokenindex).data.equals("[")||
        finalToken.get(tokenindex).type.name().equals("MulDivMod")||
        finalToken.get(tokenindex).type.name().equals("AddSub")||
        finalToken.get(tokenindex).type.name().equals("OPT")||
        finalToken.get(tokenindex).type.name().equals("RO")||
        finalToken.get(tokenindex).data.equals("ANDB")||
        finalToken.get(tokenindex).data.equals("XOB")||
        finalToken.get(tokenindex).data.equals("ORB")||
        finalToken.get(tokenindex).data.equals("AND")||
        finalToken.get(tokenindex).data.equals("OR")||
        finalToken.get(tokenindex).data.equals(">")||
        finalToken.get(tokenindex).data.equals(",")||
        finalToken.get(tokenindex).data.equals("]")||
        finalToken.get(tokenindex).data.equals("!"))
    {     
    return true;
    }
    
     System.out.println("BRACKET Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    
    return false;
  }
 
 static boolean P_L()
 {
    
                if(exp())
                {
                    if(P_L2())
                    {

                    return true;
                    }
                }
                //follow
   else if(finalToken.get(tokenindex).data.equals(">")||
        finalToken.get(tokenindex).type.name().equals("INCDEC")||
        finalToken.get(tokenindex).type.name().equals("ID")||
        finalToken.get(tokenindex).type.name().equals("flo")||
        finalToken.get(tokenindex).type.name().equals("num")||
        finalToken.get(tokenindex).type.name().equals("str")||
        finalToken.get(tokenindex).type.name().equals("ch")||
        finalToken.get(tokenindex).type.name().equals("bo"))
     {
     
     return true;
     }
 
    System.out.println("P_L Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
  }
 
 static boolean P_L2()
     {
     
               if(finalToken.get(tokenindex).data.equals(","))
             {
             tokenindex++;
             if(exp())
                 {
                 if(P_L2())
                 return true;
                 
                }
             }
      else if(finalToken.get(tokenindex).data.equals(",")||
        finalToken.get(tokenindex).data.equals(">"))
         {        
         return true;
         }
         
         
    System.out.println("P_L2 Statement Error For Token : "+finalToken.get(tokenindex).data+" \n At line :"+finalToken.get(tokenindex).line_no);
    return false;
     }
 
     
}
