package Test.java.com.logicbig.example.bean;

import org.primefaces.PrimeFaces;
import org.primefaces.context.PrimeRequestContext;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseStream;
import javax.faces.context.ResponseWriter;
import javax.faces.render.RenderKit;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.Principal;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class Mocks {
    private FacesContext facesContextMock;

    PrimeFaces primeFaces;

    public Mocks() {
        this.facesContextMock = new FacesContext() {
            @Override
            public Application getApplication() {
                return null;
            }

            @Override
            public Iterator<String> getClientIdsWithMessages() {
                return null;
            }

            @Override
            public ExternalContext getExternalContext() {
                return new ExternalContext(){
                    @Override
                    public void dispatch(String s) throws IOException {

                    }

                    @Override
                    public String encodeActionURL(String s) {
                        return null;
                    }

                    @Override
                    public String encodeNamespace(String s) {
                        return null;
                    }

                    @Override
                    public String encodeResourceURL(String s) {
                        return null;
                    }

                    @Override
                    public Map<String, Object> getApplicationMap() {
                        return null;
                    }

                    @Override
                    public String getAuthType() {
                        return null;
                    }

                    @Override
                    public Object getContext() {
                        return null;
                    }

                    @Override
                    public String getInitParameter(String s) {
                        return null;
                    }

                    @Override
                    public Map getInitParameterMap() {
                        return null;
                    }

                    @Override
                    public String getRemoteUser() {
                        return null;
                    }

                    @Override
                    public Object getRequest() {
                        return null;
                    }

                    @Override
                    public String getRequestContextPath() {
                        return null;
                    }

                    @Override
                    public Map<String, Object> getRequestCookieMap() {
                        return null;
                    }

                    @Override
                    public Map<String, String> getRequestHeaderMap() {
                        return null;
                    }

                    @Override
                    public Map<String, String[]> getRequestHeaderValuesMap() {
                        return null;
                    }

                    @Override
                    public Locale getRequestLocale() {
                        return null;
                    }

                    @Override
                    public Iterator<Locale> getRequestLocales() {
                        return null;
                    }

                    @Override
                    public Map<String, Object> getRequestMap() {
                        return null;
                    }

                    @Override
                    public Map<String, String> getRequestParameterMap() {
                        return null;
                    }

                    @Override
                    public Iterator<String> getRequestParameterNames() {
                        return null;
                    }

                    @Override
                    public Map<String, String[]> getRequestParameterValuesMap() {
                        return null;
                    }

                    @Override
                    public String getRequestPathInfo() {
                        return null;
                    }

                    @Override
                    public String getRequestServletPath() {
                        return null;
                    }

                    @Override
                    public URL getResource(String s) throws MalformedURLException {
                        return null;
                    }

                    @Override
                    public InputStream getResourceAsStream(String s) {
                        return null;
                    }

                    @Override
                    public Set<String> getResourcePaths(String s) {
                        return null;
                    }

                    @Override
                    public Object getResponse() {
                        return null;
                    }

                    @Override
                    public Object getSession(boolean b) {
                        return null;
                    }

                    @Override
                    public Map<String, Object> getSessionMap() {
                        return null;
                    }

                    @Override
                    public Principal getUserPrincipal() {
                        return null;
                    }

                    @Override
                    public boolean isUserInRole(String s) {
                        return false;
                    }

                    @Override
                    public void log(String s) {

                    }

                    @Override
                    public void log(String s, Throwable throwable) {

                    }

                    @Override
                    public void redirect(String s) throws IOException {

                    }
                };
            }

            @Override
            public FacesMessage.Severity getMaximumSeverity() {
                return null;
            }

            @Override
            public Iterator<FacesMessage> getMessages() {
                return null;
            }

            @Override
            public Iterator<FacesMessage> getMessages(String s) {
                return null;
            }

            @Override
            public RenderKit getRenderKit() {
                return null;
            }

            @Override
            public boolean getRenderResponse() {
                return false;
            }

            @Override
            public boolean getResponseComplete() {
                return false;
            }

            @Override
            public ResponseStream getResponseStream() {
                return null;
            }

            @Override
            public void setResponseStream(ResponseStream responseStream) {

            }

            @Override
            public ResponseWriter getResponseWriter() {
                return null;
            }

            @Override
            public void setResponseWriter(ResponseWriter responseWriter) {

            }

            @Override
            public UIViewRoot getViewRoot() {
                return new UIViewRoot();
            }

            @Override
            public void setViewRoot(UIViewRoot uiViewRoot) {

            }

            @Override
            public void addMessage(String s, FacesMessage facesMessage) {

            }

            @Override
            public void release() {

            }

            @Override
            public void renderResponse() {

            }

            @Override
            public void responseComplete() {

            }
        };

        this.primeFaces = new PrimeFaces() {
            @Override
            public Ajax ajax() {
                return new Ajax(){
                    @Override
                    public void update(String... expressions) {

                    }
                };
            }

            @Override
            public PrimeRequestContext getRequestContext(){
                return new PrimeRequestContext(facesContextMock);
            }




        };
    }
}
