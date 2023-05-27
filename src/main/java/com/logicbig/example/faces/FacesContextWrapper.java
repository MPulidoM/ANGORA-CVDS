package com.logicbig.example.faces;

import javax.faces.context.FacesContext;

public class FacesContextWrapper {
    public FacesContext getCurrentInstance() {
        return FacesContext.getCurrentInstance();
    }
}
