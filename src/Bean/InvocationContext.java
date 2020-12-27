package Bean;

import javax.ejb.EJB;
import javax.ejb.EJBContext;

public interface InvocationContext {
    public Object getBean();
    public java.lang.reflect.Method getMethod();
    public Object[] getParameters();
    public void setParameters(Object params);
    public EJBContext getEjbContext();
    public java.util.Map getContextData();
    public Object proceed() throws Exception;
}
