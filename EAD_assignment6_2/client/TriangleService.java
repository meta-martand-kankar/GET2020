/**
 * TriangleService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package soapProject;

public interface TriangleService extends javax.xml.rpc.Service {
    public java.lang.String getTriangleAddress();

    public soapProject.Triangle getTriangle() throws javax.xml.rpc.ServiceException;

    public soapProject.Triangle getTriangle(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
