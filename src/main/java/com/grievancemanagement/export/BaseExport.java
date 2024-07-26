package com.grievancemanagement.export;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

public abstract class BaseExport {

	protected abstract String getCommaSeperatedData();
	
	protected abstract String getFileName();
	
	public void download() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext externalContext = facesContext.getExternalContext();
		
		externalContext.responseReset();
		externalContext.setResponseContentType("text/csv");
        externalContext.setResponseHeader("Content-Disposition", String.format("attachment; filename=\"%s.csv\"", getFileName()));
        try {
            externalContext.getResponseOutputStream().write(getCommaSeperatedData().getBytes());
            facesContext.responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
}
