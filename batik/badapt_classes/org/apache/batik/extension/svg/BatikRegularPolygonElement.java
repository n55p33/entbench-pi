package org.apache.batik.extension.svg;
public class BatikRegularPolygonElement extends org.apache.batik.extension.GraphicsExtensionElement implements org.apache.batik.extension.svg.BatikExtConstants {
    protected BatikRegularPolygonElement() { super(); }
    public BatikRegularPolygonElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
    }
    public java.lang.String getLocalName() { return BATIK_EXT_REGULAR_POLYGON_TAG;
    }
    public java.lang.String getNamespaceURI() { return BATIK_EXT_NAMESPACE_URI;
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.extension.svg.BatikRegularPolygonElement(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "YoXvXPORzVp4Eq5zJeYOImzXi3YjNvd4Dttk2Dko7SPe2laHYWRf4y7E4/+l" +
       "UKcLZbAGSzg1mDewtirbyHopMZgD1AJr7tIlGzOLkDZdx3X2YzMkhj6HTcqR" +
       "fOC/ND92DBrOwPIw1Xpshn2riF+TV1x476hVHA4xT+Ut/0mCHS5z/5yAPrui" +
       "VgEpit/Lp85fkvc/u9Up83ori7JhOHO88It//CRx8Xdvz5HvW7lu3KOyKaaG" +
       "hG3AJSty84iorYP88EHnud//oL8wdCdpGfv6bpN48f9KUGJj7TQbFeXNU39c" +
       "duC+4tE7yLArI+aMsvz2yPNv71knnYuLg4STXKsOIJWTBsKGhUVNBicmDdXE" +
       "ng7hpnf7ntOLjtIHz3bXc7bXCdBKp/NDsdbUOnFSrDN2DBtA/fYClNm6RNVR" +
       "V5t9QVzJn0Rcif5spSmwSt/p6rPzzk1Ra2odde06Y9PYQGx0gSnQChZEKzs4" +
       "no5Y48T/wBoLcGwZPClXpdRtrLGpuqKoNbWOxqfqjH0Nm5OcNGtsehRC1Ad1" +
       "BLLpbZKAbH9AWOahTwR/4Xxe+7SBOXJp1eWHc2CXXrzU1bLk0sFfCnTyD9Xt" +
       "gDN5W1VDYRoO2SbDZHlFqNzulAyGeJ2Borc+ZnMAzCknp33DmfNNkL32HEBd" +
       "/zs867xr1PAsThrFO0x3gZO2gA7StfMRJnkKZAIS/Hza8HZsWx019pjUKCqS" +
       "Nez1uHYux6rToNjjRbfbY39KuHJGNBc3Wx7y2s7dFhz0Lu0bffDmZ551KndJ" +
       "pbOzyGV+hjQ7hwgfvVfX5Obxatq74VbnS61r464L9zgCB6GzPOTfg5CcDXSn" +
       "ZZGa1ur3S9v3L+98/aenm96DBHqYxCgnCw6H7pWcSxQojG1Im4czQeIM3YyK" +
       "Yntgw1Mz923O/+U3omojWBXASb02fVa69twDPz+39DIU5fPTpBFyPStPkjbF" +
       "2jWjjTNpypwkHQrsGYgIXBSqpkmLrSknbJaWM6QTPZ9ivSXs4pqzw+/Fcx8n" +
       "a6out+Y4LUOFO83MId3WZJHPINMGPRVXbl4CtA0jMiHo8bdyYbXuWWnX17t+" +
       "eLa3YTdEb4U6YfbNlp3zk2v4Fi7Itt0OMv4LfjF4/okPbjp24JuT3pR7I7XK" +
       "v5IyjLIz1pDNjBiGR9u23q2xX8DmShn7OYltdHsRvWJOmYd/Xxbrf1d8YvPK" +
       "vwFaIXJ2kRcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
