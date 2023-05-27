package com.logicbig.example.faces;

import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;

public class PrimeFacesWrapper {
    public PrimeFaces current() {
        return PrimeFaces.current();
    }

    public PrimeRequestContext getRequestContext(){
        return PrimeRequestContext.getCurrentInstance(null);
    }
}
