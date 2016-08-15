package org.apache.batik.dom.svg;
public class SVGOMClipPathElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGClipPathElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_CLIP_PATH_UNITS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[] CLIP_PATH_UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      clipPathUnits;
    protected SVGOMClipPathElement() { super(); }
    public SVGOMClipPathElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() { clipPathUnits =
                                                createLiveAnimatedEnumeration(
                                                  null,
                                                  SVG_CLIP_PATH_UNITS_ATTRIBUTE,
                                                  CLIP_PATH_UNITS_VALUES,
                                                  (short)
                                                    1);
    }
    public java.lang.String getLocalName() { return SVG_CLIP_PATH_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getClipPathUnits() {
        return clipPathUnits;
    }
    protected org.w3c.dom.Node newNode() { return new org.apache.batik.dom.svg.SVGOMClipPathElement(
                                             );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ose9wOquBnIX4wVBaci19syuwTOgRXtkCjDbMeZaPN1Q+hLfkDhLEp0xPukp" +
       "bAeuN4delHstDF5P6LhhEjnbWXbs9c7qW3WFk3K7xkbMDm+zdoAgUntSmTZH" +
       "qaRyczvV5pOqnTOZOnV3bG2w6XM5XPH0zSYAEuAXwmY41cSRxPZGWJCsPZdb" +
       "rb2KyYcCtbU4PBys1/bUMZjaQmTbzQU1DEazdMJbnoBLNO8JFXENb+Eu1R0K" +
       "Q3KwTilNcIdrWK7TymAIS7lI8oTQktqr1q7uY0h92RngqdOtreWpKU4F4BvO" +
       "pLkebujNlOzbzoCK6QbtLMdCM6jLclXtdoNGUOlbC6Jjy0EitYUqQjnd1TaU" +
       "WI5YVHfzpNutUybb2brrKjdCYbW7nFfmO5kMRKK93OCEQPRQIPvdylvTrUnH" +
       "Wyy0sIIx415VpvJ1l+apHhO0nUFF3nYXWNweAMNnetNJrPPCwDY4Ux9zmMCt" +
       "k4Cemfg0QRW3ys2VJMUjZtKNqg1pOFExC8yCSHRl2d36sUrXJ06+mM/4VjM2" +
       "1luW9LhVVWpLbbe99WZ8uMSBP9PoPMTUUSZhO2E15hE0JIyRHAFbJLVeOKfX" +
       "WUzx6xUy6+uC4qWdznI32WgcFbS0Kb/ytxnM9RedXV9YWCt/6W372a4zGEiR" +
       "hXdHXJ1xG2hlx7UHSo5wzSYCR5SCN6zRbEyuep04x1Kk23cjHE+JxazKxHMy" +
       "aHnAnmZ5vNC3i65CyoRT7daVcc+oT1aYv1DqU7e+NvWesF6rVE/S4p6o56RY" +
       "01RPrgdq02uiY4LpyVanqZAxju34TYNZw2y1P9IVK0BqWDoiw7o27sxdFE4V" +
       "aYzA7HaO+Cs/XJCzdncuq5Fu93ZTq+FLTgLQcjsjfXLTn0atml31FTwfKtOl" +
       "WTMDrTbAnM5wMF+3O114vPIjFHXx6ai/yHK/2cm7PD331lmuejs5H82wra1N" +
       "qBax6kd+e2CaREBky6o/XiZkaAcuPeyykmcrKDLZoDliVmAV6ZGyaWZ5Ys81" +
       "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" +
       "HfLn/fD5+8ML6v5zkfzHBLoG+CNvder+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/lt4/C2O2k+k8Xs/gDQeKQqLW8HkUBrJD9/D/+SCujeL5I+Bm/h6xgXa8d3U" +
       "tdNCOK4o2f3WD8Bu8TYPwsH38iG7L//w2f3zC+q+VyR/BhwZKP/8ffnxHfji" +
       "hNf/9bYeWyTQO2/1jK54EPToTS92969M1S+9dvWe97wm/M7+rvnoJei9DHSP" +
       "kbru6TcIp/JXwkg37JKje/cvEspL3ktXAGe3uzNKoDtAWhB96a5963sBvbdq" +
       "DVqC9HTL+w8N4nTLBLqr/H+63dUEuu+kXQJd2WdON3kYjA6aFNlHwiNrq1x0" +
       "0dWL5NCy1fhotb10asE8NLBSVw+/la6Ou5x+q1bcqJaPro9uP9P9s+sb6pdf" +
       "o7mX32z8/P6tnOrKeV6Mcg8D3b1/tnd8g/rUbUc7GutK//nvPvhL9z53FAA8" +
       "uCf4xNhP0fbkrV+ldb0wKd+R5f/0Pb/8oX/w2u+XF1z/D8T2qEENLwAA");
}
