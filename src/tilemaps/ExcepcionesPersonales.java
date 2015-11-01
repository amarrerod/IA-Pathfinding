
/**
 *
 * @author Alejandro Marrero Díaz
 * @contact: alu0100825008@ull.edu.es
 * @version 1.0
 * @career: Grado en Ingeniería Informática
 * @College: Universidad de La Laguna
 * @subject: Inteligencia Artificial
 * @course: 3
 * 
 * 
 */


package tilemaps;


//Clase heredada de Exception para manejar mis propias excepciones
public class ExcepcionesPersonales extends Exception{
    
    //Cadena para mostrar el error
    private String codigoError;
    //info adicional
    private String infoAdicional;
    
    
    public ExcepcionesPersonales(){
        super();
    }
    
    public ExcepcionesPersonales(String infoMsg){
        
        super(infoMsg);
        this.infoAdicional = infoMsg;
    }
    
    public ExcepcionesPersonales(Throwable t){
        super(t);
    }
    
    
   /**
    * @return the errorCode
    */
   public String getErrorCode() {
         return codigoError;
   }

   public void setErrorCode(String errorCode) {
         this.codigoError = errorCode;
   }
 
   /**
    * @return the aditionalInfo
    */
   public String getAditionalInfo() {
         return infoAdicional;
   }
 
   /**
    * @param aditionalInfo the aditionalInfo to set
    */
   public void setAditionalInfo(String aditionalInfo) {
         this.infoAdicional = aditionalInfo;
   }

}
