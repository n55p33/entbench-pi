package org.apache.batik.gvt;
public class Marker {
    protected double orient;
    protected org.apache.batik.gvt.GraphicsNode markerNode;
    protected java.awt.geom.Point2D ref;
    public Marker(org.apache.batik.gvt.GraphicsNode markerNode, java.awt.geom.Point2D ref,
                  double orient) { super();
                                   if (markerNode == null) { throw new java.lang.IllegalArgumentException(
                                                               );
                                   }
                                   if (ref == null) { throw new java.lang.IllegalArgumentException(
                                                        );
                                   }
                                   this.markerNode =
                                     markerNode;
                                   this.ref = ref;
                                   this.orient = orient;
    }
    public java.awt.geom.Point2D getRef() { return (java.awt.geom.Point2D)
                                                     ref.
                                                     clone(
                                                       );
    }
    public double getOrient() { return orient; }
    public org.apache.batik.gvt.GraphicsNode getMarkerNode() {
        return markerNode;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028784000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JVsUClEgDOF2JViUwhnejJP6skFUiHQj226qLL0KMVXWKkK5pWZnkFqVeSAt" +
       "uQjvMYsV06nD4zrmmP1+oi7NanfdKfgr0au16/0pHwC38OUypsdBLbJ7eNre" +
       "uLhDTyy3026a635BNNquloRID9N52W4hZZkAyLEqy6NWGvP+WtXWs0p5GSDt" +
       "qNmmZ4sE9ZlBY90OBRUO50MYHlWwqCJNZnpMDgf6yA8khh63BvNhSxApQvbl" +
       "RnPQqEuEX1tK8rozQCg+4R1zVUX4sSRGMQmj+LKR8oWauibqRLUgrxUPQStJ" +
       "sythLacH9ypOaVWrGpbea8dlpCd2anjSmPRVdorY8NhvuZXNSJrGOkV1CojY" +
       "CLBpCDMy6qCrZsPigBJitY53wgJiLooFulSHy0ubt+OxV2XKaTnOQjYVaVMk" +
       "8MGQJsobtl5ZFOiiX2hbuMI3ZtMKuuo0ESrC4X7EzMJi16SNBBYJYWMv6JWk" +
       "ESk1FcV4qOIoMR73TIdv4gyHIRMeWfjNWofGWhNaXzMjpMPMeC7ozHVY7ifp" +
       "GlfZTlsYxGXCaQeVDpIEFapIiDCpebNuN46EBW5PGRVvrqQp6znpsjUpdIaN" +
       "GlBBopllsdwdhYQkcrNlopoblwkXxU5CGirGilMing6ZjlOsy2oR5dEmMu9Y" +
       "vY3IuL4dC8wEXXVbBDIoOv1yHKyWBd3VCT0o00p5Zg48UoInhZrc1zuVIiyT" +
       "rFNSNlGRQEYagSEbuFAjJ8t6OVWsPrvhpFFpM+ql0XAcg0XmtHAdonoLETsW" +
       "gtZ42wrMKm6nlanJdUwtscckIvV1AaNTeiRVyjNkjKRNgS1ibdSt9QsAJods" +
       "1Q8EYU30u310iM4cbbApxnbTD4ebOomy1emESwtRG7ZRc7GWeFu1MW0sq15M" +
       "yamS8BMzrZeStSlvGik7GSHzQQWlo8Em4sQu0WqCs4WDMYKGz6eVKtp1DMw1" +
       "Eq8O1yJPgmeFeXdeW3tmq9hhYLLDlNiBhAc0NxgV/WGVLNQmfWKgNKb0cpBM" +
       "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");
}
