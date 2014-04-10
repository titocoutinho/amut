package desenv.manager.auxiliar;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.primefaces.context.RequestContext;

import desenv.modelo.auxiliar.Boleano;

public class AbstractBean {
	
	
	

	public AbstractBean() {
		super();
	}

	private static final String KEEP_DIALOG_OPENED = "KEEP_DIALOG_OPENED";

	

	protected void displayErrorMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendErrorMessageToUser(message);
	}
	
	protected void displayInfoMessageToUser(String message) {
		JSFMessageUtil messageUtil = new JSFMessageUtil();
		messageUtil.sendInfoMessageToUser(message);
	}
	
	protected void closeDialog(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, false);
	}
	
	protected void keepDialogOpen(){
		getRequestContext().addCallbackParam(KEEP_DIALOG_OPENED, true);
	}
	
	protected RequestContext getRequestContext(){
		return RequestContext.getCurrentInstance();
	}
	
	public List<SelectItem> getBoleano() {
        List<SelectItem> siMaritialStatus = new ArrayList<SelectItem>();
        for (Boleano ms : Boleano.values()) {
            siMaritialStatus.add(new SelectItem(ms.name(), ms.toString().replace("_", " ")));
        }
        return siMaritialStatus;
    }
	
	
	

	
	
	
	

}
