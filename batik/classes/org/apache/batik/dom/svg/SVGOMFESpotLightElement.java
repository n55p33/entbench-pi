package org.apache.batik.dom.svg;
public class SVGOMFESpotLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFESpotLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Z_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_Z_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      z;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtX;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtY;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtZ;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularExponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      limitingConeAngle;
    protected SVGOMFESpotLightElement() {
        super(
          );
    }
    public SVGOMFESpotLightElement(java.lang.String prefix,
                                   org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedNumber(
            null,
            SVG_X_ATTRIBUTE,
            0.0F);
        y =
          createLiveAnimatedNumber(
            null,
            SVG_Y_ATTRIBUTE,
            0.0F);
        z =
          createLiveAnimatedNumber(
            null,
            SVG_Z_ATTRIBUTE,
            0.0F);
        pointsAtX =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_X_ATTRIBUTE,
            0.0F);
        pointsAtY =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_Y_ATTRIBUTE,
            0.0F);
        pointsAtZ =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_Z_ATTRIBUTE,
            0.0F);
        specularExponent =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE,
            1.0F);
        limitingConeAngle =
          createLiveAnimatedNumber(
            null,
            SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_SPOT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getZ() {
        return z;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtX() {
        return pointsAtX;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtY() {
        return pointsAtY;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtZ() {
        return pointsAtZ;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularExponent() {
        return specularExponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getLimitingConeAngle() {
        return limitingConeAngle;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFESpotLightElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1afWwcxRWfO8ffdvyRzybYSRyHEifcJQVKkUOK4w/icP5o" +
       "HKLgkDh7e3PnxXu7m905+xxqCogogSJEQ/gIgog/QtNGkKC2UT/4UKqUAkqp" +
       "BElbSMVXqwooRRC1pVWB0vdm92739m43ugjX0s6tZ96bee83b957M7NPfEhK" +
       "DZ00U4WF2KRGjVC3wgYF3aCxTlkwjE1QNyI+WCL8fft7/VcFSdkwmTkqGH2i" +
       "YNAeicoxY5g0SYrBBEWkRj+lMeQY1KlB9XGBSaoyTOZIRm9SkyVRYn1qjCLB" +
       "ZkGPkAaBMV2KphjttTpgpCkCkoS5JOEOd3N7hNSIqjZpk893kHc6WpAyaY9l" +
       "MFIfuUkYF8IpJsnhiGSw9rROVmiqPJmQVRaiaRa6Sb7CgmBD5Io8CFqeqvvk" +
       "03tH6zkEswRFURlXz9hIDVUep7EIqbNru2WaNHaSW0hJhFQ7iBlpjWQGDcOg" +
       "YRg0o61NBdLXUiWV7FS5OizTU5kmokCMLMntRBN0IWl1M8hlhh4qmKU7ZwZt" +
       "F2e1NbXMU/H+FeH9D26v/1EJqRsmdZIyhOKIIASDQYYBUJqMUt3oiMVobJg0" +
       "KDDZQ1SXBFnaZc10oyElFIGlYPozsGBlSqM6H9PGCuYRdNNTIlP1rHpxblDW" +
       "f6VxWUiArnNtXU0Ne7AeFKySQDA9LoDdWSwzxiQlxsgiN0dWx9brgABYy5OU" +
       "jarZoWYoAlSQRtNEZEFJhIfA9JQEkJaqYIA6Iws8O0WsNUEcExJ0BC3SRTdo" +
       "NgFVJQcCWRiZ4ybjPcEsLXDNkmN+Puxfc8/NynolSAIgc4yKMspfDUzNLqaN" +
       "NE51CuvAZKxpizwgzH12b5AQIJ7jIjZpfvrtc9esbD7xokmzsADNQPQmKrIR" +
       "8VB05isXdS6/qgTFqNBUQ8LJz9Gcr7JBq6U9rYGHmZvtERtDmcYTG399w61H" +
       "6AdBUtVLykRVTiXBjhpENalJMtWvpQrVBUZjvaSSKrFO3t5LyuE9IinUrB2I" +
       "xw3KeskMmVeVqfx/gCgOXSBEVfAuKXE1864JbJS/pzVCSDk8pBWeZcT8W4oF" +
       "I2J4VE3SsCAKiqSo4UFdRf2NMHicKGA7Go6C1Y+FDTWlgwmGVT0RFsAORqnV" +
       "EFOTYWMcTGnztQN9Pd1DmsoiUmKUoW9Ad4vGpv1/hkmjtrMmAgGYiIvcbkCG" +
       "FbRelWNUHxH3p9Z1nzs6cso0MVwWFk6MrIKRQ+bIIT5yCEYOwcghj5FJIMAH" +
       "nI0SmLMOczYGqx/cb83yoW0bduxtKQFz0yZmAOBBIG3JCUOdtovI+PUR8Vhj" +
       "7a4lb64+GSQzIqRREFlKkDGqdOgJ8FfimLWka6IQoOw4sdgRJzDA6apIY+Cm" +
       "vOKF1UuFOk51rGdktqOHTBTD9Rr2jiEF5ScnHpq4bfN3VgVJMDc04JCl4NWQ" +
       "fRAdetZxt7pdQqF+6/a898mxB6ZU2znkxJpMiMzjRB1a3CbhhmdEbFssHB95" +
       "dqqVw14JzpsJsNjALza7x8jxPe0ZP466VIDCcVVPCjI2ZTCuYqO6OmHXcFtt" +
       "4O+zwSxmEmtlytbq5L/YOlfDcp5p22hnLi14nLh6SHv0td++fxmHOxNS6hy5" +
       "wBBl7Q43hp01cofVYJvtJp1SoHvjocH77v9wz1Zus0CxtNCArVh2gvuCKQSY" +
       "d7+48/W33jx0Jpi18wAjlZquMljkNJbO6olNpNZHTxjwYlsk8IQy9ICG03q9" +
       "AiYqxSUhKlNcW5/VLVt9/G/31JumIENNxpJWnr8Du/4r68itp7b/q5l3ExAx" +
       "Etuw2WSme59l99yh68IkypG+7dWmAy8Ij0KgAOdsSLso97eEw0D4vF3B9V/F" +
       "y8tdbVdiscxw2n/uEnNkTCPivWc+rt388XPnuLS5KZdzuvsErd20MCwuTkP3" +
       "89z+ab1gjALd5Sf6b6yXT3wKPQ5DjyJ4X2NABzeZzjEOi7q0/OwvT87d8UoJ" +
       "CfaQKlkVYj0CX2ekEgycGqPgYdPaN68xJ3eiAop6rirJUz6vAgFeVHjqupMa" +
       "42Dv+tm8n6w5fPBNbmga76Ipa1zV2E0Lj2rmHyu8iLD8Ki/bsLg0Y7BlWioK" +
       "+bvLWqt8OnTNa9By8fj/fEjGuTKYaIXMRCvTsKxgkOmIgtcCNLtUMYWRhUvb" +
       "62M6A1is403fwKLTlLz9AuHHig7NbFjIKysxkOYEK74Zsv3lkdNX/u7w9x6Y" +
       "MNOp5d5BwsU3/z8DcvT2P/07z4x5eCiQ6rn4h8NPPLKgc+0HnN/208jdms4P" +
       "/hDrbN6vHUn+M9hS9nyQlA+TetHafGwW5BR6v2FIuI3MjgQ2KDntucmzmSm2" +
       "Z+PQRe4Y4RjWHSHspAPekRrfa11BYQ7Oyxp42izza3Pbc4Dwl62FTTqIryGw" +
       "a4NvcVx2PdunY0ZmpZPyJl2QWK/Cg1l2dsB8L8kzX75gu1RYPrA3jdE07I/R" +
       "y9rLjdvnjeezz+tz4yFmq12WhF0eqsdN1bFYkR9lvLgha0tntFnpn/F1KFIS" +
       "U/P+FG4LXRolLkCjXkumXg+NVF+NvLhBo0l8GXNJqF2AhP3WGP0eEo77SujF" +
       "DRLuKiThRJESroRnyBpjyEPCKV8JvbgxZVFhu210sC2FJL3lAiTdYo21xUPS" +
       "O3wl9eJ2SHpDIUl3X4Ck26yxtnlI+l1fSb24HZIOF5L07iIlvQyeqDVW1EPS" +
       "fb6SenFDvDY0KqZkQe9Oa6oCca+QwPcVKTCG2IQ1ZMJD4AO+AntxM9IgS0nI" +
       "5xXIxBXaoSRMj+uW+GEfidP2yN3ZkflfGbGOCDK/jpEdKUIgJ6eZuEx0es/8" +
       "3TJmok1eZz/83OrQ7fsPxgYeX22mFI255yndSir55O8//03oobdfKrB5r2Sq" +
       "dqlMx6nskLAWh8xJYvr4sZidEbwxc9+ff96aWFfMZhvrms+zncb/F4ESbd55" +
       "kVuUF27/64JNa0d3FLFvXuSC093lD/ueeOnai8V9QX4GaKYqeWeHuUztuQlK" +
       "lU5ZSlc25aQpS3PNfBU8U5a5TLnN3DZILxv3YvXJfn/s03Yci6OMLJQUWB94" +
       "dEs7ZDkijdPsabth+CasgzpfWuPW2WJ4qvGtsUfee9K0Snd26iKme/ff9UXo" +
       "nv2mhZqntUvzDkydPOaJLRe93gTnC/gLwPNffFAvrMBfyEE7rWPDxdlzQ03D" +
       "hbXETyw+RM+7x6ae/sHUnqCF0/cZmTGuSjHbWRz7MvYQvP5IdpZrsG0FPLut" +
       "Wd7tYyAF9mXlmi6Ng5quBLbap0cf2zjl0/YyFr9iZL5tN7lGg+2/sNF6fhrQ" +
       "asS2ZngOWLodOM9y6s6FpcqH1Uf113zazmJxmpGaBGURVRTkfss5bLChODMN" +
       "UDRh2xJ4HrP0eax4KLxYfdT9i0/bu1i8DcsGoNiSiX1LCsS+3H2DjdM704nT" +
       "YUvZw8Xj5MXqg8U/fNo+weIjEyeeor5vQ/DxdEJw1NLjaPEQeLF6qxkI+LSV" +
       "YOVnJgTDLgg+ny4IlsNz3NLjePEQeLH6qDnTp60ei0rTcQw6t1Y2FIGq6YTi" +
       "GUufZ4qHwovVR92FPm1NWMzNhcK1MALzphOKk5Y+J4uHwovVR91LfNowugeW" +
       "5kLhWiCB1umCAhPVU5Y+p4qHwovVR12f0/8Anv4HVjEyC6AYKrD7dCCyeroQ" +
       "WQ3PaUut08Uj4sXqo/U6n7YuLK5mZDbmGoW2tw5I1k4DJLOwbQE8Zy29zp4H" +
       "kgK7GS9WH7UHfNq+hcUGyIMVOtEP+8pM2lHvTDuyDRyZ66YBGYyu5Cp43rHU" +
       "e6d4ZLxYfbTf7tO2A4sbIF8HY3GfVmdPoKM2LMNfyg0JI/M8PgbAK6z5eR8g" +
       "mR/NiEcP1lXMO3j9H/gxQ/bDlpoIqYinZNl5IeB4L9N0Gpc4sjXm9YDGNR8F" +
       "pb0OrhkpgRLFDyRM6jFYT4WogRJKJ6VimZWTkpFS/uuk28lIlU3HSJn54iRh" +
       "0DuQ4GtKy9hs4auv7Gl75pjIzKsWOmeC501zzjeBWRbnxTXu7vnXY5kjkpT5" +
       "/diIeOzghv6bz339cfPiXJSFXfyMujpCys07fN4pHrMs8ewt01fZ+uWfznyq" +
       "cllmc91gCmwvioW25ZIO2NlqaC4LXFfKRmv2Zvn1Q2uee3lv2atBEthKAgJE" +
       "ia35109pLaWTpq0R+4TL8fUhv+tuX/7w5NqV8Y/+yC9NCZ7Z5VzruelHxDOH" +
       "t53eN/9Qc5BU95JSCW90+L1Y16SykYrj+jCplYzuNIgIvcA2uZdUpBRpZ4r2" +
       "xiJkJlq2gNedHBcLztpsLX52wUhL/nlI/scqVbI6QfV1akqJYTe1EVJt15gz" +
       "4zqpSmmai8GuyU7l7HzdR8SuO+ueubexpAdWZ446zu7LjVQ0ewrm/NKNV5jH" +
       "N1g8ncZ5BvMfifRpWubkpqLUvLEO7DFpsJ6RQJt1j42eJmAeeSDRXXwN3clf" +
       "sbj7f6oAPd7EKgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DNgo4Dc78F1PnuG7Tr7NPSL/vVtB/ot7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8l+89eT/6pyyH+bJX+7IF28W//sRr/91K3h9Zc/rK7ec14XL55S9LU9u3/GS" +
       "TvK6cMdb5fUMuL625/W1W8/r4XPKHsmTK7vJODj+ovoYvwduBb/f3PP7zVvP" +
       "78lzyp7Ok3ee5HfKLi88fiv4fX3P7+u3nt+PnVMG58l7T/I7bZ/PvFV+eYDw" +
       "6p7fq7eeH3VO2XN5gifQQ4CfcMY7+GM0ibdKEwXX7+9p/v6tp9k8p6yVJ88n" +
       "0NvzNfGsl/nHeNbeAs+H8szHwPXtPc9v3yzP1433LgzPKRPyhANBk6eveV/T" +
       "D5bHK8eXx8OCgm7vLdDNFwyIAtef7On+ya2n+8I5ZfkRjAsSCOvAsJ4+rXZ4" +
       "Am12xPUnbuqoYwI9coNz7PmJ3Eev++/M7v8e6ldevv+uR14W/7A4yn34n4zL" +
       "HHSXkTrO8UOAx+4vBZFuWIUyLu+OBAYFwwUgd6Mzawl0G0hz3BfMnbQNLPws" +
       "aSAJ0uOS3t4mjksm0B3F93G5MIHuPpJLoEu7m+MiCWgdiOS3aXBgcGefVT08" +
       "aHfwLLl79nz0uHUVocyDrzdQh1WOHxPPHyGLPz4dPO6lu78+vaB+9eUO/+HX" +
       "yC/sjqmrjrwtDrHdxUF37k7MF43mj4xP3rC1g7YutZ/5wX2/fvk9B4+39+0A" +
       "H1n6MWzvOvtAeNMNkuII9/afPvKP3//Fl79THJ75f+ieM+GRNgAA");
}
