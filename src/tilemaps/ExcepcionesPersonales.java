
package tilemaps;

/**
 *
 * @author Alejandro Marrero
 */
public class ExcepcionesPersonales extends Exception{
    
    private String codigoError;
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
