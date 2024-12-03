package CAP1.ENUM;

/**
 *  THE ENUM CA USE AN ABSTRACT METHOD, BUT IS MANDATORY THAT ALL ENUM USE THIS METHOD
 */
public enum ExamplePersonal {
     REACT{
       public String timeDuration(){
           return "Lunes de 10 a 1";
       }
     }, JAVA{
         public String timeDuration(){
             return "MIERCOLES DE 10 A 1";
         }
    }, AWS{
         public String timeDuration(){
             return "Martes de 10 a 1";
         }
    };

    public abstract String timeDuration();
}
